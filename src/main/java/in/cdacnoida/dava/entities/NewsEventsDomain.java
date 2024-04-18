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
////@Cacheable
////@javax.persistence.Cacheable
////@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
//@Table(name = "news_event_dtl")
public class NewsEventsDomain extends TransactionInfoDomain{



	@Id
	@Column(name="num_event_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1, allocationSize = 1)
	private Integer numEventId;
	
	@Column(name="num_event_type")
	private int numEventType;
	
	@Column(name="dt_of_event_occur")
	private Date dtOfEventOccur;
	
	@Column(name="str_details")
	private String strDetails;
	
	@Column(name="str_status")
	private String strStatus;
	
	@Column(name="publish_date")
	private Date publishDate;
	
	@Column(name="valid_upto")
	private Date validUpto;
	
	@Column(name="approve_by")
	private String approveBy;

	public Integer getNumEventId() {
		return numEventId;
	}

	public void setNumEventId(Integer numEventId) {
		this.numEventId = numEventId;
	}

	

	public int getNumEventType() {
		return numEventType;
	}

	public void setNumEventType(int numEventType) {
		this.numEventType = numEventType;
	}

	public Date getDtOfEventOccur() {
		return dtOfEventOccur;
	}

	public void setDtOfEventOccur(Date dtOfEventOccur) {
		this.dtOfEventOccur = dtOfEventOccur;
	}

	public String getStrDetails() {
		return strDetails;
	}

	public void setStrDetails(String strDetails) {
		this.strDetails = strDetails;
	}

	public String getStrStatus() {
		return strStatus;
	}

	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getValidUpto() {
		return validUpto;
	}

	public void setValidUpto(Date validUpto) {
		this.validUpto = validUpto;
	}

	public String getApproveBy() {
		return approveBy;
	}

	public void setApproveBy(String approveBy) {
		this.approveBy = approveBy;
	}

	
	
	
	
}
