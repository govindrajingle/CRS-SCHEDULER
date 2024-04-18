package in.cdacnoida.dava.model;

public class PackUnitMasterModel {

	int numPackId;
	String packName;
	String remarks;
	int num_isvalid;
	 int[] radio;
	 
	 
	 
	public int[] getRadio() {
		return radio;
	}
	public void setRadio(int[] radio) {
		this.radio = radio;
	}
	public int getNum_isvalid() {
		return num_isvalid;
	}
	public void setNum_isvalid(int num_isvalid) {
		this.num_isvalid = num_isvalid;
	}
	public int getNumPackId() {
		return numPackId;
	}
	public void setNumPackId(int numPackId) {
		this.numPackId = numPackId;
	}
	public String getPackName() {
		return packName;
	}
	public void setPackName(String packName) {
		this.packName = packName;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
