package in.cdacnoida.dava.springsecurity;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccessEventListener 
	implements ApplicationListener<AuthenticationSuccessEvent>{

	@Autowired
    private LoginAttemptService loginAttemptService;
	
	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent e) {
		
		Principal principal =(Principal) e.getSource();
		if(principal!=null) {
			String userName=principal.getName();
			if(userName!=null) {
				loginAttemptService.loginSucceeded(userName);
			}
		}else {
			WebAuthenticationDetails auth = (WebAuthenticationDetails) 
			          e.getAuthentication().getDetails();
			         
			loginAttemptService.loginSucceeded(auth.getRemoteAddress());
		}	

	}
}
