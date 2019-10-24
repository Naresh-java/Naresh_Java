package log4j;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Log4J_Test_FreeCRM {

	WebDriver driver ;
	 Logger log = Logger.getLogger(Log4J_Test_FreeCRM.class);

	@BeforeMethod
	public void setup() {
		log.info("------------------------Starting TestCase Execution------------------------");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://freecrm.com");
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
	}
	@Test
	public void validateTitle() {
		log.info("-------------------------Starting TestCase --------------------------");
		log.info("-------------------------ValidateTitle-------------------------------");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
		log.info("-------------------------Ending TestCase --------------------------");
		log.info("------------------------- End ValidateTitle-------------------------------");
	}
	@Test(dependsOnMethods = "validateTitle")
	public void validateLogo() {
		log.info("-------------------------Starting TestCase --------------------------");
		log.info("-------------------------ValidateLogo-------------------------------");
		boolean b = driver.findElement(By.xpath("//*[@src='/images/cogtiny1.jpg']")).isDisplayed();
		Assert.assertTrue(b);
		log.info("-------------------------Ending TestCase --------------------------");
		log.info("------------------------- End ValidateLogo-------------------------------");
	}
	@AfterMethod
	public void tareDown() {
		driver.quit();
		log.info("-----------------------Browser is Closed-----------------------------");
	}

}
