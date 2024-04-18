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
//@Table(name="storage_condition_mst")
public class StorageCondMstDom extends TransactionInfoDomain implements Serializable{
	
private static final long serialVersionUID = 523549270668333231L;
	
	@Id
	@Column(name="num_condition_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1, allocationSize=1)
	int numStorageConditionId;
	
	@Column(name="str_condition_name")
	String strStorageConditionName;

	public int getNumStorageConditionId() {
		return numStorageConditionId;
	}

	public void setNumStorageConditionId(int numStorageConditionId) {
		this.numStorageConditionId = numStorageConditionId;
	}

	public String getStrStorageConditionName() {
		return strStorageConditionName;
	}

	public void setStrStorageConditionName(String strStorageConditionName) {
		this.strStorageConditionName = strStorageConditionName;
	}
}