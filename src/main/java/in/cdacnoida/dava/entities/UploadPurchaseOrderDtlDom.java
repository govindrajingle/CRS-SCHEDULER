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
//@Table(name="upload_po_dtl")
public class UploadPurchaseOrderDtlDom extends TransactionInfoDomain  implements Serializable{

	private static final long serialVersionUID = -6048595144903121228L;
	@Id
	@Column(name="num_po_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1000, allocationSize=1)
	Integer numPOId; 
	
	@Column(name="num_upload_id")
	Integer numUploadId;
	
	@Column(name="num_inst_id")
	Integer numInstId;
	
	@Column(name="num_premise_no")
	Integer numPremiseNo;
	
	@Column(name="str_po_no")
	String strPONo;
	
	@Column(name="dt_po_date")
	Date dtPODate;
	
	@Column(name="str_company_name")
	String strCompanyName;
	
	@Column(name="str_Company_Add")
	String strCompanyAdd;
	
	@Column(name="str_country_name")
	String strCountryName;
	
	@Column(name="num_country_id")
	Integer numCountryId;
	
	@Column(name="num_status")
	Integer numStatus;
	
	@Column(name="str_remarks")
	String strRemarks;

	public Integer getNumPOId() {
		return numPOId;
	}

	public void setNumPOId(Integer numPOId) {
		this.numPOId = numPOId;
	}

	public Integer getNumUploadId() {
		return numUploadId;
	}

	public void setNumUploadId(Integer numUploadId) {
		this.numUploadId = numUploadId;
	}

	public Integer getNumInstId() {
		return numInstId;
	}

	public void setNumInstId(Integer numInstId) {
		this.numInstId = numInstId;
	}

	public Integer getNumPremiseNo() {
		return numPremiseNo;
	}

	public void setNumPremiseNo(Integer numPremiseNo) {
		this.numPremiseNo = numPremiseNo;
	}

	public String getStrPONo() {
		return strPONo;
	}

	public void setStrPONo(String strPONo) {
		this.strPONo = strPONo;
	}

	public Date getDtPODate() {
		return dtPODate;
	}

	public void setDtPODate(Date dtPODate) {
		this.dtPODate = dtPODate;
	}

	public String getStrCompanyName() {
		return strCompanyName;
	}

	public void setStrCompanyName(String strCompanyName) {
		this.strCompanyName = strCompanyName;
	}

	public String getStrCompanyAdd() {
		return strCompanyAdd;
	}

	public void setStrCompanyAdd(String strCompanyAdd) {
		this.strCompanyAdd = strCompanyAdd;
	}

	public String getStrCountryName() {
		return strCountryName;
	}

	public void setStrCountryName(String strCountryName) {
		this.strCountryName = strCountryName;
	}

	public Integer getNumCountryId() {
		return numCountryId;
	}

	public void setNumCountryId(Integer numCountryId) {
		this.numCountryId = numCountryId;
	}

	public Integer getNumStatus() {
		return numStatus;
	}

	public void setNumStatus(Integer numStatus) {
		this.numStatus = numStatus;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

}