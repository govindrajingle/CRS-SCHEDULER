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
//@Table(name="site_type_mst")
public class SiteTypeMstDomain extends TransactionInfoDomain   implements Serializable{

	private static final long serialVersionUID = -6048595144903121228L;
	@Id
	@Column(name="num_site_type_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1000, allocationSize=1)
	int numSiteTypeId; 
	
	@Column(name="site_type_name")
	String siteTypeName;
	
	@Column(name="site_type_flag")
	int siteTypeFlag;
	
	@Column(name="remarks")
	String remarks;
	
	@Column(name="dt_entry_date")
	Date dtEntryDate;

	public int getNumSiteTypeId() {
		return numSiteTypeId;
	}

	public void setNumSiteTypeId(int numSiteTypeId) {
		this.numSiteTypeId = numSiteTypeId;
	}

	public String getSiteTypeName() {
		return siteTypeName;
	}

	public void setSiteTypeName(String siteTypeName) {
		this.siteTypeName = siteTypeName;
	}

	public int getSiteTypeFlag() {
		return siteTypeFlag;
	}

	public void setSiteTypeFlag(int siteTypeFlag) {
		this.siteTypeFlag = siteTypeFlag;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getDtEntryDate() {
		return dtEntryDate;
	}

	public void setDtEntryDate(Date dtEntryDate) {
		this.dtEntryDate = dtEntryDate;
	}
}
