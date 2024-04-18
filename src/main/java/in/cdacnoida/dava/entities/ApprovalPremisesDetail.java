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
@Table(name="approval_premises_dtl")
public class ApprovalPremisesDetail extends TransactionInfoDomain implements Serializable{
	
	private static final long serialVersionUID = -6048595144903121228L;
	
	@Id
	@Column(name="num_approval_no")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1000, allocationSize=1)
	int numAppNo; 
	
	@Column(name="num_premises_no")
	int numPremisesNo;
	
	@Column(name="num_inst_id")
	int numInstId;
	
	@Column(name="num_app_type_id")
	int numAppTypeId;
	
	@Column(name="str_app_no")
	String strAppNo;
	
	@Column(name="str_issuing_auth")
	String strIssuingAuth;
	
	@Column(name="dt_issue_dt")
	Date dtIssueDt;
	
	@Column(name="dt_expiry_dt")
	Date dtExpiryDt;
	
	@Column(name="str_remarks")
	String strRemarks;
	
	@Column(name="num_status")
	int numStatus;

	public int getNumAppNo() {
		return numAppNo;
	}

	public void setNumAppNo(int numAppNo) {
		this.numAppNo = numAppNo;
	}

	public int getNumPremisesNo() {
		return numPremisesNo;
	}

	public void setNumPremisesNo(int numPremisesNo) {
		this.numPremisesNo = numPremisesNo;
	}

	public int getNumInstId() {
		return numInstId;
	}

	public void setNumInstId(int numInstId) {
		this.numInstId = numInstId;
	}

	public int getNumAppTypeId() {
		return numAppTypeId;
	}

	public void setNumAppTypeId(int numAppTypeId) {
		this.numAppTypeId = numAppTypeId;
	}

	public String getStrAppNo() {
		return strAppNo;
	}

	public void setStrAppNo(String strAppNo) {
		this.strAppNo = strAppNo;
	}

	public String getStrIssuingAuth() {
		return strIssuingAuth;
	}

	public void setStrIssuingAuth(String strIssuingAuth) {
		this.strIssuingAuth = strIssuingAuth;
	}

	public Date getDtIssueDt() {
		return dtIssueDt;
	}

	public void setDtIssueDt(Date dtIssueDt) {
		this.dtIssueDt = dtIssueDt;
	}

	public Date getDtExpiryDt() {
		return dtExpiryDt;
	}

	public void setDtExpiryDt(Date dtExpiryDt) {
		this.dtExpiryDt = dtExpiryDt;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	public int getNumStatus() {
		return numStatus;
	}

	public void setNumStatus(int numStatus) {
		this.numStatus = numStatus;
	}

}
