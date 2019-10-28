package framework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginOrangeHRM {
	@Test
	public void loginToOrangeHRM() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://orangehrm-demo-6x.orangehrmlive.com/auth/login");
		driver.manage().timeouts().pageLoadTimeout
		(Data.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait
		(Data.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String filePath = "C:\\Users\\NARESH\\git\\repository2\\Maven_Framework\\Repositorys\\OrangeHRM.xml";
		RepositoryUtili.loadRepositoryFile(filePath);
		WebElement username =driver.findElement(RepositoryUtili.getBy("username"));
		username.clear();
		username.sendKeys("admin");
		WebElement password = driver.findElement(RepositoryUtili.getBy("password"));
		password.clear();
		password.sendKeys("admin123");
		driver.findElement(RepositoryUtili.getBy("clicklogin")).click();

	}
}
