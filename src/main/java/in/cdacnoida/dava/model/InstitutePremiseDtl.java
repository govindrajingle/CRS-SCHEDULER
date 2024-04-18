package in.cdacnoida.dava.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="MANUFACTURER")
@XmlAccessorType (XmlAccessType.FIELD)
public class InstitutePremiseDtl {
	
	@XmlElement(name = "EXPO_TYPE")
	private String expType;
	
	@XmlElement(name = "MANF_NAME")
	private String manufName;
	
	@XmlElement(name = "MANF_STAT")
	private String manufStatus;
	
	@XmlElement(name = "MANF_PANN")
	private String manufPan;
	
	@XmlElement(name = "MANF_LICN")
	private String manufLic;
	
	@XmlElement(name = "MANF_IECN")
	private String manufIEC;
	
	@XmlElement(name = "MANF_TINN")
	private String manufTinn;
	
	@XmlElement(name = "MANF_ADDR")
	private String manufAdd;
	
	@XmlElement(name = "MANF_RAJY")
	private String manufState;
	
	@XmlElement(name = "MANF_DIST")
	private String manufDist;
	
	@XmlElement(name = "MANF_CITY")
	private String manufCity;
	
	@XmlElement(name = "MANF_PINC")
	private String manufPin;
	
	@XmlElement(name = "MANF_EMAL")
	private String manufEmail;
	
	@XmlElement(name = "MANF_WEBS")
	private String manufWebsite;
	
	@XmlElement(name = "MANF_CPER")
	private String manufContactName;
	
	@XmlElement(name = "MANF_CDSG")
	private String manufDesigNation;
	
	@XmlElement(name = "MANF_CMOB")
	private String manufContactNumber;
	
	@XmlElement(name = "MANF_CEML")
	private String manufContactEmail;
	
	@XmlElement(name = "GSTIN_NO")
	private String gstinNo;
	
	@XmlElement(name = "GS1_NO")
	private String gs1No;

	public String getExpType() {
		return expType;
	}

	public void setExpType(String expType) {
		this.expType = expType;
	}

	public String getManufName() {
		return manufName;
	}

	public void setManufName(String manufName) {
		this.manufName = manufName;
	}

	public String getManufStatus() {
		return manufStatus;
	}

	public void setManufStatus(String manufStatus) {
		this.manufStatus = manufStatus;
	}

	public String getManufPan() {
		return manufPan;
	}

	public void setManufPan(String manufPan) {
		this.manufPan = manufPan;
	}

	public String getManufLic() {
		return manufLic;
	}

	public void setManufLic(String manufLic) {
		this.manufLic = manufLic;
	}

	public String getManufIEC() {
		return manufIEC;
	}

	public void setManufIEC(String manufIEC) {
		this.manufIEC = manufIEC;
	}

	public String getManufTinn() {
		return manufTinn;
	}

	public void setManufTinn(String manufTinn) {
		this.manufTinn = manufTinn;
	}

	public String getManufAdd() {
		return manufAdd;
	}

	public void setManufAdd(String manufAdd) {
		this.manufAdd = manufAdd;
	}

	public String getManufState() {
		return manufState;
	}

	public void setManufState(String manufState) {
		this.manufState = manufState;
	}

	public String getManufDist() {
		return manufDist;
	}

	public void setManufDist(String manufDist) {
		this.manufDist = manufDist;
	}

	public String getManufCity() {
		return manufCity;
	}

	public void setManufCity(String manufCity) {
		this.manufCity = manufCity;
	}

	public String getManufPin() {
		return manufPin;
	}

	public void setManufPin(String manufPin) {
		this.manufPin = manufPin;
	}

	public String getManufEmail() {
		return manufEmail;
	}

	public void setManufEmail(String manufEmail) {
		this.manufEmail = manufEmail;
	}

	public String getManufWebsite() {
		return manufWebsite;
	}

	public void setManufWebsite(String manufWebsite) {
		this.manufWebsite = manufWebsite;
	}

	public String getManufContactName() {
		return manufContactName;
	}

	public void setManufContactName(String manufContactName) {
		this.manufContactName = manufContactName;
	}

	public String getManufDesigNation() {
		return manufDesigNation;
	}

	public void setManufDesigNation(String manufDesigNation) {
		this.manufDesigNation = manufDesigNation;
	}

	public String getManufContactNumber() {
		return manufContactNumber;
	}

	public void setManufContactNumber(String manufContactNumber) {
		this.manufContactNumber = manufContactNumber;
	}

	public String getManufContactEmail() {
		return manufContactEmail;
	}

	public void setManufContactEmail(String manufContactEmail) {
		this.manufContactEmail = manufContactEmail;
	}

	public String getGstinNo() {
		return gstinNo;
	}

	public void setGstinNo(String gstinNo) {
		this.gstinNo = gstinNo;
	}

	public String getGs1No() {
		return gs1No;
	}

	public void setGs1No(String gs1No) {
		this.gs1No = gs1No;
	}

	@Override
	public String toString() {
		return "InstitutePremiseDtl [expType=" + expType + ", manufName=" + manufName + ", manufStatus=" + manufStatus
				+ ", manufPan=" + manufPan + ", manufLic=" + manufLic + ", manufIEC=" + manufIEC + ", manufTinn="
				+ manufTinn + ", manufAdd=" + manufAdd + ", manufState=" + manufState + ", manufDist=" + manufDist
				+ ", manufCity=" + manufCity + ", manufPin=" + manufPin + ", manufEmail=" + manufEmail
				+ ", manufWebsite=" + manufWebsite + ", manufContactName=" + manufContactName + ", manufDesigNation="
				+ manufDesigNation + ", manufContactNumber=" + manufContactNumber + ", manufContactEmail="
				+ manufContactEmail + ", gstinNo=" + gstinNo + ", gs1No=" + gs1No + "]";
	}
	
}
