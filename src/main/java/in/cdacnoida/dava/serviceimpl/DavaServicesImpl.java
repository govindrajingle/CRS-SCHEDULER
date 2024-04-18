package in.cdacnoida.dava.serviceimpl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.WordUtils;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.MapSolrParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.cdacnoida.dava.controllers.FtpService;
import in.cdacnoida.dava.controllers.GlobalAction;
import in.cdacnoida.dava.controllers.MD5Hash;
import in.cdacnoida.dava.daoimpl.DaoHelper;
import in.cdacnoida.dava.daoservice.DavaDaoServices;
import in.cdacnoida.dava.entities.AppUserLogs;
import in.cdacnoida.dava.entities.ApplicantTypeMasterDomain;
import in.cdacnoida.dava.entities.ApprovalPremisesDetail;
import in.cdacnoida.dava.entities.ApprovalTypeMst;
import in.cdacnoida.dava.entities.CodeRequestMstDomain;
import in.cdacnoida.dava.entities.ConsignmentDetailDomain;
import in.cdacnoida.dava.entities.ConsignmentDetailsEntity;
import in.cdacnoida.dava.entities.CountryMst;
import in.cdacnoida.dava.entities.DesktopConfigDtlDom;
import in.cdacnoida.dava.entities.DistrictMst;
import in.cdacnoida.dava.entities.DrugMst;
import in.cdacnoida.dava.entities.EXPORT_DETAILS;
import in.cdacnoida.dava.entities.EXP_TERTIARY_LIST_DETAILS;
import in.cdacnoida.dava.entities.EmailDetailDomain;
import in.cdacnoida.dava.entities.EmailMstDomain;
import in.cdacnoida.dava.entities.EmailSchedulerEntity;
import in.cdacnoida.dava.entities.ExportOrderDomain;
import in.cdacnoida.dava.entities.HostRegistrationEntity;
import in.cdacnoida.dava.entities.InstPremiseDtlDomain;
import in.cdacnoida.dava.entities.InstituteMasterDomain;
import in.cdacnoida.dava.entities.InstituteMemberDetailDomain;
import in.cdacnoida.dava.entities.LicPremiseDtlDomain;
import in.cdacnoida.dava.entities.LicenseTypeMstDomain;
import in.cdacnoida.dava.entities.LocationMasterDomain;
import in.cdacnoida.dava.entities.MemberTypeMasterDomain;
import in.cdacnoida.dava.entities.NewsEventMstDomain;
import in.cdacnoida.dava.entities.NewsEventsDomain;
import in.cdacnoida.dava.entities.OfficialRegistrationDetails;
import in.cdacnoida.dava.entities.OtherPromotionCouncilDetails;
import in.cdacnoida.dava.entities.PasswordHistory;
import in.cdacnoida.dava.entities.PointOfDistributionMst;
import in.cdacnoida.dava.entities.PortOfExportDomain;
import in.cdacnoida.dava.entities.ProcurementMstDomain;
import in.cdacnoida.dava.entities.ProductDetails;
import in.cdacnoida.dava.entities.PromotionCouncilMaster;
import in.cdacnoida.dava.entities.RcmcRegistrationData;
import in.cdacnoida.dava.entities.RegistrationDetails;
import in.cdacnoida.dava.entities.ReportProblemDomain;
import in.cdacnoida.dava.entities.SECONDARY1_DETAILS;
import in.cdacnoida.dava.entities.SECONDARY2_DETAILS;
import in.cdacnoida.dava.entities.SECONDARY3_DETAILS;
import in.cdacnoida.dava.entities.SeatMaster;
import in.cdacnoida.dava.entities.StatesMst;
import in.cdacnoida.dava.entities.TERTIRY_DETAILS;
import in.cdacnoida.dava.entities.TileDomain;
import in.cdacnoida.dava.entities.UploadConsignDtlDomain;
import in.cdacnoida.dava.entities.UploadInvoiceDtlDomain;
import in.cdacnoida.dava.entities.UploadPurchaseOrderDtlDom;
import in.cdacnoida.dava.entities.UploadXmlDataDtlDomain;
import in.cdacnoida.dava.entities.UploadXmlDataDtlLogDomain;
import in.cdacnoida.dava.entities.UploadXmlInvoiceDtlDomain;
import in.cdacnoida.dava.entities.WorkshopRegistrationDomain;
import in.cdacnoida.dava.entities.ZoneMst;
import in.cdacnoida.dava.entities.galleryFormentity;
import in.cdacnoida.dava.model.AppUserLogsForm;
import in.cdacnoida.dava.model.ConfigDtl;
import in.cdacnoida.dava.model.ConsignmentDetails;
import in.cdacnoida.dava.model.DrugDtlsModel;
import in.cdacnoida.dava.model.EXPORT;
import in.cdacnoida.dava.model.EXP_TERTIARY_LIST;
import in.cdacnoida.dava.model.ExportOrderModel;
import in.cdacnoida.dava.model.GeneratePackModel;
import in.cdacnoida.dava.model.HibernateSearchModel;
import in.cdacnoida.dava.model.HostRegistrationForm;
import in.cdacnoida.dava.model.MANUFACTURE_SCHEMA_LIST;
import in.cdacnoida.dava.model.MemberAddDtlModel;
import in.cdacnoida.dava.model.MemberDetailForm;
import in.cdacnoida.dava.model.NewsEventsModel;
import in.cdacnoida.dava.model.OffRegModel;
import in.cdacnoida.dava.model.OfficialForm;
import in.cdacnoida.dava.model.PRODUCT_SCHEMA_LIST;
import in.cdacnoida.dava.model.PointOfDistributionModel;
import in.cdacnoida.dava.model.PortOfExportModel;
import in.cdacnoida.dava.model.ProcurementMstModel;
import in.cdacnoida.dava.model.Product;
import in.cdacnoida.dava.model.RegistrationForm;
import in.cdacnoida.dava.model.SECONDARY1;
import in.cdacnoida.dava.model.SECONDARY2;
import in.cdacnoida.dava.model.SECONDARY3;
import in.cdacnoida.dava.model.TERTIARY;
import in.cdacnoida.dava.model.UploadDataForm;
import in.cdacnoida.dava.model.WorkshopRegistrationModel;
import in.cdacnoida.dava.model.galleryForm;
import in.cdacnoida.dava.service.DavaServices;
import in.cdacnoida.dava.transactions.AppUserLogsRepo;
import in.cdacnoida.dava.transactions.DavaTransactions;
import in.cdacnoida.dava.transactions.EmailSchedulerRepo;
import in.cdacnoida.dava.transactions.GuestRegistrationRepo;
import in.cdacnoida.dava.transactions.UploadXmlDataDtlLogRepository;
import in.cdacnoida.dava.transactions.UserRepository;
import in.cdacnoida.dava.util.Sendmail;
import in.cdacnoida.davaconfig.EmailContent;
import in.cdacnoida.davaconfig.FtpDetailsProperties;

@Service
public class DavaServicesImpl implements DavaServices{

	@Value("${solr.server.url}") 
	private String urlString="";
	
	@Value("${projectUrl}")
	String projectUrl;					
				   
 
	private static final Logger LOGGER=LoggerFactory.getLogger(DavaServicesImpl.class);
	
//
	@Autowired
	private GlobalAction fileServices;
	
	@Autowired
	private DavaDaoServices davaDaoServices;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	public DavaDaoServices davaDao;
	
	@Autowired
	public DaoHelper daoHelper;
	
	@Autowired
	private DavaTransactions davaTransactions;
	
	@Autowired
	private FtpDetailsProperties ftpProps;
	
	@Autowired
	private FtpService ftpService;
	
	@Autowired
	private Sendmail sendmail;
	
	@Autowired
	private EmailContent emailContent;
	
	@Autowired
	private EmailSchedulerRepo emailSchedulerRepo;
	
	@Autowired
	private UploadXmlDataDtlLogRepository uploadXmlDataDtlLogRepository;
	
	@Autowired
	private GuestRegistrationRepo guestRegRepo;
	
	@Autowired
	private AppUserLogsRepo appUserLogsRepo;
	
	public List<CountryMst> getCountryNames() {
		List<CountryMst> countryMst=davaDaoServices.getCountryNames();
		return countryMst;
	}

	@Override
	public List<DistrictMst> getDistrictNames(Integer stateId) {
		List<DistrictMst> districtMst=davaDaoServices.getDistrictNames(stateId);
		return districtMst;
	}

	@Override
	public List<StatesMst> getStatedata(Integer countryId) {
		List<StatesMst> stateData=davaDaoServices.getStatedata(countryId);
		return stateData;
	}
	
	@Override
	public List<RegistrationDetails> getUserId() {
		List<RegistrationDetails> userData=davaDaoServices.getUserId();
		return userData;
	}

	@Override
	public RegistrationDetails saveUser(RegistrationForm registrationForm) {
		
		PasswordHistory passwordHistory=new PasswordHistory();
		System.out.println("registrationForm.getPassword():::"+registrationForm.getPassword());
		System.out.println("registrationForm timeline():::"+registrationForm.getExpirationTime());
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

		String[] temp = value4.split(" ### ");
		if (temp.length == 3) {
			registrationForm.setPassword(temp[1].trim());
			System.out.println(temp[1].trim());
		} else {
			throw new Exception("Invalid Password Exception");
		}
		} catch (Exception e) {

		}
		//Encryption of password using bcrypt	
		registrationForm.setPassword(bCryptPasswordEncoder.encode(registrationForm.getPassword()));	
		//registrationForm.setPassword(bCryptPasswordEncoder.encode(decodedPass2));
		passwordHistory.setPassword(registrationForm.getPassword());
		//passwordHistory.setPassword(decodedPass2);
		System.out.println("registrationForm.getPassword()ddd:::"+registrationForm.getPassword());
		RegistrationDetails registrationDetails=getRefistrationEntity(registrationForm);
		passwordHistory.setRegistrationDetails(registrationDetails);
		RegistrationDetails getUserNameDetails=userRepository.findByUserName(registrationDetails.getUserName());
		if(getUserNameDetails!=null)
			return null;
		
		RegistrationDetails status=davaDaoServices.saveUser(registrationDetails);
		
		if(status!=null)
			davaDaoServices.savePasswordHistoryDetails(passwordHistory);
		
		if(status!=null && registrationForm.getMemberOfOtherExportPromotionCouncil().equals("yes")) {
			for(int i=0;i<registrationForm.getPromotionCouncil().length;i++) {
				OtherPromotionCouncilDetails otherPromotionCouncilDetails=new OtherPromotionCouncilDetails();
				String promotionCouncilName=registrationForm.getPromotionCouncil()[i];
				String registrationNumber=registrationForm.getRegistrationNumber()[i];
				Date validThrough=registrationForm.getValidityDuration()[i];
				otherPromotionCouncilDetails.setStrPromotionCouncilName(promotionCouncilName);
				otherPromotionCouncilDetails.setStrRegistrationNumber(registrationNumber);
				otherPromotionCouncilDetails.setDateValidThrough(validThrough);
				otherPromotionCouncilDetails.setRegistrationDetails(status);
				davaDaoServices.saveOtherPromotionCouncil(otherPromotionCouncilDetails);
			}
		}
		
		return status;
		
	}
	 public  String decode(String strString_p)	
	   {	
	        if(strString_p==null)	
	                strString_p="";	
	        else	
	        {	
	           try	
	       {	
	                 strString_p = new String((new sun.misc.BASE64Decoder()).decodeBuffer(strString_p));	
	       }	
	                        catch(Exception e){}	
	                }	
	                return strString_p;	
	        }	
	 public static String reverse(String input){	
		    char[] in = input.toCharArray();	
		    int begin=0;	
		    int end=in.length-1;	
		    char temp;	
		    while(end>begin){	
		        temp = in[begin];	
		        in[begin]=in[end];	
		        in[end] = temp;	
		        end--;	
		        begin++;	
		    }	
		    return new String(in);	
		}
	private RegistrationDetails getRefistrationEntity(RegistrationForm registrationForm) {
		RegistrationDetails registrationDetails=new RegistrationDetails();
		//String dpanNumber=decode(registrationForm.getOrgPanNumber());
		registrationDetails.setUserId(registrationForm.getUserId());
		
		registrationDetails.setUserName(registrationForm.getUserName().toLowerCase());
		registrationDetails.setPassword(registrationForm.getPassword());	
		//registrationDetails.setPassword(decodedPasswordd);
		registrationDetails.setApplicantType(registrationForm.getApplicantType());
		registrationDetails.setOrgName(registrationForm.getOrgName());
		registrationDetails.setOrgType(registrationForm.getOrgType());
		registrationDetails.setOrgAddress(registrationForm.getOrgAddress());
		registrationDetails.setOrgCountryId(registrationForm.getOrgCountryId());
		registrationDetails.setOrgStateId(registrationForm.getOrgStateId());
		registrationDetails.setOrgDistId(registrationForm.getOrgDistId());
		registrationDetails.setOrgContactNumber(registrationForm.getOrgContactNumber());
		registrationDetails.setOrgPincode(registrationForm.getOrgPincode());
		registrationDetails.setOrgFaxNumber(registrationForm.getOrgFaxNumber());
		registrationDetails.setOrgEmailId(registrationForm.getOrgEmailId());
		registrationDetails.setOrgPanNumber(registrationForm.getOrgPanNumber());
		registrationDetails.setOrgWebsite(registrationForm.getOrgWebsite());
		
		registrationDetails.setManfSiteName(registrationForm.getManfSiteName());
		registrationDetails.setManfSiteAddress(registrationForm.getManfSiteAddress());
		registrationDetails.setManfSitePincode(registrationForm.getManfSitePincode());
		registrationDetails.setManfCountryId(registrationForm.getManfCountryId());
		registrationDetails.setManfStateId(registrationForm.getManfStateId());
		registrationDetails.setManfDistId(registrationForm.getManfDistId());
		registrationDetails.setManfSiteCity(registrationForm.getManfSiteCity());
		registrationDetails.setManfSiteContactNumber(registrationForm.getManfSiteContactNumber());
		registrationDetails.setManfSiteFaxNumber(registrationForm.getManfSiteFaxNumber());
		registrationDetails.setManfLicNumber(registrationForm.getManfLicNumber());
		
		registrationDetails.setIecNumber(registrationForm.getIecNumber());
		registrationDetails.setIecIssueDate(registrationForm.getIecIssueDate());
		registrationDetails.setIecIssueAuthority(registrationForm.getIecIssueAuthority());
		
		registrationDetails.setSsiNumber(registrationForm.getSsiNumber());
		registrationDetails.setSsiType(registrationForm.getSsiType());
		registrationDetails.setSsiIssueDate(registrationForm.getSsiIssueDate());
		
		registrationDetails.setContactPersonName(registrationForm.getContactPersonName());
		registrationDetails.setContactPerDesg(registrationForm.getContactPerDesg());
		registrationDetails.setContPerMobileNo(registrationForm.getContPerMobileNo());
		registrationDetails.setContPersEmail(registrationForm.getContPersEmail());
		
		registrationDetails.setRandomNumber(registrationForm.getRandomCode());
		registrationDetails.setNumEmailStatus(0);
		registrationDetails.setNumIsValied(0);
		registrationDetails.setNumTrUserId(0);
		registrationDetails.setDtTrDate(new Date());
		
		registrationDetails
				.setMemberOfOtherExportPromotionCouncil(registrationForm.getMemberOfOtherExportPromotionCouncil());
		registrationDetails.setNumRcmsStatus(registrationForm.getNumRcmcFlag());
		registrationDetails.setStrRcmcNumber(registrationForm.getStr_rcmc_fieo_no());
		registrationDetails.setRcmcOfFieo(registrationForm.getRcmcOfFieo());
		
		registrationDetails.setNumApprovalStatusPharmaexil(0);
		
		registrationDetails.setVerificationLink(registrationForm.getEmailVerificationLink());
		
		registrationDetails.setGstnumber(registrationForm.getGstnumber());
		
		registrationDetails.setGsOne(registrationForm.getGsOne());
		
		// Govind 080923
		registrationDetails.setExpirationTime(registrationForm.getExpirationTime());
		registrationDetails.setCategoryDropdown(registrationForm.getCategoryDropdown());
		registrationDetails.setOrgDropdown(registrationForm.getOrgDropdown());		
		
		return registrationDetails;
	}

	@Override
	public RegistrationForm getRcmcData(String rcmcNumber) {
		
		RcmcRegistrationData rcmcRegistrationData=davaDaoServices.getRcmcData(rcmcNumber);
		RegistrationForm regForm=new RegistrationForm();
		if(rcmcRegistrationData!=null) {
			regForm=getRegFormData(rcmcRegistrationData);
			//Hiding the RCMC Confidential Details
            regForm.setOrgContactNumber(null);
            regForm.setContPerMobileNo(null);
            regForm.setContactPersonName(null);
            regForm.setContactPerDesg(null);
            regForm.setContPersEmail(null);
            regForm.setIecNumber(null);
            regForm.setIecIssueDate(null);
            regForm.setIecIssueAuthority("DGFT");
		}
		return regForm;
	}

	private RegistrationForm getRegFormData(RcmcRegistrationData rcmcRegistrationData) {
		RegistrationForm registrationForm=new RegistrationForm();
		
		registrationForm.setUserId(rcmcRegistrationData.getUserId());
		
		registrationForm.setApplicantType(rcmcRegistrationData.getApplicantType());
		registrationForm.setOrgName(rcmcRegistrationData.getOrgName());
		registrationForm.setOrgType(rcmcRegistrationData.getOrgType());
		registrationForm.setOrgAddress(rcmcRegistrationData.getOrgAddress());
		registrationForm.setOrgCountryId(rcmcRegistrationData.getOrgCountryId());
		registrationForm.setOrgStateId(rcmcRegistrationData.getOrgStateId());
		registrationForm.setOrgDistId(rcmcRegistrationData.getOrgDistId());
		registrationForm.setOrgContactNumber(rcmcRegistrationData.getOrgContactNumber());
		registrationForm.setOrgPincode(rcmcRegistrationData.getOrgPincode());
		registrationForm.setOrgFaxNumber(rcmcRegistrationData.getOrgFaxNumber());
		registrationForm.setOrgEmailId(rcmcRegistrationData.getOrgEmailId());
		registrationForm.setOrgPanNumber(rcmcRegistrationData.getOrgPanNumber());
		registrationForm.setOrgWebsite(rcmcRegistrationData.getOrgWebsite());
		
		//registrationForm.setManfSiteName(rcmcRegistrationData.getManfSiteName());
		//registrationForm.setManfSiteAddress(rcmcRegistrationData.getManfSiteAddress());
		//registrationForm.setManfSitePincode(rcmcRegistrationData.getManfSitePincode());
		//registrationForm.setManfCountryId(rcmcRegistrationData.getManfCountryId());
		//registrationForm.setManfStateId(rcmcRegistrationData.getManfStateId());
		//registrationForm.setManfDistId(rcmcRegistrationData.getManfDistId());
		//registrationForm.setManfSiteCity(rcmcRegistrationData.getManfSiteCity());
		//registrationForm.setManfSiteContactNumber(rcmcRegistrationData.getManfSiteContactNumber());
		//registrationForm.setManfSiteFaxNumber(rcmcRegistrationData.getManfSiteFaxNumber());
		//registrationForm.setManfLicNumber(rcmcRegistrationData.getManfLicNumber());
		
		registrationForm.setIecNumber(rcmcRegistrationData.getIecNumber());
		registrationForm.setIecIssueDate(rcmcRegistrationData.getIecIssueDate());
		registrationForm.setIecIssueAuthority(rcmcRegistrationData.getIecIssueAuthority());
		
		registrationForm.setSsiNumber(rcmcRegistrationData.getSsiNumber());
		//registrationForm.setSsiType(rcmcRegistrationData.getSsiType());
		registrationForm.setSsiIssueDate(rcmcRegistrationData.getSsiIssueDate());
		
		registrationForm.setContactPersonName(rcmcRegistrationData.getContactPersonName());
		registrationForm.setContactPerDesg(rcmcRegistrationData.getContactPerDesg());
		registrationForm.setContPerMobileNo(rcmcRegistrationData.getContPerMobileNo());
		registrationForm.setContPersEmail(rcmcRegistrationData.getContPersEmail());

		return registrationForm;
	}

	@Override
	public boolean updatePasswordcnf(RegistrationForm registrationForm) {
		boolean status=false;
		RegistrationDetails registrationDetails=userRepository.findByUserName(registrationForm.getUserName());
		
		
		if(registrationDetails!=null) {
			
			PasswordHistory passwordHistory=new PasswordHistory();
			passwordHistory.setPassword(bCryptPasswordEncoder.encode(registrationForm.getPassword()));
			
			registrationDetails.setPassword(bCryptPasswordEncoder.encode(registrationForm.getPassword()));
			 System.out.println("harshi" + bCryptPasswordEncoder.encode(registrationForm.getPassword()));
			//added by harshita
			 Random random = new Random(System.nanoTime() % 100000);
				int randomCode = random.nextInt(1000000000);
				registrationForm.setRandomCode(randomCode);
				
			registrationDetails.setRandomNumber(registrationForm.getRandomCode());
			 System.out.println("harshita"+registrationForm.getRandomCode());
			passwordHistory.setRegistrationDetails(registrationDetails);
			
			try {
				davaDaoServices.saveUser(registrationDetails);
				davaDaoServices.savePasswordHistoryDetails(passwordHistory);
				status=true;
			} catch (Exception e) {
				LOGGER.info("exception in updating password of user {} ",e.getMessage());
				return status;
			}
		}
		return status;
	}

	
	@Override
	public RegistrationDetails verifyUserEmail(String userName, int randomCode) {
		RegistrationDetails status = null;
		RegistrationDetails registrationDetails=userRepository.findByUserName(userName);
            	 if(registrationDetails!=null && registrationDetails.getRandomNumber()==randomCode) {//ith
            		registrationDetails.setNumEmailStatus(1);
            		 registrationDetails.setRandomNumber(0);
            		 if(registrationDetails.getApplicantType().equals("104"))
            			 registrationDetails.setNumApprovalStatusPharmaexil(1);
            		 		status=davaDaoServices.saveUser(registrationDetails);
            	 }//ith
		return status;
	}

	
	
	@Override
	public void  verifyUserEmailfail(String userName, int randomCode) {
		
		RegistrationDetails registrationDetails=userRepository.findByUserName(userName);
            	
		         		registrationDetails.setNumEmailStatus(0);
		         		davaDaoServices.saveUser(registrationDetails);
            		 //registrationDetails.setRandomNumber(0);
            
	}

	
	@Override
	public boolean checkUserNameExist(String userName) {
		boolean status=false;
		RegistrationDetails registrationDetails=userRepository.findByUserName(userName);
		if(registrationDetails!=null) 
			status=true;
		else
			status=false;
		return status;
	}
	
	public String generateJSONObject(String Fun, String searchTerm, String Query, int sAmount, int sStart) {
		String str=davaDaoServices.generateJSONObject(Fun,searchTerm,Query,sAmount,sStart);
		return str;
	}
	
	public String ShowRCMCData(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int amount = 5; /* Amount in Show Entry drop down */
		int start = 0; /* Counter for Paging, initially 0 */
		int echo = 0; /* Maintains the request number, initially 0 */
		int col = 0; /* Column number in the datatable */
		/* Below variables store the options to create the Query */
		
		String dir = "asc";
		int sStart =  0;
		int sAmount =  5000000;
		String sEcho = request.getParameter("sEcho");
		String sCol = request.getParameter("iSortCol_0");
		String sdir = request.getParameter("sSortDir_0");
		
		String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) {
			start = sStart;
			if (start < 0)
				start = 0;
		}
 
		/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) {
			amount = sAmount;
			if (amount < 5 || amount > 100)
				amount = 5;
		}
 
		/* Counter of the request sent from Data table */
		if (sEcho != null) {
			echo = Integer.parseInt(sEcho);
		}
 
		/* Column number */
		if (sCol != null) {
			col = Integer.parseInt(sCol);
			if (col < 0 || col > 5)
				col = 0;
		}
 
		/* Sorting order */
		if (sdir != null) {
			if (!sdir.equals("asc"))
				dir = "desc";
		}
	
		
		String searchTerm ="";
		
		String Query = "select case applicant_type when 100 then 'Exporter' when 101 then 'Manufacturer' end as applicanttype,rcmc_number,rcmc_issuedt,to_char(rcmc_duedtrenew,'dd-Mon-yyyy') as rcmc_duedtrenew , org_name,org_address, org_pan_number,org_website,"
				+ " manf_site_name,manf_lic_number, contact_person_name || ' (' ||contact_per_desg || ')' contact_person_name"
				+ " from rcmc_registration_data r where rcmc_number <> '1001'";
		String result =generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
		return result.toString();
	}


	public String RCMCData(String data) {
		//return data;
		
		return davaDaoServices.getRCMCRegData(data);
	}


	public List<ApplicantTypeMasterDomain> getApplicantTypeList() {
		List<ApplicantTypeMasterDomain> appTypeList =davaDaoServices.getApplicantTypeList();
		return appTypeList;
	}

	public List<ApplicantTypeMasterDomain> getApplicantTypeListName(int numUserTypeId) {
		List<ApplicantTypeMasterDomain> appTypeList =davaDaoServices.getApplicantTypeListName(numUserTypeId);
		return appTypeList;
	}

	public List<LicenseTypeMstDomain> getLicenseType() {
		List<LicenseTypeMstDomain> licMst=davaDaoServices.getLicTypeList();
		return licMst;
	}
	
	public List<LicenseTypeMstDomain> getLicenseTypeForExp() {
		List<LicenseTypeMstDomain> licMst=davaDaoServices.getLicTypeListForExp();
		return licMst;
	}
	
	public String generateManufCode() {
		//For Generation of product Code
		  List<Character> arrayList = new ArrayList<Character>();
	      String capcode = "ABCDEFGHIJKLMONOPQURSTUVWXYZ0123456789";
	      for (int i = 1; i < capcode.length() - 1; i++) {
	          arrayList.add(capcode.charAt(i));
	      }
	      Collections.shuffle(arrayList);
	      Iterator itr = arrayList.iterator();
	      String s = "";
	      String s2 = "";
	      Object obj;
	      while (itr.hasNext()) {
	          obj = itr.next();
	          s = obj.toString();
	          s2 = s2 + s;
	      }
	      String s1 = s2.substring(0, 3);
	      char[] s3 = s1.toCharArray();
	      Random r = new Random();
	      int index = Math.abs(r.nextInt()) % 5;
	      System.out.println(index);
	      String manufCode = String.copyValueOf(s3);
	      System.out.println(manufCode);
		return manufCode;
	}
	
	public InstPremiseDtlDomain addInstPreDetail(MemberAddDtlModel memberAddDtlModel, HttpServletRequest request) {
		//String manufCode = generateManufCode();
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		InstPremiseDtlDomain instDom = new InstPremiseDtlDomain();
		instDom.setNumInstid(instId);
		instDom.setSiteType(memberAddDtlModel.getSiteType());
		instDom.setPremiseName(memberAddDtlModel.getPremiseName());
		instDom.setStrAddress(memberAddDtlModel.getPremiseAddress());
		instDom.setNumStateId(memberAddDtlModel.getStateId());
		instDom.setNumDistrictId(memberAddDtlModel.getDistrictId());
		instDom.setNumPincode(memberAddDtlModel.getPinCode());
		instDom.setStrContactDtls(memberAddDtlModel.getContactNumber());
		instDom.setFaxNumber(memberAddDtlModel.getFaxNumber());
		instDom.setEmailId(memberAddDtlModel.getEmailId());
		instDom.setGstin(memberAddDtlModel.getGstin());
		instDom.setGs1(memberAddDtlModel.getGs1());
		instDom.setContactPersonName(memberAddDtlModel.getContactPersonName());
		instDom.setContPerMobileNo(memberAddDtlModel.getContPerMobileNo());
		instDom.setContactPerDesg(memberAddDtlModel.getContactPerDesg());
		instDom.setContPersEmail(memberAddDtlModel.getContPersEmail());
		//instDom.setGtin(memberAddDtlModel.getGtin());
		instDom.setGln(memberAddDtlModel.getGln());
		//instDom.setStrManufCode(manufCode);
		instDom.setNumCountryId(193);
		instDom.setNumIsValid(1);
		instDom.setDtTrDate(new Date());
		instDom.setNumTrUserId(1001);
		instDom.setNumDocId(99);
		//instDom.setNumDocId(memberAddDtlModel.getNumDocId());
		InstPremiseDtlDomain premiseDomainPersisted = davaDaoServices.addPremisesDtls(instDom);
		return premiseDomainPersisted;
	}
	
	public EmailMstDomain addDataToEmailMst(String name, HttpServletRequest request) {
		
		EmailMstDomain emd = new EmailMstDomain();
		emd.setMailTypeName(name);
		emd.setRemarks("--");
		emd.setDtTrDate(new Date());
		emd.setNumIsValid(1);
		emd.setNumTrUserId(1001);
		EmailMstDomain data = davaDaoServices.saveEmailMst(emd);
		Integer email_id = data.getNumMailTypeId();
		request.getSession().setAttribute("email_id", email_id);
		return data;
		
	}
	
	public void addEmailDetailsToDb(Long userId, String userName, String subject, String body,
			HttpServletRequest request) {

		Integer id =  (Integer) request.getSession().getAttribute("email_id");
		System.out.println(id + "    id");
		EmailDetailDomain emailDom = new EmailDetailDomain();
		emailDom.setMailTypeId(id);
		emailDom.setNumSendTo(userId);
		emailDom.setStrSendTo(userName);
		emailDom.setSubject(subject);
		emailDom.setBody(body);
		emailDom.setDtTrDate(new Date());
		emailDom.setNumIsValid(1);
		emailDom.setNumTrUserId(1001);
		
		davaDaoServices.addEmailDetailsToDb(emailDom);
	}
	
	public LicPremiseDtlDomain addLicPreDetail(MemberAddDtlModel memberAddDtlModel, Integer premisesNo, HttpServletRequest request) {
		SimpleDateFormat inputFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		LicPremiseDtlDomain licDtlDom = null;
		System.out.println(memberAddDtlModel.getList_licNo().size() + "  ===== memberAddDtlModel.getList_licNo().size()");
		for(int i=0; i<memberAddDtlModel.getList_licNo().size();i++){
			LicPremiseDtlDomain licPreDtlDom = new LicPremiseDtlDomain();
			//licDtlDom.setNumInstId(instId);
			licPreDtlDom.setNumPremisesNo(premisesNo);
			licPreDtlDom.setStrLicenceNo(memberAddDtlModel.getList_licNo().get(i));
			licPreDtlDom.setStrIssuingAuth(memberAddDtlModel.getList_issueAuth().get(i));
			licPreDtlDom.setNumLicenceTypeId(memberAddDtlModel.getList_licType().get(i));
			//licPreDtlDom.setNumLicenceTypeId(1);
			
			String strFromdate = memberAddDtlModel.getList_fromDate().get(i);
			Date dtFromdate = null;
			try {
				dtFromdate = inputFormat2.parse(strFromdate);
			}catch(ParseException e) {
				e.printStackTrace();
			}
			licPreDtlDom.setFromDate(dtFromdate);
			
			String strToDate = memberAddDtlModel.getList_toDate().get(i);
			Date dtToDate = null;
			try {
				dtToDate = inputFormat2.parse(strToDate);
			}catch(ParseException e) {
				e.printStackTrace();
			}
			licPreDtlDom.setToDate(dtToDate);
			
			licPreDtlDom.setNumIsValid(1);
			licPreDtlDom.setDtTrDate(new Date());
			licPreDtlDom.setNumTrUserId(1001);
			
			licDtlDom = davaDaoServices.addLicwnsePremisesDtls(licPreDtlDom);
		}
		return licDtlDom;
	}


	public List<MemberTypeMasterDomain> getMemberType() {
		List<MemberTypeMasterDomain> memTypeList =davaDaoServices.getMemberTypeList();
		return memTypeList;
	}

	public List<NewsEventMstDomain> getEventType() {
		List<NewsEventMstDomain> memTypeList = davaDaoServices.getEventTypeList();
		return memTypeList;
	}

	public InstituteMemberDetailDomain saveMemberDetails(MemberDetailForm memDtlForm, HttpServletRequest request) {
		InstituteMemberDetailDomain instMemDtlDomain = new InstituteMemberDetailDomain();
		InstituteMemberDetailDomain memdtl = null;
		SimpleDateFormat inputFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		System.err.println("memDtlForm.getDateOfJoining()------ "+memDtlForm.getDateOfJoining());
		Date dtAppFromdate = null;
		try {
			dtAppFromdate = inputFormat2.parse(memDtlForm.getDateOfJoining());
		}catch(ParseException e) {
			e.printStackTrace();
		}
		String cardno=memDtlForm.getStrCardNumber();
		System.out.println("cardno:::"+cardno);
		String cardno2=decode(cardno);
		System.out.println("cardno2:::"+cardno2);
		String cardno3=reverse(cardno2);
		System.out.println("cardno3:::"+cardno3);
		String cardno4=decode(cardno3);
		System.out.println("cardno4:::"+cardno4);
		
		System.out.println("Date----   "+memDtlForm.getDateOfJoining()+"  Parse Date-------  "+dtAppFromdate);
		System.err.println("Integer.parseInt(memDtlForm.getStrDocId())---------  "+memDtlForm.getStrDocId());
		instMemDtlDomain.setNumMemberType(memDtlForm.getNumMemberType());
		instMemDtlDomain.setStrMemberName(memDtlForm.getStrMemberName());
		instMemDtlDomain.setStrEmail(memDtlForm.getStrEmail());
		instMemDtlDomain.setStrMemberGender(memDtlForm.getNumGender()+"");
		instMemDtlDomain.setStrMemberDesig(memDtlForm.getStrDesignation());
		instMemDtlDomain.setDtOfJoining(dtAppFromdate);
		instMemDtlDomain.setNumIdProofTypeid(memDtlForm.getIdProofTypeId());
		instMemDtlDomain.setStrIdCardNo(cardno4);
//		instMemDtlDomain.setStrIdCardNo(memDtlForm.getStrCardNumber());
		//instMemDtlDomain.setNumDocumentId();
		//instMemDtlDomain.setNumStatus(memDtlForm.getNumstatus());
		instMemDtlDomain.setNumIsValid(1);
		instMemDtlDomain.setDtTrDate(new Date());
		instMemDtlDomain.setStrContactNo(memDtlForm.getNumContactNo());
		instMemDtlDomain.setNumApplTypeId(0);
		instMemDtlDomain.setNumDocumentId(memDtlForm.getStrDocId());
		instMemDtlDomain.setStrFaxNo(memDtlForm.getNumFaxNo());
		instMemDtlDomain.setNumInstId(instId);
		memdtl = davaDaoServices.addMemberDetails(instMemDtlDomain);
		return memdtl;
	}
	
	public String addDrugMstDetail(DrugDtlsModel drugDtlsModel, HttpServletRequest request) {
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		/*
		 * String GenerateProdCode = null;
		 * 
		 * String DrugType = null; if(drugDtlsModel.getDrugType() == 11) { DrugType =
		 * "F"; }else if(drugDtlsModel.getDrugType() == 12) { DrugType = "B"; }
		 * 
		 * String TherepueticCat = null;
		 * if(Integer.toString(drugDtlsModel.getTherapeuticClass()).length() < 2 ) {
		 * TherepueticCat = "0" + Integer.toString(drugDtlsModel.getTherapeuticClass());
		 * }else { TherepueticCat =
		 * Integer.toString(drugDtlsModel.getTherapeuticClass()); }
		 * 
		 * String Dosage = null;
		 * if(Integer.toString(drugDtlsModel.getDosageForm()).length() < 2 ) { Dosage =
		 * "0" + Integer.toString(drugDtlsModel.getDosageForm()); }else { Dosage =
		 * Integer.toString(drugDtlsModel.getDosageForm()); }
		 * 
		 * List<Character> arrayList = new ArrayList<Character>(); String capcode =
		 * "ABCDEFGHIJKLMONOPQURSTUVWXYZ0123456789"; for (int i = 1; i <
		 * capcode.length() - 1; i++) { arrayList.add(capcode.charAt(i)); }
		 * Collections.shuffle(arrayList); Iterator itr = arrayList.iterator(); String s
		 * = ""; String s2 = ""; Object obj; while (itr.hasNext()) { obj = itr.next(); s
		 * = obj.toString(); s2 = s2 + s; } String s1 = s2.substring(0, 3); char[] s3 =
		 * s1.toCharArray(); Random r = new Random(); int index = Math.abs(r.nextInt())
		 * % 5; System.out.println(index); String SerialNum = String.copyValueOf(s3);
		 * System.out.println(SerialNum);
		 * 
		 * GenerateProdCode = DrugType + TherepueticCat + Dosage + SerialNum ;
		 * 
		 * System.out.println(GenerateProdCode);
		 */
		
		DrugMst drugDom = new DrugMst();
		drugDom.setNumInstId(instId);
		drugDom.setNumDrugType(drugDtlsModel.getDrugType());
		drugDom.setNumManuUnitId(drugDtlsModel.getManuUnit());
		
		/*
		 * List<String> manuUnits = drugDtlsModel.getListManufacturingUnit(); String
		 * str= null; if(manuUnits.size()>0) { str = manuUnits.get(0);
		 * System.err.println("str--"+str); for(int i=0;i<manuUnits.size()-1;i++) {
		 * str+= "," + manuUnits.get(i+1); System.err.println("str-"+str); }
		 * drugDom.setStrManufacturingUnit(str); } else {
		 * drugDom.setStrManufacturingUnit(""); }
		 */
		
		
		
		
	
		String genericName = drugDtlsModel.getGenericName();
		genericName = genericName.replaceAll(",", "");
		drugDom.setStrGenericName(genericName.trim());
		String brandName = drugDtlsModel.getBrandName();
		brandName = brandName.replaceAll(",$", "");
		drugDom.setStrBrandName(brandName.trim());
		drugDom.setNumDosageForm(drugDtlsModel.getDosageForm());
		drugDom.setNumPharmacopialClassification(drugDtlsModel.getClassificationDrug());
		drugDom.setNumScheduleId(drugDtlsModel.getScheduleDrug());
		String strength = drugDtlsModel.getStrength();
		strength = strength.replaceAll(",$", "");
		drugDom.setStrStrength(strength.trim());
		//drugDom.setStrStorageCondition(drugDtlsModel.getStorageCon().trim());
		String composition = drugDtlsModel.getComposition();
		composition = composition.replaceAll(",$", "");
		drugDom.setStrComposition(composition.trim());
		drugDom.setNumPackUnit(drugDtlsModel.getPackUnit());
		//drugDom.setStrPackSize(drugDtlsModel.getPackSize().trim());
		if(drugDtlsModel.getHsCode() != 0)
			drugDom.setNumHSCode(Long.valueOf(drugDtlsModel.getHsCode()));
		else
			drugDom.setNumHSCode(Long.valueOf(drugDtlsModel.getHsCodeFF()));
		
		if(drugDtlsModel.getNumStorageCondition() != 0)
			drugDom.setNumStorageCondition(drugDtlsModel.getNumStorageCondition());
		else
			drugDom.setNumStorageCondition(drugDtlsModel.getNumStorageConditionFF());
		
		drugDom.setNumThrepueticClass(drugDtlsModel.getTherapeuticClass());
		drugDom.setStrTherepueticClass(drugDtlsModel.getTherepueticClassOfDrug());
		String gtin = drugDtlsModel.getGtin();
		gtin = gtin.replaceAll(",", "");
		drugDom.setStrGtinNo(gtin.trim());
		//drugDom.setStrProductCode(GenerateProdCode);
		String packSIze = drugDtlsModel.getPackSize();
		packSIze = packSIze.replaceAll(",", "");
		drugDom.setStrPackSize(packSIze.trim());
		
		String primaryGTIN = drugDtlsModel.getpLevelGTIN();
		if (primaryGTIN.charAt(0)== ',') {
			primaryGTIN = primaryGTIN.replaceAll(",", "");
		}
		else {
			primaryGTIN = primaryGTIN.replaceAll(",$", "");
		
			
			//System.out.println(primaryGTIN.charAt(0));
				if(primaryGTIN.charAt(0) == ',') {
					primaryGTIN = primaryGTIN.substring(1);
				}
			}
		drugDom.setStrPrimaryGTIN(primaryGTIN.trim());
		
		
		String s1GTIN = drugDtlsModel.getS1LevelGTIN();
		//s1GTIN = s1GTIN.replaceAll(",", "");
		//s1GTIN = s1GTIN.replaceAll(",$", "");
		if(s1GTIN != "") {
			if(s1GTIN.charAt(0) == ',')
				s1GTIN = s1GTIN.substring(1);
			drugDom.setStrS1GTIN(s1GTIN.trim());
		}
		
		String s2GTIN = drugDtlsModel.getS2LevelGTIN();
		//s2GTIN = s2GTIN.replaceAll(",", "");
		//s2GTIN = s2GTIN.replaceAll(",$", "");
		if(s2GTIN != "") {
			if(s2GTIN.charAt(0) == ',')
				s2GTIN = s2GTIN.substring(1);
			drugDom.setStrS2GTIN(s2GTIN.trim());
		}
		
		String s3GTIN = drugDtlsModel.getS3LevelGTIN();
		//s3GTIN = s3GTIN.replaceAll(",", "");
		//s3GTIN = s3GTIN.replaceAll(",$", "");
		if(s3GTIN != "") {
			if(s3GTIN.charAt(0) == ',')
				s3GTIN = s3GTIN.substring(1);
			drugDom.setStrS3GTIN(s3GTIN.trim());
		}
		
		String tertiaryGTIN = drugDtlsModel.getTertiryLevelGTIN();
		//tertiaryGTIN = tertiaryGTIN.replaceAll(",", "");
		//tertiaryGTIN = tertiaryGTIN.replaceAll(",$", "");
		if(tertiaryGTIN != "") {
			if(tertiaryGTIN.charAt(0) == ',')
				tertiaryGTIN = tertiaryGTIN.substring(1);
			drugDom.setStrTertiaryGTIN(tertiaryGTIN.trim());
		}
		//drugDom.setNumPackLevel(drugDtlsModel.getPackLevel());
		
		drugDom.setDtTrDate(new Date());
		drugDom.setNumIsValid(1);
		drugDom.setNumTrUserId(1001);
		drugDom.setNumStatus(1);
		//List<DrugMst> list = davaTransactions.checkDuplicateRecordDrugMst(drugDom);
		//System.out.println("list size here     "+list.size());
		//int count = list.size();
		int count = 0 ;
		DrugMst drugMstDom = null;
		String msg = null;
		if(count>0) {
			msg = "Record already exist";
		}else {
			drugMstDom = davaDaoServices.addDrugDtls(drugDom);
		}
		
		return msg;
	}


	public void updateDocumentMstPath(String path, int numDocId) {
		davaDaoServices.updateDocumentMstPath(path,numDocId);
		
	}
	
	public ApprovalPremisesDetail addAppPremisesDtls(MemberAddDtlModel memberAddDtlModel, Integer premisesNo,
			HttpServletRequest request) {
		SimpleDateFormat inputFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		ApprovalPremisesDetail appPreDtl = null;
		System.out.println(memberAddDtlModel.getList_approvalNo().size()
				+ "  ===== memberAddDtlModel.getList_approvalNo().size()");
		for(int i=0; i<memberAddDtlModel.getList_approvalNo().size();i++){
			ApprovalPremisesDetail appPreDtls = new ApprovalPremisesDetail();
			//appPreDtls.setNumInstId(instId);
			appPreDtls.setNumPremisesNo(premisesNo);
			appPreDtls.setNumAppTypeId(memberAddDtlModel.getList_approvalType().get(i));
			appPreDtls.setStrAppNo(memberAddDtlModel.getList_approvalNo().get(i));
			//appPreDtls.setStrIssuingAuth(memberAddDtlModel.getList_appIssueAuth().get(i));
			
			String strAppFromdate = memberAddDtlModel.getList_appFromDate().get(i);
			Date dtAppFromdate = null;
			try {
				dtAppFromdate = inputFormat2.parse(strAppFromdate);
			}catch(ParseException e) {
				e.printStackTrace();
			}
			appPreDtls.setDtIssueDt(dtAppFromdate);
			
			String strAppToDate = memberAddDtlModel.getList_appToDate().get(i);
			Date dtAppToDate = null;
			try {
				dtAppToDate = inputFormat2.parse(strAppToDate);
			}catch(ParseException e) {
				e.printStackTrace();
			}
			appPreDtls.setDtExpiryDt(dtAppToDate);
			
			appPreDtls.setNumIsValid(1);
			appPreDtls.setDtTrDate(new Date());
			appPreDtls.setNumTrUserId(1001);
			
			appPreDtl = davaDaoServices.addApprovalPremisesDtls(appPreDtls);
		}
		return appPreDtl;
	}
	
	public String ShowDrugDetails(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int amount = 5; /* Amount in Show Entry drop down */
		int start = 0; /* Counter for Paging, initially 0 */
		int echo = 0; /* Maintains the request number, initially 0 */
		int col = 0; /* Column number in the datatable */
		/* Below variables store the options to create the Query */
		
		String dir = "asc";
		int sStart =  0;
		int sAmount =  5000000;
		String sEcho = request.getParameter("sEcho");
		String sCol = request.getParameter("iSortCol_0");
		String sdir = request.getParameter("sSortDir_0");
		
		String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) {
			start = sStart;
			if (start < 0)
				start = 0;
		}
 
		/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) {
			amount = sAmount;
			if (amount < 5 || amount > 100)
				amount = 5;
		}
 
		/* Counter of the request sent from Data table */
		if (sEcho != null) {
			echo = Integer.parseInt(sEcho);
		}
 
		/* Column number */
		if (sCol != null) {
			col = Integer.parseInt(sCol);
			if (col < 0 || col > 5)
				col = 0;
		}
 
		/* Sorting order */
		if (sdir != null) {
			if (!sdir.equals("asc"))
				dir = "desc";
		}
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		Integer premiseNo = userDetails.get(0).getNumPremisesNo();
		String applicantType = userDetails.get(0).getApplicantType();
		
		String searchTerm ="";
		
		String Query =null;
		
		System.out.println(userDetails.get(0).getNumInstId());
		
		if(applicantType.equals("104")) {
			Query = "select num_drug_id,str_manufacturing_unit, nvl(str_generic_name,'NA') str_generic_name, dava.manufacture_units_name( str_manufacturing_unit) manufacturingunit, nvl(dosagename( num_dosage_form),'NA') str_dosage_name,drug_typename(num_drug_type) str_type_name, nvl(str_brand_name,'NA') str_brand_name, nvl(schedulename(num_schedule_id),'NA') str_schedule_name, nvl(str_strength,'NA') str_strength, nvl(storagecondition (num_storage_condition),'NA') str_condition_name, nvl(str_composition,'NA') str_composition ,d.num_hs_code, nvl(str_commodity_name,'NA') str_commodity_name , nvl(d.num_hs_code || ' ' || str_commodity_name,'NA') hscode, case d.num_threpuetic_class when -1 THEN 'Other Class of Drug(if any)' else dava.drugclassname(d.num_threpuetic_class)  end as str_drug_class_name, nvl(str_gtin_no,'NA') str_gtin_no, str_drug_code, (SELECT str_premises_name||' - '||str_address  from institute_premises_dtl i WHERE i.num_premises_no= d.num_manu_unit_id) premisenameadd, str_primary_gtin, str_s1_gtin, str_s2_gtin, str_s3_gtin, str_tertiary_gtin from (drug_mst d   JOIN hscode_mst hs ON (hs.num_hscode = d.num_hs_code)) where d.num_isvalid = 1 and d.num_drug_type = 11 and d.num_inst_id=" + 
					instId+" and num_manu_unit_id ="+premiseNo+" or 0 ="+premiseNo;
		}else {
			Query = "select num_drug_id,str_manufacturing_unit, nvl(str_generic_name,'NA') str_generic_name, dava.manufacture_units_name( str_manufacturing_unit) manufacturingunit, nvl(dosagename( num_dosage_form),'NA') str_dosage_name,drug_typename(num_drug_type) str_type_name, nvl(str_brand_name,'NA') str_brand_name, nvl(schedulename(num_schedule_id),'NA') str_schedule_name, nvl(str_strength,'NA') str_strength, nvl(storagecondition (num_storage_condition),'NA') str_condition_name, nvl(str_composition,'NA') str_composition ,d.num_hs_code, nvl(str_commodity_name,'NA') str_commodity_name , nvl(d.num_hs_code || ' ' || str_commodity_name,'NA') hscode, case d.num_threpuetic_class when -1 THEN 'Other Class of Drug(if any)' else dava.drugclassname(d.num_threpuetic_class)  end as str_drug_class_name, nvl(str_gtin_no,'NA') str_gtin_no, str_drug_code, (SELECT str_premises_name||' - '||str_address  from institute_premises_dtl i WHERE i.num_premises_no= d.num_manu_unit_id) premisenameadd, str_primary_gtin, str_s1_gtin, str_s2_gtin, str_s3_gtin, str_tertiary_gtin from (drug_mst d   JOIN hscode_mst hs ON (hs.num_hscode = d.num_hs_code)) where d.num_isvalid = 1 and d.num_drug_type = 11 and d.num_inst_id=" + 
					instId;
		}
		
		
		
		String result = generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
		return result.toString();
	}
	
	public String ShowDrugDetailsBD(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int amount = 5; /* Amount in Show Entry drop down */
		int start = 0; /* Counter for Paging, initially 0 */
		int echo = 0; /* Maintains the request number, initially 0 */
		int col = 0; /* Column number in the datatable */
		/* Below variables store the options to create the Query */
		
		String dir = "asc";
		int sStart =  0;
		int sAmount =  5000000;
		String sEcho = request.getParameter("sEcho");
		String sCol = request.getParameter("iSortCol_0");
		String sdir = request.getParameter("sSortDir_0");
		
		String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) {
			start = sStart;
			if (start < 0)
				start = 0;
		}
 
		/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) {
			amount = sAmount;
			if (amount < 5 || amount > 100)
				amount = 5;
		}
 
		/* Counter of the request sent from Data table */
		if (sEcho != null) {
			echo = Integer.parseInt(sEcho);
		}
 
		/* Column number */
		if (sCol != null) {
			col = Integer.parseInt(sCol);
			if (col < 0 || col > 5)
				col = 0;
		}
 
		/* Sorting order */
		if (sdir != null) {
			if (!sdir.equals("asc"))
				dir = "desc";
		}
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		Integer premiseNo = userDetails.get(0).getNumPremisesNo();
		String applicantType = userDetails.get(0).getApplicantType();
		
		String searchTerm ="";
		String Query =null;
		if(applicantType.equals("104")) {
			Query = "select num_drug_id,str_manufacturing_unit, nvl(str_generic_name,'NA') str_generic_name, dava.manufacture_units_name( str_manufacturing_unit) manufacturingunit,nvl(drug_typename(num_drug_type),'NA') str_type_name, nvl(storagecondition (num_storage_condition),'NA') as str_condition_name,d.num_hs_code,d.num_hs_code || ' ' ||  (select str_commodity_name from hscode_mst hs where d.num_hs_code = hs.num_hscode) as hscode, nvl(str_gtin_no,'NA') str_gtin_no, str_drug_code, (SELECT str_premises_name||' - '||str_address  from institute_premises_dtl i WHERE i.num_premises_no= d.num_manu_unit_id) premisenameadd, (SELECT str_premises_name  from institute_premises_dtl i WHERE i.num_premises_no= d.num_manu_unit_id) premisename, str_primary_gtin, str_s1_gtin, str_s2_gtin, str_s3_gtin, str_tertiary_gtin,str_pack_size from drug_mst d where d.num_isvalid = 1 and d.num_drug_type = 12 and d.num_inst_id="+ instId+" and num_manu_unit_id ="+premiseNo;
		}else {
			System.out.println("hello" + instId);
			Query = "select num_drug_id,str_manufacturing_unit, nvl(str_generic_name,'NA') str_generic_name, dava.manufacture_units_name( str_manufacturing_unit) manufacturingunit,nvl(drug_typename(num_drug_type),'NA') str_type_name, nvl(storagecondition (num_storage_condition),'NA') as str_condition_name,d.num_hs_code,d.num_hs_code || ' ' ||  (select str_commodity_name from hscode_mst hs where d.num_hs_code = hs.num_hscode) as hscode, nvl(str_gtin_no,'NA') str_gtin_no, str_drug_code, (SELECT str_premises_name||' - '||str_address  from institute_premises_dtl i WHERE i.num_premises_no= d.num_manu_unit_id) premisenameadd, (SELECT str_premises_name  from institute_premises_dtl i WHERE i.num_premises_no= d.num_manu_unit_id) premisename, str_primary_gtin, str_s1_gtin, str_s2_gtin, str_s3_gtin, str_tertiary_gtin,str_pack_size from drug_mst d where d.num_isvalid = 1 and d.num_drug_type = 12 and d.num_inst_id="
					+ instId;
		}
		
		String result = generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
		return result.toString();
	}
	
	public String ShowAllDrugDetails(HttpServletRequest request, Long UserId) {
		// TODO Auto-generated method stub
		int amount = 5; /* Amount in Show Entry drop down */
		int start = 0; /* Counter for Paging, initially 0 */
		int echo = 0; /* Maintains the request number, initially 0 */
		int col = 0; /* Column number in the datatable */
		/* Below variables store the options to create the Query */
		
		String dir = "asc";
		int sStart =  0;
		int sAmount =  5000000;
		String sEcho = request.getParameter("sEcho");
		String sCol = request.getParameter("iSortCol_0");
		String sdir = request.getParameter("sSortDir_0");
		
		String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) {
			start = sStart;
			if (start < 0)
				start = 0;
		}
 
		/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) {
			amount = sAmount;
			if (amount < 5 || amount > 100)
				amount = 5;
		}
 
		/* Counter of the request sent from Data table */
		if (sEcho != null) {
			echo = Integer.parseInt(sEcho);
		}
 
		/* Column number */
		if (sCol != null) {
			col = Integer.parseInt(sCol);
			if (col < 0 || col > 5)
				col = 0;
		}
 
		/* Sorting order */
		if (sdir != null) {
			if (!sdir.equals("asc"))
				dir = "desc";
		}
		
		String searchTerm ="";
		
		String Query = "";
		if(UserId == 0) {
			Query = "select num_drug_id,str_manufacturing_unit, nvl(str_generic_name,'NA') str_generic_name, to_char(dt_tr_date,'dd-Mon-YYYY')dt_tr_date, dava.manufacture_units_name( str_manufacturing_unit) manufacturingunit, nvl(dosagename( num_dosage_form),'NA') as str_dosage_name, nvl(drug_typename(num_drug_type),'NA') str_type_name, nvl(str_brand_name,'NA') str_brand_name, nvl(schedulename(num_schedule_id),'NA') as str_schedule_name, nvl(str_strength,'NA') str_strength, nvl(storagecondition (num_storage_condition),'NA') as str_condition_name, nvl(str_composition,'NA') str_composition,d.num_hs_code,d.num_hs_code || ' ' ||  (select str_commodity_name from hscode_mst hs where d.num_hs_code = hs.num_hscode) as hscode, (SELECT str_premises_name||' - '||str_address  from institute_premises_dtl i WHERE i.num_premises_no= d.num_manu_unit_id) premisenameadd, nvl(str_gtin_no,'NA') str_gtin_no from drug_mst d where d.num_isvalid = 1";
		}else {
			List<RegistrationDetails> userDetails = davaDao.getRegistrationDetails(UserId);
			int instId = userDetails.get(0).getNumInstId();
			Query = "select num_drug_id,str_manufacturing_unit, nvl(str_generic_name,'NA') str_generic_name, to_char(dt_tr_date,'dd-Mon-YYYY')dt_tr_date, dava.manufacture_units_name( str_manufacturing_unit) manufacturingunit, nvl(dosagename( num_dosage_form),'NA') as str_dosage_name, nvl(drug_typename(num_drug_type),'NA') str_type_name, nvl(str_brand_name,'NA') str_brand_name, nvl(schedulename(num_schedule_id),'NA') as str_schedule_name, nvl(str_strength,'NA') str_strength, nvl(storagecondition (num_storage_condition),'NA') as str_condition_name, nvl(str_composition,'NA') str_composition,d.num_hs_code,d.num_hs_code || ' ' ||  (select str_commodity_name from hscode_mst hs where d.num_hs_code = hs.num_hscode) as hscode,(SELECT str_premises_name||' - '||str_address  from institute_premises_dtl i WHERE i.num_premises_no= d.num_manu_unit_id) premisenameadd, nvl(str_gtin_no,'NA') str_gtin_no from drug_mst d where d.num_isvalid = 1 and d.num_inst_id=" +  instId;
		}
		
		String result = generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
		return result.toString();
	}
	
	public DrugMst updateDrugDetails(DrugDtlsModel drugDtlsModel, HttpServletRequest request) {
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		DrugMst drugDom = new DrugMst();
		System.err.println("Man Unit   "+drugDtlsModel.getManuUnit());
		drugDom.setNumDrugId(drugDtlsModel.getDrugId());
		List<DrugMst> dm = davaTransactions.getProdCode(drugDtlsModel.getDrugId());
		drugDom.setDrugCode(dm.get(0).getDrugCode());
		drugDom.setNumInstId(instId);
		drugDom.setNumDrugType(drugDtlsModel.getDrugType());
		drugDom.setNumManuUnitId(drugDtlsModel.getManuUnit());
		/*
		 * List<String> manuUnits = drugDtlsModel.getListManufacturingUnit(); String str
		 * = null; if(manuUnits.size()>0){ str = manuUnits.get(0);
		 * System.err.println("str--"+str); for(int i=0;i<manuUnits.size()-1;i++){ str+=
		 * "," + manuUnits.get(i+1); System.err.println("str-"+str); }
		 * drugDom.setStrManufacturingUnit(str); } else{
		 * drugDom.setStrManufacturingUnit(""); }
		 */
		//drugDom.setStrGenericName(drugDtlsModel.getGenericName().trim());
		//drugDom.setStrBrandName(drugDtlsModel.getBrandName().trim());
		drugDom.setNumDosageForm(drugDtlsModel.getDosageForm());
		drugDom.setNumPharmacopialClassification(drugDtlsModel.getClassificationDrug());
		drugDom.setNumScheduleId(drugDtlsModel.getScheduleDrug());
		//drugDom.setStrStrength(drugDtlsModel.getStrength().trim());
		//drugDom.setStrStorageCondition(drugDtlsModel.getStorageCon());
		//drugDom.setStrComposition(drugDtlsModel.getComposition().trim());
		drugDom.setNumPackUnit(drugDtlsModel.getPackUnit());
		//drugDom.setStrPackSize(drugDtlsModel.getPackSize().trim());
		if(drugDtlsModel.getHsCode() != 0)
			drugDom.setNumHSCode(Long.valueOf(drugDtlsModel.getHsCode()));
		else
			drugDom.setNumHSCode(Long.valueOf(drugDtlsModel.getHsCodeFF()));
		
		if(drugDtlsModel.getNumStorageCondition() != 0)
			drugDom.setNumStorageCondition(drugDtlsModel.getNumStorageCondition());
		else
			drugDom.setNumStorageCondition(drugDtlsModel.getNumStorageConditionFF());
		
		drugDom.setNumThrepueticClass(drugDtlsModel.getTherapeuticClass());
		drugDom.setStrTherepueticClass(drugDtlsModel.getTherepueticClassOfDrug());
		//drugDom.setStrGtinNo(drugDtlsModel.getGtin().trim());
		//drugDom.setStrProductCode(getProdCode);
		drugDom.setDtTrDate(new Date());
		drugDom.setNumIsValid(1);
		drugDom.setNumTrUserId(1001);
		drugDom.setNumStatus(1);
		
		String genericName = drugDtlsModel.getGenericName();
		System.out.println("genericName : " + genericName);
		genericName = genericName.replaceAll(",$", "");
		System.out.println("genericName : " + genericName);
		
		drugDom.setStrGenericName(genericName.trim());
		
		String brandName = drugDtlsModel.getBrandName();
		brandName = brandName.replaceAll(",$", "");
		drugDom.setStrBrandName(brandName.trim());
		
		String strength = drugDtlsModel.getStrength();
		strength = strength.replaceAll(",$", "");
		drugDom.setStrStrength(strength.trim());
		
		String composition = drugDtlsModel.getComposition();
		composition = composition.replaceAll(",$", "");
		drugDom.setStrComposition(composition.trim());
		
		String gtin = drugDtlsModel.getGtin();
		gtin = gtin.replaceAll(",", "");
		drugDom.setStrGtinNo(gtin.trim());
		
		String packSIze = drugDtlsModel.getPackSize();
		packSIze = packSIze.replaceAll(",", "");
		drugDom.setStrPackSize(packSIze.trim());
		
		/*
		 * String primaryGTIN = drugDtlsModel.getpLevelGTIN(); primaryGTIN =
		 * primaryGTIN.replaceAll(",$", ""); System.out.println(primaryGTIN.charAt(0));
		 * if(primaryGTIN.charAt(0) == ',') primaryGTIN = primaryGTIN.substring(1);
		 * drugDom.setStrPrimaryGTIN(primaryGTIN.trim());
		 */
		
		
		
		String primaryGTIN = drugDtlsModel.getpLevelGTIN();
		if (primaryGTIN.charAt(0)== ',') {
			primaryGTIN = primaryGTIN.replaceAll(",", "");
		}
		else {
			primaryGTIN = primaryGTIN.replaceAll(",$", "");
		
			
			//System.out.println(primaryGTIN.charAt(0));
				if(primaryGTIN.charAt(0) == ',') {
					primaryGTIN = primaryGTIN.substring(1);
				}
			}
		drugDom.setStrPrimaryGTIN(primaryGTIN.trim());
		
		String s1GTIN = drugDtlsModel.getS1LevelGTIN();
		//s1GTIN = s1GTIN.replaceAll(",", "");
		//s1GTIN = s1GTIN.replaceAll(",$", "");
		if(s1GTIN != "") {
			if(s1GTIN.charAt(0) == ',')
				s1GTIN = s1GTIN.substring(1);
			drugDom.setStrS1GTIN(s1GTIN.trim());
		}
		
		String s2GTIN = drugDtlsModel.getS2LevelGTIN();
		//s2GTIN = s2GTIN.replaceAll(",", "");
		//s2GTIN = s2GTIN.replaceAll(",$", "");
		if(s2GTIN != "") {
			if(s2GTIN.charAt(0) == ',')
				s2GTIN = s2GTIN.substring(1);
			drugDom.setStrS2GTIN(s2GTIN.trim());
		}
		
		String s3GTIN = drugDtlsModel.getS3LevelGTIN();
		//s3GTIN = s3GTIN.replaceAll(",", "");
		//s3GTIN = s3GTIN.replaceAll(",$", "");
		if(s3GTIN != "") {
			if(s3GTIN.charAt(0) == ',')
				s3GTIN = s3GTIN.substring(1);
			drugDom.setStrS3GTIN(s3GTIN.trim());
		}
		
		String tertiaryGTIN = drugDtlsModel.getTertiryLevelGTIN();
		//tertiaryGTIN = tertiaryGTIN.replaceAll(",", "");
		//tertiaryGTIN = tertiaryGTIN.replaceAll(",$", "");
		if(tertiaryGTIN != "") {
			if(tertiaryGTIN.charAt(0) == ',')
				tertiaryGTIN = tertiaryGTIN.substring(1);
			drugDom.setStrTertiaryGTIN(tertiaryGTIN.trim());
		}
		
		//drugDom.setNumPackLevel(drugDtlsModel.getPackLevel());
		
		DrugMst drugMstDom = davaDaoServices.modifyDrugDetails(drugDom);
		return drugMstDom;
	}
	
	public DrugMst deleteDrugDetails(DrugDtlsModel drugDtlsModel, HttpServletRequest request) {
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		DrugMst drugDom = new DrugMst();
		drugDom.setNumDrugId(drugDtlsModel.getDrugId());
		drugDom.setNumInstId(instId);
		drugDom.setNumManuUnitId(drugDtlsModel.getManuUnit());
		/*
		 * List<String> manuUnits = drugDtlsModel.getListManufacturingUnit(); String str
		 * = null; if(manuUnits.size()>0){ str = manuUnits.get(0);
		 * System.err.println("str--"+str); for(int i=0;i<manuUnits.size()-1;i++){ str+=
		 * "," + manuUnits.get(i+1); System.err.println("str-"+str); }
		 * drugDom.setStrManufacturingUnit(str); } else{
		 * drugDom.setStrManufacturingUnit(""); }
		 */
		drugDom.setNumDrugType(drugDtlsModel.getDrugType());
		drugDom.setNumManuUnitId(drugDtlsModel.getManuUnit());
		drugDom.setStrGenericName(drugDtlsModel.getGenericName().trim());
		drugDom.setStrBrandName(drugDtlsModel.getBrandName().trim());
		drugDom.setNumDosageForm(drugDtlsModel.getDosageForm());
		drugDom.setNumPharmacopialClassification(drugDtlsModel.getClassificationDrug());
		drugDom.setNumScheduleId(drugDtlsModel.getScheduleDrug());
		drugDom.setStrStrength(drugDtlsModel.getStrength().trim());
		//drugDom.setStrStorageCondition(drugDtlsModel.getStorageCon());
		drugDom.setStrComposition(drugDtlsModel.getComposition().trim());
		drugDom.setNumPackUnit(drugDtlsModel.getPackUnit());
		//drugDom.setStrPackSize(drugDtlsModel.getPackSize());
		drugDom.setNumThrepueticClass(drugDtlsModel.getTherapeuticClass());
		drugDom.setStrGtinNo(drugDtlsModel.getGtin().trim());
		if(drugDtlsModel.getHsCode() != 0)
			drugDom.setNumHSCode(Long.valueOf(drugDtlsModel.getHsCode()));
		else
			drugDom.setNumHSCode(Long.valueOf(drugDtlsModel.getHsCodeFF()));
		
		if(drugDtlsModel.getNumStorageCondition() != 0)
			drugDom.setNumStorageCondition(drugDtlsModel.getNumStorageCondition());
		else
			drugDom.setNumStorageCondition(drugDtlsModel.getNumStorageConditionFF());
		
		String packSIze = drugDtlsModel.getPackSize();
		//packSIze = packSIze.replaceAll(",", "");
		drugDom.setStrPackSize(packSIze.trim());
		
		drugDom.setStrPrimaryGTIN(drugDtlsModel.getpLevelGTIN());
		
		drugDom.setStrS1GTIN(drugDtlsModel.getS1LevelGTIN());
		
		drugDom.setStrS2GTIN(drugDtlsModel.getS2LevelGTIN());
		
		drugDom.setStrS3GTIN(drugDtlsModel.getS3LevelGTIN());
		
		drugDom.setStrTertiaryGTIN(drugDtlsModel.getTertiryLevelGTIN());
		//drugDom.setNumPackLevel(drugDtlsModel.getPackLevel());
		drugDom.setDtTrDate(new Date());
		drugDom.setNumIsValid(0);
		drugDom.setNumTrUserId(1001);
		drugDom.setNumStatus(0);
		DrugMst drugMstDom = davaDaoServices.deleteDrugDetails(drugDom);
		return drugMstDom;
	}
	
	public String getMemberSiteDtlXML(Integer premisesNo) {
		String str= davaDaoServices.generateReportSiteDtlXML(premisesNo);
		 
		 System.out.println("str in impl:::::::"+str);
		 return str;
	}
	
	public RegistrationDetails findByUserName(String loogedInUserId) {
		RegistrationDetails registrationDetails=userRepository.findByUserName(loogedInUserId);
		return registrationDetails;
	}

	public List<OfficialForm> getMenu(int roleId) throws SQLException {
		return davaDaoServices.getMenu(roleId);
	}

	public List<SeatMaster> getSeatMstData(Integer numSeatId) {

		return davaDaoServices.getSeatMstData(numSeatId);
	}

	public String updateSeatMaster(long userId) {
		
		return davaDaoServices.AddSeatMaster(userId);
	}
	
	public String totalRecall(Integer upId, Long UserId) {

		return davaTransactions.totalRecall(upId,UserId);
		
		
	}

	public List<TileDomain> getTile(Integer numRoleId) {
		return davaDaoServices.getTile(numRoleId);
	}
	
	public List<InstPremiseDtlDomain> getPremiseAddress(Integer manufactureId) {
		List<InstPremiseDtlDomain> premiseDtls=davaDaoServices.getPremiseAddress(manufactureId);
		return premiseDtls;
	}

	
	public RegistrationDetails saveManufUser(RegistrationForm registrationForm, String verificationLink) {
		
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		//RegistrationDetails reg=findByUserName(loogedInUserId);
		//long userId = Long.parseLong(loogedInUserId);
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		List<InstPremiseDtlDomain> instPreDtls = davaDao.getInstPremisesDtlsById(registrationForm.getManuUnit());
		
		registrationForm.setPassword(bCryptPasswordEncoder.encode(registrationForm.getPassword()));
		RegistrationDetails registrationDetails=new RegistrationDetails();
		registrationDetails.setUserName(registrationForm.getUserName().toLowerCase());
		registrationDetails.setContactPersonName(registrationForm.getContactPersonName());
		registrationDetails.setContactPerDesg(registrationForm.getContactPerDesg());
		registrationDetails.setContPerMobileNo(registrationForm.getContPerMobileNo());
		registrationDetails.setPassword(registrationForm.getPassword());
		registrationDetails.setManfSiteName(instPreDtls.get(0).getPremiseName());
		registrationDetails.setManfCountryId(instPreDtls.get(0).getNumCountryId());
		registrationDetails.setManfDistId(instPreDtls.get(0).getNumDistrictId());
		registrationDetails.setManfSiteAddress(instPreDtls.get(0).getStrAddress());
		registrationDetails.setManfSiteCity(instPreDtls.get(0).getStrCity());
		registrationDetails.setManfSiteContactNumber(instPreDtls.get(0).getContPerMobileNo());
		registrationDetails.setManfSiteFaxNumber(instPreDtls.get(0).getFaxNumber());
		registrationDetails.setManfSitePincode(instPreDtls.get(0).getNumPincode());
		registrationDetails.setManfStateId(instPreDtls.get(0).getNumStateId());
		registrationDetails.setNumPremisesNo(registrationForm.getManuUnit());
		registrationDetails.setVerificationLink(verificationLink);
		registrationDetails.setNumIsValied(0);
		registrationDetails.setNumEmailStatus(1);
		//registrationDetails.setNumEmailStatus(0);
		registrationDetails.setRandomNumber(0);
		registrationDetails.setNumApprovalStatusPharmaexil(1);
		registrationDetails.setDtTrDate(new Date());
		registrationDetails.setNumTrUserId(userDetails.get(0).getUserId().intValue());
		//registrationDetails.setRandomNumber(registrationForm.getRandomCode());
		
		
		 String str1 = Integer.toString(100); 
		
		if(userDetails.get(0).getApplicantType().equals(str1)) {
			
			registrationDetails.setApplicantType(104+"");
			//registrationForm.setNumInstId(userDetails.get(0).getNumInstId());
			/*
			 * 
			 * registrationDetails.setNumSeatId(userDetails.get(0).getNumSeatId());
			 */
			registrationDetails.setOrgAddress(userDetails.get(0).getOrgAddress());
			registrationDetails.setOrgContactNumber(userDetails.get(0).getOrgContactNumber());
			registrationDetails.setOrgCountryId(userDetails.get(0).getOrgCountryId());
			registrationDetails.setOrgDistId(userDetails.get(0).getOrgDistId());
			registrationDetails.setOrgEmailId(userDetails.get(0).getOrgEmailId());
			registrationDetails.setOrgFaxNumber(userDetails.get(0).getOrgFaxNumber());
			registrationDetails.setOrgName(userDetails.get(0).getOrgName());
			registrationDetails.setOrgPanNumber(userDetails.get(0).getOrgPanNumber());
			registrationDetails.setOrgPincode(userDetails.get(0).getOrgPincode());
			registrationDetails.setOrgStateId(userDetails.get(0).getOrgStateId());
			registrationDetails.setOrgType(userDetails.get(0).getOrgType());
			registrationDetails.setOrgWebsite(userDetails.get(0).getOrgWebsite());
			registrationDetails.setNumInstId(userDetails.get(0).getNumInstId());
			//updateSeatMaster(userDetails.get(0).getUserId());
		}
		
		RegistrationDetails getUserNameDetails=userRepository.findByUserName(registrationDetails.getUserName());
		if(getUserNameDetails!=null)
			return null;
		
		RegistrationDetails registrationDomain=davaDaoServices.saveUser(registrationDetails);
		return registrationDomain;
	}
	
	public RegistrationDetails saveOffReg(OffRegModel registrationForm) {
		System.err.println("password--- "+registrationForm.getPassword());
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		//RegistrationDetails reg=findByUserName(loogedInUserId);
		//long userId = Long.parseLong(loogedInUserId);
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		// List<InstPremiseDtlDomain> instPreDtls =
		// davaDao.getInstPremisesDtlsById(registrationForm.getManuUnit());
		
		registrationForm.setPassword(bCryptPasswordEncoder.encode(registrationForm.getPassword()));
		RegistrationDetails registrationDetails=new RegistrationDetails();
		registrationDetails.setUserName(registrationForm.getUserName().toLowerCase());
		registrationDetails.setContactPersonName(registrationForm.getStrName());
		registrationDetails.setContactPerDesg(registrationForm.getEmpDesg());
		registrationDetails.setContPerMobileNo(registrationForm.getEmpMobileNo());
		registrationDetails.setPassword(registrationForm.getPassword());
		registrationDetails.setNumIsValied(0);
		registrationDetails.setNumEmailStatus(0);
		registrationDetails.setNumApprovalStatusPharmaexil(1);
		registrationDetails.setRandomNumber(registrationForm.getRandomCode());
		registrationDetails.setApplicantType(registrationForm.getUserType()+"");
		registrationDetails.setContPersEmail(registrationForm.getEmpEmailId());
		registrationDetails.setNumInstId(101);
		registrationDetails.setVerificationLink("");
		registrationDetails.setDtTrDate(new Date());
		//Employee number and Gender not saved yet
		RegistrationDetails getUserNameDetails=userRepository.findByUserName(registrationDetails.getUserName());
		if(getUserNameDetails!=null)
			return null;
		
		
		RegistrationDetails registrationDomain=davaDaoServices.saveUser(registrationDetails);
		return registrationDomain;
	}

	public String showManufSiteUserList(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int amount = 5; /* Amount in Show Entry drop down */
		int start = 0; /* Counter for Paging, initially 0 */
		int echo = 0; /* Maintains the request number, initially 0 */
		int col = 0; /* Column number in the datatable */
		/* Below variables store the options to create the Query */
		
		String dir = "asc";
		int sStart =  0;
		int sAmount =  5000000;
		String sEcho = request.getParameter("sEcho");
		String sCol = request.getParameter("iSortCol_0");
		String sdir = request.getParameter("sSortDir_0");
		
		String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) {
			start = sStart;
			if (start < 0)
				start = 0;
		}
 
		/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) {
			amount = sAmount;
			if (amount < 5 || amount > 100)
				amount = 5;
		}
 
		/* Counter of the request sent from Data table */
		if (sEcho != null) {
			echo = Integer.parseInt(sEcho);
		}
 
		/* Column number */
		if (sCol != null) {
			col = Integer.parseInt(sCol);
			if (col < 0 || col > 5)
				col = 0;
		}
 
		/* Sorting order */
		if (sdir != null) {
			if (!sdir.equals("asc"))
				dir = "desc";
		}
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		String searchTerm ="";
		
		String Query = "select user_name,contact_person_name,contact_per_desg,cont_per_mobile_no,num_premises_no, user_id ,(SELECT str_premises_name||' , '||str_address  from institute_premises_dtl i WHERE i.num_premises_no= u.num_premises_no) premisesname from user_registration u where applicant_type=104 and num_isvalid=1 and num_inst_id="
				+ instId;
		String result = generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
		return result.toString();
	}
	
	public String ShowManufacturingSiteListing(HttpServletRequest request) {
		// TODO Auto-generated method stub
				int amount = 5; /* Amount in Show Entry drop down */
				int start = 0; /* Counter for Paging, initially 0 */
				int echo = 0; /* Maintains the request number, initially 0 */
				int col = 0; /* Column number in the datatable */
				/* Below variables store the options to create the Query */
				
				String dir = "asc";
				int sStart =  0;
				int sAmount =  5000000;
				String sEcho = request.getParameter("sEcho");
				String sCol = request.getParameter("iSortCol_0");
				String sdir = request.getParameter("sSortDir_0");
				
				String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) {
					start = sStart;
					if (start < 0)
						start = 0;
				}
		 
				/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) {
					amount = sAmount;
					if (amount < 5 || amount > 100)
						amount = 5;
				}
		 
				/* Counter of the request sent from Data table */
		if (sEcho != null) {
					echo = Integer.parseInt(sEcho);
				}
		 
				/* Column number */
		if (sCol != null) {
					col = Integer.parseInt(sCol);
					if (col < 0 || col > 5)
						col = 0;
				}
		 
				/* Sorting order */
		if (sdir != null) {
					if (!sdir.equals("asc"))
						dir = "desc";
				}
				String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
				List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
				String applicantType = userDetails.get(0).getApplicantType();
				int instId = userDetails.get(0).getNumInstId();
				Long numUserId = userDetails.get(0).getUserId();
				
				String searchTerm ="";
				String Query = null;
				if(applicantType.equals("104")) {
					Query = "select i.num_premises_no, case num_sitetype_id when 1 then 'Own Site' when 2 then 'Loan Site' else 'Whole-Sale Site' end as sitetype, str_premises_name, (str_address||' ,'||statename(i.num_state_id::int4) ||' ,'||districtname(i.num_district_id::int4) ||'-'||num_pincode) as address, str_contact_details, str_fax_details, str_email, str_gstin_no, str_gs1_no, num_cont_mobile_no, str_cont_email, str_cont_desg, str_cont_name, str_premise_code , str_gln_no from institute_premises_dtl i ,  user_registration ur  where i.num_inst_id = ur.num_inst_id and  i.num_isvalid = 1 and i.num_inst_id="+ instId+" and ur.user_id="+numUserId+" and ( nvl(ur.num_premises_no,0) =0 or i.num_premises_no = ur.num_premises_no ) ORDER BY num_premises_no desc";
				}else {
					Query = "select num_premises_no, case num_sitetype_id when 1 then 'Own Site' when 2 then 'Loan Site' else 'Whole-Sale Site' end as sitetype, str_premises_name, (str_address||' ,'||s.str_state_name||' ,'||str_district_name||'-'||num_pincode) as address, str_contact_details, str_fax_details, str_email, str_gstin_no, str_gs1_no, num_cont_mobile_no, str_cont_email, str_cont_desg, str_cont_name, str_premise_code , str_gln_no from ((institute_premises_dtl i JOIN states_mst s on(i.num_state_id = s.num_state_id)) JOIN district_mst d on (i.num_district_id = d.num_district_id)) where i.num_isvalid = 1 and i.num_inst_id="+ instId+" ORDER BY num_premises_no desc";
				}
				System.out.println("in data table code" + instId);

				String result = generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
				return result.toString();
	}
	
	
	public String showEmailData(HttpServletRequest request) {
		// TODO Auto-generated method stub
				int amount = 5; /* Amount in Show Entry drop down */
				int start = 0; /* Counter for Paging, initially 0 */
				int echo = 0; /* Maintains the request number, initially 0 */
				int col = 0; /* Column number in the datatable */
				/* Below variables store the options to create the Query */
				
				String dir = "asc";
				int sStart =  0;
				int sAmount =  5000000;
				String sEcho = request.getParameter("sEcho");
				String sCol = request.getParameter("iSortCol_0");
				String sdir = request.getParameter("sSortDir_0");
				
				String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) {
					start = sStart;
					if (start < 0)
						start = 0;
				}
		 
				/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) {
					amount = sAmount;
					if (amount < 5 || amount > 100)
						amount = 5;
				}
		 
				/* Counter of the request sent from Data table */
		if (sEcho != null) {
					echo = Integer.parseInt(sEcho);
				}
		 
				/* Column number */
		if (sCol != null) {
					col = Integer.parseInt(sCol);
					if (col < 0 || col > 5)
						col = 0;
				}
		 
				/* Sorting order */
		if (sdir != null) {
					if (!sdir.equals("asc"))
						dir = "desc";
				}
				String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
				List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
				Long userId = userDetails.get(0).getUserId();
				int instId = userDetails.get(0).getNumInstId();
				System.out.println(userDetails.get(0).getRoleId());
				
				String searchTerm ="";
		// select m.str_mail_type_name, s.str_sendto, s.str_subject, s.str_body from
		// mail_type_mst m , send_mail_dtl s where m.num_mail_type_id=s.num_mailtype_id
		// and m.num_isvalid = 1 and s.num_isvalid = 1 and s.num_sendto = 1187
				String Query = null;
				if(userDetails.get(0).getRoleId().equals("200"))
					Query = "select m.str_mail_type_name, s.str_sendto, s.str_subject, s.str_body from mail_type_mst m , send_mail_dtl s where m.num_mail_type_id=s.num_mailtype_id and m.num_isvalid = 1 and s.num_isvalid = 1 ";
				else
					Query = "select m.str_mail_type_name, s.str_sendto, s.str_subject, s.str_body from mail_type_mst m , send_mail_dtl s where m.num_mail_type_id=s.num_mailtype_id and m.num_isvalid = 1 and s.num_isvalid = 1 and s.num_sendto ="+ userId;
				String result = generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
				return result.toString();
	}


	public String showAddedMemberList(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int amount = 5; /* Amount in Show Entry drop down */
		int start = 0; /* Counter for Paging, initially 0 */
		int echo = 0; /* Maintains the request number, initially 0 */
		int col = 0; /* Column number in the datatable */
		/* Below variables store the options to create the Query */
		
		String dir = "asc";
		int sStart =  0;
		int sAmount =  5000000;
		String sEcho = request.getParameter("sEcho");
		String sCol = request.getParameter("iSortCol_0");
		String sdir = request.getParameter("sSortDir_0");
		
		String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) 
		{
			start = sStart;
			if (start < 0)
				start = 0;
		}
 
		/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) {
			amount = sAmount;
			if (amount < 5 || amount > 100)
				amount = 5;
		}
 
		/* Counter of the request sent from Data table */
		if (sEcho != null) {
			echo = Integer.parseInt(sEcho);
		}
 
		/* Column number */
		if (sCol != null) {
			col = Integer.parseInt(sCol);
			if (col < 0 || col > 5)
				col = 0;
		}
 
		/* Sorting order */
		if (sdir != null) {
			if (!sdir.equals("asc"))
				dir = "desc";
		}
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		String searchTerm ="";
		
		String Query = "select num_memb_id,str_fax_no,case str_member_gender when 1 then 'Male' else 'Female' end as gender, num_inst_id,num_member_type,str_member_name,str_member_desig,to_char(dt_of_joining,'yyyy-MM-dd')joiningdate ,str_email,case num_idproff_type_id  when 1 then 'Aadhar Card' WHEN 2 then 'PAN Card' when 3 THEN 'PassPort'  else 'NA' END as idprooftype,str_idcard_no, num_document_id,str_contact_no,num_status,(SELECT str_type_name FROM member_type_mst m where m.num_type_id = i.num_member_type) membertype from institute_member_dtl i where num_isvalid=1 and num_inst_id="
				+ instId;
		String result = generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
		return result.toString();
	}

	public InstituteMemberDetailDomain deleteMemberDetails(MemberDetailForm memDtlForm) {
		
		return davaDaoServices.deleteMemberDetails(memDtlForm);
	}

	public RegistrationDetails deleteManufUserDetail(RegistrationForm registrationForm) {
		Long userId = registrationForm.getUserManuId();
		System.out.println("userId : " + userId);
		return davaDaoServices.deleteManufUserDetail(userId);
	}
 //added by harshita on 13-02-2024
	
	public InstPremiseDtlDomain deletemanusite(MemberAddDtlModel MemberAddDtlModel) {
		int premiseno = MemberAddDtlModel.getPremiseno();
		System.out.println("premiseno : " + premiseno);
		return davaDaoServices.deletemanusitedetail(premiseno);
	}

								  
 
																				  
												   
												 
														 
  

	public List<InstituteMemberDetailDomain> getAddedMemberData(int memberId) {
		// TODO Auto-generated method stub
		return davaDaoServices.getAddedMemberData(memberId);
	}

	public InstituteMemberDetailDomain updateMemberDetails(MemberDetailForm memDtlForm, HttpServletRequest request) {
		InstituteMemberDetailDomain instMemDtlDomain = new InstituteMemberDetailDomain();
		InstituteMemberDetailDomain memdtl = null;
		SimpleDateFormat inputFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		System.err.println("memDtlForm.getDateOfJoining()------ "+memDtlForm.getDateOfJoining());
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		Date dtAppFromdate = null;
		try {
			dtAppFromdate = inputFormat2.parse(memDtlForm.getDateOfJoining());
		}catch(ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Date----   "+memDtlForm.getDateOfJoining()+"  Parse Date-------  "+dtAppFromdate);
		System.err.println("Integer.parseInt(memDtlForm.getStrDocId())---------  "+memDtlForm.getStrDocId());
		instMemDtlDomain.setNumMemberType(memDtlForm.getNumMemberType());
		instMemDtlDomain.setStrMemberName(memDtlForm.getStrMemberName());
		instMemDtlDomain.setStrEmail(memDtlForm.getStrEmail());
		instMemDtlDomain.setStrMemberGender(memDtlForm.getNumGender()+"");
		instMemDtlDomain.setStrMemberDesig(memDtlForm.getStrDesignation());
		instMemDtlDomain.setDtOfJoining(dtAppFromdate);
		
		instMemDtlDomain.setNumIdProofTypeid(memDtlForm.getIdProofTypeId());
		instMemDtlDomain.setStrIdCardNo(memDtlForm.getStrCardNumber());
		instMemDtlDomain.setNumIsValid(1);
		instMemDtlDomain.setDtTrDate(new Date());
		instMemDtlDomain.setStrContactNo(memDtlForm.getNumContactNo());
		instMemDtlDomain.setNumApplTypeId(0);
		instMemDtlDomain.setNumDocumentId(memDtlForm.getStrDocId());
		instMemDtlDomain.setStrFaxNo(memDtlForm.getNumFaxNo());
		instMemDtlDomain.setNumMemberId(memDtlForm.getNumMemberId());
		instMemDtlDomain.setNumInstId(instId);
		memdtl = davaDaoServices.updateMemberDetails(instMemDtlDomain);
		return memdtl;
	}
	
	public RegistrationDetails updateManufUserDetail(RegistrationForm registrationForm, HttpServletRequest request) {
		System.err.println("password--- " + registrationForm.getPassword());
		String loogedInUserId = SecurityContextHolder.getContext().getAuthentication().getName();	
		
		Long userId = registrationForm.getUserManuId();
		System.out.println("userId : " + userId);
		Integer premiseNo = null;
		String password = null;
		String userName = null;
		Integer randomNo = null;
		List<RegistrationDetails> rs = davaTransactions.getUserDetailfromUserId(userId);
		int i;
		  for(i =0; i<rs.size();i++) 
		  { 
			 premiseNo = rs.get(i).getNumPremisesNo();
			 password = rs.get(i).getPassword();
			 userName = rs.get(i).getUserName();
			 randomNo = rs.get(i).getRandomNumber();
			 System.out.println("premiseNo rs : " + premiseNo); 
			 System.out.println("password rs : " + password);
			 System.out.println("userName rs : " + userName);
			 System.out.println("randomNo rs : " + randomNo);
		  }
		 										
		  System.err.println("person name : " + registrationForm.getContactPersonName());
		  System.err.println("person desg : " + registrationForm.getContactPerDesg());
		  System.err.println("person mob no : " + registrationForm.getContPerMobileNo());
		 
		  	//List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
			List<InstPremiseDtlDomain> instPreDtls = davaDao.getInstPremisesDtlsById(premiseNo);

			//registrationForm.setPassword(bCryptPasswordEncoder.encode(registrationForm.getPassword()));
			RegistrationDetails registrationDetails = new RegistrationDetails();
			//registrationDetails.setUserName(registrationForm.getUserName());
			registrationDetails.setUserId(userId);
			registrationDetails.setUserName(userName);
			registrationDetails.setContactPersonName(registrationForm.getContactPersonName());
			registrationDetails.setContactPerDesg(registrationForm.getContactPerDesg());
			registrationDetails.setContPerMobileNo(registrationForm.getContPerMobileNo());
			//registrationDetails.setPassword(registrationForm.getPassword());
			registrationDetails.setPassword(password);
			registrationDetails.setManfSiteName(instPreDtls.get(0).getPremiseName());
			registrationDetails.setManfCountryId(instPreDtls.get(0).getNumCountryId());
			registrationDetails.setManfDistId(instPreDtls.get(0).getNumDistrictId());
			registrationDetails.setManfSiteAddress(instPreDtls.get(0).getStrAddress());
			registrationDetails.setManfSiteCity(instPreDtls.get(0).getStrCity());
			registrationDetails.setManfSiteContactNumber(instPreDtls.get(0).getContPerMobileNo());
			registrationDetails.setManfSiteFaxNumber(instPreDtls.get(0).getFaxNumber());
			registrationDetails.setManfSitePincode(instPreDtls.get(0).getNumPincode());
			registrationDetails.setManfStateId(instPreDtls.get(0).getNumStateId());
			//registrationDetails.setNumPremisesNo(registrationForm.getManuUnit());
			registrationDetails.setNumPremisesNo(premiseNo);
			registrationDetails.setNumIsValied(rs.get(0).getNumIsValied());
			registrationDetails.setNumEmailStatus(rs.get(0).getNumEmailStatus());			
			registrationDetails.setNumApprovalStatusPharmaexil(rs.get(0).getNumApprovalStatusPharmaexil());
			registrationDetails.setRandomNumber(rs.get(0).getRandomNumber());
			registrationDetails.setDtTrDate(new Date());
			registrationDetails.setNumTrUserId(rs.get(0).getNumTrUserId());
			registrationDetails.setVerificationLink(rs.get(0).getVerificationLink());
		/*
		 * System.err.println("user detail ------   " +
		 * userDetails.get(0).getApplicantType());
		 * 
		 * String str1 = Integer.toString(100);
		 * 
		 * if (userDetails.get(0).getApplicantType().equals(str1)) {
		 * System.err.println("in 100--------------");
		 */
				registrationDetails.setApplicantType(104 + "");
				//registrationForm.setNumInstId(rs.get(i).getNum);
				registrationDetails.setOrgAddress(rs.get(0).getOrgAddress());
				registrationDetails.setOrgContactNumber(rs.get(0).getOrgContactNumber());
				registrationDetails.setOrgCountryId(rs.get(0).getOrgCountryId());
				registrationDetails.setOrgDistId(rs.get(0).getOrgDistId());
				registrationDetails.setOrgEmailId(rs.get(0).getOrgEmailId());
				registrationDetails.setOrgFaxNumber(rs.get(0).getOrgFaxNumber());
				registrationDetails.setOrgName(rs.get(0).getOrgName());
				registrationDetails.setOrgPanNumber(rs.get(0).getOrgPanNumber());
				registrationDetails.setOrgPincode(rs.get(0).getOrgPincode());
				registrationDetails.setOrgStateId(rs.get(0).getOrgStateId());
				registrationDetails.setOrgType(rs.get(0).getOrgType());
				registrationDetails.setOrgWebsite(rs.get(0).getOrgWebsite());
				registrationDetails.setNumInstId(rs.get(0).getNumInstId());
			
			RegistrationDetails registrationDomain = davaDaoServices.updateManfUserDetail(registrationDetails);
			return registrationDomain;

		
	}

	public String createJSONManufacturingSiteDetail(Integer numPremiseNo) {
		return davaDaoServices.createJSONManufacturingSiteDtls(numPremiseNo);
	}
	
	public List<InstPremiseDtlDomain> getAllPremiseDtls(Integer numPremiseNo) {
		List<InstPremiseDtlDomain> premiseDtls=davaDaoServices.getInstPremiseDtls(numPremiseNo);
		return premiseDtls;
	}
	
	
	public String getManuName(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int amount = 5; /* Amount in Show Entry drop down */
		int start = 0; /* Counter for Paging, initially 0 */
		int echo = 0; /* Maintains the request number, initially 0 */
		int col = 0; /* Column number in the datatable */
		/* Below variables store the options to create the Query */

		String dir = "asc";
		int sStart = 0;
		int sAmount = 5000000;
		String sEcho = request.getParameter("sEcho");
		String sCol = request.getParameter("iSortCol_0");
		String sdir = request.getParameter("sSortDir_0");

		String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) {
			start = sStart;
			if (start < 0)
				start = 0;
		}

		/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) {
			amount = sAmount;
			if (amount < 5 || amount > 100)
				amount = 5;
		}

		/* Counter of the request sent from Data table */
		if (sEcho != null) {
			echo = Integer.parseInt(sEcho);
		}

		/* Column number */
		if (sCol != null) {
			col = Integer.parseInt(sCol);
			if (col < 0 || col > 5)
				col = 0;
		}

		/* Sorting order */
		if (sdir != null) {
			if (!sdir.equals("asc"))
				dir = "desc";
		}
		String loogedInUserId = SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		String searchTerm = "";

		String Query = "select ipd.num_premises_no from ((institute_premises_dtl ipd JOIN user_registration usr on (usr.manf_site_name = ipd.str_premises_name)) where where ur.num_isvalid=0 and usr.user_id = 1254;";
		String result = generateJSONObject("find_val", searchTerm, Query, sAmount, sStart);
		System.out.println("result : " + result.toString());
		return result.toString();
	}
	
	
	public String ShowRegistrationPendingListing(HttpServletRequest request) {
		// TODO Auto-generated method stub
				int amount = 5; /* Amount in Show Entry drop down */
				int start = 0; /* Counter for Paging, initially 0 */
				int echo = 0; /* Maintains the request number, initially 0 */
				int col = 0; /* Column number in the datatable */
				/* Below variables store the options to create the Query */
				
				String dir = "asc";
				int sStart =  0;
				int sAmount =  5000000;
				String sEcho = request.getParameter("sEcho");
				String sCol = request.getParameter("iSortCol_0");
				String sdir = request.getParameter("sSortDir_0");
				
				String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) {
					start = sStart;
					if (start < 0)
						start = 0;
				}
		 
				/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) {
					amount = sAmount;
					if (amount < 5 || amount > 100)
						amount = 5;
				}
		 
				/* Counter of the request sent from Data table */
		if (sEcho != null) {
					echo = Integer.parseInt(sEcho);
				}
		 
				/* Column number */
		if (sCol != null) {
					col = Integer.parseInt(sCol);
					if (col < 0 || col > 5)
						col = 0;
				}
		 
				/* Sorting order */
		if (sdir != null) {
					if (!sdir.equals("asc"))
						dir = "desc";
				}
				String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
				
				String searchTerm ="";
				
			if (projectUrl.contains("localhost")) {
					

					System.out.println("if yopmail ");
				
				//String Query="select user_id, user_name, applicant_type, str_appl_type_name, cont_pers_email, contact_per_desg, to_char(created_date,'dd-Mon-YYYY')createddate , org_address, org_contact_number, case org_country_id when 193 then 'India' else 'NA' end as country, org_dist_id, str_district_name, address_proof_id, drug_license_id, org_email_id, org_fax_number, org_name, org_pan_number, org_pincode, org_state_id, s.str_state_name, org_type, org_website, str_rcmc_no, ur.num_email_status from (((user_registration ur JOIN applicant_type_mst a on(ur.applicant_type=a.num_appl_type_id)) JOIN states_mst s on(ur.org_state_id = s.num_state_id)) JOIN district_mst d on (ur.org_dist_id = d.num_district_id)) where ur.num_isvalid=0 and ur.num_approval_status_pharmaexil=0 AND user_name NOT LIKE '%yopmail%' ORDER BY created_date DESC";
				String Query="select user_id, user_name, applicant_type, str_appl_type_name, cont_pers_email, contact_per_desg, to_char(created_date,'dd-Mon-YYYY')createddate , org_address, org_contact_number, case org_country_id when 193 then 'India' else 'NA' end as country, org_dist_id, str_district_name, address_proof_id, drug_license_id, org_email_id, org_fax_number, org_name, org_pan_number, org_pincode, org_state_id, s.str_state_name, org_type, org_website, str_rcmc_no, ur.num_email_status from (((user_registration ur JOIN applicant_type_mst a on(ur.applicant_type=a.num_appl_type_id)) JOIN states_mst s on(ur.org_state_id = s.num_state_id)) JOIN district_mst d on (ur.org_dist_id = d.num_district_id)) where ur.num_isvalid=0 and ur.num_approval_status_pharmaexil=0 ORDER BY created_date DESC";
				String result = generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
				return result.toString();
				}
				
				else {
					System.out.println("notyopmail ");
			String Query="select user_id, user_name, applicant_type, str_appl_type_name, cont_pers_email, contact_per_desg, to_char(created_date,'dd-Mon-YYYY')createddate , org_address, org_contact_number, case org_country_id when 193 then 'India' else 'NA' end as country, org_dist_id, str_district_name, address_proof_id, drug_license_id, org_email_id, org_fax_number, org_name, org_pan_number, org_pincode, org_state_id, s.str_state_name, org_type, org_website, str_rcmc_no, ur.num_email_status from (((user_registration ur JOIN applicant_type_mst a on(ur.applicant_type=a.num_appl_type_id)) JOIN states_mst s on(ur.org_state_id = s.num_state_id)) JOIN district_mst d on (ur.org_dist_id = d.num_district_id)) where ur.num_isvalid=0 and ur.num_approval_status_pharmaexil=0 AND user_name NOT LIKE '%yopmail%' ORDER BY created_date DESC";
			String result = generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
				
			return result.toString();
			}
				
	
	}
	
	public String ShowApprovedRegistrationListing(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int amount = 5; /* Amount in Show Entry drop down */
		int start = 0; /* Counter for Paging, initially 0 */
		int echo = 0; /* Maintains the request number, initially 0 */
		int col = 0; /* Column number in the datatable */
		/* Below variables store the options to create the Query */
		
		String dir = "asc";
		int sStart =  0;
		int sAmount =  5000000;
		String sEcho = request.getParameter("sEcho");
		String sCol = request.getParameter("iSortCol_0");
		String sdir = request.getParameter("sSortDir_0");
		
		String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) {
			start = sStart;
			if (start < 0)
				start = 0;
		}
 
		/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) {
			amount = sAmount;
			if (amount < 5 || amount > 100)
				amount = 5;
		}
 
		/* Counter of the request sent from Data table */
		if (sEcho != null) {
			echo = Integer.parseInt(sEcho);
		}
 
		/* Column number */
		if (sCol != null) {
			col = Integer.parseInt(sCol);
			if (col < 0 || col > 5)
				col = 0;
		}
 
		/* Sorting order */
		if (sdir != null) {
			if (!sdir.equals("asc"))
				dir = "desc";
		}
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		String searchTerm ="";		
//		String Query="select user_id, user_name, applicant_type, str_appl_type_name, cont_pers_email, contact_per_desg, to_char(created_date,'dd-Mon-YYYY')createddate , org_address, org_contact_number, case org_country_id when 193 then 'India' else 'NA' end as country, org_dist_id, str_district_name, org_email_id, org_fax_number, org_name, org_pan_number, org_pincode, org_state_id, s.str_state_name, org_type, org_website, str_rcmc_no from (((user_registration ur JOIN applicant_type_mst a on(ur.applicant_type=a.num_appl_type_id)) JOIN states_mst s on(ur.org_state_id = s.num_state_id)) JOIN district_mst d on (ur.org_dist_id = d.num_district_id)) where ur.num_isvalid =1 and ur.num_approval_status_pharmaexil = 1";
		String Query = "SELECT ur.user_id, ur.user_name, ur.applicant_type, a.str_appl_type_name, ur.cont_pers_email, ur.contact_per_desg, to_char(ur.created_date, 'dd-Mon-YYYY') AS createddate, ur.org_address, ur.org_contact_number, CASE ur.org_country_id WHEN 193 THEN 'India' ELSE 'NA' END AS country, ur.org_dist_id, d.str_district_name, ur.org_email_id, ur.org_fax_number, ur.org_name, ur.org_pan_number, ur.org_pincode, ur.org_state_id, s.str_state_name, ur.org_type, ur.org_website, ur.str_rcmc_no, ur.num_inst_id, ipd.str_premise_code, ipd.dt_tr_date, ipd.num_document_id, ipd.str_premises_name FROM user_registration ur JOIN applicant_type_mst a ON ur.applicant_type = a.num_appl_type_id JOIN states_mst s ON ur.org_state_id = s.num_state_id JOIN district_mst d ON ur.org_dist_id = d.num_district_id LEFT JOIN institute_premises_dtl ipd ON ur.num_inst_id = ipd.num_inst_id WHERE ur.num_isvalid = 1 AND ur.num_approval_status_pharmaexil = 1 AND ur.applicant_type IN (100, 101) ORDER BY ur.created_date DESC";
		String result = generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
															 
		return result.toString();
	}
	
	
	public String ShowRejectedRegistrationListing(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int amount = 5; /* Amount in Show Entry drop down */
		int start = 0; /* Counter for Paging, initially 0 */
		int echo = 0; /* Maintains the request number, initially 0 */
		int col = 0; /* Column number in the datatable */
		/* Below variables store the options to create the Query */
		
		String dir = "asc";
		int sStart =  0;
		int sAmount =  5000000;
		String sEcho = request.getParameter("sEcho");
		String sCol = request.getParameter("iSortCol_0");
		String sdir = request.getParameter("sSortDir_0");
		
		String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) {
			start = sStart;
			if (start < 0)
				start = 0;
		}
 
		/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) {
			amount = sAmount;
			if (amount < 5 || amount > 100)
				amount = 5;
		}
 
		/* Counter of the request sent from Data table */
		if (sEcho != null) {
			echo = Integer.parseInt(sEcho);
		}
 
		/* Column number */
		if (sCol != null) {
			col = Integer.parseInt(sCol);
			if (col < 0 || col > 5)
				col = 0;
		}
 
		/* Sorting order */
		if (sdir != null) {
			if (!sdir.equals("asc"))
				dir = "desc";
		}
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		String searchTerm ="";
		
																																																																																																																																																																																																																																					
		String Query="select user_id,str_reason, user_name, applicant_type, str_appl_type_name, cont_pers_email, contact_per_desg, to_char(created_date,'dd-Mon-YYYY')createddate , org_address, org_contact_number, case org_country_id when 193 then 'India' else 'NA' end as country, org_dist_id, str_district_name, org_email_id, org_fax_number, org_name, org_pan_number, org_pincode, org_state_id, s.str_state_name, org_type, org_website, str_rcmc_no from (((user_registration ur JOIN applicant_type_mst a on(ur.applicant_type=a.num_appl_type_id)) JOIN states_mst s on(ur.org_state_id = s.num_state_id)) JOIN district_mst d on (ur.org_dist_id = d.num_district_id)) where ur.num_isvalid =0 and ur.num_approval_status_pharmaexil = 2 ORDER BY created_date DESC";
		String result = generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
															 
		return result.toString();
	}

	
	
	
	public String ShowFeedbackResponseListing(HttpServletRequest request) {
		// TODO Auto-generated method stub
				int amount = 5; /* Amount in Show Entry drop down */
				int start = 0; /* Counter for Paging, initially 0 */
				int echo = 0; /* Maintains the request number, initially 0 */
				int col = 0; /* Column number in the datatable */
				/* Below variables store the options to create the Query */
				
				String dir = "asc";
				int sStart =  0;
				int sAmount =  5000000;
				String sEcho = request.getParameter("sEcho");
				String sCol = request.getParameter("iSortCol_0");
				String sdir = request.getParameter("sSortDir_0");
				
				String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) {
					start = sStart;
					if (start < 0)
						start = 0;
				}
		 
				/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) {
					amount = sAmount;
					if (amount < 5 || amount > 100)
						amount = 5;
				}
		 
				/* Counter of the request sent from Data table */
		if (sEcho != null) {
					echo = Integer.parseInt(sEcho);
				}
		 
				/* Column number */
		if (sCol != null) {
					col = Integer.parseInt(sCol);
					if (col < 0 || col > 5)
						col = 0;
				}
		 
				/* Sorting order */
		if (sdir != null) {
					if (!sdir.equals("asc"))
						dir = "desc";
				}
				//String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
				//List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
				//int instId = userDetails.get(0).getNumInstId();
				String searchTerm ="";
				
			
				String Query="select rownum,num_problem_id,to_char(dt_entry_date,'dd-Mon-YYYY')createddate  , str_user_name, str_org_name, str_subject, str_problem, str_address, str_pincode, str_designation, str_email_id, str_landline_no, str_problemno, num_reply_status, str_reply, num_doc_id, num_cdac_status, num_cdac_issue_type, str_cdac_remarks, nvl(str_assigned_to,'NA') assigned_to, case num_issue_status when 0 then 'NA' when 1 then 'No action taken' when 2 then 'In progress' when 3 then 'Resolved' when 4 then 'Query forwarded to support team' when 5 then 'Response pending from user' when 6 then 'Pharmexcil to clarify' end as issue_status, num_issue_status, str_assigned_to from feedback_mst where num_isvalid = 1 ORDER BY str_problemno DESC";
		    	String result = generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
				return result.toString();
	}

	public UploadXmlDataDtlDomain saveUploadDataDtl(String finalName, int doc_size, int doc_id, Path path1,
			int purposeType) throws IOException {
		
		UploadXmlDataDtlDomain uploadDomain = new UploadXmlDataDtlDomain();
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		//int userId = (int)userDetails.get(0).getUserId();
		
		Long l= new Long(userDetails.get(0).getUserId());  
		int userId=l.intValue(); 
		
		String fileString = new String(Files.readAllBytes(path1), StandardCharsets.UTF_8);
        String hashvalue = fileString.hashCode()+"";
		
		uploadDomain.setNumDocumentId(doc_id);
		uploadDomain.setNumDocSize(doc_size);
		uploadDomain.setNum_purposeTypeId(purposeType);
		uploadDomain.setNumInstId(userDetails.get(0).getNumInstId());
		uploadDomain.setNumUserId(userId);
		uploadDomain.setStrFilename(finalName);
		uploadDomain.setStrHashCode(hashvalue);
		uploadDomain.setNumStatus(0);// 0 for upload and 1 for final save
		uploadDomain.setNumIsValid(1);
		uploadDomain.setDtTrDate(new Date());
		uploadDomain.setNumTrUserId(100);
		if(purposeType==1)
			uploadDomain.setStrRmarks("Product Detail"); 
		else if(purposeType==2)
			uploadDomain.setStrRmarks("Manufacturing Site Details");
		else
			uploadDomain.setStrRmarks("Exporter Details");
		UploadXmlDataDtlDomain upload = davaDaoServices.saveUploadDtl(uploadDomain);
		return null;
	}

	
	// Added by Manibhushan
	
	public UploadXmlDataDtlDomain saveInvoiceDataDtl(String finalName, int doc_size, int doc_id, Path path1,
			int purposeType) throws IOException {
		
	UploadXmlInvoiceDtlDomain uploadDomain = new UploadXmlInvoiceDtlDomain();
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		//int userId = (int)userDetails.get(0).getUserId();
		
		Long l= new Long(userDetails.get(0).getUserId());  
		int userId=l.intValue(); 
		
		String fileString = new String(Files.readAllBytes(path1), StandardCharsets.UTF_8);
        String hashvalue = fileString.hashCode()+"";
        
        
      //  uploadDomain.setStrInvoiceNo();
        
        
		
		/*
		 * uploadDomain.setNumDocumentId(doc_id); uploadDomain.setStrInvoiceNo(doc_id);
		 * 
		 * 
		 * uploadDomain.setNumDocSize(doc_size);
		 * uploadDomain.setNum_purposeTypeId(purposeType);
		 * uploadDomain.setNumInstId(userDetails.get(0).getNumInstId());
		 * uploadDomain.setNumUserId(userId); uploadDomain.setStrFilename(finalName);
		 * uploadDomain.setStrHashCode(hashvalue); uploadDomain.setNumStatus(0);// 0 for
		 * upload and 1 for final save uploadDomain.setNumIsValid(1);
		 * uploadDomain.setDtTrDate(new Date()); uploadDomain.setNumTrUserId(100);
		 */
		/*
		 * if(purposeType==1) uploadDomain.setStrRmarks("Product Detail"); else
		 * if(purposeType==2) uploadDomain.setStrRmarks("Manufacturing Site Details");
		 * else uploadDomain.setStrRmarks("Exporter Details"); UploadXmlDataDtlDomain
		 * upload = davaDaoServices.saveUploadDtl(uploadDomain);
		 */
		return null;
	}

	
	
	
	@Override
	public List<ReportProblemDomain> getProblemDeatil(int problem_id) {
		// TODO Auto-generated method stub
		 return davaDaoServices.getProblemDeatil( problem_id);
	}
	
	

	public List<String> getUploadedData() {
		
		return davaDaoServices.getuploadedDataDtl();
	}
	
	public void updateUserRegForApprovalDetails(RegistrationForm registrationForm, Long userId, String userName,
			HttpServletRequest request) {
		
		  Optional<RegistrationDetails> registrationDetails=userRepository.findById(userId);
		  RegistrationDetails rg=registrationDetails.get();
		// RegistrationDetails
		// registrationDetails=userRepository.findByUserName(userName);
		  rg.setNumIsValied(1);
		  rg.setNumApprovalStatusPharmaexil(1);
		  rg.setStrReason(registrationForm.getStrReason());
		  davaDaoServices.saveUser(rg);
		 
	}
	
	public void updateUserRegForRejectionDetails(RegistrationForm registrationForm, Long userId, String userName,
			HttpServletRequest request) {
		  Optional<RegistrationDetails> registrationDetails=userRepository.findById(userId);
		  RegistrationDetails rg=registrationDetails.get();
		// RegistrationDetails
		// registrationDetails=userRepository.findByUserName(userName);
		  rg.setUserName(userName+"_old");
		  rg.setNumIsValied(0);
		  rg.setNumApprovalStatusPharmaexil(2);
		  rg.setStrReason(registrationForm.getStrReason());
		  davaDaoServices.saveUser(rg);
	}
	public void updateInstPremiseDtl(int manuUnit, Long userId) {
		davaDaoServices.updateInstPremiseDtl(manuUnit,userId);
		
	}
	
	
public String saveProductInTable(Integer upId,String fileasString, Integer InstId) {
		
		return davaDaoServices.saveProductInTable(upId,fileasString,InstId);
	}

	public void updateFinalStatus(int docId,String previewXml) {
		davaDaoServices.updateFinalStatus(docId,previewXml);
		
	}
	
	public void updateFinalStatus(int docId,StringBuffer previewXml) {
		davaDaoServices.updateFinalStatus(docId,previewXml);
		
	}
	
	public String ShowUploadXmlDetails(HttpServletRequest request,int numTypeId) {
		// TODO Auto-generated method stub
		int amount = 5; /* Amount in Show Entry drop down */
		int start = 0; /* Counter for Paging, initially 0 */
		int echo = 0; /* Maintains the request number, initially 0 */
		int col = 0; /* Column number in the datatable */
		/* Below variables store the options to create the Query */
		
		String dir = "asc";
		int sStart =  0;
		int sAmount =  5000000;
		String sEcho = request.getParameter("sEcho");
		String sCol = request.getParameter("iSortCol_0");
		String sdir = request.getParameter("sSortDir_0");
		
		String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) {
			start = sStart;
			if (start < 0)
				start = 0;
		}
 
		/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) {
			amount = sAmount;
			if (amount < 5 || amount > 100)
				amount = 5;
		}
 
		/* Counter of the request sent from Data table */
		if (sEcho != null) {
			echo = Integer.parseInt(sEcho);
		}
 
		/* Column number */
		if (sCol != null) {
			col = Integer.parseInt(sCol);
			if (col < 0 || col > 5)
				col = 0;
		}
 
		/* Sorting order */
		if (sdir != null) {
			if (!sdir.equals("asc"))
				dir = "desc";
		}
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		
		String searchTerm ="";
		String Query="";
		// String Query="select str_remarks,str_filename,num_document_id,num_upload_id,
		// to_char(dt_tr_date,'dd-Mon-YYYY')createddate,to_char(dt_tr_date,'HH24:MI:ss')
		// createdtime from upload_data_dtl where num_isvalid = 1 and
		// num_inst_id="+instId;
		if(numTypeId==0)
			Query = "select a.str_remarks,a.str_ackreceipt_filename,a.str_ackreceipt_filepath,u.user_name,i.str_manuf_code,a.str_filename,a.num_document_id,a.num_upload_id,to_char(a.dt_tr_date,'dd-Mon-YYYY')createddate,to_char(a.dt_tr_date,'HH24:MI:ss') createdtime ,a.num_type_id, a.num_status , case a.num_status when 1 then 'Uploaded Succesfully' when 2 then 'Uploaded Successfuly' else 'Duplicate pack code ,file Not Uploaded Successfuly' end as status from upload_data_dtl a,user_registration u,institute_mst i where a.num_user_id=u.user_id and a.num_inst_id=i.num_inst_id and a.num_isvalid = 1 and num_recall_flag = 0 and a.num_inst_id="
					+ instId;
		else
			Query = "select inv.str_invoice_no,a.str_remarks,u.user_name,i.str_manuf_code,a.str_filename,a.num_document_id,a.num_upload_id,to_char(a.dt_tr_date,'dd-Mon-YYYY')createddate,to_char(a.dt_tr_date,'HH24:MI:ss') createdtime ,a.num_type_id, a.num_status, case a.num_status when 1 then 'Uploaded Succesfully' when 2 then 'Uploaded Successfuly' else 'Duplicate pack code ,file Not Uploaded Successfuly' end as status from upload_data_dtl a,user_registration u,institute_mst i,invoice_dtl inv where a.num_user_id=u.user_id and a.num_inst_id=i.num_inst_id and a.num_isvalid = 1 and num_recall_flag = 0 and a.num_inst_id="
					+ instId + " and  a.num_type_id=" + numTypeId + " and inv.num_inv_id=a.num_invoice_no";

		//System.err.println("Query>>>>>"+Query);
		
		String result = generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
		//System.err.println(result.toString()+"77777");
		return result.toString();
	}
	
	public String ShowAllUploadXmlDetails(HttpServletRequest request, Integer company, Date dateFromDate, Date dateToDate) {
		// TODO Auto-generated method stub
		int amount = 5; /* Amount in Show Entry drop down */
		int start = 0; /* Counter for Paging, initially 0 */
		int echo = 0; /* Maintains the request number, initially 0 */
		int col = 0; /* Column number in the datatable */
		/* Below variables store the options to create the Query */
		
		String dir = "asc";
		int sStart =  0;
		int sAmount =  5000000;
		String sEcho = request.getParameter("sEcho");
		String sCol = request.getParameter("iSortCol_0");
		String sdir = request.getParameter("sSortDir_0");
		
		String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) {
			start = sStart;
			if (start < 0)
				start = 0;
		}
 
		/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) {
			amount = sAmount;
			if (amount < 5 || amount > 100)
				amount = 5;
		}
 
		/* Counter of the request sent from Data table */
		if (sEcho != null) {
			echo = Integer.parseInt(sEcho);
		}
 
		/* Column number */
		if (sCol != null) {
			col = Integer.parseInt(sCol);
			if (col < 0 || col > 5)
				col = 0;
		}
 
		/* Sorting order */
		if (sdir != null) {
			if (!sdir.equals("asc"))
				dir = "desc";
		}
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		
		String searchTerm ="";
		String Query="";
			if(company == 0) {
				Query="select a.str_remarks,u.user_name,i.str_manuf_code,a.str_filename,a.num_document_id,a.num_upload_id,to_char(a.dt_tr_date,'dd-Mon-YYYY')createddate,to_char(a.dt_tr_date,'HH24:MI:ss') createdtime ,a.num_type_id, u.org_name from upload_data_dtl a,user_registration u,institute_mst i where a.num_user_id=u.user_id and a.num_inst_id=i.num_inst_id and a.num_isvalid = 1 and num_recall_flag = 0 and a.dt_tr_date BETWEEN '"+dateFromDate+"' and '"+dateToDate+"'";
			}else {
				Query="select a.str_remarks,u.user_name,i.str_manuf_code,a.str_filename,a.num_document_id,a.num_upload_id,to_char(a.dt_tr_date,'dd-Mon-YYYY')createddate,to_char(a.dt_tr_date,'HH24:MI:ss') createdtime ,a.num_type_id, u.org_name from upload_data_dtl a,user_registration u,institute_mst i where a.num_user_id=u.user_id and u.user_id="+company+" and a.num_inst_id=i.num_inst_id and a.num_isvalid = 1 and num_recall_flag = 0 and a.dt_tr_date BETWEEN '"+dateFromDate+"' and '"+dateToDate+"'";
			}
		String result = generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
		//System.err.println(result.toString()+"77777");
		return result.toString();
	}
	
	
	public String ShowXmlDiscription(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int amount = 5; /* Amount in Show Entry drop down */
		int start = 0; /* Counter for Paging, initially 0 */
		int echo = 0; /* Maintains the request number, initially 0 */
		int col = 0; /* Column number in the datatable */
		/* Below variables store the options to create the Query */
		
		String dir = "asc";
		int sStart =  0;
		int sAmount =  5000000;
		String sEcho = request.getParameter("sEcho");
		String sCol = request.getParameter("iSortCol_0");
		String sdir = request.getParameter("sSortDir_0");
		
		String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) {
			start = sStart;
			if (start < 0)
				start = 0;
		}
 
		/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) {
			amount = sAmount;
			if (amount < 5 || amount > 100)
				amount = 5;
		}
 
		/* Counter of the request sent from Data table */
		if (sEcho != null) {
			echo = Integer.parseInt(sEcho);
		}
 
		/* Column number */
		if (sCol != null) {
			col = Integer.parseInt(sCol);
			if (col < 0 || col > 5)
				col = 0;
		}
 
		/* Sorting order */
		if (sdir != null) {
			if (!sdir.equals("asc"))
				dir = "desc";
		}
	
		
		String searchTerm ="";
		
		// String Query="select num_drug_id, str_generic_name, str_premises_name,
		// str_dosage_name, str_type_name, str_brand_name, str_schedule_name,
		// str_strength, monograph_name, str_condition_name,
		// str_composition,d.num_hs_code, str_commodity_name , CONCAT(d.num_hs_code,
		// str_commodity_name) hscode from (((((((drug_mst d JOIN institute_premises_dtl
		// inst ON (d.num_manu_unit_id = inst.num_premises_no)) JOIN
		// drug_dosage_form_mst dr ON (d.num_dosage_form = dr.num_drug_dosage_form_id))
		// JOIN drug_type_mst drt ON (d.num_drug_type = drt.num_type_id)) JOIN
		// drug_schedule_mst sc ON (d.num_schedule_id = sc.num_schedule_id)) JOIN
		// drug_monograph_mst mono ON(d.num_pharmacopial_classification =
		// mono.monograph_id)) JOIN hscode_mst hs ON (hs.num_hscode = d.num_hs_code))
		// JOIN storage_condition_mst sto
		// ON(d.num_storage_condition=sto.num_condition_id)) where d.num_isvalid = 1";
		String Query="select str_remarks,str_filename,num_document_id,num_upload_id from upload_data_dtl where num_isvalid = 1";
		//System.err.println("Query>>>>>"+Query);
		
		String result = generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
		//System.err.println(result.toString()+"77777");
		return result.toString();
	}
	
	public boolean saveManufacturerInTable(String fileasString) {
		return davaDaoServices.saveManufacturingInTable(fileasString);
	}
	
	/*
	 * public void setConfigDetails(ConfigDtl configdtl) { DesktopConfigDtlDom
	 * dskConDom = new DesktopConfigDtlDom();
	 * dskConDom.setNumUserId(configdtl.getUser_id());
	 * dskConDom.setIpAddress(configdtl.getIp_address().toString());
	 * dskConDom.setAppVersion(configdtl.getApp_version());
	 * dskConDom.setJavaVersion(configdtl.getJava_version());
	 * dskConDom.setMacAddress(configdtl.getMac_address());
	 * dskConDom.setOsVersion(configdtl.getOs_version()); dskConDom.setDtTrDate(new
	 * Date()); dskConDom.setNumIsValid(1); dskConDom.setNumTrUserId(1001);
	 * davaDaoServices.saveConfigDtls(dskConDom); }
	 */

	@Override
	public boolean verifyPasswords(String rawPassword,String encodedPassword) {
		boolean result=bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
		return result;
	}

	
	public boolean savePackingInTable(String fileasString) {
		return davaDaoServices.savePackagingInTable(fileasString);
	}

	@Override
	public List<DrugMst> getProductNames() {
		List<DrugMst> getProductNames=davaDao.getProductNames();
		return getProductNames;
	}
	
	public List<DrugMst> getProductNames(Integer InstId) {
		List<DrugMst> getProductNames=davaDao.getProductNames(InstId);
		return getProductNames;
	}

	@Override
	public List<CountryMst> getCountrybasedOnRegion(Integer regionId) {
		List<CountryMst> getCountrybasedOnRegion=davaDao.getCountrybasedOnRegion(regionId);
		
		return getCountrybasedOnRegion;
	}

	@Override
	public boolean saveExportOrderDetails(ExportOrderModel exportOrderModel) {
		ExportOrderDomain exportOrderDomain=getExportOrderDomain(exportOrderModel);
		boolean result=davaDao.saveExportOrderDetails(exportOrderDomain);
		return result;
	}

	private ExportOrderDomain getExportOrderDomain(ExportOrderModel exportOrderModel) {
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		
		ExportOrderDomain exportOrderDomain=new ExportOrderDomain();
		exportOrderDomain.setExp_id(exportOrderModel.getExp_id());
		exportOrderDomain.setNumInstId(instId);
		exportOrderDomain.setInvoice_no(exportOrderModel.getInvoice_no());
		exportOrderDomain.setInvoice_date(exportOrderModel.getInvoice_date());
		exportOrderDomain.setProductId(exportOrderModel.getProductId());
		exportOrderDomain.setProductName(exportOrderModel.getProductName());
		exportOrderDomain.setExportingRegion(exportOrderModel.getExportingRegion());
		exportOrderDomain.setCountry_id(exportOrderModel.getCountry_id());
		exportOrderDomain.setExportingCountryAddress(exportOrderModel.getExportingCountryAddress());
		exportOrderDomain.setExportingCountryContact(exportOrderModel.getExportingCountryContact());
		exportOrderDomain.setNumIsValid(1);
		exportOrderDomain.setNumTrUserId(1001);
		exportOrderDomain.setDtTrDate(new Date());
		return exportOrderDomain;
	}
	
	public ConsignmentDetailDomain saveConsignmentDetails(EXP_TERTIARY_LIST exp_tertiary_list,int docId) {
		
		
		
		  EXP_TERTIARY_LIST_DETAILS exp=new EXP_TERTIARY_LIST_DETAILS();
		  ConsignmentDetailsEntity consignmentDetailsEntity=new ConsignmentDetailsEntity(); 
		  
		  //Consignment Details Entity
		  ConsignmentDetails cd=exp_tertiary_list.getConsignmentDetails();
		  
		  consignmentDetailsEntity.setStr_sender_manufacturer_code(cd.getSender_manufacturer_code());
		  consignmentDetailsEntity.setStr_filename(cd.getFilename());
		  consignmentDetailsEntity.setFile_date(stringToDate(cd.getFile_date()));
		  consignmentDetailsEntity.setExp_tertiary_list_details(exp);
		  consignmentDetailsEntity.setStr_file_time(cd.getFile_time());
		  consignmentDetailsEntity.setStr_serialization_type(cd.getSerialization_type());

		  //EXP_TERTIARY_LIST_DETAILS entity
		  exp.setDocId(docId);
		  exp.setConsignmentDetailsEntity(consignmentDetailsEntity);
		  
		  
		  EXPORT_DETAILS exportDetails=new EXPORT_DETAILS();
		  EXPORT export=cd.getExport();
		  
		  exportDetails.setSscc(export.getSscc());
		  exportDetails.setInvoice_no(export.getInvoice_no());
		  exportDetails.setInv_date(export.getInv_date());
		  exportDetails.setCountryOfExp(export.getCountryOfExp());
		  exportDetails.setCompanyName(export.getCompanyName());
		  exportDetails.setCompanyAddress(export.getCompanyAddress());
		  exportDetails.setTertiaryCount(export.getTertiaryCount());
		  
		  consignmentDetailsEntity.setExportDetails(exportDetails);
		  
		  //EXPORT_DETAILS entity
		  exportDetails.setConsignmentDetailsEntity(consignmentDetailsEntity);
		 
		  davaDaoServices.persistConsignmentDetailEntities(exp,consignmentDetailsEntity,exportDetails);
		  
		  
		  for (TERTIARY tertiary : export.getTertiary()) {
				
			  TERTIRY_DETAILS tertiaryDetails=new TERTIRY_DETAILS();
			  tertiaryDetails.setStr_tertiaryType(tertiary.getTertiaryType());
			  tertiaryDetails.setStr_ProductCount(tertiary.getProductCount());
			  tertiaryDetails.setStr_secondary3Count(tertiary.getSecondary3Count());
			  tertiaryDetails.setExportDetails(exportDetails);
			  davaDaoServices.addTertiaryDetails(tertiaryDetails);
			  
			 for (SECONDARY3 secondary3 : tertiary.getSecondary3()) {
				  
				 SECONDARY3_DETAILS secondary3Details=new SECONDARY3_DETAILS();
				 
				 secondary3Details.setStr_secondary3Type(secondary3.getSecondary3Type());
				 secondary3Details.setStr_code_SNoSecondary3(secondary3.getCode_SNoSecondary3());
				 secondary3Details.setStr_secondary2Count(secondary3.getSecondary2Count());
				 secondary3Details.setTertiaryDetails(tertiaryDetails);
				 davaDaoServices.addSecondary3Details(secondary3Details);
				 
				 for (SECONDARY2 secondary2 : secondary3.getSecondary2()) {
					
					 SECONDARY2_DETAILS secondary2Details=new SECONDARY2_DETAILS();
					 
					 secondary2Details.setStr_secondary2Type(secondary2.getSecondary2Type());
					 secondary2Details.setStr_code_SNoSecondary2(secondary2.getCode_SNoSecondary2());
					 secondary2Details.setStr_secondary1Count(secondary2.getSecondary1Count());
					 secondary2Details.setSecondary3Details(secondary3Details);
					 davaDaoServices.addSecondary2Details(secondary2Details);
					 
					 for (SECONDARY1 secondaryOne : secondary2.getSecondary1()) {
						
						 SECONDARY1_DETAILS secondary1Details=new SECONDARY1_DETAILS();
						 
						 secondary1Details.setStr_secondary1Type(secondaryOne.getSecondary1Type());
						 secondary1Details.setStr_code_SNoSecondary1(secondaryOne.getCode_SNoSecondary1());
						 secondary1Details.setSecondary2Details(secondary2Details);
						 davaDaoServices.addSecondary1Details(secondary1Details);
						 
						 for (Product product : secondaryOne.getProduct()) {
							
							 ProductDetails productDetails=new ProductDetails();

							 productDetails.setStr_ProductName(product.getProductName());
							 productDetails.setStr_pack_size(product.getPack_size());
							 productDetails.setStr_prodCode(product.getProdCode());
							 productDetails.setStr_batch_number(product.getBatch_number());
							 productDetails.setDate_expiry_date(stringToDate(product.getExpiry_date()));
							 productDetails.setStr_procurement_source_name(product.getProcurement_source_name());
							 productDetails.setStr_procurement_source_address(product.getProcurement_source_address());
							 productDetails.setSecondary1Details(secondary1Details);
							 davaDaoServices.addProductdetails(productDetails);
						}
						
					}
					
				}
				
			}
			  
			
		}
		  
		  return null;
		 
	}
	
	
	public Date stringToDate(String date) {
		String sDate1=date;  
		Date date1=null;
		if(sDate1!=null) {
			try {
				  date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
				} catch (ParseException e) {
					e.printStackTrace();
				} 
		}
		return date1;
	}

	private ConsignmentDetailDomain getConsignmentDetailDomain(EXP_TERTIARY_LIST exp_tertiary_list) {
		ConsignmentDetailDomain cd =new ConsignmentDetailDomain();
		
		
		
		
		
		
		
		
		cd.setNum_premise_no(0);
		cd.setNum_inst_id(0);
		cd .setNum_sender_manuf_code(exp_tertiary_list.getConsignmentDetails().getSender_manufacturer_code());
		cd.setStr_file_name(exp_tertiary_list.getConsignmentDetails().getFilename());
		//cd.setDt_file_date(exp_tertiary_list.getConsignmentDetails().getFile_date());
		cd.setDt_file_date(new Date());
		cd.setStr_serialization_type(exp_tertiary_list.getConsignmentDetails().getSerialization_type());
		cd.setStr_sscc(exp_tertiary_list.getConsignmentDetails().getExport().getSscc());
		cd.setStr_invoice_no(exp_tertiary_list.getConsignmentDetails().getExport().getInvoice_no());
		//cd.setDt_invoice_date(exp_tertiary_list.getConsignmentDetails().getExport().getCountryOfExp());
		cd.setDt_invoice_date(new Date());
		cd.setStr_exp_country(exp_tertiary_list.getConsignmentDetails().getExport().getCompanyName());
		cd.setStr_company_name(exp_tertiary_list.getConsignmentDetails().getExport().getCompanyName());
		cd.setStr_company_add(exp_tertiary_list.getConsignmentDetails().getExport().getCompanyAddress());
		cd.setNum_tertiary_count(exp_tertiary_list.getConsignmentDetails().getExport().getTertiaryCount());
		cd.setStr_tertiary_type(
				exp_tertiary_list.getConsignmentDetails().getExport().getTertiary().get(0).getTertiaryType());
		cd.setNum_prod_count(
				exp_tertiary_list.getConsignmentDetails().getExport().getTertiary().get(0).getProductCount());
		cd.setNum_s3_count(
				exp_tertiary_list.getConsignmentDetails().getExport().getTertiary().get(0).getSecondary3Count());
		cd.setStr_s3_type(exp_tertiary_list.getConsignmentDetails().getExport().getTertiary().get(0).getSecondary3()
				.get(0).getSecondary3Type());
		cd.setStr_s3_sno(exp_tertiary_list.getConsignmentDetails().getExport().getTertiary().get(0).getSecondary3()
				.get(0).getCode_SNoSecondary3());
		cd.setNum_s2_count(exp_tertiary_list.getConsignmentDetails().getExport().getTertiary().get(0).getSecondary3()
				.get(0).getSecondary2Count());
		cd.setStr_s2_type(exp_tertiary_list.getConsignmentDetails().getExport().getTertiary().get(0).getSecondary3()
				.get(0).getSecondary2().get(0).getSecondary2Type());
		cd.setStr_s2_sno(exp_tertiary_list.getConsignmentDetails().getExport().getTertiary().get(0).getSecondary3()
				.get(0).getSecondary2().get(0).getCode_SNoSecondary2());
		cd.setNum_s1_count(exp_tertiary_list.getConsignmentDetails().getExport().getTertiary().get(0).getSecondary3()
				.get(0).getSecondary2().get(0).getSecondary1Count());
		cd.setStr_s2_type(exp_tertiary_list.getConsignmentDetails().getExport().getTertiary().get(0).getSecondary3()
				.get(0).getSecondary2().get(0).getSecondary2Type());
		cd.setNum_s1_count(exp_tertiary_list.getConsignmentDetails().getExport().getTertiary().get(0).getSecondary3()
				.get(0).getSecondary2().get(0).getSecondary1Count());
		cd.setStr_s1_type(exp_tertiary_list.getConsignmentDetails().getExport().getTertiary().get(0).getSecondary3()
				.get(0).getSecondary2().get(0).getSecondary1().get(0).getSecondary1Type());
		cd.setStr_s1_type(exp_tertiary_list.getConsignmentDetails().getExport().getTertiary().get(0).getSecondary3()
				.get(0).getSecondary2().get(0).getSecondary1().get(0).getCode_SNoSecondary1());
		cd.setStr_pack_size(exp_tertiary_list.getConsignmentDetails().getExport().getTertiary().get(0).getSecondary3()
				.get(0).getSecondary2().get(0).getSecondary1().get(0).getProduct().get(0).getPack_size());
		cd.setStr_batch_no(exp_tertiary_list.getConsignmentDetails().getExport().getTertiary().get(0).getSecondary3()
				.get(0).getSecondary2().get(0).getSecondary1().get(0).getProduct().get(0).getBatch_number());
		cd.setStr_source_add(exp_tertiary_list.getConsignmentDetails().getExport().getTertiary().get(0).getSecondary3()
				.get(0).getSecondary2().get(0).getSecondary1().get(0).getProduct().get(0)
				.getProcurement_source_address());
		cd.setStr_source_name(exp_tertiary_list.getConsignmentDetails().getExport().getTertiary().get(0).getSecondary3()
				.get(0).getSecondary2().get(0).getSecondary1().get(0).getProduct().get(0).getProcurement_source_name());
		cd.setStr_prod_name(exp_tertiary_list.getConsignmentDetails().getExport().getTertiary().get(0).getSecondary3()
				.get(0).getSecondary2().get(0).getSecondary1().get(0).getProduct().get(0).getProductName());
		cd.setStr_prod_code(exp_tertiary_list.getConsignmentDetails().getExport().getTertiary().get(0).getSecondary3()
				.get(0).getSecondary2().get(0).getSecondary1().get(0).getProduct().get(0).getProdCode());
		
		return cd;
	}
	
	public InstPremiseDtlDomain saveManufacturePremiseDetails(MANUFACTURE_SCHEMA_LIST manufacture_schema_list,
			int docId) {
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		InstPremiseDtlDomain premise = null;
		for(int i=0;i<manufacture_schema_list.getInstitutePremiseDtl().size();i++) {
			//String manufCode = generateManufCode();
			InstPremiseDtlDomain instDom = new InstPremiseDtlDomain();
			instDom.setNumInstid(instId);
			instDom.setStrExpType(manufacture_schema_list.getInstitutePremiseDtl().get(i).getExpType());
			//instDom.setSiteType(manufacture_schema_list.getInstitutePremiseDtl().get(i).getExpType());
			instDom.setPremiseName(manufacture_schema_list.getInstitutePremiseDtl().get(i).getManufName());
			instDom.setStrAddress(manufacture_schema_list.getInstitutePremiseDtl().get(i).getManufAdd());
			instDom.setNumStateId(
					Integer.parseInt(manufacture_schema_list.getInstitutePremiseDtl().get(i).getManufState()));
			instDom.setNumDistrictId(
					Integer.parseInt(manufacture_schema_list.getInstitutePremiseDtl().get(i).getManufDist()));
			instDom.setNumPincode(
					Integer.parseInt(manufacture_schema_list.getInstitutePremiseDtl().get(i).getManufPin()));
			//instDom.setStrContactDtls(manufacture_schema_list.getInstitutePremiseDtl().get(i).get);
			//instDom.setFaxNumber(manufacture_schema_list.getInstitutePremiseDtl().get(i).get);
			instDom.setEmailId(manufacture_schema_list.getInstitutePremiseDtl().get(i).getManufEmail());
			instDom.setGstin(manufacture_schema_list.getInstitutePremiseDtl().get(i).getGstinNo());
			instDom.setGs1(manufacture_schema_list.getInstitutePremiseDtl().get(i).getGs1No());
			instDom.setContactPersonName(manufacture_schema_list.getInstitutePremiseDtl().get(i).getManufContactName());
			instDom.setContPerMobileNo(manufacture_schema_list.getInstitutePremiseDtl().get(i).getManufContactNumber());
			instDom.setContactPerDesg(manufacture_schema_list.getInstitutePremiseDtl().get(i).getManufDesigNation());
			instDom.setContPersEmail(manufacture_schema_list.getInstitutePremiseDtl().get(i).getManufContactEmail());
			instDom.setNumDocumentId(docId);
			instDom.setNumCountryId(193);
			instDom.setNumIsValid(1);
			instDom.setDtTrDate(new Date());
			instDom.setNumTrUserId(1001);
			//instDom.setStrManufCode(manufCode);
			davaDaoServices.savePremiseDetails(instDom);
		}
		
		return premise;
	}

	public DrugMst saveProductDetails(PRODUCT_SCHEMA_LIST prod_schema_list, int docId) {
		DrugMst drugDomain = null;
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		for(int a=0;a<prod_schema_list.getProductSchemaDtl().size();a++) {
			DrugMst drugDom = new DrugMst();
			/*
			 * List<Character> arrayList = new ArrayList<Character>(); String capcode =
			 * "ABCDEFGHIJKLMONOPQURSTUVWXYZ0123456789"; for (int i = 1; i <
			 * capcode.length() - 1; i++) { arrayList.add(capcode.charAt(i)); }
			 * Collections.shuffle(arrayList); Iterator itr = arrayList.iterator(); String s
			 * = ""; String s2 = ""; Object obj; while (itr.hasNext()) { obj = itr.next(); s
			 * = obj.toString(); s2 = s2 + s; } String s1 = s2.substring(0, 7); char[] s3 =
			 * s1.toCharArray(); Random r = new Random(); int index = Math.abs(r.nextInt())
			 * % 5; System.out.println(index); String SerialNum = String.copyValueOf(s3);
			 * System.out.println(SerialNum);
			 * 
			 * String GenerateProdCode =
			 * prod_schema_list.getProdEnvelope().getProductSchemaDtl().get(a).getProdType()
			 * + SerialNum;
			 */
		      drugDom.setNumInstId(instId);
		      System.out.println(prod_schema_list.getProductSchemaDtl().get(a).getSchedule());
		      if(prod_schema_list.getProductSchemaDtl().get(a).getProdType().equals("B"))
		    	  drugDom.setNumDrugType(11);
		      else
		    	  drugDom.setNumDrugType(12);
				//drugDom.setNumManuUnitId(prod_schema_list.getProdEnvelope().getProductSchemaDtl().get(a).);
				drugDom.setStrGenericName(prod_schema_list.getProductSchemaDtl().get(a).getGenName());
				//drugDom.setStrBrandName(prod_schema_list.getProdEnvelope().getProductSchemaDtl().get(a).get);
				//drugDom.setNumDosageForm(prod_schema_list.getProdEnvelope().getProductSchemaDtl().get(a).get);
				//drugDom.setNumPharmacopialClassification(prod_schema_list.getProdEnvelope().getProductSchemaDtl().get(a).get);
				drugDom.setNumScheduleId(1);
				//drugDom.setStrStrength(prod_schema_list.getProdEnvelope().getProductSchemaDtl().get(a).get);
				//drugDom.setStrStorageCondition(prod_schema_list.getProdEnvelope().getProductSchemaDtl().get(a).);
				drugDom.setStrComposition(prod_schema_list.getProductSchemaDtl().get(a).getComposition());
				//drugDom.setNumPackUnit(prod_schema_list.getProdEnvelope().getProductSchemaDtl().get(a).);
				//drugDom.setStrPackSize(prod_schema_list.getProdEnvelope().getProductSchemaDtl().get(a).);
				drugDom.setNumHSCode(Long.valueOf(prod_schema_list.getProductSchemaDtl().get(a).getHsCode()));
				//drugDom.setNumThrepueticClass(prod_schema_list.getProdEnvelope().getProductSchemaDtl().get(a).);
				//drugDom.setStrProductCode(GenerateProdCode);
				drugDom.setDtTrDate(new Date());
				drugDom.setNumIsValid(1);
				drugDom.setNumTrUserId(1001);
				drugDom.setNumStatus(1);
				drugDom.setNumDocumentId(docId);
				davaDaoServices.saveDrugMasterDetails(drugDom);
		}
		
		return drugDomain;
	}
	
	public List<DrugMst> getProductCode(Integer drugId) {
		List<DrugMst> prodDtls=davaDaoServices.getProdCode(drugId);
		return prodDtls;
	}
	
	public ProcurementMstDomain addProcurementDetailDom(ProcurementMstModel procurementMstModel,
			HttpServletRequest request) {
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		
		SimpleDateFormat inputFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		ProcurementMstDomain pmDom = new ProcurementMstDomain();
		pmDom.setNumInvoiceNo(procurementMstModel.getNumInvoiceNo());
		pmDom.setNumInstId(instId);
		pmDom.setNumPremisesNo(procurementMstModel.getNumPremisesNo());
		pmDom.setNumDrugId(procurementMstModel.getNumDrugId());
		pmDom.setStrBatchNumber(procurementMstModel.getStrBatchNumber());
		pmDom.setStrPremiseAddress(procurementMstModel.getStrPremiseAddress());
		pmDom.setStrPremiseName(procurementMstModel.getStrPremiseName());
		pmDom.setStrProdName(procurementMstModel.getStrProdName());
		pmDom.setStrProdCode(procurementMstModel.getStrProdCode());
		pmDom.setNumSiteType(procurementMstModel.getSiteType());
		pmDom.setStrDrugLicenseNo(procurementMstModel.getDrugLicense());
		pmDom.setStrGSTIN(procurementMstModel.getGSTIN());
		//pmDom.setDtExpDate(procurementMstModel.getDtExpDate());
		
		 String strExpDate = procurementMstModel.getDtExpDate(); 
		 Date dtExpDate = null; 
		 try { 
			 dtExpDate = inputFormat2.parse(strExpDate); 
		 }catch(ParseException  e) { 
			 e.printStackTrace(); 
		 } 
		 pmDom.setDtExpDate(dtExpDate);
		
		pmDom.setDtTrDate(new Date());
		pmDom.setNumIsValid(1);
		pmDom.setNumTrUserId(1001);
		return davaDaoServices.saveProcurementMasterDetails(pmDom);
	}
	
	public String ShowProcurementDetails(HttpServletRequest request) {
		// TODO Auto-generated method stub
				int amount = 5; /* Amount in Show Entry drop down */
				int start = 0; /* Counter for Paging, initially 0 */
				int echo = 0; /* Maintains the request number, initially 0 */
				int col = 0; /* Column number in the datatable */
				/* Below variables store the options to create the Query */
				
				String dir = "asc";
				int sStart =  0;
				int sAmount =  5000000;
				String sEcho = request.getParameter("sEcho");
				String sCol = request.getParameter("iSortCol_0");
				String sdir = request.getParameter("sSortDir_0");
				
				String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) {
					start = sStart;
					if (start < 0)
						start = 0;
				}
		 
				/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) {
					amount = sAmount;
					if (amount < 5 || amount > 100)
						amount = 5;
				}
		 
				/* Counter of the request sent from Data table */
		if (sEcho != null) {
					echo = Integer.parseInt(sEcho);
				}
		 
				/* Column number */
		if (sCol != null) {
					col = Integer.parseInt(sCol);
					if (col < 0 || col > 5)
						col = 0;
				}
		 
				/* Sorting order */
		if (sdir != null) {
					if (!sdir.equals("asc"))
						dir = "desc";
				}
			
				String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
				List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
				int instId = userDetails.get(0).getNumInstId();
				
				String searchTerm ="";
				
				String Query="select num_procurement_id, e.str_invoice_no,i.str_premises_name,str_address, str_premise_name, str_premise_address,d.str_generic_name,str_drug_code, str_prod_name, str_prod_code, str_batch_number, to_char(dt_exp_date,'dd-Mon-YYYY')expdate, str_drug_lic_no, str_gstin, case num_site_type when 1 then 'Own Site' when 2 then 'Loan Site' else 'Whole-Sale Site' end as sitetype from (((procurement_mst p JOIN export_order_mst e ON(p.num_invoice_no=e.num_exp_id)) JOIN institute_premises_dtl i ON(p.num_premises_no=i.num_premises_no)) JOIN drug_mst d ON(p.num_drug_id=d.num_drug_id)) where p.num_isvalid = 1 and p.num_inst_id ="+instId;
				
				String result = generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
				return result.toString();
	}
	
	@Override
	public Map<String,List<Long>> getStateStatistics(Long userId) {
		Map<String,List<Long>> stateStatistics = davaDaoServices.getStateStatistics(userId);
		return stateStatistics;
	}
	public Map<String,Integer> getCountryStatistics(Long userId){
		Map<String,Integer> countrystatistics=davaDaoServices.getCountryStatistics(userId);
		return countrystatistics;
		
	}
	
	@Override
	public List<MemberAddDtlModel> getSitesDisplay(int stateID) {
		List<MemberAddDtlModel> memberAddDtlModels=new ArrayList<MemberAddDtlModel>();
		List <InstPremiseDtlDomain> instPremiseDtlDomains=null;
		
		
		instPremiseDtlDomains = davaDaoServices.getSitesDisplay(stateID);
		
		for (InstPremiseDtlDomain instPremiseDtlDomain : instPremiseDtlDomains) {
			MemberAddDtlModel memberAddDtlModel1=new MemberAddDtlModel();         
                                             
			memberAddDtlModel1.setPremiseName(instPremiseDtlDomain.getPremiseName());
			memberAddDtlModel1.setPremiseAddress(instPremiseDtlDomain.getStrAddress());
			memberAddDtlModel1.setSiteType(instPremiseDtlDomain.getSiteType());
			memberAddDtlModel1.setContactNumber(instPremiseDtlDomain.getStrContactDtls());
			memberAddDtlModel1.setFaxNumber(instPremiseDtlDomain.getFaxNumber());
			memberAddDtlModel1.setEmailId(instPremiseDtlDomain.getEmailId());
			memberAddDtlModel1.setGstin(instPremiseDtlDomain.getGstin());
			memberAddDtlModel1.setGs1(instPremiseDtlDomain.getGstin());
			memberAddDtlModel1.setContactPersonName(instPremiseDtlDomain.getContactPersonName());
			memberAddDtlModel1.setContPerMobileNo(instPremiseDtlDomain.getContPerMobileNo());
			memberAddDtlModel1.setContPersEmail(instPremiseDtlDomain.getContPersEmail());
			memberAddDtlModel1.setContactPerDesg(instPremiseDtlDomain.getContactPerDesg());
			memberAddDtlModels.add(memberAddDtlModel1);
			
		}
		
		return memberAddDtlModels;
	}
	


	public String setConfigDetails(ConfigDtl configdtl) {
        DesktopConfigDtlDom cd = new DesktopConfigDtlDom();
        RegistrationDetails rd = null;
        
        Optional<RegistrationDetails> rg1=userRepository.findById(configdtl.getUser_id());
        if(rg1.isPresent()) {
                rd=rg1.get();
                System.out.println("rd : " + rd.getPublicKey());
        }
        //String PublicKey = rd.getPublicKey();
        //System.out.println("PublicKey : " + PublicKey);
        try
        {
        if(rd.getPublicKey() == null || rd.getPublicKey().isEmpty()) 

        {
	        cd.setNumUserId(configdtl.getUser_id());
	        cd.setAppVersion(configdtl.getApp_version());
	        cd.setIpAddress(configdtl.getIp_address());
	        cd.setJavaVersion(configdtl.getJava_version());
	        cd.setMacAddress(configdtl.getMac_address());
	        cd.setOsVersion(configdtl.getOs_version());
	        cd.setPublicKey(configdtl.getPublicKey());
	        cd.setDirectoryPath(configdtl.getDirectoryPath());
	        cd.setXsdPath("");
	        cd.setFolderPath(configdtl.getFolderPath());
	        cd.setInputPath(configdtl.getInputPath());
	        cd.setOutputPath(configdtl.getOutputPath());
	        cd.setLogPath(configdtl.getLogPath());
	        cd.setElementName(configdtl.getElementName());
	        cd.setFileType(configdtl.getFileType());
	        cd.setDtTrDate(new Date());
	        cd.setNumIsValid(1);
	        cd.setNumTrUserId(1001);
	        rd.setPublicKey(configdtl.getPublicKey());
	        System.out.println("rd.setPublicKey : " + rd.getPublicKey());
	        userRepository.updatePublicKey(configdtl.getUser_id(), rd.getPublicKey());
	        davaDaoServices.saveConfigDtls(cd);
	        return "Successfully done configuration";
        }
        else
        {
        	if(rd.getPublicKey().equals(configdtl.getPublicKey()))
        	{
        		cd.setNumUserId(configdtl.getUser_id());
    	        cd.setAppVersion(configdtl.getApp_version());
    	        cd.setIpAddress(configdtl.getIp_address().toString());
    	        cd.setJavaVersion(configdtl.getJava_version());
    	        cd.setMacAddress(configdtl.getMac_address());
    	        cd.setOsVersion(configdtl.getOs_version());
    	        cd.setPublicKey(configdtl.getPublicKey());
    	        cd.setDirectoryPath(configdtl.getDirectoryPath());
    	        cd.setXsdPath("");
    	        cd.setFolderPath(configdtl.getFolderPath());
    	        cd.setInputPath(configdtl.getInputPath());
    	        cd.setOutputPath(configdtl.getOutputPath());
    	        cd.setLogPath(configdtl.getLogPath());
    	        cd.setElementName(configdtl.getElementName());
    	        cd.setFileType(configdtl.getFileType());
    	        cd.setDtTrDate(new Date());
    	        cd.setNumIsValid(1);
    	        cd.setNumTrUserId(1001);
    	        rd.setPublicKey(configdtl.getPublicKey());
    	        System.out.println("rd.setPublicKey : " + rd.getPublicKey());
    	        davaDaoServices.saveConfigDtls(cd);
    	        return "Successfully done configuration";
        	}
        	else
        	{
        		System.out.println("You have already registered with different dongle");
        		return "You have already registered with different dongle.";
        	}
        }
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
		return "";
		
	}

	@Override
	public String checkAlreadtRegWithNumber(String rcmcNumber) {
		String reisteredStatus="notRegistered";
		RegistrationDetails registrationDetails=userRepository.findByStrRcmcNumber(rcmcNumber);
		if(registrationDetails!=null)
			reisteredStatus="alreadyRegistered";
		return reisteredStatus;
	}

	@Override
	public String findByiecNumber(String iecNumber) {
		String reisteredStatus="NotPresent";
		RegistrationDetails registrationDetails=userRepository.findByIecNumber(iecNumber);
		if(registrationDetails!=null)
			reisteredStatus="alreadyPresent";
		return reisteredStatus;
	}

	@Override
	public String findBygstnNumber(String gstnNumber) {
		String reisteredStatus="NotPresent";
		RegistrationDetails registrationDetails=userRepository.findByGstnumber(gstnNumber);
		if(registrationDetails!=null)
			reisteredStatus="alreadyPresent";
		return reisteredStatus;
	}
	
	public void updatePublicKeyInUR(Long userId, String mac_address, String publicKey) {
		davaDaoServices.updateKeyinRegistration(userId,mac_address,publicKey);
		
	}
	
	@Override
	public String checkIecNumber(String iecNumber) {
		String result="alreadyPresent";
		RegistrationDetails registrationDetails=userRepository.findByIecNumber(iecNumber);
		if(registrationDetails==null)
			result="notPresent";
		return result;
	}

	@Override
	public String checkGstnNumber(String gstnNumber) {
		String result="alreadyPresent";
		RegistrationDetails registrationDetails=userRepository.findByGstnumber(gstnNumber);
		if(registrationDetails==null)
			result="notPresent";
		return result;
	}

	@Override
	public List<RegistrationDetails> getRegistrationData() {
		return userRepository.findAll();
	}
	
	@Override
	public boolean checkIfValidOldPassword(RegistrationDetails registrationDetails, String oldPassword) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
		return encoder.matches(oldPassword, registrationDetails.getPassword());  
	
	}

	@Override
	public String createJSONTilesData(String tilesfuncName, Integer numInstId, Long numTrUserId) {
		return davaDaoServices.createJSONTilesData(tilesfuncName,numInstId,numTrUserId);
	}

	@Override
	public List<HibernateSearchModel> getSolrSearchResults(String searchString, String string, boolean b) {

		HttpSolrClient dclient=null;
		List<HibernateSearchModel> pd=new ArrayList<HibernateSearchModel>();

		try{
			dclient = new HttpSolrClient.Builder(urlString).build();
		}catch(Exception e){
			e.printStackTrace();
			

		}
		Map<Long, List<HibernateSearchModel>>  response=new HashMap<Long, List<HibernateSearchModel>>();
		if(dclient!=null){
		QueryResponse response1=doDatabaseSearch(searchString,dclient);

		long numFound=0;

		if(response1!=null ){
			if(response1.getResults()!=null)
				numFound=response1.getResults().getNumFound();

				//Map<String, Map<String, List<String>>> hitHighlightedMap = response1.getHighlighting();
			Map<String,Map<String,List<String>>> map=new HashMap<String, Map<String,List<String>>>();
				//map.putAll(hitHighlightedMap);

			SolrDocumentList documents =response1.getResults();

				for (SolrDocument document : documents) {

				HibernateSearchModel proposal=new HibernateSearchModel();

				response1.getResults().getNumFound();
				String printcd=(String)((List<?>)document.get("printcd")).get(0);
				
				String xmlString=(String)((List<?>)document.get("printxml")).get(0);

				proposal.setPrintcd(printcd);
				proposal.setXmlString(xmlString);
				pd.add(proposal);
			}



		}else{
			numFound=-1;
		}
		response.put(numFound, pd);
		}
		return pd;
	
	}
	
	public QueryResponse doDatabaseSearch(String searchString, HttpSolrClient client) {
		try {

			
			System.out.println("inside doDatabaseSearch");
			final Map<String, String> queryParamMap = new HashMap<String, String>();
			queryParamMap.put("defType","edismax");
			String FieldQuery="printcd";
			String q=new String(searchString);

		
				q+="\"";
				q="\""+q;
			
		
			queryParamMap.put("q",q);
			queryParamMap.put("qf",FieldQuery);
			//queryParamMap.put("fl","*,score");
		
			MapSolrParams queryParams = new MapSolrParams(queryParamMap);
			QueryResponse solrresponse=null;
			solrresponse = client.query(queryParams);	

			return solrresponse;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<HibernateSearchModel> getDatabaseSearchResults(String searchString) {
		List<HibernateSearchModel> models=new ArrayList<HibernateSearchModel>();
		ArrayList<Object> paraList=new ArrayList<Object>();
		String query="select printxml from pack_code_dtl where str_printcd=?";
		paraList.add(0, searchString);
		List<Object[]> list = daoHelper.getData(query, paraList);
		for (Object[] objects : list) {
			HibernateSearchModel model=new HibernateSearchModel();
			model.setXmlString(String.valueOf(objects[0]));
			models.add(model);
		}
		return models;
	}

	public List<Object[]> getSearchXMLResults(String searchString) {
		ArrayList<Object> paraList = new ArrayList<Object>();
		String query = "select printxml from pack_code_dtl where str_printcd=?";
		paraList.add(0, searchString);
		List<Object[]> list = daoHelper.getData(query, paraList);
		
		return list;
	}

	public List<InstituteMasterDomain> getInstituteData(int instId) {
		List<InstituteMasterDomain> i =davaDaoServices.getInstData(instId);
		return i;
	}

	@Override
	public WorkshopRegistrationDomain addWorkshopRegistration(WorkshopRegistrationModel workshopRegistrationModel,
			HttpServletRequest request) {
		WorkshopRegistrationDomain wd = new WorkshopRegistrationDomain();
		wd.setStrName(workshopRegistrationModel.getStrName());
		wd.setStrName2(workshopRegistrationModel.getStrName2());
		wd.setEmailId(workshopRegistrationModel.getEmailId());
		wd.setGender(workshopRegistrationModel.getGender());
		wd.setCompanyName(workshopRegistrationModel.getCompanyName());
		wd.setCompanyAdd(workshopRegistrationModel.getCompanyAdd());
		wd.setMobileNo(workshopRegistrationModel.getMobileNo());
		wd.setLocation(workshopRegistrationModel.getLocation());
		wd.setNumIsValid(1);
		wd.setDtTrDate(new Date());
		wd.setNumTrUserId(1001);
		WorkshopRegistrationDomain dom = davaDaoServices.saveWorkshopRegistration(wd,request);
		return dom;
	}
	
	public CodeRequestMstDomain addGeneratePackCode(GeneratePackModel generatePackModel, HttpServletRequest request) {
		
		SimpleDateFormat inputFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		
		CodeRequestMstDomain dom = new CodeRequestMstDomain();
		dom.setInstId(instId);
		dom.setPackLevel(generatePackModel.getPackLevel());
		dom.setPackType(generatePackModel.getPackType());
		dom.setCodeCount(generatePackModel.getCodeCount());
		
		String strDispatchDate = generatePackModel.getDispatchDate(); 
		 Date dtDispatchDate = null; 
		 try { 
			 dtDispatchDate = inputFormat2.parse(strDispatchDate); 
		 }catch(ParseException  e) { 
			 e.printStackTrace(); 
		 } 
		 dom.setDtDispatchDate(dtDispatchDate);
		
		 dom.setDtTrDate(new Date());
		 dom.setNumIsValid(1);
		 dom.setNumTrUserId(1001);
		CodeRequestMstDomain crd = davaDaoServices.saveCodeRequest(dom);
		return crd;
	}
	
	public String ShowGeneratePackCode(HttpServletRequest request) {
		int amount = 5; /* Amount in Show Entry drop down */
		int start = 0; /* Counter for Paging, initially 0 */
		int echo = 0; /* Maintains the request number, initially 0 */
		int col = 0; /* Column number in the datatable */
		/* Below variables store the options to create the Query */
		
		String dir = "asc";
		int sStart =  0;
		int sAmount =  5000000;
		String sEcho = request.getParameter("sEcho");
		String sCol = request.getParameter("iSortCol_0");
		String sdir = request.getParameter("sSortDir_0");
		
		String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) {
			start = sStart;
			if (start < 0)
				start = 0;
		}
 
		/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) {
			amount = sAmount;
			if (amount < 5 || amount > 100)
				amount = 5;
		}
 
		/* Counter of the request sent from Data table */
		if (sEcho != null) {
			echo = Integer.parseInt(sEcho);
		}
 
		/* Column number */
		if (sCol != null) {
			col = Integer.parseInt(sCol);
			if (col < 0 || col > 5)
				col = 0;
		}
 
		/* Sorting order */
		if (sdir != null) {
			if (!sdir.equals("asc"))
				dir = "desc";
		}
	
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		
		String searchTerm ="";
		
		//String Query = "select num_req_id, case num_pack_level when 1 then 'Tertiary level' when 2 then 'Secondary level 3' when 3 then 'Secondary level 2' else 'Secondary level 1' end as pack_level, case num_pack_type when 1 then 'Homogeneous' else 'Heterogeneous' end as pack_type,to_char(dt_dispatch_date,'dd-Mon-YYYY')dispatchdate , num_noofcode_req from code_req_mst where num_isvalid = 1 and num_inst_id="
		String Query = "select num_req_id, " +
			    "case num_pack_level " +
			        "when 1 then 'Tertiary level' " +
			        "when 2 then 'Secondary level 3' " +
			        "when 3 then 'Secondary level 2' " +
			        "when 4 then 'Secondary level 1' " +
			        "when 5 then 'Primary Level ' " +
			        "else 'Secondary level 1' " +
			    "end as pack_level, " +
			    "case num_pack_type " +
			        "when 1 then 'Homogeneous' " +
			        "else 'Heterogeneous' " +
			    "end as pack_type, " +
			    "to_char(dt_dispatch_date,'dd-Mon-YYYY') as dispatchdate, " +
			    "num_noofcode_req " +
			    "from code_req_mst " +
			    "where num_isvalid = 1 and num_inst_id="+ instId;
		
		String result = generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
		return result.toString();
	}
	
	public Integer saveConsignmentDetailsInTable(Integer uploadId) {
		return davaDaoServices.getUploadedDetails(uploadId);
		//return true;
	}

	public UploadXmlDataDtlDomain saveUploadDesktopDataDtl(String finalName, int doc_size, int doc_id, Path path1,
			int purposeType, long UserId, String xmlData) throws IOException {
			UploadXmlDataDtlDomain uploadDomain = new UploadXmlDataDtlDomain();
			String loogedInUserId = SecurityContextHolder.getContext().getAuthentication().getName();
			List<RegistrationDetails> userDetails = davaDao.getRegistrationDetails(UserId);
			System.out.println(userDetails.get(0).getNumInstId());
			// int userId = (int)userDetails.get(0).getUserId();
			Long l = new Long(UserId);
			int userId = l.intValue();
			String fileString = new String(Files.readAllBytes(path1), StandardCharsets.UTF_8);
			String hashvalue = MD5Hash.getMd5(fileString);
			uploadDomain.setNumDocumentId(doc_id);
			uploadDomain.setNumDocSize(doc_size);
			uploadDomain.setNum_purposeTypeId(purposeType);
			uploadDomain.setNumInstId(userDetails.get(0).getNumInstId());
			uploadDomain.setNumUserId(userId);
			uploadDomain.setStrFilename(finalName);
			uploadDomain.setStrHashCode(hashvalue);
			uploadDomain.setXmlData(xmlData);
			uploadDomain.setNumStatus(1);
			uploadDomain.setNumIsValid(1);
			uploadDomain.setNumVerifyBy(11);// 11->Pending; 22->Success 33->Failed
			uploadDomain.setDtTrDate(new Date());
			uploadDomain.setNumTrUserId(100);
			if (purposeType == 1)
				uploadDomain.setStrRmarks("Product Detail");
			else if (purposeType == 2)
				uploadDomain.setStrRmarks("Manufacturing Site Details");
			else
				uploadDomain.setStrRmarks("Exporter Details");
			UploadXmlDataDtlDomain upload = davaDaoServices.saveUploadDtl(uploadDomain);
			return upload;
		}
	


	@Override
	public UploadXmlDataDtlDomain saveUploadACkDtl(String finalName, int doc_id, String path) {
		List<UploadXmlDataDtlDomain> uploadDomain = davaDaoServices.getUploadedeData(doc_id);

		UploadXmlDataDtlDomain obj=uploadDomain.get(0);
		obj.setNumDocumentId(doc_id);	
		obj.setStrAckReceipt(finalName);
		obj.setStrAckReceiptPath(path);
		UploadXmlDataDtlDomain upload = davaDaoServices.saveUploadDtl(obj);
		return upload;
	}

	@Override
	public RegistrationForm getUserDetails(Long userId) {
		Optional<RegistrationDetails> optional=userRepository.findById(userId);
		RegistrationDetails regDetails=optional.get();
		RegistrationForm regForm=getRegForm(regDetails);
		return regForm;
	}
	
	
	
	private RegistrationForm getRegForm(RegistrationDetails regDetails) {
		
		RegistrationForm registrationForm=new RegistrationForm();
		registrationForm.setUserId(regDetails.getUserId());
		registrationForm.setUserName(regDetails.getUserName());
		registrationForm.setPassword(regDetails.getPassword());
		registrationForm.setApplicantType(regDetails.getApplicantType());
		registrationForm.setOrgName(regDetails.getOrgName());
		registrationForm.setOrgType(regDetails.getOrgType());
		registrationForm.setOrgAddress(regDetails.getOrgAddress());
		registrationForm.setOrgCountryId(regDetails.getOrgCountryId());
		registrationForm.setOrgStateId(regDetails.getOrgStateId());
		registrationForm.setOrgDistId(regDetails.getOrgDistId());
		registrationForm.setOrgContactNumber(regDetails.getOrgContactNumber());
		registrationForm.setOrgPincode(regDetails.getOrgPincode());
		registrationForm.setOrgFaxNumber(regDetails.getOrgFaxNumber());
		registrationForm.setOrgEmailId(regDetails.getOrgEmailId());
		registrationForm.setOrgPanNumber(regDetails.getOrgPanNumber());
		registrationForm.setOrgWebsite(regDetails.getOrgWebsite());
		registrationForm.setIecNumber(regDetails.getIecNumber());
		registrationForm.setIecIssueDate(regDetails.getIecIssueDate());
		registrationForm.setIecIssueAuthority(regDetails.getIecIssueAuthority());
		registrationForm.setSsiNumber(regDetails.getSsiNumber());
		registrationForm.setSsiIssueDate(regDetails.getSsiIssueDate());	
		registrationForm.setContactPersonName(regDetails.getContactPersonName());
		registrationForm.setContactPerDesg(regDetails.getContactPerDesg());
		registrationForm.setContPerMobileNo(regDetails.getContPerMobileNo());
		registrationForm.setContPersEmail(regDetails.getContPersEmail());
		registrationForm.setMemberOfOtherExportPromotionCouncil(regDetails.getMemberOfOtherExportPromotionCouncil());
		registrationForm.setRcmcNumber(regDetails.getStrRcmcNumber());
		registrationForm.setFinalApprovalStatus(regDetails.getNumApprovalStatusPharmaexil());
		registrationForm.setRcmcStatus(regDetails.getNumRcmsStatus());
		registrationForm.setEmailStatus(regDetails.getNumEmailStatus());
		registrationForm.setNumIsValied(regDetails.getNumIsValied());
		registrationForm.setRandomCode(regDetails.getRandomNumber());
		registrationForm.setEmailVerificationLink(regDetails.getVerificationLink());
		registrationForm.setNumInstId(regDetails.getNumInstId());
		registrationForm.setStrReason(regDetails.getStrReason());
		registrationForm.setGstnumber(regDetails.getGstnumber());
		registrationForm.setGsOne(regDetails.getGsOne());
		registrationForm.setNumTrUserId(regDetails.getNumTrUserId());
		registrationForm.setDtTrDate(regDetails.getDtTrDate());
		registrationForm.setNumPremisesNo(regDetails.getNumPremisesNo());
		registrationForm.setPublicKey(regDetails.getPublicKey());
		registrationForm.setRoleId(regDetails.getRoleId());
		registrationForm.setRoleName(regDetails.getRoleName());
		registrationForm.setOtherPromotionCouncilDetails(regDetails.getOtherPromotionCouncilDetails());
		return registrationForm;
	}

	@Override	
	public void updateUserProfile(RegistrationForm registrationForm) {	
		RegistrationDetails registrationDetails=getRegistrationEntity(registrationForm);	
		RegistrationDetails status=davaDaoServices.saveUser(registrationDetails);	
		MultipartFile file=registrationForm.getAddressProofFile();	
		MultipartFile drugLicence=registrationForm.getDrugLicence();	
			
		if(status!=null && registrationForm.getMemberOfOtherExportPromotionCouncil().equals("yes")) {	
			for(int i=0;i<registrationForm.getPromotionCouncil().length;i++) {	
				OtherPromotionCouncilDetails otherPromotionCouncilDetails=new OtherPromotionCouncilDetails();	
				String promotionCouncilName=registrationForm.getPromotionCouncil()[i];	
				String registrationNumber=registrationForm.getRegistrationNumber()[i];	
				Date validThrough=registrationForm.getValidityDuration()[i];	
				otherPromotionCouncilDetails.setStrPromotionCouncilName(promotionCouncilName);	
				otherPromotionCouncilDetails.setStrRegistrationNumber(registrationNumber);	
				otherPromotionCouncilDetails.setDateValidThrough(validThrough);	
				otherPromotionCouncilDetails.setRegistrationDetails(status);	
				davaDaoServices.saveOtherPromotionCouncil(otherPromotionCouncilDetails);	
			}	
		}	
			
//		MultipartFile file=registrationForm.getAddressProofFile();	
//		MultipartFile drugLicence=registrationForm.getDrugLicence();	
			
		String rootDirectory=ftpProps.getDirectory();	
		String finalPath = rootDirectory + "//" + registrationDetails.getApplicantType() + "//"	
				+ registrationDetails.getUserId();	
    	if(registrationForm.getApplicantType().equals("101")) {	
    		if(drugLicence!=null) {	
    			String drugDetailsPath=finalPath;	
    			String druggs=registrationDetails.getUserId() + "_drugDetails.pdf";	
    				
        		try {	
					boolean result = ftpService.uploadFile(registrationDetails.getUserId() + "_drugDetails.pdf",	
							drugLicence.getInputStream(), drugDetailsPath);	
        			LOGGER.info("Successfuly uploaded drug details {} ",result);	
    			} catch (IOException e) {	
					LOGGER.error("error in uploading " + registrationDetails.getUserId() + " drug details {}",	
							e.getMessage());	
    				e.printStackTrace();	
    			}	
    		}	
    	}	
    		
    	if(file!=null) {	
    		String corporateAddressProofPath=finalPath;	
    			
				  try {	
						boolean result = ftpService.uploadFile(registrationDetails.getUserId() + "_corporateAddressProof.pdf",	
								file.getInputStream(), corporateAddressProofPath);	
		    				
		    			LOGGER.info("Successfuly uploaded corporate address proof {} ",result);	
		    		} catch (IOException e1) {	
						LOGGER.error("error in uploading " + registrationDetails.getUserId() + " corporate address proof {}",	
								e1.getMessage());	
		    			e1.printStackTrace();	
		    		}	
    		LOGGER.info("Final path to upload xml file {}",finalPath);	
			/*	
			 * try { boolean result = ftpService.uploadFile(registrationDetails.getUserId()	
			 * + "_corporateAddressProof.pdf", file.getInputStream(),	
			 * corporateAddressProofPath);	
			 * 	
			 * LOGGER.info("Successfuly uploaded corporate address proof {} ",result); }	
			 * catch (IOException e1) { LOGGER.error("error in uploading " +	
			 * registrationDetails.getUserId() + " corporate address proof {}",	
			 * e1.getMessage()); e1.printStackTrace(); }	
			 */	
    	}	
			
			
	}
	
	private RegistrationDetails getRegistrationEntity(RegistrationForm registrationForm) {
		RegistrationDetails registrationDetails=userRepository.findByUserName(registrationForm.getUserName());
		
		registrationDetails.setOrgName(registrationForm.getOrgName());
		registrationDetails.setOrgType(registrationForm.getOrgType());
		registrationDetails.setOrgAddress(registrationForm.getOrgAddress());
		registrationDetails.setOrgCountryId(registrationForm.getOrgCountryId());
		registrationDetails.setOrgStateId(registrationForm.getOrgStateId());
		registrationDetails.setOrgDistId(registrationForm.getOrgDistId());
		registrationDetails.setOrgContactNumber(registrationForm.getOrgContactNumber());
		registrationDetails.setOrgPincode(registrationForm.getOrgPincode());
		registrationDetails.setOrgFaxNumber(registrationForm.getOrgFaxNumber());
		registrationDetails.setOrgEmailId(registrationForm.getOrgEmailId());
		registrationDetails.setOrgPanNumber(registrationForm.getOrgPanNumber());
		registrationDetails.setOrgWebsite(registrationForm.getOrgWebsite());
		registrationDetails.setIecNumber(registrationForm.getIecNumber());
		registrationDetails.setIecIssueDate(registrationForm.getIecIssueDate());
		registrationDetails.setIecIssueAuthority(registrationForm.getIecIssueAuthority());
		registrationDetails.setSsiNumber(registrationForm.getSsiNumber());
		registrationDetails.setSsiIssueDate(registrationForm.getSsiIssueDate());
		registrationDetails.setContactPersonName(registrationForm.getContactPersonName());
		registrationDetails.setContactPerDesg(registrationForm.getContactPerDesg());
		registrationDetails.setContPerMobileNo(registrationForm.getContPerMobileNo());
		registrationDetails.setContPersEmail(registrationForm.getContPersEmail());
		registrationDetails
				.setMemberOfOtherExportPromotionCouncil(registrationForm.getMemberOfOtherExportPromotionCouncil());
		registrationDetails.setGstnumber(registrationForm.getGstnumber());
		registrationDetails.setGsOne(registrationForm.getGsOne());
		registrationDetails.setGstnumber(registrationForm.getGstnumber());
		registrationDetails.setGsOne(registrationForm.getGsOne());
		registrationDetails.setOtherPromotionCouncilDetails(registrationForm.getOtherPromotionCouncilDetails());
		return registrationDetails;
	}

	public PortOfExportDomain savePortOfExport(PortOfExportModel portOfExportModel, HttpServletRequest request) {
		PortOfExportDomain port = new PortOfExportDomain();
		port.setStrPortName(portOfExportModel.getPortName().trim());
		port.setStrPortCode(portOfExportModel.getPortCode().trim());
		port.setNumPincode(portOfExportModel.getPincode());
		port.setStrContactNumber(portOfExportModel.getMobileNo());
		port.setStrEmail(portOfExportModel.getEmailId().trim());
		port.setNumCountryId(193);
		port.setNumDistrictId(portOfExportModel.getDistId());
		port.setNumStateId(portOfExportModel.getStateId());
		port.setStrPortAdd(portOfExportModel.getPortAddress());
		port.setNumIsValid(1);
		port.setDtTrDate(new Date());
		port.setNumTrUserId(1001);
		return davaDaoServices.saveExportPort(port);
	}
	
	public NewsEventsDomain saveNewsEvents(NewsEventsModel newsEventsModel, HttpServletRequest request) {
		NewsEventsDomain news = new NewsEventsDomain();
		SimpleDateFormat inputFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		Date eventDate = null;
		Date publishDate = null;
		Date validUpto = null;
				try {
					eventDate = inputFormat2.parse(newsEventsModel.getEventDate());
					publishDate = inputFormat2.parse(newsEventsModel.getPublishDate());
					validUpto = inputFormat2.parse(newsEventsModel.getValidUpto());
				} catch (ParseException e) {
					e.printStackTrace();
				}
		news.setNumEventType(newsEventsModel.getNumEventType());
		news.setDtOfEventOccur(eventDate);
		news.setStrDetails(newsEventsModel.getDetails());
		news.setStrStatus(newsEventsModel.getStatus());
		news.setPublishDate(publishDate);
		news.setValidUpto(validUpto);
		news.setApproveBy(newsEventsModel.getApproveBy());
		news.setDtTrDate(new Date());
		news.setNumIsValid(1);
		news.setNumTrUserId(1001);
		return davaDaoServices.saveNewsEvents(news);
	}

	public String ShowPortOfExport(HttpServletRequest request) {
		int amount = 5; /* Amount in Show Entry drop down */
		int start = 0; /* Counter for Paging, initially 0 */
		int echo = 0; /* Maintains the request number, initially 0 */
		int col = 0; /* Column number in the datatable */
		/* Below variables store the options to create the Query */
		
		String dir = "asc";
		int sStart =  0;
		int sAmount =  5000000;
		String sEcho = request.getParameter("sEcho");
		String sCol = request.getParameter("iSortCol_0");
		String sdir = request.getParameter("sSortDir_0");
		
		String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) {
			start = sStart;
			if (start < 0)
				start = 0;
		}
 
		/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) {
			amount = sAmount;
			if (amount < 5 || amount > 100)
				amount = 5;
		}
 
		/* Counter of the request sent from Data table */
		if (sEcho != null) {
			echo = Integer.parseInt(sEcho);
		}
 
		/* Column number */
		if (sCol != null) {
			col = Integer.parseInt(sCol);
			if (col < 0 || col > 5)
				col = 0;
		}
 
		/* Sorting order */
		if (sdir != null) {
			if (!sdir.equals("asc"))
				dir = "desc";
		}
	
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		String appType = userDetails.get(0).getApplicantType();
		
		String searchTerm ="";
		
		String Query="select rownum, num_port_id, str_port_code, str_port_name, str_port_add, statename(num_state_id), districtname(num_district_id), num_pincode, str_email, str_contact_number, str_remarks from port_mst where num_isvalid = 1 ORDER BY rownum";
		
		String result = generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
		return result.toString();
	}

	
	public UploadXmlDataDtlLogDomain saveUploadDataLogDtl(String finalName, int doc_size, int doc_id, Path path1,
			int purposeType,String xmlData) throws IOException {

		
		UploadXmlDataDtlLogDomain uploadDomain = new UploadXmlDataDtlLogDomain();
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		//int userId = (int)userDetails.get(0).getUserId();
		
		Long l= new Long(userDetails.get(0).getUserId());  
		int userId=l.intValue(); 
		
		//String fileString = new String(Files.readAllBytes(path1), StandardCharsets.UTF_8);
       // String hashvalue = fileString.hashCode()+"";
        
        String fileString = new String(Files.readAllBytes(path1), StandardCharsets.UTF_8);
		String hashvalue = MD5Hash.getMd5(fileString);
		
		uploadDomain.setNumDocumentId(doc_id);
		uploadDomain.setNumDocSize(doc_size);
		uploadDomain.setNum_purposeTypeId(purposeType);
		uploadDomain.setNumInstId(userDetails.get(0).getNumInstId());
		uploadDomain.setNumUserId(userId);
		uploadDomain.setStrFilename(finalName);
		uploadDomain.setStrHashCode(hashvalue);
		uploadDomain.setNumStatus(0);// 0 for upload and 1 for final save
		uploadDomain.setNumIsValid(1);
		uploadDomain.setDtTrDate(new Date());
		uploadDomain.setNumTrUserId(100);
		uploadDomain.setXmlData(xmlData);
		if(purposeType==1)
			uploadDomain.setStrRmarks("Product Detail"); 
		else if(purposeType==2)
			uploadDomain.setStrRmarks("Manufacturing Site Details");
		else
			uploadDomain.setStrRmarks("Exporter Details");
		UploadXmlDataDtlLogDomain upload = davaDaoServices.saveUploadDtl(uploadDomain);
		return null;
	
	}

	@Override
	public UploadXmlDataDtlLogDomain getUploadedDataLog(int docId) {
		UploadXmlDataDtlLogDomain optional=uploadXmlDataDtlLogRepository.findByNumDocumentId(docId);
		return optional;
	}

	@Override
	public UploadXmlDataDtlDomain saveUploadDataDtlfromLog(UploadXmlDataDtlLogDomain dom) {
		UploadXmlDataDtlDomain uploadDomain = new UploadXmlDataDtlDomain();
				
		uploadDomain.setNumDocumentId(dom.getNumDocumentId());
		uploadDomain.setNumDocSize(dom.getNumDocSize());
		uploadDomain.setNum_purposeTypeId(dom.getNum_purposeTypeId());
		uploadDomain.setNumInstId(dom.getNumInstId());
		uploadDomain.setNumUserId(dom.getNumUserId());
		uploadDomain.setStrFilename(dom.getStrFilename());
		uploadDomain.setStrHashCode(dom.getStrHashCode());
		uploadDomain.setNumStatus(1);// 0 for upload and 1 for final save
		uploadDomain.setNumIsValid(1);
		uploadDomain.setDtTrDate(new Date());
		uploadDomain.setNumTrUserId(dom.getNumTrUserId());
		uploadDomain.setStrRmarks(dom.getStrRmarks()); 
		uploadDomain.setXmlData(dom.getXmlData());
		
		UploadXmlDataDtlDomain upload = davaDaoServices.saveUploadDtl(uploadDomain);
		return upload;
	}

	@Override
	public void indexSearchPageDB(String freshImport) {
		
		HttpSolrClient client =  new HttpSolrClient.Builder(urlString).build();
		Date importDate = new Date();	
		if(null == client){
			System.out.println("Server not Up");
		}
		
		try {	
			
			StringBuilder query = new StringBuilder("SELECT * FROM Pack_code_dtl");		
			
			
			if(!freshImport.equals("true")){	
				Date indexDate = daoHelper.getLastIndexTime("DB Import");
				if(null != indexDate){
					query.append(" where dt_tr_date > '"+indexDate+"'");
				}
			}else{
				client.deleteByQuery("*:*");
			}

			Connection connection = daoHelper.getConnection();
			Statement statement = connection.createStatement();
			statement.executeQuery(query.toString());
			
			ResultSet rs = statement.executeQuery(query.toString());

			while(rs.next()){
				SolrInputDocument document = new SolrInputDocument();
				document.addField("uploadid", rs.getInt("num_upload_id"));
				document.addField("invoiceid", rs.getInt("num_inv_id"));
				document.addField("printcd", rs.getString("str_printcd"));
				document.addField("codetype",rs.getInt("num_code_type"));
				document.addField("printxml", rs.getString("printxml"));
				client.add(document);
			}
		
			client.commit();
			
			daoHelper.updateBYQuery("update iveda_import_history set dt_import='"+importDate+"' where str_import_base = 'DB Import'");
			
		} catch (Exception e) {
			e.printStackTrace();
		}		

	}

	@Override
	public boolean checkPasswordHistory() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkPasswordHistory(List<PasswordHistory> passwordList, String password) {
		boolean result=true;
		for (PasswordHistory passwordHistory : passwordList) {
			if(bCryptPasswordEncoder.matches(password, passwordHistory.getPassword()))
				result=false;
		}
		return result;
	}
	

	
	@Override
	public galleryFormentity savegalleryform(galleryForm fv, HttpServletRequest request) {
		galleryFormentity entityobj = new galleryFormentity();
		galleryFormentity gallerydetailPersisted = null;
		entityobj.setGalleryId(fv.getGalleryId());
		entityobj.setEventName(fv.getEventName());
		entityobj.setEventPlace(fv.getEventPlace());
		entityobj.setEventDate(fv.getEventDate());
		entityobj.setEventPublishDate(fv.getEventPublishDate());
		entityobj.setEventExpiryDate(fv.getEventExpiryDate());
		entityobj.setGalleryImage(request.getAttribute("gallerypathlist").toString());
		entityobj.setNum_isvalid(1);
		if (fv.getGalleryId() == null) {
			gallerydetailPersisted = davaDaoServices.savegalleryform(entityobj);
		} else {
			gallerydetailPersisted = davaDaoServices.Updategalleryform(entityobj);
		}
		return gallerydetailPersisted;

	}

	/** to parse date to string in format yyyy-MM-dd */
	@Override
	public String formattedDate(Date date) {
		SimpleDateFormat simpledateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String fDate = "";
		if (date != null) {
			fDate = simpledateFormat.format(date);
		}
		return fDate;
	}

	@Override
	public List<galleryForm> getEventlist(String limit) {
		List<galleryForm> galleryeventlist = new ArrayList<galleryForm>();
		List<galleryFormentity> galleryevententitylist = null;
		galleryevententitylist = davaDaoServices.getEventlist(limit);

		for (galleryFormentity galleryevententitylistMain : galleryevententitylist) {

			galleryForm galleryformModelDtl = new galleryForm();
			galleryformModelDtl.setGalleryId(galleryevententitylistMain.getGalleryId());
			galleryformModelDtl.setEventName(galleryevententitylistMain.getEventName());
			galleryformModelDtl.setEventPlace(galleryevententitylistMain.getEventPlace());
			// Date date=galleryevententitylistMain.getEventDate();
			// String dateWithoutTime="";
			// dateWithoutTime=formattedDate(galleryevententitylistMain.getEventDate());

			// dateWithoutTime=davaServices.formattedDate(fv.getEventDate());
			galleryformModelDtl.setEventDate(galleryevententitylistMain.getEventDate());
			galleryformModelDtl.setEventPublishDate(galleryevententitylistMain.getEventPublishDate());
			galleryformModelDtl.setEventExpiryDate(galleryevententitylistMain.getEventExpiryDate());
			galleryformModelDtl.setGalleryImagepath(galleryevententitylistMain.getGalleryImage());
			galleryeventlist.add(galleryformModelDtl);
		}

		// TODO Auto-generated method stub
		return galleryeventlist;
	}

	@Override
	public String deletegallerydetail(Long galleryId) {
		// TODO Auto-generated method stub

		String ss = null;
		try {

			ss = davaDaoServices.deletegallerydetail(galleryId);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return ss;
	}


	
	
	
	/*public Date getLastIndexTime(String indexBase){		
		String query = "SELECT dt_import FROM serb_import_history where str_import_base = '"+indexBase+"'" ;
		List<Date> dataList = daoHelper.runNative(query);
		if(dataList.size()>0){
			return dataList.get(0);
		}
		return null;
	}
*/

	public String GetRecalledUploadedXML(HttpServletRequest request, int numTypeId) {
		// TODO Auto-generated method stub
		int amount = 5; /* Amount in Show Entry drop down */
		int start = 0; /* Counter for Paging, initially 0 */
		int echo = 0; /* Maintains the request number, initially 0 */
		int col = 0; /* Column number in the datatable */
		/* Below variables store the options to create the Query */

		String dir = "asc";
		int sStart = 0;
		int sAmount = 5000000;
		String sEcho = request.getParameter("sEcho");
		String sCol = request.getParameter("iSortCol_0");
		String sdir = request.getParameter("sSortDir_0");

		String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) {
			start = sStart;
			if (start < 0)
				start = 0;
		}

		/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) {
			amount = sAmount;
			if (amount < 5 || amount > 100)
				amount = 5;
		}

		/* Counter of the request sent from Data table */
		if (sEcho != null) {
			echo = Integer.parseInt(sEcho);
		}

		/* Column number */
		if (sCol != null) {
			col = Integer.parseInt(sCol);
			if (col < 0 || col > 5)
				col = 0;
		}

		/* Sorting order */
		if (sdir != null) {
			if (!sdir.equals("asc"))
				dir = "desc";
		}
		String loogedInUserId = SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();

		String searchTerm = "";
		String Query = "select a.str_remarks,a.str_ackreceipt_filename,a.str_ackreceipt_filepath,u.user_name,i.str_manuf_code,a.str_filename,a.num_document_id,a.num_upload_id,to_char(a.dt_tr_date,'dd-Mon-YYYY')createddate,to_char(a.dt_tr_date,'HH24:MI:ss') createdtime ,a.num_type_id from upload_data_dtl a,user_registration u,institute_mst i where a.num_user_id=u.user_id and a.num_inst_id=i.num_inst_id and a.num_isvalid = 1 and a.num_recall_flag = 1 and a.num_type_id=3 and a.num_inst_id= "+ instId;

		String result = generateJSONObject("find_val", searchTerm, Query, sAmount, sStart);
		
		return result.toString();
	}
	
	public void saveApprovalTypeMst(String type, String remarks, HttpServletRequest request) {
		ApprovalTypeMst app = new ApprovalTypeMst();
		app.setStrAppTypeName(WordUtils.capitalize(type));
		app.setStrRemarks(remarks);
		app.setNumIsValid(1);
		app.setDtTrDate(new Date());
		app.setNumTrUserId(1001);
		davaDaoServices.addApprovalTypeMst(app);
	}

	@Override
	public String saveOfficialRegistration(RegistrationForm registrationForm) {
		RegistrationDetails registrationDetails=getRegistrationDetails(registrationForm);
		LocationMasterDomain locationMasterDomain=getLocationMasterDomain(registrationForm);
		OfficialRegistrationDetails officialRegDetails=getOfficialRegistrationDetails(registrationForm);
		String result=davaDaoServices.saveOfficialRegistration(registrationDetails,locationMasterDomain,officialRegDetails);
		return result;
	}

	private OfficialRegistrationDetails getOfficialRegistrationDetails(RegistrationForm registrationForm) {
		OfficialRegistrationDetails officialDomain=new OfficialRegistrationDetails();
		officialDomain.setEmpName(registrationForm.getEmpName());
		officialDomain.setEmpNo(registrationForm.getEmpNo());
		officialDomain.setEmpDesg(registrationForm.getEmpDesg());
		officialDomain.setEmpEmailId(registrationForm.getEmpEmailId());
		officialDomain.setGender(registrationForm.getGender());
		officialDomain.setEmpMobileNo(registrationForm.getOrgContactNumber());
		return officialDomain;
	}

	private LocationMasterDomain getLocationMasterDomain(RegistrationForm registrationForm) {
		LocationMasterDomain locationDomain=new LocationMasterDomain();
		locationDomain.setLoc_name(registrationForm.getLocationName());
		locationDomain.setLoc_short_Name(registrationForm.getLocationShortName());
		locationDomain.setLoc_add(registrationForm.getLocationAddress());
		locationDomain.setLoc_country(registrationForm.getOrgCountryId());
		locationDomain.setLoc_zone(registrationForm.getLocZoneId());
		locationDomain.setLoc_state(registrationForm.getOrgStateId());
		locationDomain.setLoc_dist(registrationForm.getOrgDistId());
		locationDomain.setPinCode(registrationForm.getOrgPincode());
		locationDomain.setLoc_contact_dtls(Long.parseLong(registrationForm.getLocContactNumber()));
		locationDomain.setLoc_email(registrationForm.getLocEmailId());
		locationDomain.setWebsite(registrationForm.getLocWebsiteLink());
		return locationDomain;
		
	}

	private RegistrationDetails getRegistrationDetails(RegistrationForm registrationForm) {
		RegistrationDetails registrationDetails=new RegistrationDetails();
		registrationDetails.setApplicantType(registrationForm.getApplicantType());
		registrationDetails.setUserName(registrationForm.getUserName().toLowerCase());
		registrationDetails.setPassword(bCryptPasswordEncoder.encode(registrationForm.getPassword()));
		registrationDetails.setOrgName(registrationForm.getLocationName());
		registrationDetails.setOrgCountryId(registrationForm.getOrgCountryId());
		registrationDetails.setOrgStateId(registrationForm.getOrgStateId());
		registrationDetails.setOrgDistId(registrationForm.getOrgDistId());
		registrationDetails.setOrgPincode(registrationForm.getOrgPincode());
		registrationDetails.setOrgFaxNumber(registrationForm.getOrgFaxNumber());
		registrationDetails.setRandomNumber(registrationForm.getRandomCode());
		registrationDetails.setVerificationLink(registrationForm.getEmailVerificationLink());
		registrationDetails.setNumEmailStatus(0);
		registrationDetails.setNumIsValied(0);
		registrationDetails.setNumTrUserId(0);
		registrationDetails.setNumApprovalStatusPharmaexil(0);
		registrationDetails.setDtTrDate(new Date());
		return registrationDetails;
	}

	@Override
	public List<ZoneMst> getZoneDetails() {
		return davaDaoServices.getZoneDetails();
	}
	
	public List<RegistrationDetails> fetchRegistrationData(Long company, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return davaDaoServices.getRegistrationDetails(company);
	}

	@Override
	public List<PromotionCouncilMaster> getPromotionCouncil() {
		
		return davaDaoServices.getPromotionCouncil();
	}

	@Override
	public List<RegistrationDetails> getRegistrationDataWithoutRegEmail() {
		
		return userRepository.getUsersWithoutVerification();
	}

	@Override
	public EmailSchedulerEntity getSentEmailCount(String userName) {
		
		return emailSchedulerRepo.findByEmailId(userName);
	}

	@Override
	public void updateEmailCount(Integer emailCount) {
		emailSchedulerRepo.setEmailCount(emailCount);
		
	}

	public void saveEmailEntity(EmailSchedulerEntity emailScheduledEntity) {
		emailSchedulerRepo.save(emailScheduledEntity);
	}
	
	public PointOfDistributionMst savePointOfDistributionMst(PointOfDistributionModel distributionModel, HttpServletRequest request) {
		String loogedInUserId = SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		Integer instId = userDetails.get(0).getNumInstId();
		Integer UserId = userDetails.get(0).getUserId().intValue();
		
		PointOfDistributionMst point = new PointOfDistributionMst();
		point.setNumInstId(instId);
		point.setNumGenName(distributionModel.getGenName());
		point.setNumHSCode(distributionModel.getHsCode());
		point.setStrGoodsName(distributionModel.getGoodsName().trim());
		point.setStrGoodsAddress(distributionModel.getGoodsAdd().trim());
		point.setStrGoodsCity(distributionModel.getGoodsCity().trim());
		point.setStrPinCode(distributionModel.getPinCode().trim());
		point.setNumRegionId(distributionModel.getExpReg());
		List<String> countries = distributionModel.getListExpCountry();
		String str = null;
		if(countries.size()>0){
			str = countries.get(0);
			System.err.println("str--"+str);
			System.err.println("protocols size--"+countries.size());
			for(int i=0;i<countries.size()-1;i++){
				str+= "," + countries.get(i+1);	
				System.err.println("str-"+str);
			}
			point.setStrCountryIds(str);
		}
		else{
			point.setStrCountryIds("");
		}
		point.setNumMeansTransportId(distributionModel.getMeansTransport());
		point.setStrFromTransportCity(distributionModel.getFromCity().trim());
		point.setNumFromTransportCountry(distributionModel.getFromCountry());
		point.setStrToTransportCity(distributionModel.getToCity().trim());
		point.setNumToTransportCountry(distributionModel.getToCountry());
		point.setNumIsValid(1);
		point.setNumTrUserId(UserId);
		point.setDtTrDate(new Date());
		PointOfDistributionMst pointDis = davaDaoServices.savePointOfDistributionMaster(point);
		return pointDis;
	}
	
	public String loadAllPointsOfDistributionDetails(HttpServletRequest request) {
		// TODO Auto-generated method stub
				int amount = 5; /* Amount in Show Entry drop down */
				int start = 0; /* Counter for Paging, initially 0 */
				int echo = 0; /* Maintains the request number, initially 0 */
				int col = 0; /* Column number in the datatable */
				/* Below variables store the options to create the Query */
				
				String dir = "asc";
				int sStart =  0;
				int sAmount =  5000000;
				String sEcho = request.getParameter("sEcho");
				String sCol = request.getParameter("iSortCol_0");
				String sdir = request.getParameter("sSortDir_0");
				
				String individualSearch = "";
				if (request.getParameter("iDisplayStart") != null) {
					start = sStart;
					if (start < 0)
						start = 0;
				}
		 
				/* Total number of records to be fetched */
				if (request.getParameter("iDisplayLength") != null) {
					amount = sAmount;
					if (amount < 5 || amount > 100)
						amount = 5;
				}
		 
				/* Counter of the request sent from Data table */
				if (sEcho != null) {
					echo = Integer.parseInt(sEcho);
				}
		 
				/* Column number */
				if (sCol != null) {
					col = Integer.parseInt(sCol);
					if (col < 0 || col > 5)
						col = 0;
				}
		 
				/* Sorting order */
				if (sdir != null) {
					if (!sdir.equals("asc"))
						dir = "desc";
				}
				String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
				List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
				int instId = userDetails.get(0).getNumInstId();
				
				String searchTerm ="";
				
				String Query = "select num_distribution_id,(select str_generic_name from drug_mst d where d.num_drug_id=p.num_generic_name) str_genric_name, p.num_hs_code, p.num_hs_code || ' ' ||  (select str_commodity_name from hscode_mst hs where p.num_hs_code = hs.num_hscode) as hscode, str_goods_name, str_goods_address, str_goods_city, str_pincode, num_region_id, (select str_region_name from region_mst r where p.num_region_id=r.num_region_id) str_region_name, str_country_ids,dava.country_ids_name( str_country_ids) countryname, case num_means_transport_id when 1 then 'Air' else 'Sea' end as transport, str_from_transport_city, (select str_country_name from country_mst c where c.num_country_id=p.num_from_transport_country) from_transport_country, str_to_transport_city, (select str_country_name from country_mst c where c.num_country_id=p.num_to_transport_country) to_transport_country , num_tr_user_id from point_distribution_mst p where p.num_isvalid=1 and p.num_inst_id="
						+ instId;
				String result = generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
				return result.toString();
	}
	
	public void loadStatisticsFunc() {
		davaDaoServices.loadStatsFunc();
	}
	
	

	
	/*
	 * public void expirelink() { davaDaoServices.expirelink(); }
	 */
	
	@Override
	public List<ReportProblemDomain> getFeedbackResData() {
		List<ReportProblemDomain> getData=davaDaoServices.getFeedbackResData();
		return getData;
	}
	
	public String loadDeletedDrugDetails(HttpServletRequest request) {
		// TODO Auto-generated method stub
				int amount = 5; /* Amount in Show Entry drop down */
				int start = 0; /* Counter for Paging, initially 0 */
				int echo = 0; /* Maintains the request number, initially 0 */
				int col = 0; /* Column number in the datatable */
				/* Below variables store the options to create the Query */
				
				String dir = "asc";
				int sStart =  0;
				int sAmount =  5000000;
				String sEcho = request.getParameter("sEcho");
				String sCol = request.getParameter("iSortCol_0");
				String sdir = request.getParameter("sSortDir_0");
				
				String individualSearch = "";
				if (request.getParameter("iDisplayStart") != null) {
					start = sStart;
					if (start < 0)
						start = 0;
				}
		 
				/* Total number of records to be fetched */
				if (request.getParameter("iDisplayLength") != null) {
					amount = sAmount;
					if (amount < 5 || amount > 100)
						amount = 5;
				}
		 
				/* Counter of the request sent from Data table */
				if (sEcho != null) {
					echo = Integer.parseInt(sEcho);
				}
		 
				/* Column number */
				if (sCol != null) {
					col = Integer.parseInt(sCol);
					if (col < 0 || col > 5)
						col = 0;
				}
		 
				/* Sorting order */
				if (sdir != null) {
					if (!sdir.equals("asc"))
						dir = "desc";
				}
				String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
				List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
				int instId = userDetails.get(0).getNumInstId();
				
				String searchTerm ="";
				
				String Query = "select rownum,num_drug_id,str_manufacturing_unit, nvl(str_generic_name,'NA') str_generic_name, dava.manufacture_units_name( str_manufacturing_unit) manufacturingunit, nvl(dosagename( num_dosage_form),'NA') as str_dosage_name, nvl(drug_typename(num_drug_type),'NA') str_type_name, nvl(str_brand_name,'NA') str_brand_name, nvl(schedulename(num_schedule_id),'NA') as str_schedule_name, nvl(str_strength,'NA') str_strength, nvl(storagecondition (num_storage_condition),'NA') as str_condition_name, nvl(str_composition,'NA') str_composition,d.num_hs_code,d.num_hs_code || ' ' ||  (select str_commodity_name from hscode_mst hs where d.num_hs_code = hs.num_hscode) as hscode,(SELECT str_premises_name||' - '||str_address  from institute_premises_dtl i WHERE i.num_premises_no= d.num_manu_unit_id) premisenameadd, nvl(str_gtin_no,'NA') str_gtin_no from drug_mst d where d.num_isvalid = 0 and d.num_inst_id="
						+ instId;
				String result = generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
				return result.toString();
	}

	public PortOfExportDomain updatePortOfExport(PortOfExportModel portOfExportModel, HttpServletRequest request) {
		PortOfExportDomain port = new PortOfExportDomain();
		port.setNumPortId(portOfExportModel.getPortId());
		port.setStrPortName(portOfExportModel.getPortName().trim());
		port.setStrPortCode(portOfExportModel.getPortCode().trim());
		port.setNumPincode(portOfExportModel.getPincode());
		port.setStrContactNumber(portOfExportModel.getMobileNo());
		port.setStrEmail(portOfExportModel.getEmailId().trim());
		port.setNumCountryId(193);
		port.setNumDistrictId(portOfExportModel.getDistId());
		port.setNumStateId(portOfExportModel.getStateId());
		port.setStrPortAdd(portOfExportModel.getPortAddress());
		port.setNumIsValid(1);
		port.setDtTrDate(new Date());
		port.setNumTrUserId(1001);
		return davaDaoServices.updateExportPort(port);
	}

	public void deletePortOfExport(PortOfExportModel portOfExportModel, HttpServletRequest request) {
		int count = portOfExportModel.getRadio().length;
	    for (int i = 0; i <count; i++) 
	    { 

	    	PortOfExportDomain port = new PortOfExportDomain();
	    	port.setNumPortId(portOfExportModel.getRadio()[i]);
	    	port.setNumIsValid(0);
	    	port.setStrPortName(portOfExportModel.getPortName().trim());
			port.setStrPortCode(portOfExportModel.getPortCode().trim());
			port.setNumPincode(portOfExportModel.getPincode());
			port.setStrContactNumber(portOfExportModel.getMobileNo());
			port.setStrEmail(portOfExportModel.getEmailId().trim());
			port.setNumCountryId(193);
			port.setNumDistrictId(portOfExportModel.getDistId());
			port.setNumStateId(portOfExportModel.getStateId());
			port.setStrPortAdd(portOfExportModel.getPortAddress());
			port.setDtTrDate(new Date());
			port.setNumTrUserId(1001);
	  
			davaDaoServices.updateExportPort(port);
	    }
	}

	public UploadXmlInvoiceDtlDomain updateConsignmentDtls(Integer upId, UploadDataForm uploadData) {
		
		SimpleDateFormat inputFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		List<UploadXmlInvoiceDtlDomain> invDtl = davaTransactions.getInvoiceDetails(upId);
		System.out.println(invDtl.get(0).getNumInvoiceId());
		
		UploadXmlInvoiceDtlDomain inv = new UploadXmlInvoiceDtlDomain();
		
		inv.setNumInvoiceId(invDtl.get(0).getNumInvoiceId());
		inv.setNumInstId(invDtl.get(0).getNumInstId());
		inv.setStrCompanyAddress(invDtl.get(0).getStrCompanyAddress());
		inv.setStrCompanyName(invDtl.get(0).getStrCompanyName());
		inv.setNumTertiaryCount(invDtl.get(0).getNumTertiaryCount());
		inv.setStrSerialType(invDtl.get(0).getStrSerialType());
		inv.setNumUploadId(upId);
		inv.setStrInvoiceNo(uploadData.getEwayBill().trim());
		Date dtDate = null;
		try {
			dtDate = inputFormat2.parse(uploadData.getBillDate());
		}catch(ParseException e) {
			e.printStackTrace();
		}
		inv.setDtInvoiceDate(dtDate);
		inv.setStrRegionCode(uploadData.getExportingRegion());
		inv.setStrCountryOfExp(uploadData.getExportingCountry());
		inv.setStrSourcePortname(uploadData.getPortName());
		inv.setStrLandingPortname(uploadData.getLandingPort());
		inv.setNumIsValid(1);
		inv.setNumTrUserId(1001);
		inv.setDtTrDate(new Date());
		return davaDaoServices.updateConsignDtls(inv);
	}
	
	public String ShowConsignUploadXmlDetails(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int amount = 5; /* Amount in Show Entry drop down */
		int start = 0; /* Counter for Paging, initially 0 */
		int echo = 0; /* Maintains the request number, initially 0 */
		int col = 0; /* Column number in the datatable */
		/* Below variables store the options to create the Query */
		
		String dir = "asc";
		int sStart =  0;
		int sAmount =  5000000;
		String sEcho = request.getParameter("sEcho");
		String sCol = request.getParameter("iSortCol_0");
		String sdir = request.getParameter("sSortDir_0");
		
		String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) {
			start = sStart;
			if (start < 0)
				start = 0;
		}
 
		/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) {
			amount = sAmount;
			if (amount < 5 || amount > 100)
				amount = 5;
		}
 
		/* Counter of the request sent from Data table */
		if (sEcho != null) {
			echo = Integer.parseInt(sEcho);
		}
 
		/* Column number */
		if (sCol != null) {
			col = Integer.parseInt(sCol);
			if (col < 0 || col > 5)
				col = 0;
		}
 
		/* Sorting order */
		if (sdir != null) {
			if (!sdir.equals("asc"))
				dir = "desc";
		}
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		
		String searchTerm ="";
		//String Query="select a.str_remarks,a.str_ackreceipt_filename,a.str_ackreceipt_filepath,u.user_name,i.str_manuf_code,a.str_filename,a.num_document_id,a.num_upload_id,to_char(a.dt_tr_date,'dd-Mon-YYYY')createddate,to_char(a.dt_tr_date,'HH24:MI:ss') createdtime ,a.num_type_id,(select  decode(count(*),0,0,1) exist_flg_con from upload_consig_dtl u where u.num_upload_id = a.num_upload_id),(select  decode(count(*),0,0,1) exist_flg_pur from upload_po_dtl u where u.num_upload_id = a.num_upload_id),(select  decode(count(*),0,0,1) exist_flg_inv from upload_inv_dtl u where u.num_upload_id = a.num_upload_id),a.num_status, case a.num_status when 1 then 'Uploaded Succesfully' when 2 then 'Uploaded Successfuly' else 'Duplicate pack code ,file Not Uploaded Successfuly' end as status, substr(a.error_name,  POSITION( '(' in  a.error_name)) as exact_code ,a.error_name from upload_data_dtl a,user_registration u,institute_mst i where a.num_user_id=u.user_id and a.num_inst_id=i.num_inst_id and a.num_isvalid = 1 and a.num_type_id=3 and num_recall_flag = 0 and a.num_inst_id="+instId;
		String Query="select a.str_remarks,a.str_ackreceipt_filename,a.str_ackreceipt_filepath,u.user_name,i.str_manuf_code,a.str_filename,a.num_document_id,a.num_upload_id,to_char(a.dt_tr_date,'dd-Mon-YYYY')createddate,to_char(a.dt_tr_date,'HH24:MI:ss') createdtime ,a.num_type_id,(select  decode(count(*),0,0,1) exist_flg_con from upload_consig_dtl u where u.num_upload_id = a.num_upload_id),(select  decode(count(*),0,0,1) exist_flg_pur from upload_po_dtl u where u.num_upload_id = a.num_upload_id),(select  decode(count(*),0,0,1) exist_flg_inv from upload_inv_dtl u where u.num_upload_id = a.num_upload_id),a.num_status, case a.num_status when 1 then 'Uploaded Succesfully' when 2 then 'Uploaded Successfuly' else 'Duplicate pack code ,file Not Uploaded Successfuly' end as status, substr(a.error_name,  POSITION( '(' in  a.error_name)) as exact_code ,a.error_name, a.num_verify_by from upload_data_dtl a,user_registration u,institute_mst i where a.num_user_id=u.user_id and a.num_inst_id=i.num_inst_id and a.num_isvalid = 1 and a.num_type_id=3 and num_recall_flag = 0 and a.num_inst_id="+instId;
		
		String result = generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
		return result.toString();
	}

	@Override
	public String saveOfficialRegistration(HostRegistrationForm hostRegForm) {
		
		
		Supplier<Integer> otpGenerator=()->{
			int randomWithMathRandom = 10000 + new Random().nextInt(90000);
			return randomWithMathRandom;
		};
		
		HostRegistrationEntity guestRegEntry=guestRegRepo.findByEmail(hostRegForm.getEmail());
		if(guestRegEntry!=null)
			return "Email id already exist";
		
		
		HostRegistrationEntity gustRegEntity=
				new HostRegistrationEntity();
		gustRegEntity.setName(hostRegForm.getName());
		gustRegEntity.setCountry(hostRegForm.getCountry());
		gustRegEntity.setEmail(hostRegForm.getEmail());
		gustRegEntity.setCity(hostRegForm.getCity());
		gustRegEntity.setActive(false);
		gustRegEntity.setOtp(otpGenerator.get());
		guestRegRepo.save(gustRegEntity);
			
		String subject=emailContent.getEmailContent().get("guestRegistrationOtpSub");
		String content=emailContent.getEmailContent().get("guestRegistrationOtpContent");
		content=content.replaceAll("\\$USER\\_NAME\\$", gustRegEntity.getName());
		content=content.replaceAll("\\$OTP\\$", gustRegEntity.getOtp().toString());
	
		sendmail.sendMailToUser(gustRegEntity.getEmail(), subject, content);
		
		return "successfully added";
	}

	@Override
	public String verifyOtp(HostRegistrationForm hostRegForm) {
		HostRegistrationEntity guestRegEntry=guestRegRepo.findByEmail(hostRegForm.getEmail());
		
		String result="Invalid OTP";
		if(guestRegEntry==null)
			return "Email id does not exist";
		else {
			if(hostRegForm.getOtp().equals(guestRegEntry.getOtp())) {
				result="Success";
				guestRegEntry.setActive(true);
				guestRegRepo.save(guestRegEntry);
			}
		}
		
		return result;
	}

	@Override
	public String resendOtp(String emailId) {
		
		HostRegistrationEntity guestRegEntry=guestRegRepo.findByEmail(emailId);
		
		String result="Failure";
		if(guestRegEntry==null)
			return "Email id does not exist";
		else {
			result="Success";
			String subject=emailContent.getEmailContent().get("guestRegistrationOtpSub");
			String content=emailContent.getEmailContent().get("guestRegistrationOtpContent");
			content=content.replaceAll("\\$USER\\_NAME\\$", guestRegEntry.getName());
			content=content.replaceAll("\\$OTP\\$", guestRegEntry.getOtp().toString());
		
			sendmail.sendMailToUser(guestRegEntry.getEmail(), subject, content);
		}
		
		return result;
	}

	@Override
	public String saveUserAppLogs(AppUserLogsForm appUserLogsForm) {
		AppUserLogs appUserLogs=new AppUserLogs();
		appUserLogs.setEmail(appUserLogsForm.getEmail());
		appUserLogs.setSerialNumber(appUserLogsForm.getSerialNumber());
		appUserLogsRepo.save(appUserLogs);
		return "Success";
	}

	@Override
	public List<AppUserLogs> getAppSearchLogs() {
		List<AppUserLogs> appSearchLogs=appUserLogsRepo.findAll();
		return appSearchLogs;
	}
	
	public UploadConsignDtlDomain addConsignmentDtls(UploadDataForm uploadData, HttpServletRequest request) {
		SimpleDateFormat inputFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		UploadConsignDtlDomain consignDtl = null;
		System.out.println(uploadData.getList_ewayBill().size() + "  ===== uploadData.getList_ewayBill().size()");
		for(int i=0; i<uploadData.getList_ewayBill().size();i++){
			UploadConsignDtlDomain conDtls = new UploadConsignDtlDomain();
			conDtls.setNumUploadId(uploadData.getUploadId());
			conDtls.setNumInstId(instId);
			conDtls.setStrInvNo(uploadData.getList_ewayBill().get(i));
			
			String strBillDateate = uploadData.getList_billDate().get(i);
			Date dtBillate = null;
			try {
				dtBillate = inputFormat2.parse(strBillDateate);
			}catch(ParseException e) {
				e.printStackTrace();
			}
			conDtls.setDtInvDate(dtBillate);
			conDtls.setStrRegionCode(uploadData.getList_exportingRegion().get(i));
			conDtls.setStrExpCountry(uploadData.getList_exportingCountry().get(i));
			conDtls.setStrSourcePortName(uploadData.getList_portName().get(i));
			conDtls.setStrLandingPort(uploadData.getList_landingPort().get(i));
			conDtls.setNumPrimaryCount(Integer.parseInt(uploadData.getList_primaryPacks().get(i)));
			conDtls.setNumS1Count(Integer.parseInt(uploadData.getList_s1packs().get(i)));
			conDtls.setNumS2Count(Integer.parseInt(uploadData.getList_s2packs().get(i)));
			conDtls.setNumS3Count(Integer.parseInt(uploadData.getList_s3packs().get(i)));
			conDtls.setNumTertiaryCount(Integer.parseInt(uploadData.getList_tertiaryPacks().get(i)));
			
			conDtls.setNumIsValid(1);
			conDtls.setDtTrDate(new Date());
			conDtls.setNumTrUserId(1001);
			
			consignDtl = davaDaoServices.addConDetails(conDtls);
		}
		return consignDtl;
	}
	
	public UploadPurchaseOrderDtlDom addPurOrderDtls(UploadDataForm uploadData, HttpServletRequest request) {
		SimpleDateFormat inputFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		UploadPurchaseOrderDtlDom PurchaseDtl = null;
		System.out.println(uploadData.getList_orderNo().size() + "  ===== uploadData.getList_orderNo().size()");
		for(int i=0; i<uploadData.getList_orderNo().size();i++){
			UploadPurchaseOrderDtlDom purDtls = new UploadPurchaseOrderDtlDom();
			purDtls.setNumUploadId(uploadData.getUploadId());
			purDtls.setNumInstId(instId);
			purDtls.setStrPONo(uploadData.getList_orderNo().get(i));
			
			String strOrderDate = uploadData.getList_orderDate().get(i);
			Date dtOrderDate = null;
			try {
				dtOrderDate = inputFormat2.parse(strOrderDate);
			}catch(ParseException e) {
				e.printStackTrace();
			}
			purDtls.setDtPODate(dtOrderDate);
			purDtls.setStrCompanyName(uploadData.getList_companyName().get(i));
			purDtls.setStrCompanyAdd(uploadData.getList_companyAdd().get(i));
			purDtls.setStrCountryName(uploadData.getList_country().get(i));
			
			purDtls.setNumIsValid(1);
			purDtls.setDtTrDate(new Date());
			purDtls.setNumTrUserId(1001);
			
			PurchaseDtl = davaDaoServices.addPODetails(purDtls);
		}
		return PurchaseDtl;
	}
	
	public UploadInvoiceDtlDomain addInvoiceDetails(UploadDataForm uploadData, HttpServletRequest request) {
		SimpleDateFormat inputFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		UploadInvoiceDtlDomain invoiceDtl = null;
		System.out.println(uploadData.getList_invoiceNo().size() + "  ===== uploadData.getList_invoiceNo().size())");
		for(int i=0; i<uploadData.getList_invoiceNo().size();i++){
			UploadInvoiceDtlDomain invDtls = new UploadInvoiceDtlDomain();
			invDtls.setNumUploadId(uploadData.getUploadId());
			invDtls.setNumInstId(instId);
			invDtls.setStrInvNo(uploadData.getList_invoiceNo().get(i));
			
			String strInvDate = uploadData.getList_invoiceDate().get(i);
			Date dtInvDate = null;
			try {
				dtInvDate = inputFormat2.parse(strInvDate);
			}catch(ParseException e) {
				e.printStackTrace();
			}
			invDtls.setDtInvDate(dtInvDate);
			invDtls.setStrPONo(uploadData.getList_purchaseInvNo().get(i));
			
			invDtls.setNumIsValid(1);
			invDtls.setDtTrDate(new Date());
			invDtls.setNumTrUserId(1001);
			
			invoiceDtl = davaDaoServices.addInvoiceDetails(invDtls);
		}
		return invoiceDtl;
	}
	
	public List<UploadXmlDataDtlDomain> getUploadedData(Integer uploadId) {
		
		return davaDaoServices.getuploadedDataDtl(uploadId);
	}
	
	public String ShowAllRegistrationDataListing(HttpServletRequest request, Integer Status) {
		// TODO Auto-generated method stub
		int amount = 5; /* Amount in Show Entry drop down */
		int start = 0; /* Counter for Paging, initially 0 */
		int echo = 0; /* Maintains the request number, initially 0 */
		int col = 0; /* Column number in the datatable */
		/* Below variables store the options to create the Query */
		
		String dir = "asc";
		int sStart =  0;
		int sAmount =  5000000;
		String sEcho = request.getParameter("sEcho");
		String sCol = request.getParameter("iSortCol_0");
		String sdir = request.getParameter("sSortDir_0");
		
		String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) {
			start = sStart;
			if (start < 0)
				start = 0;
		}
 
		/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) {
			amount = sAmount;
			if (amount < 5 || amount > 100)
				amount = 5;
		}
 
		/* Counter of the request sent from Data table */
		if (sEcho != null) {
			echo = Integer.parseInt(sEcho);
		}
 
		/* Column number */
		if (sCol != null) {
			col = Integer.parseInt(sCol);
			if (col < 0 || col > 5)
				col = 0;
		}
 
		/* Sorting order */
		if (sdir != null) {
			if (!sdir.equals("asc"))
				dir = "desc";
		}
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		String searchTerm ="";
		String Query = null;
		if(Status == 5) {
			Query="select user_id, user_name, applicant_type, str_appl_type_name, cont_pers_email, contact_per_desg, to_char(created_date,'dd-Mon-YYYY')createddate , org_address, org_contact_number, case org_country_id when 193 then 'India' else 'NA' end as country, org_dist_id, str_district_name, org_email_id, org_fax_number, org_name, org_pan_number, org_pincode, org_state_id, s.str_state_name, org_type, org_website, str_rcmc_no, ur.num_approval_status_pharmaexil, case ur.num_approval_status_pharmaexil when 0 then 'Pending' when 1 then 'Approved' else 'Rejected' end as pharmstatus from (((user_registration ur JOIN applicant_type_mst a on(ur.applicant_type=a.num_appl_type_id)) JOIN states_mst s on(ur.org_state_id = s.num_state_id)) JOIN district_mst d on (ur.org_dist_id = d.num_district_id))";
		}else {
			Query="select user_id, user_name, applicant_type, str_appl_type_name, cont_pers_email, contact_per_desg, to_char(created_date,'dd-Mon-YYYY')createddate , org_address, org_contact_number, case org_country_id when 193 then 'India' else 'NA' end as country, org_dist_id, str_district_name, org_email_id, org_fax_number, org_name, org_pan_number, org_pincode, org_state_id, s.str_state_name, org_type, org_website, str_rcmc_no, ur.num_approval_status_pharmaexil, case ur.num_approval_status_pharmaexil when 0 then 'Pending' when 1 then 'Approved' else 'Rejected' end as pharmstatus from (((user_registration ur JOIN applicant_type_mst a on(ur.applicant_type=a.num_appl_type_id)) JOIN states_mst s on(ur.org_state_id = s.num_state_id)) JOIN district_mst d on (ur.org_dist_id = d.num_district_id)) where num_approval_status_pharmaexil ="+Status+"";
		}
		
		String result = generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
		return result.toString();
	}
	
	public String ShowAllUploadXmlDetails(HttpServletRequest request, Integer company) {
		// TODO Auto-generated method stub
		int amount = 5; /* Amount in Show Entry drop down */
		int start = 0; /* Counter for Paging, initially 0 */
		int echo = 0; /* Maintains the request number, initially 0 */
		int col = 0; /* Column number in the datatable */
		/* Below variables store the options to create the Query */
		
		String dir = "asc";
		int sStart =  0;
		int sAmount =  5000000;
		String sEcho = request.getParameter("sEcho");
		String sCol = request.getParameter("iSortCol_0");
		String sdir = request.getParameter("sSortDir_0");
		
		String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) {
			start = sStart;
			if (start < 0)
				start = 0;
		}
 
		/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) {
			amount = sAmount;
			if (amount < 5 || amount > 100)
				amount = 5;
		}
 
		/* Counter of the request sent from Data table */
		if (sEcho != null) {
			echo = Integer.parseInt(sEcho);
		}
 
		/* Column number */
		if (sCol != null) {
			col = Integer.parseInt(sCol);
			if (col < 0 || col > 5)
				col = 0;
		}
 
		/* Sorting order */
		if (sdir != null) {
			if (!sdir.equals("asc"))
				dir = "desc";
		}
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		
		String searchTerm ="";
		String Query="";
			if(company == 0) {
				Query="select a.str_remarks,u.user_name,i.str_manuf_code,a.str_filename,a.num_document_id,a.num_upload_id,to_char(a.dt_tr_date,'dd-Mon-YYYY')createddate,to_char(a.dt_tr_date,'HH24:MI:ss') createdtime ,a.num_type_id, u.org_name from upload_data_dtl a,user_registration u,institute_mst i where a.num_user_id=u.user_id and a.num_inst_id=i.num_inst_id and a.num_isvalid = 1 and num_recall_flag = 0 ";
			}else {
				Query="select a.str_remarks,u.user_name,i.str_manuf_code,a.str_filename,a.num_document_id,a.num_upload_id,to_char(a.dt_tr_date,'dd-Mon-YYYY')createddate,to_char(a.dt_tr_date,'HH24:MI:ss') createdtime ,a.num_type_id, u.org_name from upload_data_dtl a,user_registration u,institute_mst i where a.num_user_id=u.user_id and u.user_id="+company+" and a.num_inst_id=i.num_inst_id and a.num_isvalid = 1 and num_recall_flag = 0 ";
			}
		String result = generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
		//System.err.println(result.toString()+"77777");
		return result.toString();
	}
	
	public String ShowAllProductData(HttpServletRequest request, Integer productId, Integer hsCode) {
		// TODO Auto-generated method stub
		int amount = 5; /* Amount in Show Entry drop down */
		int start = 0; /* Counter for Paging, initially 0 */
		int echo = 0; /* Maintains the request number, initially 0 */
		int col = 0; /* Column number in the datatable */
		/* Below variables store the options to create the Query */
		
		String dir = "asc";
		int sStart =  0;
		int sAmount =  5000000;
		String sEcho = request.getParameter("sEcho");
		String sCol = request.getParameter("iSortCol_0");
		String sdir = request.getParameter("sSortDir_0");
		
		String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) {
			start = sStart;
			if (start < 0)
				start = 0;
		}
 
		/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) {
			amount = sAmount;
			if (amount < 5 || amount > 100)
				amount = 5;
		}
 
		/* Counter of the request sent from Data table */
		if (sEcho != null) {
			echo = Integer.parseInt(sEcho);
		}
 
		/* Column number */
		if (sCol != null) {
			col = Integer.parseInt(sCol);
			if (col < 0 || col > 5)
				col = 0;
		}
 
		/* Sorting order */
		if (sdir != null) {
			if (!sdir.equals("asc"))
				dir = "desc";
		}
		
		String searchTerm ="";
		
		String Query  = "select num_drug_id, num_drug_type,str_manufacturing_unit, nvl(str_generic_name,'NA') str_generic_name, dava.manufacture_units_name( str_manufacturing_unit) manufacturingunit, nvl(dosagename( num_dosage_form),'NA') as str_dosage_name, nvl(drug_typename(num_drug_type),'NA') str_type_name, nvl(str_brand_name,'NA') str_brand_name, nvl(schedulename(num_schedule_id),'NA') as str_schedule_name, nvl(str_strength,'NA') str_strength, nvl(storagecondition (num_storage_condition),'NA') as str_condition_name, nvl(str_composition,'NA') str_composition,d.num_hs_code,d.num_hs_code || ' ' ||  (select str_commodity_name from hscode_mst hs where d.num_hs_code = hs.num_hscode) as hscode, nvl(str_gtin_no,'NA') str_gtin_no from drug_mst d where d.num_isvalid = 1 and d.num_drug_type=" +productId+ "and num_hs_code ="+hsCode+"";
			String result = generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
			return result.toString();
	}
	
	@Override
	public List<DesktopConfigDtlDom> findDesktopCongDtls(String userId) {
		Long uId = Long.parseLong(userId);
		return davaDaoServices.getDesktopCongDtls(uId);
	}

	@Override
	public void loadPendingStatus_FeedbackResponses() {
		//List<ReportProblemDomain> getData = davaDao.getFeedbackResData();
		List<ReportProblemDomain> getStatusData = davaDao.getFeedBackStatusData();
		for(int i=0;i<getStatusData.size();i++) {
			System.out.println(getStatusData.get(i).getNumIssueStatus());
			Integer assignStatus = getStatusData.get(i).getNumIssueStatus();
			Integer feedbackId = getStatusData.get(i).getProblem_id();
			ReportProblemDomain dom = new ReportProblemDomain();
			dom.setProblem_id(feedbackId);
			dom.setAddress(getStatusData.get(i).getAddress());
			dom.setCountry_id(getStatusData.get(i).getCountry_id());
			dom.setDesignation(getStatusData.get(i).getDesignation());
			dom.setDoc_id(getStatusData.get(i).getDoc_id());
			dom.setDtTrDate(new Date());
			dom.setEmail_id(getStatusData.get(i).getEmail_id());
            dom.setEntry_date(getStatusData.get(i).getEntry_date());
            dom.setLandline_no(getStatusData.get(i).getLandline_no());
            dom.setMobile(getStatusData.get(i).getMobile());
            dom.setMobile_no(getStatusData.get(i).getMobile_no());
            dom.setNumCdacIssueType(getStatusData.get(i).getNumCdacStatus());
            dom.setNumCdacStatus(getStatusData.get(i).getNumCdacStatus());
           // dom.setNumIssueStatus(getStatusData.get(i).getNumIssueStatus());
            dom.setNumIsValid(getStatusData.get(i).getNumIsValid());
            dom.setNumTrUserId(getStatusData.get(i).getNumTrUserId());
            dom.setOrg_name(getStatusData.get(i).getOrg_name());
            dom.setPincode(getStatusData.get(i).getPincode());
            dom.setProblem(getStatusData.get(i).getProblem());
            dom.setProblem_no(getStatusData.get(i).getProblem_no());
            dom.setReplyStatus(getStatusData.get(i).getReplyStatus());
            dom.setStrAssignedTo(getStatusData.get(i).getStrAssignedTo());
            dom.setStrCdacRemarks(getStatusData.get(i).getStrCdacRemarks());
            dom.setStrReply(getStatusData.get(i).getStrReply());
            dom.setSubject(getStatusData.get(i).getSubject());
            dom.setUser_name(getStatusData.get(i).getUser_name());
			dom.setNumIssueStatus(1);
			davaDaoServices.updatefeedbackresponse(dom);
		}
	
	}
	

	

}
