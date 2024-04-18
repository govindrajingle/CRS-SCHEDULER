package in.cdacnoida.dava.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SECONDARY1")
@XmlAccessorType (XmlAccessType.FIELD)
public class SECONDARY1 {

	@XmlElement(name = "Secondary1Type")
	private String secondary1Type;
	@XmlElement(name = "CODE_SNoSecondary1")
	private String code_SNoSecondary1;
	@XmlElement(name = "Product")
	private List<Product> product;
	
	
	public String getSecondary1Type() {
		return secondary1Type;
	}
	public void setSecondary1Type(String secondary1Type) {
		this.secondary1Type = secondary1Type;
	}
	
	public String getCode_SNoSecondary1() {
		return code_SNoSecondary1;
	}
	public void setCode_SNoSecondary1(String code_SNoSecondary1) {
		this.code_SNoSecondary1 = code_SNoSecondary1;
	}
	
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "SECONDARY1 [secondary1Type=" + secondary1Type + ", code_SNoSecondary1=" + code_SNoSecondary1
				+ ", product=" + product + "]";
	}

}
