package excel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Print_Tables_InExcel {
	public static void main(String[] args) {
		try {
			FileOutputStream fileOut = new FileOutputStream("D:\\Garbage\\Tables.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet("Tables");
			for (int rowCount = 0; rowCount <10; rowCount++) {
				XSSFRow row = sheet.createRow(rowCount);
				for (int cellCount = 0; cellCount < 19; cellCount++) {
					XSSFCell cell = row.createCell(cellCount);
					String table = (cellCount+2)+" X "+(rowCount+1)+" = "+((rowCount+1)*(cellCount+2));
					cell.setCellValue(table);
					System.out.print(table+"\t");
				}
				System.out.println();
				
			}
			wb.write(fileOut);
			fileOut.close();
			wb.close();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
