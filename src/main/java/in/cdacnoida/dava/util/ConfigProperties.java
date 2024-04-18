package in.cdacnoida.dava.util;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:configprops.properties")
@ConfigurationProperties(prefix = "mail")
public class ConfigProperties {
	
		private String hostName;
	    private int port;
	    private String from;
		private String registrationconfirm;
		private String registrationcontent;
		private String smtp_host_name;
		private String smtp_auth_user;
		private String smtp_auth_pass;
		private String emailFromAddress ;
		private String emailCC;
		private String emailAdvAddress ;
		private String secretId;
		private String dburl;
		private String dbusername;
		private String dbpassword;
		
		private Map<String,String> emailContent=new HashedMap<>();
		
	    public String getHostName() {
			return hostName;
		}
		public void setHostName(String hostName) {
			this.hostName = hostName;
		}
		public int getPort() {
			return port;
		}
		public void setPort(int port) {
			this.port = port;
		}
		public String getFrom() {
			return from;
		}
		public void setFrom(String from) {
			this.from = from;
		}
		public String getRegistrationconfirm() {
			return registrationconfirm;
		}
		public void setRegistrationconfirm(String registrationconfirm) {
			this.registrationconfirm = registrationconfirm;
		}
		public String getRegistrationcontent() {
			return registrationcontent;
		}
		public void setRegistrationcontent(String registrationcontent) {
			this.registrationcontent = registrationcontent;
		}
		public String getSmtp_host_name() {
			return smtp_host_name;
		}
		public void setSmtp_host_name(String smtp_host_name) {
			this.smtp_host_name = smtp_host_name;
		}
		public String getSmtp_auth_user() {
			return smtp_auth_user;
		}
		public void setSmtp_auth_user(String smtp_auth_user) {
			this.smtp_auth_user = smtp_auth_user;
		}
		public String getSmtp_auth_pass() {
			return smtp_auth_pass;
		}
		public void setSmtp_auth_pass(String smtp_auth_pass) {
			this.smtp_auth_pass = smtp_auth_pass;
		}
		public String getEmailFromAddress() {
			return emailFromAddress;
		}
		public void setEmailFromAddress(String emailFromAddress) {
			this.emailFromAddress = emailFromAddress;
		}
		public String getEmailCC() {
			return emailCC;
		}
		public void setEmailCC(String emailCC) {
			this.emailCC = emailCC;
		}
		public String getEmailAdvAddress() {
			return emailAdvAddress;
		}
		public void setEmailAdvAddress(String emailAdvAddress) {
			this.emailAdvAddress = emailAdvAddress;
		}
		public String getSecretId() {
			return secretId;
		}
		public void setSecretId(String secretId) {
			this.secretId = secretId;
		}
		public String getDburl() {
			return dburl;
		}
		public void setDburl(String dburl) {
			this.dburl = dburl;
		}
		public String getDbusername() {
			return dbusername;
		}
		public void setDbusername(String dbusername) {
			this.dbusername = dbusername;
		}
		public String getDbpassword() {
			return dbpassword;
		}
		public void setDbpassword(String dbpassword) {
			this.dbpassword = dbpassword;
		}
		public Map<String, String> getEmailContent() {
			return emailContent;
		}
		public void setEmailContent(Map<String, String> emailContent) {
			this.emailContent = emailContent;
		}
		
		
}
