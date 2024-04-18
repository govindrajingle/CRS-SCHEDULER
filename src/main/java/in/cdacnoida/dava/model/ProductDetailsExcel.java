package in.cdacnoida.dava.model;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelRow;


public class ProductDetailsExcel {

	public ProductDetailsExcel() {
	}

	@ExcelRow
	private int rowIndex;

	@ExcelCell(0)
	private String FileName;

	@ExcelCell(1)
	private String ManufacturerCode;
	
	@ExcelCell(2)
	private String ManufacturingSiteCode;
	
	@ExcelCell(3)
	private String ProductType;
	
	
	@ExcelCell(4)
	private String ProductCode;
	
	@ExcelCell(5)
	private String ProductName;
	
	@ExcelCell(6)
	private String GenericName;
	
	@ExcelCell(7)
	private String Composition;
	
	@ExcelCell(8)
	private String Scheduled;
	
	@ExcelCell(9)
	private String Remark;
	
	@ExcelCell(10)
	private String StorageCondition;
	
	@ExcelCell(11)
	private String Strength;
	
	@ExcelCell(12)
	private String Dosage;
	
	@ExcelCell(13)
	private String HsCode;

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public String getManufacturerCode() {
		return ManufacturerCode;
	}

	public void setManufacturerCode(String manufacturerCode) {
		ManufacturerCode = manufacturerCode;
	}

	public String getProductType() {
		return ProductType;
	}

	public void setProductType(String productType) {
		ProductType = productType;
	}

    
	
	

	public String getProductCode() {
		return ProductCode;
	}

	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getGenericName() {
		return GenericName;
	}

	public void setGenericName(String genericName) {
		GenericName = genericName;
	}

	public String getComposition() {
		return Composition;
	}

	public void setComposition(String composition) {
		Composition = composition;
	}

	public String getScheduled() {
		return Scheduled;
	}

	public void setScheduled(String scheduled) {
		Scheduled = scheduled;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	public String getStorageCondition() {
		return StorageCondition;
	}

	public void setStorageCondition(String storageCondition) {
		StorageCondition = storageCondition;
	}

	public String getStrength() {
		return Strength;
	}

	public void setStrength(String strength) {
		Strength = strength;
	}

	public String getDosage() {
		return Dosage;
	}

	public void setDosage(String dosage) {
		Dosage = dosage;
	}

	public String getHsCode() {
		return HsCode;
	}

	public void setHsCode(String hsCode) {
		HsCode = hsCode;
	}

	public String getManufacturingSiteCode() {
		return ManufacturingSiteCode;
	}

	public void setManufacturingSiteCode(String manufacturingSiteCode) {
		ManufacturingSiteCode = manufacturingSiteCode;
	}
	
	
	
	
	
	
	

}
