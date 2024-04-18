package in.cdacnoida.dava.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "creit_registration_master")
public class BOOTCreitRegistrationMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_no")
	private Long seqNo;

	@Column(name = "application_id")
	private String applicationId;

	@Column(name = "str_version")
	private String strVersion;

	@Column(name = "reg_date")
	private Timestamp regDate;

	@Column(name = "reg_number")
	private String regNumber;

	@Column(name = "reg_cert_flag")
	private String regCertFlag;

	@Column(name = "str_status")
	private String strStatus;

	@Column(name = "trans_date")
	private Timestamp transDate;

	@Column(name = "trans_user_id")
	private String transUserId;

	@Column(name = "dealing_officer")
	private String dealingOfficer;

	@Column(name = "granting_officer")
	private String grantingOfficer;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "agree_form_flag")
	private String agreeFormFlag;

	@Column(name = "trans_type_id")
	private String transTypeId;

	@Column(name = "num_sequence")
	private Integer numSequence;

	@Column(name = "surv_initiated")
	private String survInitiated;

	@Column(name = "intimation_flag")
	private String intimationFlag;

	@Column(name = "letter_of_intimation")
	private String letterOfIntimation;

	@Column(name = "transaction_id")
	private Integer transactionId;

	@Column(name = "valid_up_to")
	private Timestamp validUpTo;

	@Column(name = "letter_edited")
	private Integer letterEdited;

	@Column(name = "revised_letter_sent_on")
	private Timestamp revisedLetterSentOn;

	@Column(name = "is_letter_revised")
	private String isLetterRevised;

	public Long getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getStrVersion() {
		return strVersion;
	}

	public void setStrVersion(String strVersion) {
		this.strVersion = strVersion;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public String getRegCertFlag() {
		return regCertFlag;
	}

	public void setRegCertFlag(String regCertFlag) {
		this.regCertFlag = regCertFlag;
	}

	public String getStrStatus() {
		return strStatus;
	}

	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	public Timestamp getTransDate() {
		return transDate;
	}

	public void setTransDate(Timestamp transDate) {
		this.transDate = transDate;
	}

	public String getTransUserId() {
		return transUserId;
	}

	public void setTransUserId(String transUserId) {
		this.transUserId = transUserId;
	}

	public String getDealingOfficer() {
		return dealingOfficer;
	}

	public void setDealingOfficer(String dealingOfficer) {
		this.dealingOfficer = dealingOfficer;
	}

	public String getGrantingOfficer() {
		return grantingOfficer;
	}

	public void setGrantingOfficer(String grantingOfficer) {
		this.grantingOfficer = grantingOfficer;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAgreeFormFlag() {
		return agreeFormFlag;
	}

	public void setAgreeFormFlag(String agreeFormFlag) {
		this.agreeFormFlag = agreeFormFlag;
	}

	public String getTransTypeId() {
		return transTypeId;
	}

	public void setTransTypeId(String transTypeId) {
		this.transTypeId = transTypeId;
	}

	public Integer getNumSequence() {
		return numSequence;
	}

	public void setNumSequence(Integer numSequence) {
		this.numSequence = numSequence;
	}

	public String getSurvInitiated() {
		return survInitiated;
	}

	public void setSurvInitiated(String survInitiated) {
		this.survInitiated = survInitiated;
	}

	public String getIntimationFlag() {
		return intimationFlag;
	}

	public void setIntimationFlag(String intimationFlag) {
		this.intimationFlag = intimationFlag;
	}

	public String getLetterOfIntimation() {
		return letterOfIntimation;
	}

	public void setLetterOfIntimation(String letterOfIntimation) {
		this.letterOfIntimation = letterOfIntimation;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Timestamp getValidUpTo() {
		return validUpTo;
	}

	public void setValidUpTo(Timestamp validUpTo) {
		this.validUpTo = validUpTo;
	}

	public Integer getLetterEdited() {
		return letterEdited;
	}

	public void setLetterEdited(Integer letterEdited) {
		this.letterEdited = letterEdited;
	}

	public Timestamp getRevisedLetterSentOn() {
		return revisedLetterSentOn;
	}

	public void setRevisedLetterSentOn(Timestamp revisedLetterSentOn) {
		this.revisedLetterSentOn = revisedLetterSentOn;
	}

	public String getIsLetterRevised() {
		return isLetterRevised;
	}

	public void setIsLetterRevised(String isLetterRevised) {
		this.isLetterRevised = isLetterRevised;
	}

	@Override
	public String toString() {
		return "BOOTCreitRegistrationMaster [seqNo=" + seqNo + ", applicationId=" + applicationId + ", strVersion="
				+ strVersion + ", regDate=" + regDate + ", regNumber=" + regNumber + ", regCertFlag=" + regCertFlag
				+ ", strStatus=" + strStatus + ", transDate=" + transDate + ", transUserId=" + transUserId
				+ ", dealingOfficer=" + dealingOfficer + ", grantingOfficer=" + grantingOfficer + ", remarks=" + remarks
				+ ", agreeFormFlag=" + agreeFormFlag + ", transTypeId=" + transTypeId + ", numSequence=" + numSequence
				+ ", survInitiated=" + survInitiated + ", intimationFlag=" + intimationFlag + ", letterOfIntimation="
				+ letterOfIntimation + ", transactionId=" + transactionId + ", validUpTo=" + validUpTo
				+ ", letterEdited=" + letterEdited + ", revisedLetterSentOn=" + revisedLetterSentOn
				+ ", isLetterRevised=" + isLetterRevised + "]";
	}

	// getters and setters

}
