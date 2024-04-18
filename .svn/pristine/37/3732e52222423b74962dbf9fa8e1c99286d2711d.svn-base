package in.cdacnoida.dava.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Product")
@XmlAccessorType (XmlAccessType.FIELD)
public class Product {

	@XmlElement(name = "ProductName")
	private String productName;
	
	@XmlElement(name = "ProdCode")
	private String prodCode;
	
	@XmlElement(name = "PACK_SIZE")
	private String pack_size;
	
	@XmlElement(name = "BATCH_NUMBER")
	private String batch_number;
	
	@XmlElement(name = "EXPIRY_DATE")
	private String expiry_date;
	
	@XmlElement(name = "HS_CODE")
	private String hs_code;
	
	@XmlElement(name = "PROCUREMENT_SOURCE_GSTN")
	private String procurementSourceGstn;
	
	@XmlElement(name = "PROCUREMENT_SOURCE_NAME")
	private String procurement_source_name;
	
	@XmlElement(name = "PROCUREMENT_SOURCE_ADDRESS")
	private String procurement_source_address;
	
	@XmlElement(name = "SubCount")
	private String subcount;
	
	
	
	
	
	
	/*
	 * public String getSubcount() { return subcount; } public void
	 * setSubcount(String subcount) { this.subcount = subcount; }
	 */
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProcurementSourceGstn() {
		return procurementSourceGstn;
	}
	public void setProcurementSourceGstn(String procurementSourceGstn) {
		this.procurementSourceGstn = procurementSourceGstn;
	}
	public String getPack_size() {
		return pack_size;
	}
	public void setPack_size(String pack_size) {
		this.pack_size = pack_size;
	}
	
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	
	public String getBatch_number() {
		return batch_number;
	}
	public void setBatch_number(String batch_number) {
		this.batch_number = batch_number;
	}
	
	public String getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}
	
	public String getProcurement_source_name() {
		return procurement_source_name;
	}
	public void setProcurement_source_name(String procurement_source_name) {
		this.procurement_source_name = procurement_source_name;
	}
	
	public String getProcurement_source_address() {
		return procurement_source_address;
	}
	public void setProcurement_source_address(String procurement_source_address) {
		this.procurement_source_address = procurement_source_address;
	}
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", prodCode=" + prodCode + ", pack_size=" + pack_size
				+ ", batch_number=" + batch_number + ", expiry_date=" + expiry_date + ", procurementSourceGstn="
				+ procurementSourceGstn + ", procurement_source_name=" + procurement_source_name
				+ ", procurement_source_address=" + procurement_source_address + "]";
	}
	public void setSubCount(String subCount) {
		
		this.subcount=subCount;
	}
	
	@XmlElement(name = "List_srno")
	private List<List_srno> listSrNo=new ArrayList<List_srno>();
	
	public void addListSrNo(List_srno listSrNo) {
		this.listSrNo.add(listSrNo);
	}
	public String getHs_code() {
		return hs_code;
	}
	public void setHs_code(String hs_code) {
		this.hs_code = hs_code;
	}
	
	
	
	
	
}
