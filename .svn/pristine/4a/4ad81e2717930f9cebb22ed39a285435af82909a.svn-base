package in.cdacnoida.dava.model;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import in.cdacnoida.dava.misc.ValidationGroups.MemberDetails;
import in.cdacnoida.dava.misc.ValidationGroups.PointOfDistribution;

public class PointsOfDisModel {
	
	int distrubutionId;
	@NotNull(message="Export Region is required and cannot be empty", groups={PointOfDistribution.class})
	int expReg;
	
	int expCountry;
	
	String expSiteAdd;
	@NotEmpty(message=" Name is required and cannot be empty", groups={PointOfDistribution.class})
	@Size(min=1, max=50,message=" Name can contain maximum of 50 characters", groups={PointOfDistribution.class})
	@Pattern(regexp="^[a-zA-Z0-9.,\\-\\/\\s +&()]+$",message=" Name can consist of alphabets, numbers and special characters( /,()-.+&) and white spaces are permitted",groups={PointOfDistribution.class})
	String expName;
	@NotEmpty(message=" Number is required and cannot be empty", groups={PointOfDistribution.class})
	@Size(min=10, max=10,message=" Number can contain maximum of 10 characters", groups={PointOfDistribution.class})
	@Pattern(regexp="^[a-zA-Z0-9.,\\-\\/\\s +&()]+$",message=" Number can consist of numbers are permitted",groups={PointOfDistribution.class})
	String expNumber;
	@NotEmpty(message=" Designation is required and cannot be empty", groups={PointOfDistribution.class})
	@Size(min=1, max=20,message=" Designation can contain maximum of 20 characters", groups={PointOfDistribution.class})
	@Pattern(regexp="^[a-zA-Z0-9.,\\-\\/\\s +&()]+$",message=" Designation can consist of alphabets, numbers and special characters( /,()-.+&) and white spaces are permitted",groups={PointOfDistribution.class})
	String expDesignation;
	@NotEmpty(message="Email cannot not be null or empty")
	@Email
	String expEmail;
	
	String orgName;
	
	List<String> listExpCountry;

	public int getDistrubutionId() {
		return distrubutionId;
	}

	public void setDistrubutionId(int distrubutionId) {
		this.distrubutionId = distrubutionId;
	}

	public int getExpReg() {
		return expReg;
	}

	public void setExpReg(int expReg) {
		this.expReg = expReg;
	}

	public int getExpCountry() {
		return expCountry;
	}

	public void setExpCountry(int expCountry) {
		this.expCountry = expCountry;
	}

	public String getExpSiteAdd() {
		return expSiteAdd;
	}

	public void setExpSiteAdd(String expSiteAdd) {
		this.expSiteAdd = expSiteAdd;
	}

	public String getExpName() {
		return expName;
	}

	public void setExpName(String expName) {
		this.expName = expName;
	}

	public String getExpNumber() {
		return expNumber;
	}

	public void setExpNumber(String expNumber) {
		this.expNumber = expNumber;
	}

	public String getExpDesignation() {
		return expDesignation;
	}

	public void setExpDesignation(String expDesignation) {
		this.expDesignation = expDesignation;
	}

	public String getExpEmail() {
		return expEmail;
	}

	public void setExpEmail(String expEmail) {
		this.expEmail = expEmail;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public List<String> getListExpCountry() {
		return listExpCountry;
	}

	public void setListExpCountry(List<String> listExpCountry) {
		this.listExpCountry = listExpCountry;
	}

}
