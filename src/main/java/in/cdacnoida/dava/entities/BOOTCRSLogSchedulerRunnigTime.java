package in.cdacnoida.dava.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "log_scheduler_running_time")
public class BOOTCRSLogSchedulerRunnigTime {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "srno")
	@TableGenerator(name = "srno", initialValue = 1000, allocationSize = 1)
	private Long SrNo;

	@Column(name = "is_valid")
	private Integer IsValid;

	@Column(name = "method_name")
	private String MethodName;

	@Column(name = "dt_tr_date")
	private LocalDateTime TransactionDate;

	public Long getSrNo() {
		return this.SrNo;
	}

	public void setSrNo(Long srNo) {
		this.SrNo = srNo;
	}

	public Integer getIsValid() {
		return this.IsValid;
	}

	public void setIsValid(Integer isValid) {
		this.IsValid = isValid;
	}

	public String getMethodName() {
		return this.MethodName;
	}

	public void setMethodName(String methodName) {
		this.MethodName = methodName;
	}

	public LocalDateTime getTransactionDate() {
		return this.TransactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.TransactionDate = transactionDate;
	}
}
