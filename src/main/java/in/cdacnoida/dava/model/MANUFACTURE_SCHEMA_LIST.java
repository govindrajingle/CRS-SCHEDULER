package in.cdacnoida.dava.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="MANUFACTURER_LIST")
@XmlAccessorType (XmlAccessType.FIELD)
public class MANUFACTURE_SCHEMA_LIST {

	@XmlElement(name = "MANUFACTURER")
	private List<InstitutePremiseDtl> institutePremiseDtl;

	public List<InstitutePremiseDtl> getInstitutePremiseDtl() {
		return institutePremiseDtl;
	}

	public void setInstitutePremiseDtl(List<InstitutePremiseDtl> institutePremiseDtl) {
		this.institutePremiseDtl = institutePremiseDtl;
	}

	@Override
	public String toString() {
		return "MANUFACTURE_SCHEMA_LIST [institutePremiseDtl=" + institutePremiseDtl + "]";
	}
	
	
}
