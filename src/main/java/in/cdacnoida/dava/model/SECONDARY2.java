package in.cdacnoida.dava.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SECONDARY2")
@XmlAccessorType (XmlAccessType.FIELD)
public class SECONDARY2 {

	public SECONDARY2() {}
	@XmlElement(name = "Secondary2Type")
	private String secondary2Type;
	@XmlElement(name = "CODE_SNoSecondary2")
	private String code_SNoSecondary2;
	@XmlElement(name = "Secondary1Count")
	private String secondary1Count;
	@XmlElement(name = "SECONDARY1")
	private List<SECONDARY1> secondary1;
	
	
	public String getSecondary2Type() {
		return secondary2Type;
	}
	public void setSecondary2Type(String secondary2Type) {
		this.secondary2Type = secondary2Type;
	}
	
	public String getCode_SNoSecondary2() {
		return code_SNoSecondary2;
	}
	public void setCode_SNoSecondary2(String code_SNoSecondary2) {
		this.code_SNoSecondary2 = code_SNoSecondary2;
	}
	
	public String getSecondary1Count() {
		return secondary1Count;
	}
	public void setSecondary1Count(String secondary1Count) {
		this.secondary1Count = secondary1Count;
	}
	
	public List<SECONDARY1> getSecondary1() {
		return secondary1;
	}
	public void setSecondary1(List<SECONDARY1> secondary1) {
		this.secondary1 = secondary1;
	}
	@Override
	public String toString() {
		return "SECONDARY2 [secondary2Type=" + secondary2Type + ", code_SNoSecondary2=" + code_SNoSecondary2
				+ ", secondary1Count=" + secondary1Count + ", secondary1=" + secondary1 + "]";
	}
	
}
