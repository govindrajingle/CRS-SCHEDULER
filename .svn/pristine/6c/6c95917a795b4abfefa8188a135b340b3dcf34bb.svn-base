package in.cdacnoida.dava.model;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import in.cdacnoida.dava.misc.ValidationGroups.ManufacturingSiteDetails;

public class MemberAddDtlModel {
	
	int numPremiseNo;
	@NotNull(message="This Site Type is required and cannot be empty", groups={ManufacturingSiteDetails.class})
	Integer siteType;
	@NotEmpty(message="This Premise Name is required and cannot be empty", groups={ManufacturingSiteDetails.class})
	@Size(min=1, max=100,message="This Premise Name can contain maximum of 100 characters", groups={ManufacturingSiteDetails.class})
	@Pattern(regexp="^[a-zA-Z0-9.,\\-\\/\\s +&()]+$",message="Premise Name can consist of alphabets, numbers and special characters( /,()-.+&) and white spaces are permitted",groups={ManufacturingSiteDetails.class})
	String premiseName;
	@NotEmpty(message="This Premise Address is required and cannot be empty", groups={ManufacturingSiteDetails.class})
	@Size(min=1, max=250,message="This Premise Address can contain maximum of 250 characters", groups={ManufacturingSiteDetails.class})
	@Pattern(regexp="^[a-zA-Z0-9.,\\-\\/\\s +&()]+$",message="Premise Address can consist of alphabets, numbers and special characters( /,()-.+&) and white spaces are permitted",groups={ManufacturingSiteDetails.class})
	String premiseAddress;
	@NotNull(message="This State is required and cannot be empty", groups={ManufacturingSiteDetails.class})
	int stateId;
	@NotNull(message="This District is required and cannot be empty", groups={ManufacturingSiteDetails.class})
	int districtId;
	@NotNull(message="This Pincode is required and cannot be empty", groups={ManufacturingSiteDetails.class})
	int pinCode;
	@NotEmpty(message="This Contact Number is required and cannot be empty", groups={ManufacturingSiteDetails.class})
	@Size(min=6, max=20,message="This Contact Number can contain maximum of 20 characters", groups={ManufacturingSiteDetails.class})
	@Pattern(regexp="^[a-zA-Z0-9.,\\-\\/\\s +&()]+$",message="Contact Number can consist of numbers are permitted",groups={ManufacturingSiteDetails.class})
	String contactNumber;
	
	String faxNumber;
	@NotEmpty(message="Email cannot not be null or empty")
	@Email
	String emailId;
	String gstin;
	
	String gs1;
	@NotEmpty(message="This Contact Person name is required and cannot be empty", groups={ManufacturingSiteDetails.class})
	@Size(min=1, max=50,message="This Contact Person name can contain maximum of 50 characters", groups={ManufacturingSiteDetails.class})
	@Pattern(regexp="^[a-zA-Z0-9.,\\-\\/\\s +&()]+$",message="Contact Person name can consist of alphabets, numbers and special characters( /,()-.+&) and white spaces are permitted",groups={ManufacturingSiteDetails.class})
	String contactPersonName;
	@NotEmpty(message="This Contact Person Number is required and cannot be empty", groups={ManufacturingSiteDetails.class})
	@Size(min=10, max=10,message="This Contact Person Number can contain 10 digits", groups={ManufacturingSiteDetails.class})
	@Pattern(regexp="^[a-zA-Z0-9.,\\-\\/\\s +&()]+$",message="Contact Person Number can consist of alphabets, numbers and special characters( /,()-.+&) and white spaces are permitted",groups={ManufacturingSiteDetails.class})
	String contPerMobileNo;
	@NotEmpty(message="This Contact Person Designation is required and cannot be empty", groups={ManufacturingSiteDetails.class})
	@Size(min=1, max=20,message="This Contact Person Designation can contain maximum of 20 characters", groups={ManufacturingSiteDetails.class})
	@Pattern(regexp="^[a-zA-Z0-9.,\\-\\/\\s +&()]+$",message="Contact Person Designation can consist of alphabets, numbers and special characters( /,()-.+&) and white spaces are permitted",groups={ManufacturingSiteDetails.class})
	String contactPerDesg;
	@NotEmpty(message="Email cannot not be null or empty")
	@Email
	String contPersEmail;
	
	int numLicenseNo;
	
	int licType;
	
	String licNo;
	
	String fromDate;
	
	String toDate;
	
	String issueAuth;
	
	String addedList_str;
	
	List<Integer> list_licType ;
	List<String> list_licNo ;
	List<String> list_fromDate ;
	List<String> list_toDate ;
	List<String> list_issueAuth ;
	
	int approvalType;
	String strAppType;
	String approvalNo;
	String appFromDate;
	String appToDate;
	String appIssueAuth;
	String appAddedList_str;
	
	List<Integer> list_approvalType;
	List<String> list_strAppType;
	List<String> list_approvalNo;
	List<String> list_appFromDate;
	List<String> list_appToDate;
	List<String> list_appIssueAuth;
	
	int numDrugDocId;
	String hppGeneratedData2;
	String hashValue2;
	String strDrugDocId;
	private MultipartFile drugLicenceMF;
	
	
	String gln;
	
	String appTypeRemarks;
	
	public int getNumPremiseNo() {
		return numPremiseNo;
	}
	public void setNumPremiseNo(int numPremiseNo) {
		this.numPremiseNo = numPremiseNo;
	}
	public Integer getSiteType() {
		return siteType;
	}
	public void setSiteType(Integer siteType) {
		this.siteType = siteType;
	}
	public String getPremiseName() {
		return premiseName;
	}
	public void setPremiseName(String premiseName) {
		this.premiseName = premiseName;
	}
	public String getPremiseAddress() {
		return premiseAddress;
	}
	public void setPremiseAddress(String premiseAddress) {
		this.premiseAddress = premiseAddress;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public int getDistrictId() {
		return districtId;
	}
	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getFaxNumber() {
		return faxNumber;
	}
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getGstin() {
		return gstin;
	}
	public void setGstin(String gstin) {
		this.gstin = gstin;
	}
	public String getGs1() {
		return gs1;
	}
	public void setGs1(String gs1) {
		this.gs1 = gs1;
	}
	public String getContactPersonName() {
		return contactPersonName;
	}
	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}
	public String getContPerMobileNo() {
		return contPerMobileNo;
	}
	public void setContPerMobileNo(String contPerMobileNo) {
		this.contPerMobileNo = contPerMobileNo;
	}
	public String getContactPerDesg() {
		return contactPerDesg;
	}
	public void setContactPerDesg(String contactPerDesg) {
		this.contactPerDesg = contactPerDesg;
	}
	public String getContPersEmail() {
		return contPersEmail;
	}
	public void setContPersEmail(String contPersEmail) {
		this.contPersEmail = contPersEmail;
	}
	public int getLicType() {
		return licType;
	}
	public void setLicType(int licType) {
		this.licType = licType;
	}
	public String getLicNo() {
		return licNo;
	}
	public void setLicNo(String licNo) {
		this.licNo = licNo;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getIssueAuth() {
		return issueAuth;
	}
	public void setIssueAuth(String issueAuth) {
		this.issueAuth = issueAuth;
	}
	public List<Integer> getList_licType() {
		return list_licType;
	}
	public void setList_licType(List<Integer> list_licType) {
		this.list_licType = list_licType;
	}
	public List<String> getList_licNo() {
		return list_licNo;
	}
	public void setList_licNo(List<String> list_licNo) {
		this.list_licNo = list_licNo;
	}
	public List<String> getList_fromDate() {
		return list_fromDate;
	}
	public void setList_fromDate(List<String> list_fromDate) {
		this.list_fromDate = list_fromDate;
	}
	public List<String> getList_toDate() {
		return list_toDate;
	}
	public void setList_toDate(List<String> list_toDate) {
		this.list_toDate = list_toDate;
	}
	public List<String> getList_issueAuth() {
		return list_issueAuth;
	}
	public void setList_issueAuth(List<String> list_issueAuth) {
		this.list_issueAuth = list_issueAuth;
	}
	public int getNumLicenseNo() {
		return numLicenseNo;
	}
	public void setNumLicenseNo(int numLicenseNo) {
		this.numLicenseNo = numLicenseNo;
	}
	public String getAddedList_str() {
		return addedList_str;
	}
	public void setAddedList_str(String addedList_str) {
		this.addedList_str = addedList_str;
	}
	public int getApprovalType() {
		return approvalType;
	}
	public void setApprovalType(int approvalType) {
		this.approvalType = approvalType;
	}
	public String getApprovalNo() {
		return approvalNo;
	}
	public void setApprovalNo(String approvalNo) {
		this.approvalNo = approvalNo;
	}
	public String getAppFromDate() {
		return appFromDate;
	}
	public void setAppFromDate(String appFromDate) {
		this.appFromDate = appFromDate;
	}
	public String getAppToDate() {
		return appToDate;
	}
	public void setAppToDate(String appToDate) {
		this.appToDate = appToDate;
	}
	public String getAppIssueAuth() {
		return appIssueAuth;
	}
	public void setAppIssueAuth(String appIssueAuth) {
		this.appIssueAuth = appIssueAuth;
	}
	public String getAppAddedList_str() {
		return appAddedList_str;
	}
	public void setAppAddedList_str(String appAddedList_str) {
		this.appAddedList_str = appAddedList_str;
	}
	public List<Integer> getList_approvalType() {
		return list_approvalType;
	}
	public void setList_approvalType(List<Integer> list_approvalType) {
		this.list_approvalType = list_approvalType;
	}
	public List<String> getList_approvalNo() {
		return list_approvalNo;
	}
	public void setList_approvalNo(List<String> list_approvalNo) {
		this.list_approvalNo = list_approvalNo;
	}
	public List<String> getList_appFromDate() {
		return list_appFromDate;
	}
	public void setList_appFromDate(List<String> list_appFromDate) {
		this.list_appFromDate = list_appFromDate;
	}
	public List<String> getList_appToDate() {
		return list_appToDate;
	}
	public void setList_appToDate(List<String> list_appToDate) {
		this.list_appToDate = list_appToDate;
	}
	public List<String> getList_appIssueAuth() {
		return list_appIssueAuth;
	}
	public void setList_appIssueAuth(List<String> list_appIssueAuth) {
		this.list_appIssueAuth = list_appIssueAuth;
	}
	public String getGln() {
		return gln;
	}
	public void setGln(String gln) {
		this.gln = gln;
	}
	public String getStrAppType() {
		return strAppType;
	}
	public void setStrAppType(String strAppType) {
		this.strAppType = strAppType;
	}
	public List<String> getList_strAppType() {
		return list_strAppType;
	}
	public void setList_strAppType(List<String> list_strAppType) {
		this.list_strAppType = list_strAppType;
	}
	public String getAppTypeRemarks() {
		return appTypeRemarks;
	}
	public void setAppTypeRemarks(String appTypeRemarks) {
		this.appTypeRemarks = appTypeRemarks;
	}
	
	public int getNumDrugDocId() {
		return numDrugDocId;
	}
	public void setNumDrugDocId(int numDrugDocId) {
		this.numDrugDocId = numDrugDocId;
	}
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
	public String getStrDrugDocId() {
		return strDrugDocId;
	}
	public void setStrDrugDocId(String strDrugDocId) {
		this.strDrugDocId = strDrugDocId;
	}
	public MultipartFile getDrugLicenceMF() {
		return drugLicenceMF;
	}
	public void setDrugLicenceMF(MultipartFile drugLicenceMF) {
		this.drugLicenceMF = drugLicenceMF;
	}
	@Override
	public String toString() {
		return "MemberAddDtlModel [numPremiseNo=" + numPremiseNo + ", siteType=" + siteType + ", premiseName="
				+ premiseName + ", premiseAddress=" + premiseAddress + ", stateId=" + stateId + ", districtId="
				+ districtId + ", pinCode=" + pinCode + ", contactNumber=" + contactNumber + ", faxNumber=" + faxNumber
				+ ", emailId=" + emailId + ", gstin=" + gstin + ", gs1=" + gs1 + ", contactPersonName="
				+ contactPersonName + ", contPerMobileNo=" + contPerMobileNo + ", contactPerDesg=" + contactPerDesg
				+ ", contPersEmail=" + contPersEmail + ", numLicenseNo=" + numLicenseNo + ", licType=" + licType
				+ ", licNo=" + licNo + ", fromDate=" + fromDate + ", toDate=" + toDate + ", issueAuth=" + issueAuth
				+ ", addedList_str=" + addedList_str + ", list_licType=" + list_licType + ", list_licNo=" + list_licNo
				+ ", list_fromDate=" + list_fromDate + ", list_toDate=" + list_toDate + ", list_issueAuth="
				+ list_issueAuth + ", approvalType=" + approvalType + ", strAppType=" + strAppType + ", approvalNo="
				+ approvalNo + ", appFromDate=" + appFromDate + ", appToDate=" + appToDate + ", appIssueAuth="
				+ appIssueAuth + ", appAddedList_str=" + appAddedList_str + ", list_approvalType=" + list_approvalType
				+ ", list_strAppType=" + list_strAppType + ", list_approvalNo=" + list_approvalNo
				+ ", list_appFromDate=" + list_appFromDate + ", list_appToDate=" + list_appToDate
				+ ", list_appIssueAuth=" + list_appIssueAuth + ", numDrugDocId=" + numDrugDocId + ", hppGeneratedData2="
				+ hppGeneratedData2 + ", hashValue2=" + hashValue2 + ", strDrugDocId=" + strDrugDocId
				+ ", drugLicenceMF=" + drugLicenceMF + ", gln=" + gln + ", appTypeRemarks=" + appTypeRemarks + "]";
	}
	
	int premiseno;

	public int getPremiseno() {
		return premiseno;
	}
	public void setPremiseno(int premiseno) {
		this.premiseno = premiseno;
	}
	
}
