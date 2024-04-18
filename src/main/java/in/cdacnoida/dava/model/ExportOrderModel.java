package in.cdacnoida.dava.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

public class ExportOrderModel {
	

	private Integer exp_id;
	
	//@NotNull(message="Invoice Number cannot not be null or empty")
	@NotEmpty(message="Exporting Country Address cannot not be null or empty")
	@Pattern(message="Exporting Country Address does not match required structure",regexp="^[a-zA-Z0-9.,\\-\\/\\s +&()]+$")
	private String invoice_no;
	
	@NotNull(message="Invoice date cannot not be null or empty")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date invoice_date;
	
	@NotNull(message="Product id cannot not be null or empty")
	@Pattern(message="Product id does not match to the required structure", regexp="^[0-9]+$")
	private String productId;
	
	@Pattern(message="Product Name does not match to the required structure", 
			regexp="^[a-zA-Z0-9().\\/,\\s\\-]+$")
	private String productName;
	
	private String genericName;
	
	@NotNull(message="exporting region cannot not be null or empty")
	private Integer exportingRegion;
	
	@NotNull(message="exporting country cannot not be null or empty")
	private String country_id;
	
	private String ExportingCountryName;
	
	
	@NotEmpty(message="Exporting Country Address cannot not be null or empty")
	@Pattern(message="Exporting Country Address does not match required structure",
	regexp="^[a-zA-Z0-9.,\\-\\/\\s +&()]+$")
	private String ExportingCountryAddress;
	
	@NotNull(message="Contact cannot not be null or empty")
	@Pattern(message="Contact does not match to the required structure", regexp="^[0-9]+$")
	private String ExportingCountryContact;
	
	
	private String productSourceName;
	private String productSourceAddress;
	public Integer getExp_id() {
		return exp_id;
	}
	public void setExp_id(Integer exp_id) {
		this.exp_id = exp_id;
	}
	public String getInvoice_no() {
		return invoice_no;
	}
	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}
	public Date getInvoice_date() {
		return invoice_date;
	}
	public void setInvoice_date(Date invoice_date) {
		this.invoice_date = invoice_date;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getGenericName() {
		return genericName;
	}
	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}
	public Integer getExportingRegion() {
		return exportingRegion;
	}
	public void setExportingRegion(Integer exportingRegion) {
		this.exportingRegion = exportingRegion;
	}
	public String getCountry_id() {
		return country_id;
	}
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}
	public String getExportingCountryName() {
		return ExportingCountryName;
	}
	public void setExportingCountryName(String exportingCountryName) {
		ExportingCountryName = exportingCountryName;
	}
	public String getExportingCountryAddress() {
		return ExportingCountryAddress;
	}
	public void setExportingCountryAddress(String exportingCountryAddress) {
		ExportingCountryAddress = exportingCountryAddress;
	}
	public String getExportingCountryContact() {
		return ExportingCountryContact;
	}
	public void setExportingCountryContact(String exportingCountryContact) {
		ExportingCountryContact = exportingCountryContact;
	}
	public String getProductSourceName() {
		return productSourceName;
	}
	public void setProductSourceName(String productSourceName) {
		this.productSourceName = productSourceName;
	}
	public String getProductSourceAddress() {
		return productSourceAddress;
	}
	public void setProductSourceAddress(String productSourceAddress) {
		this.productSourceAddress = productSourceAddress;
	}
	
	
	

}
