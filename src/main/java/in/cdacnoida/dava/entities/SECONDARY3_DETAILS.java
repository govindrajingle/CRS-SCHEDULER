package in.cdacnoida.dava.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table
public class SECONDARY3_DETAILS {

	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	private Long lng_id;
	
	private String str_secondary3Type;
	private String str_code_SNoSecondary3;
	private String str_secondary2Count;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private TERTIRY_DETAILS tertiaryDetails;
	
	@OneToMany(mappedBy = "secondary3Details")
	private List<SECONDARY2_DETAILS> secondary2=new ArrayList<>();

	public Long getLng_id() {
		return lng_id;
	}

	public void setLng_id(Long lng_id) {
		this.lng_id = lng_id;
	}

	public String getStr_secondary3Type() {
		return str_secondary3Type;
	}

	public void setStr_secondary3Type(String str_secondary3Type) {
		this.str_secondary3Type = str_secondary3Type;
	}

	public String getStr_code_SNoSecondary3() {
		return str_code_SNoSecondary3;
	}

	public void setStr_code_SNoSecondary3(String str_code_SNoSecondary3) {
		this.str_code_SNoSecondary3 = str_code_SNoSecondary3;
	}

	public String getStr_secondary2Count() {
		return str_secondary2Count;
	}

	public void setStr_secondary2Count(String str_secondary2Count) {
		this.str_secondary2Count = str_secondary2Count;
	}

	public TERTIRY_DETAILS getTertiaryDetails() {
		return tertiaryDetails;
	}

	public void setTertiaryDetails(TERTIRY_DETAILS tertiaryDetails) {
		this.tertiaryDetails = tertiaryDetails;
	}

	public List<SECONDARY2_DETAILS> getSecondary2() {
		return secondary2;
	}

	public void setSecondary2(SECONDARY2_DETAILS secondary2) {
		this.secondary2.add(secondary2);
	}
	
	
}
