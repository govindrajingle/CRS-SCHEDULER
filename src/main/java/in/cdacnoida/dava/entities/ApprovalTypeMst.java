package in.cdacnoida.dava.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

//@Entity
@Table(name="approval_type_mst")
public class ApprovalTypeMst extends TransactionInfoDomain implements Serializable{
	
	private static final long serialVersionUID = -6048595144903121228L;
	
	@Id
	@Column(name="num_app_type_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1000, allocationSize=1)
	int numAppTypeId; 
	
	@Column(name="str_app_type_name")
	String strAppTypeName;
	
	@Column(name="str_remarks")
	String strRemarks;

	public int getNumAppTypeId() {
		return numAppTypeId;
	}

	public void setNumAppTypeId(int numAppTypeId) {
		this.numAppTypeId = numAppTypeId;
	}

	public String getStrAppTypeName() {
		return strAppTypeName;
	}

	public void setStrAppTypeName(String strAppTypeName) {
		this.strAppTypeName = strAppTypeName;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

}
