package in.cdacnoida.dava.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import in.cdacnoida.dava.misc.ValidationGroups.DrugDetails;
import in.cdacnoida.dava.misc.ValidationGroups.LocationMaster;

public class DrugDtlsModel {
	
	int drugId;
	@NotNull(message="Drug Type is required and cannot be empty", groups={DrugDetails.class})
	int drugType;
	@NotEmpty(message="This Generic name is required and cannot be empty", groups={DrugDetails.class})
	@Size(min=1, max=200,message="This Generic Name can contain maximum of 200 characters", groups={DrugDetails.class})
	//@Pattern(regexp="^[a-zA-Z0-9.,\\-\\/\\s +&()]+$",message="Generic Name can consist of alphabets, numbers and special characters( /,()-.+&) and white spaces are permitted",groups={DrugDetails.class})
	String genericName;
	//@NotEmpty(message="This Brand name is required and cannot be empty", groups={DrugDetails.class})
	//@Size(min=1, max=20,message="This Brand Name can contain maximum of 20 characters", groups={DrugDetails.class})
	//@Pattern(regexp="^[a-zA-Z0-9.,\\-\\/\\s +&()]+$",message="Brand Name can consist of alphabets, numbers and special characters( /,()-.+&) and white spaces are permitted",groups={DrugDetails.class})
	String brandName;
	//@NotNull(message="Dosage Form is required and cannot be empty", groups={DrugDetails.class})
	int dosageForm;
	//@NotNull(message="Classification of Drug is required and cannot be empty", groups={DrugDetails.class})
	int classificationDrug;
	
	int scheduleDrug;
	//@NotEmpty(message="Strength is required and cannot be empty", groups={DrugDetails.class})
	//@Size(min=1, max=20,message="Strength can contain maximum of 20 characters", groups={DrugDetails.class})
	//@Pattern(regexp="^[a-zA-Z0-9.,\\-\\/\\s +&()]+$",message="Strength can consist of alphabets, numbers and special characters( /,()-.+&) and white spaces are permitted",groups={DrugDetails.class})
	String strength;
	
	String storageCon;
	//@NotEmpty(message="Composition is required and cannot be empty", groups={DrugDetails.class})
	//@Size(min=1, max=200,message="Composition can contain maximum of 200 characters", groups={DrugDetails.class})
	//@Pattern(regexp="^[a-zA-Z0-9.,\\-\\/\\s +&()]+$",message="Composition can consist of alphabets, numbers and special characters( /,()-.+&) and white spaces are permitted",groups={DrugDetails.class})
	String composition;
	
	String packSize;
	
	int packUnit;
	//@NotNull(message="This Manufacturing Unit is required and cannot be empty", groups={DrugDetails.class})
	int manuUnit;
	
	int[] radio;
	//@NotNull(message="HS Code is required and cannot be empty", groups={DrugDetails.class})
	int hsCode;
	
	int numStorageCondition;
	
	int hsCodeFF;
	
	int numStorageConditionFF;
	
	int therapeuticClass;
	
	List<String> listManufacturingUnit;
	
	String therepueticClassOfDrug;
	
	String gtin;
	
	Integer packLevel;
	
	String pLevelGTIN;
	String s1LevelGTIN;
	String s2LevelGTIN;
	String s3LevelGTIN;
	String tertiryLevelGTIN;
	
	List<String> list_pLevelGTIN ;
	List<String> list_s1LevelGTIN ;
	List<String> list_s2LevelGTIN ;
	List<String> list_s3LevelGTIN ;
	List<String> List_tertiryLevelGTIN ;

	public int getDrugId() {
		return drugId;
	}

	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}

	public int getDrugType() {
		return drugType;
	}

	public void setDrugType(int drugType) {
		this.drugType = drugType;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getDosageForm() {
		return dosageForm;
	}

	public void setDosageForm(int dosageForm) {
		this.dosageForm = dosageForm;
	}

	public int getClassificationDrug() {
		return classificationDrug;
	}

	public void setClassificationDrug(int classificationDrug) {
		this.classificationDrug = classificationDrug;
	}

	public int getScheduleDrug() {
		return scheduleDrug;
	}

	public void setScheduleDrug(int scheduleDrug) {
		this.scheduleDrug = scheduleDrug;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public String getStorageCon() {
		return storageCon;
	}

	public void setStorageCon(String storageCon) {
		this.storageCon = storageCon;
	}

	public String getComposition() {
		return composition;
	}

	public void setComposition(String composition) {
		this.composition = composition;
	}

	public String getPackSize() {
		return packSize;
	}

	public void setPackSize(String packSize) {
		this.packSize = packSize;
	}

	public int getPackUnit() {
		return packUnit;
	}

	public void setPackUnit(int packUnit) {
		this.packUnit = packUnit;
	}

	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	public int getManuUnit() {
		return manuUnit;
	}

	public void setManuUnit(int manuUnit) {
		this.manuUnit = manuUnit;
	}

	public int[] getRadio() {
		return radio;
	}

	public void setRadio(int[] radio) {
		this.radio = radio;
	}

	public int getHsCode() {
		return hsCode;
	}

	public void setHsCode(int hsCode) {
		this.hsCode = hsCode;
	}

	public int getNumStorageCondition() {
		return numStorageCondition;
	}

	public void setNumStorageCondition(int numStorageCondition) {
		this.numStorageCondition = numStorageCondition;
	}

	public int getTherapeuticClass() {
		return therapeuticClass;
	}

	public void setTherapeuticClass(int therapeuticClass) {
		this.therapeuticClass = therapeuticClass;
	}

	public List<String> getListManufacturingUnit() {
		return listManufacturingUnit;
	}

	public void setListManufacturingUnit(List<String> listManufacturingUnit) {
		this.listManufacturingUnit = listManufacturingUnit;
	}

	public String getTherepueticClassOfDrug() {
		return therepueticClassOfDrug;
	}

	public void setTherepueticClassOfDrug(String therepueticClassOfDrug) {
		this.therepueticClassOfDrug = therepueticClassOfDrug;
	}

	public String getGtin() {
		return gtin;
	}

	public void setGtin(String gtin) {
		this.gtin = gtin;
	}

	public int getHsCodeFF() {
		return hsCodeFF;
	}

	public void setHsCodeFF(int hsCodeFF) {
		this.hsCodeFF = hsCodeFF;
	}

	public int getNumStorageConditionFF() {
		return numStorageConditionFF;
	}

	public void setNumStorageConditionFF(int numStorageConditionFF) {
		this.numStorageConditionFF = numStorageConditionFF;
	}

	public Integer getPackLevel() {
		return packLevel;
	}

	public void setPackLevel(Integer packLevel) {
		this.packLevel = packLevel;
	}

	public String getpLevelGTIN() {
		return pLevelGTIN;
	}

	public void setpLevelGTIN(String pLevelGTIN) {
		this.pLevelGTIN = pLevelGTIN;
	}

	public String getS1LevelGTIN() {
		return s1LevelGTIN;
	}

	public void setS1LevelGTIN(String s1LevelGTIN) {
		this.s1LevelGTIN = s1LevelGTIN;
	}

	public String getS2LevelGTIN() {
		return s2LevelGTIN;
	}

	public void setS2LevelGTIN(String s2LevelGTIN) {
		this.s2LevelGTIN = s2LevelGTIN;
	}

	public String getS3LevelGTIN() {
		return s3LevelGTIN;
	}

	public void setS3LevelGTIN(String s3LevelGTIN) {
		this.s3LevelGTIN = s3LevelGTIN;
	}

	public String getTertiryLevelGTIN() {
		return tertiryLevelGTIN;
	}

	public void setTertiryLevelGTIN(String tertiryLevelGTIN) {
		this.tertiryLevelGTIN = tertiryLevelGTIN;
	}

	public List<String> getList_pLevelGTIN() {
		return list_pLevelGTIN;
	}

	public void setList_pLevelGTIN(List<String> list_pLevelGTIN) {
		this.list_pLevelGTIN = list_pLevelGTIN;
	}

	public List<String> getList_s1LevelGTIN() {
		return list_s1LevelGTIN;
	}

	public void setList_s1LevelGTIN(List<String> list_s1LevelGTIN) {
		this.list_s1LevelGTIN = list_s1LevelGTIN;
	}

	public List<String> getList_s2LevelGTIN() {
		return list_s2LevelGTIN;
	}

	public void setList_s2LevelGTIN(List<String> list_s2LevelGTIN) {
		this.list_s2LevelGTIN = list_s2LevelGTIN;
	}

	public List<String> getList_s3LevelGTIN() {
		return list_s3LevelGTIN;
	}

	public void setList_s3LevelGTIN(List<String> list_s3LevelGTIN) {
		this.list_s3LevelGTIN = list_s3LevelGTIN;
	}

	public List<String> getList_tertiryLevelGTIN() {
		return List_tertiryLevelGTIN;
	}

	public void setList_tertiryLevelGTIN(List<String> list_tertiryLevelGTIN) {
		List_tertiryLevelGTIN = list_tertiryLevelGTIN;
	}
	
	
}
