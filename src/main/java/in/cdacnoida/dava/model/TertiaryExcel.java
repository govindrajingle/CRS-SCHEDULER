package in.cdacnoida.dava.model;
import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelRow;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("Tertiary")
public class TertiaryExcel {

	public TertiaryExcel() {}
	
	@ExcelRow 
	private int rowIndex;
	
	@ExcelCell(0)
	private String ssccCode;

	@ExcelCell(1)
	private String tertiaryType;
	
	@ExcelCell(2)
	private String prodCode;
	
	@ExcelCell(3)
	private String batch_number;

	@ExcelCell(4)
	private String sub_count;

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public String getSsccCode() {
		return ssccCode;
	}

	public void setSsccCode(String ssccCode) {
		this.ssccCode = ssccCode;
	}

	public String getTertiaryType() {
		return tertiaryType;
	}

	public void setTertiaryType(String tertiaryType) {
		this.tertiaryType = tertiaryType;
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

	public String getSub_count() {
		return sub_count;
	}

	public void setSub_count(String sub_count) {
		this.sub_count = sub_count;
	}
}
