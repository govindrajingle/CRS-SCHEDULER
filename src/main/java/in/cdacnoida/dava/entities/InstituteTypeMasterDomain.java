package in.cdacnoida.dava.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

//@Entity
//@Table(name = "Institute_Type_Mst")
public class InstituteTypeMasterDomain implements Serializable {

	private static final long serialVersionUID = 5417354371927066831L;

	@Id
	@Column(name = "num_inst_type_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	int numInstTypeId;

	@Column(name = "str_inst_type_name")
	String strInstTypeName;

	@Column(name = "str_inst_type_code")
	String strInstTypeCode;

	@Column(name="num_iscdsco_office")
	int  numIsCdscoOffice;
	
	@Column(name = "str_remarks")
	String strRemarks;

	@Column(name="NUM_ISVALID")
    int numIsValid;
	
	@Column(name="DT_TR_DATE")
	Date dtTrDate;
	
	@Column(name="NUM_TR_USER_ID")
	int  numTrUserId;

	public int getNumInstTypeId() {
		return numInstTypeId;
	}

	public void setNumInstTypeId(int numInstTypeId) {
		this.numInstTypeId = numInstTypeId;
	}

	public String getStrInstTypeName() {
		return strInstTypeName;
	}

	public void setStrInstTypeName(String strInstTypeName) {
		this.strInstTypeName = strInstTypeName;
	}

	public String getStrInstTypeCode() {
		return strInstTypeCode;
	}

	public void setStrInstTypeCode(String strInstTypeCode) {
		this.strInstTypeCode = strInstTypeCode;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	public int getNumIsCdscoOffice() {
		return numIsCdscoOffice;
	}

	public void setNumIsCdscoOffice(int numIsCdscoOffice) {
		this.numIsCdscoOffice = numIsCdscoOffice;
	}

	public int getNumIsValid() {
		return numIsValid;
	}

	public void setNumIsValid(int numIsValid) {
		this.numIsValid = numIsValid;
	}

	public Date getDtTrDate() {
		return dtTrDate;
	}

	public void setDtTrDate(Date dtTrDate) {
		this.dtTrDate = dtTrDate;
	}

	public int getNumTrUserId() {
		return numTrUserId;
	}

	public void setNumTrUserId(int numTrUserId) {
		this.numTrUserId = numTrUserId;
	}

		
	
}