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
//@Table(name = "newsEvent_type_mst")
public class NewsEventMstDomain extends TransactionInfoDomain implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "num_event_type_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	private Integer numEventTypeId;
	
	@Column(name="str_event_type_name")
	private String strEventTypeName;

	public Integer getNumEventTypeId() {
		return numEventTypeId;
	}

	public void setNumEventTypeId(Integer numEventTypeId) {
		this.numEventTypeId = numEventTypeId;
	}

	public String getStrEventTypeName() {
		return strEventTypeName;
	}

	public void setStrEventTypeName(String strEventTypeName) {
		this.strEventTypeName = strEventTypeName;
	}

	
}
