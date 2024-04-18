package in.cdacnoida.dava.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name="location_mst")
public class LocationMasterDomain implements Serializable {

	private static final long serialVersionUID = -6048595144903121228L;
	@Id
	@Column(name="num_loc_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1000, allocationSize=1)
	int numlocationId; 
	
	@Column(name="num_inst_id")
	int loc_type_name;
	
	@Column(name="num_inst_type_id")
	int loc_type;
	
	@Column(name="str_address")
	String loc_add;
	
	@Column(name="str_loc_name")
	String loc_name;
		
	@Column(name="str_short_name")
	String loc_short_Name;
	
	@Column(name="num_country_id")
	int loc_country;

	@Column(name="num_state_id")
	int loc_state;
	
	@Column(name="num_district_id")
	int loc_dist;
	
	@Column(name="num_mob_no")
	Long loc_contact_dtls;
	
	@Column(name="str_fax_no")
	String loc_fax_dtls;
	
	@Column(name="str_email_id")
	String loc_email;
	
	@Column(name="str_officer_name")
	String contactPersonName;
	
	@Column(name="str_state_name")
	String strStateName;
	
	@Column(name="NUM_ISVALID")
    int numIsValid;
	
	@Column(name="DT_TR_DATE")
	Date dtTrDate;
	
	@Column(name="NUM_TR_USER_ID")
	int  numTrUserId;
	
	@Column(name="num_zone_id")
	int loc_zone;

	@Column
	private Integer pinCode;
	
	@Column
	private String website;
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy="locationMasterDomain")
	private OfficialRegistrationDetails officialRegistrationDetails;
	
	
	
	
	
	

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public OfficialRegistrationDetails getOfficialRegistrationDetails() {
		return officialRegistrationDetails;
	}

	public void setOfficialRegistrationDetails(OfficialRegistrationDetails officialRegistrationDetails) {
		this.officialRegistrationDetails = officialRegistrationDetails;
	}

	public int getNumlocationId() {
		return numlocationId;
	}

	public void setNumlocationId(int numlocationId) {
		this.numlocationId = numlocationId;
	}

	public int getLoc_type_name() {
		return loc_type_name;
	}

	public void setLoc_type_name(int loc_type_name) {
		this.loc_type_name = loc_type_name;
	}

	public int getLoc_type() {
		return loc_type;
	}

	public void setLoc_type(int loc_type) {
		this.loc_type = loc_type;
	}

	public String getLoc_add() {
		return loc_add;
	}

	public void setLoc_add(String loc_add) {
		this.loc_add = loc_add;
	}

	public String getLoc_name() {
		return loc_name;
	}

	public void setLoc_name(String loc_name) {
		this.loc_name = loc_name;
	}

	public String getLoc_short_Name() {
		return loc_short_Name;
	}

	public void setLoc_short_Name(String loc_short_Name) {
		this.loc_short_Name = loc_short_Name;
	}

	public int getLoc_country() {
		return loc_country;
	}

	public void setLoc_country(int loc_country) {
		this.loc_country = loc_country;
	}

	public int getLoc_state() {
		return loc_state;
	}

	public void setLoc_state(int loc_state) {
		this.loc_state = loc_state;
	}

	public int getLoc_dist() {
		return loc_dist;
	}

	public void setLoc_dist(int loc_dist) {
		this.loc_dist = loc_dist;
	}

	public Long getLoc_contact_dtls() {
		return loc_contact_dtls;
	}

	public void setLoc_contact_dtls(Long loc_contact_dtls) {
		this.loc_contact_dtls = loc_contact_dtls;
	}

	public String getLoc_fax_dtls() {
		return loc_fax_dtls;
	}

	public void setLoc_fax_dtls(String loc_fax_dtls) {
		this.loc_fax_dtls = loc_fax_dtls;
	}

	public String getLoc_email() {
		return loc_email;
	}

	public void setLoc_email(String loc_email) {
		this.loc_email = loc_email;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getStrStateName() {
		return strStateName;
	}

	public void setStrStateName(String strStateName) {
		this.strStateName = strStateName;
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

	public int getLoc_zone() {
		return loc_zone;
	}

	public void setLoc_zone(int loc_zone) {
		this.loc_zone = loc_zone;
	}
	
}


