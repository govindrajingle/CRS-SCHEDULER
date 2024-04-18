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

/**
* The DocumentMasterDomain an class that is a Domain Class
* that is a entity which is mapping of 'document_mst' table
* from database for hibernate ORM.
*/

@Entity
@Table(name = "document_mst")
public class DocumentMasterDomain extends TransactionInfoDomain implements Serializable 
{
	private static final long serialVersionUID = -9170913258269305131L;

	@Id
	@Column(name = "num_document_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	int numDocumentId;
	
	@Column(name="num_doc_size")
	int numDocSize;
	
	@Column(name="num_file_slno")
	int numFileSlno;
	
	@Column(name = "NUM_SIGN_FLAG")
	int numSignFlag;
	
	@Column(name = "NUM_VERIFY_BY") 
	int numVerifyBy;
	
	@Column(name = "STR_EXPERT_ID") 
	String strExpertId;
	
	@Column(name="str_filename")
	String strFilename;
	
	@Column(name="str_Remarks")
	String strRmarks;
	
	@Column(name = "DT_EXPIRY_DATE")
	Date dtExpiryDate;
	
	@Column(name = "NUM_AGENCY_ID")
	int numAgencyId; 
	
	@Column(name="str_status")
	String strStatus;

	public int getNumDocumentId() {
		return numDocumentId;
	}

	public void setNumDocumentId(int numDocumentId) {
		this.numDocumentId = numDocumentId;
	}

	public int getNumDocSize() {
		return numDocSize;
	}

	public void setNumDocSize(int numDocSize) {
		this.numDocSize = numDocSize;
	}

	public int getNumFileSlno() {
		return numFileSlno;
	}

	public void setNumFileSlno(int numFileSlno) {
		this.numFileSlno = numFileSlno;
	}

	public int getNumSignFlag() {
		return numSignFlag;
	}

	public void setNumSignFlag(int numSignFlag) {
		this.numSignFlag = numSignFlag;
	}

	public int getNumVerifyBy() {
		return numVerifyBy;
	}

	public void setNumVerifyBy(int numVerifyBy) {
		this.numVerifyBy = numVerifyBy;
	}

	public String getStrExpertId() {
		return strExpertId;
	}

	public void setStrExpertId(String strExpertId) {
		this.strExpertId = strExpertId;
	}

	public String getStrFilename() {
		return strFilename;
	}

	public void setStrFilename(String strFilename) {
		this.strFilename = strFilename;
	}

	public String getStrRmarks() {
		return strRmarks;
	}

	public void setStrRmarks(String strRmarks) {
		this.strRmarks = strRmarks;
	}

	public Date getDtExpiryDate() {
		return dtExpiryDate;
	}

	public void setDtExpiryDate(Date dtExpiryDate) {
		this.dtExpiryDate = dtExpiryDate;
	}

	public int getNumAgencyId() {
		return numAgencyId;
	}

	public void setNumAgencyId(int numAgencyId) {
		this.numAgencyId = numAgencyId;
	}

	public String getStrStatus() {
		return strStatus;
	}

	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}
	

	
}
