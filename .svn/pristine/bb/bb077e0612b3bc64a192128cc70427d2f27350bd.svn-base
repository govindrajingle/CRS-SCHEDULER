package in.cdacnoida.dava.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="PRODUCTS_LIST")
@XmlAccessorType (XmlAccessType.FIELD)
public class ProductList {
	
	public ProductList() {}
	
	
	@XmlElement(name = "FILENAME")
	private String fileName;
	
	@XmlElement(name = "MANUFACTURER_CODE")
	private String manfCode;
	
	
	@XmlElement(name = "PRODUCT")
	private List<PRODUCTS> product=new ArrayList<PRODUCTS>();


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getManfCode() {
		return manfCode;
	}


	public void setManfCode(String manfCode) {
		this.manfCode = manfCode;
	}


	public List<PRODUCTS> getProduct() {
		return product;
	}


	public void addProduct(PRODUCTS product) {
		this.product.add(product);
	}
	
	
	

}
