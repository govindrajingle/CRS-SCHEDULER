package in.cdacnoida.dava.serviceimpl;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdacnoida.dava.daoservice.BOOTCreitRegistrationMasterDaoService;
import in.cdacnoida.dava.transactions.BOOTCrsTransactions;
import in.cdacnoida.dava.util.BOOTSendMail;

@Service
public class BOOTCreitRegistrationMasterDaoServiceImpl implements BOOTCreitRegistrationMasterDaoService {

	@Autowired
	private BOOTCrsTransactions bOOTCrsTransactions;

	@Autowired
	BOOTSendMail bOOTSendMail;

	@Override
	public List<HashMap<String, Object>> updateLapsingService() {
		List<Object[]> results = bOOTCrsTransactions.getQueryData();
		List<HashMap<String, Object>> crmList = new ArrayList<>();
		for (Object[] row : results) {
			HashMap<String, Object> crm = new HashMap<>();
			crm.put("application_id", row[0]);
			crm.put("valid_up_to", convertToLocalDateTime((Timestamp) row[1]));
			crm.put("reg_date", convertToLocalDateTime((Timestamp) row[2]));
			crm.put("reg_number", row[3]);
			crm.put("str_status", row[4]);
			crmList.add(crm);
		}
		String new_status = "LP";
		List<HashMap<String, Object>> receivedInfo = crmList;
		if (receivedInfo.size() > 0) {
			for (int index = 0; index < receivedInfo.size(); index++) {
				HashMap<String, Object> record = receivedInfo.get(index);
				String app_id = (String) record.get("application_id");
				String str_status = (String) record.get("str_status");
				String reg_number = (String) record.get("reg_number");
				try {
					bOOTCrsTransactions.updateQueryData(app_id, reg_number, str_status);
					bOOTCrsTransactions.updateQueryNewStatus(app_id, reg_number, new_status, str_status);
					bOOTCrsTransactions.LogSchedularInsertQueryInsert(app_id, reg_number, new_status, str_status);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		try {
			DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
			if (dayOfWeek.getValue() >= DayOfWeek.MONDAY.getValue()
					&& dayOfWeek.getValue() <= DayOfWeek.FRIDAY.getValue()) {
				boolean check = false;
				check = bOOTSendMail.checkGazettedHoliday();
				if (check) {
					// call the send mail
					System.out.println(LocalDateTime.now()+"   Lapsed record email service called");
					String result = bOOTSendMail.sendMailForLapsed();
					System.out.println(LocalDateTime.now()+"   Mail status "+result);
				}
			} else
				System.out.println("no mails should be delivered because of weekend or public holiday >>Lapsing!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return crmList;
	}

	@Override
	public List<HashMap<String, Object>> DefermentQueryDataService() {
		List<Object[]> results = bOOTCrsTransactions.DefermentQueryData();
		List<HashMap<String, Object>> dfmList = new ArrayList<>();
		for (Object[] row : results) {
			HashMap<String, Object> dfm = new HashMap<>();
			dfm.put("application_id", row[0]);
			dfm.put("valid_upto", convertToLocalDateTime((Timestamp) row[1]));
			dfm.put("reg_date", convertToLocalDateTime((Timestamp) row[2]));
			dfm.put("reg_number", row[3]);
			dfm.put("str_status", row[4]);
			dfmList.add(dfm);
		}
		String new_status = "DF";
		List<HashMap<String, Object>> receivedInfo = dfmList;
		if (receivedInfo.size() > 0) {
			for (int index = 0; index < receivedInfo.size(); index++) {
				HashMap<String, Object> record = receivedInfo.get(index);
				String app_id = (String) record.get("application_id");
				String str_status = (String) record.get("str_status");
				String reg_number = (String) record.get("reg_number");
				try {
					//insert into creit_registration_history
					bOOTCrsTransactions.updateQueryData(app_id, reg_number, str_status);
					//update creit_registration_master
					bOOTCrsTransactions.updateQueryNewStatus(app_id, reg_number, new_status, str_status);
					//insert into log_schedular_deferment_lapsed_dtl
					bOOTCrsTransactions.LogSchedularInsertQueryInsert(app_id, reg_number, new_status, str_status);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		try {
			DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
			if (dayOfWeek.getValue() >= DayOfWeek.MONDAY.getValue()
					&& dayOfWeek.getValue() <= DayOfWeek.FRIDAY.getValue()) {
				boolean check = false;
				check = bOOTSendMail.checkGazettedHoliday();
				if (check) {
					// call the send mail
					System.out.println(LocalDateTime.now()+"   Deferred record email service called");
					String result = bOOTSendMail.sendMailForDeferment();
					System.out.println(LocalDateTime.now()+"   Mail status "+result);					
				}
			} else
				System.out.println("no mails should be delivered because of weekend or public holiday >>Deffered!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dfmList;
	}

	private LocalDateTime convertToLocalDateTime(Timestamp timestamp) {
		LocalDateTime dateTime = timestamp.toLocalDateTime();
		if (dateTime.getHour() >= 12) {
			dateTime = dateTime.plusDays(1);
		}
		return dateTime;
	}

}
