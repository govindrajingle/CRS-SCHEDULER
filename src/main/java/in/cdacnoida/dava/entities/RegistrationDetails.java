package in.cdacnoida.dava.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_registration")
public class RegistrationDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	private Long userId;

	@Column
	private String userName;

	@Column
	@JsonIgnore
	private String password;

	@Column(length = 50)
	private String applicantType;

	@Column(length = 250)
	private String orgName;

	@Column(length = 5)
	private String orgType;

	@Column(length = 250)
	private String orgAddress;

	@Column(length = 6)
	private Integer orgPincode;

	@Column(length = 5)
	private Integer orgCountryId;

	@Column(length = 5)
	private Integer orgStateId;

	@Column(length = 4)
	private Integer orgDistId;

	@Column(length = 50)
	private String orgContactNumber;

	@Column(length = 50)
	private String orgFaxNumber;

	@Column(length = 50)
	private String orgEmailId;

	@Column(length = 50)
	private String orgPanNumber;

	@Column(length = 50)
	private String orgWebsite;

	@Column(length = 250)
	private String manfSiteName;

	@Column(length = 250)
	private String manfSiteAddress;

	@Column(length = 6)
	private Integer manfSitePincode;

	@Column(length = 5)
	private Integer manfCountryId;

	@Column(length = 5)
	private Integer manfStateId;

	@Column(length = 4)
	private Integer manfDistId;

	@Column(length = 50)
	private String manfSiteCity;

	@Column(length = 50)
	private String manfSiteContactNumber;

	@Column(length = 50)
	private String manfSiteFaxNumber;

	@Column(length = 50)
	private String manfLicNumber;

	@Column(length = 20)
	private String iecNumber;

	@Column(length = 12)
	private Date iecIssueDate;

	@Column(length = 100)
	private String iecIssueAuthority;

	@Column(length = 20)
	private String ssiNumber;

	@Column(length = 12)
	private Date ssiIssueDate;

	@Column(length = 5)
	private String ssiType;

	@Column(length = 50)
	private String contactPersonName;

	@Column(length = 50)
	private String contactPerDesg;

	@Column(length = 15)
	private String contPerMobileNo;

	@Column(length = 50)
	private String contPersEmail;

	@Column(length = 5)
	private Integer numRcmsStatus;

	@Column(name = "num_email_status")
	private Integer numEmailStatus;

	@Column(name = "num_isvalid")
	private Integer numIsValied;

	@Column(name = "random_number")
	private Integer randomNumber;

	@UpdateTimestamp
	@JsonIgnore
	private LocalDateTime lastUpdatedDate;

	@CreationTimestamp
	@JsonIgnore
	private LocalDateTime createdDate;

	@Column(name = "num_tr_user_id")
	private Integer numTrUserId;

	@Column(name = "dt_tr_date")
	private Date dtTrDate;

	@Column(name = "num_inst_id")
	private Integer numInstId;

	@Column(name = "num_default_seatid")
	private Integer numSeatId;

	@Column(name = "num_premises_no")
	private Integer numPremisesNo;

	@Column(name = "is_member_of_other_promotion_council", length = 10)
	private String memberOfOtherExportPromotionCouncil;
	
	
	
	@Column(name = "categoryDropdown", length = 20)
	private String categoryDropdown;
	
	
	@Column(name = "orgDropdown", length = 20)
	private String orgDropdown;

	@Column(name = "str_rcmc_fieo_no", length = 50)
	private String rcmcOfFieo;

	@Column(name = "str_rcmc_no", length = 50)
	private String strRcmcNumber;

	@Column(name = "numApprovalStatusPharmaexil", length = 4)
	private Integer numApprovalStatusPharmaexil;

	@Column(name = "str_reason")
	String strReason;

	@Column(name = "public_key")
	String publicKey;

	@Column
	private String verificationLink;

	/*
	 * @Column(name = "num_doc_id") int doc_id;
	 * 
	 * @Column(name = "num_drug_Doc_Id") int drugdoc_id;
	 * 
	 * 
	 * public int getDrugdoc_id() { return drugdoc_id; }
	 * 
	 * public void setDrugdoc_id(int drugdoc_id) { this.drugdoc_id = drugdoc_id; }
	 * 
	 * public int getDoc_id() { return doc_id; }
	 * 
	 * public void setDoc_id(int doc_id) { this.doc_id = doc_id; }
	 * 
	 */
	@Column(name = "str_gstn_number")
	private String gstnumber;
	
	 // Govind 080923
	 @Column(name = "expiration_time")
	 private LocalDateTime expirationTime;
	 
	 @Column(name = "resend_verification_time")
	 private LocalDateTime resendVerificationTime;
	 
		@Column(name = "address_proof_id")
		private Integer addressProffId;	
		
		@Column(name = "drug_license_id")
		private Integer drugLicenseId;

	public Integer getAddressProffId() {
			return addressProffId;
		}

		public void setAddressProffId(Integer addressProffId) {
			this.addressProffId = addressProffId;
		}

		public Integer getDrugLicenseId() {
			return drugLicenseId;
		}

		public void setDrugLicenseId(Integer drugLicenseId) {
			this.drugLicenseId = drugLicenseId;
		}

	public LocalDateTime getResendVerificationTime() {
		return resendVerificationTime;
	}

	public void setResendVerificationTime(LocalDateTime resendVerificationTime) {
		this.resendVerificationTime = resendVerificationTime;
	}

	public LocalDateTime getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(LocalDateTime expirationTime) {
		this.expirationTime = expirationTime;
	}

	@OneToMany(mappedBy = "registrationDetails")
	@JsonIgnore
	List<OtherPromotionCouncilDetails> otherPromotionCouncilDetails = new ArrayList<>();

	@OneToMany(mappedBy = "registrationDetails")
	@JsonIgnore
	List<PasswordHistory> passwordHistory = new ArrayList<>();

	@OneToMany(mappedBy = "registrationDetails")
	@JsonIgnore
	List<DesktopConfigDtlDom> desktopEntity = new ArrayList<>();

	@Formula("(select s.num_role_id from dava.user_registration u,dava.seat_mst s where u.user_id = user_id and u.num_default_seatid = s.num_seat_id  and u.num_isvalid =1)")
	private String roleId;

	@Formula("(select getrolename(u.num_default_seatid) from dava.user_registration u,dava.seat_mst s where u.user_id = user_id and u.num_default_seatid = s.num_seat_id  and u.num_isvalid =1)")
	private String roleName;

	@Column(name = "str_gs1_number", length = 50)
	private String gsOne;

	@OneToOne(mappedBy = "registrationDetails", fetch = FetchType.LAZY)
	private OfficialRegistrationDetails officialRegistration;

	public void setPasswordHistory(List<PasswordHistory> passwordHistory) {
		this.passwordHistory = passwordHistory;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getApplicantType() {
		return applicantType;
	}

	public void setApplicantType(String applicantType) {
		this.applicantType = applicantType;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getOrgAddress() {
		return orgAddress;
	}

	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}

	public Integer getOrgPincode() {
		return orgPincode;
	}

	public void setOrgPincode(Integer orgPincode) {
		this.orgPincode = orgPincode;
	}

	public Integer getOrgCountryId() {
		return orgCountryId;
	}

	public void setOrgCountryId(Integer orgCountryId) {
		this.orgCountryId = orgCountryId;
	}

	public Integer getOrgStateId() {
		return orgStateId;
	}

	public void setOrgStateId(Integer orgStateId) {
		this.orgStateId = orgStateId;
	}

	public Integer getOrgDistId() {
		return orgDistId;
	}

	public void setOrgDistId(Integer orgDistId) {
		this.orgDistId = orgDistId;
	}

	public String getOrgContactNumber() {
		return orgContactNumber;
	}

	public void setOrgContactNumber(String orgContactNumber) {
		this.orgContactNumber = orgContactNumber;
	}

	public String getOrgFaxNumber() {
		return orgFaxNumber;
	}

	public void setOrgFaxNumber(String orgFaxNumber) {
		this.orgFaxNumber = orgFaxNumber;
	}

	public String getOrgEmailId() {
		return orgEmailId;
	}

	public void setOrgEmailId(String orgEmailId) {
		this.orgEmailId = orgEmailId;
	}

	public String getOrgPanNumber() {
		return orgPanNumber;
	}

	public void setOrgPanNumber(String orgPanNumber) {
		this.orgPanNumber = orgPanNumber;
	}

	public String getOrgWebsite() {
		return orgWebsite;
	}

	public void setOrgWebsite(String orgWebsite) {
		this.orgWebsite = orgWebsite;
	}

	public String getManfSiteName() {
		return manfSiteName;
	}

	public void setManfSiteName(String manfSiteName) {
		this.manfSiteName = manfSiteName;
	}

	public String getManfSiteAddress() {
		return manfSiteAddress;
	}

	public void setManfSiteAddress(String manfSiteAddress) {
		this.manfSiteAddress = manfSiteAddress;
	}

	public Integer getManfSitePincode() {
		return manfSitePincode;
	}

	public void setManfSitePincode(Integer manfSitePincode) {
		this.manfSitePincode = manfSitePincode;
	}

	public Integer getManfCountryId() {
		return manfCountryId;
	}

	public void setManfCountryId(Integer manfCountryId) {
		this.manfCountryId = manfCountryId;
	}

	public Integer getManfStateId() {
		return manfStateId;
	}

	public void setManfStateId(Integer manfStateId) {
		this.manfStateId = manfStateId;
	}

	public Integer getManfDistId() {
		return manfDistId;
	}

	public void setManfDistId(Integer manfDistId) {
		this.manfDistId = manfDistId;
	}

	public String getManfSiteCity() {
		return manfSiteCity;
	}

	public void setManfSiteCity(String manfSiteCity) {
		this.manfSiteCity = manfSiteCity;
	}

	public String getManfSiteContactNumber() {
		return manfSiteContactNumber;
	}

	public void setManfSiteContactNumber(String manfSiteContactNumber) {
		this.manfSiteContactNumber = manfSiteContactNumber;
	}

	public String getManfSiteFaxNumber() {
		return manfSiteFaxNumber;
	}

	public void setManfSiteFaxNumber(String manfSiteFaxNumber) {
		this.manfSiteFaxNumber = manfSiteFaxNumber;
	}

	public String getManfLicNumber() {
		return manfLicNumber;
	}

	public void setManfLicNumber(String manfLicNumber) {
		this.manfLicNumber = manfLicNumber;
	}

	public String getIecNumber() {
		return iecNumber;
	}

	public void setIecNumber(String iecNumber) {
		this.iecNumber = iecNumber;
	}

	public String getIecIssueAuthority() {
		return iecIssueAuthority;
	}

	public void setIecIssueAuthority(String iecIssueAuthority) {
		this.iecIssueAuthority = iecIssueAuthority;
	}

	public String getSsiNumber() {
		return ssiNumber;
	}

	public void setSsiNumber(String ssiNumber) {
		this.ssiNumber = ssiNumber;
	}

	public Date getIecIssueDate() {
		return iecIssueDate;
	}

	public void setIecIssueDate(Date iecIssueDate) {
		this.iecIssueDate = iecIssueDate;
	}

	public Date getSsiIssueDate() {
		return ssiIssueDate;
	}

	public void setSsiIssueDate(Date ssiIssueDate) {
		this.ssiIssueDate = ssiIssueDate;
	}

	public String getSsiType() {
		return ssiType;
	}

	public void setSsiType(String ssiType) {
		this.ssiType = ssiType;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getContactPerDesg() {
		return contactPerDesg;
	}

	public void setContactPerDesg(String contactPerDesg) {
		this.contactPerDesg = contactPerDesg;
	}

	public String getContPerMobileNo() {
		return contPerMobileNo;
	}

	public void setContPerMobileNo(String contPerMobileNo) {
		this.contPerMobileNo = contPerMobileNo;
	}

	public String getContPersEmail() {
		return contPersEmail;
	}

	public void setContPersEmail(String contPersEmail) {
		this.contPersEmail = contPersEmail;
	}

	public Integer getNumRcmsStatus() {
		return numRcmsStatus;
	}

	public void setNumRcmsStatus(Integer numRcmsStatus) {
		this.numRcmsStatus = numRcmsStatus;
	}

	public Integer getNumEmailStatus() {
		return numEmailStatus;
	}

	public void setNumEmailStatus(Integer numEmailStatus) {
		this.numEmailStatus = numEmailStatus;
	}

	public Integer getNumIsValied() {
		return numIsValied;
	}

	public void setNumIsValied(Integer numIsValied) {
		this.numIsValied = numIsValied;
	}

	public Integer getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(Integer randomNumber) {
		this.randomNumber = randomNumber;
	}

	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getNumTrUserId() {
		return numTrUserId;
	}

	public void setNumTrUserId(Integer numTrUserId) {
		this.numTrUserId = numTrUserId;
	}

	public Date getDtTrDate() {
		return dtTrDate;
	}

	public void setDtTrDate(Date dtTrDate) {
		this.dtTrDate = dtTrDate;
	}

	public Integer getNumSeatId() {
		return numSeatId;
	}

	public void setNumSeatId(Integer numSeatId) {
		this.numSeatId = numSeatId;
	}

	public Integer getNumInstId() {
		return numInstId;
	}

	public void setNumInstId(Integer numInstId) {
		this.numInstId = numInstId;
	}

	public Integer getNumPremisesNo() {
		return numPremisesNo;
	}

	public void setNumPremisesNo(Integer numPremisesNo) {
		this.numPremisesNo = numPremisesNo;
	}

	public String getMemberOfOtherExportPromotionCouncil() {
		return memberOfOtherExportPromotionCouncil;
	}

	public void setMemberOfOtherExportPromotionCouncil(String memberOfOtherExportPromotionCouncil) {
		this.memberOfOtherExportPromotionCouncil = memberOfOtherExportPromotionCouncil;
	}

	public String getRcmcOfFieo() {
		return rcmcOfFieo;
	}

	public void setRcmcOfFieo(String rcmcOfFieo) {
		this.rcmcOfFieo = rcmcOfFieo;
	}

	public String getStrRcmcNumber() {
		return strRcmcNumber;
	}

	public void setStrRcmcNumber(String strRcmcNumber) {
		this.strRcmcNumber = strRcmcNumber;
	}

	public Integer getNumApprovalStatusPharmaexil() {
		return numApprovalStatusPharmaexil;
	}

	public void setNumApprovalStatusPharmaexil(Integer numApprovalStatusPharmaexil) {
		this.numApprovalStatusPharmaexil = numApprovalStatusPharmaexil;
	}

	public String getStrReason() {
		return strReason;
	}

	public void setStrReason(String strReason) {
		this.strReason = strReason;
	}

	public List<OtherPromotionCouncilDetails> getOtherPromotionCouncilDetails() {
		return otherPromotionCouncilDetails;
	}

	public void addOtherPromotionCouncilDetails(OtherPromotionCouncilDetails otherPromotionCouncilDetails) {
		this.otherPromotionCouncilDetails.add(otherPromotionCouncilDetails);
	}

	public String getVerificationLink() {
		return verificationLink;
	}

	public void setVerificationLink(String verificationLink) {
		this.verificationLink = verificationLink;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public void setOtherPromotionCouncilDetails(List<OtherPromotionCouncilDetails> otherPromotionCouncilDetails) {
		this.otherPromotionCouncilDetails = otherPromotionCouncilDetails;
	}

	public String getGstnumber() {
		return gstnumber;
	}

	public void setGstnumber(String gstnumber) {
		this.gstnumber = gstnumber;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getGsOne() {
		return gsOne;
	}

	public void setGsOne(String gsOne) {
		this.gsOne = gsOne;
	}

	public List<DesktopConfigDtlDom> getDesktopEntity() {
		return desktopEntity;
	}

	public void addDesktopEntity(DesktopConfigDtlDom desktopEntity) {
		this.desktopEntity.add(desktopEntity);
	}

	public List<PasswordHistory> getPasswordHistory() {
		return passwordHistory;
	}

	public void setPasswordHistory(PasswordHistory passwordHistory) {
		this.passwordHistory.add(passwordHistory);
	}

	public void setDesktopEntity(List<DesktopConfigDtlDom> desktopEntity) {
		this.desktopEntity = desktopEntity;
	}
	
	

	public String getCategoryDropdown() {
		return categoryDropdown;
	}

	public void setCategoryDropdown(String categoryDropdown) {
		this.categoryDropdown = categoryDropdown;
	}

	public String getOrgDropdown() {
		return orgDropdown;
	}

	public void setOrgDropdown(String orgDropdown) {
		this.orgDropdown = orgDropdown;
	}

	@Override
	public String toString() {
		return "RegistrationDetails [userId=" + userId + ", userName=" + userName + ", password=" + password
				+ ", applicantType=" + applicantType + ", orgName=" + orgName + ", orgType=" + orgType + ", orgAddress="
				+ orgAddress + ", orgPincode=" + orgPincode + ", orgCountryId=" + orgCountryId + ", orgStateId="
				+ orgStateId + ", orgDistId=" + orgDistId + ", orgContactNumber=" + orgContactNumber + ", orgFaxNumber="
				+ orgFaxNumber + ", orgEmailId=" + orgEmailId + ", orgPanNumber=" + orgPanNumber + ", orgWebsite="
				+ orgWebsite + ", manfSiteName=" + manfSiteName + ", manfSiteAddress=" + manfSiteAddress
				+ ", manfSitePincode=" + manfSitePincode + ", manfCountryId=" + manfCountryId + ", manfStateId="
				+ manfStateId + ", manfDistId=" + manfDistId + ", manfSiteCity=" + manfSiteCity
				+ ", manfSiteContactNumber=" + manfSiteContactNumber + ", manfSiteFaxNumber=" + manfSiteFaxNumber
				+ ", manfLicNumber=" + manfLicNumber + ", iecNumber=" + iecNumber + ", iecIssueDate=" + iecIssueDate
				+ ", iecIssueAuthority=" + iecIssueAuthority + ", ssiNumber=" + ssiNumber + ", ssiIssueDate="
				+ ssiIssueDate + ", ssiType=" + ssiType + ", contactPersonName=" + contactPersonName
				+ ", contactPerDesg=" + contactPerDesg + ", contPerMobileNo=" + contPerMobileNo + ", contPersEmail="
				+ contPersEmail + ", numRcmsStatus=" + numRcmsStatus + ", numEmailStatus=" + numEmailStatus
				+ ", numIsValied=" + numIsValied + ", randomNumber=" + randomNumber + ", lastUpdatedDate="
				+ lastUpdatedDate + ", ExpirationTime=" + expirationTime + ", createdDate=" + createdDate + ", numTrUserId=" + numTrUserId + ", dtTrDate="
				+ dtTrDate + ", numInstId=" + numInstId + ", numSeatId=" + numSeatId + ", numPremisesNo="
				+ numPremisesNo + ", memberOfOtherExportPromotionCouncil=" + memberOfOtherExportPromotionCouncil
				+ ", rcmcOfFieo=" + rcmcOfFieo + ", strRcmcNumber=" + strRcmcNumber + ", numApprovalStatusPharmaexil="
				+ numApprovalStatusPharmaexil + ", strReason=" + strReason + ", publicKey=" + publicKey
				+ ", verificationLink=" + verificationLink + ", gstnumber=" + gstnumber
				+ ", otherPromotionCouncilDetails=" + otherPromotionCouncilDetails + ", passwordHistory="
				+ passwordHistory + ", desktopEntity=" + desktopEntity + ", roleId=" + roleId + ", roleName=" + roleName
				+ ", gsOne=" + gsOne + ", officialRegistration=" + officialRegistration + "]";
	}

	

	public OfficialRegistrationDetails getOfficialRegistration() {
		return officialRegistration;
	}

	public void setOfficialRegistration(OfficialRegistrationDetails officialRegistration) {
		this.officialRegistration = officialRegistration;
	}


}
