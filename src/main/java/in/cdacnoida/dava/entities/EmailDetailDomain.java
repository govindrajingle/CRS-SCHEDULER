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
//@Table(name = "send_mail_dtl")
public class EmailDetailDomain extends TransactionInfoDomain implements Serializable {

	
	private static final long serialVersionUID = -9170913258269305131L;
	
	@Id
	@Column(name = "num_mailid")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")  
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	int numMailId; //Primary Key
	
	@Column(name = "str_sendto") 
	String strSendTo;
	
	@Column(name = "str_subject") 
	String subject;
	
	@Column(name = "str_body") 
	String body;
	
	@Column(name = "num_sendto") 
	Long numSendTo;
	
	@Column(name = "num_mailtype_id") 
	int mailTypeId;
	

	public int getNumMailId() {
		return numMailId;
	}

	public void setNumMailId(int numMailId) {
		this.numMailId = numMailId;
	}

	public String getStrSendTo() {
		return strSendTo;
	}

	public void setStrSendTo(String strSendTo) {
		this.strSendTo = strSendTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Long getNumSendTo() {
		return numSendTo;
	}

	public void setNumSendTo(Long numSendTo) {
		this.numSendTo = numSendTo;
	}

	public int getMailTypeId() {
		return mailTypeId;
	}

	public void setMailTypeId(int mailTypeId) {
		this.mailTypeId = mailTypeId;
	}

	
	
}
