package in.cdacnoida.dava.springsecurity;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import in.cdacnoida.dava.entities.LoginHistoryDomain;
import in.cdacnoida.dava.entities.RegistrationDetails;
import in.cdacnoida.dava.model.UserDetails;
import in.cdacnoida.dava.service.DavaServices;
import in.cdacnoida.dava.service.LoginHistoryService;
import in.cdacnoida.dava.util.DataEncoder;
import org.apache.commons.codec.binary.Base64;
import javax.servlet.http.Cookie;

@Component
public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private static final Logger LOGGER=LoggerFactory.getLogger(MySimpleUrlAuthenticationSuccessHandler.class);

	
	@Autowired
    ActiveUserStore activeUserStore;
	
	@Autowired
	private DavaServices davaServices;
	
	@Autowired
	LoginHistoryService loginHistoryService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		 HttpSession session = request.getSession(false);
		 String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		 RegistrationDetails registrationDetails=null;
		 if(loogedInUserId!=null && !loogedInUserId.equals("")) {
			 registrationDetails=davaServices.findByUserName(loogedInUserId);
		 }
		 
		 	
		 	
	        if (session != null) {
	        	String captcha = request.getParameter("captcha");
	        	Object captchaObject=request.getSession().getAttribute("captcha");
	        	//String sessionCaptcha =  request.getSession().getAttribute("captcha").toString();
	        	
	        	if(captchaObject!=null && !captcha.equals(captchaObject.toString())) {
	        		request.getSession().setAttribute("error", "invalid captcha");
	        		response.sendRedirect(request.getContextPath()+"/login");	
	        	}else if(registrationDetails!=null && registrationDetails.getRandomNumber()!=0 && registrationDetails.getNumEmailStatus()!=1) {
	        		request.getSession().setAttribute("error", "Email not verified yet");
	        		response.sendRedirect(request.getContextPath()+"/login");	
	        	}else if(registrationDetails.getNumApprovalStatusPharmaexil()==2){
	        		request.getSession().setAttribute("error", "Your registration request is rejected by Pharmexcil");
	        		response.sendRedirect(request.getContextPath()+"/login");
	        	}else if(registrationDetails.getNumApprovalStatusPharmaexil()!=1){
	        		request.getSession().setAttribute("error", "Registration request is pending at Pharmexcil");
	        		response.sendRedirect(request.getContextPath()+"/login");
	        	}else {
	        		LoggedUser user = new LoggedUser(authentication.getName(), activeUserStore,registrationDetails.getUserId());
		            session.setAttribute("user", user);
		            LoginHistoryDomain  loginHistoryDomain = createLoginHistoryDomain(request,registrationDetails);
			        loginHistoryService.saveLoginHistoryDomain(loginHistoryDomain);
			        
			        //LoggedInUserSession loggedInUser=new LoggedInUserSession(registrationDetails.getUserId(),registrationDetails.getUserName(),registrationDetails.getApplicantType());
			        //Added for Session Highjacking
			        UserDetails ud=new UserDetails();
					ud.setUserId(registrationDetails.getUserId());
					ud.setEncUserId(DataEncoder.encode(String.valueOf(registrationDetails.getUserId())));
					ud.setTomcatSessId(session.getId());
					ud.setEncSessionId(DataEncoder.encode(ud.getTomcatSessId()));
					setSession(ud,request,response);
					UserDetails userDetails=new UserDetails(registrationDetails.getUserId(),registrationDetails.getUserName());
					session.setAttribute("userDetails", userDetails);
					//End
	        		response.sendRedirect(request.getContextPath()+"/");	
	        	}
	        }
	}
	
	
	
	public String setSession(UserDetails ses, HttpServletRequest request_p,
			HttpServletResponse response_p) {
		
				HttpSession httpsession=request_p.getSession();
				String userAgent = request_p.getHeader("User-Agent");
				ses.setBrowserInfo(userAgent);

				httpsession.setAttribute("SessInfo", ses);
				
				byte[] encodedBytes = Base64.encodeBase64(("" + ses.getUserId()).getBytes());
				String encUserId = new String(encodedBytes);
				ses.setEncUserId(encUserId);
				Cookie[] cookies = request_p.getCookies();
				String sessionId = "";
				String encSessionId = "";

				for (int i = 0; i < cookies.length; i++) {
					Cookie cookie = cookies[i];
					if (cookie.getName().equalsIgnoreCase("JSESSIONID") || cookie.getName().equalsIgnoreCase("cdacid")) {
						sessionId = ses.getTomcatSessId();
						ses.setTomcatSessId(sessionId);
						byte[] encodedSessionByte = Base64.encodeBase64(sessionId.getBytes());
						encSessionId = new String(encodedSessionByte);
						ses.setEncSessionId(encSessionId);

					}
				}

				Cookie userIdCookie = new Cookie("window_count_save", encUserId);
				Cookie sessionCookie = new Cookie("hit_count_save", encSessionId);
				
				response_p.addCookie(userIdCookie);
				response_p.addCookie(sessionCookie);
				
				//end
		return "Success";
	}
	
	public LoginHistoryDomain createLoginHistoryDomain(HttpServletRequest request,RegistrationDetails userInfo){
		LoginHistoryDomain loginHistory = new LoginHistoryDomain();
		loginHistory.setUserId(userInfo.getUserId());
		loginHistory.setUserName(userInfo.getUserName());
		loginHistory.setUserEmail(userInfo.getUserName());
		loginHistory.setLoginDate(new Date());
		//loginHistory.setNumTrUserId(userInfo.getUserId());
		
		loginHistory.setNumIsValid(1);
		
		String  browserDetails  =   request.getHeader("User-Agent");
        String  userAgent       =   browserDetails;
        String  user            =   userAgent.toLowerCase();

        String os = "";
        String browser = "";

       
        //=================OS=======================
         if (userAgent.toLowerCase().indexOf("windows") >= 0 )
         {
             os = "Windows";
         } else if(userAgent.toLowerCase().indexOf("mac") >= 0)
         {
             os = "Mac";
         } else if(userAgent.toLowerCase().indexOf("x11") >= 0)
         {
             os = "Unix";
         } else if(userAgent.toLowerCase().indexOf("android") >= 0)
         {
             os = "Android";
         } else if(userAgent.toLowerCase().indexOf("iphone") >= 0)
         {
             os = "IPhone";
         }else{
             os = "UnKnown, More-Info: "+userAgent;
         }
         //===============Browser===========================
        if (user.contains("msie"))
        {
            String substring=userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
            browser=substring.split(" ")[0].replace("MSIE", "IE")+"-"+substring.split(" ")[1];
        } else if (user.contains("safari") && user.contains("version"))
        {
            browser=(userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0]+"-"+(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
        } else if ( user.contains("opr") || user.contains("opera"))
        {
            if(user.contains("opera"))
                browser=(userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0]+"-"+(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
            else if(user.contains("opr"))
                browser=((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-")).replace("OPR", "Opera");
        } else if (user.contains("chrome"))
        {
            browser=(userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
        } else if ((user.indexOf("mozilla/7.0") > -1) || (user.indexOf("netscape6") != -1)  || (user.indexOf("mozilla/4.7") != -1) || (user.indexOf("mozilla/4.78") != -1) || (user.indexOf("mozilla/4.08") != -1) || (user.indexOf("mozilla/3") != -1) )
        {
            //browser=(userAgent.substring(userAgent.indexOf("MSIE")).split(" ")[0]).replace("/", "-");
            browser = "Netscape-?";

        } else if (user.contains("firefox"))
        {
            browser=(userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
        } else if(user.contains("rv"))
        {
            browser="IE-" + user.substring(user.indexOf("rv") + 3, user.indexOf(")"));
        } else
        {
            browser = "UnKnown, More-Info: "+userAgent;
        }
      loginHistory.setOsType(os);
      loginHistory.setBrowserName(browser);
      
      String ipAddress = request.getRemoteAddr();
      loginHistory.setIpAddress(ipAddress);      
      loginHistory.setSessionId(request.getSession().getId());				
		return loginHistory;
	}
	

}
