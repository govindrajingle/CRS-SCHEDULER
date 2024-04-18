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
//@Table(name="region_mst")
public class RegionMstDomain extends TransactionInfoDomain implements Serializable{

	private static final long serialVersionUID = -6048595144903121228L;
	
	@Id
	@Column(name="num_region_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	Integer numRegionId;
	
	@Column(name="str_region_code")
	String strRegionCode;
	
	@Column(name="str_region_name")
	String strRegionName;
	
	@Column(name="str_remarks")
	String strRemarks;

	public int getNumRegionId() {
		return numRegionId;
	}

	public void setNumRegionId(int numRegionId) {
		this.numRegionId = numRegionId;
	}

	public String getStrRegionCode() {
		return strRegionCode;
	}

	public void setStrRegionCode(String strRegionCode) {
		this.strRegionCode = strRegionCode;
	}

	public String getStrRegionName() {
		return strRegionName;
	}

	public void setStrRegionName(String strRegionName) {
		this.strRegionName = strRegionName;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	
}