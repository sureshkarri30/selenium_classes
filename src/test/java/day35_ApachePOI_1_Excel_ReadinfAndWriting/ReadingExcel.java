package day35_ApachePOI_1_Excel_ReadinfAndWriting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {

	public static void main(String[] args) throws IOException {

		FileInputStream excelfile = new FileInputStream("./src/test/resources/ReadExcelTestdata/TestMobiles.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(excelfile);
		
		XSSFSheet sheet = workbook.getSheet("sheet1");
		
		int noOfRows = sheet.getLastRowNum();
		System.out.println("No Of Rows: "+noOfRows);
		
		int noOfCol = sheet.getRow(0).getLastCellNum();//6
		System.out.println("No Of cols: "+noOfCol);//3
		
		
		for (int r = 0; r <= noOfRows; r++) {
			XSSFRow row = sheet.getRow(r);
			for (int c = 0; c < noOfCol; c++) {
//				XSSFCell cell = row.getCell(c);
//				String cellData = cell.toString();
				String cellData = "";
				try {
					cellData = row.getCell(c).toString();
				} catch (Exception e) {
					
				}
				System.out.print(cellData+"\t");
			}
			
			System.out.println();
		}
		
		workbook.close();
		excelfile.close();
	}

}
