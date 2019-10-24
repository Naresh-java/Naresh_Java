package excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Store_Data_Into_Excel {
	public static void main(String[] args) throws FileNotFoundException, IOException {  
        Workbook wb = new XSSFWorkbook();  
        try  (OutputStream fileOut = new FileOutputStream("D:\\Garbage\\testdata.xlsx")) {  
            XSSFSheet sheet1 = (XSSFSheet) wb.createSheet("First Sheet");  
            XSSFSheet sheet2 = (XSSFSheet) wb.createSheet("Second Sheet");  
            wb.write(fileOut);  
        }catch(Exception e) {  
            System.out.println(e.getMessage());  
        }  
    }  

}
