package in.cdacnoida.dava.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

//@Entity
//@Table(name = "export_order_mst")
public class ExportOrderDomain extends TransactionInfoDomain implements Serializable {

	private static final long serialVersionUID = -6048595144903121228L;
	
	@Id
	@Column(name = "num_exp_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	private Integer exp_id;

	@Column(name="num_inst_id")
	int numInstId;
	
	@Column(name = "str_invoice_no")
	private String invoice_no;
	
	@Column(name = "dt_invoice_date")
	private Date invoice_date;
	
	 @Column(name = "str_product_id")
	 private  String productId;
	
	 @Column(name = "str_prodname")
	 private String productName;
	
	 @Column(name = "num_export_region_id")
	 private Integer exportingRegion;
	 
	 @Column(name = "str_country_id")
	 private String country_id;

	
	@Column(name = "str_exp_comp_name")
	private String ExportingCountryName;

	@Column(name = "str_exp_comp_add")
	private String ExportingCountryAddress;
	
	
	@Column(name = "str_exp_comp_contact")
	private String ExportingCountryContact;

	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	private LocalDateTime createdDate;

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


	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}


	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}


	public LocalDateTime getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}


	public int getNumInstId() {
		return numInstId;
	}


	public void setNumInstId(int numInstId) {
		this.numInstId = numInstId;
	}
	
	
	
}
