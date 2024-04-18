package in.cdacnoida.dava.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import in.cdacnoida.dava.model.TERTIARY;

@Entity
@Table
public class EXPORT_DETAILS {

	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	private Long lng_id;
	
	
	private String sscc;
	private String invoice_no;
	private String inv_date;
	private String countryOfExp;
	private String companyName;
	private String companyAddress;
	private String tertiaryCount;
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy = "exportDetails")
	private ConsignmentDetailsEntity consignmentDetailsEntity;
	
	@OneToMany(mappedBy="exportDetails")
	private List<TERTIRY_DETAILS> tertiaryDetails=new ArrayList<>();

	public Long getLng_id() {
		return lng_id;
	}

	public void setLng_id(Long lng_id) {
		this.lng_id = lng_id;
	}

	public String getSscc() {
		return sscc;
	}

	public void setSscc(String sscc) {
		this.sscc = sscc;
	}

	public String getInvoice_no() {
		return invoice_no;
	}

	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}

	public String getInv_date() {
		return inv_date;
	}

	public void setInv_date(String inv_date) {
		this.inv_date = inv_date;
	}

	public String getCountryOfExp() {
		return countryOfExp;
	}

	public void setCountryOfExp(String countryOfExp) {
		this.countryOfExp = countryOfExp;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getTertiaryCount() {
		return tertiaryCount;
	}

	public void setTertiaryCount(String tertiaryCount) {
		this.tertiaryCount = tertiaryCount;
	}

	public ConsignmentDetailsEntity getConsignmentDetailsEntity() {
		return consignmentDetailsEntity;
	}

	public void setConsignmentDetailsEntity(ConsignmentDetailsEntity consignmentDetailsEntity) {
		this.consignmentDetailsEntity = consignmentDetailsEntity;
	}

	public List<TERTIRY_DETAILS> getTertiaryDetails() {
		return tertiaryDetails;
	}

	public void addTertiaryDetails(TERTIRY_DETAILS tertiaryDetails) {
		this.tertiaryDetails.add(tertiaryDetails);
	}

}
