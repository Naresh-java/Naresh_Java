package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Callender {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.calculator.net/age-calculator.html");
		driver.switchTo().frame(0);
		Select month = new Select(driver.findElement(By.id("today_Month_ID")));
		month.selectByValue("aug");
		Select day = new Select(driver.findElement(By.id("today_Day_ID")));
		day.selectByValue("15");
		Select year = new Select(driver.findElement(By.id("today_Year_ID")));
		year.selectByValue("2016");
	}

}
