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
@Table(name="country_mst")
public class CountryMst implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	private Integer num_country_id;
	
	@Column(name="num_isvalid")
	private Integer num_isvalid;
	
	@Column(name="str_country_name")
	private String str_country_name;

	public Integer getNum_country_id() {
		return num_country_id;
	}

	public void setNum_country_id(Integer num_country_id) {
		this.num_country_id = num_country_id;
	}

	public Integer getNum_isvalid() {
		return num_isvalid;
	}

	public void setNum_isvalid(Integer num_isvalid) {
		this.num_isvalid = num_isvalid;
	}

	public String getStr_country_name() {
		return str_country_name;
	}

	public void setStr_country_name(String str_country_name) {
		this.str_country_name = str_country_name;
	}
	
	
	
}
