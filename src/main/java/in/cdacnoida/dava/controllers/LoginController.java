package in.cdacnoida.dava.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.cdacnoida.dava.entities.RegistrationDetails;
import in.cdacnoida.dava.model.LoginBean;
import in.cdacnoida.dava.service.DavaServices;
import in.cdacnoida.dava.springsecurity.LoggedInUserSession;
import in.cdacnoida.dava.util.Captcha;

@Controller
public class LoginController {

	@Autowired
	private DavaServices davaServices;
	
	@Autowired
	private LoggedInUserSession userData;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(LoginController.class);
	
	@GetMapping("/")
	public ModelAndView successfulLogin(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		LOGGER.info("Logged in user id is {}",loogedInUserId);
		if(loogedInUserId!=null && !loogedInUserId.equals("")) {
			RegistrationDetails registrationDetails=davaServices.findByUserName(loogedInUserId);
			LOGGER.info("Logged in user type is {} ",registrationDetails.getApplicantType());
			String applicantType=registrationDetails.getApplicantType();
			userData.setUserId(registrationDetails.getUserId());
			userData.setUserName(registrationDetails.getOrgName());
			
			String userType=registrationDetails.getApplicantType();
			if(userType.equals("100")) {
				userType="Manufacture";
			}else if(userType.equals("101")) {
				userType="Exporter";
			}else if(userType.equals("104")){
				userType="Manufacturing Site User";
			}else {
				userType="Admin";
			}
			userData.setUserType(userType);
			request.getSession().setAttribute("userData", userData);
			LOGGER.info("Logged In User Session  {}",userData);
			mv.setViewName("redirect:/Dashboard");
		}
		return mv;
	}
	
	
	@GetMapping("logout-success")
	public ModelAndView afterLogout(HttpServletRequest request,HttpSession session) {
		ModelAndView mv=new ModelAndView();
		Object error= session.getAttribute("error");
		LOGGER.info("error {}", error);
		mv.setViewName("redirect:/login");
		return mv;
	}
	
	@GetMapping("/loginFailure")
	public ModelAndView loginFailure(HttpServletRequest request,@RequestParam("error") String error) {
		ModelAndView mv=new ModelAndView();
		LoginBean loginBean=new LoginBean();
		Captcha captcha=new Captcha();
		String generatedCaptcha=captcha.getCaptcha();
		HttpSession session = request.getSession(true);
		
		session.setAttribute("captcha", generatedCaptcha);
		mv.addObject("generatedCaptcha", generatedCaptcha);
		mv.addObject("loginBean", loginBean);
		mv.setViewName("davaHome");
		return mv;
	}
	
}
