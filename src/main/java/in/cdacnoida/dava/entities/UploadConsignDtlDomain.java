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
//@Table(name="upload_consig_dtl")
public class UploadConsignDtlDomain extends TransactionInfoDomain  implements Serializable{

	private static final long serialVersionUID = -6048595144903121228L;
	@Id
	@Column(name="num_inv_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1000, allocationSize=1)
	Integer numInvNo; 
	
	@Column(name="num_upload_id")
	Integer numUploadId;
	
	@Column(name="num_inst_id")
	Integer numInstId;
	
	@Column(name="str_invoice_no")
	String strInvNo;
	
	@Column(name="dt_inv_date")
	Date dtInvDate;
	
	@Column(name="str_country_of_exp")
	String strExpCountry;
	
	@Column(name="str_region_cd")
	String strRegionCode;
	
	@Column(name="str_source_portname")
	String strSourcePortName;
	
	@Column(name="str_landing_portname")
	String strLandingPort;
	  
	@Column(name="num_primary_count")
	Integer numPrimaryCount;
	  
	@Column(name="num_s1_count")
	Integer numS1Count;
	  
	@Column(name="num_s2_count")
	Integer numS2Count;
	  
	@Column(name="num_s3_count")
	Integer numS3Count;
	  
	@Column(name="num_tertiary_count")
	Integer numTertiaryCount;
	
	@Column(name="num_status")
	Integer numStatus;
	
	@Column(name="str_remarks")
	String strRemarks;

	public Integer getNumInvNo() {
		return numInvNo;
	}

	public void setNumInvNo(Integer numInvNo) {
		this.numInvNo = numInvNo;
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

	public String getStrInvNo() {
		return strInvNo;
	}

	public void setStrInvNo(String strInvNo) {
		this.strInvNo = strInvNo;
	}

	public Date getDtInvDate() {
		return dtInvDate;
	}

	public void setDtInvDate(Date dtInvDate) {
		this.dtInvDate = dtInvDate;
	}

	public String getStrExpCountry() {
		return strExpCountry;
	}

	public void setStrExpCountry(String strExpCountry) {
		this.strExpCountry = strExpCountry;
	}

	public String getStrRegionCode() {
		return strRegionCode;
	}

	public void setStrRegionCode(String strRegionCode) {
		this.strRegionCode = strRegionCode;
	}

	public String getStrSourcePortName() {
		return strSourcePortName;
	}

	public void setStrSourcePortName(String strSourcePortName) {
		this.strSourcePortName = strSourcePortName;
	}

	public String getStrLandingPort() {
		return strLandingPort;
	}

	public void setStrLandingPort(String strLandingPort) {
		this.strLandingPort = strLandingPort;
	}

	public Integer getNumPrimaryCount() {
		return numPrimaryCount;
	}

	public void setNumPrimaryCount(Integer numPrimaryCount) {
		this.numPrimaryCount = numPrimaryCount;
	}

	public Integer getNumS1Count() {
		return numS1Count;
	}

	public void setNumS1Count(Integer numS1Count) {
		this.numS1Count = numS1Count;
	}

	public Integer getNumS2Count() {
		return numS2Count;
	}

	public void setNumS2Count(Integer numS2Count) {
		this.numS2Count = numS2Count;
	}

	public Integer getNumS3Count() {
		return numS3Count;
	}

	public void setNumS3Count(Integer numS3Count) {
		this.numS3Count = numS3Count;
	}

	public Integer getNumTertiaryCount() {
		return numTertiaryCount;
	}

	public void setNumTertiaryCount(Integer numTertiaryCount) {
		this.numTertiaryCount = numTertiaryCount;
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