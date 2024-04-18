package in.cdacnoida.dava.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

//@Entity
//@Table(name="zone_mst")
public class ZoneMst{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="generator")
	@TableGenerator(name="generator", initialValue=1, allocationSize=1)
	@Column(name="num_zone_id")
	int zoneId;
	
	@Column(name="str_zone_name")
	String zoneName;
	
	@Column(name="str_remarks")
	String remarks;
	
	@Column(name="num_isvalid")
	int num_isvalid;
	
	@Column(name="num_tr_user_id")
	int num_tr_user_id;
	
	@Column(name="dt_tr_date")
	Date dt_tr_date;
	
	@Column(name="num_inst_id")
	int num_inst_id;

	public int getNum_isvalid() {
		return num_isvalid;
	}

	public void setNum_isvalid(int num_isvalid) {
		this.num_isvalid = num_isvalid;
	}

	public int getNum_tr_user_id() {
		return num_tr_user_id;
	}

	public void setNum_tr_user_id(int num_tr_user_id) {
		this.num_tr_user_id = num_tr_user_id;
	}

	public Date getDt_tr_date() {
		return dt_tr_date;
	}

	public void setDt_tr_date(Date dt_tr_date) {
		this.dt_tr_date = dt_tr_date;
	}

	public int getNum_inst_id() {
		return num_inst_id;
	}

	public void setNum_inst_id(int num_inst_id) {
		this.num_inst_id = num_inst_id;
	}

	public int getZoneId() {
		return zoneId;
	}

	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
