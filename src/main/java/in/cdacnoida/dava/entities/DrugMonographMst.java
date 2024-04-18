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
//@Table(name="drug_monograph_mst")
public class DrugMonographMst extends TransactionInfoDomain implements Serializable{

	private static final long serialVersionUID = -6048595144903121228L;
	
	@Id
	@Column(name="monograph_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1000, allocationSize=1)
	int monographId; 
	
	@Column(name="monograph_name")
	String monographName;
	
	@Column(name="str_remarks")
	String strRemarks;
	
	@Column(name="doses_name")
	String dosesName;

	public int getMonographId() {
		return monographId;
	}

	public void setMonographId(int monographId) {
		this.monographId = monographId;
	}

	public String getMonographName() {
		return monographName;
	}

	public void setMonographName(String monographName) {
		this.monographName = monographName;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	public String getDosesName() {
		return dosesName;
	}

	public void setDosesName(String dosesName) {
		this.dosesName = dosesName;
	}
	
}
