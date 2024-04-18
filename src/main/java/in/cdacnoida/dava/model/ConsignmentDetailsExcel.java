package in.cdacnoida.dava.model;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelRow;

public class ConsignmentDetailsExcel {

	
	public ConsignmentDetailsExcel() {}
	
	@ExcelRow 
	private int rowIndex;
	
	@ExcelCell(0)
	private String sender_manufacturer_code;

	@ExcelCell(1)
	private String filename;
	
	@ExcelCell(2)
	private String file_date;

	@ExcelCell(3)
	private String file_time;
	
	@ExcelCell(4)
	private String supply_type;

	@ExcelCell(5)
	private String serialization_type;

	@ExcelCell(6)
	private String eway_bill_no;
	
	@ExcelCell(7)
	private String bill_date;
	
	@ExcelCell(8)
	private String regionId;
	
	@ExcelCell(9)
	private String countryOfExp;
	
	@ExcelCell(10)
	private String companyName;
	
	@ExcelCell(11)
	private String companyAddress;
	
	@ExcelCell(12)
	private String portName;
	
	@ExcelCell(13)
	private String landingPort;
	
	@ExcelCell(14)
	private String tertiaryCount;
	
	@ExcelCell(15)
	private String tertiaryType;
	
	@ExcelCell(16)
	private String productCount;
	
	@ExcelCell(17)
	private String sSCC;

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public String getSender_manufacturer_code() {
		return sender_manufacturer_code;
	}

	public void setSender_manufacturer_code(String sender_manufacturer_code) {
		this.sender_manufacturer_code = sender_manufacturer_code;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFile_date() {
		return file_date;
	}

	public void setFile_date(String file_date) {
		this.file_date = file_date;
	}

	public String getFile_time() {
		return file_time;
	}

	public void setFile_time(String file_time) {
		this.file_time = file_time;
	}

	public String getSerialization_type() {
		return serialization_type;
	}

	public void setSerialization_type(String serialization_type) {
		this.serialization_type = serialization_type;
	}

     
	
	
	

	public String getEway_bill_no() {
		return eway_bill_no;
	}

	public void setEway_bill_no(String eway_bill_no) {
		this.eway_bill_no = eway_bill_no;
	}

	public String getBill_date() {
		return bill_date;
	}

	public void setBill_date(String bill_date) {
		this.bill_date = bill_date;
	}

	public String getPortName() {
		return portName;
	}

	public void setPortName(String portName) {
		this.portName = portName;
	}

	public String getLandingPort() {
		return landingPort;
	}

	public void setLandingPort(String landingPort) {
		this.landingPort = landingPort;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getCountryOfExp() {
		return countryOfExp;
	}

	public void setCountryOfExp(String countryOfExp) {
		this.countryOfExp = countryOfExp;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getTertiaryCount() {
		return tertiaryCount;
	}

	public void setTertiaryCount(String tertiaryCount) {
		this.tertiaryCount = tertiaryCount;
	}

	public String getTertiaryType() {
		return tertiaryType;
	}

	public void setTertiaryType(String tertiaryType) {
		this.tertiaryType = tertiaryType;
	}

	public String getProductCount() {
		return productCount;
	}

	public void setProductCount(String productCount) {
		this.productCount = productCount;
	}

	public String getsSCC() {
		return sSCC;
	}

	public void setsSCC(String sSCC) {
		this.sSCC = sSCC;
	}

	
	
	
	public String getSupply_type() {
		return supply_type;
	}

	public void setSupply_type(String supply_type) {
		this.supply_type = supply_type;
	}

	@Override
	public String toString() {
		return "ConsignmentDetailsExcel [rowIndex=" + rowIndex + ", sender_manufacturer_code="
				+ sender_manufacturer_code + ", filename=" + filename + ", file_date=" + file_date + ", file_time="
				+ file_time + ", supply_type=" + supply_type + ", serialization_type=" + serialization_type
				+ ", eway_bill_no=" + eway_bill_no + ", bill_date=" + bill_date + ", regionId=" + regionId
				+ ", countryOfExp=" + countryOfExp + ", companyName=" + companyName + ", companyAddress="
				+ companyAddress + ", portName=" + portName + ", landingPort=" + landingPort + ", tertiaryCount="
				+ tertiaryCount + ", tertiaryType=" + tertiaryType + ", productCount=" + productCount + ", sSCC=" + sSCC
				+ "]";
	}

	
	
	
	
	
	

	
	
	

}
