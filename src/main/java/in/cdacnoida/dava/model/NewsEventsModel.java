package in.cdacnoida.dava.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import in.cdacnoida.dava.misc.ValidationGroups.MemberDetails;

public class NewsEventsModel {

	int numEventId;
	int numEventType;
	String eventDate;
	String details;
	String status;
	String publishDate;
	String validUpto;
	String approveBy;
	
	int numDocId;
	String strDocId;
	public int getNumEventId() {
		return numEventId;
	}
	public void setNumEventId(int numEventId) {
		this.numEventId = numEventId;
	}
	public int getNumEventType() {
		return numEventType;
	}
	public void setNumEventType(int numEventType) {
		this.numEventType = numEventType;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getValidUpto() {
		return validUpto;
	}
	public void setValidUpto(String validUpto) {
		this.validUpto = validUpto;
	}
	public String getApproveBy() {
		return approveBy;
	}
	public void setApproveBy(String approveBy) {
		this.approveBy = approveBy;
	}
	public int getNumDocId() {
		return numDocId;
	}
	public void setNumDocId(int numDocId) {
		this.numDocId = numDocId;
	}
	public String getStrDocId() {
		return strDocId;
	}
	public void setStrDocId(String strDocId) {
		this.strDocId = strDocId;
	}
	
	
	
	
	
}
