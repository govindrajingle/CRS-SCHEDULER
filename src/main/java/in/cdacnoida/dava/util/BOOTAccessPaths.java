package in.cdacnoida.dava.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:BOOTresourceBundlePath.properties")
@ConfigurationProperties(prefix = "")
public class BOOTAccessPaths {
	//FTP
	private String BIS_GST_NO;
	private String FTP_HOST_NAME;
	private String FTP_AUTH_USER;
	private String FTP_AUTH_PWD;
	private String FTP_PORT;
	private String FTP_DIR;
	private String FTP_HOST;
	private String FTP_USER;
	private String FTP_PWD;
	private String PROJECT_URL;
	
	//SMTP
	private String SMTP_HOST_NAME;
	private String SMTP_AUTH_USER;
	private String SMTP_AUTH_PWD;
	private String emailFromAddress;
	private String emailCC;
	private String SMTP_PORT;
	private String MAIL_CONTENT_LIST;
	
	public String getBIS_GST_NO() {
		return BIS_GST_NO;
	}

	public void setBIS_GST_NO(String bIS_GST_NO) {
		BIS_GST_NO = bIS_GST_NO;
	}

	public String getFTP_HOST_NAME() {
		return FTP_HOST_NAME;
	}

	public void setFTP_HOST_NAME(String fTP_HOST_NAME) {
		FTP_HOST_NAME = fTP_HOST_NAME;
	}

	public String getFTP_AUTH_USER() {
		return FTP_AUTH_USER;
	}

	public void setFTP_AUTH_USER(String fTP_AUTH_USER) {
		FTP_AUTH_USER = fTP_AUTH_USER;
	}

	public String getFTP_AUTH_PWD() {
		return FTP_AUTH_PWD;
	}

	public void setFTP_AUTH_PWD(String fTP_AUTH_PWD) {
		FTP_AUTH_PWD = fTP_AUTH_PWD;
	}

	public String getFTP_PORT() {
		return FTP_PORT;
	}

	public void setFTP_PORT(String fTP_PORT) {
		FTP_PORT = fTP_PORT;
	}

	public String getFTP_DIR() {
		return FTP_DIR;
	}

	public void setFTP_DIR(String fTP_DIR) {
		FTP_DIR = fTP_DIR;
	}

	public String getFTP_HOST() {
		return FTP_HOST;
	}

	public void setFTP_HOST(String fTP_HOST) {
		FTP_HOST = fTP_HOST;
	}

	public String getFTP_USER() {
		return FTP_USER;
	}

	public void setFTP_USER(String fTP_USER) {
		FTP_USER = fTP_USER;
	}

	public String getFTP_PWD() {
		return FTP_PWD;
	}

	public void setFTP_PWD(String fTP_PWD) {
		FTP_PWD = fTP_PWD;
	}

	public String getPROJECT_URL() {
		return PROJECT_URL;
	}

	public void setPROJECT_URL(String pROJECT_URL) {
		PROJECT_URL = pROJECT_URL;
	}

	@Override
	public String toString() {
		return "BOOTAccessPaths [BIS_GST_NO=" + BIS_GST_NO + ", FTP_HOST_NAME=" + FTP_HOST_NAME + ", FTP_AUTH_USER="
				+ FTP_AUTH_USER + ", FTP_AUTH_PWD=" + FTP_AUTH_PWD + ", FTP_PORT=" + FTP_PORT + ", FTP_DIR=" + FTP_DIR
				+ ", FTP_HOST=" + FTP_HOST + ", FTP_USER=" + FTP_USER + ", FTP_PWD=" + FTP_PWD + ", PROJECT_URL="
				+ PROJECT_URL + ", SMTP_HOST_NAME=" + SMTP_HOST_NAME + ", SMTP_AUTH_USER=" + SMTP_AUTH_USER
				+ ", SMTP_AUTH_PWD=" + SMTP_AUTH_PWD + ", emailFromAddress=" + emailFromAddress + ", emailCC=" + emailCC
				+ ", SMTP_PORT=" + SMTP_PORT + "]";
	}

	public String getSMTP_HOST_NAME() {
		return SMTP_HOST_NAME;
	}

	public void setSMTP_HOST_NAME(String sMTP_HOST_NAME) {
		SMTP_HOST_NAME = sMTP_HOST_NAME;
	}

	public String getSMTP_AUTH_USER() {
		return SMTP_AUTH_USER;
	}

	public void setSMTP_AUTH_USER(String sMTP_AUTH_USER) {
		SMTP_AUTH_USER = sMTP_AUTH_USER;
	}

	public String getSMTP_AUTH_PWD() {
		return SMTP_AUTH_PWD;
	}

	public void setSMTP_AUTH_PWD(String sMTP_AUTH_PWD) {
		SMTP_AUTH_PWD = sMTP_AUTH_PWD;
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

	public String getSMTP_PORT() {
		return SMTP_PORT;
	}

	public void setSMTP_PORT(String sMTP_PORT) {
		SMTP_PORT = sMTP_PORT;
	}

	public String getMAIL_CONTENT_LIST() {
		return MAIL_CONTENT_LIST;
	}

	public void setMAIL_CONTENT_LIST(String mAIL_CONTENT_LIST) {
		MAIL_CONTENT_LIST = mAIL_CONTENT_LIST;
	}
}
