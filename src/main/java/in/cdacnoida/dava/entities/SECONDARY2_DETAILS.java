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
public class SECONDARY2_DETAILS {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	private Long lng_id;
	
	private String str_secondary2Type;
	private String str_code_SNoSecondary2;
	private String str_secondary1Count;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private SECONDARY3_DETAILS secondary3Details;
	
	@OneToMany(mappedBy = "secondary2Details")
	private List<SECONDARY1_DETAILS> secondary1=new ArrayList<>();

	public Long getLng_id() {
		return lng_id;
	}

	public void setLng_id(Long lng_id) {
		this.lng_id = lng_id;
	}

	public String getStr_secondary2Type() {
		return str_secondary2Type;
	}

	public void setStr_secondary2Type(String str_secondary2Type) {
		this.str_secondary2Type = str_secondary2Type;
	}

	public String getStr_code_SNoSecondary2() {
		return str_code_SNoSecondary2;
	}

	public void setStr_code_SNoSecondary2(String str_code_SNoSecondary2) {
		this.str_code_SNoSecondary2 = str_code_SNoSecondary2;
	}

	public String getStr_secondary1Count() {
		return str_secondary1Count;
	}

	public void setStr_secondary1Count(String str_secondary1Count) {
		this.str_secondary1Count = str_secondary1Count;
	}

	public void setSecondary1(List<SECONDARY1_DETAILS> secondary1) {
		this.secondary1 = secondary1;
	}

	public SECONDARY3_DETAILS getSecondary3Details() {
		return secondary3Details;
	}

	public void setSecondary3Details(SECONDARY3_DETAILS secondary3Details) {
		this.secondary3Details = secondary3Details;
	}

	public List<SECONDARY1_DETAILS> getSecondary1() {
		return secondary1;
	}

	public void setSecondary1(SECONDARY1_DETAILS secondary1) {
		this.secondary1.add(secondary1);
	}

}
