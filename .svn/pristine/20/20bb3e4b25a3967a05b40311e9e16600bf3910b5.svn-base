package in.cdacnoida.dava.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import in.cdacnoida.dava.entities.DesktopConfigDtlDom;
import in.cdacnoida.dava.entities.RegistrationDetails;
import in.cdacnoida.dava.exphandelling.CredentialsNotValid;
import in.cdacnoida.dava.exphandelling.ResourceNotFound;
import in.cdacnoida.dava.exphandelling.UserAlreadyExist;
import in.cdacnoida.dava.exphandelling.UserNotVerified;
import in.cdacnoida.dava.model.AppUserLogsForm;
import in.cdacnoida.dava.model.ConfigDtl;
import in.cdacnoida.dava.model.Demo;
import in.cdacnoida.dava.model.DesktopConfigDtls;
import in.cdacnoida.dava.model.FileParameters;
import in.cdacnoida.dava.model.HashCodesAndFilenames;
import in.cdacnoida.dava.model.HashRequest;
import in.cdacnoida.dava.model.HostRegistrationForm;
import in.cdacnoida.dava.model.UpdatePublicKeyModel;
import in.cdacnoida.dava.service.DataEncoderService;
import in.cdacnoida.dava.service.DavaServices;
import in.cdacnoida.dava.service.FileStorageService;
import in.cdacnoida.dava.service.GlobalService;
import in.cdacnoida.dava.transactions.DocumentMasterDomainRepository;
import in.cdacnoida.davaconfig.FileUploadingPath;

@RestController
public class RestServiceControler {

	List<FileParameters> listFileParameters = new ArrayList<FileParameters>();

	@Autowired
	private DavaServices davaser;


	@Autowired
	FtpService ftpService;

	HttpServletRequest request;
	HttpServletResponse response;
	HttpSession session;

	@Autowired
	DataEncoderService encodedservice;


	@Autowired
	GlobalService gService;

	@Autowired
	private DavaServices davaServices;

	@Autowired
	private FileUploadingPath uploadingPath;
	
    @Autowired
    private DocumentMasterDomainRepository documentMasterDomainRepository;

	@Value("${APP_VERSION}")
	String APP_VERSION;

	private static final Logger LOGGER = LoggerFactory.getLogger(RestServiceControler.class);

	// This method is used to get the registration page with country names

	@Autowired
	private FileStorageService fileStorageService;
	
	@PostMapping("/receivedHash")
	public ResponseEntity<Boolean> duplicateHashFromDesktopApp(@RequestBody HashRequest hashRequest) {
		System.out.println(LocalDateTime.now()+"--- inside (Desktop upload) DuplicateHashFromDesktopApp");
		String[] parts = hashRequest.getHashvalue().split("\\+");
		String hashvalue = parts[0];
        String Originalfilename = parts[1];
        System.out.println("Hash Value: " + hashvalue);
        System.out.println("Original Filename: " + Originalfilename);		
		boolean duplicateFilenameFound = false;
		boolean duplicateHashCodeFound = false;
	    List<String> hcodes = davaServices.getUploadedData();	
	    List<String> filenames = documentMasterDomainRepository.findStrRemarksWithXml();
		for (String filename : filenames) {
			if (filename.equalsIgnoreCase(Originalfilename)) {
				System.out.println("Duplicate file name found --- "+filename);
				duplicateFilenameFound = true;
			}
		}
		for (String hcode : hcodes) {
			if (hcode.equals(hashvalue)) {
				System.out.println("Duplicate hash code found --- "+hcode);
				duplicateHashCodeFound = true;
			}
		}
	    boolean result = duplicateFilenameFound || duplicateHashCodeFound;
	    return ResponseEntity.ok(result);
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		System.out.println("ok2");

		String fileName = fileStorageService.storeFiles(file, request, listFileParameters.get(0));
		listFileParameters.remove(0);
		return fileName;

	}

	// added by harshita
	@RequestMapping(value = "/addressProofFile", method = RequestMethod.POST)
	public String addressProofFile(@RequestParam("file") MultipartFile file) {
		System.out.println("ok2");

		String fileName = fileStorageService.storeFiles(file, request, listFileParameters.get(0));
		listFileParameters.remove(0);
		return fileName;

	}

	@RequestMapping(value = "/drugLicence", method = RequestMethod.POST)
	public String drugLicence(@RequestParam("file") MultipartFile file) {
		System.out.println("ok2");

		String fileName = fileStorageService.storeFiles(file, request, listFileParameters.get(0));
		listFileParameters.remove(0);
		return fileName;

	}

	@PostMapping("/uploadFileData")
	public String uploadFileData(@RequestBody FileParameters fp) {
		System.out.println("upload file data");
		listFileParameters.add(fp);
		System.out.println("shubham");
		return "added";
	}

	@RequestMapping(value = "/RecRCMCData", method = RequestMethod.POST)
	public void getRecRCMCData(@RequestBody String RcmcData, @RequestParam String apikey)

	{

		davaser.RCMCData(RcmcData);

	}

	private boolean CheckXSDFormat(Path xmlFilePath, File xsdFile, int purposeType) {

		boolean response = false;

		File schemaFile = null;
		if (purposeType == 1) {
			schemaFile = new File(uploadingPath.getXsdPath() + "PROSchema.xsd");
		} else if (purposeType == 2) {
			schemaFile = new File(uploadingPath.getXsdPath() + "ManufactureSchema.xsd");
		} else if (purposeType == 3) {
			schemaFile = new File(uploadingPath.getXsdPath() + "ExporterTertiaryPackingSchema.xsd");
		} else {
			System.out.println("purpose not found 404................................................................");
		}

		Source xmlFile = new StreamSource(new File(xmlFilePath.toString()));
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		try {

			schemaFile.setReadable(true);
			Schema schema = schemaFactory.newSchema(schemaFile);
			Validator validator = schema.newValidator();
			validator.validate(xmlFile);

			response = true;
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return response;
	}

	
	//NO USING THIS CODE , USING FILESTORAGE.JAVA CODE
	/*
	 * private boolean CheckHashValue(Path path1) throws IOException {
	 * 
	 * String fileString = new String(Files.readAllBytes(path1),
	 * StandardCharsets.UTF_8); String hashvalue = fileString.hashCode() + ""; //
	 * System.err.println("hashvalue=------------------- "+hashvalue); boolean
	 * response = false;
	 * 
	 * List<String> itemsToAdd = new ArrayList<String>(); itemsToAdd.add(hashvalue);
	 * // System.err.println("add detail hash code--- "+itemsToAdd);
	 * 
	 * List<UploadXmlDataDtlDomain> uploaddata = davaServices.getUploadedData();
	 * 
	 * 
	 * for(int i=0;i<uploaddata.size();i++) {
	 * System.err.println("already present hash code-- "+uploaddata.get(i).
	 * getStrHashCode()); }
	 * 
	 * if (uploaddata.size() != 0) { //
	 * System.err.println("upload data in table size is not 0 "+uploaddata.size());
	 * for (UploadXmlDataDtlDomain modelListdata : uploaddata) { for (String
	 * prevListdata : itemsToAdd) { if
	 * (prevListdata.toString().equals(modelListdata.getStrHashCode())) {
	 * System.err.println("same hashcode-------   "); response = false;
	 * 
	 * } else { System.err.println("Hash code not same"); response = true; }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * } else response = true;
	 * 
	 * return response; }
	 */

	@PostMapping("/UserLogin")
	public ResponseEntity<RegistrationDetails> sendFile(@RequestBody Demo demo) {
		System.out.println(LocalDateTime.now() + " --- Desktop User " + demo.getUsername());
		RegistrationDetails registrationDetails = null;
		if (demo != null) {
			registrationDetails = davaser.findByUserName(demo.getUsername().toLowerCase().trim());
			if (registrationDetails == null)
				throw new ResourceNotFound("no user found with " + demo.getUsername() + " this user name");

			boolean checkCredentials = davaser.verifyPasswords(demo.getPassword(), registrationDetails.getPassword());

			if (registrationDetails.getNumEmailStatus() == 0)
				throw new UserNotVerified("User Not Verified email yet");
			else if (registrationDetails.getNumApprovalStatusPharmaexil() == 0)
				throw new UserNotVerified("Registration request is pending at Pharmexcil");
			else if (registrationDetails.getNumApprovalStatusPharmaexil() == 2)
				throw new UserNotVerified("Registration request is cancelled by Pharmexcil");
			else if (checkCredentials == false)
				throw new CredentialsNotValid("Bad Credentils");
		}
		return new ResponseEntity<RegistrationDetails>(registrationDetails, HttpStatus.ACCEPTED);
	}

	@PostMapping("/desktopConfigDtls")
	public ResponseEntity<DesktopConfigDtlDom> sendFileConfigDtls(@RequestBody DesktopConfigDtls desk) {
		System.out.println("user  : " + desk.getUserId());
		System.out.println("inside user login");
		List<DesktopConfigDtlDom> deskDtls = null;
		if (desk != null) {
			deskDtls = davaser.findDesktopCongDtls(desk.getUserId());
			if (deskDtls == null)
				throw new ResourceNotFound("No Configuration found");

		}
		return new ResponseEntity<DesktopConfigDtlDom>(deskDtls.get(0), HttpStatus.ACCEPTED);
	}

	@GetMapping("/getVersionDetls")
	public ResponseEntity<String> getVersionDetls() {
		System.out.println("inside user login");
		String appVersion = APP_VERSION;

		// return new
		// ResponseEntity<DesktopConfigDtlDom>(deskDtls.get(0),HttpStatus.ACCEPTED);
		return new ResponseEntity<String>(appVersion, HttpStatus.OK);
	}

	@PostMapping("/app/user/logs")
	public ResponseEntity<String> saveUerLogs(@Valid @RequestBody AppUserLogsForm appUserLogsForm) {
		String result = davaser.saveUserAppLogs(appUserLogsForm);
		return new ResponseEntity<String>(result, HttpStatus.ACCEPTED);
	}

	@PostMapping("/guest/registration")
	public ResponseEntity<String> saveHostRegistration(@RequestBody @Valid HostRegistrationForm hostRegForm) {

		String result = davaser.saveOfficialRegistration(hostRegForm);
		if (result.equals("Email id already exist"))
			throw new UserAlreadyExist("Given Email Id already exist");

		return new ResponseEntity<String>(result, HttpStatus.CREATED);
	}

	@PostMapping("/guest/verifyotp")
	public ResponseEntity<String> compareOtp(@RequestBody HostRegistrationForm hostRegForm) {

		String status = davaser.verifyOtp(hostRegForm);
		if (status.equals("Email id does not exist"))
			throw new ResourceNotFound("Given email id does not exist");

		return new ResponseEntity<String>(status, HttpStatus.CREATED);
	}

	@GetMapping("/guest/resendotp/{emailId}")
	public ResponseEntity<String> resendOtp(@PathVariable String emailId) {

		String status = davaser.resendOtp(emailId.toLowerCase());
		if (status.equals("Email id does not exist"))
			throw new ResourceNotFound("Given email id does not exist");

		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

	@GetMapping("/ivedaRegistrationData")
	public ResponseEntity<List<RegistrationDetails>> getRegistrationData() {
		List<RegistrationDetails> registrationData = davaser.getRegistrationData();
		return new ResponseEntity<List<RegistrationDetails>>(registrationData, HttpStatus.OK);
	}

	@PostMapping("/ConfigDetails")
	public String configdtl(@RequestBody ConfigDtl configdtl) {
		String response = davaser.setConfigDetails(configdtl);
		LOGGER.info("dongal configuration done for user {} with status {}", configdtl.getUser_id(), response);
		return response;
	}

	@PostMapping("/updatePublicKey")
	public String updatePublicKey(@RequestBody UpdatePublicKeyModel upk) {
		System.out.println(upk.toString());
		davaser.updatePublicKeyInUR(upk.getUserId(), upk.getMac_address(), upk.getPublicKey());
		return "success";
	}

	
    @GetMapping("/HashCodeCheck")
    public ResponseEntity<HashCodesAndFilenames> sendHashCodeAndFileNameOriginal() {
    	System.out.println("inside hashcodecheck");
	    HashCodesAndFilenames hashCodesAndFilenames = new HashCodesAndFilenames();
	    List<String> hcodes = davaServices.getUploadedData();
	    List<String> filenames = documentMasterDomainRepository.findStrRemarksWithXml();
	    //hashCodesAndFilenames.setHcodes(hcodes);
	    //hashCodesAndFilenames.setFilenames(filenames);
	    return new ResponseEntity<HashCodesAndFilenames>(hashCodesAndFilenames, HttpStatus.OK);
    }	

	
//	public List<String> getHashCodeColumn(){
//		List<String> hcodes = davaServices.getUploadedData();
//		System.out.println("++++++++++++++++++++++++++++++" + hcodes);
//		return hcodes;
//	}
	
	
	@RequestMapping(value = "/RCMCData", method = RequestMethod.GET)
	public Object getRCMCData(HttpServletRequest request) throws MalformedURLException {
		try {
			System.out.println("RCMC");
			URL obj = new URL("https://pharmexcil.in/member/cdac_api/RCMCData?apikey=CDAC@Auth$2019");
			HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
			System.out.println("Hello con");
			// conn.setRequestProperty("apikey", "CDAC@Auth$2019");

			conn.setRequestMethod("GET");
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-Type", "application/json");

			int responseCode = conn.getResponseCode();

			String output;
			StringBuffer output1 = new StringBuffer();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				StringBuffer response = new StringBuffer();

				System.out.println("Output from Server ... \n");
				while ((output = in.readLine()) != null) {
					output1.append(output);
					System.out.println(output);
				}
				in.close();
				davaser.RCMCData(output1.toString());

			} else {
				System.out.println("GET NOT WORKED");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "";
	}
	
	
}
