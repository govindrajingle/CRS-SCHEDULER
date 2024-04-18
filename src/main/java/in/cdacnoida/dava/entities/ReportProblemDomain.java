package in.cdacnoida.dava.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

//@Entity
//@Table(name = "feedback_mst")
public class ReportProblemDomain extends TransactionInfoDomain implements Serializable {

	private static final long serialVersionUID = -6048595144903121228L;
	
	@Id
	@Column(name = "num_problem_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	int problem_id;

	@Column(name = "num_doc_id")
	int doc_id;
	
	@Column(name = "num_country_id")
	int country_id;
	
	@Column(name = "str_pincode") 
	String pincode;
	
	@Column(name = "str_user_name")
	String user_name;
	
	@Column(name = "str_org_name")
	String org_name;
	
	@Column(name = "str_problem")
	String problem;

	@Column(name = "str_address")
	String address;
	
	@Column(name = "str_designation")
	String designation;
	
	@Column(name = "str_email_id")
	String email_id;
	
	@Column(name = "num_mobile_no")
	int mobile_no;
   
	@Column(name = "str_problemno")
	String problem_no;
	
	@Column(name = "str_landline_no")
	String landline_no;
	
	@Column(name = "str_subject")
	String subject;
	
	@Column(name = "dt_entry_date")
	Date entry_date;
	
	@Column(name = "str_mobile_no")
	String mobile;
	
	@Column(name = "num_reply_status")
	int replyStatus;
   
	@Column(name = "str_reply")
	String strReply;
	
	@Column(name = "num_cdac_issue_type")
	Integer numCdacIssueType;
   
	@Column(name = "str_cdac_remarks")
	String strCdacRemarks;
	
	@Column(name = "num_cdac_status")
	Integer numCdacStatus;
	
	@Column(name = "num_issue_status")
	Integer numIssueStatus;
   
	@Column(name = "str_assigned_to")
	String strAssignedTo;

	public int getProblem_id() {
		return problem_id;
	}

	public void setProblem_id(int problem_id) {
		this.problem_id = problem_id;
	}

	public int getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public int getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(int mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getProblem_no() {
		return problem_no;
	}

	public void setProblem_no(String problem_no) {
		this.problem_no = problem_no;
	}

	public String getLandline_no() {
		return landline_no;
	}

	public void setLandline_no(String landline_no) {
		this.landline_no = landline_no;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getReplyStatus() {
		return replyStatus;
	}

	public void setReplyStatus(int replyStatus) {
		this.replyStatus = replyStatus;
	}

	public String getStrReply() {
		return strReply;
	}

	public void setStrReply(String strReply) {
		this.strReply = strReply;
	}

	public Integer getNumCdacIssueType() {
		return numCdacIssueType;
	}

	public void setNumCdacIssueType(Integer numCdacIssueType) {
		this.numCdacIssueType = numCdacIssueType;
	}

	public String getStrCdacRemarks() {
		return strCdacRemarks;
	}

	public void setStrCdacRemarks(String strCdacRemarks) {
		this.strCdacRemarks = strCdacRemarks;
	}

	public Integer getNumCdacStatus() {
		return numCdacStatus;
	}

	public void setNumCdacStatus(Integer numCdacStatus) {
		this.numCdacStatus = numCdacStatus;
	}

	public Integer getNumIssueStatus() {
		return numIssueStatus;
	}

	public void setNumIssueStatus(Integer numIssueStatus) {
		this.numIssueStatus = numIssueStatus;
	}

	public String getStrAssignedTo() {
		return strAssignedTo;
	}

	public void setStrAssignedTo(String strAssignedTo) {
		this.strAssignedTo = strAssignedTo;
	}

}
