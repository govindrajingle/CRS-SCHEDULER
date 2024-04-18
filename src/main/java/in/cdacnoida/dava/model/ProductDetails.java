package in.cdacnoida.dava.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import in.cdacnoida.dava.model.EXPORT;


@XmlRootElement(name="PRODUCT")
@XmlAccessorType (XmlAccessType.FIELD)
public class ProductDetails {

	
	public ProductDetails() {}
	
	
	@XmlElement(name = "FILENAME")
	private String fileName;
	
	@XmlElement(name = "MANUFACTURER_CODE")
	private String manufacturerCode;
	
	
	@XmlElement(name = "PRODUCT")
	private List<PRODUCTS> product=new ArrayList<PRODUCTS>();
	
	
	public void addProduct(PRODUCTS product) {
		this.product.add(product);
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getManufacturerCode() {
		return manufacturerCode;
	}


	public void setManufacturerCode(String manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
	}


	@Override
	public String toString() {
		return "ProductDetails [fileName=" + fileName + ", manufacturerCode=" + manufacturerCode + "]";
	}
	
	
	
	
	
	
}
