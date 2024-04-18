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
@Table(name="country_region_map")
public class CountryRegionMapDomain implements Serializable {

	private static final long serialVersionUID = -6048595144903121228L;
	@Id
	@Column(name="num_mapping_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1000, allocationSize=1)
	int mappingId; 
	
	
	@Column(name="num_country_id")
	int country_Id;

	@Column(name="num_region_id")
	int region_Id;
	
	
	
	@Column(name="NUM_ISVALID")
    int numIsValid;
	
	@Column(name="DT_TR_DATE")
	Date dtTrDate;
	
	@Column(name="NUM_TR_USER_ID")
	int  numTrUserId;

	public int getMappingId() {
		return mappingId;
	}

	public void setMappingId(int mappingId) {
		this.mappingId = mappingId;
	}



	public int getNumIsValid() {
		return numIsValid;
	}

	public void setNumIsValid(int numIsValid) {
		this.numIsValid = numIsValid;
	}

	public Date getDtTrDate() {
		return dtTrDate;
	}

	public void setDtTrDate(Date dtTrDate) {
		this.dtTrDate = dtTrDate;
	}

	public int getNumTrUserId() {
		return numTrUserId;
	}

	public void setNumTrUserId(int numTrUserId) {
		this.numTrUserId = numTrUserId;
	}

	public int getCountry_Id() {
		return country_Id;
	}

	

	public int getRegion_Id() {
		return region_Id;
	}

	public void setRegion_Id(int region_Id) {
		this.region_Id = region_Id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setCountry_Id(int country_Id) {
		this.country_Id = country_Id;
	}

	

	
	
	
	
	
}


