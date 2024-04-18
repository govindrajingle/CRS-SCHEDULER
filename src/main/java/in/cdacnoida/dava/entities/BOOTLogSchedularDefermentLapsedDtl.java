package in.cdacnoida.dava.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "log_schedular_deferment_lapsed_dtl")
public class BOOTLogSchedularDefermentLapsedDtl {

	@Column(name = "application_id")
	private String applicationId;

	@Column(name = "reg_number")
	private String regNumber;

	@Column(name = "reg_date")
	private Timestamp regDate;

	@Column(name = "valid_upto")
	private Timestamp validUpto;

	@Column(name = "tr_dt")
	private Timestamp trDt;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_no")
	private Long seqNo;

	@Column(name = "str_target_status")
	private String strTargetStatus;

	@Column(name = "str_old_status")
	private String strOldStatus;

	@Column(name = "mail_send_content")
	private String mailSendContent;

	@Column(name = "is_no")
	private String isNo;

	@Column(name = "product_category")
	private String productCategory;

	@Column(name = "brand_name")
	private String brandName;

	@Column(name = "email_in_form_vi")
	private String emailInFormVi;

	@Column(name = "email_contact_person")
	private String emailContactPerson;

	@Column(name = "email_indian_rep")
	private String emailIndianRep;

	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "email_correspondence")
	private String emailCorrespondence;

	@Column(name = "str_user_id")
	private String strUserId;

	@Column(name = "str_manufacturing_unit")
	private String strManufacturingUnit;

	@Column(name = "str_manufacure_address")
	private String strManufactureAddress;

	@Column(name = "name_of_ind_representative")
	private String nameOfIndRepresentative;

	@Column(name = "address_of_ind_rep")
	private String addressOfIndRep;

	@Column(name = "email_delivered")
	private String emailDelivered;

	@Column(name = "is_processed")
	private String isProcessed;

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public Timestamp getValidUpto() {
		return validUpto;
	}

	public void setValidUpto(Timestamp validUpto) {
		this.validUpto = validUpto;
	}

	public Timestamp getTrDt() {
		return trDt;
	}

	public void setTrDt(Timestamp trDt) {
		this.trDt = trDt;
	}

	public Long getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
	}

	public String getStrTargetStatus() {
		return strTargetStatus;
	}

	public void setStrTargetStatus(String strTargetStatus) {
		this.strTargetStatus = strTargetStatus;
	}

	public String getStrOldStatus() {
		return strOldStatus;
	}

	public void setStrOldStatus(String strOldStatus) {
		this.strOldStatus = strOldStatus;
	}

	public String getMailSendContent() {
		return mailSendContent;
	}

	public void setMailSendContent(String mailSendContent) {
		this.mailSendContent = mailSendContent;
	}

	public String getIsNo() {
		return isNo;
	}

	public void setIsNo(String isNo) {
		this.isNo = isNo;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getEmailInFormVi() {
		return emailInFormVi;
	}

	public void setEmailInFormVi(String emailInFormVi) {
		this.emailInFormVi = emailInFormVi;
	}

	public String getEmailContactPerson() {
		return emailContactPerson;
	}

	public void setEmailContactPerson(String emailContactPerson) {
		this.emailContactPerson = emailContactPerson;
	}

	public String getEmailIndianRep() {
		return emailIndianRep;
	}

	public void setEmailIndianRep(String emailIndianRep) {
		this.emailIndianRep = emailIndianRep;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getEmailCorrespondence() {
		return emailCorrespondence;
	}

	public void setEmailCorrespondence(String emailCorrespondence) {
		this.emailCorrespondence = emailCorrespondence;
	}

	public String getStrUserId() {
		return strUserId;
	}

	public void setStrUserId(String strUserId) {
		this.strUserId = strUserId;
	}

	public String getStrManufacturingUnit() {
		return strManufacturingUnit;
	}

	public void setStrManufacturingUnit(String strManufacturingUnit) {
		this.strManufacturingUnit = strManufacturingUnit;
	}

	public String getStrManufactureAddress() {
		return strManufactureAddress;
	}

	public void setStrManufactureAddress(String strManufactureAddress) {
		this.strManufactureAddress = strManufactureAddress;
	}

	public String getNameOfIndRepresentative() {
		return nameOfIndRepresentative;
	}

	public void setNameOfIndRepresentative(String nameOfIndRepresentative) {
		this.nameOfIndRepresentative = nameOfIndRepresentative;
	}

	public String getAddressOfIndRep() {
		return addressOfIndRep;
	}

	public void setAddressOfIndRep(String addressOfIndRep) {
		this.addressOfIndRep = addressOfIndRep;
	}

	public String getEmailDelivered() {
		return emailDelivered;
	}

	public void setEmailDelivered(String emailDelivered) {
		this.emailDelivered = emailDelivered;
	}

	public String getIsProcessed() {
		return isProcessed;
	}

	public void setIsProcessed(String isProcessed) {
		this.isProcessed = isProcessed;
	}

	// getters and setters
}