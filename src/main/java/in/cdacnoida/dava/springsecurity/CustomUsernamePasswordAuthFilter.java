package in.cdacnoida.dava.springsecurity;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import in.cdacnoida.dava.util.DataEncoder;
import sun.misc.BASE64Decoder;

import java.util.Base64;

public class CustomUsernamePasswordAuthFilter extends UsernamePasswordAuthenticationFilterImpl{

	
	
	
	private static final Logger LOGGER=LoggerFactory.getLogger(CustomUsernamePasswordAuthFilter.class);
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request,HttpServletResponse response,
			FilterChain chain,Authentication authResult) throws ServletException,IOException {
		super.successfulAuthentication(request, response, chain, authResult);
	}
	
	
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request,HttpServletResponse response,
			AuthenticationException failed) throws ServletException,IOException {
		super.unsuccessfulAuthentication(request, response, failed);
	}
	
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,HttpServletResponse response)
			throws AuthenticationException{
		
		 /*String password=request.getParameter("password");
		
		 byte[] decoded;
		 byte[] decoded2;
		 byte[] decoded3;
		 byte[] decoded4;
		 try {
			 decoded = new BASE64Decoder().decodeBuffer(password);
			 String value = new String(decoded);
			 
			 decoded2 = new BASE64Decoder().decodeBuffer(value);
			 String value2 = new String(decoded2);
			 
			 decoded3 = new BASE64Decoder().decodeBuffer(value2);
			 String value3 = new String(decoded3);
			 
			 decoded4 = new BASE64Decoder().decodeBuffer(value3);
			 String value4 = new String(decoded4);
			 
			 String[] temp = value4.split(" ### ");
			 if(temp.length==3){
				 request.setAttribute("passwordNew", temp[1].trim());
				}else{
					throw new Exception("Invalid Password Exception");
				}
			 
		} catch (Exception e) {
			
		}*/
		 
		
		
		 
		/* if(captcha!=null){
	        HttpSession session = request.getSession(false);
	        String sessionCaptcha= session.getAttribute("captcha").toString();
	        LOGGER.info("session stored captcha {}",sessionCaptcha);
	        if(!captcha.equals(sessionCaptcha)) {
	        	  throw new AuthenticationServiceException("Incorrect captcha value!");
	        }
		 }*/
	        //return super.attemptAuthentication(request, response);
		 	return super.attemptAuthentication(request, response);
	    }
}
