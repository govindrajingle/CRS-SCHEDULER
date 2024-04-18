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
//@Table(name="licence_type_mst")
public class LicenseTypeMstDomain extends TransactionInfoDomain   implements Serializable {
	
	private static final long serialVersionUID = -6048595144903121228L;
	@Id
	@Column(name="num_lic_type_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1000, allocationSize=1)
	int numLicenseTypeId; 
	
	@Column(name="lic_type_name")
	String licenseTypeName;
	
	@Column(name="lic_type_flag")
	int licenseTypeFlag;
	
	@Column(name="remarks")
	String remarks;
	
	@Column(name="dt_entry_date")
	Date dtEntryDate;

	public int getNumLicenseTypeId() {
		return numLicenseTypeId;
	}

	public void setNumLicenseTypeId(int numLicenseTypeId) {
		this.numLicenseTypeId = numLicenseTypeId;
	}

	public String getLicenseTypeName() {
		return licenseTypeName;
	}

	public void setLicenseTypeName(String licenseTypeName) {
		this.licenseTypeName = licenseTypeName;
	}

	public int getLicenseTypeFlag() {
		return licenseTypeFlag;
	}

	public void setLicenseTypeFlag(int licenseTypeFlag) {
		this.licenseTypeFlag = licenseTypeFlag;
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
