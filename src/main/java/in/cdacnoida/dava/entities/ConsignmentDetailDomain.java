package in.cdacnoida.dava.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



//@Entity
@Table(name = "consignment_dtl")
public class ConsignmentDetailDomain extends TransactionInfoDomain implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	private Integer num_packaging_id;
	
	private Integer num_premise_no;
	private Integer num_inst_id;
	private String num_sender_manuf_code;
	private String str_file_name;
	private Date dt_file_date;
	private String str_serialization_type;
	private String str_sscc;
	private String str_invoice_no;
	private Date dt_invoice_date;
	private String str_exp_country;
	private String str_company_name;
	private String str_company_add;
	private String num_tertiary_count;
	private String str_tertiary_type;
	private String num_prod_count;
	private String num_s3_count;
	private String str_s3_type;
	private String str_s3_sno;
	private String num_s2_count;
	private String str_s2_type;
	private String str_s2_sno;
	private String num_s1_count;
	private String str_s1_type;
	private String str_s1_sno;
	private String str_prod_name;
	private String str_pack_size;
	private String str_prod_code;
	private String str_batch_no;
	private String str_source_name;
	private String str_source_add;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	private LocalDateTime createdDate;

	public Integer getNum_packaging_id() {
		return num_packaging_id;
	}

	public void setNum_packaging_id(Integer num_packaging_id) {
		this.num_packaging_id = num_packaging_id;
	}

	public Integer getNum_premise_no() {
		return num_premise_no;
	}

	public void setNum_premise_no(Integer num_premise_no) {
		this.num_premise_no = num_premise_no;
	}

	public Integer getNum_inst_id() {
		return num_inst_id;
	}

	public void setNum_inst_id(Integer num_inst_id) {
		this.num_inst_id = num_inst_id;
	}

	public String getNum_sender_manuf_code() {
		return num_sender_manuf_code;
	}

	public void setNum_sender_manuf_code(String num_sender_manuf_code) {
		this.num_sender_manuf_code = num_sender_manuf_code;
	}

	public String getStr_file_name() {
		return str_file_name;
	}

	public void setStr_file_name(String str_file_name) {
		this.str_file_name = str_file_name;
	}

	public Date getDt_file_date() {
		return dt_file_date;
	}

	public void setDt_file_date(Date dt_file_date) {
		this.dt_file_date = dt_file_date;
	}

	public String getStr_serialization_type() {
		return str_serialization_type;
	}

	public void setStr_serialization_type(String str_serialization_type) {
		this.str_serialization_type = str_serialization_type;
	}

	public String getStr_sscc() {
		return str_sscc;
	}

	public void setStr_sscc(String str_sscc) {
		this.str_sscc = str_sscc;
	}

	public String getStr_invoice_no() {
		return str_invoice_no;
	}

	public void setStr_invoice_no(String str_invoice_no) {
		this.str_invoice_no = str_invoice_no;
	}

	public Date getDt_invoice_date() {
		return dt_invoice_date;
	}

	public void setDt_invoice_date(Date dt_invoice_date) {
		this.dt_invoice_date = dt_invoice_date;
	}

	public String getStr_exp_country() {
		return str_exp_country;
	}

	public void setStr_exp_country(String str_exp_country) {
		this.str_exp_country = str_exp_country;
	}

	public String getStr_company_name() {
		return str_company_name;
	}

	public void setStr_company_name(String str_company_name) {
		this.str_company_name = str_company_name;
	}

	public String getStr_company_add() {
		return str_company_add;
	}

	public void setStr_company_add(String str_company_add) {
		this.str_company_add = str_company_add;
	}

	public String getNum_tertiary_count() {
		return num_tertiary_count;
	}

	public void setNum_tertiary_count(String num_tertiary_count) {
		this.num_tertiary_count = num_tertiary_count;
	}

	public String getStr_tertiary_type() {
		return str_tertiary_type;
	}

	public void setStr_tertiary_type(String str_tertiary_type) {
		this.str_tertiary_type = str_tertiary_type;
	}

	public String getNum_prod_count() {
		return num_prod_count;
	}

	public void setNum_prod_count(String num_prod_count) {
		this.num_prod_count = num_prod_count;
	}

	public String getNum_s3_count() {
		return num_s3_count;
	}

	public void setNum_s3_count(String num_s3_count) {
		this.num_s3_count = num_s3_count;
	}

	public String getStr_s3_type() {
		return str_s3_type;
	}

	public void setStr_s3_type(String str_s3_type) {
		this.str_s3_type = str_s3_type;
	}

	public String getStr_s3_sno() {
		return str_s3_sno;
	}

	public void setStr_s3_sno(String str_s3_sno) {
		this.str_s3_sno = str_s3_sno;
	}

	public String getNum_s2_count() {
		return num_s2_count;
	}

	public void setNum_s2_count(String num_s2_count) {
		this.num_s2_count = num_s2_count;
	}

	public String getStr_s2_type() {
		return str_s2_type;
	}

	public void setStr_s2_type(String str_s2_type) {
		this.str_s2_type = str_s2_type;
	}

	public String getStr_s2_sno() {
		return str_s2_sno;
	}

	public void setStr_s2_sno(String str_s2_sno) {
		this.str_s2_sno = str_s2_sno;
	}

	public String getNum_s1_count() {
		return num_s1_count;
	}

	public void setNum_s1_count(String num_s1_count) {
		this.num_s1_count = num_s1_count;
	}

	public String getStr_s1_type() {
		return str_s1_type;
	}

	public void setStr_s1_type(String str_s1_type) {
		this.str_s1_type = str_s1_type;
	}

	public String getStr_s1_sno() {
		return str_s1_sno;
	}

	public void setStr_s1_sno(String str_s1_sno) {
		this.str_s1_sno = str_s1_sno;
	}

	public String getStr_prod_name() {
		return str_prod_name;
	}

	public void setStr_prod_name(String str_prod_name) {
		this.str_prod_name = str_prod_name;
	}

	public String getStr_pack_size() {
		return str_pack_size;
	}

	public void setStr_pack_size(String str_pack_size) {
		this.str_pack_size = str_pack_size;
	}

	public String getStr_prod_code() {
		return str_prod_code;
	}

	public void setStr_prod_code(String str_prod_code) {
		this.str_prod_code = str_prod_code;
	}

	public String getStr_batch_no() {
		return str_batch_no;
	}

	public void setStr_batch_no(String str_batch_no) {
		this.str_batch_no = str_batch_no;
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

	public String getStr_source_name() {
		return str_source_name;
	}

	public void setStr_source_name(String str_source_name) {
		this.str_source_name = str_source_name;
	}

	public String getStr_source_add() {
		return str_source_add;
	}

	public void setStr_source_add(String str_source_add) {
		this.str_source_add = str_source_add;
	}
}
