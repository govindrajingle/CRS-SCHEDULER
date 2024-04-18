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
//@Table(name = "port_mst")
public class PortOfExportDomain extends TransactionInfoDomain implements Serializable{
private static final long serialVersionUID = -9170913258269305131L;
	
	@Id
	@Column(name = "num_port_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")  
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	int numPortId;
	
	@Column(name = "str_port_code") 
	String strPortCode;
	
	@Column(name = "str_port_name") 
	String strPortName;
	
	@Column(name = "str_port_add") 
	String strPortAdd;
	
	@Column(name = "num_state_id") 
	int numStateId;
	
	@Column(name = "num_district_id") 
	int numDistrictId;
	
	@Column(name = "num_pincode") 
	Integer numPincode;
	
	@Column(name = "num_country_id") 
	int numCountryId;
	
	@Column(name = "str_email") 
	String strEmail;
	
	@Column(name = "str_contact_number") 
	String strContactNumber;

	public int getNumPortId() {
		return numPortId;
	}

	public void setNumPortId(int numPortId) {
		this.numPortId = numPortId;
	}

	public String getStrPortCode() {
		return strPortCode;
	}

	public void setStrPortCode(String strPortCode) {
		this.strPortCode = strPortCode;
	}

	public String getStrPortName() {
		return strPortName;
	}

	public void setStrPortName(String strPortName) {
		this.strPortName = strPortName;
	}

	public String getStrPortAdd() {
		return strPortAdd;
	}

	public void setStrPortAdd(String strPortAdd) {
		this.strPortAdd = strPortAdd;
	}

	public int getNumStateId() {
		return numStateId;
	}

	public void setNumStateId(int numStateId) {
		this.numStateId = numStateId;
	}

	public int getNumDistrictId() {
		return numDistrictId;
	}

	public void setNumDistrictId(int numDistrictId) {
		this.numDistrictId = numDistrictId;
	}

	public Integer getNumPincode() {
		return numPincode;
	}

	public void setNumPincode(Integer numPincode) {
		this.numPincode = numPincode;
	}

	public int getNumCountryId() {
		return numCountryId;
	}

	public void setNumCountryId(int numCountryId) {
		this.numCountryId = numCountryId;
	}

	public String getStrEmail() {
		return strEmail;
	}

	public void setStrEmail(String strEmail) {
		this.strEmail = strEmail;
	}

	public String getStrContactNumber() {
		return strContactNumber;
	}

	public void setStrContactNumber(String strContactNumber) {
		this.strContactNumber = strContactNumber;
	}
	
}
