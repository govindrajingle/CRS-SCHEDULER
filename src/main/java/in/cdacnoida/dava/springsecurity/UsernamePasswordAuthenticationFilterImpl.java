package in.cdacnoida.dava.springsecurity;

import java.time.LocalDateTime;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


public class UsernamePasswordAuthenticationFilterImpl extends UsernamePasswordAuthenticationFilter{

	
	private boolean postOnly = true;
	
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		if (postOnly && !request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException(
					"Authentication method not supported: " + request.getMethod());
		}
		
		
		/*
		 * String username1 = obtainUsername(request); System.out.println("username1::"
		 * + username1); byte[] Encodedusername1 =
		 * Base64.getDecoder().decode(username1); String EU1 = new
		 * String(Encodedusername1); System.out.println("encodedusername1::" +
		 * Encodedusername1); StringBuffer reversedStringBuffer1 = new
		 * StringBuffer(EU1); reversedStringBuffer1.reverse();
		 * System.out.println("reversedStringBuffer::" + reversedStringBuffer1); String
		 * EN2 = new String(reversedStringBuffer1); System.out.println("EN2::" + EN2);
		 * byte[] EN3 = Base64.getDecoder().decode(EN2); String username = new
		 * String(EN3); System.out.println("username::" + username);
		 */
		String username = obtainUsername(request);
		System.out.println(LocalDateTime.now() + " --- Logged In --- " + username);
		String password= obtainPassword(request);
		String token=request.getSession().getAttribute("passhash").toString(); 

//		System.out.println("passhash::::::"+token);
	
		//String password = request.getAttribute("passwordNew").toString();

        //added by harshita
//		System.out.println("insidehgf      "+password);
		try {
			/*
			 * byte[] decoded1;
			 * 
			 * 
			 * decoded1 = new BASE64Decoder().decodeBuffer(username); username=new
			 * String(decoded1);
			 * 
			 * System.out.println("hello"+ username);
			 */
			
			byte[] decodedBytes = Base64.getDecoder().decode(password);
			String decodedString = new String(decodedBytes);
			
//			System.out.println("decodedString::::::"+decodedString);
			
			StringBuffer reversedStringBuffer = new StringBuffer(decodedString);
			reversedStringBuffer.reverse(); 
			
//			System.out.println("reversedStringBuffer::"+reversedStringBuffer);
			
			String value1 = new String (reversedStringBuffer);
//			System.out.println("value1::"+reversedStringBuffer);
			
			
			byte[] decodedBytes2 = Base64.getDecoder().decode(value1);
			String value4 =new String(decodedBytes2);
//			 System.out.println("value4::"+value4);
			 
		  String[] temp = value4.split(" ### ");
		  
//		  System.out.println("User Name ::"+ temp[0].trim() + "--"  +username + " NA" +  temp[0].trim().equals( username));
		  
		  
//		  System.out.println("passhash ::"+ temp[2].trim() + "--"  +token + " NA" +  temp[2].trim().equals(token));
		  
		  
		  
//		  System.out.println("temp[1].trim()==="+temp[1].trim());
		  System.out.println(LocalDateTime.now() + " sdf4HsdaD3GF7342473ggdf535$#765%#gjferqoebc6^$$" + temp[1].trim() + "$$sdf4HsdaD3GF7342473ggdf535$#765%#gjferqoebc6^$$");
		  
		  
		  if(temp.length==3 &&    temp[0].trim().equals(username) &&    temp[2].trim().equals(token)){
			 
		  //username =temp[0].trim();  
		  password =temp[1].trim();
		  
		  request.setAttribute("passwordNew", temp[1].trim()); 
		  }else{ throw new
		  Exception("Invalid Password Exception"); }
		  
		  } catch (Exception e) {
		  
		  }	
 
		if (username == null) {
			username = "";
		}

		if (password == null) {
			password = "";
		}
		
		username = username.trim().toLowerCase();
		
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
				username, password);
		
		request.changeSessionId();
		
		// Allow subclasses to set the "details" property
		setDetails(request, authRequest);
		
		
		
		return this.getAuthenticationManager().authenticate(authRequest);
	}

}
