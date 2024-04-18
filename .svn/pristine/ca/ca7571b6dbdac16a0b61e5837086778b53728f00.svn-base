package in.cdacnoida.dava.springsecurity;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFailureEventListener 
	implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

	 @Autowired
	 private LoginAttemptService loginAttemptService;
	 
	 private static final Logger LOGGER=LoggerFactory.getLogger(AuthenticationFailureEventListener.class);
	
	@Override
	public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent e) {
		Principal principal =(Principal) e.getSource();
		if(principal!=null) {
			String userName=principal.getName();
			if(userName!=null) {
				 loginAttemptService.loginFailed(userName);
			}
		}else {
			 WebAuthenticationDetails auth = (WebAuthenticationDetails) 
			          e.getAuthentication().getDetails();
			 loginAttemptService.loginFailed(auth.getRemoteAddress());
		}	
	}

}
