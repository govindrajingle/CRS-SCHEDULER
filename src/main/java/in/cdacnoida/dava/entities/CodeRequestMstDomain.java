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
@Table(name="code_req_mst")
public class CodeRequestMstDomain extends TransactionInfoDomain implements Serializable{

	private static final long serialVersionUID = -6048595144903121228L;
	
	@Id
	@Column(name="num_req_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1000, allocationSize=1)
	int numRequestId; 
	
	@Column(name="num_inst_id")
	int instId;
	
	@Column(name="num_pack_level")
	int packLevel;
	
	@Column(name="num_pack_type")
	int packType;
	
	@Column(name="dt_dispatch_date")
	Date dtDispatchDate;
	
	@Column(name="num_status")
	int status;
	
	@Column(name="num_noofcode_req")
	Integer codeCount;

	public int getNumRequestId() {
		return numRequestId;
	}

	public void setNumRequestId(int numRequestId) {
		this.numRequestId = numRequestId;
	}

	public int getInstId() {
		return instId;
	}

	public void setInstId(int instId) {
		this.instId = instId;
	}

	public int getPackLevel() {
		return packLevel;
	}

	public void setPackLevel(int packLevel) {
		this.packLevel = packLevel;
	}

	public int getPackType() {
		return packType;
	}

	public void setPackType(int packType) {
		this.packType = packType;
	}

	public Date getDtDispatchDate() {
		return dtDispatchDate;
	}

	public void setDtDispatchDate(Date dtDispatchDate) {
		this.dtDispatchDate = dtDispatchDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Integer getCodeCount() {
		return codeCount;
	}

	public void setCodeCount(Integer codeCount) {
		this.codeCount = codeCount;
	}
	
}
