package in.cdacnoida.dava.model;

public class UserDetails {

	private Long userId;
	
	
	private String userEmail;
	
	
	private String password;
	
	private String proposalNumber;
	
	
	private String phoneNumber;
	
	
	private String encUserId;
	private String encSessionId;
	private String tomcatSessId;
	private String browserInfo;
	
	public UserDetails() {}
	
	public UserDetails(Long userId,String userEmail) {
		super();
		this.userEmail = userEmail;
		this.userId=userId;
		
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProposalNumber() {
		return proposalNumber;
	}

	public void setProposalNumber(String proposalNumber) {
		this.proposalNumber = proposalNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEncUserId() {
		return encUserId;
	}

	public void setEncUserId(String encUserId) {
		this.encUserId = encUserId;
	}

	public String getEncSessionId() {
		return encSessionId;
	}

	public void setEncSessionId(String encSessionId) {
		this.encSessionId = encSessionId;
	}

	public String getTomcatSessId() {
		return tomcatSessId;
	}

	public void setTomcatSessId(String tomcatSessId) {
		this.tomcatSessId = tomcatSessId;
	}

	public String getBrowserInfo() {
		return browserInfo;
	}

	public void setBrowserInfo(String browserInfo) {
		this.browserInfo = browserInfo;
	}
}
