package in.cdacnoida.dava.entities;



import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gemreporthistory")
public class BOOTCRSGemReportHistory {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "download_id", unique = true)
    private String downloadId;

    @Column(name = "log_dt")
    private LocalDateTime logDt;

    @Column(name = "download_date")
    private String downloadDate;

    @Column(name = "validity")
    private LocalDateTime validity;

    @Column(name = "isvalid")
    private Integer isvalid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDownloadId() {
		return downloadId;
	}

	public void setDownloadId(String downloadId) {
		this.downloadId = downloadId;
	}

	public LocalDateTime getLogDt() {
		return logDt;
	}

	public void setLogDt(LocalDateTime logDt) {
		this.logDt = logDt;
	}

	public String getDownloadDate() {
		return downloadDate;
	}

	public void setDownloadDate(String downloadDate) {
		this.downloadDate = downloadDate;
	}

	public LocalDateTime getValidity() {
		return validity;
	}

	public void setValidity(LocalDateTime validity) {
		this.validity = validity;
	}

	public Integer getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(Integer isvalid) {
		this.isvalid = isvalid;
	}


}