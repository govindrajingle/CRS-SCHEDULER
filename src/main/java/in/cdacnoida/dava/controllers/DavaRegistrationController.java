package in.cdacnoida.dava.controllers;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowagie.text.pdf.PdfReader;

import in.cdacnoida.dava.daoimpl.DaoHelper;
import in.cdacnoida.dava.daoservice.DavaDaoServices;
import in.cdacnoida.dava.daoservice.GenJasperService;
import in.cdacnoida.dava.daoservice.LocationMasterDaoService;
import in.cdacnoida.dava.entities.AppUserLogs;
import in.cdacnoida.dava.entities.ApplicantTypeMasterDomain;
import in.cdacnoida.dava.entities.ApprovalPremisesDetail;
import in.cdacnoida.dava.entities.ApprovalTypeMst;
import in.cdacnoida.dava.entities.CodeRequestMstDomain;
import in.cdacnoida.dava.entities.CountryMst;
import in.cdacnoida.dava.entities.DistrictMst;
import in.cdacnoida.dava.entities.DrugDosageMst;
import in.cdacnoida.dava.entities.DrugMonographMst;
import in.cdacnoida.dava.entities.DrugMst;
import in.cdacnoida.dava.entities.DrugScheduleMst;
import in.cdacnoida.dava.entities.DrugTypeMst;
import in.cdacnoida.dava.entities.HSCodeDomain;
import in.cdacnoida.dava.entities.InstPremiseDtlDomain;
import in.cdacnoida.dava.entities.InstituteMasterDomain;
import in.cdacnoida.dava.entities.InstituteMemberDetailDomain;
import in.cdacnoida.dava.entities.InstituteTypeMasterDomain;
import in.cdacnoida.dava.entities.LicPremiseDtlDomain;
import in.cdacnoida.dava.entities.LicenseTypeMstDomain;
import in.cdacnoida.dava.entities.LocationMasterDomain;
import in.cdacnoida.dava.entities.MemberTypeMasterDomain;
import in.cdacnoida.dava.entities.NewsEventMstDomain;
import in.cdacnoida.dava.entities.NewsEventsDomain;
import in.cdacnoida.dava.entities.PackUnitMst;
import in.cdacnoida.dava.entities.PasswordHistory;
import in.cdacnoida.dava.entities.PointOfDistributionMst;
import in.cdacnoida.dava.entities.PortOfExportDomain;
import in.cdacnoida.dava.entities.PromotionCouncilMaster;
import in.cdacnoida.dava.entities.RegionMstDomain;
import in.cdacnoida.dava.entities.RegistrationDetails;
import in.cdacnoida.dava.entities.ReportProblemDomain;
import in.cdacnoida.dava.entities.RoleMaster;
import in.cdacnoida.dava.entities.SiteTypeMstDomain;
import in.cdacnoida.dava.entities.StatesMst;
import in.cdacnoida.dava.entities.StorageCondMstDom;
import in.cdacnoida.dava.entities.TherepueticClassDom;
import in.cdacnoida.dava.entities.ZoneMst;
import in.cdacnoida.dava.misc.SMSHttpPostClient;
import in.cdacnoida.dava.misc.ValidationGroups.DrugDetails;
import in.cdacnoida.dava.misc.ValidationGroups.ManufacturingSiteDetails;
import in.cdacnoida.dava.misc.ValidationGroups.MemberDetails;
import in.cdacnoida.dava.model.AboutUsModel;
import in.cdacnoida.dava.model.DrugDtlsModel;
import in.cdacnoida.dava.model.EmailDetailForm;
import in.cdacnoida.dava.model.GeneratePackModel;
import in.cdacnoida.dava.model.LoginBean;
import in.cdacnoida.dava.model.MemberAddDtlModel;
import in.cdacnoida.dava.model.MemberDetailForm;
import in.cdacnoida.dava.model.NewsEventsModel;
import in.cdacnoida.dava.model.OffRegModel;
import in.cdacnoida.dava.model.PointOfDistributionModel;
import in.cdacnoida.dava.model.PortOfExportModel;
import in.cdacnoida.dava.model.RegistrationForm;
import in.cdacnoida.dava.model.SolrSearchModel;
import in.cdacnoida.dava.model.UploadDataForm;
import in.cdacnoida.dava.service.DataEncoderService;
import in.cdacnoida.dava.service.DavaServices;
import in.cdacnoida.dava.service.GlobalService;
import in.cdacnoida.dava.service.PointsOfDisService;
import in.cdacnoida.dava.springsecurity.LoggedInUserSession;
import in.cdacnoida.dava.transactions.InstPremiseDtlRepository;
import in.cdacnoida.dava.transactions.UserRepository;
import in.cdacnoida.dava.util.Captcha;
import in.cdacnoida.dava.util.DataEncoder;
import in.cdacnoida.dava.util.DynamicHomepage;
import in.cdacnoida.dava.util.FileValidation;
import in.cdacnoida.dava.util.FtpConnection;
import in.cdacnoida.dava.util.Sendmail;
import in.cdacnoida.davaconfig.EmailContent;
import in.cdacnoida.davaconfig.FileUploadingPath;
import in.cdacnoida.davaconfig.FtpDetailsProperties;
//added by harshita on 150723	
import sun.misc.BASE64Encoder;

@Controller
public class DavaRegistrationController {

	@Autowired
	private GlobalAction fileServices;

	@Autowired
	private DavaServices davaServices;

	@Autowired
	private Sendmail sendmail;

	@Autowired
	private DaoHelper daoHelper;

	@Autowired
	private Captcha captcha;

	@Autowired
	public LocationMasterDaoService locDao;

	@Autowired
	public DavaDaoServices davaDao;

	@Autowired
	private DataEncoderService encodedservice;

	@Autowired
	private FileValidation fileValidation;

	@Autowired
	private FtpDetailsProperties ftpProps;

	@Autowired
	private LoggedInUserSession userData;

	@Autowired
	GlobalService gService;

	@Autowired
	private FtpService ftpService;

	@Autowired
	private FtpConnection connection;

	@Value("${JRXML_PATH}")
	String JRXML_PATH;

	@Autowired
	private FileUploadingPath fileUploadingPath;

	@Autowired
	private DynamicHomepage dynamicHomepage;

	@Autowired
	private EmailContent emailContent;

	@Autowired
	public PointsOfDisService podServ;

	@Value("${projectUrl}")
	String projectUrl;

	@Autowired
	public GenJasperService genJasperService;

	@Autowired
	UserRepository userRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(DavaRegistrationController.class);

	@GetMapping("/getRcmcNumberStatus")
	public @ResponseBody String getRcmcNumberStatus(@RequestParam("rcmcNumber") String rcmcNumber) {
		String result = "invalidRcmcNumber";
		RegistrationForm registrationForm = davaServices.getRcmcData(rcmcNumber.trim());
		String alreadyRegisteredWithNumber = davaServices.checkAlreadtRegWithNumber(rcmcNumber.trim());
		if (registrationForm.getApplicantType() != null)
			result = "validRcmcNumber";
		if (alreadyRegisteredWithNumber.equalsIgnoreCase("alreadyRegistered"))
			result = "alreadyRegistered";
		return result;
	}

	// This Method is used to get RCMC registration Page
	@GetMapping("/rcmcRegistration")
	public ModelAndView getRcmcRegistrationPage(@ModelAttribute("registrationForm") RegistrationForm registrationForm,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		List<ApplicantTypeMasterDomain> appType = davaServices.getApplicantTypeList();
		request.setAttribute("appType", appType);
		LoginBean loginBean = new LoginBean();
		mv.addObject("generatedCaptcha", request.getSession().getAttribute("captcha"));
		mv.addObject("loginBean", loginBean);
		mv.setViewName("getRcmcRegistrationPage");
		return mv;
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

	public String encode(String str) {
		BASE64Encoder encoder = new

		BASE64Encoder();
		str = new String(encoder.encodeBuffer(str.getBytes()));
		return str;
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

	// This method is used to get the registration page with country names
	@PostMapping("/getregistration")
	public ModelAndView getRegistrationPage(@ModelAttribute("registrationForm") RegistrationForm registrationForm,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		// RegistrationForm registrationForm=new RegistrationForm();
		String rcmcNumber = request.getParameter("rcmcNumber");
		String registeredWithRcmc = request.getParameter("registeredWithRcmc");
		String applicant_type = registrationForm.getApplicantType();
		mv.addObject("editableStatus", false);
		if (!registeredWithRcmc.equals("") && !rcmcNumber.equals("")) {
			registrationForm = davaServices.getRcmcData(rcmcNumber.trim());
			registrationForm.setApplicantType(applicant_type);
			registrationForm.setStr_rcmc_fieo_no(rcmcNumber);
			registrationForm.setNumRcmcFlag(1);
			List<StatesMst> ManfstatesNames = davaServices.getStatedata(registrationForm.getManfCountryId());
			List<StatesMst> OrgstatesNames = davaServices.getStatedata(registrationForm.getOrgCountryId());
			List<DistrictMst> ManfdistrictNames = davaServices.getDistrictNames(registrationForm.getManfStateId());
			List<DistrictMst> OrgdistrictNames = davaServices.getDistrictNames(registrationForm.getOrgStateId());
			mv.addObject("iecIssueDate", formattedDate(registrationForm.getIecIssueDate()));
			mv.addObject("ssiIssueDate", formattedDate(registrationForm.getSsiIssueDate()));
			mv.addObject("ManfstatesNames", ManfstatesNames);
			mv.addObject("OrgstatesNames", OrgstatesNames);
			mv.addObject("ManfdistrictNames", ManfdistrictNames);
			mv.addObject("OrgdistrictNames", OrgdistrictNames);
			mv.addObject("editableStatus", true);

		}
		if (!registeredWithRcmc.equals("") && !rcmcNumber.equals(""))
			mv.addObject("registeredWithRcmc", true);
		else
			mv.addObject("registeredWithRcmc", false);

		registrationForm.setNumRcmcFlag(0);
		LOGGER.info("rcmc registration data {}", registrationForm);

		String generatedCaptcha = captcha.getCaptcha();
		HttpSession session = request.getSession(false);
		session.setAttribute("registrationCaptcha", generatedCaptcha);
		// Added By Deepshikha
		List<ApplicantTypeMasterDomain> appType = davaServices.getApplicantTypeList();
		request.setAttribute("appType", appType);

		List<PromotionCouncilMaster> promotionCouncilList = davaServices.getPromotionCouncil();
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = null;
		try {
			jsonArray = mapper.writeValueAsString(promotionCouncilList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("Java to Json  {} ", jsonArray);

		String applicantTypeData = "";
		if (applicant_type.equals("100"))
			applicantTypeData = "Manufacturer";
		else
			applicantTypeData = "Exporter's";

		// getting State Data
		List<CountryMst> countryMst = davaServices.getCountryNames();
		mv.addObject("countryMst", countryMst);
		mv.addObject("registrationForm", registrationForm);
		mv.addObject("appTypeJson", jsonArray);
		mv.addObject("registrationCaptcha", generatedCaptcha);
		mv.addObject("councilList", promotionCouncilList);
		request.getSession().setAttribute("numUserTypeId", registrationForm.getNumUserTypeId());
		LoginBean loginBean = new LoginBean();
		mv.addObject("loginBean", loginBean);
		mv.addObject("generatedCaptcha", request.getSession().getAttribute("captcha"));
		mv.setViewName("davaRegistration");
		return mv;
	}

	@PostMapping("/forgotPassword")
	public ModelAndView forgotPassword(@ModelAttribute("loginBean") LoginBean loginBean, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView();

		if (loginBean.getFusername() != null && !loginBean.getFusername().equals("")) {
			/*
			 * String username1 = loginBean.getFusername().trim();
			 * System.out.println("username1::" + username1); byte[] Encodedusername1 =
			 * Base64.getDecoder().decode(username1); String EU1 = new
			 * String(Encodedusername1); System.out.println("encodedusername1::" +
			 * Encodedusername1); StringBuffer reversedStringBuffer1 = new
			 * StringBuffer(EU1); reversedStringBuffer1.reverse();
			 * System.out.println("reversedStringBuffer::" + reversedStringBuffer1); String
			 * EN2 = new String(reversedStringBuffer1); System.out.println("EN2::" + EN2);
			 * byte[] EN3 = Base64.getDecoder().decode(EN2); String EN4 = new String(EN3);
			 */

			String username = loginBean.getFusername().trim();

			/*
			 * byte[] byteValueBase64Decoded =
			 * Base64.getDecoder().decode(username.getBytes()); byteValueBase64Decoded =
			 * Base64.getDecoder().decode(byteValueBase64Decoded); byteValueBase64Decoded =
			 * Base64.getDecoder().decode(byteValueBase64Decoded); String
			 * stringValueBase64Decoded = new String(byteValueBase64Decoded);
			 */

			System.out.println(" User ID" + username);
			RegistrationDetails registrationDetails = userRepository.findByUserName(username);

			// Encode the String

			if (registrationDetails != null) {

				// added by harshita

				Random random = new Random(System.nanoTime() % 100000);
				int randomCode = random.nextInt(1000000000);
				registrationDetails.setRandomNumber(randomCode);

				String Username = registrationDetails.getUserName().toLowerCase();
				System.out.println("Username::" + Username);
				String encodedusername = encode(Username);
				System.out.println("encodedusername::" + encodedusername);
				String encodedusernameR = reverse(encodedusername);
				System.out.println("encodedusernameR::" + encodedusernameR.trim());
				String encodedusername2 = encode(encodedusernameR);
				System.out.println("encodedusername2::" + encodedusername2);

				Long userId = registrationDetails.getUserId();

				// String
				// encodedMail=DataEncoder.encode(registrationDetails.getUserName().toLowerCase()+"###egov");

				/*
				 * String
				 * encodedMail=DataEncoder.encode(registrationDetails.getUserName().toLowerCase(
				 * )+"&randomNumber="+registrationDetails.getRandomNumber()); String
				 * updatePasswordLink=projectUrl+request.getContextPath()+
				 * "/updatePassword?details="+encodedMail;
				 */

				String updatePasswordLink = projectUrl + request.getContextPath() + "/updatePassword?details="
						+ encodedusername2 + "&randomNumber=" + registrationDetails.getRandomNumber();

				// Added by Govind
				LocalDateTime expirationTime = LocalDateTime.now().plusHours(1);
				registrationDetails.setExpirationTime(expirationTime);
				userRepository.save(registrationDetails);
				System.out.println("Expiration Time of Password Link :: " + expirationTime);

				/*
				 * String updatePasswordLink = projectUrl + request.getContextPath() +
				 * "/updatePassword?details=" +
				 * DataEncoder.encode(registrationDetails.getUserName().toLowerCase()) +
				 * "&randomNumber=" + registrationDetails.getRandomNumber();
				 */

				String subject = emailContent.getEmailContent().get("forgotPasswordSubject");
				String content = emailContent.getEmailContent().get("forgotPasswordContent");
				content = content.replaceAll("\\$USER\\_NAME\\$", registrationDetails.getOrgName());
				content = content.replaceAll("\\$URL\\_LINK\\$", updatePasswordLink);

				// sendmail.sendEmailToUser(registrationDetails.getUserName(),
				// updatePasswordLink);

				String result1 = daoHelper.getcount("username_sendmailcount", registrationDetails.getUserName());

				int mailcount = Integer.parseInt(result1);

				// System.out.println("iVEDA" + "" + result1 +
				// registrationDetails.getUserName());

				if (mailcount <= 4) {

					boolean result = sendmail.sendMailToUser(registrationDetails.getUserName(), subject, content);

					davaServices.addDataToEmailMst("Update Password Process", request);

					davaServices.addEmailDetailsToDb(userId, registrationDetails.getUserName(), "Update Password Link",
							updatePasswordLink, request);

					if (!result)
						redirectAttributes.addFlashAttribute("registrationStatus",
								"Error Occured while sending the mail , please try again or contact Pharmaexcil");
					else
						redirectAttributes.addFlashAttribute("registrationStatus",
								"Password updation link is successfully sent to your registered email id");

					redirectAttributes.addFlashAttribute("registrationSuccessful", true);

				}

				else {

					request.getSession().setAttribute("error",
							"Your reset password limit has exceeded, Kindly contact admin for any queries");

				}

			} else {

				redirectAttributes.addFlashAttribute("registrationStatus",
						"Password updation link is successfully sent to your registered email id");

				redirectAttributes.addFlashAttribute("registrationSuccessful", true);

				/* request.getSession().setAttribute("error", "Not a registered user"); */
			}
		} else {
			redirectAttributes.addFlashAttribute("registrationStatus",
					"Password updation link is successfully sent to your registered email id");

			redirectAttributes.addFlashAttribute("registrationSuccessful", true);

			/*
			 * request.getSession().setAttribute("error",
			 * "Please enter valid email address");
			 */
		}
		mv.setViewName("redirect:/login");
		return mv;
	}

	@GetMapping("/updatePassword")
	public ModelAndView updatePassword(@RequestParam("details") String email,
			@RequestParam("randomNumber") String Str_randomNumber, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String decodedMail = decode(email);

		System.out.println("decodedMail::::::" + decodedMail);
		String decodedMail1 = reverse(decodedMail);
		System.out.println("decodedMail1::::::" + decodedMail1);
		String decodedMail2 = decode(decodedMail1);

		System.out.println("decodedMail2::::::" + decodedMail2);
		// String decodedMail = DataEncoder.decode(email);

		System.out.println("decodedMail::::::" + decodedMail);
		String[] details = decodedMail2.split("&");
		System.out.println("details::::::" + details);

		System.out.println("randomNumber::::::" + Str_randomNumber);

		int randomNumber = 0;
		try {
			randomNumber = Integer.parseInt(Str_randomNumber);
			if (details != null && details.length == 1) {// 1st
				/* if(details!=null && details.length==2 && details[1].equals("egov")) { */
				String userName = details[0];
				LocalDateTime dbExpirationTime = userRepository.findExpirationTimeByUsername(userName);

				if (dbExpirationTime != null) {// nth
					LocalDateTime currentTime = LocalDateTime.now();

					if (currentTime.isBefore(dbExpirationTime) || currentTime.isEqual(dbExpirationTime)) {// jth

						RegistrationDetails registrationDetails1 = userRepository
								.findByRandomNumberAndUserName(userName.trim().toLowerCase(), randomNumber);

						if (registrationDetails1 != null) {// 2nd
							RegistrationDetails registrationDetails = userRepository
									.findByUserName(userName.trim().toLowerCase());
							if (registrationDetails != null) {// 3rd
								LoginBean loginBean = new LoginBean();
								mv.addObject("loginBean", loginBean);
								RegistrationForm registrationForm = new RegistrationForm();
								mv.addObject("registrationForm", registrationForm);
								mv.addObject("userName", registrationDetails.getUserName());
								mv.setViewName("updatePasswordPage");
							} // 3rd if block

							else {
								request.getSession().setAttribute("error", "Not a registered user");
								mv.setViewName("redirect:/login");
							}
						} // 2nd if block
						else {
							request.getSession().setAttribute("error", "Email link is expired.");
							mv.setViewName("redirect:/login");
						}
					} // jth
					else {
						request.getSession().setAttribute("error", "Email link is expired.");
						mv.setViewName("redirect:/login");
					}
				} // nth
				else {
					request.getSession().setAttribute("error", "Email link is expired.");
					mv.setViewName("redirect:/login");
				}

			} // 1st if block
			else {
				request.getSession().setAttribute("error", "Not a registered user");
				mv.setViewName("redirect:/login");
			}
		} // try block ended
		catch (NumberFormatException e) {

			request.getSession().setAttribute("error", "Not a valid request");
			mv.setViewName("redirect:/login");

		} catch (Exception e) {
			request.getSession().setAttribute("error", "Not a valid request");
			mv.setViewName("redirect:/login");
		}

		return mv;
	}

	@GetMapping("/changePassword")
	public ModelAndView updatePassword(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		if (userName != null) {
			RegistrationDetails registrationDetails = userRepository.findByUserName(userName);
			if (registrationDetails != null) {
				LoginBean loginBean = new LoginBean();
				mv.addObject("loginBean", loginBean);
				RegistrationForm registrationForm = new RegistrationForm();
				mv.addObject("registrationForm", registrationForm);
				mv.addObject("userName", registrationDetails.getUserName());
				mv.setViewName("changePassword");
			}
		}
		return mv;
	}

	@PostMapping("/changePassword")
	public ModelAndView changePassword(@ModelAttribute("registrationForm") RegistrationForm registrationForm,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView();

		// byte[] decoded;
		// byte[] decoded2;
		// byte[] decoded3;
		// byte[] decoded4;

		try {

			String pwd = registrationForm.getPassword();
			System.out.println("pwd::::::" + pwd);

			byte[] decodedBytes = Base64.getDecoder().decode(pwd);

			String decodedString = new String(decodedBytes);

			// System.out.println("decodedString::::::" + decodedString);
			StringBuffer reversedStringBuffer = new StringBuffer(decodedString);

			reversedStringBuffer.reverse(); // reversing string

			// System.out.println("reversedStringBuffer::" + reversedStringBuffer);

			String value1 = new String(reversedStringBuffer);

			// System.out.println("value1::" + reversedStringBuffer);

			byte[] decodedBytes2 = Base64.getDecoder().decode(value1);

			String value4 = new String(decodedBytes2);

			System.out.println("value4::" + value4);

			String[] temp = value4.split(" ### ");
			System.out.println("temp::" + temp);

			if (temp.length == 4) {
				// System.out.println("temp.length::" + temp.length);
				registrationForm.setPassword(temp[1].trim());
				// System.out.println(temp[1].trim());
				registrationForm.setOldPassword(temp[2].trim());
				// System.out.println(temp[2].trim());

			} else {
				throw new Exception("Invalid Password Exception");
			}
		} catch (Exception e) {

		}

		RegistrationDetails registrationDetails = userRepository.findByUserName(registrationForm.getUserName());
		List<PasswordHistory> passwordList = registrationDetails.getPasswordHistory();

		if (!davaServices.checkIfValidOldPassword(registrationDetails, registrationForm.getOldPassword())) {
			// throw new InvalidOldPasswordException();
			request.setAttribute("message", "Invalid Old password");
			request.setAttribute("registrationSuccessful", false);
			mv.setViewName("changePassword");
		} else if (registrationForm.getPassword().equalsIgnoreCase(registrationForm.getOldPassword())) {
			request.setAttribute("message", "Old and New password cannot be same");
			request.setAttribute("registrationSuccessful", false);
			mv.setViewName("changePassword");
		} else if (!davaServices.checkPasswordHistory(passwordList, registrationForm.getPassword())) {
			request.setAttribute("message", "You cannot enter password which is previously used");
			request.setAttribute("registrationSuccessful", false);
			mv.setViewName("changePassword");
		} else {
			boolean status = davaServices.updatePasswordcnf(registrationForm);

			if (status) {
				request.setAttribute("message", "Password updated successfuly");
				request.setAttribute("registrationSuccessful", true);

			} else {
				request.setAttribute("registrationSuccessful", false);
				request.setAttribute("message", "Error in updating password");
			}
			mv.setViewName("changePassword");

		}

		return mv;
	}

	@PostMapping("/updatePassword")
	public ModelAndView updatePasswordcnf(@ModelAttribute("registrationForm") RegistrationForm registrationForm,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView();

		try {

			String pwd = registrationForm.getPassword();
			// System.out.println("pwd::::::" + pwd);

			byte[] decodedBytes = Base64.getDecoder().decode(pwd);

			String decodedString = new String(decodedBytes);

			// System.out.println("decodedString::::::" + decodedString);
			StringBuffer reversedStringBuffer = new StringBuffer(decodedString);

			reversedStringBuffer.reverse(); // reversing string

			// System.out.println("reversedStringBuffer::" + reversedStringBuffer);

			String value1 = new String(reversedStringBuffer);

			// System.out.println("value1::" + reversedStringBuffer);

			byte[] decodedBytes2 = Base64.getDecoder().decode(value1);

			String value4 = new String(decodedBytes2);

			// System.out.println("value4::" + value4);

			/*
			 * 
			 * 
			 * 
			 * byte[] decoded; byte[] decoded2; byte[] decoded3; byte[] decoded4; String
			 * value="";
			 * 
			 * try { decoded = new
			 * BASE64Decoder().decodeBuffer(registrationForm.getPassword()); value =new
			 * String(decoded);
			 * 
			 * decoded2 = new BASE64Decoder().decodeBuffer(value); String value2 =new
			 * String(decoded2);
			 * 
			 * decoded3 = new BASE64Decoder().decodeBuffer(value2); String value3 =new
			 * String(decoded3);
			 * 
			 * decoded4 = new BASE64Decoder().decodeBuffer(value3); String value4 =new
			 * String(decoded4);
			 */
			String[] temp = value4.split(" ### ");
			System.out.println("temp::" + temp);
			if (temp.length == 3) {
				registrationForm.setPassword(temp[1].trim());
				System.out.println(temp[1].trim());
				registrationForm.setRandomCode(0);

			} else {
				throw new Exception("Invalid Password Exception");
			}
		} catch (Exception e) {

		}

		RegistrationDetails registrationDetails = userRepository.findByUserName(registrationForm.getUserName());
		List<PasswordHistory> passwordList = registrationDetails.getPasswordHistory();
		if (!davaServices.checkPasswordHistory(passwordList, registrationForm.getPassword())) {
			request.getSession().setAttribute("error", "You cannot enter password which is previously used");
		} else {
			boolean status = davaServices.updatePasswordcnf(registrationForm);
			if (status) {
				redirectAttributes.addFlashAttribute("registrationStatus", "Password updated successfuly");
				redirectAttributes.addFlashAttribute("registrationSuccessful", true);
				// add SMS code when password is updated

				// String templateid = "1007165521077469819";
				/*
				 * try { String mobile = registrationForm.getContPerMobileNo(); String username
				 * = registrationForm.getContactPersonName(); String emailId =
				 * registrationForm.getUserName();
				 * 
				 * System.out.println("mob====" + mobile+"username"+username+"emailId"+emailId);
				 * 
				 * String smsContent = "Dear"+ username +
				 * "Your password has been successfully changed - iVEDA Support team";
				 * 
				 * System.out.println("sms_content--->" + smsContent + "mobile no=" + mobile);
				 * 
				 * SMSHttpPostClient.sendSingleSmsWithTempId(mobile + "", smsContent,
				 * templateid); } catch (Exception e) { e.printStackTrace();
				 * 
				 * }
				 */

			} else {
				request.getSession().setAttribute("error", "Error in updating password");
			}
		}

		mv.setViewName("redirect:/login");
		return mv;
	}

	// this method is used to check given IEC number is already registered with some
	// other company
	@GetMapping("/checkIecNumber")
	public @ResponseBody String checkIecNumber(@RequestParam("iecNumber") String iecNumber) {
		return davaServices.checkIecNumber(iecNumber);
	}

	// this method is used to check GSTN number, whether given GSTN Number is
	// already present in dtabase or not
	@GetMapping("/checkGstnNumber")
	public @ResponseBody String checkGstnNumber(@RequestParam("gstnNumber") String gstnNumber) {
		return davaServices.checkGstnNumber(gstnNumber);
	}

	// This method is used to save the registration details
	@PostMapping("/registration")
	public ModelAndView saveRegistrationData(@ModelAttribute("registrationForm") RegistrationForm registrationForm,
			RedirectAttributes redirectAttributes, HttpServletRequest request) throws Exception {

		ModelAndView mv = new ModelAndView();
		// System.out.println("hppdata:::::" + registrationForm.getHppGeneratedData());
		// System.out.println("getHppGeneratedData:::::" +
		// request.getParameter("hppGeneratedData"));
		// System.out.println("hashValue:::::" + request.getParameter("hashValue"));

		String username1 = registrationForm.getUserName();
		// System.out.println("username1::::" + username1);
		byte[] Encodedusername1 = Base64.getDecoder().decode(username1);
		String EU1 = new String(Encodedusername1);
		// System.out.println("encodedusername1::" + Encodedusername1);
		StringBuffer reversedStringBuffer1 = new StringBuffer(EU1);
		reversedStringBuffer1.reverse();
		// System.out.println("reversedStringBuffer::" + reversedStringBuffer1);
		String EN2 = new String(reversedStringBuffer1);
		// System.out.println("EN2::" + EN2);
		byte[] EN3 = Base64.getDecoder().decode(EN2);
		String username = new String(EN3);
		// System.out.println("username::" + username);
		registrationForm.setUserName(username);

		HttpSession session = request.getSession(false);
		String exceptionMessage = "";
		RegistrationDetails userRegDomain = null;

		MultipartFile file = registrationForm.getAddressProofFile();
		MultipartFile drugLicence = registrationForm.getDrugLicence();

		// System.out.println("file::" + file);
		// System.out.println("drugLicence::" + drugLicence);
		// This code is used to validate the bean coming in request using JSR 380 API
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<RegistrationForm>> violations = validator.validate(registrationForm);
		PdfReader document = null;
		for (ConstraintViolation<RegistrationForm> violation : violations) {
			LOGGER.error("Server Side Validation Exception in RegistrationForm :" + violation.getMessage());
			exceptionMessage = violation.getMessage();
			break;
		}
		boolean fileValidationResult = fileValidation.validatePdfFile(file);
		boolean fileValidationResult2 = false;
		boolean fileValidationResult3 = false;
		// System.out.println("fileValidationResult:::" + fileValidationResult);
		String addressFileHash = request.getParameter("addressProofDocument");
		// System.out.println("addressProofDocument::" + addressFileHash);
		boolean fileValidationResult1 = fileValidation.validateAddressFileContent(file, addressFileHash);
		if (registrationForm.getApplicantType().equals("101")) {
			fileValidationResult2 = fileValidation.validatePdfFile(drugLicence);
			String drugFileHash = request.getParameter("drugLiecenseDocument");
			fileValidationResult3 = fileValidation.validateDrugFileContent(drugLicence, drugFileHash);
		}

		String registrationCaptcha = session.getAttribute("registrationCaptcha").toString();
		if ((!fileValidationResult)
				|| registrationCaptcha != null && !registrationCaptcha.equals(registrationForm.getRegCaptcha())) {
			if (!fileValidationResult) {
				redirectAttributes.addFlashAttribute("fileValidException", true);
			}
			String encodedPanno = registrationForm.getOrgPanNumber();
			String decodedPan = decode(encodedPanno);
			String decodePanR = reverse(decodedPan);
			String decodedPan2 = decode(decodePanR);
			registrationForm.setOrgPanNumber(decodedPan2);

			// this code is for invalid captcha
			String generatedCaptcha = captcha.getCaptcha();
			session.setAttribute("registrationCaptcha", generatedCaptcha);
			redirectAttributes.addFlashAttribute("registrationStatus", true);
			List<CountryMst> countryMst = davaServices.getCountryNames();
			List<StatesMst> ManfstatesNames = davaServices.getStatedata(registrationForm.getManfCountryId());
			List<StatesMst> OrgstatesNames = davaServices.getStatedata(registrationForm.getOrgCountryId());
			List<DistrictMst> ManfdistrictNames = davaServices.getDistrictNames(registrationForm.getManfStateId());
			List<DistrictMst> OrgdistrictNames = davaServices.getDistrictNames(registrationForm.getOrgStateId());
			registrationForm.setRegCaptcha("");
			registrationForm.setPassword("");
			mv.addObject("countryMst", countryMst);
			mv.addObject("registrationForm", registrationForm);
			mv.addObject("registrationCaptcha", generatedCaptcha);
			mv.addObject("ManfstatesNames", ManfstatesNames);
			mv.addObject("OrgstatesNames", OrgstatesNames);
			mv.addObject("ManfdistrictNames", ManfdistrictNames);
			mv.addObject("OrgdistrictNames", OrgdistrictNames);
			mv.addObject("iecIssueDate", formattedDate(registrationForm.getIecIssueDate()));
			mv.addObject("ssiIssueDate", formattedDate(registrationForm.getSsiIssueDate()));
			LoginBean loginBean = new LoginBean();
			mv.addObject("loginBean", loginBean);
			mv.addObject("registrationStatus", true);
			mv.setViewName("davaRegistration");
		} else if (violations.size() > 0) {
			String encodedPanno = registrationForm.getOrgPanNumber();
			String decodedPan = decode(encodedPanno);
			String decodePanR = reverse(decodedPan);
			String decodedPan2 = decode(decodePanR);
			registrationForm.setOrgPanNumber(decodedPan2);

			String generatedCaptcha = captcha.getCaptcha();
			session.setAttribute("registrationCaptcha", generatedCaptcha);
			redirectAttributes.addFlashAttribute("registrationStatus", true);
			List<CountryMst> countryMst = davaServices.getCountryNames();
			List<StatesMst> ManfstatesNames = davaServices.getStatedata(registrationForm.getManfCountryId());
			List<StatesMst> OrgstatesNames = davaServices.getStatedata(registrationForm.getOrgCountryId());
			List<DistrictMst> ManfdistrictNames = davaServices.getDistrictNames(registrationForm.getManfStateId());
			List<DistrictMst> OrgdistrictNames = davaServices.getDistrictNames(registrationForm.getOrgStateId());
			registrationForm.setRegCaptcha("");
			registrationForm.setPassword("");
			mv.addObject("countryMst", countryMst);
			mv.addObject("registrationForm", registrationForm);
			mv.addObject("registrationCaptcha", generatedCaptcha);
			mv.addObject("ManfstatesNames", ManfstatesNames);
			mv.addObject("OrgstatesNames", OrgstatesNames);
			mv.addObject("ManfdistrictNames", ManfdistrictNames);
			mv.addObject("OrgdistrictNames", OrgdistrictNames);
			mv.addObject("iecIssueDate", formattedDate(registrationForm.getIecIssueDate()));
			mv.addObject("ssiIssueDate", formattedDate(registrationForm.getSsiIssueDate()));
			mv.addObject("serversideValidationException", true);
			mv.addObject("serversideValidationExceptionMessage", exceptionMessage);
			LoginBean loginBean = new LoginBean();
			mv.addObject("loginBean", loginBean);
			mv.setViewName("davaRegistration");
		} else {

			/*
			 * byte[] decoded; byte[] decoded2; byte[] decoded3; byte[] decoded4; String
			 * value = "";
			 * 
			 * try { decoded = new
			 * BASE64Decoder().decodeBuffer(registrationForm.getPassword()); value = new
			 * String(decoded);
			 * 
			 * decoded2 = new BASE64Decoder().decodeBuffer(value); String value2 = new
			 * String(decoded2);
			 * 
			 * decoded3 = new BASE64Decoder().decodeBuffer(value2); String value3 = new
			 * String(decoded3);
			 * 
			 * decoded4 = new BASE64Decoder().decodeBuffer(value3); String value4 = new
			 * String(decoded4);
			 * 
			 * String[] temp = value4.split(" ### "); if (temp.length == 3) {
			 * registrationForm.setPassword(temp[1].trim());
			 * 
			 * } else { throw new Exception("Invalid Password Exception"); } } catch
			 * (Exception e) {
			 * 
			 * }
			 */

			String hppValue = request.getParameter("hppGeneratedData");
			String Value1 = request.getParameter("hashValue");
			String value2 = decode(Value1);
			String value3 = reverse(value2);
			String hashValue = value3;
			String hppValue2 = null;
			String hashValue2 = null;
			String Value2 = null;
			String Value3 = null;
			String Value4 = null;

			if (drugLicence != null) {
				hppValue2 = request.getParameter("hppGeneratedData2");
				Value2 = request.getParameter("hashValue2");
				Value3 = decode(Value2);
				Value4 = reverse(Value3);
				hashValue2 = Value4;
			}
			// System.out.println("hashValue:::" + hashValue);
			// System.out.println("hashValuedd:::" + decode(hashValue));
			String hash = null;
			String hash2 = null;
			String fileName = null;
			if (file != null) {
				fileName = file.getOriginalFilename();
				String fakePath = "C:\\fakepath\\" + fileName + hppValue;
				hash = encodedservice.encode(fakePath);
				// System.out.println("hash:::" + hash);
			}
			if (drugLicence != null) {
				fileName = drugLicence.getOriginalFilename();
				String fakePath = "C:\\fakepath\\" + fileName + hppValue2;
				hash2 = encodedservice.encode(fakePath);
				// System.out.println("hash:::" + hash2);
			}
			String fileSize = null;
			String fileSize2 = null;

			String check = null;
			int urlcheck = 0;
			String check1 = null;
			int urlcheck1 = 0;
			GlobalAction globalAction = new GlobalAction();
			if (file != null) {
				fileSize = file.getSize() / 1024 + " Kb";
				check = GlobalAction.validateFileContentType("pdf", file);
				urlcheck = GlobalAction.checkFileContainUrl(file);
			}

			if (drugLicence != null) {
				fileSize2 = drugLicence.getSize() / 1024 + " Kb";
				check1 = GlobalAction.validateFileContentType("pdf", drugLicence);
				urlcheck1 = GlobalAction.checkFileContainUrl(drugLicence);

			}

			// System.out.println("check" + check);
			// System.out.println("check1" + check1);
			if (drugLicence != null) {
				if (file != null) {
					if (Integer.parseInt(fileSize2.split(" ")[0]) < 10 * 1024
							&& Integer.parseInt(fileSize2.split(" ")[0]) > 0
							&& Integer.parseInt(fileSize.split(" ")[0]) < 10 * 1024
							&& Integer.parseInt(fileSize.split(" ")[0]) > 0) {
						if (hash.toString().equals(hashValue) && hash2.toString().equals(hashValue2)) {
							if (check1 != "12" && urlcheck1 != 19 && check != "12" && urlcheck != 19) {

								Random random = new Random(System.nanoTime() % 100000);
								int randomCode = random.nextInt(1000000000);
								registrationForm.setRandomCode(randomCode);

								// added by harshita on 150723

								// Govind 080923
								LocalDateTime expirationTime = LocalDateTime.now().plusHours(1);
								registrationForm.setExpirationTime(expirationTime);
								System.out.println("Expiration Of New Resgistration Link :: " + expirationTime);

								String Username = registrationForm.getUserName();
								// System.out.println("Username::" + Username);
								String encodedusername = encode(Username);
								// System.out.println("encodedusername::" + encodedusername);
								String encodedusernameR = reverse(encodedusername);
								//// System.out.println("encodedusernameR::" + encodedusernameR);
								String encodedusername2 = encode(encodedusernameR);
								System.out.println("encodedusername2::" + encodedusername2);
								// registrationForm.setUserName(encodedusername2);

								/*
								 * String verificationLink = projectUrl + request.getContextPath() +
								 * "/emailVerification?email=" + registrationForm.getUserName() + "&randomCode="
								 * + registrationForm.getRandomCode();
								 * 
								 * 
								 * System.out.println("verificationLink::" + verificationLink);
								 */

								List<RegistrationDetails> user_id = davaServices.getUserId();
								System.out.println("userid:::" + user_id.get(0).getUserId());
								long user = user_id.get(0).getUserId() + 1;
								System.out.println("userid:::" + user);
								String apptype = registrationForm.getApplicantType();

								String rootDirectory = ftpProps.getDirectory();
								System.out.println("rootDirectory:::" + rootDirectory);

								String finalPath = rootDirectory + "/" + apptype + "/" + user + "/";
								System.out.println("finalPath::::" + finalPath);
								boolean result = false;
								if (apptype.equals("101")) {
									// if(fileValidationResult2 && fileValidationResult3) {
									String drugDetailsPath = finalPath;
									// String drugsDetails = drugDetailsPath + user
									// + "_drugDetails.pdf";

									// G29 (Save ftp path and user id to Registration Table)
									// String directory = drugsDetails;
									// int doc_size = Integer.parseInt(fileSize.split(" ")[0]);
									// String filename = fileName;
									// int doc_id = gService.addDocument(directory, doc_size, filename,
									// "Drug License Details", 1000001);
									// System.err.println("in file upload doc id drug license details-- " + doc_id);
									// userRepository.updateDrugLicenseId(user, doc_id);
									// G29

									try {
										result = ftpService.uploadFile(drugDetailsPath + user + "_drugDetails.pdf",
												drugLicence.getInputStream(), drugDetailsPath);
										LOGGER.info("Successfuly uploaded drug details {} ", result);
									} catch (IOException e) {
										LOGGER.error("error in uploading " + user + " drug details {}", e.getMessage());
										e.printStackTrace();
									}
									/*
									 * }else { redirectAttributes.addFlashAttribute("exception", true);
									 * redirectAttributes.addFlashAttribute("error", "Illegal File Extension !!!");
									 * mv.setViewName("redirect:/login"); }
									 */
								}
								// if(fileValidationResult && fileValidationResult1) {

								// String adressDetails = corporateAddressProofPath + user
								// + "_corporateAddressProof.pdf";
								// LOGGER.info("Final path to upload xml file {}", finalPath);

								// G29 (Save ftp path and user id to Registration Table)
								/*
								 * String directory = adressDetails; int doc_size =
								 * Integer.parseInt(fileSize.split(" ")[0]); String filename = fileName; int
								 * doc_id = gService.addDocument(directory, doc_size, filename,
								 * "Address Proof Details", 1000001);
								 * System.err.println("in file upload doc id of addressDetails-- " + doc_id);
								 */
								// userRepository.updateAddressProffId(user, doc_id);
								// G29
								boolean result2 = false;

								if (apptype.equals("101")) {

									String corporateAddressProofPath = finalPath;
									try {
										result2 = ftpService.uploadFile(
												corporateAddressProofPath + user + "_corporateAddressProof.pdf",
												file.getInputStream(), corporateAddressProofPath);

										LOGGER.info("Successfuly uploaded corporate address proof {} ", result2);
									} catch (IOException e1) {
										LOGGER.error("error in uploading " + user + " corporate address proof {}",
												e1.getMessage());
										e1.printStackTrace();
									}

								}
								String verificationLink = projectUrl + request.getContextPath()
										+ "/emailVerification?iveda=" + encodedusername2 + "&randomCode="
										+ registrationForm.getRandomCode();

								registrationForm.setEmailVerificationLink(verificationLink);

								userRegDomain = davaServices.saveUser(registrationForm);

								if (userRegDomain != null) {

									String drugDetailsPath = finalPath;
									String drugsDetails = drugDetailsPath + user + "_drugDetails.pdf";

									// G29 (Save ftp path and user id to Registration Table)
									String directory = drugsDetails;
									int doc_size = Integer.parseInt(fileSize.split(" ")[0]);
									String filename = fileName;
									int doc_id = gService.addDocument(directory, doc_size, filename,
											"Drug License Details", 1000001);
									System.err.println("in file upload doc id drug license details-- " + doc_id);

									userRepository.updateDrugLicenseId(user, doc_id);

								}

								String corporateAddressProofPath = finalPath;
								String adressDetails = corporateAddressProofPath + user + "_corporateAddressProof.pdf";
								LOGGER.info("Final path to upload xml file {}", finalPath);
								String directory = adressDetails;
								int doc_size = Integer.parseInt(fileSize.split(" ")[0]);
								fileName = file.getOriginalFilename();

								int doc_id = gService.addDocument(directory, doc_size, fileName,
										"Address Proof Details", 1000001);
								System.err.println("in file upload doc id of addressDetails-- " + doc_id);

								userRepository.updateAddressProffId(user, doc_id);

								/*
								 * if (registrationForm.getApplicantType().equals("101")) { if(check != "12" &&
								 * check1 != "12" && urlcheck!=19 && urlcheck1!=19) { userRegDomain =
								 * davaServices.saveUser(registrationForm); }else { System.out.
								 * println("inside Universal Document Controller validateFileContentType file might have alert, script tag "
								 * ); redirectAttributes.addFlashAttribute("exception", true);
								 * redirectAttributes.addFlashAttribute("error", "Invalid File");
								 * mv.setViewName("redirect:/login"); } }else { userRegDomain =
								 * davaServices.saveUser(registrationForm); }
								 */

								if (userRegDomain != null && result2 == true && result == true) {

									/*
									 * }else { redirectAttributes.addFlashAttribute("exception", true);
									 * redirectAttributes.addFlashAttribute("error", "Illegal File Extension !!!");
									 * mv.setViewName("redirect:/login"); }
									 */
									// davaServices.updateSeatMaster(userRegDomain.getUserId());

									String emailVerificationSubject = emailContent.getEmailContent()
											.get("emailVerificationSubject");
									String emailVerificationContent = emailContent.getEmailContent()
											.get("emailVerificationContent");

									emailVerificationContent = emailVerificationContent.replaceAll("\\$USER\\_NAME\\$",
											userRegDomain.getOrgName());
									emailVerificationContent = emailVerificationContent.replaceAll("\\$URL\\_LINK\\$",
											verificationLink);

									boolean result1 = sendmail.sendMailToUser(registrationForm.getUserName(),
											emailVerificationSubject, emailVerificationContent);

									// sendmail.sendEmailToUser(registrationForm.getUserName(), verificationLink);

									// davaServices.updateSeatMaster(userRegDomain.getUserId());

									if (!result1)
										redirectAttributes.addFlashAttribute("registrationStatus",
												"Registration Successfull , Some error occured while sending verification link to your mail, please contact pharmaexcil");
									else
										redirectAttributes.addFlashAttribute("registrationStatus",
												"Registration Form is Submitted Successfully E-mail Verification link is sent to the Registered/Corporate email id Please verify");
									redirectAttributes.addFlashAttribute("registrationSuccessful", true);
									// String seat = davaServices.updateSeatMaster(userRegDomain.getUserId());
									mv.setViewName("redirect:/login");

								} else {
									redirectAttributes.addFlashAttribute("exception", true);
									redirectAttributes.addFlashAttribute("error",
											"Entered user name is already present , please register with different user name");
									mv.setViewName("redirect:/login");
								}
							} else {
								redirectAttributes.addFlashAttribute("exception", true);
								redirectAttributes.addFlashAttribute("error", "Invalid File!!!");
								mv.setViewName("redirect:/login");
							}
						} else {
							redirectAttributes.addFlashAttribute("exception", true);
							redirectAttributes.addFlashAttribute("error", "Data tampered");
							mv.setViewName("redirect:/login");
						}
					} else {

						redirectAttributes.addFlashAttribute("exception", true);
						redirectAttributes.addFlashAttribute("error",
								"File Size must be should be more than 0 and less than 10 MB");
						mv.setViewName("redirect:/login");
					}
				} else {
					redirectAttributes.addFlashAttribute("exception", true);
					redirectAttributes.addFlashAttribute("error", "Upload Adress Proof");
					mv.setViewName("redirect:/login");

				}
			} else {
				if (file != null) {
					if (Integer.parseInt(fileSize.split(" ")[0]) < 10 * 1024
							&& Integer.parseInt(fileSize.split(" ")[0]) > 0) {
						if (hash.toString().equals(hashValue)) {
							if (check != "12" && urlcheck != 19) {

								Random random = new Random(System.nanoTime() % 100000);
								int randomCode = random.nextInt(1000000000);
								registrationForm.setRandomCode(randomCode);

								// added by harshita on 150723

								// Govind
								LocalDateTime expirationTime = LocalDateTime.now().plusHours(1);
								registrationForm.setExpirationTime(expirationTime);
								System.out.println("Expiration New Resgistation Link :: " + expirationTime);

								String Username = registrationForm.getUserName();
								System.out.println("Username::" + Username);
								String encodedusername =

										encode(Username);
								System.out.println("encodedusername::" + encodedusername);
								String encodedusernameR = reverse(encodedusername);
								System.out.println("encodedusernameR::" + encodedusernameR);
								String encodedusername2 = encode(encodedusernameR);
								System.out.println("encodedusername2::" + encodedusername2);
								// registrationForm.setUserName(encodedusername2);

								/*
								 * String verificationLink = projectUrl + request.getContextPath() +
								 * "/emailVerification?email=" + registrationForm.getUserName() + "&randomCode="
								 * + registrationForm.getRandomCode();
								 * 
								 * 
								 * System.out.println("verificationLink::" + verificationLink);
								 */

								/*
								 * LocalDateTime expirationTime = LocalDateTime.now().plusHours(1);
								 * registrationForm.setExpirationTime(expirationTime);
								 * System.out.println("Expiration Time of New Registration Link :: " +
								 * expirationTime);
								 */

								List<RegistrationDetails> user_id = davaServices.getUserId();
								System.out.println("userid:::" + user_id.get(0).getUserId());
								long user = user_id.get(0).getUserId() + 1;
								System.out.println("userid:::" + user);
								String apptype = registrationForm.getApplicantType();

								String rootDirectory = ftpProps.getDirectory();
								System.out.println("rootDirectory:::" + rootDirectory);

								String finalPath = rootDirectory + "/" + apptype + "/" + user + "/";
								System.out.println("finalPath::::" + finalPath);
								boolean result7 = false;
								if (apptype.equals("101")) {
									// if(fileValidationResult2 && fileValidationResult3) {
									String drugDetailsPath = finalPath;
									String drugsDetails = drugDetailsPath + user + "_drugDetails.pdf";

									// G29 (Save ftp path and user id to Registration Table)
									String directory = drugsDetails;
									int doc_size = Integer.parseInt(fileSize.split(" ")[0]);
									String filename = fileName;
									int doc_id = gService.addDocument(directory, doc_size, filename,
											"Drug License Details", 1000001);
									System.err.println("in file upload doc id-- " + doc_id);
									// userRepository.updateDrugLicenseId(user, doc_id);
									// G29

									try {
										result7 = ftpService.uploadFile(drugDetailsPath + user + "_drugDetails.pdf",
												drugLicence.getInputStream(), drugDetailsPath);
										LOGGER.info("Successfuly uploaded drug details {} ", result7);
									} catch (IOException e) {
										LOGGER.error("error in uploading " + user + " drug details {}", e.getMessage());
										e.printStackTrace();
									}
									/*
									 * }else { redirectAttributes.addFlashAttribute("exception", true);
									 * redirectAttributes.addFlashAttribute("error", "Illegal File Extension !!!");
									 * mv.setViewName("redirect:/login"); }
									 */
								}
								// if(fileValidationResult && fileValidationResult1) {
								String corporateAddressProofPath = finalPath;
								String adressDetails = corporateAddressProofPath + user + "_corporateAddressProof.pdf";
								System.out.println("adressDetails:::Dipen::" + adressDetails);

								// G29(Save ftp path and user id to Registration Table)
								String directory = adressDetails;
								int doc_size = Integer.parseInt(fileSize.split(" ")[0]);
								String filename = fileName;
								int doc_id = gService.addDocument(directory, doc_size, filename,
										"Address Proof Details", 1000001);
								System.err.println("in file upload doc id-- " + doc_id);
								// userRepository.updateAddressProffId(user, doc_id);
								// G29

								LOGGER.info("Final path to upload xml file {}", finalPath);
								boolean result8 = false;
								try {
									result8 = ftpService.uploadFile(
											corporateAddressProofPath + user + "_corporateAddressProof.pdf",
											file.getInputStream(), corporateAddressProofPath);

									LOGGER.info("Successfuly uploaded corporate address proof {} ", result8);
								} catch (IOException e1) {
									LOGGER.error("error in uploading " + user + " corporate address proof {}",
											e1.getMessage());
									e1.printStackTrace();
								}

								String verificationLink = projectUrl + request.getContextPath()
										+ "/emailVerification?iveda=" + encodedusername2 + "&randomCode="
										+ registrationForm.getRandomCode();

								registrationForm.setEmailVerificationLink(verificationLink);

								userRegDomain = davaServices.saveUser(registrationForm);

								userRepository.updateAddressProffId(user, doc_id);
								/*
								 * if (registrationForm.getApplicantType().equals("101")) { if(check != "12" &&
								 * check1 != "12" && urlcheck!=19 && urlcheck1!=19) { userRegDomain =
								 * davaServices.saveUser(registrationForm); }else { System.out.
								 * println("inside Universal Document Controller validateFileContentType file might have alert, script tag "
								 * ); redirectAttributes.addFlashAttribute("exception", true);
								 * redirectAttributes.addFlashAttribute("error", "Invalid File");
								 * mv.setViewName("redirect:/login"); } }else { userRegDomain =
								 * davaServices.saveUser(registrationForm); }
								 */

								if (userRegDomain != null && result8 == true) {

									/*
									 * }else { redirectAttributes.addFlashAttribute("exception", true);
									 * redirectAttributes.addFlashAttribute("error", "Illegal File Extension !!!");
									 * mv.setViewName("redirect:/login"); }
									 */
									// davaServices.updateSeatMaster(userRegDomain.getUserId());

									String emailVerificationSubject = emailContent.getEmailContent()
											.get("emailVerificationSubject");
									String emailVerificationContent = emailContent.getEmailContent()
											.get("emailVerificationContent");

									emailVerificationContent = emailVerificationContent.replaceAll("\\$USER\\_NAME\\$",
											userRegDomain.getOrgName());
									emailVerificationContent = emailVerificationContent.replaceAll("\\$URL\\_LINK\\$",
											verificationLink);

									boolean result = sendmail.sendMailToUser(registrationForm.getUserName(),
											emailVerificationSubject, emailVerificationContent);

									// sendmail.sendEmailToUser(registrationForm.getUserName(), verificationLink);

									// davaServices.updateSeatMaster(userRegDomain.getUserId());

									if (!result)
										redirectAttributes.addFlashAttribute("registrationStatus",
												"Registration Successfull , Some error occured while sending verification link to your mail, please contact pharmaexcil");
									else
										redirectAttributes.addFlashAttribute("registrationStatus",
												"Registration Form is Submitted Successfully E-mail Verification link is sent to the Registered/Corporate email id Please verify");
									redirectAttributes.addFlashAttribute("registrationSuccessful", true);
									// String seat = davaServices.updateSeatMaster(userRegDomain.getUserId());
									mv.setViewName("redirect:/login");

								} else {
									redirectAttributes.addFlashAttribute("exception", true);
									redirectAttributes.addFlashAttribute("error",
											"Entered user name is already present , please register with different user name");
									mv.setViewName("redirect:/login");
								}
							} else {
								redirectAttributes.addFlashAttribute("exception", true);
								redirectAttributes.addFlashAttribute("error", "Invalid File!!!");
								mv.setViewName("redirect:/login");
							}
						} else {
							redirectAttributes.addFlashAttribute("exception", true);
							redirectAttributes.addFlashAttribute("error", "Tampered File!!!");
							mv.setViewName("redirect:/login");
						}
					} else {

						redirectAttributes.addFlashAttribute("exception", true);
						redirectAttributes.addFlashAttribute("error",
								"File Size must be should be more than 0 and less than 10 MB");
						mv.setViewName("redirect:/login");

					}

				} else {

					redirectAttributes.addFlashAttribute("exception", true);
					redirectAttributes.addFlashAttribute("error", "Upload Adress Proof");
					mv.setViewName("redirect:/login");
				}

			}

		}

		// }
		return mv;
	}

	// This method is used to get the State data based on Country
	@GetMapping("/getStateData")
	public ResponseEntity<List<StatesMst>> getStatedata(@RequestParam("countryId") Integer countryId) {
		List<StatesMst> statesNames = davaServices.getStatedata(countryId);
		return new ResponseEntity<List<StatesMst>>(statesNames, HttpStatus.OK);
	}

	// This method is used to get the district data based on state data
	@GetMapping("/getDistrictData")
	public ResponseEntity<List<DistrictMst>> getDistrictData(@RequestParam("stateId") Integer stateId) {
		List<DistrictMst> districtNames = davaServices.getDistrictNames(stateId);
		return new ResponseEntity<List<DistrictMst>>(districtNames, HttpStatus.OK);
	}

	@GetMapping("/emailVerification")
	public ModelAndView verifyEmailId(@RequestParam("iveda") String encodedMail,
			@RequestParam("randomCode") int randomCode, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView();

		System.out.println("encodedMail:::" + encodedMail);
		String decodedMail = decode(encodedMail);

		String decodedMail1 = reverse(decodedMail);

		String decodedMail2 = decode(decodedMail1);
		decodedMail2 = decodedMail2.toLowerCase();

		// System.out.println("decodedMail2:::" + decodedMail2);

		// System.out.println("randomCode:::" + randomCode);

		RegistrationDetails status = davaServices.verifyUserEmail(decodedMail2, randomCode);

		System.out.println("decodedMail2:::" + decodedMail2 + "status:::" + status);

		// System.out.println("email sta:::"+status.getNumEmailStatus());

		// Govind
		LocalDateTime dbExpirationTime = userRepository.findExpirationTimeByUsername(decodedMail2);

		if (status == null || status.getNumEmailStatus() == 1) { // kth
			if (status != null && status.getApplicantType().equals("104")) {
				LOGGER.info("Email Verification status {}", status.toString());
				redirectAttributes.addFlashAttribute("registrationSuccessful", true);
				redirectAttributes.addFlashAttribute("registrationStatus",
						"E-mail Verification is Successful , You can proceed to Login now");
			} else if (status != null && !status.getApplicantType().equals("104") && randomCode != 0) {

				if (dbExpirationTime != null) { // nth
					LocalDateTime currentTime = LocalDateTime.now();
					if (currentTime.isBefore(dbExpirationTime) || currentTime.isEqual(dbExpirationTime)) { // jth

						LOGGER.info("Email Verification status {}", status.toString());
						redirectAttributes.addFlashAttribute("registrationSuccessful", true);
						System.out.println("helloooooo:::" + status);
						redirectAttributes.addFlashAttribute("registrationStatus",
								"E-mail Verification is Successful , Registration request is pending at PHARMEXCIL. You will get a Confirmation E-mail after successful verification from PHARMEXCIL");

					} else {
						redirectAttributes.addFlashAttribute("registrationSuccessful", true);

						// redirectAttributes.addFlashAttribute("registrationStatus", "Your email is
						// already verified");
						davaServices.verifyUserEmailfail(decodedMail2, randomCode);
						redirectAttributes.addFlashAttribute("registrationStatus", "Email link is expired.");

					}

				} else {
					redirectAttributes.addFlashAttribute("registrationSuccessful", true);
					// redirectAttributes.addFlashAttribute("registrationStatus", "Your email is
					// already verified");
					// davaServices.verifyUserEmailfail(decodedMail2, randomCode);
					redirectAttributes.addFlashAttribute("registrationStatus", "Email link is expired.");
				}

			} else if (randomCode == 0) {
				// System.out.println("in ran code 000:::" + randomCode);
				redirectAttributes.addFlashAttribute("registrationSuccessful", true);
				redirectAttributes.addFlashAttribute("registrationStatus", "Your email does not exist");
			} else {
				redirectAttributes.addFlashAttribute("registrationSuccessful", true);
				// redirectAttributes.addFlashAttribute("registrationStatus", "Your email is
				// already verified");
				// davaServices.verifyUserEmailfail(decodedMail2, randomCode);
				redirectAttributes.addFlashAttribute("registrationStatus", "Email link is expired.");
			}
		} // kth
		else {
			redirectAttributes.addFlashAttribute("registrationSuccessful", true);
			redirectAttributes.addFlashAttribute("registrationStatus", "Your email does not exist");
		}
		/*
		 * }//jth else { redirectAttributes.addFlashAttribute("registrationSuccessful",
		 * false); redirectAttributes.addFlashAttribute("registrationStatus",
		 * "Email link is expired."); } }//nth else {
		 * redirectAttributes.addFlashAttribute("registrationSuccessful", false);
		 * redirectAttributes.addFlashAttribute("registrationStatus",
		 * "Email link is expired."); }
		 */
		mv.setViewName("redirect:/login");
		return mv;
	}

	@GetMapping("/getUserNameStatus")
	public @ResponseBody boolean checkUserNameExist(@RequestParam("userName") String userName) {

		boolean status = davaServices.checkUserNameExist(userName);
		return status;
	}

	public String formattedDate(Date date) {
		SimpleDateFormat simpledateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String fDate = "";
		if (date != null) {
			fDate = simpledateFormat.format(date);
		}
		return fDate;
	}

	@RequestMapping(value = "/RCMCRegData", method = RequestMethod.GET)
	public String RCMCRegData(@ModelAttribute("login") RegistrationForm registrationForm, HttpServletRequest request) {

		String response = "";

		response = "RCMCData";

		return response;
	}

	@RequestMapping(value = "/getRCMCData", method = RequestMethod.GET)
	@ResponseBody
	public String viewLocMaster(HttpServletRequest request, HttpServletResponse response) {

		// System.out.println("in data table code");
		String jsonResponse = davaServices.ShowRCMCData(request);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}

	/*
	 * @RequestMapping(value = "/AppJCaptcha", method = RequestMethod.POST)
	 * public @ResponseBody String JCaptcha(HttpServletRequest request) { String
	 * flag="false"; Boolean isResponseCorrect =Boolean.FALSE; //remenber that we
	 * need an id to validate! String captchaId = request.getSession().getId();
	 * 
	 * //retrieve the response String response =
	 * request.getParameter("jcaptcha").toString();
	 * //System.out.println("user captcha="+response); // Call the Service method
	 * try { isResponseCorrect =
	 * CaptchaServiceSingleton.getInstance().validateResponseForID(captchaId,
	 * response); //System.out.println("isResponseCorrect= "+isResponseCorrect);
	 * if(isResponseCorrect) flag="true"; else flag="false";
	 * 
	 * } catch (CaptchaServiceException e) { //should not happen, may be thrown if
	 * the id is not valid } // System.err.println("flag---"+flag); return flag; }
	 */
	@RequestMapping(value = "/AddAddressDetails", method = RequestMethod.GET)
	public String showAddressDetails(@ModelAttribute("registrationForm") MemberAddDtlModel memberAddDtlModel,
			HttpServletRequest request) {
		String response = "";

		String loogedInUserId = SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		System.out.println(userDetails.get(0).getUserId() + "  " + userDetails.get(0).getUserName() + "  "
				+ userDetails.get(0).getApplicantType());

		request.setAttribute("applicant", userDetails.get(0).getApplicantType());

		List<StatesMst> state = locDao.getState();
		request.setAttribute("state", state);

		List<LicenseTypeMstDomain> lic = null;
		if (userDetails.get(0).getApplicantType().equals("100")) {
			lic = davaServices.getLicenseType();
		} else {
			lic = davaServices.getLicenseTypeForExp();
		}
		request.setAttribute("lic", lic);

		List<ApprovalTypeMst> app = davaDao.getApprovalType();
		request.setAttribute("app", app);

		List<SiteTypeMstDomain> site = davaDao.getSiteAccUser(userDetails.get(0).getApplicantType());
		request.setAttribute("site", site);

		// System.out.println(request.getSession().getAttribute("manufacturingSiteListAfterSave")+"
		// |||| "+request.getSession().getAttribute("premisedata"));

		// List<InstPremiseDtlDomain> inst = (List<InstPremiseDtlDomain>)
		// request.getSession().getAttribute("premisedata");
		// request.getSession().getAttribute("manufacturingSiteListAfterSave");
		// Integer flag = (Integer)
		// request.getSession().getAttribute("backFromPreview");
		// request.setAttribute("premise", inst);
		// request.setAttribute("flag", flag);

		response = "AddressDetails";

		return response;
	}

	@Autowired
	InstPremiseDtlRepository instPremiseDtlRepository;

	@RequestMapping(value = "/saveInstPremisesAddressDetails", method = RequestMethod.POST)
	public String saveInstPremisesAddressDetails(
			@Validated(ManufacturingSiteDetails.class) @ModelAttribute("registrationForm") MemberAddDtlModel memberAddDtlModel,
			BindingResult result, HttpServletRequest request, RedirectAttributes attr)
			throws FileNotFoundException, UnsupportedEncodingException, TransformerException, JSONException {
		MultipartFile drugLicenceMF = memberAddDtlModel.getDrugLicenceMF();
		System.out.println("IN Testing ACTION");
		System.out.println("drugLicenceMF::" + drugLicenceMF);
		System.out.println("ALL DATA -- " + memberAddDtlModel.toString());
		String res = "";
		List<String> errorMessage = new ArrayList<String>();
		if (result.hasErrors()) {
			List<ObjectError> errorList = result.getAllErrors();
			for (int i = 0; i < errorList.size(); i++) {
				String codes = errorList.get(i).getCodes()[1].substring(
						errorList.get(i).getCodes()[1].lastIndexOf(".") + 1, errorList.get(i).getCodes()[1].length());
				errorMessage.add(errorList.get(i).getDefaultMessage());
			}
			attr.addFlashAttribute("errors", errorMessage);
			res = "redirect:/AddAddressDetails";

		} else {
			InstPremiseDtlDomain instDomain = davaServices.addInstPreDetail(memberAddDtlModel, request);
			// (G-CODE) START
			int numInstId = instDomain.getNumInstid();
			System.out.println("numInstId: " + numInstId);

			String loogedInUserIdName = SecurityContextHolder.getContext().getAuthentication().getName();
			System.out.println("loogedInUserIdName: " + loogedInUserIdName);

			RegistrationDetails rg = userRepository.findByUserName(loogedInUserIdName);

			Long userId = rg.getUserId();
			System.out.println("Logged userID: " + userId);

			String loogedInUserId = Long.toString(userId);

			String applicantType = userRepository.findApplicantTypeByUserId(userId);
			System.out.println("Applicant Type: " + applicantType);

			String rootDirectory = ftpProps.getDirectory();
			System.out.println("Root Directory: " + rootDirectory);

			String finalPath = rootDirectory + "/" + applicantType + "/" + loogedInUserId + "/";
			System.out.println("Final Path: " + finalPath);

			String filename = drugLicenceMF.getOriginalFilename();
			System.out.println("Filename: " + filename);

			long doc_size_long = drugLicenceMF.getSize();
			int doc_size = (int) doc_size_long;
			System.out.println("Document Size: " + doc_size);

			String drugDetailsPath = finalPath;
			System.out.println("Drug Details Path: " + drugDetailsPath);

			String uniqName = generateRandomAlphabets(3);
			System.out.println("Unique Name: " + uniqName);

			String drugsDetails = drugDetailsPath + loogedInUserId + "_manufsiteLic-" + uniqName + ".pdf";
			System.out.println("Drugs Details: " + drugsDetails);

			String directory = drugsDetails;
			System.out.println("Directory: " + directory);

			int doc_id = gService.addDocument(directory, doc_size, filename, "Manufacturing Unit Drug License Details",
					1000001);
			System.out.println("Document ID: " + doc_id);

			instPremiseDtlRepository.updateNumDocumentId(numInstId, doc_id);
			instPremiseDtlRepository.setZero(numInstId);

			try {
				ftpService.uploadFile(drugDetailsPath + loogedInUserId + "_manufsiteLic-" + uniqName + ".pdf",
						drugLicenceMF.getInputStream(), drugDetailsPath);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// (G-CODE) END

			System.out.println(instDomain.getNumPremiseNo());
			Integer premisesNo = instDomain.getNumPremiseNo();

			System.out.println(memberAddDtlModel.getAddedList_str());
			String addedList = memberAddDtlModel.getAddedList_str();

			List<String> list_licenseTypeText = new ArrayList<String>();
			List<Integer> list_licenseType = new ArrayList<Integer>();
			List<String> list_licenseNumber = new ArrayList<String>();
			List<String> list_issueAuthId = new ArrayList<String>();
			List<String> list_FromDate = new ArrayList<String>();
			List<String> list_ToDate = new ArrayList<String>();

			JSONArray jArr = new JSONArray(addedList);
			System.out.println("JSON LENGTH - " + jArr.length());
			for (int i = 0; i < jArr.length(); i++) {
				JSONObject jobj = jArr.getJSONObject(i);
				list_licenseTypeText.add(jobj.getString("licenseTypeText").toString());
				list_licenseType.add(Integer.parseInt(jobj.getString("licenseType").toString()));
				list_licenseNumber.add(jobj.getString("licenseNumber").toString());
				list_issueAuthId.add(jobj.getString("issueAuthId").toString());
				list_FromDate.add(jobj.getString("FromDate").toString());
				list_ToDate.add(jobj.getString("ToDate").toString());
			}
			memberAddDtlModel.setList_licType(list_licenseType);
			memberAddDtlModel.setList_licNo(list_licenseNumber);
			memberAddDtlModel.setList_issueAuth(list_issueAuthId);
			memberAddDtlModel.setList_fromDate(list_FromDate);
			memberAddDtlModel.setList_toDate(list_ToDate);

			LicPremiseDtlDomain licDom = davaServices.addLicPreDetail(memberAddDtlModel, premisesNo, request);

			System.out.println(memberAddDtlModel.getAppAddedList_str());
			String appAddedList = memberAddDtlModel.getAppAddedList_str();

			List<String> list_approvalTypeText = new ArrayList<String>();
			List<Integer> list_approvalType = new ArrayList<Integer>();
			List<String> list_approvalNo = new ArrayList<String>();
			List<String> list_appFromDate = new ArrayList<String>();
			List<String> list_appToDate = new ArrayList<String>();
			// List<String> list_appIssueAuth = new ArrayList<String>();

			JSONArray jArr1 = new JSONArray(appAddedList);
			System.out.println("JSON LENGTH - " + jArr1.length());
			for (int i = 0; i < jArr1.length(); i++) {
				JSONObject jobj1 = jArr1.getJSONObject(i);
				list_approvalTypeText.add(jobj1.getString("approvalTypeText").toString());
				list_approvalType.add(Integer.parseInt(jobj1.getString("approvalType").toString()));
				list_approvalNo.add(jobj1.getString("approvalNumber").toString());
				// list_appIssueAuth.add(jobj1.getString("appIssueAuthId").toString());
				list_appFromDate.add(jobj1.getString("approvalFromDate").toString());
				list_appToDate.add(jobj1.getString("approvalToDate").toString());
			}
			memberAddDtlModel.setList_approvalType(list_approvalType);
			memberAddDtlModel.setList_approvalNo(list_approvalNo);
			memberAddDtlModel.setList_appFromDate(list_appFromDate);
			memberAddDtlModel.setList_appToDate(list_appToDate);
			// memberAddDtlModel.setList_appIssueAuth(list_appIssueAuth);

			ApprovalPremisesDetail appPreDtl = davaServices.addAppPremisesDtls(memberAddDtlModel, premisesNo, request);
			// attr.addFlashAttribute("flagSave", 1);
			request.getSession().setAttribute("premisesNo", premisesNo);
			res = "redirect:/PreviewPremisesDetails";
		}
		return res;

	}

	private static String generateRandomAlphabets(int length) {
		StringBuilder result = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			// ASCII value for 'A' is 65, and for 'Z' is 90
			char randomAlphabet = (char) (random.nextInt(26) + 'A');
			result.append(randomAlphabet);
		}
		return result.toString();
	}

	@RequestMapping(value = "/PreviewPremisesDetails", method = RequestMethod.GET)
	public String showMemberDetails(@ModelAttribute("registrationForm") MemberAddDtlModel memberAddDtlModel,
			HttpServletRequest request)
			throws FileNotFoundException, UnsupportedEncodingException, TransformerException {
		String response = "";
		Integer premisesNo = (Integer) request.getSession().getAttribute("premisesNo");

		System.out.println("premises number for premises detail - - - - - " + premisesNo);
		String strXml = "<roottag>";
		String xmlString = davaServices.getMemberSiteDtlXML(premisesNo);
		System.out.println("xml string:::" + xmlString);
		strXml = strXml + xmlString + "</roottag>";
		String strRealPathLogo = request.getSession().getServletContext()
				.getRealPath("/WEB-INF/JSP/RegistrationPages/");
		String xslInput = strRealPathLogo + File.separator + "SiteDetailsView.xsl";
		FileInputStream xsl = new FileInputStream(xslInput);

		TransformerFactory tFactory = TransformerFactory.newInstance();
		StreamSource styleSource = new StreamSource(xsl);
		Transformer transformer = tFactory.newTransformer(styleSource);
		String s = new String(strXml.getBytes(), "UTF-8");
		InputStream is = new ByteArrayInputStream(s.getBytes());
		StreamSource xmlSource = new StreamSource(is);

		StringWriter outWriter = new StringWriter();
		StreamResult result1 = new StreamResult(outWriter);
		transformer.transform(xmlSource, result1);
		StringBuffer sb = outWriter.getBuffer();

		String finalstring = sb.toString();

		System.out.println("response::::" + finalstring);
		request.setAttribute("viewdata", finalstring);

		request.setAttribute("premisesNo", premisesNo);
		response = "PremisesDtlPreview";

		return response;
	}

	@RequestMapping(value = "/AddMemberDetails", method = RequestMethod.GET)
	public String showMemberDetails(@ModelAttribute("memberDtlForm") MemberDetailForm memDtlForm,
			HttpServletRequest request) {
		String response = "";

		List<MemberTypeMasterDomain> memTypeList = davaServices.getMemberType();
		request.setAttribute("memTypeList", memTypeList);
		response = "MemberDetails";

		return response;
	}

	@RequestMapping(value = "/AddDrugDetails", method = RequestMethod.GET)
	public ModelAndView showDrugDetails(@ModelAttribute("registrationForm") DrugDtlsModel drugDtlsModel,
			HttpServletRequest request) {
		String response = "";

		String loogedInUserId = SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		Integer instId = userDetails.get(0).getNumInstId();
		Integer premiseNo = userDetails.get(0).getNumPremisesNo();
		System.out.println(premiseNo);

		ModelAndView mv = new ModelAndView();

		List<DrugTypeMst> drugType = davaDao.getDrugType();
		request.setAttribute("drugType", drugType);

		List<DrugMonographMst> drugMonoType = davaDao.getDrugMonoType();
		request.setAttribute("drugMonoType", drugMonoType);

		List<DrugDosageMst> drugDoseType = davaDao.getDrugDoseType();
		request.setAttribute("drugDoseType", drugDoseType);

		List<DrugScheduleMst> drugSchType = davaDao.getDrugSchType();
		request.setAttribute("drugSchType", drugSchType);

		List<PackUnitMst> packUnitType = davaDao.getPackUnitType();
		request.setAttribute("packUnitType", packUnitType);

		List<InstPremiseDtlDomain> instPreDtls = null;

		if (premiseNo == null || premiseNo == 0) {
			instPreDtls = davaDao.getInstPremisesDtls(instId);
		} else {
			instPreDtls = davaDao.getInstPremisesDtlsSubLogin(instId, premiseNo);
		}

		request.setAttribute("instPreDtls", instPreDtls);

		List<HSCodeDomain> hsCodeDtls = davaDao.getHSCodeDtls();
		request.setAttribute("hsCodeDtls", hsCodeDtls);

		List<StorageCondMstDom> stoDom = davaDao.getStorageCondition();
		request.setAttribute("stoDom", stoDom);

		List<TherepueticClassDom> thDom = davaDao.getTherepueticClass();
		request.setAttribute("thDom", thDom);

		// response= "DrugDetails";
		mv.setViewName("DrugDetails");
		return mv;
	}

	@GetMapping("/getManufactreData")
	public ResponseEntity<List<InstPremiseDtlDomain>> getManufactreData(@RequestParam("manId") Integer manufactureId) {
		List<InstPremiseDtlDomain> premiseDtls = davaServices.getPremiseAddress(manufactureId);
		return new ResponseEntity<List<InstPremiseDtlDomain>>(premiseDtls, HttpStatus.OK);
	}

	@RequestMapping(value = "/saveDrugDetails", method = RequestMethod.POST)
	public String saveDrugDetails(
			@Validated(DrugDetails.class) @ModelAttribute("registrationForm") DrugDtlsModel drugDtlsModel,
			BindingResult result, HttpServletRequest request, RedirectAttributes attr) {
		System.out.println("IN Testing ACTION");
		String res = "";
		List<String> errorMessage = new ArrayList<String>();
		if (result.hasErrors()) {
			List<ObjectError> errorList = result.getAllErrors();
			for (int i = 0; i < errorList.size(); i++) {
				String codes = errorList.get(i).getCodes()[1].substring(
						errorList.get(i).getCodes()[1].lastIndexOf(".") + 1, errorList.get(i).getCodes()[1].length());
				errorMessage.add(errorList.get(i).getDefaultMessage());
			}
			attr.addFlashAttribute("errors", errorMessage);
			res = "redirect:/AddDrugDetails";

		} else {
			/*
			 * String a = ApplicationProperties.getValueFromKey("file.upload.dir");
			 * System.out.println(a);
			 */
			String drugDom = davaServices.addDrugMstDetail(drugDtlsModel, request);
			System.out.println("String from addDrugMstDetail -- " + drugDom);
			if (drugDom == null) {
				attr.addFlashAttribute("flagSave", 2);
			} else {
				attr.addFlashAttribute("flagSave", 1);
			}
			res = "redirect:/AddDrugDetails";
		}
		return res;
	}

	@RequestMapping(value = "/ShowDrugDetails", method = RequestMethod.GET)
	public ModelAndView drugDetails(@ModelAttribute("registrationForm") DrugDtlsModel drugDtlsModel,
			HttpServletRequest request) {
		String response = "";
		ModelAndView mv = new ModelAndView();

		// response= "DrugDetails";
		mv.setViewName("showDrugDetails");
		return mv;
	}

	@RequestMapping(value = "/getDrugDetails", method = RequestMethod.GET)
	@ResponseBody
	public String getDrugDetails(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("in data table code");
		String jsonResponse = davaServices.ShowDrugDetails(request);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}

	@RequestMapping(value = "/getDrugDetailsBD", method = RequestMethod.GET)
	@ResponseBody
	public String getDrugDetailsBD(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("in data table code");
		String jsonResponse = davaServices.ShowDrugDetailsBD(request);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}

	@RequestMapping(value = "/ShowAllDrugs", method = RequestMethod.GET)
	public ModelAndView ShowAllDrugs(@ModelAttribute("registrationForm") DrugDtlsModel drugDtlsModel,
			HttpServletRequest request) {
		String response = "";
		ModelAndView mv = new ModelAndView();

		List<RegistrationDetails> regList = davaDao.getAllRegistrations();
		request.setAttribute("regList", regList);
		// response= "DrugDetails";
		mv.setViewName("AllDrugData");
		return mv;
	}

	@RequestMapping(value = "/getAllDrugDetails", method = RequestMethod.GET)
	@ResponseBody
	public String getAllDrugDetails(@RequestParam("company") Long company, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("in data table code");
		System.out.println(company + "  User Id");
		String jsonResponse = davaServices.ShowAllDrugDetails(request, company);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}

	@RequestMapping(value = "/updateDrugDetails", method = RequestMethod.POST)
	public String updateDrugDetails(
			@Validated(DrugDetails.class) @ModelAttribute("registrationForm") DrugDtlsModel drugDtlsModel,
			BindingResult result, HttpServletRequest request, RedirectAttributes attr) {

		System.out.println("IN Testing ACTION");
		String res = "";
		List<String> errorMessage = new ArrayList<String>();
		if (result.hasErrors()) {
			List<ObjectError> errorList = result.getAllErrors();
			for (int i = 0; i < errorList.size(); i++) {
				String codes = errorList.get(i).getCodes()[1].substring(
						errorList.get(i).getCodes()[1].lastIndexOf(".") + 1, errorList.get(i).getCodes()[1].length());
				errorMessage.add(errorList.get(i).getDefaultMessage());
			}
			attr.addFlashAttribute("errors", errorMessage);
			res = "redirect:/AddDrugDetails";

		} else {
			DrugMst drugDom = davaServices.updateDrugDetails(drugDtlsModel, request);
			attr.addFlashAttribute("flagUpdate", 1);
			res = "redirect:/AddDrugDetails";
		}
		return res;

	}

	@RequestMapping(value = "/deleteDrugDetails", method = RequestMethod.POST)
	public String deleteDrugDetails(@ModelAttribute("registrationForm") DrugDtlsModel drugDtlsModel,
			BindingResult result, HttpServletRequest request, RedirectAttributes attr) {

		System.out.println("IN Testing ACTION");
		String res = "";
		DrugMst drugDom = davaServices.deleteDrugDetails(drugDtlsModel, request);
		attr.addFlashAttribute("flagDelete", 1);
		res = "redirect:/AddDrugDetails";
		return res;

	}

	@RequestMapping(value = "/OfficialRegistration", method = RequestMethod.GET)
	public String showOfficialRegistrationPage(@ModelAttribute("offRegistration") OffRegModel offReg,
			HttpServletRequest request) {
		String response = "";

		List<InstituteTypeMasterDomain> instType = locDao.LoadLocationType();
		request.setAttribute("instType", instType);

		List<RoleMaster> role = locDao.loadRole();
		request.setAttribute("role", role);

		List<LocationMasterDomain> loc = locDao.loadLocationMaster();
		request.setAttribute("loc", loc);

		response = "OfficialRegistrationPage";

		return response;
	}

	@PostMapping(value = "/saveOfficialReg")
	public String saveOfficialReg(@ModelAttribute("offRegistration") OffRegModel registrationForm, BindingResult result,
			HttpServletRequest request, RedirectAttributes attr) {
		System.err.println("in save manuf user---- ");

		// byte[] decoded;
		// String value="";

		try {
			String pwd = registrationForm.getPassword();

			System.out.println("pwd::::::" + pwd);

			byte[] decodedBytes = Base64.getDecoder().decode(pwd);

			String decodedString = new String(decodedBytes);

			System.out.println("decodedString::::::" + decodedString);

			StringBuffer reversedStringBuffer = new StringBuffer(decodedString);
			reversedStringBuffer.reverse(); // reversing string

			System.out.println("reversedStringBuffer::" + reversedStringBuffer);

			String value1 = new String(reversedStringBuffer);

			System.out.println("value1::" + reversedStringBuffer);
			byte[] decodedBytes2 = Base64.getDecoder().decode(value1);

			String value4 = new String(decodedBytes2);

			System.out.println("value4::" + value4);

			/*
			 * decoded = new BASE64Decoder().decodeBuffer(registrationForm.getPassword());
			 * value =new String(decoded);
			 */
			String[] temp = value4.split(" ### ");
			if (temp.length == 3) {
				registrationForm.setPassword(temp[1].trim());
				System.out.println(temp[1].trim());
			} else {
				throw new Exception("Invalid Password Exception");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * byte[] decoded; String value="";
		 * 
		 * try { decoded = new
		 * BASE64Decoder().decodeBuffer(registrationForm.getPassword()); value =new
		 * String(decoded); String[] temp = value.split(" ### "); if(temp.length==3){
		 * 
		 * 
		 * registrationForm.setPassword(temp[1].trim());
		 * 
		 * }else{ throw new Exception("Invalid Password Exception"); } }catch (Exception
		 * 
		 * 
		 * 
		 * e) { e.printStackTrace(); }
		 */

		Random random = new Random(System.nanoTime() % 100000);
		int randomCode = random.nextInt(1000000000);
		registrationForm.setRandomCode(randomCode);

		RegistrationDetails userRegDomain = davaServices.saveOffReg(registrationForm);

		if (userRegDomain != null && userRegDomain.getUserId() != null) {

			String verificationLink = projectUrl + request.getContextPath() + "/emailVerification?email="
					+ DataEncoder.encode(registrationForm.getUserName()) + "&randomCode="
					+ registrationForm.getRandomCode();

			String emailVerificationSubject = emailContent.getEmailContent().get("emailVerificationSubjectForOfficial");
			String emailVerificationContent = emailContent.getEmailContent().get("emailVerificationContentForOfficial");

			// emailVerificationContent=emailVerificationContent.replaceAll("\\$USER\\_NAME\\$",
			// userRegDomain.getOrgName());
			emailVerificationContent = emailVerificationContent.replaceAll("\\$URL\\_LINK\\$", verificationLink);
			// sendmail.sendEmailToUser(userRegDomain.getUserName(), verificationLink);
			sendmail.sendMailToUser(userRegDomain.getUserName(), emailVerificationSubject, emailVerificationContent);

			String seat = davaServices.updateSeatMaster(userRegDomain.getUserId());
			System.out.println(seat.length() + "    seat length");
			attr.addFlashAttribute("flagSave", 1);
			return "redirect:/OfficialRegistration";

		} else {
			attr.addFlashAttribute("flagSave", 2);
			return "redirect:/OfficialRegistration";
		}
	}

	// Added By Deepshikha

	@PostMapping(value = "/saveMemberDetail")
	public String SaveMemberDetails(
			@Validated(MemberDetails.class) @ModelAttribute("memberDtlForm") MemberDetailForm memDtlForm,
			BindingResult result, HttpServletRequest request, RedirectAttributes attr) throws Exception {

		if (!memDtlForm.getStrDocId().trim().equals("-1")) {
			MultipartFile uploadfile = memDtlForm.getUploadfile();
			String value1 = request.getParameter("hashValue");
			String Value2 = decode(value1);
			String Value3 = reverse(Value2);
			String hashValue = Value3;
			System.out.println("hashValue:::" + hashValue);
			String FileNameOriginal = uploadfile.getOriginalFilename();
			String hash = null;

			if (uploadfile != null) {
				String fakePath = "C:\\fakepath\\" + FileNameOriginal;
				hash = encodedservice.encode(fakePath);
				System.out.println("hash:::" + hash);
			}
			if (uploadfile != null) {
				String fileSize = uploadfile.getSize() / 1024 + " Kb";
				if (Integer.parseInt(fileSize.split(" ")[0]) < 10 * 1024
						&& Integer.parseInt(fileSize.split(" ")[0]) > 0) {
					GlobalAction globalAction = new GlobalAction();

					String check = GlobalAction.validateFileContentType("pdf", uploadfile);
					int urlcheck = GlobalAction.checkFileContainUrl(uploadfile);
					if (hash.toString().equals(hashValue)) {
						if (check != "12" && urlcheck != 19) {

							String stChecksum = "";
							try {
								byte[] uploadBytes = uploadfile.getBytes();
								MessageDigest md5 = MessageDigest.getInstance("MD5");
								byte[] digest = md5.digest(uploadBytes);
								String hashString = new BigInteger(1, digest).toString(16);
								stChecksum = hashString.trim();
							} catch (Exception e) {
								e.printStackTrace();
							}
							String xmldata = request.getParameter("xmlUploadData");
							if (!stChecksum.equals(xmldata)) {
								attr.addFlashAttribute("errors", " Error in saving data ...File Content changed");

								return "redirect:/AddMemberDetails";
							}

						} else {
							attr.addFlashAttribute("errors", " Invalid !!!");
							return "redirect:/AddMemberDetails";
						}
					} else {
						attr.addFlashAttribute("errors", " Invalid !!!");
						return "redirect:/AddMemberDetails";
					}
				} else {
					attr.addFlashAttribute("errors", "File Size should be more than 0 MB and less than 10MB. ");
					return "redirect:/AddMemberDetails";
				}

			}
		} else {

			attr.addFlashAttribute("errors", "please Upload Company ID pdf");
			return "redirect:/AddMemberDetails";
		}

		String response = "";
		List<String> errorMessage = new ArrayList<String>();
		if (result.hasErrors()) {
			List<ObjectError> errorList = result.getAllErrors();
			for (int i = 0; i < errorList.size(); i++) {
				String codes = errorList.get(i).getCodes()[1].substring(
						errorList.get(i).getCodes()[1].lastIndexOf(".") + 1, errorList.get(i).getCodes()[1].length());
				errorMessage.add(errorList.get(i).getDefaultMessage());
			}
			attr.addFlashAttribute("errors", errorMessage);
			response = "redirect:/AddMemberDetails";

		} else {
			InstituteMemberDetailDomain memDetail = davaServices.saveMemberDetails(memDtlForm, request);
			System.err.println("memDtlForm.getStrDocId()---- " + memDtlForm.getStrDocId());

			if (!memDtlForm.getStrDocId().trim().equals("-1")) {
				String sId = encodedservice.decode(memDtlForm.getStrDocId());
				String sId2 = reverse(sId);
				int numDocId = Integer.parseInt(encodedservice.decode(sId2));
				System.out.println("numDocId::::" + numDocId);
				String path = request.getContextPath() + "/numDocId" + ".pdf";// request.getContextPath()+"/"+numDocId+".pdf";
				davaServices.updateDocumentMstPath(path, numDocId);
			}

			attr.addFlashAttribute("flagSave", 1);
			response = "redirect:/AddMemberDetails";
		}
		return response;
	}

	@RequestMapping(value = "/previousMemberSiteDetails", method = RequestMethod.GET)
	public String backFromPreviewMemberSiteDetails(
			@ModelAttribute("registrationForm") MemberAddDtlModel memberAddDtlModel, HttpServletRequest request) {

		String response = "";

		List<StatesMst> state = locDao.getState();
		request.setAttribute("state", state);

		List<LicenseTypeMstDomain> lic = davaServices.getLicenseType();
		request.setAttribute("lic", lic);

		List<ApprovalTypeMst> app = davaDao.getApprovalType();
		request.setAttribute("app", app);

		Integer numPremiseNo = memberAddDtlModel.getNumPremiseNo();

		List<InstPremiseDtlDomain> inst = davaServices.getAllPremiseDtls(numPremiseNo);
		System.out.println("list of premise      " + inst.get(0).getGstin());

		// String manufacturingSiteList =
		// davaServices.createJSONManufacturingSiteDetail(numPremiseNo);
		// System.out.println("manufacturingSiteList "+manufacturingSiteList);
		// request.setAttribute("premisedata", inst);
		// request.getSession().setAttribute("manufacturingSiteListAfterSave",
		// manufacturingSiteList);
		// request.setAttribute("backFromPreview", 1);
		// approvaldtl_json(premiseno int4) licensedtl_json(premiseno int4)
		response = "redirect:/AddAddressDetails";

		// response= "AddressDetails";

		return response;
	}

	@RequestMapping(value = "/finalSubmitMemberSiteDetails", method = RequestMethod.POST)
	public String finalSubmitMemberSiteDetails(@ModelAttribute("registrationForm") MemberAddDtlModel memberAddDtlModel,
			HttpServletRequest request) {
		String response = "";
		request.setAttribute("backFromPreview", 0);
		request.removeAttribute("backFromPreview");
		request.getSession().removeAttribute("premisesNo");
		response = "redirect:/Dashboard";

		return response;
	}

	@GetMapping(value = "/AddManufSiteUser")
	public String AddManufSiteUser(@ModelAttribute("registrationForm") RegistrationForm registrationForm,
			HttpServletRequest request) {

		String loogedInUserId = SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		Integer instId = userDetails.get(0).getNumInstId();

		List<InstPremiseDtlDomain> instPreDtls = davaDao.getInstPremisesDtlsForSublogin(instId);
		request.setAttribute("instPreDtls", instPreDtls);
		return "manufSiteUser";
	}

	@PostMapping(value = "/saveManufUserDetail")
	public String SaveManufUserDetail(@ModelAttribute("registrationForm") RegistrationForm registrationForm,
			BindingResult result, HttpServletRequest request, RedirectAttributes attr) {

		// added by harshita for user login

		String username1 = registrationForm.getUserName();
		System.out.println("username1::" + username1);
		byte[] Encodedusername1 = Base64.getDecoder().decode(username1);
		String EU1 = new String(Encodedusername1);
		System.out.println("encodedusername1::" + Encodedusername1);
		StringBuffer reversedStringBuffer1 = new StringBuffer(EU1);
		reversedStringBuffer1.reverse();
		System.out.println("reversedStringBuffer::" + reversedStringBuffer1);
		String EN2 = new String(reversedStringBuffer1);
		System.out.println("EN2::" + EN2);
		byte[] EN3 = Base64.getDecoder().decode(EN2);
		String username = new String(EN3);
		registrationForm.setUserName(username);

		System.out.println("username::" + username);

		// byte[] decoded;
		// String value="";

		try {
			String pwd = registrationForm.getPassword();

			System.out.println("pwd::::::" + pwd);

			byte[] decodedBytes = Base64.getDecoder().decode(pwd);

			String decodedString = new String(decodedBytes);

			System.out.println("decodedString::::::" + decodedString);

			StringBuffer reversedStringBuffer = new StringBuffer(decodedString);
			reversedStringBuffer.reverse(); // reversing string

			System.out.println("reversedStringBuffer::" + reversedStringBuffer);

			String value1 = new String(reversedStringBuffer);

			System.out.println("value1::" + reversedStringBuffer);
			byte[] decodedBytes2 = Base64.getDecoder().decode(value1);

			String value4 = new String(decodedBytes2);

			System.out.println("value4::" + value4);

			/*
			 * decoded = new BASE64Decoder().decodeBuffer(registrationForm.getPassword());
			 * value =new String(decoded);
			 */
			String[] temp = value4.split(" ### ");
			if (temp.length == 3) {
				registrationForm.setPassword(temp[1].trim());
				System.out.println(temp[1].trim());
			} else {
				throw new Exception("Invalid Password Exception");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Random random = new Random(System.nanoTime() % 100000);
		int randomCode = random.nextInt(1000000000);
		registrationForm.setRandomCode(randomCode);
		// added by harshita on 160723
		String Username = registrationForm.getUserName();
		System.out.println("Username::" + Username);
		String encodedusername =

				encode(Username);
		System.out.println("encodedusername::" + encodedusername);
		String encodedusernameR = reverse(encodedusername);
		System.out.println("encodedusernameR::" + encodedusernameR);
		String encodedusername2 = encode(encodedusernameR);
		System.out.println("encodedusername2::" + encodedusername2);
		// registrationForm.setUserName(encodedusername2);
		String verificationLink = projectUrl + request.getContextPath() + "/emailVerification?iveda=" + encodedusername2
				+ "&randomCode=" + registrationForm.getRandomCode();

		RegistrationDetails userRegDomain = davaServices.saveManufUser(registrationForm, verificationLink);

		if (userRegDomain != null && userRegDomain.getUserId() != null) {
			// String seat = davaServices.updateSeatMaster(userRegDomain.getUserId());
			// sendmail.sendEmailToUser(userRegDomain.getUserName(), verificationLink);

			/*
			 * String emailVerificationSubject = emailContent.getEmailContent()
			 * .get("emailVerificationSubjectForManufacturingSite"); String
			 * emailVerificationContent = emailContent.getEmailContent()
			 * .get("emailVerificationContentForManufacturingSite");
			 * 
			 * emailVerificationContent =
			 * emailVerificationContent.replaceAll("\\$USER\\_NAME\\$", "Dear User"
			 * userRegDomain.getOrgName() ); emailVerificationContent =
			 * emailVerificationContent.replaceAll("\\$URL\\_LINK\\$", verificationLink);
			 * sendmail.sendMailToUser(userRegDomain.getUserName(),
			 * emailVerificationSubject, emailVerificationContent);
			 */

			String seat = davaServices.updateSeatMaster(userRegDomain.getUserId());
			davaServices.updateInstPremiseDtl(registrationForm.getManuUnit(), userRegDomain.getUserId());
			attr.addFlashAttribute("flagSave", 1);
			return "redirect:/AddManufSiteUser";

		} else {
			attr.addFlashAttribute("flagSave", 2);
			return "redirect:/AddManufSiteUser";
		}
		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * RegistrationDetails
		 * userRegDomain=davaServices.saveManufUser(registrationForm);
		 * if(userRegDomain.getUserId()!= null) {
		 * System.err.println("in not user id null----- "+userRegDomain.getUserId());
		 * String seat = davaServices.updateSeatMaster(userRegDomain.getUserId()); }
		 * return "redirect:/AddManufSiteUser";
		 */
	}

	@RequestMapping(value = "/getManufSiteUserList", method = RequestMethod.GET)
	@ResponseBody
	public String getManufSiteUserList(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("in data table code");
		String jsonResponse = davaServices.showManufSiteUserList(request);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}

	@RequestMapping(value = "/getAddedMemberList", method = RequestMethod.GET)
	@ResponseBody
	public String getAddedMemberList(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("in data table code");
		String jsonResponse = davaServices.showAddedMemberList(request);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}

	@RequestMapping(value = "/deleteMemberDetails", method = RequestMethod.POST)
	public String deleteMemberDetails(@ModelAttribute("memberDtlForm") MemberDetailForm memDtlForm,
			BindingResult result, HttpServletRequest request, RedirectAttributes attr) {

		System.out.println("IN Testing ACTION");
		String res = "";
		InstituteMemberDetailDomain memDtl = davaServices.deleteMemberDetails(memDtlForm);
		attr.addFlashAttribute("flagDelete", 1);
		res = "redirect:/AddMemberDetails";
		return res;

	}

	@RequestMapping(value = "/deleteManufUserDetail", method = RequestMethod.POST)
	public String deleteManufUserDetail(@ModelAttribute("registrationForm") RegistrationForm registrationForm,
			BindingResult result, HttpServletRequest request, RedirectAttributes attr) {

		System.out.println("IN Testing ACTION");
		String res = "";
		RegistrationDetails userRegDomain = davaServices.deleteManufUserDetail(registrationForm);
		attr.addFlashAttribute("flagDelete", 1);
		res = "redirect:/AddManufSiteUser";
		return res;

	}

	@RequestMapping(value = "/getAddedMemberData/{memId}", method = RequestMethod.GET)
	@ResponseBody
	public List<InstituteMemberDetailDomain> getAddedMemberData(@PathVariable int memId, HttpServletRequest request,
			HttpServletResponse response) {
		// int memberId = Integer.parseInt(memId);
		System.err.println("member id in jax call---- " + memId);
		List<InstituteMemberDetailDomain> instMemDomain = davaServices.getAddedMemberData(memId);
		return instMemDomain;
	}

	@RequestMapping(value = "/ManufacturingSiteListing", method = RequestMethod.GET)
	public String ManufacturingSiteListingData(@ModelAttribute("manuList") MemberAddDtlModel manuList,
			HttpServletRequest request) {
		String response = "";

		response = "manuListPage";

		return response;
	}

	@RequestMapping(value = "/getManufacturingSiteListing", method = RequestMethod.GET)
	@ResponseBody
	public String viewManufacturingSiteListing(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("in data table code");
		String jsonResponse = davaServices.ShowManufacturingSiteListing(request);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}

	@RequestMapping(value = "/EmailData", method = RequestMethod.GET)
	public String getEmailData(@ModelAttribute("emailDetialForm") EmailDetailForm emailDetialForm,
			HttpServletRequest request) {
		String response = "";

		response = "viewEmailData";

		return response;
	}

	@RequestMapping(value = "/getEmailData", method = RequestMethod.GET)
	@ResponseBody
	public String viewEmailData(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("in data table code");
		String jsonResponse = davaServices.showEmailData(request);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}

	@RequestMapping(value = "/updateMemberDetails", method = RequestMethod.POST)
	public String updateMemberDetails(
			@Validated(MemberDetails.class) @ModelAttribute("memberDtlForm") MemberDetailForm memDtlForm,
			BindingResult result, HttpServletRequest request, RedirectAttributes attr) {
		MultipartFile uploadfile = memDtlForm.getUploadfile();
		String value1 = request.getParameter("hashValue");
		String Value2 = decode(value1);
		String Value3 = reverse(Value2);
		String hashValue = Value3;
		System.out.println("hashValue:::" + hashValue);
		String FileNameOriginal = uploadfile.getOriginalFilename();
		String hash = null;
		System.out.println("IN Testing ACTION");
		String res = "";
		List<String> errorMessage = new ArrayList<String>();
		if (result.hasErrors()) {
			List<ObjectError> errorList = result.getAllErrors();
			for (int i = 0; i < errorList.size(); i++) {
				String codes = errorList.get(i).getCodes()[1].substring(
						errorList.get(i).getCodes()[1].lastIndexOf(".") + 1, errorList.get(i).getCodes()[1].length());
				errorMessage.add(errorList.get(i).getDefaultMessage());
			}
			attr.addFlashAttribute("errors", errorMessage);
			res = "redirect:/AddMemberDetails";

		} else {
			InstituteMemberDetailDomain memDtl = davaServices.updateMemberDetails(memDtlForm, request);
			attr.addFlashAttribute("flagUpdate", 1);
			res = "redirect:/AddMemberDetails";
		}
		return res;

	}

	@RequestMapping(value = "/updateManufUserDetail", method = RequestMethod.POST)
	public String updateManufUserDetail(@ModelAttribute("registrationForm") RegistrationForm registrationForm,
			BindingResult result, HttpServletRequest request, RedirectAttributes attr) {

		System.out.println("IN Testing ACTION");
		System.err.println("password--- " + registrationForm.getPassword());
		String res = "";
		List<String> errorMessage = new ArrayList<String>();
		if (result.hasErrors()) {
			List<ObjectError> errorList = result.getAllErrors();
			for (int i = 0; i < errorList.size(); i++) {
				String codes = errorList.get(i).getCodes()[1].substring(
						errorList.get(i).getCodes()[1].lastIndexOf(".") + 1, errorList.get(i).getCodes()[1].length());
				errorMessage.add(errorList.get(i).getDefaultMessage());
			}
			attr.addFlashAttribute("errors", errorMessage);
			res = "redirect:/AddManufSiteUser";

		} else {
			RegistrationDetails userRegDomain = davaServices.updateManufUserDetail(registrationForm, request);
			attr.addFlashAttribute("flagUpdate", 1);
			res = "redirect:/AddManufSiteUser";
		}
		return res;

	}

	@RequestMapping(value = "/RegistrationPendingApproval", method = RequestMethod.GET)
	public String RegistrationPendingApprovalData(@ModelAttribute("registrationForm") RegistrationForm registrationForm,
			HttpServletRequest request) {
		// added by harshita on 140723

		String response = "";
		Random random = new Random(System.nanoTime() % 100000);
		int randomCode = random.nextInt(1000000000);
		registrationForm.setRandomCode(randomCode);
		registrationForm.setToken(randomCode + "");
		request.getSession().setAttribute("randomCode", randomCode + "");
		response = "RegistrationPending";
		// System.out.println(" randomCode user" + randomCode);
		return response;
	}

	@RequestMapping(value = "/getRegistrationPendingListing", method = RequestMethod.GET)
	@ResponseBody
	public String viewRegistrationPendingListing(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("in data table code");
		String jsonResponse = davaServices.ShowRegistrationPendingListing(request);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}

	@RequestMapping(value = "/ApprovedRegistration", method = RequestMethod.GET)
	public String ApprovedRegistrationData(@ModelAttribute("registrationForm") RegistrationForm registrationForm,
			HttpServletRequest request) {
		String response = "";

		response = "RegistrationApproved";

		return response;
	}

	@RequestMapping(value = "/RejectedRegistration", method = RequestMethod.GET)
	public String RejectedRegistrationData(@ModelAttribute("registrationForm") RegistrationForm registrationForm,
			HttpServletRequest request) {
		String response = "";

		response = "RegistrationRejected";

		return response;
	}

	@RequestMapping(value = "/getApprovedRegistrationListing", method = RequestMethod.GET)
	@ResponseBody
	public String viewApprovedRegistrationListing(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("in data table code");
		String jsonResponse = davaServices.ShowApprovedRegistrationListing(request);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
//		System.out.println("MEHNAT"+jsonResponse);
		return jsonResponse;
	}

	@RequestMapping(value = "/getRejectedRegistrationListing", method = RequestMethod.GET)
	@ResponseBody
	public String viewgetRejectedRegistrationListing(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("in data table code");
		String jsonResponse = davaServices.ShowRejectedRegistrationListing(request);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}

	@RequestMapping(value = "/updateUserRegForApproval", method = RequestMethod.POST)
	public String updateUserRegForApproval(@ModelAttribute("registrationForm") RegistrationForm registrationForm,
			BindingResult result, HttpServletRequest request, RedirectAttributes attr) {

		System.out.println("IN Testing ACTION");
		String res = "";

		Long userId = registrationForm.getUserId();
		String userName = registrationForm.getUserName();
		// Integer instId = registrationForm.getNumInstId();
		// getUserDetailfromUserId(Long)

		String seat = davaServices.updateSeatMaster(userId);
		String token = registrationForm.getToken();

		/*
		 * Random random = new Random(System.nanoTime() % 100000); int randomCode =
		 * random.nextInt(1000000000); registrationForm.setRandomCode(randomCode);
		 * registrationForm.setToken (randomCode+"");
		 */
		// System.out.println( " randomCode user" + randomCode);

		try {
			String reason = registrationForm.getStrReason();

			System.out.println("reason::::::" + reason);

			byte[] decodedBytes = Base64.getDecoder().decode(reason);

			String decodedString = new String(decodedBytes);

			System.out.println("decodedString::::::" + decodedString);

			StringBuffer reversedStringBuffer = new StringBuffer(decodedString);
			reversedStringBuffer.reverse(); // reversing string

			System.out.println("reversedStringBuffer::" + reversedStringBuffer);

			String value1 = new String(reversedStringBuffer);

			System.out.println("value1::" + reversedStringBuffer);
			byte[] decodedBytes2 = Base64.getDecoder().decode(value1);

			String value4 = new String(decodedBytes2);

			System.out.println("value4::" + value4);

			/*
			 * decoded = new BASE64Decoder().decodeBuffer(registrationForm.getPassword());
			 * value =new String(decoded);
			 */
			String[] temp = value4.split(" ### ");
			if (temp.length == 3 && temp[0].trim().equals(userName) && temp[2].trim().equals(token)) {
				registrationForm.setStrReason(temp[1].trim());
				System.out.println(temp[1].trim());
			} else {
				throw new Exception("Invalid Reason");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("updateUserRegForApprovalDetails " + userId + " userName" + userName);
		davaServices.updateUserRegForApprovalDetails(registrationForm, userId, userName, request);
		System.out.println("OK ");

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<RegistrationForm>> violations = validator.validate(registrationForm);
		boolean violationResult = false;

		for (ConstraintViolation<RegistrationForm> violation : violations) {
			LOGGER.error("Server Side Validation Exception in RegistrationForm :" + violation.getMessage());
			if (violation.getMessage().equals("Please enter a valid Reason")) {
				violationResult = true;
			}
		}
		if (violationResult) {
			attr.addFlashAttribute("dataViolation", 1);
			res = "redirect:/RegistrationPendingApproval";
			return res;
		}

		/*
		 * String
		 * loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName
		 * (); List<RegistrationDetails> userDetails
		 * =davaDao.getUserDetails(loogedInUserId); int instId =
		 * userDetails.get(0).getNumInstId();
		 */
		List<RegistrationDetails> rd = davaDao.getRegistrationDetails(userId);
		int instId = rd.get(0).getNumInstId();
		List<InstituteMasterDomain> inst = davaServices.getInstituteData(instId);
		String code = inst.get(0).getStrManufCode();

		String subject = emailContent.getEmailContent().get("pharmaexcilApproveSubject");
		String content = emailContent.getEmailContent().get("pharmaexcilApproveContent");
		content = content.replaceAll("\\$USER\\_NAME\\$", rd.get(0).getOrgName());
		content = content.replaceAll("\\$REG\\_CODE\\$", code);

		// sendmail.transferToMailServer(registrationForm.getUserName(), "Your
		// registration is approved.", "Reason for your Approval is
		// "+registrationForm.getStrReason()+ " and Your Code is "+code);

		boolean result1 = sendmail.sendMailToUser(registrationForm.getUserName(), subject, content);

		davaServices.addDataToEmailMst("Registration Approval Process", request);

		davaServices.addEmailDetailsToDb(userId, registrationForm.getUserName(), "Your registration is approved.",
				"Reason for your Approval is " + registrationForm.getStrReason() + " and Your Code is " + code,
				request);

		attr.addFlashAttribute("flagUpdateApp", 1);
		res = "redirect:/RegistrationPendingApproval";
		return res;

	}

	@RequestMapping(value = "/updateUserRegForRejection", method = RequestMethod.POST)
	public String updateupdateUserRegForRejection(@ModelAttribute("registrationForm") RegistrationForm registrationForm,
			BindingResult result, HttpServletRequest request, RedirectAttributes attr) {

		// added by harshita 140723

		// Integer instId = registrationForm.getNumInstId();
		// getUserDetailfromUserId(Long)

		Long userId1 = registrationForm.getUserId();
		String userName1 = registrationForm.getUserName();
		// Integer instId = registrationForm.getNumInstId();
		// getUserDetailfromUserId(Long)

		String seat = davaServices.updateSeatMaster(userId1);

		String token = registrationForm.getToken();

		/*
		 * Random random = new Random(System.nanoTime() % 100000); int randomCode =
		 * random.nextInt(1000000000); registrationForm.setRandomCode(randomCode);
		 * registrationForm.setToken (randomCode+"");
		 */
		// System.out.println( " randomCode user" + randomCode);

		try {
			String reason = registrationForm.getStrReason();

			System.out.println("reason::::::" + reason);

			byte[] decodedBytes = Base64.getDecoder().decode(reason);

			String decodedString = new String(decodedBytes);

			System.out.println("decodedString::::::" + decodedString);

			StringBuffer reversedStringBuffer = new StringBuffer(decodedString);
			reversedStringBuffer.reverse(); // reversing string

			System.out.println("reversedStringBuffer::" + reversedStringBuffer);

			String value1 = new String(reversedStringBuffer);

			System.out.println("value1::" + reversedStringBuffer);
			byte[] decodedBytes2 = Base64.getDecoder().decode(value1);

			String value4 = new String(decodedBytes2);

			System.out.println("value4::" + value4);

			/*
			 * decoded = new BASE64Decoder().decodeBuffer(registrationForm.getPassword());
			 * value =new String(decoded);
			 */
			String[] temp = value4.split(" ### ");
			if (temp.length == 3 && temp[0].trim().equals(userName1) && temp[2].trim().equals(token)) {
				registrationForm.setStrReason(temp[1].trim());
				System.out.println(temp[1].trim());
			} else {
				throw new Exception("Invalid Reason");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<RegistrationForm>> violations = validator.validate(registrationForm);
		boolean violationResult = false;
		String res = "";
		for (ConstraintViolation<RegistrationForm> violation : violations) {
			LOGGER.error("Server Side Validation Exception in RegistrationForm :" + violation.getMessage());
			if (violation.getMessage().equals("Please enter a valid Reason")) {
				violationResult = true;
			}
		}
		if (violationResult) {
			attr.addFlashAttribute("dataViolation", 1);
			res = "redirect:/RegistrationPendingApproval";
			return res;
		}

		System.out.println("IN MAIL SEND ACTION");

		Long userId = registrationForm.getUserId();
		String userName = registrationForm.getUserName();
		String smsContent = "Your registration is rejected ,Reason for your Rejection is "
				+ registrationForm.getStrReason();
		Optional<RegistrationDetails> registrationDetails = userRepository.findById(userId);
		RegistrationDetails rg = registrationDetails.get();
		System.out.println(rg.getOrgName());
		String mobNo = rg.getContPerMobileNo();

		davaServices.updateUserRegForRejectionDetails(registrationForm, userId, userName, request);

		String subject = emailContent.getEmailContent().get("pharmaexcilRejectSubject");
		String content = emailContent.getEmailContent().get("pharmaexcilRejectContent");
		content = content.replaceAll("\\$USER\\_NAME\\$", rg.getOrgName());
		content = content.replaceAll("\\$REJ\\_REASON\\$", registrationForm.getStrReason());

		boolean result1 = sendmail.sendMailToUser(registrationForm.getUserName(), subject, content);
		// sendmail.transferToMailServer(registrationForm.getUserName(), "Your
		// registration is rejected.", "Reason for your Rejection is
		// "+registrationForm.getStrReason());

		davaServices.addDataToEmailMst("Registration Rejection Process", request);

		davaServices.addEmailDetailsToDb(userId, registrationForm.getUserName(), "Your registration is rejected.",
				"Reason for your Rejection is " + registrationForm.getStrReason(), request);

		System.out.println("sms");

		SMSHttpPostClient.sendSingleSMS(mobNo, smsContent);

		attr.addFlashAttribute("flagUpdateReject", 1);
		res = "redirect:/RegistrationPendingApproval";
		return res;

	}

	@RequestMapping(value = "/resendVerificationLink", method = RequestMethod.POST)
	public synchronized String resendVerificationLink(
			@ModelAttribute("registrationForm") RegistrationForm registrationForm, BindingResult result,
			HttpServletRequest request, RedirectAttributes attr) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<RegistrationForm>> violations = validator.validate(registrationForm);
		boolean violationResult = false;
		String res = "";
		for (ConstraintViolation<RegistrationForm> violation : violations) {
			LOGGER.error("Server Side Validation Exception in RegistrationForm :" + violation.getMessage());
			if (violation.getMessage().equals("Please enter a valid Reason")) {
				violationResult = true;
			}
		}
		if (violationResult) {
			attr.addFlashAttribute("dataViolation", 1);
			res = "redirect:/RegistrationPendingApproval";
			return res;
		}

		System.out.println("IN Testing ACTION");

		Long userId = registrationForm.getUserId();

		// String userName = registrationForm.getUserName();

		String encodedUN = registrationForm.getUserName();
		System.out.println("  encodedUN " + encodedUN);
		String decodedUN = decode(encodedUN);
		System.out.println("  decodedUN " + decodedUN);
		String decodeUNR = reverse(decodedUN);
		System.out.println("  decodeUNR " + decodeUNR);
		String decodedUN2 = decode(decodeUNR);
		System.out.println("  decodedUN2 " + decodedUN2);
		registrationForm.setUserName(decodedUN2);

		Optional<RegistrationDetails> registrationDetails = userRepository.findById(userId);
		RegistrationDetails rg = registrationDetails.get();

		System.out.println("----------------------------------------------------------------");

		// Added by Govind 080923
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDateTime expirationTime = LocalDateTime.now().plusHours(1);
		rg.setExpirationTime(expirationTime);
		System.out.println("Expiration Time of Verification Link :: " + expirationTime);

		// Add resend email verification link ()
		String verificationLinkE = rg.getVerificationLink();
		String pattern = "randomCode=([0-9]+)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(verificationLinkE);
		if (m.find()) {
			String randomCode = m.group(1);
			int randomCodeExt = Integer.parseInt(randomCode);
			// System.out.println("Random Code Extracted: " + randomCode);
			rg.setRandomNumber(randomCodeExt);
		}

		System.out.println(rg.getContactPersonName() + "   " + rg.getVerificationLink());

		String emailVerificationSubject = emailContent.getEmailContent().get("emailVerificationSubject");
		String emailVerificationContent = emailContent.getEmailContent().get("emailVerificationContent");

		emailVerificationContent = emailVerificationContent.replaceAll("\\$USER\\_NAME\\$", rg.getContactPersonName());
		emailVerificationContent = emailVerificationContent.replaceAll("\\$URL\\_LINK\\$", rg.getVerificationLink());

		// approach started here
		String result1 = daoHelper.getcount("username_sendmailcount", rg.getUserName());
		int mailcount = Integer.parseInt(result1);
		if (mailcount == 0) {// for every first time user
			sendmail.sendMailToUser(registrationForm.getUserName(), emailVerificationSubject, emailVerificationContent);
			LocalDateTime resendVerificationMail = LocalDateTime.now().plusHours(1);
			rg.setResendVerificationTime(resendVerificationMail);
			// for the already saved user link
			System.out.println("Mail sent to user with count : " + mailcount);
			davaServices.addDataToEmailMst("Email Verification Process", request);
			davaServices.addEmailDetailsToDb(userId, rg.getUserName(), "Email Verification Link",
					rg.getVerificationLink(), request);
			userRepository.save(rg);
			attr.addFlashAttribute("ResendLink", 1);
			res = "redirect:/RegistrationPendingApproval";
			return res;
		}

		else if (mailcount >= 1 && mailcount <= 4) {
			// for the already saved user link
			if (currentTime.isAfter(rg.getResendVerificationTime())) {
				sendmail.sendMailToUser(registrationForm.getUserName(), emailVerificationSubject,
						emailVerificationContent);
				LocalDateTime resendVerificationMail = LocalDateTime.now().plusHours(1);
				rg.setResendVerificationTime(resendVerificationMail);
				System.out.println("Mail sent to user with count : " + mailcount);
				davaServices.addDataToEmailMst("Email Verification Process", request);
				davaServices.addEmailDetailsToDb(userId, rg.getUserName(), "Email Verification Link",
						rg.getVerificationLink(), request);
				userRepository.save(rg);
				attr.addFlashAttribute("ResendLink", 1);
				res = "redirect:/RegistrationPendingApproval";
				return res;
			} else {// before an hour

				attr.addFlashAttribute("errors", 2);
				res = "redirect:/RegistrationPendingApproval";

			}

		} else {// maximum limit reached
			attr.addFlashAttribute("errors", 3);
			res = "redirect:/RegistrationPendingApproval";
		}
		// userRepository.save(rg);
		return res;
	}

	@RequestMapping(value = "/returnRegistrationOfUser", method = RequestMethod.POST)
	public String returnRegistrationOfUser(@ModelAttribute("registrationForm") RegistrationForm registrationForm,
			BindingResult result, HttpServletRequest request, RedirectAttributes attr) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<RegistrationForm>> violations = validator.validate(registrationForm);
		boolean violationResult = false;
		String res = "";
		for (ConstraintViolation<RegistrationForm> violation : violations) {
			LOGGER.error("Server Side Validation Exception in RegistrationForm :" + violation.getMessage());
			if (violation.getMessage().equals("Please enter a valid Reason")) {
				violationResult = true;
			}
		}
		if (violationResult) {
			attr.addFlashAttribute("dataViolation", 1);
			res = "redirect:/RegistrationPendingApproval";
			return res;
		}

		System.out.println("IN Testing ACTION");

		Long userId = registrationForm.getUserId();
		String userName = registrationForm.getUserName();
		Optional<RegistrationDetails> registrationDetails = userRepository.findById(userId);
		RegistrationDetails rg = registrationDetails.get();
		System.out.println(rg.getOrgName());
		String mobNo = rg.getContPerMobileNo();

		davaServices.updateUserRegForRejectionDetails(registrationForm, userId, userName, request);

		res = "redirect:/RegistrationPendingApproval";
		return res;

	}

	@GetMapping("/getProductData")
	public ResponseEntity<List<DrugMst>> getProductData(@RequestParam("drugId") Integer drugId) {
		List<DrugMst> productDtls = davaServices.getProductCode(drugId);
		return new ResponseEntity<List<DrugMst>>(productDtls, HttpStatus.OK);
	}

	@GetMapping("/DummyCharts")
	@ResponseBody
	public Map<String, List<Long>> dummycharts(HttpServletRequest request) {

		Map<String, List<Long>> charts = new HashMap<String, List<Long>>();
		try {
			Long userId = userData.getUserId();
			charts = davaServices.getStateStatistics(userId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return charts;

	}

	@GetMapping("/getcntstat")
	@ResponseBody
	public Map<String, Integer> countrystat(HttpServletRequest request) {
		Map<String, Integer> countrychart = new HashMap<String, Integer>();
		try {
			Long userId = userData.getUserId();
			countrychart = davaServices.getCountryStatistics(userId);

		} catch (Exception e) {
		}
		return countrychart;

	}

	@GetMapping("/StatewiseSiteDetails")
	@ResponseBody
	public ModelAndView statewiseSiteDetailsStatistics(@RequestParam(value = "dist") Integer stateID,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		try {
			List<MemberAddDtlModel> memberAddDtlModellist = davaServices.getSitesDisplay(stateID);
			mv.addObject("siteList", memberAddDtlModellist);
			mv.addObject(stateID);
			mv.setViewName("StatewiseSiteDetails");

		} catch (Exception e) {
		}
		return mv;

	}

	@GetMapping("/exportHierarchyStatistics")
	public ModelAndView exporthrStatistics(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("exportHierarchyStatistics");
		return mv;
	}

	@GetMapping("/viewAllCountryExportStatisticsajax")
	@ResponseBody
	public Map<String, Integer> viewAllCountryExportStatisticajax(HttpServletRequest request) {
		Map<String, Integer> countrychart = new HashMap<String, Integer>();
		// ModelAndView mv=new ModelAndView();
		try {
			Long userId = userData.getUserId();
			countrychart = davaServices.getCountryStatistics(userId);

		} catch (Exception e) {
		}
		// mv.addObject("countrychart", countrychart);
		// mv.setViewName("viewAllCountryExportStatistics");
		return countrychart;

	}

	@GetMapping("/viewAllCountryExportStatistics")
	public ModelAndView viewAllCountryExportStatistic(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewAllCountryExportStatistics");
		return mv;
	}

	@GetMapping("/findByIecNumber")
	public String findByiecNumber(@RequestParam("iecNumber") String iecNumber) {
		String result = davaServices.findByiecNumber(iecNumber);
		return result;
	}

	@GetMapping("/findBygstnNumber")
	public String findBygstnNumber(@RequestParam("gstnNumber") String gstnNumber) {
		String result = davaServices.findBygstnNumber(gstnNumber);
		return result;
	}

	@RequestMapping(value = "/GeneratePackCode", method = RequestMethod.GET)
	public String GeneratePackCode(@ModelAttribute("generatePackModel") GeneratePackModel generatePackModel,
			HttpServletRequest request) {
		String response = "";

		response = "CodeGeneration";

		return response;
	}

	@RequestMapping(value = "/saveGeneratePackCode", method = RequestMethod.POST)
	public String saveGeneratePackCode(@ModelAttribute("generatePackModel") GeneratePackModel generatePackModel,
			BindingResult result, HttpServletRequest request, RedirectAttributes attr) {
		System.out.println("IN Testing ACTION");
		String res = "";

		CodeRequestMstDomain reqDom = davaServices.addGeneratePackCode(generatePackModel, request);
		attr.addFlashAttribute("flagSave", 1);
		res = "redirect:/GeneratePackCode";
		return res;
	}

	@RequestMapping(value = "/getGeneratePackCode", method = RequestMethod.GET)
	@ResponseBody
	public String viewGeneratePackCode(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("in data table code");
		String jsonResponse = davaServices.ShowGeneratePackCode(request);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}

	@RequestMapping(value = "/downloadExcelGeneratePack", method = RequestMethod.POST)
	public void downloadExcelGeneratePack(@RequestParam("packId") int reqId, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes attr) {
		System.out.println("IN Testing ACTION");
		String res = "";
		Integer requestId = Integer.parseInt(request.getParameter("packId"));
		System.out.println("requestId" + requestId);
		String crd = davaDao.getPackCode(requestId);
		String[] split = crd.split(",");
		List<String> srNumbers = new ArrayList<>();
		for (String data : split) {
			srNumbers.add(data);
		}

		String[] columns = { "Serial Numbers" };

		// Create a Workbook
		Workbook workbook = new XSSFWorkbook();

		/*
		 * CreationHelper helps us create instances of various things like DataFormat,
		 * Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way
		 */
		CreationHelper createHelper = workbook.getCreationHelper();

		// Create a Sheet
		Sheet sheet = workbook.createSheet("Serial Numbers");

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		// Create a Row
		Row headerRow = sheet.createRow(0);

		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}

		// Create Cell Style for formatting Date
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

		// Create Other rows and cells with employees data
		int rowNum = 1;
		for (String serialNumber : srNumbers) {
			Row row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(serialNumber);
		}

		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

		File file = new File(fileUploadingPath.getXsdPath() + requestId + ".xlsx");

		// Write the output to a file
		try {
			FileOutputStream fileOut = new FileOutputStream(file);
			workbook.write(fileOut);
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		File downloadPath = new File(fileUploadingPath.getXsdPath() + requestId + ".xlsx");

		if (file.exists()) {
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment;fileName=\"" + requestId + ".xlsx\"");
			int i;
			try {
				FileInputStream fileInputStream = new FileInputStream(downloadPath);
				PrintWriter out = response.getWriter();
				while ((i = fileInputStream.read()) != -1) {
					out.write(i);
				}
				fileInputStream.close();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				file.delete();
			}
		}
		// attr.addFlashAttribute("flagDownload", 1);

	}

	public String reverseUsingApacheCommons(String input) {
		return StringUtils.reverse(input);
	}

	@GetMapping("/updateProfile")
	public ModelAndView getUserProfilePage() {
		ModelAndView mv = new ModelAndView();
		Long userId = userData.getUserId();
		RegistrationForm regform = davaServices.getUserDetails(userId);

		String pannumber = decode(regform.getOrgPanNumber());
		String pannumber1 = reverseUsingApacheCommons(pannumber);
		String m = decode(pannumber1);
		regform.setOrgPanNumber(m);
		System.out.println("(decode(pannumber1))" + m);
		List<StatesMst> OrgstatesNames = davaServices.getStatedata(regform.getOrgCountryId());
		List<DistrictMst> OrgdistrictNames = davaServices.getDistrictNames(regform.getOrgStateId());

		String path = ftpProps.getPath();
		String finalPath = path + "/" + regform.getApplicantType() + "/" + userId;
		if (regform.getApplicantType().equals("101")) {
			String drugDetailsPath = finalPath + "/" + userId + "_drugDetails.pdf";
			if (ftpService.checkFileExist(drugDetailsPath))
				mv.addObject("drugPdf", "present");
		}

		String corporateAddressProofPath = finalPath + "/" + userId + "_corporateAddressProof.pdf";
		if (ftpService.checkFileExist(corporateAddressProofPath))
			mv.addObject("addressProof", "present");

		mv.addObject("UserName", regform.getUserName());
		mv.addObject("userId", regform.getApplicantType() + "_" + userId);
		mv.addObject("iecIssueDate", formattedDate(regform.getIecIssueDate()));
		mv.addObject("ssiIssueDate", formattedDate(regform.getSsiIssueDate()));
		mv.addObject("OrgstatesNames", OrgstatesNames);
		mv.addObject("OrgdistrictNames", OrgdistrictNames);
		mv.addObject("orgPanNumber", regform.getOrgPanNumber());
		mv.addObject("registrationForm", regform);
		mv.setViewName("userProfile");
		return mv;
	}

	// Changed By dipen for security check..
	@PostMapping("/updateProfile")
	public ModelAndView updateUserProfile(@ModelAttribute("registrationForm") RegistrationForm registrationForm,
			RedirectAttributes redirectAttributes, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();

		MultipartFile file = registrationForm.getAddressProofFile();

		MultipartFile drugLicence = registrationForm.getDrugLicence();
		GlobalAction globalAction = new GlobalAction();

		String hppValue = request.getParameter("hppGeneratedData");
		String Value1 = request.getParameter("hashValue");
		String value2 = decode(Value1);
		String value3 = reverse(value2);
		String hashValue = value3;
		String hppValue2 = null;
		String hashValue2 = null;
		String Value2 = null;
		String Value3 = null;
		String Value4 = null;
		if (drugLicence != null) {
			hppValue2 = request.getParameter("hppGeneratedData2");
			Value2 = request.getParameter("hashValue2");
			Value3 = decode(Value2);
			Value4 = reverse(Value3);
			hashValue2 = Value4;
		}
		System.out.println("hashValue:::" + hashValue);
		String hash = null;
		String hash2 = null;
		String fileName = null;
		if (file != null) {
			fileName = file.getOriginalFilename();
			System.out.println("file.getOriginalFilename()::::" + file.getOriginalFilename());
			String fakePath = "C:\\fakepath\\" + fileName + hppValue;
			hash = encodedservice.encode(fakePath);
			System.out.println("hash111:::" + hash);
		}
		if (drugLicence != null) {
			fileName = drugLicence.getOriginalFilename();
			System.out.println("fileName:::" + fileName + "::hppValue2::" + hppValue2);
			String fakePath = "C:\\fakepath\\" + fileName + hppValue2;
			hash2 = encodedservice.encode(fakePath);
			System.out.println("hash:::" + hash2);
		}

		String fileSize = null;
		String fileSize2 = null;
		String check1 = null;
		int urlcheck1 = 0;
		String check = null;
		int urlcheck = 0;
		if (file != null) {
			fileSize = file.getSize() / 1024 + " Kb";
			check = GlobalAction.validateFileContentType("pdf", file);
			urlcheck = GlobalAction.checkFileContainUrl(file);
		}

		if (registrationForm.getApplicantType().equals("101")) {
			if (drugLicence != null) {
				fileSize2 = drugLicence.getSize() / 1024 + " Kb";
				check1 = GlobalAction.validateFileContentType("pdf", drugLicence);
				urlcheck1 = GlobalAction.checkFileContainUrl(drugLicence);
			}
		}

		boolean fileValidationResult1 = false;
		boolean fileValidationResult2 = false;
		boolean fileValidationResult3 = false;
		boolean fileValidationResult = fileValidation.validatePdfFile(file);
		String addressFileHash = request.getParameter("addressProofDocument");
		fileValidationResult1 = fileValidation.validateAddressFileContent(file, addressFileHash);
		if (registrationForm.getApplicantType().equals("101")) {
			fileValidationResult2 = fileValidation.validatePdfFile(drugLicence);
			String drugFileHash = request.getParameter("drugLiecenseDocument");
			fileValidationResult3 = fileValidation.validateDrugFileContent(drugLicence, drugFileHash);
		}
		System.out.println("peek-a-boo");
		if (drugLicence != null) {
			if (registrationForm.getApplicantType().equals("101")) {
				if (Integer.parseInt(fileSize2.split(" ")[0]) < 10 * 1024
						&& Integer.parseInt(fileSize2.split(" ")[0]) > 0) {
					if (hash2.toString().equals(hashValue2)) {
						if (check1 != "12" && urlcheck1 != 19) {
							// if(check1 != "12") {
							davaServices.updateUserProfile(registrationForm);
							redirectAttributes.addFlashAttribute("updated", true);
							// redirectAttributes.addFlashAttribute("error",true);
						} else {
							redirectAttributes.addFlashAttribute("error", true);
							// redirectAttributes.addFlashAttribute("error", "File Invalid!!!");
							mv.setViewName("redirect:/updateProfile");
						}
					} else {
						redirectAttributes.addFlashAttribute("error", true);

						mv.setViewName("redirect:/updateProfile");
					}
				} else {
					redirectAttributes.addFlashAttribute("exception", true);

					// redirectAttributes.addFlashAttribute("error","File size should be more than 0
					// and less than 10 MB.");
					mv.setViewName("redirect:/updateProfile");

				}
			}
		} else {
			if (file != null) {
				if (Integer.parseInt(fileSize.split(" ")[0]) < 10 * 1024
						&& Integer.parseInt(fileSize.split(" ")[0]) > 0) {
					if (hash.toString().equals(hashValue)) {
						if (check != "12" && urlcheck != 19) {
							// if(check != "12") {
							davaServices.updateUserProfile(registrationForm);
							redirectAttributes.addFlashAttribute("updated", true);
						} else {
							redirectAttributes.addFlashAttribute("error", true);
							// redirectAttributes.addFlashAttribute("error", "File Invalid!!!");
							mv.setViewName("redirect:/updateProfile");
						}
					} else {
						redirectAttributes.addFlashAttribute("error", true);
						// redirectAttributes.addFlashAttribute("error", "File Invalid!!!");
						mv.setViewName("redirect:/updateProfile");
					}
				} else {
					redirectAttributes.addFlashAttribute("exception", true);

					mv.setViewName("redirect:/updateProfile");
				}
			} else {
				redirectAttributes.addFlashAttribute("error", true);

				// redirectAttributes.addFlashAttribute("error", "File Invalid!!!");
				mv.setViewName("redirect:/updateProfile");
			}

		}
		/*
		 * if(file!=null) { if(Integer.parseInt(fileSize.split(" ")[0]) < 10 * 1024 &&
		 * Integer.parseInt(fileSize.split(" ")[0]) >0) { if(check != "12" &&
		 * urlcheck!=19) { davaServices.updateUserProfile(registrationForm);
		 * redirectAttributes.addFlashAttribute("updated", true); }else {
		 * redirectAttributes.addFlashAttribute("error",true);
		 * redirectAttributes.addFlashAttribute("error", "File Invalid!!!");
		 * mv.setViewName("redirect:/updateProfile"); } }else {
		 * redirectAttributes.addFlashAttribute("exception", true);
		 * redirectAttributes.addFlashAttribute("error",
		 * "File size should be more than 0 and less than 10 MB.");
		 * mv.setViewName("redirect:/updateProfile"); } }else {
		 * davaServices.updateUserProfile(registrationForm);
		 * redirectAttributes.addFlashAttribute("updated", true); }
		 */
		/*
		 * if(!fileValidationResult) {
		 * redirectAttributes.addFlashAttribute("error",true); }else {
		 * davaServices.updateUserProfile(registrationForm);
		 * redirectAttributes.addFlashAttribute("updated", true); }
		 */
		mv.setViewName("redirect:/updateProfile");
		return mv;
	}

	@GetMapping("/downloadPdf")
	public void downloadFile(@RequestParam("fileName") String fileName, HttpServletRequest request,
			HttpServletResponse response) {
		String[] splitName = fileName.split("_");
		String path = ftpProps.getPath();
		String finalPath = path + "/" + splitName[0] + "/" + splitName[1];
		String name = "";

		if (splitName[2].equals("drug"))
			name = splitName[1] + "_drugDetails.pdf";
		else
			name = splitName[1] + "_corporateAddressProof.pdf";

		String realPath = finalPath + "/" + name;
		response.setContentType("application/pdf");
		ServletOutputStream out = null;
		try {
			out = response.getOutputStream();
		} catch (IOException e) {

			e.printStackTrace();
		}
		ftpService.downloadFiles(realPath, out);
	}

	@PostMapping("/xmlChecksum")
	public @ResponseBody String getxmlCheckSum(@RequestParam("uploadfile") MultipartFile file) {
		String stChecksum = "";
		try {
			byte[] uploadBytes = file.getBytes();
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] digest = md5.digest(uploadBytes);
			String hashString = new BigInteger(1, digest).toString(16);
			stChecksum = hashString.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stChecksum;
	}

	@PostMapping("/getSignatureChecksum")
	public @ResponseBody String getSignatureChecksum(@RequestParam("addressProofFile") MultipartFile file) {
		String stChecksum = "";
		try {
			byte[] uploadBytes = file.getBytes();
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] digest = md5.digest(uploadBytes);
			String hashString = new BigInteger(1, digest).toString(16);
			stChecksum = hashString.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stChecksum;
	}

	@PostMapping("/getdrugChecksum")
	public @ResponseBody String getdrugChecksum(@RequestParam("drugLicence") MultipartFile file) {
		String stChecksum = "";
		try {
			byte[] uploadBytes = file.getBytes();
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] digest = md5.digest(uploadBytes);
			String hashString = new BigInteger(1, digest).toString(16);
			stChecksum = hashString.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stChecksum;
	}

	@RequestMapping(value = "/PortOfExport", method = RequestMethod.GET)
	public String PortOfExport(@ModelAttribute("portOfExportModel") PortOfExportModel portOfExportModel,
			HttpServletRequest request) {
		String response = "";

		List<StatesMst> state = locDao.getState();
		request.setAttribute("state", state);

		response = "ExportPort";

		return response;
	}

	@RequestMapping(value = "/savePortOfExport", method = RequestMethod.POST)
	public String savePortOfExport(@ModelAttribute("portOfExportModel") PortOfExportModel portOfExportModel,
			BindingResult result, HttpServletRequest request, RedirectAttributes attr) {
		System.out.println("IN Testing ACTION");
		String res = "";

		// CodeRequestMstDomain reqDom =
		// davaServices.addGeneratePackCode(generatePackModel,request);
		PortOfExportDomain port = davaServices.savePortOfExport(portOfExportModel, request);
		attr.addFlashAttribute("flagSave", 1);
		res = "redirect:/PortOfExport";
		return res;
	}

	@RequestMapping(value = "/AboutUs", method = RequestMethod.GET)
	public String AboutUs(@ModelAttribute("aboutUsModel") AboutUsModel aboutUsModel, HttpServletRequest request) {

		String response = "";

		response = "AboutUs";

		return response;
	}

	@RequestMapping(value = "/saveAboutUs", method = RequestMethod.POST)
	public String saveAboutUs(@ModelAttribute("aboutUsModel") AboutUsModel aboutUsModel, BindingResult result,
			HttpServletRequest request, RedirectAttributes attr) {
		String res = "";
		System.err.println("in save about us");

		String aboutus = aboutUsModel.getAboutUs();
		try {
			PropertiesConfiguration properties = new PropertiesConfiguration(
					fileUploadingPath.getDynamicPropertiesPath());
			properties.setProperty("homepage.aboutus", aboutus);
			properties.save();
			System.out.println("dynamic homepage properties updated Successfully!!");
		} catch (ConfigurationException e) {
			System.out.println(e.getMessage());
		}

		res = "redirect:/AboutUs";
		return res;
	}

	@RequestMapping(value = "/NewsEvents", method = RequestMethod.GET)
	public String NewsEvents(@ModelAttribute("newsEventsModel") NewsEventsModel newsEventsModel,
			HttpServletRequest request) {

		String response = "";

		List<NewsEventMstDomain> eventTpeList = davaServices.getEventType();
		request.setAttribute("eventTypeList", eventTpeList);
		response = "NewsEvents";

		return response;
	}

	@RequestMapping(value = "/saveNewsEvents", method = RequestMethod.POST)
	public String saveNewsEvents(@ModelAttribute("newsEventsModel") NewsEventsModel newsEventsModel,
			BindingResult result, HttpServletRequest request, RedirectAttributes attr) {
		String res = "";
		System.err.println("in save newsEventsModel");

		NewsEventsDomain newsEvents = davaServices.saveNewsEvents(newsEventsModel, request);
		attr.addFlashAttribute("flagSave", 1);

		res = "redirect:/NewsEvents";
		return res;
	}

	@RequestMapping(value = "/HSAPDF", method = RequestMethod.GET)
	public ModelAndView getSearchPagePDF(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		SolrSearchModel solrSearchModel = new SolrSearchModel();
		mv.addObject("solrSearchModel", solrSearchModel);
		mv.setViewName("HSAPDF");
		return mv;
	}

	@RequestMapping(value = "/HSAPDF", method = RequestMethod.POST)
	public ModelAndView indexSearchPagePDF(@ModelAttribute("solrSearchModel") SolrSearchModel solrSearchModel) {
		String freshImport = solrSearchModel.getFreshImport();
		ModelAndView mv = new ModelAndView();
		davaServices.indexSearchPageDB(freshImport);
		mv.addObject("solrSearchModel", solrSearchModel);
		mv.setViewName("HSAPDF");
		return mv;
	}

	@RequestMapping(value = "/getPortOfExport", method = RequestMethod.GET)
	@ResponseBody
	public String viewPortOfExport(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("in data table code");
		String jsonResponse = davaServices.ShowPortOfExport(request);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}

	/*
	 * @GetMapping("/galleryform") public ModelAndView
	 * getGalleryform(HttpServletRequest request) { ModelAndView mv = new
	 * 
	 * ModelAndView(); galleryForm gallerobj = new galleryForm();
	 * mv.addObject("galleryForm", gallerobj); String limit = "ALL";
	 * 
	 * List<galleryForm> eventlist = davaServices.getEventlist(limit);
	 * mv.addObject("eventList", eventlist); mv.setViewName("galleryform"); return
	 * 
	 * mv; }
	 * 
	 * 
	 * @PostMapping("/galleryform") public ModelAndView
	 * galleryform(@ModelAttribute("galleryForm") galleryForm fv, HttpServletRequest
	 * request, RedirectAttributes redirectAttributes) { ModelAndView mv = new
	 * 
	 * ModelAndView(); galleryFormentity bean = new galleryFormentity(); // Get the
	 * uploaded files and store them List<MultipartFile> files =
	 * 
	 * fv.getGalleryImage(); List<String> fileNames = new ArrayList<String>();
	 * 
	 * String strList = null; boolean result = false; if (null != files &&
	 * 
	 * 
	 * files.size() > 0) { int i = 1; for (MultipartFile multipartFile : files) {
	 * 
	 * String fileName = multipartFile.getOriginalFilename(); String filename =
	 * 
	 * fileName.split("\\.")[0]; String extension = fileName.split("\\.")[1];
	 * 
	 * System.out.println("filename==" + filename); System.out.println("extension=="
	 * + extension);
	 * 
	 * String basename = i + "." + extension; i++; // if(file.renameTo(newFile)){}
	 * 
	 * 
	 * 
	 * // fileNames.add(fileName); String rootDirectory = ftpProps.getDirectory();
	 * 
	 * String dateWithoutTime = ""; dateWithoutTime =
	 * davaServices.formattedDate(fv.getEventDate());
	 * 
	 * String dashless = dateWithoutTime.replaceAll("-", ""); // String finalPath =
	 * rootDirectory + "//" + "Eventgallery" + "//" + // fv.getEventPlace() +
	 * 
	 * 
	 * dashless + "//" // + basename; String finalPath = fv.getEventPlace() +
	 * dashless + "/" + basename; String actualpath = rootDirectory + "//" +
	 * "Eventgallery" + "//" + fv.getEventPlace() + dashless + "//"; try { result =
	 * ftpService.uploadFile(actualpath + basename, multipartFile.getInputStream(),
	 * actualpath); System.out.println(result); } catch (IOException e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * fileNames.add(finalPath); System.out.println("fileNames===" + fileNames);
	 * 
	 * }
	 * 
	 * StringBuilder sbString = new StringBuilder(""); // iterate through ArrayList
	 * 
	 * for (String imagepaths : fileNames) {
	 * 
	 * // append ArrayList element followed by comma
	 * sbString.append(imagepaths).append(","); }
	 * 
	 * 
	 * // convert StringBuffer to String strList = sbString.toString();
	 * 
	 * 
	 * // remove last comma from String if you want if (strList.length() > 0)
	 * 
	 * strList = strList.substring(0, strList.length() - 1);
	 * 
	 * System.out.println("final patn string==" + strList);
	 * 
	 * 
	 * } request.setAttribute("gallerypathlist", strList); if (result == false) {
	 * 
	 * redirectAttributes.addFlashAttribute("uploadedResult", 1); } else { bean =
	 * 
	 * davaServices.savegalleryform(fv, request);
	 * redirectAttributes.addFlashAttribute("uploadedResult", 2); }
	 * 
	 * mv.setViewName("redirect:/galleryform"); return mv; }
	 */

	@GetMapping("/deletegallerydata")
	@ResponseBody
	public String deleteGalleryData(@RequestParam(value = "pUID") Long galleryId, HttpServletRequest request) {

		String memberAddDtlModellist = null;

		try {
			memberAddDtlModellist = davaServices.deletegallerydetail(galleryId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return memberAddDtlModellist;

	}

	/*
	 * @GetMapping("/getgalleryimage")
	 * 
	 * @ResponseBody public Map<String, List<String>>
	 * processEncodedRequestNew(@RequestParam(value = "limit") String limit,
	 * HttpServletRequest request, HttpServletResponse response) {
	 * 
	 * // Map<Long, List<String>> charts = new HashMap<Long, List<String>>();
	 * 
	 * Map<String, List<String>> charts = new HashMap<String, List<String>>();
	 * 
	 * List<galleryForm> eventlist = davaServices.getEventlist(limit); String
	 * values[] = null; try {
	 * 
	 * 
	 * for (int i = 0; i < eventlist.size(); i++) { String listimg =
	 * eventlist.get(i).getGalleryImagepath();
	 * 
	 * // Long galId = eventlist.get(i).getGalleryId();
	 * 
	 * String galId = eventlist.get(i).getGalleryId();
	 * 
	 * // String galId = eventlist.get(i).getGalleryId();
	 * 
	 * 
	 * values = listimg.split(","); System.out.println("realpath====" + values +
	 * "galid::::" + galId); String imagetag = ""; for (int j = 0; j <
	 * 
	 * values.length; j++) { List<String> finalimgpaths = new ArrayList<String>();
	 * 
	 * OutputStream ss = ftpService.getFilesimage(values[j]); byte[] imageBytes =
	 * ((ByteArrayOutputStream) ss).toByteArray(); String base64Image =
	 * Base64.getEncoder().encodeToString(imageBytes); imagetag +=
	 * "<img src=data:image/jpg;base64," + base64Image +
	 * " class='zoom img-fluid' />@##";
	 * 
	 * 
	 * imagetag += "<img src=images/Eventgallery/" + values[j] +
	 * " class='zoom img-fluid' alt='Gallery Images'/>@##";
	 * 
	 * finalimgpaths.add(imagetag); String gallerynNamesstring =
	 * eventlist.get(i).getEventName();
	 * 
	 * finalimgpaths.add(gallerynNamesstring); charts.put(galId, finalimgpaths); }
	 * 
	 * 
	 * 
	 * }
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * 
	 * return charts; }
	 */

	/*
	 * @GetMapping("/getgalleryimage")
	 * 
	 * @ResponseBody public Map<Long, List<String>>
	 * processEncodedRequestNew(@RequestParam(value = "limit") String
	 * limit,HttpServletRequest request, HttpServletResponse response) {
	 * 
	 * Map<Long, List<String>> charts = new HashMap<Long, List<String>>();
	 * List<galleryForm> eventlist = davaServices.getEventlist(limit); String
	 * values[] = null; try {
	 * 
	 * for (int i = 0; i < eventlist.size(); i++) { String listimg =
	 * eventlist.get(i).getGalleryImagepath(); //Long galId =
	 * eventlist.get(i).getGalleryId();
	 * 
	 * String galId = eventlist.get(i).getGalleryId();
	 * 
	 * values = listimg.split(","); //System.out.println("realpath====" + values);
	 * String imagetag=""; for (int j = 0; j < values.length; j++) { List<String>
	 * finalimgpaths = new ArrayList<String>();
	 * 
	 * OutputStream ss = ftpService.getFilesimage(values[j]); byte[] imageBytes =
	 * ((ByteArrayOutputStream) ss).toByteArray(); String base64Image =
	 * Base64.getEncoder().encodeToString(imageBytes); imagetag +=
	 * "<img src=data:image/jpg;base64," + base64Image +
	 * " class='zoom img-fluid' />@##";
	 * 
	 * 
	 * imagetag += "<img src=images/Eventgallery/"+ values[j] +
	 * " class='zoom img-fluid' alt='Gallery Images'/>@##";
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * finalimgpaths.add(imagetag); String gallerynNamesstring =
	 * eventlist.get(i).getEventName();
	 * 
	 * finalimgpaths.add(gallerynNamesstring); charts.put(galId, finalimgpaths); }
	 * 
	 * 
	 * }
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * 
	 * return charts; }
	 */
	/*
	 * @GetMapping("/getmaingalleryimage")
	 * 
	 * @ResponseBody public Map<Long, List<String>>
	 * processEncodedRequestNewmain(@RequestParam(value = "limit") String limit,
	 * HttpServletRequest request, HttpServletResponse response) { //
	 * System.out.println("limit=="+limit); // String limit="5"; Map<Long,
	 * List<String>> charts = new HashMap<Long, List<String>>(); List<galleryForm>
	 * eventlist = davaServices.getEventlist(limit); String values[] = null; try {
	 * 
	 * for (int i = 0; i < eventlist.size(); i++) { String listimg =
	 * eventlist.get(i).getGalleryImagepath();
	 * 
	 * // Long galId = eventlist.get(i).getGalleryId();
	 * 
	 * String galId = eventlist.get(i).getGalleryId();
	 * 
	 * values = listimg.split(","); System.out.println("realpath====" + values);
	 * String imagetag = ""; for (int j = 0; j < values.length; j++) { List<String>
	 * finalimgpaths = new ArrayList<String>();
	 * 
	 * OutputStream ss = ftpService.getFilesimage(values[j]); byte[] imageBytes =
	 * ((ByteArrayOutputStream) ss).toByteArray(); String base64Image =
	 * Base64.getEncoder().encodeToString(imageBytes);
	 * 
	 * 
	 * String imagePath=ftpProps.getPath()+"//"+values[j]; OutputStream ss =
	 * ftpService.getFilesimage(imagePath); byte[] imageBytes =
	 * ((ByteArrayOutputStream) ss).toByteArray(); String base64Image =
	 * Base64.getEncoder().encodeToString(imageBytes);
	 * 
	 * 
	 * imagetag += values[j] + "@##";
	 * 
	 * finalimgpaths.add(imagetag); String gallerynNamesstring =
	 * eventlist.get(i).getEventName();
	 * 
	 * finalimgpaths.add(gallerynNamesstring); charts.put(galId, finalimgpaths); }
	 * 
	 * }
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * return charts; }
	 */

	/*
	 * @GetMapping("/getmaingalleryimage")
	 * 
	 * @ResponseBody public Map<Long, List<String>>
	 * processEncodedRequestNewmain(@RequestParam(value = "limit") String limit,
	 * HttpServletRequest request, HttpServletResponse response) { //
	 * System.out.println("limit=="+limit); // String limit="5"; Map<Long,
	 * 
	 * List<String>> charts = new HashMap<Long, List<String>>(); List<galleryForm>
	 * eventlist = davaServices.getEventlist(limit); String values[] = null; try {
	 * 
	 * 
	 * 
	 * for (int i = 0; i < eventlist.size(); i++) { String listimg =
	 * eventlist.get(i).getGalleryImagepath();
	 * 
	 * // Long galId = eventlist.get(i).getGalleryId();
	 * 
	 * String galId = eventlist.get(i).getGalleryId();
	 * 
	 * // String galId = eventlist.get(i).getGalleryId();
	 * 
	 * 
	 * values = listimg.split(","); System.out.println("realpath====" + values);
	 * 
	 * String imagetag = ""; for (int j = 0; j < values.length; j++) { List<String>
	 * finalimgpaths = new ArrayList<String>();
	 * 
	 * OutputStream ss = ftpService.getFilesimage(values[j]); byte[] imageBytes =
	 * ((ByteArrayOutputStream) ss).toByteArray(); String base64Image =
	 * Base64.getEncoder().encodeToString(imageBytes);
	 * 
	 * 
	 * String imagePath=ftpProps.getPath()+"//"+values[j]; OutputStream ss =
	 * ftpService.getFilesimage(imagePath); byte[] imageBytes =
	 * ((ByteArrayOutputStream) ss).toByteArray(); String base64Image =
	 * Base64.getEncoder().encodeToString(imageBytes);
	 * 
	 * 
	 * imagetag += values[j] + "@##";
	 * 
	 * finalimgpaths.add(imagetag); String gallerynNamesstring =
	 * eventlist.get(i).getEventName();
	 * 
	 * finalimgpaths.add(gallerynNamesstring); // charts.put(galId, finalimgpaths);
	 * 
	 * 
	 * }
	 * 
	 * }
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * 
	 * return charts; }
	 */

	@RequestMapping(value = "/getDynamicHomepage", method = RequestMethod.GET)
	public void getDynamicHomepage(HttpServletRequest request) {

		// Long userid = dynamicHomepage.getUserid();
		String aboutUs = dynamicHomepage.getAboutus();

		// System.out.println("userid : : " + userid);
		System.out.println("aboutus : : " + aboutUs);

	}

	@RequestMapping(value = "/saveAppTypeMst", method = RequestMethod.GET)
	@ResponseBody
	public String saveAppTypeMst(@RequestParam("type") String type, @RequestParam("remarks") String remarks,
			HttpServletRequest request, HttpServletResponse response) {
		String jsonResponse = "";
		System.out.println(type + "  " + remarks);
		davaServices.saveApprovalTypeMst(type, remarks, request);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}

	@RequestMapping(value = "/RegistrationOfficials", method = RequestMethod.GET)
	public String RegistrationOfficials(HttpServletRequest request) {

		String response = "";
		LoginBean loginBean = new LoginBean();
		RegistrationForm regForm = new RegistrationForm();
		List<ZoneMst> zoneMst = davaServices.getZoneDetails();
		request.setAttribute("loginBean", loginBean);
		request.setAttribute("zoneMst", zoneMst);
		request.setAttribute("regForm", regForm);
		request.setAttribute("generatedCaptcha", request.getSession().getAttribute("captcha"));
		response = "offRegistration";

		return response;
	}

	@PostMapping("/officialRegistration")
	public String saveOfficialRegistration(@ModelAttribute("regForm") RegistrationForm registrationForm,
			RedirectAttributes redirectAttributes, HttpServletRequest request) {

		Random random = new Random(System.nanoTime() % 100000);
		int randomCode = random.nextInt(1000000000);
		registrationForm.setRandomCode(randomCode);

		String verificationLink = projectUrl + request.getContextPath() + "/emailVerification?email="
				+ DataEncoder.encode(registrationForm.getUserName()) + "&randomCode="
				+ registrationForm.getRandomCode();

		registrationForm.setEmailVerificationLink(verificationLink);

		String result = davaServices.saveOfficialRegistration(registrationForm);

		if (result.equals("saved")) {
			redirectAttributes.addFlashAttribute("officialRegStatus", 1);
			String emailVerificationSubject = emailContent.getEmailContent().get("emailVerificationSubject");
			String emailVerificationContent = emailContent.getEmailContent().get("emailVerificationContent");

			emailVerificationContent = emailVerificationContent.replaceAll("\\$USER\\_NAME\\$",
					registrationForm.getEmpName());
			emailVerificationContent = emailVerificationContent.replaceAll("\\$URL\\_LINK\\$", verificationLink);
			sendmail.sendMailToUser(registrationForm.getUserName(), emailVerificationSubject, emailVerificationContent);

			redirectAttributes.addFlashAttribute("registrationSuccessful", true);
			redirectAttributes.addFlashAttribute("registrationStatus",
					"Registration Successfull, Email verification link is sent to your registered official email id");

		} else {
			redirectAttributes.addFlashAttribute("exception", true);
			redirectAttributes.addFlashAttribute("error",
					"Entered user name is already present , please register with different user name");
		}

		return "redirect:/login";
	}

	@RequestMapping(value = "/loadPortOfExportData", method = RequestMethod.GET)
	public String loadPortOfExport(@ModelAttribute("portOfExportModel") PortOfExportModel portOfExportModel,
			HttpServletRequest request) {
		String response = "";

		response = "ExportPortData";

		return response;
	}

	@RequestMapping(value = "/loadPointOfDistributionMst", method = RequestMethod.GET)
	public String loadPointOfDistributionMst(
			@ModelAttribute("distributionModel") PointOfDistributionModel distributionModel,
			HttpServletRequest request) {
		String response = "";

		String loogedInUserId = SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);

		List<DrugMst> getProductNames = davaServices.getProductNames(userDetails.get(0).getNumInstId());
		request.setAttribute("getProductNames", getProductNames);

		List<HSCodeDomain> hsCodeDtls = davaDao.getHSCodeDtls();
		request.setAttribute("hsCodeDtls", hsCodeDtls);

		List<RegionMstDomain> region = podServ.loadRegion();
		request.setAttribute("region", region);

		List<CountryMst> country = podServ.loadCountry();
		request.setAttribute("country", country);

		response = "PointOfDis";

		return response;
	}

	@RequestMapping(value = "/saveDistrubutionPoints", method = RequestMethod.POST)
	public String saveDistrubutionPoints(
			@ModelAttribute("distributionModel") PointOfDistributionModel distributionModel, BindingResult result,
			HttpServletRequest request, RedirectAttributes attr) {
		System.out.println("IN Testing ACTION");
		String res = "";

		PointOfDistributionMst dis = davaServices.savePointOfDistributionMst(distributionModel, request);
		attr.addFlashAttribute("flagSave", 1);
		res = "redirect:/loadPointOfDistributionMst";
		return res;
	}

	@RequestMapping(value = "/getAllPointOfDistDetails", method = RequestMethod.GET)
	@ResponseBody
	public String getAllPointOfDistDetails(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("in data table code");
		String jsonResponse = davaServices.loadAllPointsOfDistributionDetails(request);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}

	@RequestMapping(value = "/ShowDeletedDrugDetails", method = RequestMethod.GET)
	public ModelAndView ShowDeletedDrugDetails(@ModelAttribute("drugModel") DrugDtlsModel drugDtlsModel,
			HttpServletRequest request) {
		String response = "";
		ModelAndView mv = new ModelAndView();

		// response= "DrugDetails";
		mv.setViewName("DeletedDrugDetails");
		return mv;
	}

	@RequestMapping(value = "/getDeletedDrugDetails", method = RequestMethod.GET)
	@ResponseBody
	public String getDeletedDrugDetails(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("in data table code");
		String jsonResponse = davaServices.loadDeletedDrugDetails(request);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}

	@GetMapping("/downloadFeedbackReport")
	public void getAllFeedbackReport(HttpServletRequest request, HttpServletResponse response) {

		List<ReportProblemDomain> data = davaServices.getFeedbackResData();
		Workbook workbook = new XSSFWorkbook();
		CreationHelper createHelper = workbook.getCreationHelper();
		Sheet sheet = workbook.createSheet("Feedback");
		String[] columns = { "Serial Numbers" };

	}

	@RequestMapping(value = "/PortOfExportList", method = RequestMethod.GET)
	public String PortOfExportList(@ModelAttribute("portOfExportModel") PortOfExportModel portOfExportModel,
			HttpServletRequest request) {
		String response = "";

		response = "ExportPortListing";

		return response;
	}

	@RequestMapping(value = "/updatePortOfExport", method = RequestMethod.POST)
	public String updatePortOfExport(@ModelAttribute("portOfExportModel") PortOfExportModel portOfExportModel,
			BindingResult result, HttpServletRequest request, RedirectAttributes attr) {
		System.out.println("IN Testing ACTION");
		String res = "";
		PortOfExportDomain port = davaServices.updatePortOfExport(portOfExportModel, request);
		attr.addFlashAttribute("flagUpdate", 1);
		res = "redirect:/PortOfExport";
		return res;
	}

	@RequestMapping(value = "/deletePortOfExport", method = RequestMethod.POST)
	public String deletePortOfExport(@ModelAttribute("portOfExportModel") PortOfExportModel portOfExportModel,
			BindingResult result, HttpServletRequest request, RedirectAttributes attr) {
		System.out.println("IN Testing ACTION");
		String res = "";
		davaServices.deletePortOfExport(portOfExportModel, request);
		attr.addFlashAttribute("flagDelete", 1);
		res = "redirect:/PortOfExport";
		return res;
	}

	@GetMapping("/getAppSearchLogs")
	public ModelAndView getAppSearchLogs() {
		ModelAndView mv = new ModelAndView();
		List<AppUserLogs> appSerachLogs = davaServices.getAppSearchLogs();
		mv.addObject("appSerachLogs", appSerachLogs);
		mv.setViewName("appSearchLogs");
		return mv;
	}

	// ShowAllRegistrationDataListing
	@RequestMapping(value = "/AllCorporateData", method = RequestMethod.GET)
	public String AllCorporateData(@ModelAttribute("registrationForm") RegistrationForm registrationForm,
			HttpServletRequest request) {
		String response = "";
		LoginBean loginBean = new LoginBean();
		request.setAttribute("loginBean", loginBean);
		response = "CorporateDeatils";

		return response;
	}

	@RequestMapping(value = "/getAllRegistrationDataListing", method = RequestMethod.GET)
	@ResponseBody
	public String viewAllRegistrationDataListing(@RequestParam("appstatus") Integer appstatus,
			HttpServletRequest request, HttpServletResponse response) {

		System.out.println("in data table code  " + appstatus);
		String jsonResponse = davaServices.ShowAllRegistrationDataListing(request, appstatus);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}

	@RequestMapping(value = "/generateCorporatePdf", method = RequestMethod.POST)
	public void generatePdf(HttpServletRequest request, HttpServletResponse response) {

		String Statuss = request.getParameter("status");

		System.err.println("generatePdf " + Statuss);
		// String enFid = request.getParameter("enFid");
		String value2 = decode(Statuss);
		String value3 = reverse(value2);
		String statusId = encodedservice.decode(value3);
		System.err.println("status ---  " + statusId);
		// Integer statusFeild = Integer.parseInt(statusId);
		ArrayList<String> list = new ArrayList<String>(4);
		String inputFilename = "CorporateDetails";
		String outputFilename = "CorporateDetails " + statusId + ".pdf";
		list.add(statusId);
		list.add(inputFilename);
		list.add(outputFilename);

		genJasperService.generateCorporatePdf(request, response, list);

	}

	@GetMapping(value = "/AllUploadedDataReport")
	public String showAllUploadedData(@ModelAttribute("uploadData") UploadDataForm uploadData,
			HttpServletRequest request) {

		List<RegistrationDetails> regList = davaDao.getAllRegistrations();
		request.setAttribute("regList", regList);

		// List<Object> registrationList = davaDao.getRegistrationListing(UserId);

		return "UploadedDataReport";
	}

	@RequestMapping(value = "/getAllUploadXmlData", method = RequestMethod.GET)
	@ResponseBody
	public String getAllUploadXmlDetails(@RequestParam("company") Integer company, HttpServletRequest request,
			HttpServletResponse response) {
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("in data table code");

		String jsonResponse = davaServices.ShowAllUploadXmlDetails(request, company);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}

	@RequestMapping(value = "/getAllProductData", method = RequestMethod.GET)
	@ResponseBody
	public String getAllProductData(@RequestParam("prodType") Integer prodType, @RequestParam("hscode") Integer hscode,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("in data table code");
		System.out.println(prodType + "  Product Id");
		System.out.println(hscode + "  HCCODE");
		String jsonResponse = davaServices.ShowAllProductData(request, prodType, hscode);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}

	@RequestMapping(value = "/ProductDetailsReport", method = RequestMethod.GET)
	public String ProductDetailsReport(@ModelAttribute("registrationForm") RegistrationForm registrationForm,
			HttpServletRequest request) {
		String response = "";
		LoginBean loginBean = new LoginBean();
		request.setAttribute("loginBean", loginBean);

		List<HSCodeDomain> hsCodeDtls = davaDao.getHSCodeDtls();
		request.setAttribute("hsCodeDtls", hsCodeDtls);

		response = "ProdDetailsReport";

		return response;
	}

	@RequestMapping(value = "/generateUploadedXMLPdf", method = RequestMethod.POST)
	public void generateUploadedXMLPdf(HttpServletRequest request, HttpServletResponse response) {

		// String enFid = request.getParameter("enFid");

		String USERID = request.getParameter("userId");
		System.err.println("USERID ---  " + USERID);

		String value2 = decode(USERID);
		String value3 = reverse(value2);
		String numUserId = encodedservice.decode(value3);
		System.err.println("status ---  " + numUserId);
		// Integer statusFeild = Integer.parseInt(statusId);
		ArrayList<String> list = new ArrayList<String>(4);
		String inputFilename = "UploadedXMLData";
		String outputFilename = "UploadedXMLData.pdf";
		list.add(numUserId);
		list.add(inputFilename);
		list.add(outputFilename);

		genJasperService.generateUploadedXMLPdf(request, response, list);

	}

	@RequestMapping(value = "/generateAllProductPdf", method = RequestMethod.POST)

	public void generateAllProductPdf(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("???????");
		// String enFid = request.getParameter("enFid");

		String producttype = request.getParameter("enProdType");
		String hscode = request.getParameter("enHSCode");

		System.out.println("????producttype???" + producttype);

		System.out.println("???hscode???" + hscode);

		System.err.println("generatePdf " + producttype + "  " + hscode);

		String value2 = decode(producttype);
		String value3 = reverse(value2);
		String prodType = encodedservice.decode(value3);

		String value4 = decode(hscode);
		String value5 = reverse(value4);
		String hsCode = encodedservice.decode(value5);

		System.err.println("prodType ---  " + producttype + "   hsCode-------  " + hscode);
		// Integer statusFeild = Integer.parseInt(statusId);
		ArrayList<String> list = new ArrayList<String>(4);
		String inputFilename = "ProductDetails";
		String outputFilename = "ProductDetails.pdf";
		list.add(prodType);
		list.add(hsCode);
		list.add(inputFilename);
		list.add(outputFilename);

		genJasperService.generateProductDetailsPdf(request, response, list);

	}
	
	//GOVIND(02-Feb-2024)
	@GetMapping("/resetDongle")
 
																				 
																									   
	public ModelAndView resetDongle(HttpServletRequest request, RedirectAttributes attr) {
		ModelAndView mv = new ModelAndView();
		String loogedInUserIdName = SecurityContextHolder.getContext().getAuthentication().getName();
		//System.out.println(LocalDateTime.now()+"--- Logged usename --- " +loogedInUserIdName);
		RegistrationDetails rg = userRepository.findByUserName(loogedInUserIdName);
		Long userId = rg.getUserId();
		userRepository.setPublicKeyNull(userId);
		System.out.println(LocalDateTime.now()+" --- User Id "+userId);
		System.out.println(LocalDateTime.now()+" --- Public key reset to null "+loogedInUserIdName);
		mv.setViewName("redirect:/Dashboard");
		return mv;

	}
 
   
	//for ddeleting manufacturing site
	
	
	@RequestMapping(value = "/deletemanufacturingsite", method = RequestMethod.POST)
	public String deletemanufacturingsite(@ModelAttribute("manuList") MemberAddDtlModel MemberAddDtlModel,
			BindingResult result, HttpServletRequest request, RedirectAttributes attr) {

		System.out.println("IN Testing ACTION");
		String res = "";
		InstPremiseDtlDomain InstPremiseDtlDomain = davaServices.deletemanusite(MemberAddDtlModel);
		attr.addFlashAttribute("flagDelete", 1);
		res = "redirect:/ManufacturingSiteListing";
																 
																							  
										
		return res;

	}
		 
	
}
