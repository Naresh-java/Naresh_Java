package webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WebTable {

	private WebDriver driver;
	

	public WebTable(WebDriver driver) {
		this.driver = driver;
	}

	public String getDataFromWebTable(WebElement table, int rowIndex, int ColumnIndex) {
		List<WebElement> trs = table.findElements(By.tagName("tr"));
		List<WebElement> tds = trs.get(rowIndex).findElements(By.tagName("td"));
		String td_data = tds.get(ColumnIndex).getText();
		return td_data;

	}
}
