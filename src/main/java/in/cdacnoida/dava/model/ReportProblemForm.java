package in.cdacnoida.dava.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.serial.SerialArray;

public class ReportProblemForm {
	
	int problem_id;
	
   
	String user_name;
	String designation;
	String email_id;
	String mobile_no;
	String org_name;
	String address;
	String contact_number;
	String problem;

	

	int numDocId;
	String strDocId;
	
	String problem_no;
	
	
   int countryTypeId;
   
   
   String pincode;
   
   
   String subject;
   
	String strRemarks;
	
	List<String> uName;
	List<String> uDesignation;
	List<String> uEmail;
	List<String> uMobile;
	List<String> uOrganization;
	List<String> uAddress;
	List<String> uCountry;
	List<String> uPostalCode;
	List<String> uContact;
	List<String> uSubject;
	List<String> uProblem;
	List<String> uUpload;
	
	Integer cdacIssueType;
	
	String cdacRemarks;
	
	Integer issueStaus;
	
	String assignedTo;

	
	  public String getPincode() { return pincode; }
	 
	  
	  public void setPincode(String pincode) { this.pincode = pincode; }
	 


	public int getCountryTypeId() {
	return countryTypeId;
    }
	
	
   public void setCountryTypeId(int countryTypeId) {
	this.countryTypeId = countryTypeId;
    }
   
   
	public String getProblem_no() {
		return problem_no;
	}
	public void setProblem_no(String problem_no) {
		this.problem_no = problem_no;
	}
	
	
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
	public int getProblem_id() {
		return problem_id;
	}
	public void setProblem_id(int problem_id) {
		this.problem_id = problem_id;
	}
	
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getOrg_name() {
		return org_name;
	}
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getStrRemarks() {
		return strRemarks;
	}


	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}


	public List<String> getuName() {
		return uName;
	}


	public void setuName(List<String> uName) {
		this.uName = uName;
	}


	public List<String> getuDesignation() {
		return uDesignation;
	}


	public void setuDesignation(List<String> uDesignation) {
		this.uDesignation = uDesignation;
	}


	public List<String> getuEmail() {
		return uEmail;
	}


	public void setuEmail(List<String> uEmail) {
		this.uEmail = uEmail;
	}


	public List<String> getuMobile() {
		return uMobile;
	}


	public void setuMobile(List<String> uMobile) {
		this.uMobile = uMobile;
	}


	public List<String> getuOrganization() {
		return uOrganization;
	}


	public void setuOrganization(List<String> uOrganization) {
		this.uOrganization = uOrganization;
	}


	public List<String> getuAddress() {
		return uAddress;
	}


	public void setuAddress(List<String> uAddress) {
		this.uAddress = uAddress;
	}


	public List<String> getuCountry() {
		return uCountry;
	}


	public void setuCountry(List<String> uCountry) {
		this.uCountry = uCountry;
	}


	public List<String> getuPostalCode() {
		return uPostalCode;
	}


	public void setuPostalCode(List<String> uPostalCode) {
		this.uPostalCode = uPostalCode;
	}


	public List<String> getuContact() {
		return uContact;
	}


	public void setuContact(List<String> uContact) {
		this.uContact = uContact;
	}


	public List<String> getuSubject() {
		return uSubject;
	}


	public void setuSubject(List<String> uSubject) {
		this.uSubject = uSubject;
	}


	public List<String> getuProblem() {
		return uProblem;
	}


	public void setuProblem(List<String> uProblem) {
		this.uProblem = uProblem;
	}


	public List<String> getuUpload() {
		return uUpload;
	}


	public void setuUpload(List<String> uUpload) {
		this.uUpload = uUpload;
	}


	public Integer getCdacIssueType() {
		return cdacIssueType;
	}


	public void setCdacIssueType(Integer cdacIssueType) {
		this.cdacIssueType = cdacIssueType;
	}


	public String getCdacRemarks() {
		return cdacRemarks;
	}


	public void setCdacRemarks(String cdacRemarks) {
		this.cdacRemarks = cdacRemarks;
	}


	public Integer getIssueStaus() {
		return issueStaus;
	}


	public void setIssueStaus(Integer issueStaus) {
		this.issueStaus = issueStaus;
	}


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


	public String getAssignedTo() {
		return assignedTo;
	}


	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	
	int fileType;
	String ENdoc_id;
	
	
	
	
	
	

}
