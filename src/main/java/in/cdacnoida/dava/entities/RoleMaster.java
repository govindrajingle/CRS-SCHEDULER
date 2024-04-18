package in.cdacnoida.dava.entities;

import java.io.Serializable;
import org.hibernate.annotations.Formula;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

//@Entity
//@Table(name="ROLE_MST")

public class RoleMaster implements Serializable{

	private static final long serialVersionUID = -167673813573728172L;

	@Id
	@Column(name="NUM_ROLE_ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=113, allocationSize=1)
	private int numRoleId;
	
	@Column(name="STR_ROLE_NAME")
	private String strRoleName;

	@Column(name="NUM_USER_TYPE_ID")
	private int numUserTypeId;
	
	@Column(name="STR_SHORT_NAME")
	private String strShortName;
	
	@Column(name="num_isvalid")
	private String num_isvalid;
	
	@Column(name="dt_tr_date")
	private String dt_tr_date;
	
	@Column(name="num_tr_user_id")
	private String num_tr_user_id;

	public int getNumUserTypeId() {
		return numUserTypeId;
	}

	public void setNumUserTypeId(int numUserTypeId) {
		this.numUserTypeId = numUserTypeId;
	}

	public int getNumRoleId() {
		return numRoleId;
	}

	public void setNumRoleId(int numRoleId) {
		this.numRoleId = numRoleId;
	}

	public String getStrRoleName() {
		return strRoleName;
	}

	public void setStrRoleName(String strRoleName) {
		this.strRoleName = strRoleName;
	}

	public String getStrShortName() {
		return strShortName;
	}

	public void setStrShortName(String strShortName) {
		this.strShortName = strShortName;
	}

	public String getNum_isvalid() {
		return num_isvalid;
	}

	public void setNum_isvalid(String num_isvalid) {
		this.num_isvalid = num_isvalid;
	}

	public String getDt_tr_date() {
		return dt_tr_date;
	}

	public void setDt_tr_date(String dt_tr_date) {
		this.dt_tr_date = dt_tr_date;
	}

	public String getNum_tr_user_id() {
		return num_tr_user_id;
	}

	public void setNum_tr_user_id(String num_tr_user_id) {
		this.num_tr_user_id = num_tr_user_id;
	}


}
