package in.cdacnoida.dava.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement//This annotation is used at the top level class to indicate the root element in the XML document. The name attribute in the annotation is optional. If not specified, the class name is used as the root XML element in the document.
public class XmlBean {

	public XmlBean() {}

	private int id;  

	private String companyName;
	
	private String companyAddress;
	
	private String companyCountry;

	@XmlAttribute
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@XmlElement  
	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	@XmlElement  
	public String getCompanyCountry() {
		return companyCountry;
	}

	public void setCompanyCountry(String companyCountry) {
		this.companyCountry = companyCountry;
	}

	@Override
	public String toString() {
		return "XmlBean [id=" + id + ", companyName=" + companyName + ", companyAddress=" + companyAddress
				+ ", companyCountry=" + companyCountry + "]";
	}

}
