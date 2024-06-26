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
//@Table(name = "invoice_dtl")
public class UploadXmlInvoiceDtlDomain extends TransactionInfoDomain implements Serializable {
	private static final long serialVersionUID = -9170913258269305131L;

	@Id
	@Column(name = "num_inv_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	int numInvoiceId;
	
	@Column(name = "num_inst_id")
	int numInstId; 
	
	@Column(name="num_premise_no")
	int num_premiseNo;
	
	@Column(name="str_invoice_no")
	String strInvoiceNo;
	
	@Column(name = "dt_inv_date")
	Date dtInvoiceDate;
	
	@Column(name="str_company_add")
	String strCompanyAddress; 
	
	@Column(name="str_company_name")
	String strCompanyName;
	
	@Column(name="str_company_of_exp")
	String strCompanyOfExp;
	
	@Column(name="str_region_cd")
	String strRegionCode;
	
	@Column(name = "num_tertiary_count")
	Integer numTertiaryCount; 
	
	@Column(name = "num_upload_id")
	Integer numUploadId; 
	
	@Column(name = "dt_expiry_date")
	Date dtExpiryDate;
	
	@Column(name = "dt_file_date")
	Date dtFileDate;
	
	@Column(name = "num_doc_size")
	Integer numDocSize;
	
	@Column(name = "num_document_id")
	Integer numDocumentId;
	
	@Column(name = "num_sign_flag")
	Integer numSignFlag;
	
	@Column(name = "num_status")
	Integer numStatus;
	
	@Column(name = "num_user_id")
	Integer numUserId;
	
	@Column(name = "num_verify_by")
	Integer numVerifyBy;
	
	@Column(name = "num_type_id")
	Integer numTypeId;
	
	@Column(name="str_filename")
	String strFilename;
	
	@Column(name="str_hash_code")
	String strHashCode;
	
	@Column(name="str_remarks")
	String strRemarks;
	
	@Column(name="str_serial_type")
	String strSerialType;
	
	@Column(name="xml_data")
	String xmlData;
	
	@Column(name="str_source_portname")
	String strSourcePortname;
	
	@Column(name="str_landing_portname")
	String strLandingPortname;
	
	@Column(name="str_country_of_exp")
	String strCountryOfExp;

	public int getNumInvoiceId() {
		return numInvoiceId;
	}

	public void setNumInvoiceId(int numInvoiceId) {
		this.numInvoiceId = numInvoiceId;
	}

	public int getNumInstId() {
		return numInstId;
	}

	public void setNumInstId(int numInstId) {
		this.numInstId = numInstId;
	}

	public int getNum_premiseNo() {
		return num_premiseNo;
	}

	public void setNum_premiseNo(int num_premiseNo) {
		this.num_premiseNo = num_premiseNo;
	}

	public String getStrInvoiceNo() {
		return strInvoiceNo;
	}

	public void setStrInvoiceNo(String strInvoiceNo) {
		this.strInvoiceNo = strInvoiceNo;
	}

	public Date getDtInvoiceDate() {
		return dtInvoiceDate;
	}

	public void setDtInvoiceDate(Date dtInvoiceDate) {
		this.dtInvoiceDate = dtInvoiceDate;
	}

	public String getStrCompanyAddress() {
		return strCompanyAddress;
	}

	public void setStrCompanyAddress(String strCompanyAddress) {
		this.strCompanyAddress = strCompanyAddress;
	}

	public String getStrCompanyName() {
		return strCompanyName;
	}

	public void setStrCompanyName(String strCompanyName) {
		this.strCompanyName = strCompanyName;
	}

	public String getStrCompanyOfExp() {
		return strCompanyOfExp;
	}

	public void setStrCompanyOfExp(String strCompanyOfExp) {
		this.strCompanyOfExp = strCompanyOfExp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getStrRegionCode() {
		return strRegionCode;
	}

	public void setStrRegionCode(String strRegionCode) {
		this.strRegionCode = strRegionCode;
	}

	public Integer getNumTertiaryCount() {
		return numTertiaryCount;
	}

	public void setNumTertiaryCount(Integer numTertiaryCount) {
		this.numTertiaryCount = numTertiaryCount;
	}

	public Integer getNumUploadId() {
		return numUploadId;
	}

	public void setNumUploadId(Integer numUploadId) {
		this.numUploadId = numUploadId;
	}

	public Date getDtExpiryDate() {
		return dtExpiryDate;
	}

	public void setDtExpiryDate(Date dtExpiryDate) {
		this.dtExpiryDate = dtExpiryDate;
	}

	public Date getDtFileDate() {
		return dtFileDate;
	}

	public void setDtFileDate(Date dtFileDate) {
		this.dtFileDate = dtFileDate;
	}

	public Integer getNumDocSize() {
		return numDocSize;
	}

	public void setNumDocSize(Integer numDocSize) {
		this.numDocSize = numDocSize;
	}

	public Integer getNumDocumentId() {
		return numDocumentId;
	}

	public void setNumDocumentId(Integer numDocumentId) {
		this.numDocumentId = numDocumentId;
	}

	public Integer getNumSignFlag() {
		return numSignFlag;
	}

	public void setNumSignFlag(Integer numSignFlag) {
		this.numSignFlag = numSignFlag;
	}

	public Integer getNumStatus() {
		return numStatus;
	}

	public void setNumStatus(Integer numStatus) {
		this.numStatus = numStatus;
	}

	public Integer getNumUserId() {
		return numUserId;
	}

	public void setNumUserId(Integer numUserId) {
		this.numUserId = numUserId;
	}

	public Integer getNumVerifyBy() {
		return numVerifyBy;
	}

	public void setNumVerifyBy(Integer numVerifyBy) {
		this.numVerifyBy = numVerifyBy;
	}

	public Integer getNumTypeId() {
		return numTypeId;
	}

	public void setNumTypeId(Integer numTypeId) {
		this.numTypeId = numTypeId;
	}

	public String getStrFilename() {
		return strFilename;
	}

	public void setStrFilename(String strFilename) {
		this.strFilename = strFilename;
	}

	public String getStrHashCode() {
		return strHashCode;
	}

	public void setStrHashCode(String strHashCode) {
		this.strHashCode = strHashCode;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	public String getStrSerialType() {
		return strSerialType;
	}

	public void setStrSerialType(String strSerialType) {
		this.strSerialType = strSerialType;
	}

	public String getXmlData() {
		return xmlData;
	}

	public void setXmlData(String xmlData) {
		this.xmlData = xmlData;
	}

	public String getStrSourcePortname() {
		return strSourcePortname;
	}

	public void setStrSourcePortname(String strSourcePortname) {
		this.strSourcePortname = strSourcePortname;
	}

	public String getStrLandingPortname() {
		return strLandingPortname;
	}

	public void setStrLandingPortname(String strLandingPortname) {
		this.strLandingPortname = strLandingPortname;
	}

	public String getStrCountryOfExp() {
		return strCountryOfExp;
	}

	public void setStrCountryOfExp(String strCountryOfExp) {
		this.strCountryOfExp = strCountryOfExp;
	}
	
}
