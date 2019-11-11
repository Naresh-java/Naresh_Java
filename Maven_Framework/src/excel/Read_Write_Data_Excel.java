package excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Read_Write_Data_Excel {
	@Test
	public void launch() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get(readKeyValue("URl"));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.switchTo().frame(0);
			WebElement max = driver
					.findElement(By.xpath("//label[text()='Max:']//following-sibling::input[@type='number']"));
			max.clear();
			max.sendKeys(readKeyValue("MAX_NUM"));
			driver.findElement(By.xpath("//input[@value='Generate']")).click();
			Thread.sleep(3000);
			WebElement res = driver.findElement(By.xpath("//*[text()='Result:']//following-sibling::span[1]"));
			String result = res.getText();
			System.out.println("Results : " + result);
			// writeKeyValue(result);
		} catch (FileNotFoundException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	private String filePath = "D:\\Garbage\\Randam.xlsx";
	String value;

	private String readKeyValue(String key) throws FileNotFoundException {
		try {

			File fileOut = new File(filePath);
			XSSFWorkbook wb = new XSSFWorkbook(fileOut);
			XSSFSheet sheet = wb.getSheet("Sheet1");
			XSSFRow row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				XSSFCell cell = row.getCell(i);
				String hKey = getCellValue(cell);
				if (key.equalsIgnoreCase(hKey)) {
					XSSFRow vrow = sheet.getRow(1);
					XSSFCell vcell = vrow.getCell(i);
					value = getCellValue(vcell);
				}
			}
			wb.close();
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}

		return value;

	}

	private void writeKeyValue(String result) {
		int cellNum = -1;
		try {
			XSSFWorkbook wb = new XSSFWorkbook(filePath);
			XSSFSheet sheet = wb.getSheet("Sheet1");
			XSSFRow row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				XSSFCell cell = row.getCell(i);
				String hKey = getCellValue(cell);
				if ("RESULT".equalsIgnoreCase(hKey)) {
					cellNum = i;
					break;
				}
			}
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			FileOutputStream fileOut = new FileOutputStream(filePath);
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.getSheet("Sheet1");
			XSSFRow row = sheet.getRow(1);
			if (cellNum != -1) {
				XSSFCell cell = row.createCell(cellNum);
				cell.setCellType(CellType.STRING);
				cell.setCellValue(result.toString());
			}
			wb.write(fileOut);
			fileOut.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String getCellValue(XSSFCell cell) {
		String cellValue = "";
		if (cell != null) {
			CellType type = cell.getCellType();
			switch (type) {
			case STRING:
				cellValue = cell.getStringCellValue();
				break;
			case NUMERIC:
				cellValue = String.valueOf(cell.getNumericCellValue());
				break;
			default:
				cellValue = String.valueOf(cell.getBooleanCellValue());
				break;
			}
		}
		return cellValue;
	}
}
