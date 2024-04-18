package in.cdacnoida.dava.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="code_req_dtl")
public class CodeReqDtlDomain extends TransactionInfoDomain implements Serializable{
	
	private static final long serialVersionUID = -6048595144903121228L;
	
	@Id
	@Column(name="num_req_id")
	int numReqId;
	
	@Column(name="num_inst_id")
	int instId;
	
	@Column(name="str_pack_code")
	String strPackCode;
	
	@Column(name="num_status")
	int numStatus;

	public int getNumReqId() {
		return numReqId;
	}

	public void setNumReqId(int numReqId) {
		this.numReqId = numReqId;
	}

	public int getInstId() {
		return instId;
	}

	public void setInstId(int instId) {
		this.instId = instId;
	}

	public String getStrPackCode() {
		return strPackCode;
	}

	public void setStrPackCode(String strPackCode) {
		this.strPackCode = strPackCode;
	}

	public int getNumStatus() {
		return numStatus;
	}

	public void setNumStatus(int numStatus) {
		this.numStatus = numStatus;
	}
}
