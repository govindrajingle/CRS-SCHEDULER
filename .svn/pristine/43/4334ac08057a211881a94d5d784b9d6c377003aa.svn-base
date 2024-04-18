package in.cdacnoida.dava.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ENVELOPE")
@XmlAccessorType (XmlAccessType.FIELD)
public class ProductEnvelope {
	
	@XmlElement(name = "PRODUCT")
	private List<ProductSchemaDtl> productSchemaDtl;

	public List<ProductSchemaDtl> getProductSchemaDtl() {
		return productSchemaDtl;
	}

	public void setProductSchemaDtl(List<ProductSchemaDtl> productSchemaDtl) {
		this.productSchemaDtl = productSchemaDtl;
	}

	@Override
	public String toString() {
		return "ProductEnvelope [productSchemaDtl=" + productSchemaDtl + "]";
	}
	
	

}
