package in.cdacnoida.dava.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import in.cdacnoida.dava.misc.ValidationGroups.MemberDetails;

public class MemberDetailForm {

	int numMemberId;
	@NotNull(message="This Member Type is required and cannot be empty", groups={MemberDetails.class})
	int numMemberType;
	@NotEmpty(message="This Member Name is required and cannot be empty", groups={MemberDetails.class})
	@Size(min=1, max=50,message="This Member Name can contain maximum of 50 characters", groups={MemberDetails.class})
	@Pattern(regexp="^[a-zA-Z0-9.,\\-\\/\\s +&()]+$",message="Member Name can consist of alphabets, numbers and special characters( /,()-.+&) and white spaces are permitted",groups={MemberDetails.class})
	String strMemberName;
	@NotNull(message="Gender is required and cannot be empty", groups={MemberDetails.class})
	int numGender;
	@NotEmpty(message="This Member Designation is required and cannot be empty", groups={MemberDetails.class})
	@Size(min=1, max=20,message="This Member Designation can contain maximum of 20 characters", groups={MemberDetails.class})
	@Pattern(regexp="^[a-zA-Z0-9.,\\-\\/\\s +&()]+$",message="Member Designation can consist of alphabets, numbers and special characters( /,()-.+&) and white spaces are permitted",groups={MemberDetails.class})
	String strDesignation;
	@NotEmpty(message="This Contact Number is required and cannot be empty", groups={MemberDetails.class})
	@Size(min=10, max=10,message="This Contact Number can contain maximum of 10 characters", groups={MemberDetails.class})
	@Pattern(regexp="^[a-zA-Z0-9.,\\-\\/\\s +&()]+$",message="Contact Number can consist of numbers are permitted",groups={MemberDetails.class})
	String numContactNo;
	String numFaxNo;
	@NotNull(message="This Member Type is required and cannot be empty", groups={MemberDetails.class})
	int numstatus;
	String dateOfJoining;
	int idProofTypeId;
	String strCardNumber;
	@NotEmpty(message="User Name cannot not be null or empty")
	@Email
	String strEmail;
	
	
	private MultipartFile uploadfile;
	
	int numDocId;
	String strDocId;
	
	
	public int getNumMemberType() {
		return numMemberType;
	}
	public void setNumMemberType(int numMemberType) {
		this.numMemberType = numMemberType;
	}
	public String getStrMemberName() {
		return strMemberName;
	}
	public void setStrMemberName(String strMemberName) {
		this.strMemberName = strMemberName;
	}
	public int getNumGender() {
		return numGender;
	}
	public void setNumGender(int numGender) {
		this.numGender = numGender;
	}
	public String getStrDesignation() {
		return strDesignation;
	}
	public void setStrDesignation(String strDesignation) {
		this.strDesignation = strDesignation;
	}
	public int getNumstatus() {
		return numstatus;
	}
	public void setNumstatus(int numstatus) {
		this.numstatus = numstatus;
	}
	public int getIdProofTypeId() {
		return idProofTypeId;
	}
	public void setIdProofTypeId(int idProofTypeId) {
		this.idProofTypeId = idProofTypeId;
	}
	public String getStrCardNumber() {
		return strCardNumber;
	}
	public void setStrCardNumber(String strCardNumber) {
		this.strCardNumber = strCardNumber;
	}
	public String getStrEmail() {
		return strEmail;
	}
	public void setStrEmail(String strEmail) {
		this.strEmail = strEmail;
	}
	public String getNumContactNo() {
		return numContactNo;
	}
	public void setNumContactNo(String numContactNo) {
		this.numContactNo = numContactNo;
	}
	public int getNumMemberId() {
		return numMemberId;
	}
	public void setNumMemberId(int numMemberId) {
		this.numMemberId = numMemberId;
	}
	public String getNumFaxNo() {
		return numFaxNo;
	}
	public void setNumFaxNo(String numFaxNo) {
		this.numFaxNo = numFaxNo;
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
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public MultipartFile getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(MultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}
	
	
	
	
}
