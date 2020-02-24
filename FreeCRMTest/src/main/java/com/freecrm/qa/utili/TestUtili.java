package com.freecrm.qa.utili;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.freecrm.qa.base.TestBase;

public class TestUtili extends TestBase{
	public static long PAGE_LOAD_TIMEOUT=50;
	public static long IMPLICIT_WAIT = 50;
	
	public void switchToFrame(String frame) {
		driver.switchTo().frame(frame);
	}
	public static Object[][] getTestData(String sheetName){
		Object[][] data = null;
		File file = new File
				("D:\\JavaPractice\\FreeCRMTest\\src\\main\\java\\com\\freecrm\\qa\\testdata\\FreeCRMTestData.xlsx");
		try {
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet sheet = wb.getSheet(sheetName);
			XSSFRow row = sheet.getRow(0);
			data =  new Object[sheet.getLastRowNum()][row.getLastCellNum()];
			for (int rowCount= 0; rowCount < sheet.getLastRowNum(); rowCount++) {
				for (int columnCount = 0; columnCount < row.getLastCellNum(); columnCount++) {
					data[rowCount][columnCount] =
							sheet.getRow(rowCount+1).getCell(columnCount).toString();
					
				}
				
			}
			
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
		
	}
	public static void takeScreenshotAtEndOfTest() {
		// TODO Auto-generated method stub
		
	}
}
