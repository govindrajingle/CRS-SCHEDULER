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

import in.cdacnoida.dava.model.Product;

@Entity
@Table
public class SECONDARY1_DETAILS {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	private Long lng_id;
	
	
	private String str_secondary1Type;
	private String str_code_SNoSecondary1;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private SECONDARY2_DETAILS secondary2Details;
	
	@OneToMany(mappedBy = "secondary1Details")
	private List<ProductDetails> product=new ArrayList<>();

	public Long getLng_id() {
		return lng_id;
	}

	public void setLng_id(Long lng_id) {
		this.lng_id = lng_id;
	}

	public String getStr_secondary1Type() {
		return str_secondary1Type;
	}

	public void setStr_secondary1Type(String str_secondary1Type) {
		this.str_secondary1Type = str_secondary1Type;
	}

	public String getStr_code_SNoSecondary1() {
		return str_code_SNoSecondary1;
	}

	public void setStr_code_SNoSecondary1(String str_code_SNoSecondary1) {
		this.str_code_SNoSecondary1 = str_code_SNoSecondary1;
	}

	public SECONDARY2_DETAILS getSecondary2Details() {
		return secondary2Details;
	}

	public void setSecondary2Details(SECONDARY2_DETAILS secondary2Details) {
		this.secondary2Details = secondary2Details;
	}

	public List<ProductDetails> getProduct() {
		return product;
	}

	public void setProduct(ProductDetails product) {
		this.product.add(product);
	}
	
	
	
	
}
