package tests;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Print_Numbers_InExcel {
	public static Sheet sheet;
	public static Workbook wb;
	public static void main(String[] args) {
		int num = 25;
		 wb = new HSSFWorkbook();
		try (OutputStream os = new FileOutputStream("D:\\Garbage\\Numbers.xlsx")) {
		 sheet = wb.createSheet("New Sheet");
		 for (int i = 1; i <=100; i++) {
			 long num1 = 1;
			 for (int j = 1; j <=i; j++) {	
				num1=num1*num;
			}
			 
			 addValue(num1,i-1);	
			 System.out.println(num1);
		}
			wb.write(os);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Complete");
	}
public static void addValue(long val, int rowNum) {
	Row row     = sheet.createRow(rowNum);  
    Cell cell   = row.createCell(0);  
    cell.setCellValue(val);
}
}
