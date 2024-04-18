package in.cdacnoida.dava.model;

import java.util.Date;

public class EmailDetailForm {

	private int numMailId;
	private String strSendTo;
	private String subject;
	private String body;
	private Long numSendTo;
	private int mailTypeId;
	private int numIsValid;
	private Date dtTrDate;
	private int  numTrUserId;
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
	public int getNumIsValid() {
		return numIsValid;
	}
	public void setNumIsValid(int numIsValid) {
		this.numIsValid = numIsValid;
	}
	public Date getDtTrDate() {
		return dtTrDate;
	}
	public void setDtTrDate(Date dtTrDate) {
		this.dtTrDate = dtTrDate;
	}
	public int getNumTrUserId() {
		return numTrUserId;
	}
	public void setNumTrUserId(int numTrUserId) {
		this.numTrUserId = numTrUserId;
	}
	
	
}
