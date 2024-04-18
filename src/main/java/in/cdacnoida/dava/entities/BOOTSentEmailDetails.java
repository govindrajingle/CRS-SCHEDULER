package in.cdacnoida.dava.entities;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sent_email_details")
public class BOOTSentEmailDetails {

    @Id
    @Column(name = "mail_counter")
    private Long mailCounter;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "subject")
    private String subject;

    @Column(name = "message")
    private String message;

    @Column(name = "status")
    private Integer status;

    @Column(name = "status_after_sent")
    private Integer statusAfterSent;

    @Column(name = "date_before_sent")
    private Timestamp dateBeforeSent;

    @Column(name = "date_after_sent")
    private Timestamp dateAfterSent;

    @Column(name = "pending_to_sent")
    private Integer pendingToSent;

	public Long getMailCounter() {
		return mailCounter;
	}

	public void setMailCounter(Long mailCounter) {
		this.mailCounter = mailCounter;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatusAfterSent() {
		return statusAfterSent;
	}

	public void setStatusAfterSent(Integer statusAfterSent) {
		this.statusAfterSent = statusAfterSent;
	}

	public Timestamp getDateBeforeSent() {
		return dateBeforeSent;
	}

	public void setDateBeforeSent(Timestamp dateBeforeSent) {
		this.dateBeforeSent = dateBeforeSent;
	}

	public Timestamp getDateAfterSent() {
		return dateAfterSent;
	}

	public void setDateAfterSent(Timestamp dateAfterSent) {
		this.dateAfterSent = dateAfterSent;
	}

	public Integer getPendingToSent() {
		return pendingToSent;
	}

	public void setPendingToSent(Integer pendingToSent) {
		this.pendingToSent = pendingToSent;
	}

    // Getters and Setters
}