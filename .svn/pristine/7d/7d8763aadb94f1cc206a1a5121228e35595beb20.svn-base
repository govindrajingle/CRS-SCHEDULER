package in.cdacnoida.dava.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="statistics_data")
public class StaticsDataDomain implements Serializable{
	
	private static final long serialVersionUID = -6048595144903121228L;
	
	@Id
	@Column(name="num_statistics_data_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1000, allocationSize=1)
	int numStatisticsDataId; 

	@Column(name="num_reg_manuf")
	Integer numRegManuf;
	
	@Column(name="num_reg_exp")
	Integer numRegExp;
	
	@Column(name="num_data_manuf")
	Integer numDataManuf;
	
	@Column(name="num_data_exp")
	Integer numDataExp;
	
	@Column(name="num_exp_ch29_cuntry")
	Integer numExpCh29Country;
	
	@Column(name="num_exp_ch30_cuntry")
	Integer numExpCh30Country;
	
	@Column(name="num_exp_ch29")
	Integer numExpCh29Data;
	
	@Column(name="num_exp_ch30")
	Integer numExpCh30Data;

	public Integer getNumRegManuf() {
		return numRegManuf;
	}

	public void setNumRegManuf(Integer numRegManuf) {
		this.numRegManuf = numRegManuf;
	}

	public Integer getNumRegExp() {
		return numRegExp;
	}

	public void setNumRegExp(Integer numRegExp) {
		this.numRegExp = numRegExp;
	}

	public Integer getNumDataManuf() {
		return numDataManuf;
	}

	public void setNumDataManuf(Integer numDataManuf) {
		this.numDataManuf = numDataManuf;
	}

	public Integer getNumDataExp() {
		return numDataExp;
	}

	public void setNumDataExp(Integer numDataExp) {
		this.numDataExp = numDataExp;
	}

	public Integer getNumExpCh29Country() {
		return numExpCh29Country;
	}

	public void setNumExpCh29Country(Integer numExpCh29Country) {
		this.numExpCh29Country = numExpCh29Country;
	}

	public Integer getNumExpCh30Country() {
		return numExpCh30Country;
	}

	public void setNumExpCh30Country(Integer numExpCh30Country) {
		this.numExpCh30Country = numExpCh30Country;
	}

	public Integer getNumExpCh29Data() {
		return numExpCh29Data;
	}

	public void setNumExpCh29Data(Integer numExpCh29Data) {
		this.numExpCh29Data = numExpCh29Data;
	}

	public Integer getNumExpCh30Data() {
		return numExpCh30Data;
	}

	public void setNumExpCh30Data(Integer numExpCh30Data) {
		this.numExpCh30Data = numExpCh30Data;
	}
	
	
}
