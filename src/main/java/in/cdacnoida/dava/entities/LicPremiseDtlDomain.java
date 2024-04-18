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
//@Table(name="institute_licence_dtl")
public class LicPremiseDtlDomain extends TransactionInfoDomain   implements Serializable{

	private static final long serialVersionUID = -6048595144903121228L;
	@Id
	@Column(name="num_licence_no")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1000, allocationSize=1)
	int numLicenceNo; 
	
	@Column(name="num_inst_id")
	int numInstId;
	
	@Column(name="num_premises_no")
	int numPremisesNo;
	
	@Column(name="num_licence_type_id")
	int numLicenceTypeId;
	
	@Column(name="str_licence_no")
	String strLicenceNo;
	
	@Column(name="str_issuing_auth")
	String strIssuingAuth;
	
	@Column(name="dt_issue_dt")
	Date fromDate;
	
	@Column(name="dt_expiry_dt")
	Date toDate;
	
	@Column(name="str_remarks")
	String strRemarks;

	public int getNumLicenceNo() {
		return numLicenceNo;
	}

	public void setNumLicenceNo(int numLicenceNo) {
		this.numLicenceNo = numLicenceNo;
	}

	public int getNumInstId() {
		return numInstId;
	}

	public void setNumInstId(int numInstId) {
		this.numInstId = numInstId;
	}

	public int getNumPremisesNo() {
		return numPremisesNo;
	}

	public void setNumPremisesNo(int numPremisesNo) {
		this.numPremisesNo = numPremisesNo;
	}

	public int getNumLicenceTypeId() {
		return numLicenceTypeId;
	}

	public void setNumLicenceTypeId(int numLicenceTypeId) {
		this.numLicenceTypeId = numLicenceTypeId;
	}

	public String getStrLicenceNo() {
		return strLicenceNo;
	}

	public void setStrLicenceNo(String strLicenceNo) {
		this.strLicenceNo = strLicenceNo;
	}

	public String getStrIssuingAuth() {
		return strIssuingAuth;
	}

	public void setStrIssuingAuth(String strIssuingAuth) {
		this.strIssuingAuth = strIssuingAuth;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	
}
