package excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webtable.WebTable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class OrangeHRM {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123", Keys.ENTER);

		WebElement pim = driver.findElement(By.xpath("//b[text()='PIM']"));
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(pim));
		pim.click();
		System.out.println(Excel.readDataFromExcel(new File("D:\\Garbage\\testdata.xlsx"), "First Sheet", 1, 2));
		WebTable webTable = new WebTable(driver);
		File file = new File("D:\\Garbage\\testdata1.xlsx");
		FileOutputStream out = null;
		XSSFWorkbook wb = null;
		try {
			out = new FileOutputStream(file);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		List<WebElement> trs = driver.findElement(By.tagName("table")).findElements(By.tagName("tr"));
		for (int i = 0; i < trs.size()-2; i++) {
			List<WebElement> tds = trs.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < tds.size()-3; j++) {
				wb = new XSSFWorkbook();
				XSSFSheet sheet = wb.createSheet("WebTable Data");
				XSSFRow row = sheet.createRow(i);
				XSSFCell cell = row.createCell(j);
				String data = webTable.getDataFromWebTable(driver.findElement(By.tagName("table")), i, j);
				System.out.println(data);
				if (data!=null) {
					cell.setCellValue(data.toString());;
					
				}else {
					cell.setCellValue("NA");
				}
			}

		}
		try {
			
			wb.write(out);
			out.flush();
			wb.close();
			System.out.println("Completed ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
