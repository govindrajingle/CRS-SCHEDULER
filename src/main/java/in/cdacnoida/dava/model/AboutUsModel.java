package in.cdacnoida.dava.model;

import java.time.LocalDateTime;

public class AboutUsModel {
	
	int numTypeId;
	Long numUserId;
	String aboutUs;
	LocalDateTime lastUpdatedDate;
	
	public int getNumTypeId() {
		return numTypeId;
	}
	public void setNumTypeId(int numTypeId) {
		this.numTypeId = numTypeId;
	}
	public Long getNumUserId() {
		return numUserId;
	}
	public void setNumUserId(Long numUserId) {
		this.numUserId = numUserId;
	}
	public String getAboutUs() {
		return aboutUs;
	}
	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}
	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	

}
