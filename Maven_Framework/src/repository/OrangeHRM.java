package repository;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM {
	public static void main(String[] args) {
			WebDriver driver= new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://opensource-demo.orangehrmlive.com/");
			Repository.loadRepository();
			//String[] username = Repository.getObjectInfo("username");
			driver.findElement(Repository.getBy("username")).sendKeys("admin");;
	}

}
