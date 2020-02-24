package callender;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebCallender {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		WebElement departure = driver.findElement(By.xpath("//label[@for='departure']"));
		departure.click();
		String month = "February";
		String year = "2020";
		boolean isFound = false;
		String monthYear = month + " " + year;
		List<WebElement> getMonthYear = driver.findElements(By.xpath("//div[@class='DayPicker-Caption']"));
		for (WebElement currentMonth : getMonthYear) {
			if (monthYear.equalsIgnoreCase(currentMonth.getText())) {
				WebElement months = departure.findElement(
						By.xpath("//div[text()='" + monthYear + "']//ancestor::div[@class='DayPicker-Month']"));
				List<WebElement> days = months.findElements(
						By.xpath("//div[text()='" + monthYear + "']//ancestor::div[@class='DayPicker-Month']//p"));
				for (WebElement day : days) {
					String acday = day.getText();
					if (acday.equalsIgnoreCase("26")) {
						day.click();
						isFound = true;
						break;
					}
				}
			}
		}

	}
}
