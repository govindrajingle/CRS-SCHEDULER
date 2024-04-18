package in.cdacnoida.dava.springsecurity;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LoggedInUserSession {

	public LoggedInUserSession() {}
	
	private Long userId;
	private String userName;
	private String userType;
	
	
	
	
	public LoggedInUserSession(Long userId, String userName, String userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userType = userType;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "LoggedInUserSession [userId=" + userId + ", userName=" + userName + ", userType=" + userType + "]";
	}
	
	
}
