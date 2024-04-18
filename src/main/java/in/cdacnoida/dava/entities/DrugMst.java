package in.cdacnoida.dava.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@NamedQuery(name ="checkdupDrug", query = "SELECT I from DrugMst I where I.strBrandName=?1 and I.strGenericName=?2 and I.numIsValid =1")
//@Entity
//@Table(name="drug_mst")
public class DrugMst extends TransactionInfoDomain implements Serializable{

private static final long serialVersionUID = -6048595144903121228L;
	
	@Id
	@Column(name="num_drug_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generator")
	@TableGenerator(name="generator", initialValue=1000, allocationSize=1)
	Integer numDrugId; 
	
	@Column(name="num_inst_id")
	Integer numInstId;
	
	@Column(name="num_dosage_form")
	Integer numDosageForm;
	
	@Column(name="str_brand_name")
	String strBrandName;
	
	@Column(name="str_generic_name")
	String strGenericName;
	
	@Column(name="num_drug_type")
	Integer numDrugType;
	
	@Column(name="num_schedule_id")
	Integer numScheduleId;
	
	@Column(name="str_strength")
	String strStrength;
	
	@Column(name="num_pack_unit")
	Integer numPackUnit;
	
	@Column(name="str_pack_size")
	String strPackSize;
	
	@Column(name="num_pharmacopial_classification")
	Integer numPharmacopialClassification;
	
	@Column(name="num_status")
	Integer numStatus;
	
	@Column(name="str_storage_condition")
	String strStorageCondition;
	
	@Column(name="str_composition")
	String strComposition;
	
	@Column(name="str_product_code")
	String strProductCode;
	
	@Column(name="str_remarks")
	String strRemarks;
	
	@Column(name="num_manu_unit_id")
	Integer numManuUnitId;
	
	@Column(name="num_hs_code")
	Long numHSCode;
	
	@Column(name="num_storage_condition")
	Integer numStorageCondition;
	
	@Column(name="num_threpuetic_class")
	Integer numThrepueticClass;
	
	@Column(name="num_document_id")
	Integer numDocumentId;
	
	@Column(name="str_manufacturing_unit")
	String strManufacturingUnit;
	
	@Column(name="str_therepuetic_class")
	String strTherepueticClass;
	
	@Column(name="str_gtin_no")
	String strGtinNo;
	
	@Column(name="str_drug_code")
	String drugCode;
	
	@Column(name="num_pack_level")
	Integer numPackLevel;
	
	@Column(name="str_primary_gtin")
	String strPrimaryGTIN;
	
	@Column(name="str_s1_gtin")
	String strS1GTIN;
	
	@Column(name="str_s2_gtin")
	String strS2GTIN;
	
	@Column(name="str_s3_gtin")
	String strS3GTIN;
	
	@Column(name="str_tertiary_gtin")
	String strTertiaryGTIN;

	public int getNumDrugId() {
		return numDrugId;
	}

	public void setNumDrugId(int numDrugId) {
		this.numDrugId = numDrugId;
	}

	public int getNumInstId() {
		return numInstId;
	}

	public void setNumInstId(int numInstId) {
		this.numInstId = numInstId;
	}

	public int getNumDosageForm() {
		return numDosageForm;
	}

	public void setNumDosageForm(int numDosageForm) {
		this.numDosageForm = numDosageForm;
	}

	public String getStrBrandName() {
		return strBrandName;
	}

	public void setStrBrandName(String strBrandName) {
		this.strBrandName = strBrandName;
	}

	public String getStrGenericName() {
		return strGenericName;
	}

	public void setStrGenericName(String strGenericName) {
		this.strGenericName = strGenericName;
	}

	public int getNumDrugType() {
		return numDrugType;
	}

	public void setNumDrugType(int numDrugType) {
		this.numDrugType = numDrugType;
	}

	public int getNumScheduleId() {
		return numScheduleId;
	}

	public void setNumScheduleId(int numScheduleId) {
		this.numScheduleId = numScheduleId;
	}

	public String getStrStrength() {
		return strStrength;
	}

	public void setStrStrength(String strStrength) {
		this.strStrength = strStrength;
	}

	public int getNumPackUnit() {
		return numPackUnit;
	}

	public void setNumPackUnit(int numPackUnit) {
		this.numPackUnit = numPackUnit;
	}

	public String getStrPackSize() {
		return strPackSize;
	}

	public void setStrPackSize(String strPackSize) {
		this.strPackSize = strPackSize;
	}

	public int getNumPharmacopialClassification() {
		return numPharmacopialClassification;
	}

	public void setNumPharmacopialClassification(int numPharmacopialClassification) {
		this.numPharmacopialClassification = numPharmacopialClassification;
	}

	public int getNumStatus() {
		return numStatus;
	}

	public void setNumStatus(int numStatus) {
		this.numStatus = numStatus;
	}

	public String getStrStorageCondition() {
		return strStorageCondition;
	}

	public void setStrStorageCondition(String strStorageCondition) {
		this.strStorageCondition = strStorageCondition;
	}

	public String getStrComposition() {
		return strComposition;
	}

	public void setStrComposition(String strComposition) {
		this.strComposition = strComposition;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	public int getNumManuUnitId() {
		return numManuUnitId;
	}

	public void setNumManuUnitId(int numManuUnitId) {
		this.numManuUnitId = numManuUnitId;
	}

	

	public Long getNumHSCode() {
		return numHSCode;
	}

	public void setNumHSCode(Long numHSCode) {
		this.numHSCode = numHSCode;
	}

	public int getNumStorageCondition() {
		return numStorageCondition;
	}

	public void setNumStorageCondition(int numStorageCondition) {
		this.numStorageCondition = numStorageCondition;
	}

	public Integer getNumThrepueticClass() {
		return numThrepueticClass;
	}

	public void setNumThrepueticClass(Integer numThrepueticClass) {
		this.numThrepueticClass = numThrepueticClass;
	}

	public String getStrProductCode() {
		return strProductCode;
	}

	public void setStrProductCode(String strProductCode) {
		this.strProductCode = strProductCode;
	}

	public int getNumDocumentId() {
		return numDocumentId;
	}

	public void setNumDocumentId(int numDocumentId) {
		this.numDocumentId = numDocumentId;
	}

	public String getStrManufacturingUnit() {
		return strManufacturingUnit;
	}

	public void setStrManufacturingUnit(String strManufacturingUnit) {
		this.strManufacturingUnit = strManufacturingUnit;
	}

	public String getStrTherepueticClass() {
		return strTherepueticClass;
	}

	public void setStrTherepueticClass(String strTherepueticClass) {
		this.strTherepueticClass = strTherepueticClass;
	}

	public String getStrGtinNo() {
		return strGtinNo;
	}

	public void setStrGtinNo(String strGtinNo) {
		this.strGtinNo = strGtinNo;
	}

	public String getDrugCode() {
		return drugCode;
	}

	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}

	public Integer getNumPackLevel() {
		return numPackLevel;
	}

	public void setNumPackLevel(Integer numPackLevel) {
		this.numPackLevel = numPackLevel;
	}

	public String getStrPrimaryGTIN() {
		return strPrimaryGTIN;
	}

	public void setStrPrimaryGTIN(String strPrimaryGTIN) {
		this.strPrimaryGTIN = strPrimaryGTIN;
	}

	public String getStrS1GTIN() {
		return strS1GTIN;
	}

	public void setStrS1GTIN(String strS1GTIN) {
		this.strS1GTIN = strS1GTIN;
	}

	public String getStrS2GTIN() {
		return strS2GTIN;
	}

	public void setStrS2GTIN(String strS2GTIN) {
		this.strS2GTIN = strS2GTIN;
	}

	public String getStrS3GTIN() {
		return strS3GTIN;
	}

	public void setStrS3GTIN(String strS3GTIN) {
		this.strS3GTIN = strS3GTIN;
	}

	public String getStrTertiaryGTIN() {
		return strTertiaryGTIN;
	}

	public void setStrTertiaryGTIN(String strTertiaryGTIN) {
		this.strTertiaryGTIN = strTertiaryGTIN;
	}
	
}
