package in.cdacnoida.dava.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "creit_renewal_master")
public class BOOTCreitRenewalMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "renewal_id")
    private String renewalId;

    @Column(name = "date_of_request")
    private Timestamp dateOfRequest;

    @Column(name = "str_status")
    private String strStatus;

    @Column(name = "trans_user_id")
    private String transUserId;

    @Column(name = "reg_number")
    private String regNumber;

    @Column(name = "application_id")
    private String applicationId;

    @Column(name = "str_version")
    private String strVersion;

    @Column(name = "product_model")
    private String productModel;

    @Column(name = "valid_from")
    private Timestamp validFrom;

    @Column(name = "valid_upto")
    private Timestamp validUpto;

    @Column(name = "brand")
    private String brand;

    @Column(name = "article_name")
    private String articleName;

    @Column(name = "quantity_produced")
    private String quantityProduced;

    @Column(name = "quantity_value")
    private String quantityValue;

    @Column(name = "address")
    private String address;

    @Column(name = "difficulty")
    private String difficulty;

    @Column(name = "authentication_flag")
    private String authenticationFlag;

    @Column(name = "is_no")
    private String isNo;

    @Column(name = "renewal_flag")
    private String renewalFlag;

    @Column(name = "name_address_flag")
    private String nameAddressFlag;

    @Column(name = "payment_flag")
    private String paymentFlag;

    @Column(name = "renewal_certi_flag")
    private String renewalCertiFlag;

    @Column(name = "date_recipt_hard_copy")
    private Timestamp dateReciptHardCopy;

    @Column(name = "nodal_officer")
    private String nodalOfficer;

    @Column(name = "letter_of_renewal")
    private String letterOfRenewal;

    @Column(name = "fee_amount")
    private String feeAmount;

    @Column(name = "payment_type")
    private String paymentType;

    
    @Column(name = "radio_ir_change")
    private String radioIrChange;
    
    @Column(name = "total_arrier_amount")
    private Double totalArrierAmount;
    
    @Column(name = "is_arrear_processed")
    private String isArrearProcessed;
    
    @Column(name = "renewal_req_for")
    private Integer renewalReqFor;
    
    @Column(name = "dmsme_processed")
    private String dmsmeProcessed;
    
    @Column(name = "strmsme")
    private String strmsme;
    
    @Column(name = "msme_issuedate")
    private String msmeIssuedate;
    
    @Column(name = "msme_validitydate")
    private String msmeValiditydate;
    
    @Column(name = "payment_revised")
    private String paymentRevised;
    
    @Column(name = "letter_edited")
    private Integer letterEdited;
    
    @Column(name = "qr_code_sent")
    private Integer qrCodeSent;
    
    @Column(name = "str_tr_remarks")
    private String strTrRemarks;
    
    @Column(name = "dt_tr")
    private Timestamp dtTr;
    
    @Column(name = "refund_req_raised")
    private Integer refundReqRaised;
    
    @Column(name = "is_auto_renewed")
    private String isAutoRenewed;
    
    @Column(name = "auto_renewed_intim_email")
    private String autoRenewedIntimEmail;
    
    @Column(name = "is_archieved")
    private String isArchieved;
    
    @Column(name = "str_remarks_update")
    private String strRemarksUpdate;
    
    @Column(name = "sno_count")
    private Integer snoCount;
    
    @Column(name = "log_dt")
    private Timestamp logDt;
    
    @Column(name = "org_type")
    private String orgType;
    
    @Column(name = "org_type_doc_id")
    private String orgTypeDocId;
    
    @Column(name = "additional_org_type")
    private String additionalOrgType;
    
    @Column(name = "additional_org_type_doc_id")
    private String additionalOrgTypeDocId;
    
    @Column(name = "str_organisation_category_decision")
    private String strOrganisationCategoryDecision;
    
    @Column(name = "str_additional_organisation_category_decision")
    private String strAdditionalOrganisationCategoryDecision;
    
    @Column(name = "str_organisation_category_decision_by")
    private String strOrganisationCategoryDecisionBy;
    
    @Column(name = "str_additional_organisation_category_decision_by")
    private String strAdditionalOrganisationCategoryDecisionBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRenewalId() {
		return renewalId;
	}

	public void setRenewalId(String renewalId) {
		this.renewalId = renewalId;
	}

	public Timestamp getDateOfRequest() {
		return dateOfRequest;
	}

	public void setDateOfRequest(Timestamp dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}

	public String getStrStatus() {
		return strStatus;
	}

	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	public String getTransUserId() {
		return transUserId;
	}

	public void setTransUserId(String transUserId) {
		this.transUserId = transUserId;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
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

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public Timestamp getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Timestamp validFrom) {
		this.validFrom = validFrom;
	}

	public Timestamp getValidUpto() {
		return validUpto;
	}

	public void setValidUpto(Timestamp validUpto) {
		this.validUpto = validUpto;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public String getQuantityProduced() {
		return quantityProduced;
	}

	public void setQuantityProduced(String quantityProduced) {
		this.quantityProduced = quantityProduced;
	}

	public String getQuantityValue() {
		return quantityValue;
	}

	public void setQuantityValue(String quantityValue) {
		this.quantityValue = quantityValue;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getAuthenticationFlag() {
		return authenticationFlag;
	}

	public void setAuthenticationFlag(String authenticationFlag) {
		this.authenticationFlag = authenticationFlag;
	}

	public String getIsNo() {
		return isNo;
	}

	public void setIsNo(String isNo) {
		this.isNo = isNo;
	}

	public String getRenewalFlag() {
		return renewalFlag;
	}

	public void setRenewalFlag(String renewalFlag) {
		this.renewalFlag = renewalFlag;
	}

	public String getNameAddressFlag() {
		return nameAddressFlag;
	}

	public void setNameAddressFlag(String nameAddressFlag) {
		this.nameAddressFlag = nameAddressFlag;
	}

	public String getPaymentFlag() {
		return paymentFlag;
	}

	public void setPaymentFlag(String paymentFlag) {
		this.paymentFlag = paymentFlag;
	}

	public String getRenewalCertiFlag() {
		return renewalCertiFlag;
	}

	public void setRenewalCertiFlag(String renewalCertiFlag) {
		this.renewalCertiFlag = renewalCertiFlag;
	}

	public Timestamp getDateReciptHardCopy() {
		return dateReciptHardCopy;
	}

	public void setDateReciptHardCopy(Timestamp dateReciptHardCopy) {
		this.dateReciptHardCopy = dateReciptHardCopy;
	}

	public String getNodalOfficer() {
		return nodalOfficer;
	}

	public void setNodalOfficer(String nodalOfficer) {
		this.nodalOfficer = nodalOfficer;
	}

	public String getLetterOfRenewal() {
		return letterOfRenewal;
	}

	public void setLetterOfRenewal(String letterOfRenewal) {
		this.letterOfRenewal = letterOfRenewal;
	}

	public String getFeeAmount() {
		return feeAmount;
	}

	public void setFeeAmount(String feeAmount) {
		this.feeAmount = feeAmount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getRadioIrChange() {
		return radioIrChange;
	}

	public void setRadioIrChange(String radioIrChange) {
		this.radioIrChange = radioIrChange;
	}

	public Double getTotalArrierAmount() {
		return totalArrierAmount;
	}

	public void setTotalArrierAmount(Double totalArrierAmount) {
		this.totalArrierAmount = totalArrierAmount;
	}

	public String getIsArrearProcessed() {
		return isArrearProcessed;
	}

	public void setIsArrearProcessed(String isArrearProcessed) {
		this.isArrearProcessed = isArrearProcessed;
	}

	public Integer getRenewalReqFor() {
		return renewalReqFor;
	}

	public void setRenewalReqFor(Integer renewalReqFor) {
		this.renewalReqFor = renewalReqFor;
	}

	public String getDmsmeProcessed() {
		return dmsmeProcessed;
	}

	public void setDmsmeProcessed(String dmsmeProcessed) {
		this.dmsmeProcessed = dmsmeProcessed;
	}

	public String getStrmsme() {
		return strmsme;
	}

	public void setStrmsme(String strmsme) {
		this.strmsme = strmsme;
	}

	public String getMsmeIssuedate() {
		return msmeIssuedate;
	}

	public void setMsmeIssuedate(String msmeIssuedate) {
		this.msmeIssuedate = msmeIssuedate;
	}

	public String getMsmeValiditydate() {
		return msmeValiditydate;
	}

	public void setMsmeValiditydate(String msmeValiditydate) {
		this.msmeValiditydate = msmeValiditydate;
	}

	public String getPaymentRevised() {
		return paymentRevised;
	}

	public void setPaymentRevised(String paymentRevised) {
		this.paymentRevised = paymentRevised;
	}

	public Integer getLetterEdited() {
		return letterEdited;
	}

	public void setLetterEdited(Integer letterEdited) {
		this.letterEdited = letterEdited;
	}

	public Integer getQrCodeSent() {
		return qrCodeSent;
	}

	public void setQrCodeSent(Integer qrCodeSent) {
		this.qrCodeSent = qrCodeSent;
	}

	public String getStrTrRemarks() {
		return strTrRemarks;
	}

	public void setStrTrRemarks(String strTrRemarks) {
		this.strTrRemarks = strTrRemarks;
	}

	public Timestamp getDtTr() {
		return dtTr;
	}

	public void setDtTr(Timestamp dtTr) {
		this.dtTr = dtTr;
	}

	public Integer getRefundReqRaised() {
		return refundReqRaised;
	}

	public void setRefundReqRaised(Integer refundReqRaised) {
		this.refundReqRaised = refundReqRaised;
	}

	public String getIsAutoRenewed() {
		return isAutoRenewed;
	}

	public void setIsAutoRenewed(String isAutoRenewed) {
		this.isAutoRenewed = isAutoRenewed;
	}

	public String getAutoRenewedIntimEmail() {
		return autoRenewedIntimEmail;
	}

	public void setAutoRenewedIntimEmail(String autoRenewedIntimEmail) {
		this.autoRenewedIntimEmail = autoRenewedIntimEmail;
	}

	public String getIsArchieved() {
		return isArchieved;
	}

	public void setIsArchieved(String isArchieved) {
		this.isArchieved = isArchieved;
	}

	public String getStrRemarksUpdate() {
		return strRemarksUpdate;
	}

	public void setStrRemarksUpdate(String strRemarksUpdate) {
		this.strRemarksUpdate = strRemarksUpdate;
	}

	public Integer getSnoCount() {
		return snoCount;
	}

	public void setSnoCount(Integer snoCount) {
		this.snoCount = snoCount;
	}

	public Timestamp getLogDt() {
		return logDt;
	}

	public void setLogDt(Timestamp logDt) {
		this.logDt = logDt;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getOrgTypeDocId() {
		return orgTypeDocId;
	}

	public void setOrgTypeDocId(String orgTypeDocId) {
		this.orgTypeDocId = orgTypeDocId;
	}

	public String getAdditionalOrgType() {
		return additionalOrgType;
	}

	public void setAdditionalOrgType(String additionalOrgType) {
		this.additionalOrgType = additionalOrgType;
	}

	public String getAdditionalOrgTypeDocId() {
		return additionalOrgTypeDocId;
	}

	public void setAdditionalOrgTypeDocId(String additionalOrgTypeDocId) {
		this.additionalOrgTypeDocId = additionalOrgTypeDocId;
	}

	public String getStrOrganisationCategoryDecision() {
		return strOrganisationCategoryDecision;
	}

	public void setStrOrganisationCategoryDecision(String strOrganisationCategoryDecision) {
		this.strOrganisationCategoryDecision = strOrganisationCategoryDecision;
	}

	public String getStrAdditionalOrganisationCategoryDecision() {
		return strAdditionalOrganisationCategoryDecision;
	}

	public void setStrAdditionalOrganisationCategoryDecision(String strAdditionalOrganisationCategoryDecision) {
		this.strAdditionalOrganisationCategoryDecision = strAdditionalOrganisationCategoryDecision;
	}

	public String getStrOrganisationCategoryDecisionBy() {
		return strOrganisationCategoryDecisionBy;
	}

	public void setStrOrganisationCategoryDecisionBy(String strOrganisationCategoryDecisionBy) {
		this.strOrganisationCategoryDecisionBy = strOrganisationCategoryDecisionBy;
	}

	public String getStrAdditionalOrganisationCategoryDecisionBy() {
		return strAdditionalOrganisationCategoryDecisionBy;
	}

	public void setStrAdditionalOrganisationCategoryDecisionBy(String strAdditionalOrganisationCategoryDecisionBy) {
		this.strAdditionalOrganisationCategoryDecisionBy = strAdditionalOrganisationCategoryDecisionBy;
	}
}















