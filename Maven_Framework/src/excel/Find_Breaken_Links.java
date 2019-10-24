package excel;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Find_Breaken_Links {
	@Test
	public void findBreakenLinks() {
		ChromeOptions co = new ChromeOptions();
		co.setHeadless(true);
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://en.wikipedia.org/wiki/Rohit_Sharma");
		List<WebElement> allLinks =driver.findElements(By.tagName("a"));
		XSSFWorkbook wb = new XSSFWorkbook();
		OutputStream fileOut = null;
		try {
			 fileOut = new  FileOutputStream("D:\\Garbage\\BrokenLinks.xlsx");	
			XSSFSheet sheet = wb.createSheet("links");
			int rowCount = 0;
			int cellCount = 0;
			for (WebElement link : allLinks) {
				
				XSSFRow row = sheet.createRow(rowCount);
				if (getResponceCode(link.getAttribute("href"))>=200
						&& getResponceCode(link.getAttribute("href"))<=299) {
					XSSFCell cell =row.createCell(cellCount);
		            cell.setCellValue(link.getText()+" : "+link.getAttribute("href"));
		        	CellStyle style =setFontColor(IndexedColors.GREEN.index, wb);
		        	cell.setCellStyle(style);
					System.out.println(link.getText()+" Working");
				}else {
		            XSSFCell cell =row.createCell(cellCount);
		            cell.setCellValue(link.getText()+" : "+link.getAttribute("href"));
		        	CellStyle style =setFontColor(IndexedColors.RED.index, wb);
		            cell.setCellStyle(style);
					System.out.println(link.getText()+" not Working");
				}
				rowCount++;
				
			}
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		try {
			wb.write(fileOut);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private CellStyle setFontColor(short indexedColors,XSSFWorkbook wb) {
		CellStyle style = wb.createCellStyle();
		 Font font = wb.createFont();
         font.setColor(indexedColors);
         style.setFont(font);
		return style;
		
	}
	private int getResponceCode(String LinkUrl) {
		int responceCode=0;
		URL url;
		try {
			url = new URL(LinkUrl);
			HttpURLConnection hur = (HttpURLConnection) url.openConnection();
			hur.setRequestMethod("HEAD");
			hur.connect();
			responceCode =hur.getResponseCode();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responceCode;
	}

}
