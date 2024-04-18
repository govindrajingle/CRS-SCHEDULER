package in.cdacnoida.dava.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="PRODUCT")
@XmlAccessorType (XmlAccessType.FIELD)
public class ProductSchemaDtl {
	
	@XmlElement(name = "PRODUCT_TYPE")
	private String prodType;
	
	@XmlElement(name = "PRODUCT_CODE")
	private String prodCode;
	
	@XmlElement(name = "PRODUCT_NAME")
	private String prodName;
	
	@XmlElement(name = "GENERIC_NAME")
	private String genName;
	
	@XmlElement(name = "COMPOSITION")
	private String composition;
	
	@XmlElement(name = "SCHEDULED")
	private String schedule;
	
	@XmlElement(name = "USAGE")
	private String usage;
	
	@XmlElement(name = "REMARK")
	private String remark;
	
	@XmlElement(name = "HS_CODE")
	private String hsCode;

	public String getProdType() {
		return prodType;
	}

	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getGenName() {
		return genName;
	}

	public void setGenName(String genName) {
		this.genName = genName;
	}

	public String getComposition() {
		return composition;
	}

	public void setComposition(String composition) {
		this.composition = composition;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getHsCode() {
		return hsCode;
	}

	public void setHsCode(String hsCode) {
		this.hsCode = hsCode;
	}

	@Override
	public String toString() {
		return "ProductSchemaDtl [prodType=" + prodType + ", prodCode=" + prodCode + ", prodName=" + prodName
				+ ", genName=" + genName + ", composition=" + composition + ", schedule=" + schedule + ", usage="
				+ usage + ", remark=" + remark + ", hsCode=" + hsCode + "]";
	}

}
