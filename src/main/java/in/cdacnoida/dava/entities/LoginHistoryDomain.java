package in.cdacnoida.dava.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



//@Entity
//@Table(name="login_history")
public class LoginHistoryDomain extends TransactionInfoDomain {
	
	@Id
	@Column(name="login_history_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="loginHistoryDomain")
	@TableGenerator(name = "generator", initialValue = 1, allocationSize = 1)
	private long numId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_login")
	private Date loginDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_logout")
	private Date logoutDate;
	
	@Column(name="str_user_name",length=100)
	private String userName;
	
	@Column(name="str_user_email",length=100)
	private String userEmail;
	
	@Column(name="num_user_id")
	private long userId;
	
	@Column(name="str_browser_name",length=100)
	private String browserName;
	
	/*@Column(name="str_browser_version",length=50)
	private String browserVersion;*/
	
	@Column(name="str_ip_address",length=100)
	private String ipAddress;
	
	@Column(name="str_os_type",length=50)
	private String osType;
	
	@Column(name="str_session_id",length=50)
	private String sessionId;
	
	@Column(name="str_logout_Url",length=200)
	private String logoutUrl;
	
	public long getNumId() {
		return numId;
	}

	public void setNumId(long numId) {
		this.numId = numId;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public Date getLogoutDate() {
		return logoutDate;
	}

	public void setLogoutDate(Date logoutDate) {
		this.logoutDate = logoutDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getBrowserName() {
		return browserName;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getLogoutUrl() {
		return logoutUrl;
	}

	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}


	

}