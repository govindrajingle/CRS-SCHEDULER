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
//@Table(name="states_mst")
public class StatesMst implements Serializable {

	private static final long serialVersionUID = -6048595144903121228L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1000, allocationSize=1)
	private Integer num_state_id;
	
	@Column(name="dt_tr_date")
	private Date dt_tr_date;
	
	@Column(name="num_isvalid")
	private Integer num_isvalid;
	
	@Column(name="num_tr_user_id")
	private Integer num_tr_user_id;
	
	@Column(name="num_country_id")
	private Integer num_country_id;
	
	@Column(name="num_inst_id")
	private Integer num_inst_id;
	
	@Column(name="num_zone_id")
	private Integer num_zone_id;
	
	@Column(name="str_state_name")
	private String str_state_name;
	
	@Column(name="str_state_short_name")
	private String str_state_short_name;

	public Integer getNum_state_id() {
		return num_state_id;
	}

	public void setNum_state_id(Integer num_state_id) {
		this.num_state_id = num_state_id;
	}

	public Date getDt_tr_date() {
		return dt_tr_date;
	}

	public void setDt_tr_date(Date dt_tr_date) {
		this.dt_tr_date = dt_tr_date;
	}

	public Integer getNum_isvalid() {
		return num_isvalid;
	}

	public void setNum_isvalid(Integer num_isvalid) {
		this.num_isvalid = num_isvalid;
	}

	public Integer getNum_tr_user_id() {
		return num_tr_user_id;
	}

	public void setNum_tr_user_id(Integer num_tr_user_id) {
		this.num_tr_user_id = num_tr_user_id;
	}

	public Integer getNum_country_id() {
		return num_country_id;
	}

	public void setNum_country_id(Integer num_country_id) {
		this.num_country_id = num_country_id;
	}

	public Integer getNum_inst_id() {
		return num_inst_id;
	}

	public void setNum_inst_id(Integer num_inst_id) {
		this.num_inst_id = num_inst_id;
	}

	public Integer getNum_zone_id() {
		return num_zone_id;
	}

	public void setNum_zone_id(Integer num_zone_id) {
		this.num_zone_id = num_zone_id;
	}

	public String getStr_state_name() {
		return str_state_name;
	}

	public void setStr_state_name(String str_state_name) {
		this.str_state_name = str_state_name;
	}

	public String getStr_state_short_name() {
		return str_state_short_name;
	}

	public void setStr_state_short_name(String str_state_short_name) {
		this.str_state_short_name = str_state_short_name;
	}
}
