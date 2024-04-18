package in.cdacnoida.home;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.cdacnoida.dava.daoservice.DavaDaoServices;
import in.cdacnoida.dava.entities.ApplicantTypeMasterDomain;
import in.cdacnoida.dava.entities.InstPremiseDtlDomain;
import in.cdacnoida.dava.entities.InstituteMasterDomain;
import in.cdacnoida.dava.entities.RegistrationDetails;
import in.cdacnoida.dava.entities.SeatMaster;
import in.cdacnoida.dava.entities.TileDomain;
import in.cdacnoida.dava.model.LoginBean;
import in.cdacnoida.dava.model.OfficialForm;
import in.cdacnoida.dava.model.SolrSearchModel;
import in.cdacnoida.dava.model.UserProfileModel;
import in.cdacnoida.dava.service.DavaServices;
import in.cdacnoida.dava.springsecurity.ActiveUserStore;
import in.cdacnoida.dava.transactions.UserRepository;
import in.cdacnoida.dava.util.Captcha;
import in.cdacnoida.dava.util.DynamicHomepage;

@Controller
public class HomeController {
	
	@Autowired
	private DavaServices davaServices;

	@Autowired
	ActiveUserStore activeUserStore;
	
	@Autowired
	private DavaDaoServices davaDaoServices;
	
	@Autowired
	private DynamicHomepage dynamicHomepage;
	
	@Autowired
	private Environment env;
	
	
	@Value("${project.schema.version}")
	String schemaVersion;
	
	@Value("${project.desktopapp.version}")
	String desktopAppVersion;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/login")
	public ModelAndView cefipraHome(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		LoginBean loginBean = new LoginBean();

		// added by harshita on 130723
		Random random = new Random(System.nanoTime() % 100000);
		int randomCode = random.nextInt(1000000000);
		session.setAttribute("passhash", randomCode);
		loginBean.setToken(randomCode + "");
		//System.out.println(" randomCode user" + randomCode);

		// String user = loginBean.getUsername();
		// System.out.println( " User user" + user);

		// String password = loginBean.getPassword();
		// byte[] byteValueBase64Decoded =
		// Base64.getDecoder().decode(password.getBytes());
		// byteValueBase64Decoded = Base64.getDecoder().decode(byteValueBase64Decoded);
		// String stringValueBase64Decoded = new String(byteValueBase64Decoded);
		// System.out.println( "hello" + stringValueBase64Decoded);
		Object error = session.getAttribute("error");
		// userRepository.findByPassword(stringValueBase64Decoded);

		if (error != null) {
			LOGGER.error("error {}", error);
			if (session != null)
				SecurityContextHolder.clearContext();
			session.invalidate();
			mv.addObject("error", error);
			mv.addObject("exception", true);
		}
		Captcha captcha = new Captcha();
		String generatedCaptcha = captcha.getCaptcha();
		session = request.getSession(true);
		session.setAttribute("captcha", generatedCaptcha);
		
		
		
		
//		Properties props = new Properties();
//		String path = env.getProperty("dashboard.count");
//
//		try (FileInputStream in = new FileInputStream(path)) {
//		    props.load(in);
//
//		    // Retrieve values from properties file
//		    Integer numRegManuf = Integer.parseInt(props.getProperty("numRegManuf"));
//		    Integer numRegExp = Integer.parseInt(props.getProperty("numRegExp"));
//		    Integer numDataManuf = Integer.parseInt(props.getProperty("numDataManuf"));
//		    Integer numDataExp = Integer.parseInt(props.getProperty("numDataExp"));
//		    Integer numExpCh29Data = Integer.parseInt(props.getProperty("numExpCh29Data"));
//		    Integer numExpCh29Country = Integer.parseInt(props.getProperty("numExpCh29Country"));
//		    Integer numExpCh30Data = Integer.parseInt(props.getProperty("numExpCh30Data"));
//		    Integer numExpCh30Country = Integer.parseInt(props.getProperty("numExpCh30Country"));
//
//		    // Add values to ModelAndView
//		    mv.addObject("manufacturer", numRegManuf);
//		    mv.addObject("exporters", numRegExp);
//		    mv.addObject("expDataManuf", numDataManuf);
//		    mv.addObject("expDataExp", numDataExp);
//		    mv.addObject("chap29", numExpCh29Data);
//		    mv.addObject("chap29Coun", numExpCh29Country);
//		    mv.addObject("chap30", numExpCh30Data);
//		    mv.addObject("chap30Coun", numExpCh30Country);
//
//		    // For debugging purposes, print the retrieved values
//			/*
//			 * System.out.println("Manufacturer: " + numRegManuf);
//			 * System.out.println("Exporters: " + numRegExp);
//			 * System.out.println("Exp Data Manufacturer: " + numDataManuf);
//			 * System.out.println("Exp Data Exporters: " + numDataExp);
//			 * System.out.println("Chap 29: " + numExpCh29Data);
//			 * System.out.println("Chap 29 Country: " + numExpCh29Country);
//			 * System.out.println("Chap 30: " + numExpCh30Data);
//			 * System.out.println("Chap 30 Country: " + numExpCh30Country);
//			 */
//
//		} catch (IOException e) {
//		    e.printStackTrace();
//		}
	
	
		
		

		//davaServices.loadStatisticsFunc();

//		List<StaticsDataDomain> stats = davaDaoServices.getAllStatisticsData();
//
//		Integer manufacturer = stats.get(0).getNumRegManuf();
//		Integer exporters = stats.get(0).getNumRegExp();
//		mv.addObject("manufacturer", manufacturer);
//		mv.addObject("exporters", exporters);
//
//		Integer expDataManuf = stats.get(0).getNumDataManuf();
//		Integer expDataExp = stats.get(0).getNumDataExp();
//		mv.addObject("expDataManuf", expDataManuf);
//		mv.addObject("expDataExp", expDataExp);
//
//		Integer chap29 = stats.get(0).getNumExpCh29Data();
//		Integer chap29Coun = stats.get(0).getNumExpCh29Country();
//		mv.addObject("chap29", chap29);
//		mv.addObject("chap29Coun", chap29Coun);
//
//		Integer chap30 = stats.get(0).getNumExpCh30Data();
//		Integer chap30Coun = stats.get(0).getNumExpCh30Country();
//		mv.addObject("chap30", chap30);
//		mv.addObject("chap30Coun", chap30Coun);

		mv.addObject("schemaVersion", schemaVersion);

		/*
		 * int manufacturer=0; int exporters=0;
		 * 
		 * 
		 * 
		 * List<RegistrationDetails> data1=davaServices.getRegistrationData();
		 * for(RegistrationDetails registrationDetails : data1) {
		 * if(registrationDetails.getApplicantType().equals("100"))
		 * manufacturer=manufacturer+1;
		 * if(registrationDetails.getApplicantType().equals("101"))
		 * exporters=exporters+1; }
		 */

		mv.addObject("generatedCaptcha", generatedCaptcha);
		mv.addObject("loginBean", loginBean);
		/*
		 * mv.addObject("manufacturer", manufacturer); mv.addObject("exporters",
		 * exporters);
		 */
		mv.addObject("dynamicHomepage", dynamicHomepage);
		mv.addObject("logged_in_users", activeUserStore.users.size());
		mv.setViewName("davaHome");
		return mv;
	}

	@GetMapping("/loginException")
	public ModelAndView error(HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		LoginBean loginBean=new LoginBean();
		Captcha captcha=new Captcha();
		String generatedCaptcha=captcha.getCaptcha();
		HttpSession session = request.getSession(false);
		session.setAttribute("captcha", generatedCaptcha);
		mv.addObject("generatedCaptcha", generatedCaptcha);
		mv.addObject("loginBean", loginBean);
		
		mv.setViewName("davaHome");
		return mv;
	}
	
	@GetMapping("/adminHime")
	public ModelAndView adminHome(HttpServletRequest request) {
		return new ModelAndView("adminHome");
	}
	
	/*
	 * @GetMapping("/getStatisticsData") public ModelAndView
	 * statisticsData(HttpServletRequest request) { ModelAndView mv=new
	 * ModelAndView();
	 * 
	 * System.out.println("in stats data");
	 * 
	 * List<StaticsDataDomain> stats = davaDaoServices.getAllStatisticsData();
	 * 
	 * Integer manufacturer = stats.get(0).getNumRegManuf(); Integer exporters =
	 * stats.get(0).getNumRegExp(); mv.addObject("manufacturer", manufacturer);
	 * mv.addObject("exporters", exporters);
	 * 
	 * Integer expDataManuf = stats.get(0).getNumDataManuf(); Integer expDataExp =
	 * stats.get(0).getNumDataExp(); mv.addObject("expDataManuf", expDataManuf);
	 * mv.addObject("expDataExp", expDataExp);
	 * 
	 * Integer chap29 = stats.get(0).getNumExpCh29Data(); Integer chap29Coun =
	 * stats.get(0).getNumExpCh29Country(); mv.addObject("chap29", chap29);
	 * mv.addObject("chap29Coun", chap29Coun);
	 * 
	 * Integer chap30 = stats.get(0).getNumExpCh30Data(); Integer chap30Coun =
	 * stats.get(0).getNumExpCh30Country(); mv.addObject("chap30", chap30);
	 * mv.addObject("chap30Coun", chap30Coun);
	 * 
	 * mv.setViewName("davaHome"); return mv; }
	 */
	
	//Getting captcha
	@GetMapping("/getCaptcha")
	public @ResponseBody String getCaptcha(HttpServletRequest request) {
		Captcha captcha = new Captcha();
		String strCaptcha = captcha.getCaptcha();
		request.getSession().setAttribute("captcha", strCaptcha);
		request.getSession().setAttribute("registrationCaptcha", strCaptcha);
		return strCaptcha;
	}
	
	@GetMapping("/Dashboard")
	public ModelAndView dashboardMain(HttpServletRequest request) throws SQLException {
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		
		RegistrationDetails registrationDetails=davaServices.findByUserName(loogedInUserId);

		//System.err.println("loogedInUserId-----------    "+loogedInUserId+" seat id-------------    "+registrationDetails.getNumSeatId());
		
		List<SeatMaster> seatList = davaServices.getSeatMstData(registrationDetails.getNumSeatId());
		//System.err.println("role id--- "+seatList.get(0).getNumRoleId()); 
		int roleId=seatList.get(0).getNumRoleId(); //set menu in session
		 List<OfficialForm>menuList=davaServices.getMenu(roleId);
//		 for (OfficialForm menu : menuList) {
//			    System.out.println("MMMMMMMMM-"+menu.toString());
//			}
		  request.getSession().setAttribute("menuList", menuList);
		  //System.err.println("menulist size- ----  "+menuList.size());
		  request.getSession().setAttribute("roleId",  seatList.get(0).getNumRoleId());
		  
		 // System.out.println("df--"+seatList.get(0).getNumRoleId());
		  List<TileDomain> tileList = davaServices.getTile(seatList.get(0).getNumRoleId());
		  request.getSession().setAttribute("tileList", tileList);
		  //System.err.println("tileList--- "+tileList.size()); 
		  //getInstituteData
		  if(roleId==100 || roleId == 101) {
			  List<InstituteMasterDomain> instList = davaServices.getInstituteData(registrationDetails.getNumInstId());
			  String uniqueCode = null;
			  if(instList.get(0).getStrManufCode().equals(null))
				  uniqueCode = "";
			  else
				  uniqueCode = instList.get(0).getStrManufCode();
			  request.setAttribute("uniqueCode", uniqueCode);
		  }else if(roleId==104) {
			  String premiseUniqueCode = "";
			  if(registrationDetails.getNumPremisesNo()==null || registrationDetails.getNumPremisesNo()==0) {
				  System.out.println("not manufacturing sub-login || premise number not entered in table.");
			  }else {
				  List<InstPremiseDtlDomain> instPremise =  davaServices.getPremiseAddress(registrationDetails.getNumPremisesNo());
				  premiseUniqueCode = instPremise.get(0).getStrPremiseCode();
			  }
			  request.setAttribute("premiseUniqueCode", premiseUniqueCode);
			  
		  }
		 
		  int x= registrationDetails.getNumSeatId();
		  
			 
		  ModelAndView dashboard = null ;
		  
		  String tilesfuncName="";
		if(roleId==100 ) { // Manufacturer
			dashboard = new ModelAndView("dashboardMain");
			tilesfuncName="manufacturer_tilesdata";
		}
		else if(roleId==101) { // Exporter
			dashboard = new ModelAndView("merchantDashboard");
			tilesfuncName="exporter_tilesdata";
		}
		else if(roleId==200) {// Official
			dashboard = new ModelAndView("pharamexcilDashboard");
			tilesfuncName="admin_tilesdata";
		}
		else if(roleId==104) {
			dashboard = new ModelAndView("dashboardMain");
			tilesfuncName="manufacturer_tilesdata";
		}
		else if(roleId==105) { //custom official
			dashboard = new ModelAndView("customDashboard");
			tilesfuncName="custom_tilesdata";
		}
		else if(roleId==201) { //Regulatory Authority
			dashboard = new ModelAndView("regulatoryAuthrityDashboard");
			tilesfuncName="ra_tilesdata";
		}
		else if(roleId==202) { //MOC
			dashboard = new ModelAndView("mocDashboard");
			tilesfuncName="moc_tiledata";
		}
		String jsonResponse =davaServices.createJSONTilesData(tilesfuncName,registrationDetails.getNumInstId(),registrationDetails.getUserId());
	    ObjectMapper mapper = new ObjectMapper();
	    try {
			Map<String, String> tileMap = mapper.readValue(jsonResponse, Map.class);
			  request.getSession().setAttribute("tileMap", tileMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    request.setAttribute("desktopAppVersion", desktopAppVersion);
	    String profileCom =  davaDaoServices.getProfilePercentage(x);
	    request.getSession().setAttribute("percent", profileCom);
		  
		return dashboard;
	}
	
	
	@GetMapping("/merchantDashboard")
	public ModelAndView merchantDashboard(HttpServletRequest request) throws SQLException {

		return new ModelAndView("merchantDashboard");
	}
	
	@GetMapping("/phDashboard")
	public ModelAndView pharamexcilDashboard(HttpServletRequest request) throws SQLException {
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		RegistrationDetails registrationDetails=davaServices.findByUserName(loogedInUserId);

		//System.err.println("loogedInUserId-----------    "+loogedInUserId+" seat id-------------    "+registrationDetails.getNumSeatId());
		
		List<SeatMaster> seatList = davaServices.getSeatMstData(registrationDetails.getNumSeatId());
		//System.err.println("role id--- "+seatList.get(0).getNumRoleId()); 
		int roleId=seatList.get(0).getNumRoleId(); //set menu in session
		 List<OfficialForm>menuList=davaServices.getMenu(roleId);
		  request.getSession().setAttribute("menuList", menuList);
		  //System.err.println("menulist size- ----  "+menuList.size());
		return new ModelAndView("pharamexcilDashboard");
	}
	
	@GetMapping("/underProcess")
	public ModelAndView underProcess(HttpServletRequest request) {

		return new ModelAndView("underProcess");
	}
		
	
	@GetMapping("/faq")
	public ModelAndView faq(HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		LoginBean loginBean=new LoginBean();
		Captcha captcha = new Captcha();
		String strCaptcha = captcha.getCaptcha();
		mv.addObject("generatedCaptcha",strCaptcha);
		mv.addObject("loginBean", loginBean);		
		mv.setViewName("faq");
		return mv;
		
	}
	
	@GetMapping("/UserProfile")
	public ModelAndView userProfile(HttpServletRequest request) throws SQLException {
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		ModelAndView mv=new ModelAndView();

		RegistrationDetails registrationDetails=davaServices.findByUserName(loogedInUserId);
		
		UserProfileModel model=convertToUserProfile(registrationDetails);
		mv.addObject("model", model);		
		mv.setViewName("userProfile");
		return mv;
	}

	private UserProfileModel convertToUserProfile(RegistrationDetails registrationDetails) {
		UserProfileModel model=new UserProfileModel();
		if(null != registrationDetails.getApplicantType()) {
		List<ApplicantTypeMasterDomain> appTypeList =davaDaoServices.getApplicantTypeListName(Integer.parseInt(registrationDetails.getApplicantType()));
		model.setApplicantType(appTypeList.get(0).getStrApplTypeName());
		}
		model.setContactPerDesg(registrationDetails.getContactPerDesg());
		model.setContactPersonName(registrationDetails.getContactPersonName());
		model.setContPerMobileNo(registrationDetails.getContPerMobileNo());
		model.setContPersEmail(registrationDetails.getContPersEmail());
		model.setGsOne(registrationDetails.getGsOne());
		model.setGstnumber(registrationDetails.getGstnumber());
		model.setIecIssueAuthority(registrationDetails.getIecIssueAuthority());
		model.setIecIssueDate(registrationDetails.getIecIssueDate());
		model.setIecNumber(registrationDetails.getIecNumber());
		model.setManfCountryId(registrationDetails.getManfCountryId());
		model.setManfDistId(registrationDetails.getManfDistId());
		model.setManfLicNumber(registrationDetails.getManfLicNumber());
		model.setManfSiteAddress(registrationDetails.getManfSiteAddress());
		model.setManfSiteCity(registrationDetails.getManfSiteCity());
		model.setManfSiteContactNumber(registrationDetails.getManfSiteContactNumber());
		model.setManfSiteFaxNumber(registrationDetails.getManfSiteFaxNumber());
		model.setManfSiteName(registrationDetails.getManfSiteName());
		model.setManfSitePincode(registrationDetails.getManfSitePincode());
		model.setManfStateId(registrationDetails.getManfStateId());
		model.setManfStateId(registrationDetails.getManfStateId());
		model.setMemberOfOtherExportPromotionCouncil(registrationDetails.getMemberOfOtherExportPromotionCouncil());
		model.setNumApprovalStatusPharmaexil(registrationDetails.getNumApprovalStatusPharmaexil());
		model.setNumEmailStatus(registrationDetails.getNumEmailStatus());
		model.setNumInstId(registrationDetails.getNumInstId());
		model.setNumIsValied(registrationDetails.getNumIsValied());
		model.setNumPremisesNo(registrationDetails.getNumPremisesNo());
		model.setNumRcmsStatus(registrationDetails.getNumRcmsStatus());
		model.setNumSeatId(registrationDetails.getNumSeatId());
		model.setNumTrUserId(registrationDetails.getNumTrUserId());
		model.setOrgAddress(registrationDetails.getOrgAddress());
		model.setOrgContactNumber(registrationDetails.getOrgContactNumber());
		model.setOrgCountryId(registrationDetails.getOrgCountryId());
		model.setOrgDistId(registrationDetails.getOrgDistId());
		model.setOrgEmailId(registrationDetails.getOrgEmailId());
		model.setOrgFaxNumber(registrationDetails.getOrgFaxNumber());
		model.setOrgName(registrationDetails.getOrgFaxNumber());
		model.setOrgPanNumber(registrationDetails.getOrgPanNumber());
		model.setOrgPincode(registrationDetails.getOrgPincode());
		model.setOrgStateId(registrationDetails.getOrgStateId());
		model.setOrgType(registrationDetails.getOrgType());
		model.setOrgWebsite(registrationDetails.getOrgWebsite());
		model.setRcmcOfFieo(registrationDetails.getRcmcOfFieo());
		model.setSsiIssueDate(registrationDetails.getSsiIssueDate());
		model.setSsiNumber(registrationDetails.getSsiNumber());
		model.setStrRcmcNumber(registrationDetails.getStrRcmcNumber());
		model.setStrReason(registrationDetails.getStrReason());
		model.setUserId(registrationDetails.getUserId());
		model.setUserName(registrationDetails.getUserName());
		
		return model;
	}

	@GetMapping("/gallery")
	public ModelAndView gallery(HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		LoginBean loginBean=new LoginBean();
		mv.addObject("loginBean", loginBean);		
		mv.setViewName("gallery");
		return mv;
		
	}
	
	@GetMapping("/queryMst")
	public ModelAndView getQueryPage() {
		ModelAndView mv=new ModelAndView();
		SolrSearchModel sm=new SolrSearchModel();
		mv.addObject("solrSearchModel", sm);
		mv.setViewName("queryMst");
		return mv;
	}
	
	@PostMapping("/queryMst")
	public ModelAndView getQueryResult(@ModelAttribute("solrSearchModel") SolrSearchModel solrSearchModel) {
		String query=solrSearchModel.getQuery();
		RegistrationDetails getResult=null;
		String getMessage="";
		try {
			 getResult=davaServices.findByUserName(query);
		} catch (Exception e) {
			 getMessage=e.getMessage();
		}
		
		ModelAndView mv=new ModelAndView();
		if(getResult!=null) {
			mv.addObject("data", getResult.toString());
		}
		if(!getMessage.equals("")) {
			mv.addObject("getMessage", getMessage);
		}
		return mv;
	}
	
	@GetMapping("/videotutorial")
	public ModelAndView videotutorial(HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		LoginBean loginBean=new LoginBean();
		Captcha captcha = new Captcha();
		String strCaptcha = captcha.getCaptcha();
		mv.addObject("generatedCaptcha",strCaptcha);
		mv.addObject("loginBean", loginBean);		
		mv.setViewName("videotutorial");
		return mv;
		
	}

	@GetMapping("/screenreader")
	public ModelAndView screenreader(HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		LoginBean loginBean=new LoginBean();
		Captcha captcha = new Captcha();
		String strCaptcha = captcha.getCaptcha();
		mv.addObject("generatedCaptcha",strCaptcha);
		mv.addObject("loginBean", loginBean);		
		mv.setViewName("screenreader");
		return mv;
		
	}
	
}
