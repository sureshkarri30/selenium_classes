package day35_ApachePOI_1_Excel_ReadinfAndWriting;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingTestExcel {

public static void main(String[] args) throws IOException,FileNotFoundException{
		
		FileOutputStream file = new FileOutputStream("./src/test/resources/mynewfile.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet();
		
		
		for (int r = 0; r < 3; r++) {
			XSSFRow row = sheet.createRow(r);
			for (int c = 0; c < 3; c++) {
				XSSFCell cell = row.createCell(c);
				String value = "Welcome";
				cell.setCellValue(value);
			}
		}
				
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("Excel writing completed");
	}
	
}	

