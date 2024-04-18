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
//@Table(name="drug_class_mst")
public class TherepueticClassDom extends TransactionInfoDomain implements Serializable{
	
	private static final long serialVersionUID = 523549270668333231L;
	
	@Id
	@Column(name="num_drug_class_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1, allocationSize=1)
	int numDrugClassId;
	
	@Column(name="str_drug_class_name")
	String strDrugClassName;
	
	@Column(name="str_drug_class_desc")
	String strDrugClassDesc;

	public int getNumDrugClassId() {
		return numDrugClassId;
	}

	public void setNumDrugClassId(int numDrugClassId) {
		this.numDrugClassId = numDrugClassId;
	}

	public String getStrDrugClassName() {
		return strDrugClassName;
	}

	public void setStrDrugClassName(String strDrugClassName) {
		this.strDrugClassName = strDrugClassName;
	}

	public String getStrDrugClassDesc() {
		return strDrugClassDesc;
	}

	public void setStrDrugClassDesc(String strDrugClassDesc) {
		this.strDrugClassDesc = strDrugClassDesc;
	}
	
}
