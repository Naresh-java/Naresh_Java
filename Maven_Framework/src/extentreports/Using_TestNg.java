package extentreports;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Using_TestNg extends ExtentTestNGReportBuilder{
	@Test
	public void googleSearch() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http:\\www.google.com");
		Assert.assertEquals(driver.getTitle(),"Goolge");
		driver.close();
		driver.quit();
	}
}