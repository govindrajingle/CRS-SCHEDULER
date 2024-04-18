package in.cdacnoida.dava.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;



//@Entity
//@Table(name="event_gallery")
public class galleryFormentity {
	@Id
	@Column(name = "galleryId")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	
	 //@Column(columnDefinition = "serial")
	//private Long galleryId;
	
	
	private String galleryId;
	
	@Column(name="str_eventName")
	private String eventName;
	
	@Column(name="str_eventPlace")
	private String eventPlace;
	
	@Column(name="dt_eventDate" ,length=12)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date eventDate;
	
	@Column(name="dt_eventPublishDate",length=12)
	private Date eventPublishDate;

	@Column(name="dt_eventExpiryDate",length=12)
	private Date eventExpiryDate;
	
	@Column(name="str_gallery_imagepath")
	private String galleryImage;
	
	@Column	
	private Integer num_isvalid;
	
	



	public Integer getNum_isvalid() {
		return num_isvalid;
	}

	public void setNum_isvalid(Integer num_isvalid) {
		this.num_isvalid = num_isvalid;
	}

	public String getGalleryImage() {
		return galleryImage;
	}

	public void setGalleryImage(String galleryImage) {
		this.galleryImage = galleryImage;
	}

	
	
	/*
	 * public Long getGalleryId() { return galleryId; }
	 * 
	 * public void setGalleryId(Long galleryId) { this.galleryId = galleryId; }
	 */
	

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventPlace() {
		return eventPlace;
	}

	public void setEventPlace(String eventPlace) {
		this.eventPlace = eventPlace;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public Date getEventPublishDate() {
		return eventPublishDate;
	}

	public void setEventPublishDate(Date eventPublishDate) {
		this.eventPublishDate = eventPublishDate;
	}

	public Date getEventExpiryDate() {
		return eventExpiryDate;
	}

	public void setEventExpiryDate(Date eventExpiryDate) {
		this.eventExpiryDate = eventExpiryDate;
	}

	public String getGalleryId() {
		return galleryId;
	}

	public void setGalleryId(String galleryId) {
		this.galleryId = galleryId;
	}

	

	

	


}
