package windowhandle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleHandles {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com");
		Actions act = new Actions(driver);
		act.sendKeys("9491151062",Keys.TAB,"9491151062",Keys.ENTER).build().perform();
		Thread.sleep(3000);
		WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(search));
		search.sendKeys("iphone 7",Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Apple iPhone 7 (Black, 32 GB)']")).click();
		driver.switchTo().window(driver.getWindowHandles().iterator().next());//this line works only two windos
	}

}
