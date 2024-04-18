package in.cdacnoida.dava.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Prod_List")
@XmlAccessorType (XmlAccessType.FIELD)
public class Product_List {

	public Product_List() {}
	
	@XmlElement(name = "ProductName")
	private String productName;
	
	@XmlElement(name = "ProdCode")
	private String prodCode;
	
	@XmlElement(name = "BATCH_NUMBER")
	private String batchnumber;
	
	
	@XmlElement(name = "EXPIRY_DATE")
	private String expirydate;
	
	
	@XmlElement(name = "PROCUREMENT_SOURCE_GSTN")
	private String procumentsourcegstn;
	
	@XmlElement(name = "PROCUREMENT_SOURCE_NAME")
	private String procumentsourcename;
	
	@XmlElement(name = "PROCUREMENT_SOURCE_ADDRESS")
	private String procumentsourceaddress;
	
	@XmlElement(name = "ProductCount")
	private String ProductCount;
	
	@XmlElement(name = "Secondary3Count")
	private String secondary3Count;
	
	@XmlElement(name = "SSCC")
	private String sscc;
	
	@XmlElement(name = "Product")
	private List<Product> product=new ArrayList<Product>();
	
	@XmlElement(name = "SECONDARY3")
	private List<SECONDARY3> secondary3;
	
	
	/*
	 * public String getTertiaryType() { return tertiaryType; } public void
	 * setTertiaryType(String tertiaryType) { this.tertiaryType = tertiaryType; }
	 */
	
	public String getProductCount() {
		return ProductCount;
	}
	public void setProductCount(String productCount) {
		ProductCount = productCount;
	}
	
	public String getSecondary3Count() {
		return secondary3Count;
	}
	public void setSecondary3Count(String secondary3Count) {
		this.secondary3Count = secondary3Count;
	}
	
	public List<SECONDARY3> getSecondary3() {
		return secondary3;
	}
	public void setSecondary3(List<SECONDARY3> secondary3) {
		this.secondary3 = secondary3;
	}
	
	
	public String getSscc() {
		return sscc;
	}
	public void setSscc(String sscc) {
		this.sscc = sscc;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void addProduct(Product product) {
		this.product.add(product);
	}
	public void setProductName(String productName) {
		this.productName=productName;
		
	}
	public void setProdCode(String prodCode) {
	  this.prodCode=prodCode;
		
	}
	public void setBatch_number(String batch_number) {
		this.batchnumber=batch_number;
		
	}
	public void setExpiry_date(String expiray_date) {
		this.expirydate=expiray_date;
		
	}
	public void setProcurementSourceGstn(String procureement_source_gstn) {
      this.procumentsourcegstn=procureement_source_gstn;
		
	}
	public void setProcurement_source_name(String procurement_source_name) {
		
		this.procumentsourcename=procurement_source_name;
		
	}
	public void setProcurement_source_address(String procurement_source_address) {
	this.procumentsourceaddress=procurement_source_address;
		
	}
	
	
	
	
	
}
