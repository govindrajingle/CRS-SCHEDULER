package in.cdacnoida.dava.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Formula;



//@Entity
//@Table(name="INSTITUTE_MST")
public class InstituteMasterDomain extends TransactionInfoDomain implements Serializable {

	private static final long serialVersionUID = -6048595144903121228L;
	@Id
	@Column(name="num_inst_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1000, allocationSize=1)
	int numInstId; 
	
	@Column(name="num_inst_type_id")
	int numInstTypeId;
	
	@Column(name="str_inst_name")
	String strInstName;
	
	@Column(name="str_inst_address")
	String strInstAddress;
					
	public String getStrInstAddress() {
		return strInstAddress;
	}

	public void setStrInstAddress(String strInstAddress) {
		this.strInstAddress = strInstAddress;
	}


	
	@Column(name="str_inst_city")
	String strInstCity;
	

	@Column(name="num_inst_country_id")
	int strInstCountryId;
	
	@Column(name="num_inst_state_id")
	int strInstStateId;
	
	
	@Column(name="num_inst_district_id")
	int strInstDistrictId;
	
	
	@Column(name="num_inst_pincode")
	int strInstPincode;
	
	@Column(name="str_inst_contact_details")
	String strInstContactDetails;
	

	@Column(name="str_inst_fax_details")
	String strInstFaxDetails;
	
	@Column(name="str_inst_email")
	String strInstEmail;
	
	@Column(name="str_cont_person_fname")
	String strContactPersonFname;
	
	
	@Column(name="str_cont_person_mname")
	String strContactPersonMname;
	
	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	@Column(name="str_cont_person_lname")
	String strContactPersonLname;
	
	@Column(name="str_cont_person_desig")
	String contactPersonDesignation;
					
	@Column(name="num_institute_verify")
	int numInstVerify;
	
	@Column(name="num_cont_person_gender")
	String numGender;
	
	@Column(name="str_cont_person_salutation")
	String cont_person_salutation;
	
	@Column(name="num_zone_id")
	int numZoneId;
	
	@Column(name="str_inst_shortname")
	String shortName;
	
	@Column(name="str_manuf_code")
	String strManufCode;
	
/*	@Formula ("(select o.str_state_name from states_mst o where o.num_state_id = num_inst_state_id and o.num_isvalid=1)")
	private String strStateName;
	


	@Formula ("(select o.str_district_name from district_mst o where o.num_district_id = num_inst_district_id and o.num_isvalid=1)")
	private String strDistrictName;*/
/*	
	public String getStrStateName() {
		return strStateName;
	}

	public void setStrStateName(String strStateName) {
		this.strStateName = strStateName;
	}

	public String getStrDistrictName() {
		return strDistrictName;
	}

	public void setStrDistrictName(String strDistrictName) {
		this.strDistrictName = strDistrictName;
	}*/

	/*@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "inst")
	private Set<ManufacturingPremisesDtlDomain> manufPreDtl;
	
	
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "inst")
	private Set<ManufacturingPremisesTypeDtlDomain> manufPremisesTypeDtl;
	
	*/
	
	

	public int getNumZoneId() {
		return numZoneId;
	}

	public void setNumZoneId(int numZoneId) {
		this.numZoneId = numZoneId;
	}

	public String getCont_person_salutation() {
		return cont_person_salutation;
	}

	public void setCont_person_salutation(String cont_person_salutation) {
		this.cont_person_salutation = cont_person_salutation;
	}

	public int getNumInstId() {
		return numInstId;
	}

	public String getNumGender() {
		return numGender;
	}

	public void setNumGender(String numGender) {
		this.numGender = numGender;
	}

	public void setNumInstId(int numInstId) {
		this.numInstId = numInstId;
	}

	public int getNumInstTypeId() {
		return numInstTypeId;
	}

	public void setNumInstTypeId(int numInstTypeId) {
		this.numInstTypeId = numInstTypeId;
	}

	public String getStrInstName() {
		return strInstName;
	}

	public void setStrInstName(String strInstName) {
		this.strInstName = strInstName;
	}


	public String getStrInstCity() {
		return strInstCity;
	}

	public void setStrInstCity(String strInstCity) {
		this.strInstCity = strInstCity;
	}

	public int getStrInstCountryId() {
		return strInstCountryId;
	}

	public void setStrInstCountryId(int strInstCountryId) {
		this.strInstCountryId = strInstCountryId;
	}


	public int getStrInstStateId() {
		return strInstStateId;
	}

	public void setStrInstStateId(int strInstStateId) {
		this.strInstStateId = strInstStateId;
	}

	public int getStrInstDistrictId() {
		return strInstDistrictId;
	}

	public void setStrInstDistrictId(int strInstDistrictId) {
		this.strInstDistrictId = strInstDistrictId;
	}

	public int getStrInstPincode() {
		return strInstPincode;
	}

	public void setStrInstPincode(int strInstPincode) {
		this.strInstPincode = strInstPincode;
	}

	public String getStrInstContactDetails() {
		return strInstContactDetails;
	}

	public void setStrInstContactDetails(String strInstContactDetails) {
		this.strInstContactDetails = strInstContactDetails;
	}

	public String getStrInstFaxDetails() {
		return strInstFaxDetails;
	}

	public void setStrInstFaxDetails(String strInstFaxDetails) {
		this.strInstFaxDetails = strInstFaxDetails;
	}

	public String getStrInstEmail() {
		return strInstEmail;
	}

	public void setStrInstEmail(String strInstEmail) {
		this.strInstEmail = strInstEmail;
	}

	public String getStrContactPersonFname() {
		return strContactPersonFname;
	}

	public void setStrContactPersonFname(String strContactPersonFname) {
		this.strContactPersonFname = strContactPersonFname;
	}

	public String getStrContactPersonMname() {
		return strContactPersonMname;
	}

	public void setStrContactPersonMname(String strContactPersonMname) {
		this.strContactPersonMname = strContactPersonMname;
	}

	public String getStrContactPersonLname() {
		return strContactPersonLname;
	}

	public void setStrContactPersonLname(String strContactPersonLname) {
		this.strContactPersonLname = strContactPersonLname;
	}

	public String getContactPersonDesignation() {
		return contactPersonDesignation;
	}

	public void setContactPersonDesignation(String contactPersonDesignation) {
		this.contactPersonDesignation = contactPersonDesignation;
	}

	public int getNumInstVerify() {
		return numInstVerify;
	}

	public void setNumInstVerify(int numInstVerify) {
		this.numInstVerify = numInstVerify;
	}

	public String getStrManufCode() {
		return strManufCode;
	}

	public void setStrManufCode(String strManufCode) {
		this.strManufCode = strManufCode;
	}

	/*public Set<ManufacturingPremisesDtlDomain> getManufPreDtl() {
		return manufPreDtl;
	}

	public void setManufPreDtl(Set<ManufacturingPremisesDtlDomain> manufPreDtl) {
		this.manufPreDtl = manufPreDtl;
	}

	public Set<ManufacturingPremisesTypeDtlDomain> getManufPremisesTypeDtl() {
		return manufPremisesTypeDtl;
	}

	public void setManufPremisesTypeDtl(
			Set<ManufacturingPremisesTypeDtlDomain> manufPremisesTypeDtl) {
		this.manufPremisesTypeDtl = manufPremisesTypeDtl;
	}*/
		
	
}


