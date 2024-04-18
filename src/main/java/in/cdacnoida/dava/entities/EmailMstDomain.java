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
//@Table(name = "mail_type_mst")
public class EmailMstDomain extends TransactionInfoDomain implements Serializable {

	private static final long serialVersionUID = -9170913258269305131L;
	
	@Id
	@Column(name = "num_mail_type_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")  
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	int numMailTypeId; //Primary Key
	
	@Column(name = "str_mail_type_name") 
	String mailTypeName;
	
	@Column(name = "str_remarks") 
	String remarks;
	

	public int getNumMailTypeId() {
		return numMailTypeId;
	}

	public void setNumMailTypeId(int numMailTypeId) {
		this.numMailTypeId = numMailTypeId;
	}

	public String getMailTypeName() {
		return mailTypeName;
	}

	public void setMailTypeName(String mailTypeName) {
		this.mailTypeName = mailTypeName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	
}
