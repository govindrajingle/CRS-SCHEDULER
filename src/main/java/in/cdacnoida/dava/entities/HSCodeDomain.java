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
//@Table(name="hscode_mst")
public class HSCodeDomain extends TransactionInfoDomain   implements Serializable{

	private static final long serialVersionUID = -6048595144903121228L;
	
	@Id
	@Column(name="num_hscode")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1000, allocationSize=1)
	int numHSCode; 
	
	@Column(name="num_prod_type_id")
	int numProdTypeId;
	
	@Column(name="str_commodity_name")
	String strCommodityName;
	
	@Column(name="str_remarks")
	String strRemarks;

	public int getNumHSCode() {
		return numHSCode;
	}

	public void setNumHSCode(int numHSCode) {
		this.numHSCode = numHSCode;
	}

	public int getNumProdTypeId() {
		return numProdTypeId;
	}

	public void setNumProdTypeId(int numProdTypeId) {
		this.numProdTypeId = numProdTypeId;
	}

	public String getStrCommodityName() {
		return strCommodityName;
	}

	public void setStrCommodityName(String strCommodityName) {
		this.strCommodityName = strCommodityName;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
}
