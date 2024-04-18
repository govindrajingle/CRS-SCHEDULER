package in.cdacnoida.dava.controllers;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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

import in.cdacnoida.dava.daoservice.DavaDaoServices;
import in.cdacnoida.dava.daoservice.LocationMasterDaoService;
import in.cdacnoida.dava.entities.ApplicantTypeMasterDomain;
import in.cdacnoida.dava.entities.ApprovalPremisesDetail;
import in.cdacnoida.dava.entities.ApprovalTypeMst;
import in.cdacnoida.dava.entities.CountryMst;
import in.cdacnoida.dava.entities.DistrictMst;
import in.cdacnoida.dava.entities.DrugDosageMst;
import in.cdacnoida.dava.entities.DrugMonographMst;
import in.cdacnoida.dava.entities.DrugMst;
import in.cdacnoida.dava.entities.DrugScheduleMst;
import in.cdacnoida.dava.entities.DrugTypeMst;
import in.cdacnoida.dava.entities.HSCodeDomain;
import in.cdacnoida.dava.entities.InstPremiseDtlDomain;
import in.cdacnoida.dava.entities.InstituteMemberDetailDomain;
import in.cdacnoida.dava.entities.InstituteTypeMasterDomain;
import in.cdacnoida.dava.entities.LicPremiseDtlDomain;
import in.cdacnoida.dava.entities.LicenseTypeMstDomain;
import in.cdacnoida.dava.entities.MemberTypeMasterDomain;
import in.cdacnoida.dava.entities.PackUnitMst;
import in.cdacnoida.dava.entities.RegistrationDetails;
import in.cdacnoida.dava.entities.RoleMaster;
import in.cdacnoida.dava.entities.StatesMst;
import in.cdacnoida.dava.entities.StorageCondMstDom;
import in.cdacnoida.dava.model.DrugDtlsModel;
import in.cdacnoida.dava.model.LoginBean;
import in.cdacnoida.dava.model.MemberAddDtlModel;
import in.cdacnoida.dava.model.MemberDetailForm;
import in.cdacnoida.dava.model.RegistrationForm;
import in.cdacnoida.dava.service.DataEncoderService;
import in.cdacnoida.dava.service.DavaServices;
import in.cdacnoida.dava.service.GlobalService;
import in.cdacnoida.dava.springsecurity.LoggedInUserSession;
import in.cdacnoida.dava.transactions.UserRepository;
import in.cdacnoida.dava.util.Captcha;
import in.cdacnoida.dava.util.DataEncoder;
import in.cdacnoida.dava.util.FileValidation;
import in.cdacnoida.dava.util.Sendmail;
import in.cdacnoida.davaconfig.FtpDetailsProperties;

@Controller
public class ProfileCompletenessPercentageAction {

	@Autowired
	private DavaServices davaServices;

	@Autowired
	private Sendmail sendmail;

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

	@Value("${projectUrl}")
	String projectUrl;

	@Autowired
	private UserRepository userRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileCompletenessPercentageAction.class);
	
	
	
	
	@RequestMapping(value = "/getProfilePercentDetails",method = RequestMethod.GET)
	@ResponseBody
	public void getProfilePercentDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		
		
	    Long userId=userData.getUserId();
		
	   Optional<RegistrationDetails> registrationDetails= userRepository.findById(userId);
	   
	   RegistrationDetails rg=registrationDetails.get();
	  
	   rg.getNumSeatId();
	   
	  System.err.println(rg.getNumSeatId()+"LoggedInSeatId");
		
		
		
	}

	
}
