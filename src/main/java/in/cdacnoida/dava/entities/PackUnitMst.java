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
//@Table(name="pack_unit_mst")
public class PackUnitMst extends TransactionInfoDomain implements Serializable{
	
	private static final long serialVersionUID = -6048595144903121228L;
	
	@Id
	@Column(name="num_pack_unit_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	int numPackId;
	
	@Column(name="str_pack_unit_name")
	String packName;
	
	@Column(name="str_remarks")
	String remarks;
	

	public int getNumPackId() {
		return numPackId;
	}

	public void setNumPackId(int numPackId) {
		this.numPackId = numPackId;
	}

	public String getPackName() {
		return packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
