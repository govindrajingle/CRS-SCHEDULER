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
//@Table(name = "member_type_mst")
public class MemberTypeMasterDomain extends TransactionInfoDomain implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	private Integer numTypeId;
	
	@Column(name="str_type_name")
	private String strTypeName;
	
	@Column(name="str_type_short_name")
	private String strTypeShortName;

	public Integer getNumTypeId() {
		return numTypeId;
	}

	public void setNumTypeId(Integer numTypeId) {
		this.numTypeId = numTypeId;
	}

	public String getStrTypeName() {
		return strTypeName;
	}

	public void setStrTypeName(String strTypeName) {
		this.strTypeName = strTypeName;
	}

	public String getStrTypeShortName() {
		return strTypeShortName;
	}

	public void setStrTypeShortName(String strTypeShortName) {
		this.strTypeShortName = strTypeShortName;
	}
	
	
	
}
