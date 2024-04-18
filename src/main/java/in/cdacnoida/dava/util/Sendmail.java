package in.cdacnoida.dava.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.cdacnoida.dava.model.RegistrationForm;
import in.cdacnoida.dava.service.DavaServices;

@Component
public class Sendmail {

	@Autowired
	private ConfigProperties configProp;

	public void sendMail(String user, String subject, String content) {
		transferToMailServer(user, subject, content);
	}

	public void sendEmailToUser(String username, String verificationLink) {

		String strSubject = "Registration on IVEDA portal";
		/*
		 * String EmailContent=
		 * "Dear Sir/Ma'am,<br><br> Thank you for confirming your registration at  NVS portal.<br><br> Your User Id is as given Below :"
		 * + "<br> User Id: "+loginDetailsBean.getUserEmail()+" <br> Password: "
		 * +loginDetailsBean.getPassword()
		 * +" <br>Please note - Your registration is confirmed now. You can login into the system.<br>"
		 * + " To visit your account, please visit this URL: "+
		 * "<br>  <br><br><br> With Regards<br><br> NVS Portal Team.";
		 */

		String EmailContent = "<b>Email Verification link :</b>" + verificationLink;

		transferToMailServer(username, strSubject, EmailContent);

		// davaServices.addDataToEmailMst("Email Verification link", request);

		// davaServices.addEmailDetailsToDb(userId, username, strSubject, EmailContent,
		// request);

	}

	public boolean sendMailToUser(String email, String subject, String content) {
		boolean result = false;
		try {
			transferToMailServer(email, subject, content);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public void transferToMailServer(String userName, String strSubject, String emailContent) {
		String from = configProp.getEmailFromAddress().trim();
		String emailSubjectTxt = strSubject;
		String emailMsgTxt = emailContent;
		String emailcc = configProp.getEmailAdvAddress();
//        postMail(userName,emailSubjectTxt,""+emailMsgTxt,from,emailcc);
		postMail(userName, emailSubjectTxt, "" + emailMsgTxt, from);

	}

	/*
	 * public void postMail(String recipients, String subject, String message,
	 * String from, String strccMail)
	 */

	public void postMail(String recipients, String subject, String message, String from) {
		String hostname = configProp.getSmtp_host_name().trim();
		Integer smtpPort = configProp.getPort();
		String SMTP_HOST_NAME = hostname;

		try {

			// Set the host smtp address
			Properties props = new Properties();
			props.put("mail.smtp.host", SMTP_HOST_NAME);
			props.put("mail.smtp.port", smtpPort); // TLS Port
			props.put("mail.smtp.sendpartial", "true");
			props.put("mail.smtp.auth", "true");
			// SecurityManager security = System.getSecurityManager();
			// System.out.println("Security Manager" + security);
			// session.getInstance(props,auth)
			Authenticator auth = new SMTPAuthenticator();
			// Session session = Session.getDefaultInstance(props, auth);
			Session session = Session.getInstance(props, auth);

			// Session session= Session.getInstance(props);
			// session.setDebug(debug);

			// create a message
			Message msg = new MimeMessage(session);

			// set the from and to address
			InternetAddress addressFrom = new InternetAddress(from);
			msg.setFrom(addressFrom);

			InternetAddress addressTo = new InternetAddress(recipients);
			// InternetAddress addresscc = new InternetAddress(strccMail);
			msg.setRecipient(Message.RecipientType.TO, addressTo);
			// msg.setRecipient(Message.RecipientType.CC, addresscc);

			// Setting the Subject and Content Type
			msg.setSubject(subject);
			msg.setContent(message, "text/html;charset=utf-8");
			System.out.println("all set");
			Transport.send(msg);
			System.out.println("mail sent");

		} catch (Exception e) {
			System.out.println("in exception");
			e.printStackTrace();
		}
	}

	private class SMTPAuthenticator extends javax.mail.Authenticator {
		// String bundlprop="in.cdacnoida.msips.gl.adaptor.ResourceBundleFilePath";
		String username = "";
		String password = "";

		public PasswordAuthentication getPasswordAuthentication() {
			String username1 = configProp.getSmtp_auth_user();
			String password1 = configProp.getSmtp_auth_pass();
			username = username1.trim();

			password = password1.trim();

			return new PasswordAuthentication(username, password);
		}
	}
}
