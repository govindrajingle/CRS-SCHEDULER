package in.cdacnoida.dava.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="TERTIARY")
@XmlAccessorType (XmlAccessType.FIELD)
public class TERTIARY {

	public TERTIARY() {}
	
	@XmlElement(name = "TertiaryType")
	private String tertiaryType;
	
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
	
	
	public String getTertiaryType() {
		return tertiaryType;
	}
	public void setTertiaryType(String tertiaryType) {
		this.tertiaryType = tertiaryType;
	}
	
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
	
	
}
