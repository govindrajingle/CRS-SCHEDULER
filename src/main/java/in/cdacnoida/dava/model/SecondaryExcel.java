package in.cdacnoida.dava.model;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelRow;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("SECONDARY")
public class SecondaryExcel {

	
	public SecondaryExcel() {}

	@ExcelRow 
	private int rowIndex;
	
	@ExcelCell(0)
	private String code_sno;
	
	@ExcelCell(1)
	private String sscc;
	
	@ExcelCell(2)
	private String type;
	
	@ExcelCell(3)
	private String level;
	
	@ExcelCell(4)
	private String parentDc;
	
	@ExcelCell(5)
	private String prodCode;
	
	@ExcelCell(6)
	private String batch_number;
	
	@ExcelCell(7)
	private String subCount;

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public String getCode_sno() {
		return code_sno;
	}

	public void setCode_sno(String code_sno) {
		this.code_sno = code_sno;
	}

	public String getSscc() {
		return sscc;
	}

	public void setSscc(String sscc) {
		this.sscc = sscc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getParentDc() {
		return parentDc;
	}

	public void setParentDc(String parentDc) {
		this.parentDc = parentDc;
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

	public String getSubCount() {
		return subCount;
	}

	public void setSubCount(String subCount) {
		this.subCount = subCount;
	}
	
	
	
	
}
