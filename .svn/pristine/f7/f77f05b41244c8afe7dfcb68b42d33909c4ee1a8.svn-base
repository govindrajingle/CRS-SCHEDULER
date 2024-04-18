package in.cdacnoida.dava.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table
public class ProductDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	private Long lng_id;
	
	private String str_ProductName;
	private String str_pack_size;
	private String str_prodCode;
	private String str_batch_number;
	private Date date_expiry_date;
	private String str_procurement_source_name;
	private String str_procurement_source_address;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private SECONDARY1_DETAILS secondary1Details;

	public Long getLng_id() {
		return lng_id;
	}

	public void setLng_id(Long lng_id) {
		this.lng_id = lng_id;
	}

	public String getStr_ProductName() {
		return str_ProductName;
	}

	public void setStr_ProductName(String str_ProductName) {
		this.str_ProductName = str_ProductName;
	}

	public String getStr_pack_size() {
		return str_pack_size;
	}

	public void setStr_pack_size(String str_pack_size) {
		this.str_pack_size = str_pack_size;
	}

	public String getStr_prodCode() {
		return str_prodCode;
	}

	public void setStr_prodCode(String str_prodCode) {
		this.str_prodCode = str_prodCode;
	}

	public String getStr_batch_number() {
		return str_batch_number;
	}

	public void setStr_batch_number(String str_batch_number) {
		this.str_batch_number = str_batch_number;
	}

	public Date getDate_expiry_date() {
		return date_expiry_date;
	}

	public void setDate_expiry_date(Date date_expiry_date) {
		this.date_expiry_date = date_expiry_date;
	}

	public String getStr_procurement_source_name() {
		return str_procurement_source_name;
	}

	public void setStr_procurement_source_name(String str_procurement_source_name) {
		this.str_procurement_source_name = str_procurement_source_name;
	}

	public String getStr_procurement_source_address() {
		return str_procurement_source_address;
	}

	public void setStr_procurement_source_address(String str_procurement_source_address) {
		this.str_procurement_source_address = str_procurement_source_address;
	}

	public SECONDARY1_DETAILS getSecondary1Details() {
		return secondary1Details;
	}

	public void setSecondary1Details(SECONDARY1_DETAILS secondary1Details) {
		this.secondary1Details = secondary1Details;
	}
	
	
	
}
