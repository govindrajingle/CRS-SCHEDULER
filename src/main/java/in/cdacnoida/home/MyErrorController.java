package in.cdacnoida.home;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyErrorController.class);
	
	@RequestMapping("/login1")
	 public void login1(HttpServletRequest request) {
		System.out.println("login1 ok");
		request.changeSessionId();
		
	}
	@RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
		
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		int status1 = (Integer) status;
		System.out.println("Status Code -- " + status1);
		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
			if(statusCode == HttpStatus.NOT_FOUND.value()) {
				LOGGER.error("Page NOT_FOUND error");
				//return "error-404";
				
				 return "error";
	        }
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	            //return "error-500";
	        	LOGGER.error("INTERNAL_SERVER_ERROR");
	        	
	        	return "error";
	        }
	        else if(statusCode==HttpStatus.METHOD_NOT_ALLOWED.value()) {
	        	//return "error-405";
	        	LOGGER.error("Method Not Allowed");
	        	return "error";
	        }
		}
        return "error";
    }
	
	@Override
	public String getErrorPath() {
		return "/error";
	}

}
