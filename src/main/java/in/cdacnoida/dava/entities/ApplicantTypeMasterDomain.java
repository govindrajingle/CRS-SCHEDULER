// Deepshikha 11-12-19

package in.cdacnoida.dava.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

//@Entity
@Table(name = "applicant_type_mst")
public class ApplicantTypeMasterDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	private Integer numApplTypeId;
	
	@Column(name="num_isvalid")
	private Integer num_isvalid;
	
	@Column(name="str_appl_type_name")
	private String strApplTypeName;
	
	@Column(name="str_appl_type_short_name")
	private String strApplTypeShortName;
	
	@Column(name="num_tr_user_id")
	private String numTrUserId;
	
	@Column(name="dt_tr_date")
	private String dtTrDate;

	public Integer getNum_isvalid() {
		return num_isvalid;
	}

	public void setNum_isvalid(Integer num_isvalid) {
		this.num_isvalid = num_isvalid;
	}

	public String getStrApplTypeName() {
		return strApplTypeName;
	}

	public void setStrApplTypeName(String strApplTypeName) {
		this.strApplTypeName = strApplTypeName;
	}

	public String getStrApplTypeShortName() {
		return strApplTypeShortName;
	}

	public void setStrApplTypeShortName(String strApplTypeShortName) {
		this.strApplTypeShortName = strApplTypeShortName;
	}

	public String getNumTrUserId() {
		return numTrUserId;
	}

	public void setNumTrUserId(String numTrUserId) {
		this.numTrUserId = numTrUserId;
	}

	public String getDtTrDate() {
		return dtTrDate;
	}

	public void setDtTrDate(String dtTrDate) {
		this.dtTrDate = dtTrDate;
	}

	public Integer getNumApplTypeId() {
		return numApplTypeId;
	}

	public void setNumApplTypeId(Integer numApplTypeId) {
		this.numApplTypeId = numApplTypeId;
	}


	
	
}
