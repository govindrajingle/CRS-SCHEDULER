package in.cdacnoida.dava.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.solr.client.solrj.io.stream.GetStream;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.cdacnoida.dava.daoservice.DavaDaoServices;
import in.cdacnoida.dava.entities.CountryMst;
import in.cdacnoida.dava.entities.DistrictMst;
import in.cdacnoida.dava.entities.InstituteMemberDetailDomain;
import in.cdacnoida.dava.entities.ReportProblemDomain;
import in.cdacnoida.dava.model.LoginBean;
import in.cdacnoida.dava.model.MemberDetailForm;
import in.cdacnoida.dava.model.RegistrationForm;
import in.cdacnoida.dava.model.ReportProblemForm;
import in.cdacnoida.dava.model.ReportProblemForm2;
import in.cdacnoida.dava.service.DataEncoderService;
import in.cdacnoida.dava.service.DavaServices;
import in.cdacnoida.dava.service.ReportProblemService;
import in.cdacnoida.dava.serviceimpl.ReportProblemServiceImpl;
import in.cdacnoida.dava.transactions.DavaTransactions;
import in.cdacnoida.dava.util.ConfigProperties;
import in.cdacnoida.dava.util.DataEncoder;
import in.cdacnoida.dava.util.Sendmail;
import in.cdacnoida.davaconfig.EmailContent;

@Controller
public class ReportProblemAction {

	// @Autowired
	// public LocationMasterDaoService locDao;
	// public ReportProblemDaoService rep

	@Autowired
	HttpServletRequest request;

	@Autowired
	public ReportProblemServiceImpl rpsimpl;

	@Autowired
	public ReportProblemService repServ;

	@Autowired
	DataEncoderService encodedservice;

	@Autowired
	private DavaServices davaServices;

	@Autowired
	public DavaDaoServices dDao;
	

	@Autowired
	public DavaTransactions dt;

	@Autowired
	private Sendmail sendmail;

	@Autowired
	private ConfigProperties configProp;

	/*
	 * @Autowired public ReportProblemForm reportProblemForm;
	 */
	
	@Autowired
	private EmailContent emailContent;
	

	@RequestMapping(value = "/ReportProblem", method = RequestMethod.GET)
	public String ReportProblem(@ModelAttribute("reportProblemForm") ReportProblemForm reportForm,
			HttpServletRequest request) {
		String response = "";
		System.out.println("cdac");

		LoginBean loginBean = new LoginBean();

		List<CountryMst> countryMst = davaServices.getCountryNames();
		request.setAttribute("countryMst", countryMst);

		response = "ReportProblem";
		request.setAttribute("loginBean", loginBean);
		request.setAttribute("generatedCaptcha", request.getSession().getAttribute("captcha"));
		System.out.println("nic");

		return response;
	}
	public String decode(String strString_p) {
		  
		
		  

		if (strString_p == null)
			strString_p = "";
		else {

			try {

				strString_p = new String((new sun.misc.BASE64Decoder()).decodeBuffer(strString_p));

			} catch (Exception e) {
			}
		}
		return strString_p;
	}
	public static String reverse(String input) {
		char[] in = input.toCharArray();
		int begin = 0;
		int end = in.length - 1;
		char temp;
		while (end > begin) {
			temp = in[begin];
			in[begin] = in[end];
			in[end] = temp;
			end--;
			begin++;
		}
		return new String(in);
	}
	@RequestMapping(value = "/saveReportType", method = RequestMethod.POST)
	public String saveReportType(@ModelAttribute("registrationForm") RegistrationForm registrationForm,
			@ModelAttribute("reportProblemForm") ReportProblemForm reportForm, BindingResult result,
			RedirectAttributes redirectAttributes, HttpServletRequest request) throws Exception {

		String res = "hello";

		String enteredCaptcha = request.getParameter("feedbackResponseCaptcha");
		String captcha = request.getSession().getAttribute("captcha").toString();

		if (!enteredCaptcha.equals(captcha)) {
			redirectAttributes.addFlashAttribute("flagError", 1);
			request.setAttribute("reportProblemForm", reportForm);
			res = "redirect:/ReportProblem";
			return res;
		}
		MultipartFile file=registrationForm.getUploadfile();
		String fileSize = null;
		String check = null;
		int urlcheck = 0;
		//String hppValue=request.getParameter("hppGeneratedData");
		String Value1=request.getParameter("hashValue");
		String value2=decode(Value1);
		String value3=reverse(value2);
		String hashValue=value3;
		String hash=null;
			if(file !=null){
				
				String fileName=file.getOriginalFilename();
				String fakePath="C:\\fakepath\\"+fileName;
				hash=encodedservice.encode(fakePath);
				System.out.println("hash:::"+hash);
				
				fileSize = file.getSize() / 1024 + " Kb";
				check = GlobalAction.validateFileContentType("pdf", file);
				urlcheck = GlobalAction.checkFileContainUrl(file);
			}
			if(file!=null) {
				if (Integer.parseInt(fileSize.split(" ")[0]) < 10 * 1024
						&& Integer.parseInt(fileSize.split(" ")[0]) > 0) {
				if (hash.toString().equals(hashValue) ) {
			if(check != "12" && urlcheck != 19) {
		Long userId = registrationForm.getUserId();
		String userName = registrationForm.getUserName();

		ReportProblemDomain rp = repServ.addReportMaster(reportForm);

		System.err.println(rp.getEmail_id() + "        " + rp.getProblem_id() + "       " + rp.getProblem_no());

		List<ReportProblemDomain> list = davaServices.getProblemDeatil(rp.getProblem_id());

		redirectAttributes.addFlashAttribute("flagSave", 1);

		String emailVerificationSubject=emailContent.getEmailContent().get("emailSubjectForReportProb");
		String emailVerificationContent=emailContent.getEmailContent().get("emailContentForReportProb");
		
		emailVerificationContent=emailVerificationContent.replaceAll("\\$USER\\_NAME\\$", reportForm.getUser_name());
		emailVerificationContent=emailVerificationContent.replaceAll("\\$PROBLEN\\_NO\\$", "2024/"+rp.getProblem_id());
		sendmail.sendMailToUser(reportForm.getEmail_id(), emailVerificationSubject, emailVerificationContent);
		
		//sendmail.transferToMailServer(reportForm.getEmail_id(), "Issue Id of problem", "Your Issue ID Is 2020/" + rp.getProblem_id());

		davaServices.addDataToEmailMst("Issue Id of problem", request);

		davaServices.addEmailDetailsToDb(userId, userName, "Issue Id of problem", "Your Issue ID Is 2024/" + rp.getProblem_id(), request);

		res = "redirect:/ReportProblem";
			}else {
				redirectAttributes.addFlashAttribute("flagFile", 1);
				request.setAttribute("reportProblemForm", reportForm);
				res = "redirect:/ReportProblem";
			}
			}else {
				redirectAttributes.addFlashAttribute("tampFile", 1);
				request.setAttribute("reportProblemForm", reportForm);
				res = "redirect:/ReportProblem";
			}
			}else {
				redirectAttributes.addFlashAttribute("fileSize", 1);
				request.setAttribute("reportProblemForm", reportForm);
				res = "redirect:/ReportProblem";
			}
			}else {
				Long userId = registrationForm.getUserId();
				String userName = registrationForm.getUserName();

				ReportProblemDomain rp = repServ.addReportMaster(reportForm);

				System.err.println(rp.getEmail_id() + "        " + rp.getProblem_id() + "       " + rp.getProblem_no());

				List<ReportProblemDomain> list = davaServices.getProblemDeatil(rp.getProblem_id());

				redirectAttributes.addFlashAttribute("flagSave", 1);

				String emailVerificationSubject=emailContent.getEmailContent().get("emailSubjectForReportProb");
				String emailVerificationContent=emailContent.getEmailContent().get("emailContentForReportProb");
				
				emailVerificationContent=emailVerificationContent.replaceAll("\\$USER\\_NAME\\$", reportForm.getUser_name());
				emailVerificationContent=emailVerificationContent.replaceAll("\\$PROBLEN\\_NO\\$", "2020/"+rp.getProblem_id());
				sendmail.sendMailToUser(reportForm.getEmail_id(), emailVerificationSubject, emailVerificationContent);
				
				//sendmail.transferToMailServer(reportForm.getEmail_id(), "Issue Id of problem", "Your Issue ID Is 2020/" + rp.getProblem_id());

				davaServices.addDataToEmailMst("Issue Id of problem", request);

				davaServices.addEmailDetailsToDb(userId, userName, "Issue Id of problem", "Your Issue ID Is 2024/" + rp.getProblem_id(), request);

				res = "redirect:/ReportProblem";
			}
		return res;
	}

	

	@RequestMapping(value = "/FeedbackResponse", method = RequestMethod.GET)
	public String ApprovedRegistrationData(@ModelAttribute("reportProblemForm") ReportProblemForm reportForm,
			HttpServletRequest request) {
		String response = "";

		response = "ReposrtProblemResponse";

		return response;
	}

	@RequestMapping(value = "/getFeedbackResponseListing", method = RequestMethod.GET)
	@ResponseBody
	public String viewFeedbackResponseListing(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("in data table code");
		String jsonResponse = davaServices.ShowFeedbackResponseListing(request);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}

	@RequestMapping(value = "/updateFeedBackForReply", method = RequestMethod.POST)
	public String updateFeedBackForReply(@ModelAttribute("reportProblemForm") ReportProblemForm reportForm,
			BindingResult result, HttpServletRequest request, RedirectAttributes attr) {

		System.out.println("IN Testing ACTION");
		String res = "";
		System.out.println(reportForm.getStrRemarks() + "      Reply Status        " + reportForm.getProblem_id());
		List<ReportProblemDomain> list = davaServices.getProblemDeatil(reportForm.getProblem_id());
		ReportProblemDomain rp = repServ.updateFeedbackMaster(reportForm, list, request);
		
		
	
		//CODE FOR REPLY TO BE ADDED
		
		String subject = emailContent.getEmailContent().get("pharmaexcilfeedbackresponseSubject");
		String content = emailContent.getEmailContent().get("pharmaexcilfeedbackresponseContent");
		content = content.replaceAll("\\$USER\\_NAME\\$", rp.getUser_name());
		content = content.replaceAll("\\$Remarks\\_res\\$", rp.getStrReply());
		content = content.replaceAll("\\$report\\_id\\$", rp.getProblem_no());
		

		
		
		// sendmail.transferToMailServer(registrationForm.getUserName(), "Your
		// registration is approved.", "Reason for your Approval is
		// "+registrationForm.getStrReason()+ " and Your Code is "+code);

		boolean result1 = sendmail.sendMailToUser(rp.getEmail_id(), subject, content);

		/*
		 * davaServices.addDataToEmailMst("Feeback Pharmexcil Reply Process", request);
		 * 
		 * davaServices.addEmailDetailsToDb(reportForm.getProblem_id(),reportForm.
		 * getUser_name(), "Response to your.", "feedback is " +
		 * reportForm.getStrRemarks() + "  Your Reference Number is " + code, request);
		 * 
		 * 
		 * 
		 */
		
		attr.addFlashAttribute("flagUpdate", 1);
		System.out.println(rp);
		res = "redirect:/FeedbackResponse";
		return res;

	}
	
	@RequestMapping(value = "/updateFeedbackMstCDACRem", method = RequestMethod.POST)
	public String updateFeedbackMstCDACRem(@ModelAttribute("reportProblemForm") ReportProblemForm reportForm,
			BindingResult result, HttpServletRequest request, RedirectAttributes attr) {

		System.out.println("IN Testing ACTION");
		String res = "";
		System.out.println(reportForm.getProblem_id());
		List<ReportProblemDomain> list = davaServices.getProblemDeatil(reportForm.getProblem_id());
		
		
		attr.addFlashAttribute("flagCDACUpdate", 1);
	//	System.out.println(rp);
		
		String emailFeedbackResponseByCDACSubject=emailContent.getEmailContent().get("emailFeedbackResponseByCDACSubject");//PROB_NO
		String emailFeedbackResponseByCDACContent=emailContent.getEmailContent().get("emailFeedbackResponseByCDACContent");
		   
		/*
		 * String IssueType = null; if(reportForm.getCdacIssueType()==1) IssueType =
		 * "Guidance"; else if(reportForm.getCdacIssueType()==2) IssueType =
		 * "Software Related"; else if(reportForm.getCdacIssueType()==3) IssueType =
		 * "Solution Provider Related"; else if(reportForm.getCdacIssueType()==4)
		 * IssueType = "Other";
		 */
		emailFeedbackResponseByCDACContent=emailFeedbackResponseByCDACContent.replaceAll("\\$USER\\_NAME\\$",list.get(0).getUser_name());
	//	emailFeedbackResponseByCDACContent=emailFeedbackResponseByCDACContent.replaceAll("\\$ISSUE\\_TYPE\\$",IssueType);
		//emailFeedbackResponseByCDACContent=emailFeedbackResponseByCDACContent.replaceAll("\\$CDAC\\_REPLY\\$",reportForm.getCdacRemarks());
		emailFeedbackResponseByCDACContent=emailFeedbackResponseByCDACContent.replaceAll("\\$PROB\\_NO\\$",list.get(0).getProblem_no());
		emailFeedbackResponseByCDACContent=emailFeedbackResponseByCDACContent.replaceAll("\\$Subject\\_id\\$",list.get(0).getSubject());
		emailFeedbackResponseByCDACContent=emailFeedbackResponseByCDACContent.replaceAll("\\$PROB\\_id\\$",list.get(0).getProblem());
		emailFeedbackResponseByCDACContent=emailFeedbackResponseByCDACContent.replaceAll("\\$email\\_id\\$",list.get(0).getEmail_id());
		emailFeedbackResponseByCDACContent=emailFeedbackResponseByCDACContent.replaceAll("\\$org\\_name\\$",list.get(0).getOrg_name());
		
		
	//	ReportProblemDomain rp = repServ.updateFeedbackMasterForCDAC(reportForm, list, request);
		
		
	//	sendmail.sendMailToUser(list.get(0).getEmail_id(),emailFeedbackResponseByCDACSubject,emailFeedbackResponseByCDACContent);
		sendmail.sendMailToUser("support@iveda-india.in",emailFeedbackResponseByCDACSubject,emailFeedbackResponseByCDACContent);
		//sendmail.sendMailToUser("harshitadhaundiyal@cdac.in",emailFeedbackResponseByCDACSubject,emailFeedbackResponseByCDACContent);
		//sendmail.sendMailToUser("harshitadhaundiyal@cdac.in",emailFeedbackResponseByCDACSubject,emailFeedbackResponseByCDACContent);
		
		
		ReportProblemDomain rp = repServ.updateFeedbackMasterForCDAC(reportForm, list, request);
		
		res = "redirect:/FeedbackResponse";
		return res;

	}
	
	@RequestMapping(value = "/updateProblemStatusFeedbackMst", method = RequestMethod.POST)
	public String updateProblemStatusFeedbackMst(@ModelAttribute("reportProblemForm") ReportProblemForm reportForm, BindingResult result, HttpServletRequest request, RedirectAttributes attr) {

		System.out.println("IN Testing ACTION");
		String res = "";
		System.out.println(reportForm.getProblem_id());
		List<ReportProblemDomain> list = davaServices.getProblemDeatil(reportForm.getProblem_id());
		ReportProblemDomain rp = repServ.updateFeedbackMasterProblemStatus(reportForm, list, request);
		
		res = "redirect:/FeedbackResponse";
		return res;

	}

	@GetMapping("/loadFeedbackReply")
	public ResponseEntity<List<ReportProblemDomain>> getFeedbackData(@RequestParam("problemId") Integer problemId) {
		List<ReportProblemDomain> feedback = repServ.getFeedbackData(problemId);
		return new ResponseEntity<List<ReportProblemDomain>>(feedback, HttpStatus.OK);
	}
	
	@PostMapping("/saveReportProblem")
	public @ResponseBody String saveReportType1( @RequestBody ReportProblemForm2 reportForm2, @ModelAttribute("reportProblemForm") ReportProblemForm reportForm,HttpServletRequest request,@ModelAttribute("registrationForm") RegistrationForm registrationForm ) {
		
		 String response = "success";
		
		
		System.err.println("data recived :: "+reportForm2);
		
		 
		 ReportProblemDomain rp= new ReportProblemDomain();
		// ReportProblemDomain prob= repServ.addReportProblem(rp);
		 
		 
		 rp = repServ.addReportMaster(reportForm2);
		 
		    Long userId = registrationForm.getUserId();
			String userName = registrationForm.getUserName();
		 
		 List<ReportProblemDomain> list = davaServices.getProblemDeatil(rp.getProblem_id());

		 System.out.println(rp.getEmail_id());
		
		//	sendmail.transferToMailServer(rp.getEmail_id(), "Issue Id of problem",
		//			"Your Issue ID Is 2020/" + rp.getProblem_id());
			
			
		
		
		  String emailVerificationSubject=emailContent.getEmailContent().get("emailSubjectForReportProbAPI");
		  String emailVerificationContent=emailContent.getEmailContent().get("emailContentForReportProbAPI");
		  
		  emailVerificationContent=emailVerificationContent.replaceAll( "\\$PROBLEN\\_NO\\$", "2020/"+rp.getProblem_id());
		  sendmail.sendMailToUser(rp.getEmail_id(), emailVerificationSubject, emailVerificationContent);
		 
			

			//davaServices.addDataToEmailMst("Issue Id of problem", request);
			
			
			//davaServices.addEmailDetailsToDb(userId, userName, "Issue Id of problem", "Your Issue ID Is 2020/" + rp.getProblem_id(), request);

		/*
		 * davaServices.addEmailDetailsToDb(userId, userName, "Issue Id of problem",
		 * "Your Issue ID Is 2020/" + rp.getProblem_id(), request);
		 */
		return response;
	}

}
