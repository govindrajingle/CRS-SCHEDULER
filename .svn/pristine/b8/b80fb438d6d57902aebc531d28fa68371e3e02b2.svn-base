package in.cdacnoida.dava.exphandelling;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import in.cdacnoida.dava.model.LoginBean;
import in.cdacnoida.dava.util.Captcha;

@ControllerAdvice
@RestController
public class GlobalExceptionHandeller extends ResponseEntityExceptionHandler{

	private static final Logger LOGGER=LoggerFactory.getLogger(UserNotFound.class);
	
	@ExceptionHandler(UserNotFound.class)
	public ModelAndView userNotFound(UserNotFound ex,HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		LoginBean loginBean=new LoginBean();
		Captcha captcha=new Captcha();
		String generatedCaptcha=captcha.getCaptcha();
		HttpSession session = request.getSession(true);
		LOGGER.error("User Not Found Exception {}",ex.getMessage());
		session.setAttribute("captcha", generatedCaptcha);
		mv.addObject("generatedCaptcha", generatedCaptcha);
		mv.addObject("loginBean", loginBean);
		mv.addObject("error", ex.getMessage());
		mv.setViewName("davaHome");
		return mv;
	}
	
	
	
	
	
	@ExceptionHandler(CredentialsNotValid.class)
	public final ResponseEntity<Object> handleCredentialsNotValid
		(CredentialsNotValid ex, WebRequest request) throws Exception{
		ExceptionResponse exceptionResponse= new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false),"cdac");
		return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(UserNotVerified.class)
	public final ResponseEntity<Object> handleUserNotVerified
		(UserNotVerified ex, WebRequest request) throws Exception{
		ExceptionResponse exceptionResponse= new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false),"cdac");
		return new ResponseEntity<>(exceptionResponse,HttpStatus.LOCKED);
	}
	
	@ExceptionHandler(UserAlreadyExist.class)
	public final ResponseEntity<Object> handleFormValidationException(UserAlreadyExist ex,
			 WebRequest request) throws Exception{

		 Map<String, Object> body = new LinkedHashMap<>();
		 body.put("timestamp", LocalDate.now());
	     body.put("status", HttpStatus.BAD_REQUEST);
	     body.put("errors", ex.getMessage());
	     return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}


	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
	
		 Map<String, Object> body = new LinkedHashMap<>();
		 body.put("timestamp", LocalDate.now());
	     body.put("status", status.value());
	     List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList());
	     body.put("errors", errors);
	     return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(ResourceNotFound.class)
	public final ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFound ex, 
			WebRequest request) throws Exception{
		 Map<String, Object> body = new LinkedHashMap<>();
		 body.put("timestamp", LocalDate.now());
	     body.put("status", HttpStatus.NOT_FOUND);
	     body.put("errors", ex.getMessage());
	     return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	
	
	
}
