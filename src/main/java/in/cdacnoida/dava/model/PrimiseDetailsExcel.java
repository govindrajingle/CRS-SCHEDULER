package in.cdacnoida.dava.model;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelRow;

public class PrimiseDetailsExcel {

	
	public PrimiseDetailsExcel() {}
	
	@ExcelRow 
	private int rowIndex;
	
	@ExcelCell(0)
	private String siteType;

	@ExcelCell(1)
	private String siteName;
	
	@ExcelCell(2)
	private String address;

	@ExcelCell(3)
	private String licennceNo;

	@ExcelCell(4)
	private String pincode;

	@ExcelCell(5)
	private String email;
	
	@ExcelCell(6)
	private String contactNo;
	
	@ExcelCell(7)
	private String contactPersonName;
	
	
	@ExcelCell(8)
	private String designation;
	
	@ExcelCell(9)
	private String mobileNo;
	
	@ExcelCell(10)
	private String contact;
	
	@ExcelCell(11)
	private String emailId;
	
	
	
	
	
	

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLicennceNo() {
		return licennceNo;
	}

	public void setLicennceNo(String licennceNo) {
		this.licennceNo = licennceNo;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	
	
	

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}
	
	

	@Override
	public String toString() {
		return "PrimiseDetailsExcel [rowIndex=" + rowIndex + ", siteType=" + siteType + ", siteName=" + siteName
				+ ", address=" + address + ", licennceNo=" + licennceNo + ", pincode=" + pincode + ", email=" + email
				+ ", contactNo=" + contactNo + ", designation=" + designation + ", mobileNo=" + mobileNo + ", contact="
				+ contact + ", emailId=" + emailId + "]";
	}

	
	
	
	
	
	
	
	
	
}
