package excel;

import java.io.File;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {
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
			case BOOLEAN:
				cellValue = cell.getBooleanCellValue();
				break;
			default: 
					cellValue="Type Not Avilable";
			}
		}
		return cellValue;
	}

	public static void main(String[] args) {
		File file = new File("D:\\Garbage\\testdata.xlsx");
		XSSFWorkbook wb;
		if (file.exists()) {
			try {
				wb = new XSSFWorkbook(file);
				XSSFSheet sheet = wb.getSheetAt(0);
				for (int rowCount = 0; rowCount < sheet.getLastRowNum(); rowCount++) {
					XSSFRow row = sheet.getRow(rowCount);
					for (int CellCount = 0; CellCount < row.getLastCellNum(); CellCount++) {
						XSSFCell cell = row.getCell(CellCount);
						Object data = ExcelTest.getCellValue(cell);
						System.out.print(data+"\t");
						
					}
					System.out.println();
					
				}
				
			} catch (InvalidFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("File Not Exists");
		}
	}

}
