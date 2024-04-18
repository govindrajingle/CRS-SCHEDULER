package in.cdacnoida.dava.serviceimpl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.cdacnoida.dava.entities.LoginHistoryDomain;
import in.cdacnoida.dava.entities.RegistrationDetails;
import in.cdacnoida.dava.exphandelling.UserNotFound;
import in.cdacnoida.dava.service.LoginHistoryService;
import in.cdacnoida.dava.springsecurity.LoginAttemptService;
import in.cdacnoida.dava.transactions.UserRepository;
import in.cdacnoida.dava.util.DateUtils;
import in.cdacnoida.dava.util.UserPrinciple;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LoginAttemptService loginAttemptService;
	
	@Autowired
    private HttpServletRequest request;
	
	@Autowired
	LoginHistoryService loginHistoryService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		/*String WhichApp=request.getParameter("desktopApp").toString();
	 	System.out.println(WhichApp);*/
		
		
		String ip = getClientIP();
		
		 if (loginAttemptService.isBlocked(username)) {
	            throw new RuntimeException("blocked");
	     }
		
		RegistrationDetails registrationDetails=userRepository.findByUserName(username);
		if(registrationDetails==null) {
			//throw new UserNotFound("User Not Found");
			//Govind user not found message changed
			//throw new UserNotFound("Invalid Credentials");
			throw new RuntimeException("Invalid Credentials");
		}
		LoginHistoryDomain loginHistoryDomain =loginHistoryService.getLastLoginDetails(registrationDetails.getUserId());
		String lastLogin="";
		if(null != loginHistoryDomain){
			lastLogin=DateUtils.dateToDateTimeString(loginHistoryDomain.getLoginDate());
		}
		return new UserPrinciple(registrationDetails,lastLogin);
	}

	private String getClientIP() {
	    String xfHeader = request.getHeader("X-Forwarded-For");
	    if (xfHeader == null){
	        return request.getRemoteAddr();
	    }
	    return xfHeader.split(",")[0];
	}
	
}
