package in.cdacnoida.dava.model;
import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelRow;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("Product")
public class ProductExcel {

	public ProductExcel() {}
	
	@ExcelRow 
	private int rowIndex;
	
	@ExcelCell(0)
	private String productName;

	@ExcelCell(1)
	private String prodCode;
	
	@ExcelCell(2)
	private String batch_number;
	
	@ExcelCell(3)
	private String expiray_date;
	
	@ExcelCell(4)
	private String hs_code;
	
	
	@ExcelCell(5)
	private String procureement_source_gstn;
	
	@ExcelCell(6)
	private String procurement_source_name;
	
	@ExcelCell(7)
	private String procurement_source_address;

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public String getBatch_number() {
		return batch_number;
	}

	public void setBatch_number(String batch_number) {
		this.batch_number = batch_number;
	}

	public String getExpiray_date() {
		return expiray_date;
	}

	public void setExpiray_date(String expiray_date) {
		this.expiray_date = expiray_date;
	}

	public String getProcureement_source_gstn() {
		return procureement_source_gstn;
	}

	public void setProcureement_source_gstn(String procureement_source_gstn) {
		this.procureement_source_gstn = procureement_source_gstn;
	}

	public String getProcurement_source_name() {
		return procurement_source_name;
	}

	public void setProcurement_source_name(String procurement_source_name) {
		this.procurement_source_name = procurement_source_name;
	}

	public String getProcurement_source_address() {
		return procurement_source_address;
	}

	public void setProcurement_source_address(String procurement_source_address) {
		this.procurement_source_address = procurement_source_address;
	}

	public String getHs_code() {
		return hs_code;
	}

	public void setHs_code(String hs_code) {
		this.hs_code = hs_code;
	}
	
	
	
	
	
}
