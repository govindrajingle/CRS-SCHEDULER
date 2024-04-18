package in.cdacnoida.dava.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

//@Entity
//@Table(name = "institute_member_dtl")
public class InstituteMemberDetailDomain extends TransactionInfoDomain{



	@Id
	@Column(name="num_memb_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1, allocationSize = 1)
	private Integer numMemberId;
	
	@Column(name="num_inst_id")
	private int numInstId;
	
	@Column(name="num_member_type")
	private int numMemberType;
	
	@Column(name="str_member_name")
	private String strMemberName;
	
	@Column(name="str_member_gender")
	private String strMemberGender;

	@Column(name="str_member_desig")
	private String strMemberDesig;

	@Column(name="dt_of_joining")
	private Date dtOfJoining;

	@Column(name="str_email")
	private String strEmail;

	@Column(name="num_idproff_type_id")
	private int numIdProofTypeid;
	
	@Column(name="str_idcard_no")
	private String strIdCardNo;

	@Column(name="num_document_id")
	private String numDocumentId;

	@Column(name="num_status")
	private int numStatus;
	
	@Column(name="num_appl_type_id")
	private int numApplTypeId;

	@Column(name="str_appl_type_name")
	private String strApplTypeName;

	@Column(name="str_appl_type_short_name")
	private String strApplTypeShortName;
	
	@Column(name="str_contact_no")
	private String strContactNo;
	
	@Column(name="str_fax_no")
	private String strFaxNo;

	public Integer getNumMemberId() {
		return numMemberId;
	}

	public void setNumMemberId(Integer numMemberId) {
		this.numMemberId = numMemberId;
	}

	public int getNumInstId() {
		return numInstId;
	}

	public void setNumInstId(int numInstId) {
		this.numInstId = numInstId;
	}

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

	public String getStrMemberGender() {
		return strMemberGender;
	}

	public void setStrMemberGender(String strMemberGender) {
		this.strMemberGender = strMemberGender;
	}

	public String getStrMemberDesig() {
		return strMemberDesig;
	}

	public void setStrMemberDesig(String strMemberDesig) {
		this.strMemberDesig = strMemberDesig;
	}

	public Date getDtOfJoining() {
		return dtOfJoining;
	}

	public void setDtOfJoining(Date dtOfJoining) {
		this.dtOfJoining = dtOfJoining;
	}

	public String getStrEmail() {
		return strEmail;
	}

	public void setStrEmail(String strEmail) {
		this.strEmail = strEmail;
	}

	public int getNumIdProofTypeid() {
		return numIdProofTypeid;
	}

	public void setNumIdProofTypeid(int numIdProofTypeid) {
		this.numIdProofTypeid = numIdProofTypeid;
	}

	public String getStrIdCardNo() {
		return strIdCardNo;
	}

	public void setStrIdCardNo(String strIdCardNo) {
		this.strIdCardNo = strIdCardNo;
	}


	public String getNumDocumentId() {
		return numDocumentId;
	}

	public void setNumDocumentId(String numDocumentId) {
		this.numDocumentId = numDocumentId;
	}

	public int getNumStatus() {
		return numStatus;
	}

	public void setNumStatus(int numStatus) {
		this.numStatus = numStatus;
	}

	public int getNumApplTypeId() {
		return numApplTypeId;
	}

	public void setNumApplTypeId(int numApplTypeId) {
		this.numApplTypeId = numApplTypeId;
	}

	public String getStrApplTypeName() {
		return strApplTypeName;
	}

	public void setStrApplTypeName(String strApplTypeName) {
		this.strApplTypeName = strApplTypeName;
	}

	public String getStrApplTypeShortName() {
		return strApplTypeShortName;
	}

	public void setStrApplTypeShortName(String strApplTypeShortName) {
		this.strApplTypeShortName = strApplTypeShortName;
	}

	public String getStrContactNo() {
		return strContactNo;
	}

	public void setStrContactNo(String strContactNo) {
		this.strContactNo = strContactNo;
	}

	public String getStrFaxNo() {
		return strFaxNo;
	}

	public void setStrFaxNo(String strFaxNo) {
		this.strFaxNo = strFaxNo;
	}

	
	
}
