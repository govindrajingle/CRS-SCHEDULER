package in.cdacnoida.dava.entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="other_promotion_council_data")
public class OtherPromotionCouncilDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	private Long id;
	
	@Column(length=50)
	private String strPromotionCouncilName;
	
	@Column(length=50)
	private String strRegistrationNumber;
	
	@Column(length=50)
	private Date dateValidThrough;
	
	@UpdateTimestamp
	@JsonIgnore
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private RegistrationDetails registrationDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStrPromotionCouncilName() {
		return strPromotionCouncilName;
	}

	public void setStrPromotionCouncilName(String strPromotionCouncilName) {
		this.strPromotionCouncilName = strPromotionCouncilName;
	}

	public String getStrRegistrationNumber() {
		return strRegistrationNumber;
	}

	public void setStrRegistrationNumber(String strRegistrationNumber) {
		this.strRegistrationNumber = strRegistrationNumber;
	}

	public Date getDateValidThrough() {
		return dateValidThrough;
	}

	public void setDateValidThrough(Date dateValidThrough) {
		this.dateValidThrough = dateValidThrough;
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

	public RegistrationDetails getRegistrationDetails() {
		return registrationDetails;
	}

	public void setRegistrationDetails(RegistrationDetails registrationDetails) {
		this.registrationDetails = registrationDetails;
	}

}
