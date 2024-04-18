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



@Entity
@Table(name = "upload_data_dtl")
public class UploadXmlDataDtlDomain extends TransactionInfoDomain implements Serializable {
	private static final long serialVersionUID = -9170913258269305131L;

	@Id
	@Column(name = "num_upload_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	int numUploadId;
	
	@Column(name = "num_inst_id")
	int numInstId; 
	
	@Column(name="num_type_id")
	int num_purposeTypeId;
	
	@Column(name="str_serial_type")
	String strSerialType;
	
	@Column(name="str_filename")
	String strFilename;
	
	@Column(name = "dt_file_date")
	Date dtFileDate;
	
	@Column(name="num_doc_size")
	int numDocSize;
	
	@Column(name="num_document_id")
	int numDocumentId;
	
	@Column(name = "dt_expiry_date")
	Date dtExpiryDate;
	
	@Column(name = "NUM_SIGN_FLAG")
	int numSignFlag;
	
	@Column(name="num_status")
	int numStatus;
	
	@Column(name = "num_user_id")
	int numUserId; 
	
	@Column(name = "num_verify_by")
	int numVerifyBy;
	
	@Column(name="str_hash_code")
	String strHashCode; 
	
	@Column(name="str_remarks")
	String strRmarks;
	
	@Column(name="xml_data")
	String xmlData;

	@Column(name="str_ackreceipt_filename")
	String strAckReceipt;
	
	@Column(name="str_ackreceipt_filepath")
	String strAckReceiptPath;
	
	public String getStrAckReceiptPath() {
		return strAckReceiptPath;
	}

	public void setStrAckReceiptPath(String strAckReceiptPath) {
		this.strAckReceiptPath = strAckReceiptPath;
	}

	@Column(name="num_invoice_no")
	int invoiceNum;
	
	
	public String getStrAckReceipt() {
		return strAckReceipt;
	}

	public void setStrAckReceipt(String strAckReceipt) {
		this.strAckReceipt = strAckReceipt;
	}

	public int getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(int invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	public int getNumUploadId() {
		return numUploadId;
	}

	public void setNumUploadId(int numUploadId) {
		this.numUploadId = numUploadId;
	}

	public int getNumInstId() {
		return numInstId;
	}

	public void setNumInstId(int numInstId) {
		this.numInstId = numInstId;
	}

	public int getNum_purposeTypeId() {
		return num_purposeTypeId;
	}

	public void setNum_purposeTypeId(int num_purposeTypeId) {
		this.num_purposeTypeId = num_purposeTypeId;
	}

	public String getStrSerialType() {
		return strSerialType;
	}

	public void setStrSerialType(String strSerialType) {
		this.strSerialType = strSerialType;
	}

	public String getStrFilename() {
		return strFilename;
	}

	public void setStrFilename(String strFilename) {
		this.strFilename = strFilename;
	}

	public Date getDtFileDate() {
		return dtFileDate;
	}

	public void setDtFileDate(Date dtFileDate) {
		this.dtFileDate = dtFileDate;
	}

	public int getNumDocSize() {
		return numDocSize;
	}

	public void setNumDocSize(int numDocSize) {
		this.numDocSize = numDocSize;
	}

	public int getNumDocumentId() {
		return numDocumentId;
	}

	public void setNumDocumentId(int numDocumentId) {
		this.numDocumentId = numDocumentId;
	}

	public Date getDtExpiryDate() {
		return dtExpiryDate;
	}

	public void setDtExpiryDate(Date dtExpiryDate) {
		this.dtExpiryDate = dtExpiryDate;
	}

	public int getNumSignFlag() {
		return numSignFlag;
	}

	public void setNumSignFlag(int numSignFlag) {
		this.numSignFlag = numSignFlag;
	}

	public int getNumStatus() {
		return numStatus;
	}

	public void setNumStatus(int numStatus) {
		this.numStatus = numStatus;
	}

	public int getNumUserId() {
		return numUserId;
	}

	public void setNumUserId(int numUserId) {
		this.numUserId = numUserId;
	}

	public int getNumVerifyBy() {
		return numVerifyBy;
	}

	public void setNumVerifyBy(int numVerifyBy) {
		this.numVerifyBy = numVerifyBy;
	}

	public String getStrHashCode() {
		return strHashCode;
	}

	public void setStrHashCode(String strHashCode) {
		this.strHashCode = strHashCode;
	}

	public String getStrRmarks() {
		return strRmarks;
	}

	public void setStrRmarks(String strRmarks) {
		this.strRmarks = strRmarks;
	}

	public String getXmlData() {
		return xmlData;
	}

	public void setXmlData(String xmlData) {
		this.xmlData = xmlData;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
