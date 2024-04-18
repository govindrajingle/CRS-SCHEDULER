package in.cdacnoida.dava.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="institute_premises_dtl")
public class InstPremiseDtlDomain extends TransactionInfoDomain   implements Serializable{

	private static final long serialVersionUID = -6048595144903121228L;
	@Id
	@Column(name="num_premises_no")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1000, allocationSize=1)
	int numPremiseNo; 
	
	@Column(name="str_unit_no")
	String strUnitNo;
	
	@Column(name="num_version")
	int version;
	
	@Column(name="num_sitetype_id")
	Integer siteType;
	
	@Column(name="str_premises_name")
	String premiseName;
	
	@Column(name="num_inst_id")
	int numInstid;
	
	@Column(name="num_premises_type_id")
	int numPremiseTypeId;

	@Column(name="str_address")
	String strAddress;
	
	@Column(name="str_city")
	String strCity;
	
	@Column(name="num_pincode")
	int numPincode;
	
	@Column(name="str_contact_details")
	String strContactDtls;
	
	@Column(name="str_fax_details")
	String faxNumber;
	
	@Column(name="str_email")
	String emailId;
	
	@Column(name="num_state_id")
	int numStateId;
	
	@Column(name="num_district_id")
	int numDistrictId;
	
	@Column(name="str_gstin_no")
	String gstin;
	
	@Column(name="str_gs1_no")
	String gs1;
	
	@Column(name="str_cont_name")
	String contactPersonName;
	
	@Column(name="num_cont_mobile_no")
	String contPerMobileNo;
	
	@Column(name="str_cont_desg")
	String contactPerDesg;
	
	@Column(name="str_cont_email")
	String contPersEmail;
	
	@Column(name="num_country_id")
	int numCountryId;
	
	@Column(name="num_sublogin_userid")
	int numSubloginUserid;
	
	@Column(name="str_manuf_code")
	String strManufCode;
	
	@Column(name="str_exp_type")
	String strExpType;
	
	@Column(name="num_document_id")
	int numDocumentId = 0;
	
	@Column(name="str_gln_no")
	String gln;
	
	@Column(name="str_premise_code")
	String strPremiseCode;
	
	@Column(name="str_doc_id")
	String strDocId;
	
	@Column(name="num_doc_id")
	Integer numDocId;

		
	public String getStrDocId() {
		return strDocId;
	}

	public void setStrDocId(String strDocId) {
		this.strDocId = strDocId;
	}

	public int getNumDocId() {
		return numDocId;
	}

	public void setNumDocId(int numDocId) {
		this.numDocId = numDocId;
	}

	public int getNumPremiseNo() {
		return numPremiseNo;
	}

	public void setNumPremiseNo(int numPremiseNo) {
		this.numPremiseNo = numPremiseNo;
	}

	public String getStrUnitNo() {
		return strUnitNo;
	}

	public void setStrUnitNo(String strUnitNo) {
		this.strUnitNo = strUnitNo;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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

	public int getNumInstid() {
		return numInstid;
	}

	public void setNumInstid(int numInstid) {
		this.numInstid = numInstid;
	}

	public int getNumPremiseTypeId() {
		return numPremiseTypeId;
	}

	public void setNumPremiseTypeId(int numPremiseTypeId) {
		this.numPremiseTypeId = numPremiseTypeId;
	}

	public String getStrAddress() {
		return strAddress;
	}

	public void setStrAddress(String strAddress) {
		this.strAddress = strAddress;
	}

	public String getStrCity() {
		return strCity;
	}

	public void setStrCity(String strCity) {
		this.strCity = strCity;
	}

	public int getNumPincode() {
		return numPincode;
	}

	public void setNumPincode(int numPincode) {
		this.numPincode = numPincode;
	}

	public String getStrContactDtls() {
		return strContactDtls;
	}

	public void setStrContactDtls(String strContactDtls) {
		this.strContactDtls = strContactDtls;
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

	public int getNumStateId() {
		return numStateId;
	}

	public void setNumStateId(int numStateId) {
		this.numStateId = numStateId;
	}

	public int getNumDistrictId() {
		return numDistrictId;
	}

	public void setNumDistrictId(int numDistrictId) {
		this.numDistrictId = numDistrictId;
	}

	public int getNumCountryId() {
		return numCountryId;
	}

	public void setNumCountryId(int numCountryId) {
		this.numCountryId = numCountryId;
	}

	public int getNumSubloginUserid() {
		return numSubloginUserid;
	}

	public void setNumSubloginUserid(int numSubloginUserid) {
		this.numSubloginUserid = numSubloginUserid;
	}

	public String getStrManufCode() {
		return strManufCode;
	}

	public void setStrManufCode(String strManufCode) {
		this.strManufCode = strManufCode;
	}

	public String getStrExpType() {
		return strExpType;
	}

	public void setStrExpType(String strExpType) {
		this.strExpType = strExpType;
	}

	public int getNumDocumentId() {
		return numDocumentId;
	}

	public void setNumDocumentId(int numDocumentId) {
		this.numDocumentId = numDocumentId;
	}

	public String getGln() {
		return gln;
	}

	public void setGln(String gln) {
		this.gln = gln;
	}

	public String getStrPremiseCode() {
		return strPremiseCode;
	}

	public void setStrPremiseCode(String strPremiseCode) {
		this.strPremiseCode = strPremiseCode;
	}

	@Override
	public String toString() {
		return "InstPremiseDtlDomain [numPremiseNo=" + numPremiseNo + ", strUnitNo=" + strUnitNo + ", version="
				+ version + ", siteType=" + siteType + ", premiseName=" + premiseName + ", numInstid=" + numInstid
				+ ", numPremiseTypeId=" + numPremiseTypeId + ", strAddress=" + strAddress + ", strCity=" + strCity
				+ ", numPincode=" + numPincode + ", strContactDtls=" + strContactDtls + ", faxNumber=" + faxNumber
				+ ", emailId=" + emailId + ", numStateId=" + numStateId + ", numDistrictId=" + numDistrictId
				+ ", gstin=" + gstin + ", gs1=" + gs1 + ", contactPersonName=" + contactPersonName
				+ ", contPerMobileNo=" + contPerMobileNo + ", contactPerDesg=" + contactPerDesg + ", contPersEmail="
				+ contPersEmail + ", numCountryId=" + numCountryId + ", numSubloginUserid=" + numSubloginUserid
				+ ", strManufCode=" + strManufCode + ", strExpType=" + strExpType + ", numDocumentId=" + numDocumentId
				+ ", gln=" + gln + ", strPremiseCode=" + strPremiseCode + ", strDocId=" + strDocId + ", numDocId="
				+ numDocId + "]";
	}
	
}
