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
//@Table(name="procurement_mst")
public class ProcurementMstDomain extends TransactionInfoDomain implements Serializable{
	
	private static final long serialVersionUID = -6048595144903121228L;
	
	@Id
	@Column(name="num_procurement_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1000, allocationSize=1)
	int numProcurementId; 
	
	@Column(name="num_inst_id")
	int numInstId;
	
	@Column(name="num_invoice_no")
	int numInvoiceNo;
	
	@Column(name="num_premises_no")
	int numPremisesNo;
	
	@Column(name="str_premise_name")
	String strPremiseName;
	
	@Column(name="str_premise_address")
	String strPremiseAddress;
	
	@Column(name="str_contact_number")
	String strContactNumber;
	
	@Column(name="num_drug_id")
	int numDrugId;
	
	@Column(name="str_prod_name")
	String strProdName;
	
	@Column(name="str_prod_code")
	String strProdCode;
	
	@Column(name="str_batch_number")
	String strBatchNumber;
	
	@Column(name="dt_exp_date")
	Date dtExpDate;
	
	@Column(name="num_site_type")
	int numSiteType;
	
	@Column(name="str_drug_lic_no")
	String strDrugLicenseNo;
	
	@Column(name="str_gstin")
	String strGSTIN;

	public int getNumProcurementId() {
		return numProcurementId;
	}

	public void setNumProcurementId(int numProcurementId) {
		this.numProcurementId = numProcurementId;
	}

	public int getNumInvoiceNo() {
		return numInvoiceNo;
	}

	public void setNumInvoiceNo(int numInvoiceNo) {
		this.numInvoiceNo = numInvoiceNo;
	}

	public int getNumPremisesNo() {
		return numPremisesNo;
	}

	public void setNumPremisesNo(int numPremisesNo) {
		this.numPremisesNo = numPremisesNo;
	}

	public String getStrPremiseName() {
		return strPremiseName;
	}

	public void setStrPremiseName(String strPremiseName) {
		this.strPremiseName = strPremiseName;
	}

	public String getStrPremiseAddress() {
		return strPremiseAddress;
	}

	public void setStrPremiseAddress(String strPremiseAddress) {
		this.strPremiseAddress = strPremiseAddress;
	}

	public String getStrContactNumber() {
		return strContactNumber;
	}

	public void setStrContactNumber(String strContactNumber) {
		this.strContactNumber = strContactNumber;
	}

	public int getNumDrugId() {
		return numDrugId;
	}

	public void setNumDrugId(int numDrugId) {
		this.numDrugId = numDrugId;
	}

	public String getStrProdName() {
		return strProdName;
	}

	public void setStrProdName(String strProdName) {
		this.strProdName = strProdName;
	}

	public String getStrProdCode() {
		return strProdCode;
	}

	public void setStrProdCode(String strProdCode) {
		this.strProdCode = strProdCode;
	}

	public String getStrBatchNumber() {
		return strBatchNumber;
	}

	public void setStrBatchNumber(String strBatchNumber) {
		this.strBatchNumber = strBatchNumber;
	}

	public Date getDtExpDate() {
		return dtExpDate;
	}

	public void setDtExpDate(Date dtExpDate) {
		this.dtExpDate = dtExpDate;
	}

	public int getNumSiteType() {
		return numSiteType;
	}

	public void setNumSiteType(int numSiteType) {
		this.numSiteType = numSiteType;
	}

	public String getStrDrugLicenseNo() {
		return strDrugLicenseNo;
	}

	public void setStrDrugLicenseNo(String strDrugLicenseNo) {
		this.strDrugLicenseNo = strDrugLicenseNo;
	}

	public String getStrGSTIN() {
		return strGSTIN;
	}

	public void setStrGSTIN(String strGSTIN) {
		this.strGSTIN = strGSTIN;
	}

	public int getNumInstId() {
		return numInstId;
	}

	public void setNumInstId(int numInstId) {
		this.numInstId = numInstId;
	}

}
