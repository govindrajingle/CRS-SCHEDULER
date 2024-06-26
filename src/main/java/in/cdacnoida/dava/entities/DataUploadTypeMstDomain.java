package in.cdacnoida.dava.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/*
@Entity
@Table(name = "dataupload_type_mst")
public class DataUploadTypeMstDomain extends TransactionInfoDomain implements Serializable {

	
	
	

*/
//@Entity
@Table(name = "dataupload_type_mst")
public class DataUploadTypeMstDomain extends TransactionInfoDomain implements Serializable {

	@Id
	@Column(name = "num_type_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	private Integer numTypeId;

	/*
	 * @Column(name = "num_type_id") int numTypeId;
	 * 
	 */	@Column(name = "str_type_name") 
	String strTypeName;
	
	@Column(name = "str_xsd_filename") 
	String strXsdFilename;
	
	@Column(name = "str_remarks") 
	String strRemarks;

	public int getNumTypeId() {
		return numTypeId;
	}

	public void setNumTypeId(int numTypeId) {
		this.numTypeId = numTypeId;
	}

	public String getStrTypeName() {
		return strTypeName;
	}

	public void setStrTypeName(String strTypeName) {
		this.strTypeName = strTypeName;
	}

	public String getStrXsdFilename() {
		return strXsdFilename;
	}

	public void setStrXsdFilename(String strXsdFilename) {
		this.strXsdFilename = strXsdFilename;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	
	
	
}
