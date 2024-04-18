package in.cdacnoida.dava.springsecurity;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

@Component
public class CsrfProtectionMatcher implements RequestMatcher {

	private Pattern allowedMethods = Pattern.compile("^GET$");
	
	private AntPathRequestMatcher[] requestMatchers = {
	        
			 new AntPathRequestMatcher("/RCMCData"), // add the url in given format (note: two urls need to be seprated by comma )
	          new AntPathRequestMatcher("/uploadFile"),
	          //added by harshita
	          new AntPathRequestMatcher("/addressProofFile"),
	          new AntPathRequestMatcher("/drugLicence"),
	          new AntPathRequestMatcher("/uploadMultipleFiles"),
	          new AntPathRequestMatcher("/send"),
	          new AntPathRequestMatcher("/RecRCMCData"),
	          new AntPathRequestMatcher("/UserLogin"),
	          new AntPathRequestMatcher("/ConfigDetails"),
	          new AntPathRequestMatcher("/updatePublicKey"),
	          new AntPathRequestMatcher("/ivedaRegistrationData"),
	          new AntPathRequestMatcher("/uploadFileXml/**"),
	          new AntPathRequestMatcher("/uploadFileData"),
	          new AntPathRequestMatcher("/ivedaRegistrationData"),
	          new AntPathRequestMatcher("/saveWorkshopRegistration"),
	          new AntPathRequestMatcher("/uploadFilePDF/**"),
	          new AntPathRequestMatcher("/ShowConsignmnetDetails"),
	          new AntPathRequestMatcher("/getSignatureChecksum"),
	          new AntPathRequestMatcher("/getdrugChecksum"),
	          new AntPathRequestMatcher("/saveReportProblem"),
	          new AntPathRequestMatcher("/guest/resendotp/**"),
	          new AntPathRequestMatcher("/guest/**"),
	          new AntPathRequestMatcher("/desktopConfigDtls"),
	          new AntPathRequestMatcher("/getVersionDetls"),
	          new AntPathRequestMatcher("/app/user/logs"),
	          new AntPathRequestMatcher("/generateAllProductPdf"),
	          new AntPathRequestMatcher("/HashCodeCheck"),
	          new AntPathRequestMatcher("/receivedHash"),
	          //ALL BIS-CRS CONTROLLERS
	          new AntPathRequestMatcher("/showTestData"),
	          new AntPathRequestMatcher("/GemReportDetailsData"),
	          new AntPathRequestMatcher("/LapsingAndDeferredDataDetails")
	          
	      };
	
	
	@Override
	public boolean matches(HttpServletRequest request) {
		
		if (allowedMethods.matcher(request.getMethod()).matches()) {
		      return false;
		    }
		// If the request match one url the CSFR protection will be disabled
		 for (AntPathRequestMatcher rm : requestMatchers) {
	          if (rm.matches(request)) { 
	        	  return false; 
	        	  }
	        }
		 return true;
	}

}
