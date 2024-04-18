package in.cdacnoida.dava.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.poiji.annotation.ExcelCell;

@XmlRootElement(name = "PRODUCT")
@XmlAccessorType(XmlAccessType.FIELD)
public class PRODUCTS {

	public PRODUCTS() {
	}
	

	@XmlElement(name = "ManufacturingSiteCode")
	private String manfSiteCode;

	@XmlElement(name = "PRODUCT_TYPE")
	private String productType;

	@XmlElement(name = "PRODUCT_CODE")
	private String productCode;

	@XmlElement(name = "PRODUCT_NAME")
	private String ProductName;

	@XmlElement(name = "GENERIC_NAME")
	private String GenericName;

	@XmlElement(name = "COMPOSITION")
	private String Composition;

	@XmlElement(name = "SCHEDULED")
	private String Scheduled;

	@XmlElement(name = "REMARK")
	private String Remark;

	@XmlElement(name = "STORAGE_CONDITION")
	private String StorageCondition;

	@XmlElement(name = "STRENGTH")
	private String Strength;

	@XmlElement(name = "DOSAGE")
	private String Dosage;

	@XmlElement(name = "HS_CODE")
	private String HsCode;

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

    
	
	
	

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getGenericName() {
		return GenericName;
	}

	public void setGenericName(String genericName) {
		GenericName = genericName;
	}

	public String getComposition() {
		return Composition;
	}

	public void setComposition(String composition) {
		Composition = composition;
	}

	public String getScheduled() {
		return Scheduled;
	}

	public void setScheduled(String scheduled) {
		Scheduled = scheduled;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	public String getStorageCondition() {
		return StorageCondition;
	}

	public void setStorageCondition(String storageCondition) {
		StorageCondition = storageCondition;
	}

	public String getStrength() {
		return Strength;
	}

	public void setStrength(String strength) {
		Strength = strength;
	}

	public String getDosage() {
		return Dosage;
	}

	public void setDosage(String dosage) {
		Dosage = dosage;
	}

	public String getHsCode() {
		return HsCode;
	}

	public void setHsCode(String hsCode) {
		HsCode = hsCode;
	}
	
	
	

	public String getManfSiteCode() {
		return manfSiteCode;
	}

	public void setManfSiteCode(String manfSiteCode) {
		this.manfSiteCode = manfSiteCode;
	}

	@Override
	public String toString() {
		return "PRODUCTS [productType=" + productType + ", ProductName=" + ProductName
				+ ", GenericName=" + GenericName + ", Composition=" + Composition + ", Scheduled=" + Scheduled
				+ ", Remark=" + Remark + ", StorageCondition=" + StorageCondition + ", Strength=" + Strength
				+ ", Dosage=" + Dosage + ", HsCode=" + HsCode + "]";
	}

	public void addProduct(List<PRODUCTS> product) {
		// TODO Auto-generated method stub
		this.addProduct(product);
	}
	
	@XmlElement(name = "Product")
	private List<Product> product=new ArrayList<Product>();

}
