package in.cdacnoida.dava.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import in.cdacnoida.dava.transactions.BOOTCrsTransactions;
import in.cdacnoida.dava.transactions.BOOTSentEmailDetailsRepository;

@Component
public class BOOTSendMail {

	private BOOTSqlQueries queries = new BOOTSqlQueries();

	private BOOTAccessPaths bOOTAccessPaths;

	@Autowired
	public BOOTSendMail(BOOTAccessPaths bOOTAccessPaths) {
		this.bOOTAccessPaths = bOOTAccessPaths;
	}

	@Autowired
	BOOTCrsTransactions bOOTCrsTransactions;

	@Autowired
	BOOTSentEmailDetailsRepository bOOTSentEmailDetailsRepository;

	@Value("${ADMIN}")
	private String admin;

	@Value("${PROJECT_URL_FOR}")
	private String PROJECT_URL_FOR;

	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	String currentDate = formatter.format(new Date());

	public void sendGemReportEmail(String DownloadId) {
		String latestDownloadId = DownloadId;
		// bOOTCRSGemReportHistoryRepository.getLatestValidDownloadId();
		StringBuffer strUrl = new StringBuffer();
		strUrl.append("Dear Sir,<br/><br/>");
		strUrl.append("Please find the below url to get the latest Report.<br/><br/>");
		strUrl.append(
				PROJECT_URL_FOR + "GEMReport.do?hmode=DGMXXXVVXXXFile&id=" + DataEncoder.encode(latestDownloadId));
		strUrl.append("<br/><br/>");
		ArrayList<String> al = new ArrayList<String>();
		al.add(admin);
		// al.add("helpdesk@bis.gov.in");
		// al.add("its@bis.gov.in");
		for (int i = 0; i < al.size(); i++) {
			try {
				//TransferToMailServer(al.get(i), "Report from BIS : ", strUrl.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void TransferToMailServer(String mail, String subj, String emailMsgTxt) throws MessagingException {
		// String hostname = bOOTAccessPaths.getSMTP_HOST_NAME();
		// String username1 = bOOTAccessPaths.getSMTP_AUTH_USER();
		// String password1 = bOOTAccessPaths.getSMTP_AUTH_PWD();
		String from = bOOTAccessPaths.getEmailFromAddress();
		String ccMail = bOOTAccessPaths.getEmailCC();
		String emailSubjectTxt = subj;
		emailMsgTxt = emailMsgTxt
				+ "<br/>For details information on BIS, consult the e-BIS Portal (www.manakonline. in) <br/> Please use BIS CARE APP for verification of ISI-marked goods and hallmarked gold jewellery.";
		postMail(mail, emailSubjectTxt, emailMsgTxt, from, ccMail);
	}

	public void postMail(String recipients, String subject, String message, String from, String strccMail)
			throws MessagingException {
		Integer count = bOOTSentEmailDetailsRepository.getNextMailCounter();
		bOOTSentEmailDetailsRepository.insertEmailDetails(recipients, subject, message, count);
		String SMTP_HOST_NAME = bOOTAccessPaths.getSMTP_HOST_NAME();
		String SMTP_PORT = bOOTAccessPaths.getSMTP_PORT();
		Properties props = new Properties();
		boolean debug = true;
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", SMTP_PORT);
		// SecurityManager security = System.getSecurityManager();
		Authenticator auth = new BOOTSendMail.SMTPAuthenticator();
		Session session = Session.getInstance(props, auth);
		session.setDebug(debug);
		Message msg = new MimeMessage(session);
		InternetAddress addressFrom = new InternetAddress(from);
		msg.setFrom(addressFrom);
		InternetAddress addressTo = new InternetAddress(recipients);
		InternetAddress addresscc = new InternetAddress(strccMail);
		msg.setRecipient(Message.RecipientType.TO, addressTo);
		msg.setRecipient(Message.RecipientType.CC, addresscc);
		msg.setSubject(subject);
		msg.setContent(message, "text/html");
		Transport.send(msg);
		bOOTSentEmailDetailsRepository.updateEmailDetails(count);
	}
	
	public String sendMailForDeferment() throws Exception {

		// To get mail content from database
		String queryOne = queries.getMailContent();
		String queryTwo = queryOne.replace("?", "90");
		List<Object[]> mailContent = bOOTCrsTransactions.SelectDataFromQuery(queryTwo);
		List<HashMap<String, Object>> mailListContent = new ArrayList<>();
		for (Object[] row : mailContent) {
			HashMap<String, Object> result = new HashMap<>();
			result.put("subject", row[0]);
			result.put("content", row[1]);
			mailListContent.add(result);
		}
		List<HashMap<String, Object>> receivedMailContent = mailListContent;
		String subject = null, content = null;
		if (receivedMailContent.size() > 0) {
			for (int index = 0; index < receivedMailContent.size(); index++) {
				HashMap<String, Object> record = receivedMailContent.get(index);
				subject = (String) record.get("subject");
				content = (String) record.get("content");
			}
		}
		// System.out.println(subject);
		// System.out.println(content);
		// email details end

		String query = queries.getMailToSendQueryDefered();
		List<Object[]> results = bOOTCrsTransactions.SelectDataFromQuery(query);
		List<HashMap<String, Object>> dataList = new ArrayList<>();
		List<Integer> sequenceNumbers = new ArrayList<>();
		for (Object[] row : results) {
			HashMap<String, Object> result = new HashMap<>();
			result.put("reg_number", row[0]);
			result.put("application_id", row[1]);
			sequenceNumbers.add((Integer) row[2]);
			dataList.add(result);
		}

		List<HashMap<String, Object>> received = dataList;
		List<Object[]> filteredList = new ArrayList<>();
		if (received.size() > 0) {
			for (int index = 0; index < received.size(); index++) {
				HashMap<String, Object> record = received.get(index);
				String regNumber = (String) record.get("reg_number");
				String applicationId = (String) record.get("application_id");
				//select from log_schedular_deferment_lapsed_dtl
				String queryThree = queries.getListToAddMailToSendQueryDefered(regNumber, applicationId);
				filteredList.addAll(bOOTCrsTransactions.SelectParameterisedDataFromQuery(queryThree, regNumber, applicationId, null, null, null));
			}
		}
//		Sequence numbers
//		for (Integer i : sequenceNumbers) {
//			System.out.println("Sequence Number : " + i);
//		}

		List<HashMap<String, Object>> dataListFiltered = new ArrayList<>();
		for (Object[] row : filteredList) {
			HashMap<String, Object> temp = new HashMap<>();
			List<String> mailListToSend = new ArrayList<>();
			temp.put("<Date>", currentDate);
			temp.put("<CRS No.>", row[0]);
			temp.put("<R-no.>", row[1]);
			temp.put("<Valid upto date>", row[3]);
			temp.put("<IS No>", row[6]);
			temp.put("<Product Name>", row[7]);
			temp.put("<Name of manufacturing unit>", row[14]);
			temp.put("<Address of manufacturing unit>", row[15]);
			temp.put("<3 months from valid upto date>", row[18]);
			mailListToSend.add(row[9].toString());
			mailListToSend.add(row[10].toString());
			mailListToSend.add(row[11].toString());
			mailListToSend.add(row[12].toString());
			mailListToSend.add(row[19].toString());
			String replacedContent = content.replace("<Date>", currentDate).replace("<CRS No.>", row[0].toString())
					.replace("<R-no.>", row[1].toString()).replace("<Valid upto date>", row[3].toString())
					.replace("<IS No>", row[6].toString()).replace("<Product Name>", row[7].toString())
					.replace("<Name of manufacturing unit>", row[14].toString())
					.replace("<3 months from valid upto date>", row[18].toString())
					.replace("<Address of manufacturing unit>", row[15].toString());
			temp.put("content", replacedContent);
			String seqNumber = row[20].toString();
			for (int i = 0; i < mailListToSend.size(); i++) {
				String mailSendingTo = mailListToSend.get(i);
				System.out.println(LocalDateTime.now() + "   mail sending to " + mailSendingTo);
				try {
					//TransferToMailServer(mailSendingTo, subject, replacedContent);
					//update log_schedular_deferment_lapsed_dtl
					String updateQuery = queries.getLogSchedulerDefermentLapsedMail();
					bOOTCrsTransactions.UpdateFourRecordsParameterisedDataFromQuery(updateQuery, replacedContent,row[1].toString(), row[0].toString(), seqNumber, null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			dataListFiltered.add(temp);
		}
		return "Success";
	}	

	public String sendMailForLapsed() throws Exception {

		// To get mail content from database
		String queryOne = queries.getMailContent();
		String queryTwo = queryOne.replace("?", "92");
		List<Object[]> mailContent = bOOTCrsTransactions.SelectDataFromQuery(queryTwo);
		List<HashMap<String, Object>> mailListContent = new ArrayList<>();
		for (Object[] row : mailContent) {
			HashMap<String, Object> result = new HashMap<>();
			result.put("subject", row[0]);
			result.put("content", row[1]);
			mailListContent.add(result);
		}
		List<HashMap<String, Object>> receivedMailContent = mailListContent;
		String subject = null, content = null;
		if (receivedMailContent.size() > 0) {
			for (int index = 0; index < receivedMailContent.size(); index++) {
				HashMap<String, Object> record = receivedMailContent.get(index);
				subject = (String) record.get("subject");
				content = (String) record.get("content");
			}
		}
		// System.out.println(subject);
		// System.out.println(content);
		// email details end

		String query = queries.getMailToSendQueryLapsed();
		List<Object[]> results = bOOTCrsTransactions.SelectDataFromQuery(query);
		List<HashMap<String, Object>> dataList = new ArrayList<>();
		List<Integer> sequenceNumbers = new ArrayList<>();
		for (Object[] row : results) {
			HashMap<String, Object> result = new HashMap<>();
			result.put("reg_number", row[0]);
			result.put("application_id", row[1]);
			sequenceNumbers.add((Integer) row[2]);
			dataList.add(result);
		}

		List<HashMap<String, Object>> received = dataList;
		List<Object[]> filteredList = new ArrayList<>();
		if (received.size() > 0) {
			for (int index = 0; index < received.size(); index++) {
				HashMap<String, Object> record = received.get(index);
				String regNumber = (String) record.get("reg_number");
				String applicationId = (String) record.get("application_id");
				String queryThree = queries.getListToAddMailToSendQueryLapsed(regNumber, applicationId);
				filteredList.addAll(bOOTCrsTransactions.SelectParameterisedDataFromQuery(queryThree, regNumber,
						applicationId, null, null, null));
			}
		}
//		Sequence numbers
//		for (Integer i : sequenceNumbers) {
//			System.out.println("Sequence Number : " + i);
//		}

		List<HashMap<String, Object>> dataListFiltered = new ArrayList<>();
		for (Object[] row : filteredList) {
			HashMap<String, Object> temp = new HashMap<>();
			List<String> mailListToSend = new ArrayList<>();
			temp.put("<Date>", currentDate);
			temp.put("<CRS No.>", row[0]);
			temp.put("<R-no.>", row[1]);
			temp.put("<Valid upto date>", row[3]);
			temp.put("<IS No>", row[6]);
			temp.put("<Product Name>", row[7]);
			temp.put("<Name of manufacturing unit>", row[14]);
			temp.put("<Address of manufacturing unit>", row[15]);
			mailListToSend.add(row[9].toString());
			mailListToSend.add(row[10].toString());
			mailListToSend.add(row[11].toString());
			mailListToSend.add(row[12].toString());
			mailListToSend.add(row[19].toString());
			String replacedContent = content.replace("<Date>", currentDate).replace("<CRS No.>", row[0].toString())
					.replace("<R-no.>", row[1].toString()).replace("<Valid upto date>", row[3].toString())
					.replace("<IS No>", row[6].toString()).replace("<Product Name>", row[7].toString())
					.replace("<Name of manufacturing unit>", row[14].toString())
					.replace("<Address of manufacturing unit>", row[15].toString());
			temp.put("content", replacedContent);
			String seqNumber = row[20].toString();			
			for (int i = 0; i < mailListToSend.size(); i++) {
				String mailSendingTo = mailListToSend.get(i);
				System.out.println(LocalDateTime.now() + "   mail sending to " + mailSendingTo);
				try {
					//TransferToMailServer(mailSendingTo, subject, replacedContent);
					String updateQuery = queries.getLogSchedulerDefermentLapsedMail();
					bOOTCrsTransactions.UpdateFourRecordsParameterisedDataFromQuery(updateQuery, replacedContent,
							row[1].toString(), row[0].toString(), seqNumber, null);
				} catch (Exception e) {

				}
			}
			dataListFiltered.add(temp);
		}
		return "Success";
	}

	private class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			String username = bOOTAccessPaths.getSMTP_AUTH_USER();
			String password = bOOTAccessPaths.getSMTP_AUTH_PWD();
			return new PasswordAuthentication(username, password);
		}
	}

	public boolean checkGazettedHoliday() throws Exception {
		boolean status = true;
		String query = queries.getGazettedHoliday();
		List<Object[]> result = bOOTCrsTransactions.SelectDataFromQuery(query);
		if (result.size() > 0) {
			status = false;
		}
		return status;
	}
}
