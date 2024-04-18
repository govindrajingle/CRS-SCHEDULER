package in.cdacnoida.dava.springsecurity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		if (exception.getMessage().equalsIgnoreCase("blocked")) {
			request.getSession().setAttribute("error", "This user is blocked please try after 5 minutes");
        }else if(exception instanceof SessionAuthenticationException){
        	request.getSession().setAttribute("error", "User is logged in to maximum allowed devices");
        }else if(exception instanceof BadCredentialsException) {
        	request.getSession().setAttribute("error", "Invalid Credentials");
        }else {
        	request.getSession().setAttribute("error",exception.getMessage());
        }
		
		response.sendRedirect(request.getContextPath()+"/login");

	}

}
