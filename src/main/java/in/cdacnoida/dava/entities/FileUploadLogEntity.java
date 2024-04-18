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
//@Table(name = "user_fileupload_log")
public class FileUploadLogEntity extends TransactionInfoDomain implements Serializable{
	
	private static final long serialVersionUID = -6048595144903121228L;
	
	@Id
	@Column(name="num_seqno")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1000, allocationSize=1)
	Integer numSeqNo; 
	
	@Column(name="num_user_id")
	Long numUserId;
	
	@Column(name="str_file_name")
	String strFileName;
	
	@Column(name="dt_upload_date")
	Date dtUploadDate;

	public Integer getNumSeqNo() {
		return numSeqNo;
	}

	public void setNumSeqNo(Integer numSeqNo) {
		this.numSeqNo = numSeqNo;
	}

	public Long getNumUserId() {
		return numUserId;
	}

	public void setNumUserId(Long numUserId) {
		this.numUserId = numUserId;
	}

	public String getStrFileName() {
		return strFileName;
	}

	public void setStrFileName(String strFileName) {
		this.strFileName = strFileName;
	}

	public Date getDtUploadDate() {
		return dtUploadDate;
	}

	public void setDtUploadDate(Date dtUploadDate) {
		this.dtUploadDate = dtUploadDate;
	}
	

}
