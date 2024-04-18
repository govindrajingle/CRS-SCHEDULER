package in.cdacnoida.dava.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import in.cdacnoida.dava.model.EXPORT;


@XmlRootElement(name="ConsignmentDetails")
@XmlAccessorType (XmlAccessType.FIELD)
public class ConsignmentDetails {

	
	public ConsignmentDetails() {}
	
	@XmlElement(name = "SENDER_MANUFACTURER_CODE")
	private String sender_manufacturer_code;
	
	@XmlElement(name = "FILENAME")
	private String filename;
	
	@XmlElement(name = "FILE_DATE")
	private String file_date;
	
	@XmlElement(name = "FILE_TIME")
	private String file_time;
	
	
	@XmlElement(name = "SupplyType")
	private String supply_type;
	
	
	
	
	@XmlElement(name = "SERIALIZATION_TYPE")
	private String serialization_type;
	
	@XmlElement(name = "EWay_Bill_No")
	private String eway_bill_no;

	@XmlElement(name = "Bill_Date")
	private String bill_date;
	
	
	@XmlElement(name = "RegionCD")
	private String regionDc;
	
	
	@XmlElement(name = "CountryOfExp")
	private String countryOfExp;
	
	
	@XmlElement(name = "CompanyName")
	private String companyName;
	
	@XmlElement(name = "CompanyAddress")
	private String companyAddress;
	
	
	@XmlElement(name = "PortName")
	private String portName;
	
	@XmlElement(name = "LandingPort")
	private String landingPort;
	
	@XmlElement(name = "Prod_List")
	private List<Product_List> prolist=new ArrayList<Product_List>();
	

	
	
	
	@XmlElement(name = "TertiaryCount")
	private String tertiaryCount;

	@XmlElement(name = "TERTIARY")
	private List<TERTIARY> tertiary=new ArrayList<TERTIARY>();
	
	@XmlElement(name = "EXPORT")
	private EXPORT export;
	
	
	@XmlElement(name = "SEC_LIST")
	private SEC_LIST secList;
	
	
	
	public SEC_LIST getSecList() {
		return secList;
	}
	public void setSecList(SEC_LIST secList) {
		this.secList = secList;
	}
	public String getCountryOfExp() {
		return countryOfExp;
	}
	public void setCountryOfExp(String countryOfExp) {
		this.countryOfExp = countryOfExp;
	}
	public List<TERTIARY> getTertiary() {
		return tertiary;
	}
	public void addTertiary(TERTIARY tertiary) {
		this.tertiary.add(tertiary);
	}
	
	
	/*
	 * public void addPoduct(Product_List prolist) { this.prolist.add(prolist); }
	 */
	
	
	
	
	
	@XmlElement(name = "Product")
	private List<Product> product=new ArrayList<Product>();
	
	public void addProduct(Product product) {
		this.product.add(product);
	}
	
	
  //  public void addProduct(Product_List prolist)
  //  {	
	//this.addProduct(prolist);	
    //	this.addProduct(prolist);
    //	this.prolist.add(prolist);
    	
  //  }
    
    
    
    
	
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
	
	public EXPORT getExport() {
		return export;
	}
	public void setExport(EXPORT export) {
		this.export = export;
	}

	public String getRegionDc() {
		return regionDc;
	}
	public void setRegionDc(String regionDc) {
		this.regionDc = regionDc;
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
	
	
	
	
	public String getSupply_type() {
		return supply_type;
	}
	public void setSupply_type(String supply_type) {
		this.supply_type = supply_type;
	}
	
	
	@Override
	public String toString() {
		return "ConsignmentDetails [sender_manufacturer_code=" + sender_manufacturer_code + ", filename=" + filename
				+ ", file_date=" + file_date + ", file_time=" + file_time + ", supply_type=" + supply_type
				+ ", serialization_type=" + serialization_type + ", eway_bill_no=" + eway_bill_no + ", bill_date="
				+ bill_date + ", regionDc=" + regionDc + ", countryOfExp=" + countryOfExp + ", companyName="
				+ companyName + ", companyAddress=" + companyAddress + ", portName=" + portName + ", landingPort="
				+ landingPort + ", tertiaryCount=" + tertiaryCount + ", tertiary=" + tertiary + ", export=" + export
				+ ", secList=" + secList + "]";
	}
	public void addProduct(Product_List prolist) {
		// TODO Auto-generated method stub
		
		this.prolist.add(prolist);
		
	}
	
	
	

	
	
	
	
	

}
