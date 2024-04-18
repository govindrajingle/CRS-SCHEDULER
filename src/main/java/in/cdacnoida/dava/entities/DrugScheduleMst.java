package in.cdacnoida.dava.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

//@Entity
//@Table(name="drug_schedule_mst")
public class DrugScheduleMst extends TransactionInfoDomain implements Serializable{
	
	private static final long serialVersionUID = -6048595144903121228L;
	
	@Id
	@Column(name="num_schedule_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1000, allocationSize=1)
	int numScheduleId; 
	
	@Column(name="str_schedule_name")
	String strScheduleName;
	
	@Column(name="str_remarks")
	String strRemarks;

	public int getNumScheduleId() {
		return numScheduleId;
	}

	public void setNumScheduleId(int numScheduleId) {
		this.numScheduleId = numScheduleId;
	}

	public String getStrScheduleName() {
		return strScheduleName;
	}

	public void setStrScheduleName(String strScheduleName) {
		this.strScheduleName = strScheduleName;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
}
