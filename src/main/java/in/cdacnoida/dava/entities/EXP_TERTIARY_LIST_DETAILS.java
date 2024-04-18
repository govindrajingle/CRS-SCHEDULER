package in.cdacnoida.dava.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table
public class EXP_TERTIARY_LIST_DETAILS {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	private Long lng_user_id;
	
	
	private Integer docId;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	private ConsignmentDetailsEntity consignmentDetailsEntity;
	
	@UpdateTimestamp 
	private LocalDateTime lastUpdatedDate;
	 
	@CreationTimestamp 
	private LocalDateTime createdDate;
	 
	public Long getLng_user_id() {
		return lng_user_id;
	}
	public void setLng_user_id(Long lng_user_id) {
		this.lng_user_id = lng_user_id;
	}
	public Integer getDocId() {
		return docId;
	}
	public void setDocId(Integer docId) {
		this.docId = docId;
	}
	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public ConsignmentDetailsEntity getConsignmentDetailsEntity() {
		return consignmentDetailsEntity;
	}
	public void setConsignmentDetailsEntity(ConsignmentDetailsEntity consignmentDetailsEntity) {
		this.consignmentDetailsEntity = consignmentDetailsEntity;
	}
	
	
	
}
