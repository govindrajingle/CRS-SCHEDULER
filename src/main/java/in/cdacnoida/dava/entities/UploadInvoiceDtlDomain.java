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
//@Table(name="upload_inv_dtl")
public class UploadInvoiceDtlDomain extends TransactionInfoDomain  implements Serializable {

	private static final long serialVersionUID = -6048595144903121228L;
	@Id
	@Column(name="num_inv_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1000, allocationSize=1)
	Integer numInvId; 
	
	@Column(name="num_upload_id")
	Integer numUploadId;
	
	@Column(name="num_inst_id")
	Integer numInstId;
	
	@Column(name="str_po_no")
	String strPONo;
	
	@Column(name="str_inv_no")
	String strInvNo;
	
	@Column(name="dt_inv_date")
	Date dtInvDate;
	
	@Column(name="num_status")
	Integer numStatus;
	
	@Column(name="str_remarks")
	String strRemarks;

	public Integer getNumInvId() {
		return numInvId;
	}

	public void setNumInvId(Integer numInvId) {
		this.numInvId = numInvId;
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

	public String getStrPONo() {
		return strPONo;
	}

	public void setStrPONo(String strPONo) {
		this.strPONo = strPONo;
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