package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public static Object readDataFromExcel(File filePath , String sheetName , int rowNumber , int columnNumber) {
		XSSFWorkbook wd ;
		Object data = null;
		try {
			 wd = new XSSFWorkbook(filePath);
			 XSSFSheet sheet = wd.getSheet(sheetName);
			 XSSFRow row = sheet.getRow(rowNumber);
			 XSSFCell cell = row.getCell(columnNumber);
			 data = Excel.getCellValue(cell);
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	private static Object getCellValue(XSSFCell cell) {
		Object cellValue = "";
		if (cell != null) {
			CellType type = cell.getCellType();
			switch (type) {
			case STRING:
				cellValue = cell.getStringCellValue();
				break;
			case NUMERIC:
				cellValue = cell.getNumericCellValue();
				break;
			default:
				cellValue = cell.getBooleanCellValue();
				break;
			}
		}
		return cellValue;
	}

}
