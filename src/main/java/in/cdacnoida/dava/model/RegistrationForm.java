package in.cdacnoida.dava.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import in.cdacnoida.dava.entities.OtherPromotionCouncilDetails;

public class RegistrationForm {

	private Long userId;

	@NotEmpty(message = "User Name cannot not be null or empty")
	// @Email
	private String userName;

	@NotEmpty(message = "Password cannot not be null or empty")
	// @Pattern(message="Password does not match to the required structure",
	// regexp="^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,10}$")
	private String password;

	private String hashPassword;

	@NotEmpty(message = "Applicant Type cannot not be null or empty")
	private String applicantType;

	@NotEmpty(message = "Corporate Name cannot not be null or empty")
	@Pattern(message = "Please enter a valid Corporate Address Name", regexp = "^[a-zA-Z0-9().\\/,\\s\\-]+$")
	private String orgName;

	/* @NotEmpty(message="Organization Type cannot not be null or empty") */
	private String orgType;

	@NotEmpty(message = "Corporate Address cannot not be null or empty")
	private String orgAddress;

	@NotNull(message = "Corporate Pin code cannot not be null or empty")
	private Integer orgPincode;

	@NotNull(message = "Organization Country cannot be null")
	private Integer orgCountryId;

	@NotNull(message = "Organization State cannot be null")
	private Integer orgStateId;

	@NotNull(message = "Organization District cannot be null")
	private Integer orgDistId;

	/*
	 * @Pattern(message="Please enter a valid Corporate Contact Number",
	 * regexp="^[0-9\\-]+$")
	 */
	private String orgContactNumber;

	/*
	 * @Pattern(message="Please enter valid Corporate Fax Number",regexp=
	 * "^[a-zA-Z0-9().\\/,\\+\\-]+$")
	 */
	private String orgFaxNumber;

	@Email(message = "please enter only one email id in Corporate details")
	private String orgEmailId;

	@NotNull
	// @Pattern(message="PAN Number does not match to the required structure",
	// regexp="^([a-zA-Z]){5}([0-9]){4}([a-zA-Z]){1}?$")
	private String orgPanNumber;

	@NotNull(message = "GSTN cannot be null")
	private String gstnumber;

	/*
	 * @Pattern(message="Please enter a valid Corporate website address",regexp=
	 * "^[a-zA-Z0-9().\\/,\\s\\-\\//\\:]+$")
	 */
	private String orgWebsite;

	private String manfSiteName;

	private String manfSiteAddress;

	private Integer manfSitePincode;

	private Integer manfStateId;

	private Integer manfCountryId;

	private Integer manfDistId;

	private String manfSiteCity;

	private String manfSiteContactNumber;

	private String manfSiteFaxNumber;

	private String manfLicNumber;

	private Integer numInstId;

	@NotEmpty(message = "IEC Number cannot not be null or empty")
	@Pattern(message = "Please enter a valid IEC Number", regexp = "^[a-zA-Z0-9().\\/,\\s\\-]+$")
	private String iecNumber;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date iecIssueDate;

	// Govind 080923

	@DateTimeFormat(pattern = "yyyy-MM-dd-HH-mm-ss")
	private LocalDateTime expirationTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd-HH-mm-ss")
	private LocalDateTime resendVerificationTime;
	
	private Integer addressProffId;	
	
	private Integer drugLicenseId;

	public Integer getAddressProffId() {
		return addressProffId;
	}

	public void setAddressProffId(Integer addressProffId) {
		this.addressProffId = addressProffId;
	}

	public Integer getDrugLicenseId() {
		return drugLicenseId;
	}

	public void setDrugLicenseId(Integer drugLicenseId) {
		this.drugLicenseId = drugLicenseId;
	}

	public LocalDateTime getResendVerificationTime() {
		return resendVerificationTime;
	}

	public void setResendVerificationTime(LocalDateTime resendVerificationTime) {
		this.resendVerificationTime = resendVerificationTime;
	}
	

	@NotEmpty(message = "IEC Issue Authority cannot not be null or empty")
	@Pattern(message = "Please enter a valid IEC issuing authoriyt", regexp = "^[a-zA-Z0-9().\\/,\\s\\-]+$")
	private String iecIssueAuthority;

	/*
	 * @Pattern(message="Please enter a valid SSI number",
	 * regexp="^[a-zA-Z0-9().\\/,\\s\\-]+$")
	 */
	private String ssiNumber;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ssiIssueDate;

	private String ssiType;

	@NotEmpty(message = "Contact Person Name cannot not be null or empty")
	@Pattern(message = "Please enter a valid Contact Person Name", regexp = "^[a-zA-Z0-9().\\/,\\s\\-]+$")
	private String contactPersonName;

	@NotEmpty(message = "Contact Person Designation cannot not be null or empty")
	@Pattern(message = "Please enter a valid Contact Person Designation", regexp = "^[a-zA-Z0-9().\\/,\\s\\-]+$")
	private String contactPerDesg;

	@NotEmpty(message = "Contact Person mobile number cannot not be null or empty")
	@Pattern(message = "Please enter a valid Contact Person Number", regexp = "^[0-9\\-]{10,15}+$")
	private String contPerMobileNo;

	@NotEmpty(message = "Contact Person Email Id cannot not be null or empty")
	@Email(message = "please enter only one email id in Contact Person details")
	private String contPersEmail;

	private Integer rcmcStatus;

	@NotNull(message = "Captcha cannot not be null or empty")
	private String regCaptcha;

	private Integer randomCode;

	private Integer emailStatus;

	private Integer numIsValied;

	private Integer finalApprovalStatus;

	private int numUserTypeId;
	private int numRcmcFlag;
	private String str_rcmc_fieo_no;

	private String registeredWithRcmc;
	private String rcmcNumber;
	private String memberOfOtherExportPromotionCouncil;
	
	private String categoryDropdown;
	
	private String orgDropdown;
	
	private String rcmcOfFieo;

	int manuUnit;
	Long userManuId;

	@Pattern(message = "Please enter a valid Reason", regexp = "^[a-zA-Z0-9().\\/,\\s\\-]+$")
	String strReason;

	private String gsOne;

	private String[] promotionCouncil = {};
	private String[] registrationNumber = {};

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date[] validityDuration = {};
	private MultipartFile addressProofFile;
	private MultipartFile drugLicence;
	private String emailVerificationLink;

	private String oldPassword;

	// added by harshita on 140723
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	// added by harshita on 100823
	private String new_key;

	public String getNew_key() {
		return new_key;
	}

	public void setNew_key(String new_key) {
		this.new_key = new_key;
	}

	private Integer numTrUserId;
	private Date dtTrDate;
	private Integer numPremisesNo;
	private String publicKey;
	private List<OtherPromotionCouncilDetails> otherPromotionCouncilDetails;
	private String roleId;
	private String roleName;

	private String empName;
	private String empNo;
	private String empEmailId;
	private String gender;
	private String empDesg;
	private String empMobileNo;
	private String locationName;
	private String locationShortName;
	private String locationAddress;
	private Integer locCountryId;
	private Integer locZoneId;
	private Integer locStateId;
	private Integer locDistId;
	private String locFaxNumber;
	private String locPinCode;

	private String locContactNumber;
	private String locEmailId;
	private String locWebsiteLink;
	private String filename;

	private MultipartFile uploadfile;

	public MultipartFile getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(MultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getLocContactNumber() {
		return locContactNumber;
	}

	public void setLocContactNumber(String locContactNumber) {
		this.locContactNumber = locContactNumber;
	}

	public String getLocEmailId() {
		return locEmailId;
	}

	public void setLocEmailId(String locEmailId) {
		this.locEmailId = locEmailId;
	}

	public String getLocWebsiteLink() {
		return locWebsiteLink;
	}

	public void setLocWebsiteLink(String locWebsiteLink) {
		this.locWebsiteLink = locWebsiteLink;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpEmailId() {
		return empEmailId;
	}

	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmpDesg() {
		return empDesg;
	}

	public void setEmpDesg(String empDesg) {
		this.empDesg = empDesg;
	}

	public String getEmpMobileNo() {
		return empMobileNo;
	}

	public void setEmpMobileNo(String empMobileNo) {
		this.empMobileNo = empMobileNo;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationShortName() {
		return locationShortName;
	}

	public void setLocationShortName(String locationShortName) {
		this.locationShortName = locationShortName;
	}

	public String getLocationAddress() {
		return locationAddress;
	}

	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}

	public Integer getLocCountryId() {
		return locCountryId;
	}

	public void setLocCountryId(Integer locCountryId) {
		this.locCountryId = locCountryId;
	}

	public Integer getLocZoneId() {
		return locZoneId;
	}

	public void setLocZoneId(Integer locZoneId) {
		this.locZoneId = locZoneId;
	}

	public Integer getLocStateId() {
		return locStateId;
	}

	public void setLocStateId(Integer locStateId) {
		this.locStateId = locStateId;
	}

	public Integer getLocDistId() {
		return locDistId;
	}

	public void setLocDistId(Integer locDistId) {
		this.locDistId = locDistId;
	}

	public String getLocFaxNumber() {
		return locFaxNumber;
	}

	public void setLocFaxNumber(String locFaxNumber) {
		this.locFaxNumber = locFaxNumber;
	}

	public String getLocPinCode() {
		return locPinCode;
	}

	public void setLocPinCode(String locPinCode) {
		this.locPinCode = locPinCode;
	}

	public Integer getNumTrUserId() {
		return numTrUserId;
	}

	public void setNumTrUserId(Integer numTrUserId) {
		this.numTrUserId = numTrUserId;
	}

	public Date getDtTrDate() {
		return dtTrDate;
	}

	public void setDtTrDate(Date dtTrDate) {
		this.dtTrDate = dtTrDate;
	}

	public Integer getNumPremisesNo() {
		return numPremisesNo;
	}

	public void setNumPremisesNo(Integer numPremisesNo) {
		this.numPremisesNo = numPremisesNo;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public List<OtherPromotionCouncilDetails> getOtherPromotionCouncilDetails() {
		return otherPromotionCouncilDetails;
	}

	public void setOtherPromotionCouncilDetails(List<OtherPromotionCouncilDetails> otherPromotionCouncilDetails) {
		this.otherPromotionCouncilDetails = otherPromotionCouncilDetails;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getApplicantType() {
		return applicantType;
	}

	public void setApplicantType(String applicantType) {
		this.applicantType = applicantType;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getOrgAddress() {
		return orgAddress;
	}

	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}

	public Integer getOrgPincode() {
		return orgPincode;
	}

	public void setOrgPincode(Integer orgPincode) {
		this.orgPincode = orgPincode;
	}

	public Integer getOrgStateId() {
		return orgStateId;
	}

	public void setOrgStateId(Integer orgStateId) {
		this.orgStateId = orgStateId;
	}

	public Integer getOrgDistId() {
		return orgDistId;
	}

	public void setOrgDistId(Integer orgDistId) {
		this.orgDistId = orgDistId;
	}

	public String getOrgContactNumber() {
		return orgContactNumber;
	}

	public void setOrgContactNumber(String orgContactNumber) {
		this.orgContactNumber = orgContactNumber;
	}

	public String getOrgFaxNumber() {
		return orgFaxNumber;
	}

	public void setOrgFaxNumber(String orgFaxNumber) {
		this.orgFaxNumber = orgFaxNumber;
	}

	public String getOrgEmailId() {
		return orgEmailId;
	}

	public void setOrgEmailId(String orgEmailId) {
		this.orgEmailId = orgEmailId;
	}

	public String getOrgPanNumber() {
		return orgPanNumber;
	}

	public void setOrgPanNumber(String orgPanNumber) {
		this.orgPanNumber = orgPanNumber;
	}

	public String getOrgWebsite() {
		return orgWebsite;
	}

	public void setOrgWebsite(String orgWebsite) {
		this.orgWebsite = orgWebsite;
	}

	public String getManfSiteName() {
		return manfSiteName;
	}

	public void setManfSiteName(String manfSiteName) {
		this.manfSiteName = manfSiteName;
	}

	public String getManfSiteAddress() {
		return manfSiteAddress;
	}

	public void setManfSiteAddress(String manfSiteAddress) {
		this.manfSiteAddress = manfSiteAddress;
	}

	public Integer getManfSitePincode() {
		return manfSitePincode;
	}

	public void setManfSitePincode(Integer manfSitePincode) {
		this.manfSitePincode = manfSitePincode;
	}

	public Integer getManfStateId() {
		return manfStateId;
	}

	public void setManfStateId(Integer manfStateId) {
		this.manfStateId = manfStateId;
	}

	public Integer getManfDistId() {
		return manfDistId;
	}

	public void setManfDistId(Integer manfDistId) {
		this.manfDistId = manfDistId;
	}

	public String getManfSiteCity() {
		return manfSiteCity;
	}

	public void setManfSiteCity(String manfSiteCity) {
		this.manfSiteCity = manfSiteCity;
	}

	public String getManfSiteContactNumber() {
		return manfSiteContactNumber;
	}

	public void setManfSiteContactNumber(String manfSiteContactNumber) {
		this.manfSiteContactNumber = manfSiteContactNumber;
	}

	public String getManfSiteFaxNumber() {
		return manfSiteFaxNumber;
	}

	public void setManfSiteFaxNumber(String manfSiteFaxNumber) {
		this.manfSiteFaxNumber = manfSiteFaxNumber;
	}

	public String getManfLicNumber() {
		return manfLicNumber;
	}

	public void setManfLicNumber(String manfLicNumber) {
		this.manfLicNumber = manfLicNumber;
	}

	public String getIecNumber() {
		return iecNumber;
	}

	public void setIecNumber(String iecNumber) {
		this.iecNumber = iecNumber;
	}

	public String getIecIssueAuthority() {
		return iecIssueAuthority;
	}

	public void setIecIssueAuthority(String iecIssueAuthority) {
		this.iecIssueAuthority = iecIssueAuthority;
	}

	public String getSsiNumber() {
		return ssiNumber;
	}

	public void setSsiNumber(String ssiNumber) {
		this.ssiNumber = ssiNumber;
	}

	public Date getIecIssueDate() {
		return iecIssueDate;
	}

	public void setIecIssueDate(Date iecIssueDate) {
		this.iecIssueDate = iecIssueDate;
	}

	public Date getSsiIssueDate() {
		return ssiIssueDate;
	}

	public void setSsiIssueDate(Date ssiIssueDate) {
		this.ssiIssueDate = ssiIssueDate;
	}

	public String getSsiType() {
		return ssiType;
	}

	public void setSsiType(String ssiType) {
		this.ssiType = ssiType;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getContactPerDesg() {
		return contactPerDesg;
	}

	public void setContactPerDesg(String contactPerDesg) {
		this.contactPerDesg = contactPerDesg;
	}

	public String getContPerMobileNo() {
		return contPerMobileNo;
	}

	public void setContPerMobileNo(String contPerMobileNo) {
		this.contPerMobileNo = contPerMobileNo;
	}

	public String getContPersEmail() {
		return contPersEmail;
	}

	public void setContPersEmail(String contPersEmail) {
		this.contPersEmail = contPersEmail;
	}

	public Integer getRcmcStatus() {
		return rcmcStatus;
	}

	public void setRcmcStatus(Integer rcmcStatus) {
		this.rcmcStatus = rcmcStatus;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHashPassword() {
		return hashPassword;
	}

	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}

	public Integer getOrgCountryId() {
		return orgCountryId;
	}

	public void setOrgCountryId(Integer orgCountryId) {
		this.orgCountryId = orgCountryId;
	}

	public Integer getManfCountryId() {
		return manfCountryId;
	}

	public void setManfCountryId(Integer manfCountryId) {
		this.manfCountryId = manfCountryId;
	}

	public String getRegCaptcha() {
		return regCaptcha;
	}

	public void setRegCaptcha(String regCaptcha) {
		this.regCaptcha = regCaptcha;
	}

	public Integer getRandomCode() {
		return randomCode;
	}

	public void setRandomCode(Integer randomCode) {
		this.randomCode = randomCode;
	}

	public Integer getEmailStatus() {
		return emailStatus;
	}

	public void setEmailStatus(Integer emailStatus) {
		this.emailStatus = emailStatus;
	}

	public Integer getFinalApprovalStatus() {
		return finalApprovalStatus;
	}

	public void setFinalApprovalStatus(Integer finalApprovalStatus) {
		this.finalApprovalStatus = finalApprovalStatus;
	}

	public int getNumUserTypeId() {
		return numUserTypeId;
	}

	public void setNumUserTypeId(int numUserTypeId) {
		this.numUserTypeId = numUserTypeId;
	}

	public int getNumRcmcFlag() {
		return numRcmcFlag;
	}

	public void setNumRcmcFlag(int numRcmcFlag) {
		this.numRcmcFlag = numRcmcFlag;
	}

	public String getRegisteredWithRcmc() {
		return registeredWithRcmc;
	}

	public void setRegisteredWithRcmc(String registeredWithRcmc) {
		this.registeredWithRcmc = registeredWithRcmc;
	}

	public String getRcmcNumber() {
		return rcmcNumber;
	}

	public void setRcmcNumber(String rcmcNumber) {
		this.rcmcNumber = rcmcNumber;
	}

	public String getMemberOfOtherExportPromotionCouncil() {
		return memberOfOtherExportPromotionCouncil;
	}

	public void setMemberOfOtherExportPromotionCouncil(String memberOfOtherExportPromotionCouncil) {
		this.memberOfOtherExportPromotionCouncil = memberOfOtherExportPromotionCouncil;
	}

	public String getRcmcOfFieo() {
		return rcmcOfFieo;
	}

	public void setRcmcOfFieo(String rcmcOfFieo) {
		this.rcmcOfFieo = rcmcOfFieo;
	}

	public int getManuUnit() {
		return manuUnit;
	}

	public void setManuUnit(int manuUnit) {
		this.manuUnit = manuUnit;
	}

	public Long getUserManuId() {
		return userManuId;
	}

	public void setUserManuId(Long userManuId) {
		this.userManuId = userManuId;
	}

	public Integer getNumInstId() {
		return numInstId;
	}

	public void setNumInstId(Integer numInstId) {
		this.numInstId = numInstId;
	}

	public String getStr_rcmc_fieo_no() {
		return str_rcmc_fieo_no;
	}

	public void setStr_rcmc_fieo_no(String str_rcmc_fieo_no) {
		this.str_rcmc_fieo_no = str_rcmc_fieo_no;
	}

	public String getStrReason() {
		return strReason;
	}

	public void setStrReason(String strReason) {
		this.strReason = strReason;
	}

	public String[] getPromotionCouncil() {
		return promotionCouncil;
	}

	public void setPromotionCouncil(String[] promotionCouncil) {
		this.promotionCouncil = promotionCouncil;
	}

	public String[] getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String[] registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Date[] getValidityDuration() {
		return validityDuration;
	}

	public void setValidityDuration(Date[] validityDuration) {
		this.validityDuration = validityDuration;
	}

	public MultipartFile getAddressProofFile() {
		return addressProofFile;
	}

	public void setAddressProofFile(MultipartFile addressProofFile) {
		this.addressProofFile = addressProofFile;
	}

	public MultipartFile getDrugLicence() {
		return drugLicence;
	}

	public void setDrugLicence(MultipartFile drugLicence) {
		this.drugLicence = drugLicence;
	}

	public String getEmailVerificationLink() {
		return emailVerificationLink;
	}

	public void setEmailVerificationLink(String emailVerificationLink) {
		this.emailVerificationLink = emailVerificationLink;
	}

	public String getGstnumber() {
		return gstnumber;
	}

	public void setGstnumber(String gstnumber) {
		this.gstnumber = gstnumber;
	}

	public String getGsOne() {
		return gsOne;
	}

	public void setGsOne(String gsOne) {
		this.gsOne = gsOne;
	}

	public Integer getNumIsValied() {
		return numIsValied;
	}

	public void setNumIsValied(Integer numIsValied) {
		this.numIsValied = numIsValied;
	}

	int numAddDocId;
	String strAddDocId;

	int numDrugDocId;
	String strDrugDocId;

	public int getNumDrugDocId() {
		return numDrugDocId;
	}

	public void setNumDrugDocId(int numDrugDocId) {
		this.numDrugDocId = numDrugDocId;
	}

	public String getStrDrugDocId() {
		return strDrugDocId;
	}

	public void setStrDrugDocId(String strDrugDocId) {
		this.strDrugDocId = strDrugDocId;
	}

	public int getNumAddDocId() {
		return numAddDocId;
	}

	public void setNumAddDocId(int numAddDocId) {
		this.numAddDocId = numAddDocId;
	}

	public String getStrAddDocId() {
		return strAddDocId;
	}

	public void setStrAddDocId(String strAddDocId) {
		this.strAddDocId = strAddDocId;
	}

	int numDocId;
	String strDocId;

	public int getNumDocId() {
		return numDocId;
	}

	public void setNumDocId(int numDocId) {
		this.numDocId = numDocId;
	}

	public String getStrDocId() {
		return strDocId;
	}

	public void setStrDocId(String strDocId) {
		this.strDocId = strDocId;
	}

	private String hppGeneratedData;
	private String hashValue;

	private String hppGeneratedData2;

	private String hashValue2;

	public String getHppGeneratedData2() {
		return hppGeneratedData2;
	}

	public void setHppGeneratedData2(String hppGeneratedData2) {
		this.hppGeneratedData2 = hppGeneratedData2;
	}

	public String getHashValue2() {
		return hashValue2;
	}

	public void setHashValue2(String hashValue2) {
		this.hashValue2 = hashValue2;
	}

	public String getHashValue() {
		return hashValue;
	}

	public void setHashValue(String hashValue) {
		this.hashValue = hashValue;
	}

	public String getHppGeneratedData() {
		return hppGeneratedData;
	}

	public void setHppGeneratedData(String hppGeneratedData) {
		this.hppGeneratedData = hppGeneratedData;
	}

	// Govind 080923
	public LocalDateTime getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(LocalDateTime expirationTime) {
		this.expirationTime = expirationTime;
	}

	private String enProdType;
	private String enHscodeId;
	private String enHSCode;
	private String status;
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEnHSCode() {
		return enHSCode;
	}

	public void setEnHSCode(String enHSCode) {
		this.enHSCode = enHSCode;
	}

	public String getEnProdType() {
		return enProdType;
	}

	public void setEnProdType(String enProdType) {
		this.enProdType = enProdType;
	}

	public String getEnHscodeId() {
		return enHscodeId;
	}

	public void setEnHscodeId(String enHscodeId) {
		this.enHscodeId = enHscodeId;
	}

	public String getCategoryDropdown() {
		return categoryDropdown;
	}

	public void setCategoryDropdown(String categoryDropdown) {
		this.categoryDropdown = categoryDropdown;
	}

	public String getOrgDropdown() {
		return orgDropdown;
	}

	public void setOrgDropdown(String orgDropdown) {
		this.orgDropdown = orgDropdown;
	}

	int fileType;
	String ENdoc_id;

	public int getFileType() {
		return fileType;
	}

	public void setFileType(int fileType) {
		this.fileType = fileType;
	}

	public String getENdoc_id() {
		return ENdoc_id;
	}

	public void setENdoc_id(String eNdoc_id) {
		ENdoc_id = eNdoc_id;
	}

	
	
	
}
