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
//@Table(name="distribution_mst")
public class DistributionMstDomain extends TransactionInfoDomain implements Serializable{

	private static final long serialVersionUID = -6048595144903121228L;
	
	@Id
	@Column(name="num_distribution_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1000, allocationSize=1)
	int numDistributionId; 
	
	@Column(name="num_inst_id")
	int numInstId;
	
	@Column(name="num_region_id")
	int numRegionId;
	
	@Column(name="str_name")
	String strName;
	
	@Column(name="str_address")
	String strAddress;
	
	@Column(name="str_contact_number")
	String strContactNumber;
	
	@Column(name="num_country_id")
	int numCountryId;
	
	@Column(name="str_email_id")
	String strEmailId;
	
	@Column(name="str_cont_per_name")
	String strContPerName;
	
	@Column(name="str_cont_per_desg")
	String strContPerDesg;
	
	@Column(name="str_country_id")
	String strCountryId;

	public int getNumDistributionId() {
		return numDistributionId;
	}

	public void setNumDistributionId(int numDistributionId) {
		this.numDistributionId = numDistributionId;
	}

	public int getNumInstId() {
		return numInstId;
	}

	public void setNumInstId(int numInstId) {
		this.numInstId = numInstId;
	}

	public int getNumRegionId() {
		return numRegionId;
	}

	public void setNumRegionId(int numRegionId) {
		this.numRegionId = numRegionId;
	}

	public String getStrName() {
		return strName;
	}

	public void setStrName(String strName) {
		this.strName = strName;
	}

	public String getStrAddress() {
		return strAddress;
	}

	public void setStrAddress(String strAddress) {
		this.strAddress = strAddress;
	}

	public String getStrContactNumber() {
		return strContactNumber;
	}

	public void setStrContactNumber(String strContactNumber) {
		this.strContactNumber = strContactNumber;
	}

	public int getNumCountryId() {
		return numCountryId;
	}

	public void setNumCountryId(int numCountryId) {
		this.numCountryId = numCountryId;
	}

	public String getStrEmailId() {
		return strEmailId;
	}

	public void setStrEmailId(String strEmailId) {
		this.strEmailId = strEmailId;
	}

	public String getStrContPerName() {
		return strContPerName;
	}

	public void setStrContPerName(String strContPerName) {
		this.strContPerName = strContPerName;
	}

	public String getStrContPerDesg() {
		return strContPerDesg;
	}

	public void setStrContPerDesg(String strContPerDesg) {
		this.strContPerDesg = strContPerDesg;
	}

	public String getStrCountryId() {
		return strCountryId;
	}

	public void setStrCountryId(String strCountryId) {
		this.strCountryId = strCountryId;
	}
}
