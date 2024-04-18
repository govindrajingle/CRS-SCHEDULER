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
//@Table(name="drug_dosage_form_mst")
public class DrugDosageMst extends TransactionInfoDomain implements Serializable{

	private static final long serialVersionUID = -6048595144903121228L;
	
	@Id
	@Column(name="num_drug_dosage_form_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1000, allocationSize=1)
	int numDrugDosageFormId; 
	
	@Column(name="str_dosage_name")
	String strDosageName;
	
	@Column(name="str_remarks")
	String strRemarks;
	
	@Column(name="dt_lstmod_date")
	Date dtLstmodDate;
	
	@Column(name="dt_entry_date")
	Date dtEntryDate;
	
	@Column(name="num_division_id")
	int numDivisionId;

	public int getNumDrugDosageFormId() {
		return numDrugDosageFormId;
	}

	public void setNumDrugDosageFormId(int numDrugDosageFormId) {
		this.numDrugDosageFormId = numDrugDosageFormId;
	}

	public String getStrDosageName() {
		return strDosageName;
	}

	public void setStrDosageName(String strDosageName) {
		this.strDosageName = strDosageName;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	public Date getDtLstmodDate() {
		return dtLstmodDate;
	}

	public void setDtLstmodDate(Date dtLstmodDate) {
		this.dtLstmodDate = dtLstmodDate;
	}

	public Date getDtEntryDate() {
		return dtEntryDate;
	}

	public void setDtEntryDate(Date dtEntryDate) {
		this.dtEntryDate = dtEntryDate;
	}

	public int getNumDivisionId() {
		return numDivisionId;
	}

	public void setNumDivisionId(int numDivisionId) {
		this.numDivisionId = numDivisionId;
	}
}
