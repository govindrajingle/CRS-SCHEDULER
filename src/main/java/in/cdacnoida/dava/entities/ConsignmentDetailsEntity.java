package in.cdacnoida.dava.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table
public class ConsignmentDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	private Long lng_id;
	
	private String str_sender_manufacturer_code;
	private String str_filename;
	private Date file_date;
	private String str_file_time;
	private String str_serialization_type;
	
	@OneToOne(fetch = FetchType.LAZY)
	private EXPORT_DETAILS exportDetails;
	
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy = "consignmentDetailsEntity")
	private EXP_TERTIARY_LIST_DETAILS exp_tertiary_list_details;


	public Long getLng_id() {
		return lng_id;
	}


	public void setLng_id(Long lng_id) {
		this.lng_id = lng_id;
	}


	public String getStr_sender_manufacturer_code() {
		return str_sender_manufacturer_code;
	}


	public void setStr_sender_manufacturer_code(String str_sender_manufacturer_code) {
		this.str_sender_manufacturer_code = str_sender_manufacturer_code;
	}


	public String getStr_filename() {
		return str_filename;
	}


	public void setStr_filename(String str_filename) {
		this.str_filename = str_filename;
	}


	public Date getFile_date() {
		return file_date;
	}


	public void setFile_date(Date file_date) {
		this.file_date = file_date;
	}


	public String getStr_file_time() {
		return str_file_time;
	}


	public void setStr_file_time(String str_file_time) {
		this.str_file_time = str_file_time;
	}


	public String getStr_serialization_type() {
		return str_serialization_type;
	}


	public void setStr_serialization_type(String str_serialization_type) {
		this.str_serialization_type = str_serialization_type;
	}


	public EXPORT_DETAILS getExportDetails() {
		return exportDetails;
	}


	public void setExportDetails(EXPORT_DETAILS exportDetails) {
		this.exportDetails = exportDetails;
	}


	public EXP_TERTIARY_LIST_DETAILS getExp_tertiary_list_details() {
		return exp_tertiary_list_details;
	}


	public void setExp_tertiary_list_details(EXP_TERTIARY_LIST_DETAILS exp_tertiary_list_details) {
		this.exp_tertiary_list_details = exp_tertiary_list_details;
	}

}
