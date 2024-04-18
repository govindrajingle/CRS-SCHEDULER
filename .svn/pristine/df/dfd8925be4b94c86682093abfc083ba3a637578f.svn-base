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
public class TERTIRY_DETAILS {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	private Long lng_id;
	
	
	private String str_tertiaryType;
	private String str_ProductCount;
	private String str_secondary3Count;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private EXPORT_DETAILS exportDetails;
	
	@OneToMany(mappedBy = "tertiaryDetails")
	private List<SECONDARY3_DETAILS> secondary3=new ArrayList<>();

	public Long getLng_id() {
		return lng_id;
	}

	public void setLng_id(Long lng_id) {
		this.lng_id = lng_id;
	}

	public String getStr_tertiaryType() {
		return str_tertiaryType;
	}

	public void setStr_tertiaryType(String str_tertiaryType) {
		this.str_tertiaryType = str_tertiaryType;
	}

	public String getStr_ProductCount() {
		return str_ProductCount;
	}

	public void setStr_ProductCount(String str_ProductCount) {
		this.str_ProductCount = str_ProductCount;
	}

	public String getStr_secondary3Count() {
		return str_secondary3Count;
	}

	public void setStr_secondary3Count(String str_secondary3Count) {
		this.str_secondary3Count = str_secondary3Count;
	}

	public EXPORT_DETAILS getExportDetails() {
		return exportDetails;
	}

	public void setExportDetails(EXPORT_DETAILS exportDetails) {
		this.exportDetails = exportDetails;
	}

	public List<SECONDARY3_DETAILS> getSecondary3() {
		return secondary3;
	}

	public void setSecondary3(SECONDARY3_DETAILS secondary3) {
		this.secondary3.add(secondary3);
	}
	
	
	
}
