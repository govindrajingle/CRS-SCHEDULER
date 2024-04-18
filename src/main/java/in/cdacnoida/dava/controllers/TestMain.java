package in.cdacnoida.dava.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.poiji.bind.Poiji;

import in.cdacnoida.dava.model.ConsignmentDetailsExcel;
import in.cdacnoida.dava.model.DummyExcel;

public class TestMain {
	

	public static void main(String[] args) {	
		
		
		
		File file=new File("C:\\Users\\cdac\\Desktop\\motu.xlsx");
		List<DummyExcel> aa = Poiji.fromExcel(file, DummyExcel.class);
		int i=70;
		for (DummyExcel dummyExcel : aa) {
			
			System.out.println("update msips.msips_proposal_master set dt_submit_date='"+dummyExcel.getDate()+" 00:00:00' where num_isvalid=1 and num_proposal_id="+dummyExcel.getApplicantId()+";" );
			
		}
		
		
		
		
		
		
//		List<String> srNumbers=new ArrayList<>();
//		srNumbers.add("123456");
//		srNumbers.add("789456");
//		srNumbers.add("159456");
//		srNumbers.add("753159");
//		
//		 String[] columns = {"Serial Numbers"};
//		
//		// Create a Workbook
//		Workbook workbook = new XSSFWorkbook();
//		
//		
//		/* CreationHelper helps us create instances of various things like DataFormat, 
//        Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
//		CreationHelper createHelper = workbook.getCreationHelper();
//		
//		// Create a Sheet
//		Sheet sheet = workbook.createSheet("Serial Numbers");
//		
//		// Create a Font for styling header cells
//		Font headerFont = workbook.createFont();
//        headerFont.setBold(true);
//        headerFont.setFontHeightInPoints((short) 14);
//        headerFont.setColor(IndexedColors.RED.getIndex());
//        
//        // Create a CellStyle with the font
//        CellStyle headerCellStyle = workbook.createCellStyle();
//        headerCellStyle.setFont(headerFont);
//        
//        // Create a Row
//        Row headerRow = sheet.createRow(0);
//		
//        // Create cells
//        for(int i = 0; i < columns.length; i++) {
//            Cell cell = headerRow.createCell(i);
//            cell.setCellValue(columns[i]);
//            cell.setCellStyle(headerCellStyle);
//        }
//        
//        // Create Cell Style for formatting Date
//        CellStyle dateCellStyle = workbook.createCellStyle();
//        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
//        
//        //Create Other rows and cells with employees data
//        int rowNum = 1;
//        for (String serialNumber : srNumbers) {
//        	Row row = sheet.createRow(rowNum++);
//        	 row.createCell(0)
//             .setCellValue(serialNumber);
//		}
//        
//		// Resize all columns to fit the content size
//        for(int i = 0; i < columns.length; i++) {
//            sheet.autoSizeColumn(i);
//        }
//
//        // Write the output to a file
//        try {
//			FileOutputStream fileOut = new FileOutputStream("C:\\Users\\cdac\\Desktop\\poi-generated-file.xlsx");
//			 workbook.write(fileOut);
//		        fileOut.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
}
