package in.cdacnoida.dava.serviceimpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdacnoida.dava.service.BOOTModelWithdrawalActionService;
import in.cdacnoida.dava.sqls.ModelWithdrawalQueries;
import in.cdacnoida.dava.transactions.BOOTCrsTransactions;
import in.cdacnoida.dava.util.BOOTMailManager;
import in.cdacnoida.dava.util.BOOTSendMail;

@Service
public class BOOTModelWithdrawalActionImpl implements BOOTModelWithdrawalActionService {

	private ModelWithdrawalQueries queries = new ModelWithdrawalQueries();

	@Autowired
	private BOOTCrsTransactions bOOTCrsTransactions;
	
	@Autowired
	private BOOTMailManager bOOTMailManager;
	
	@Autowired
	private BOOTSendMail bOOTSendMail;

	@Override
	@Transactional
	public List<HashMap<String, Object>> queryForNewRecordsData() {
		// select creit_model_withdrawal_master
		List<String> results = bOOTCrsTransactions.SelectDataFromQueryAsList(queries.getQueryForNewRecords());
		List<HashMap<String, Object>> dataList = new ArrayList<>();
		for (String row : results) {
			HashMap<String, Object> temp = new HashMap<>();
			temp.put("model_withdrawal_ref_id", row);
			dataList.add(temp);
		}
		@SuppressWarnings("unused")
		boolean queryChanges = false;
		// Data operations 
		try {
			List<HashMap<String, Object>> received = dataList;
			if (received.size() > 0) {
				for (int index = 0; index < received.size(); index++) {
					HashMap<String, Object> record = received.get(index);
					String model_withdrawal_ref_id = (String) record.get("model_withdrawal_ref_id");
					List<String> application_ids = bOOTCrsTransactions.SelectDataFromQueryAsList(queries.getQryAppID().replace("?", model_withdrawal_ref_id));
					String application_id = application_ids.get(0);
					@SuppressWarnings("unused")
					String strVersionID = "A1";
					//update creit_model_withdrawal_tracker
					//bOOTCrsTransactions.UpdateDataFromQuery(queries.getTrackerUpdate().replace("1?", application_id).replace("2?", strVersionID).replace("3?", model_withdrawal_ref_id));
					
					//insert into creit_model_withdrawal_tracker
					//bOOTCrsTransactions.UpdateDataFromQuery(queries.getTrackerInsert().replace("1?", application_id).replace("2?", strVersionID).replace("3?", model_withdrawal_ref_id));
					
					//update creit_model_withdrawal_master
					//bOOTCrsTransactions.UpdateDataFromQuery(queries.getTrackerUpdateFive().replace("1?", application_id).replace("2?", strVersionID).replace("3?", model_withdrawal_ref_id));
					
					//update creit_model_withdrawal_tracker
					//bOOTCrsTransactions.UpdateDataFromQuery(queries.getTrackerUpdateSix().replace("1?", model_withdrawal_ref_id).replace("2?", application_id).replace("3?", model_withdrawal_ref_id));
					
					//update creit_model_withdrawal_tracker
					//bOOTCrsTransactions.UpdateDataFromQuery(queries.getTrackerUpdateSeven().replace("1?", application_id).replace("2?", model_withdrawal_ref_id));
					
					//update creit_model_withdrawal_models
					//bOOTCrsTransactions.UpdateDataFromQuery(queries.getTrackerUpdateEight().replace("1?", model_withdrawal_ref_id));
					
					//update creit_model_withdrawal_tracker
					//bOOTCrsTransactions.UpdateDataFromQuery(queries.getTrackerUpdateNine().replace("1?", application_id).replace("2?", application_id).replace("3?", model_withdrawal_ref_id));
					@SuppressWarnings("unused")
					ArrayList<String> list_Mail =new ArrayList<String>();
					list_Mail = bOOTMailManager.getMailContent("modelWithdrawaGranting");
					List<Object[]> receivedData = bOOTCrsTransactions.SelectDataFromQuery(queries.getTrackerUpdateTen().replace("1?", application_id).replace("2?", model_withdrawal_ref_id));
					String mailBody = list_Mail.get(1);
					for (Object[] row : receivedData) {
						mailBody=mailBody.replaceFirst("#1",row[0].toString());
                        mailBody=mailBody.replaceFirst("#2",row[1].toString());
                        mailBody=mailBody.replaceFirst("#3",row[2].toString());
                        mailBody=mailBody.replaceFirst("#4",row[3].toString());
                        mailBody=mailBody.replaceFirst("#5",row[4].toString());
                        mailBody=mailBody.replaceFirst("#6",row[1].toString());
                        mailBody=mailBody.replaceFirst("#7",row[2].toString());
                        mailBody=mailBody.replaceFirst("#8",row[5].toString());	
                        //update creit_model_withdrawal_master
                        bOOTCrsTransactions.UpdateDataFromQuery(queries.getTrackerUpdateEleven()
                        		.replace("1?", mailBody)
                        		.replace("2?", row[6].toString())
                        		.replace("3?", list_Mail.get(0))
                        		.replace("4?", application_id)
                        		.replace("5?", model_withdrawal_ref_id));
                        //send mail to user
            			try {
            				//bOOTSendMail.TransferToMailServer(row[6].toString(), list_Mail.get(0), mailBody);
            				System.out.println(LocalDateTime.now()+"  sending email to "+row[6].toString()+" is success");
            				//update creit_model_withdrawal_master
            				bOOTCrsTransactions.UpdateDataFromQuery(queries.getTrackerUpdateTwelfth().replace("1?", application_id).replace("2?", model_withdrawal_ref_id));
            			} catch (Exception e) {
            				System.out.println(LocalDateTime.now()+"  sending email to "+row[6].toString()+" is failed");
            				e.printStackTrace();
            			}
					}
				}
			}
			queryChanges = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<String> list_Mail =new ArrayList<String>();
		list_Mail = bOOTMailManager.getMailContent("modelWithdrawaGranting");
		String mailBody = list_Mail.get(1);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++ "+mailBody);
		return dataList;
	}

}
