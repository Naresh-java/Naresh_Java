package windowhandle;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;

public class WindowHandles {
	public static void main(String[] args) throws InterruptedException {

		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions(capabilities);
        internetExplorerOptions.ignoreZoomSettings();
        internetExplorerOptions.introduceFlakinessByIgnoringSecurityDomains();
        internetExplorerOptions.requireWindowFocus();
        
		WebDriver driver = new InternetExplorerDriver(internetExplorerOptions);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://google.com/");
		Actions act = new Actions(driver);
		
		Thread.sleep(3000);
		WebElement login = driver.findElement(By.xpath("//a[text()='Sign in']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", login);
		
		
		
//		act.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
//		Thread.sleep(3000);
//		Set<String> tabs =driver.getWindowHandles();
//		for (String tab : tabs) {
//			System.out.println(tab);
//			if (driver.getTitle().equalsIgnoreCase("New tab")) {
//				break;
//			}else {
//				driver.switchTo().window(tab);
//			}
//		}
//		Thread.sleep(3000);
//		driver.get("https://www.facebook.com/");;
		
		 /*// driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL + "t");//opens new tab
		
		 //Store the current window handle

		  String winHandleBefore = driver.getWindowHandle();

		  //Perform the click operation that opens new window //Switch to new window open 

		   for(String winHandle : driver.getWindowHandles()){

		   driver.switchTo().window(winHandle);

		    driver.get("https://facebook.com/");
*/
		  //  }

		
		
		
		
//		driver.get("https://www.flipkart.com");
//		Thread.sleep(3000);
//		new Actions(driver).keyDown(Keys.CANCEL+"T").keyUp("T"+Keys.CONTROL).build().perform();
//		String title = driver.getTitle();
//		Thread.sleep(3000);
//		driver.findElement(By.name("q")).sendKeys("iphone 7", Keys.ENTER);
//		Thread.sleep(3000);
//		Actions act = new Actions(driver);
//		act.keyDown(Keys.CONTROL).build().perform();
//		WebElement iphone7=driver.findElement(By.xpath("//div[text()='Apple iPhone 7 (Black, 32 GB)']"));
//		act.moveToElement(iphone7);
//		iphone7.click();
//		act.keyUp(Keys.CONTROL).build().perform();
//		Set<String > windows = driver.getWindowHandles();
//		for (String window : windows) {
//		if (title.equalsIgnoreCase(driver.getTitle())) {
//				break;
//			}
//		}
//		Thread.sleep(3000);
//		new Actions(driver).keyDown(Keys.ALT).sendKeys(Keys.TAB).keyUp(Keys.ALT).build().perform();
//		driver.switchTo().window(driver.getWindowHandles().iterator().next());
//		Set<String > windows = driver.getWindowHandles();
//		for (String window : windows) {
//			if (title.equalsIgnoreCase(driver.getTitle())) {
//				break;
//			}
//		}
//		  Actions act = new Actions(driver); act.sendKeys(Keys.TAB,"9491151062",
//		  Keys.TAB, "9491151062", Keys.ENTER).build().perform(); Thread.sleep(3000);
//		  WebElement search = driver.findElement(By.xpath("//input[@name='q']")); new
//		  WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(search));
//		  search.sendKeys("iphone 7", Keys.ENTER); Thread.sleep(3000);
//		  driver.findElement(By.xpath("//div[text()='Apple iPhone 7 (Black, 32 GB)']")).click();
//		  driver.switchTo().window(driver.getWindowHandles().iterator().next());// this line works only two windos

	}

}
