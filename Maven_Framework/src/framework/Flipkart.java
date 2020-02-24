package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
public class Flipkart {

	@Test
	public void orderIphone() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions act = new Actions(driver);
		act.sendKeys("9491151062",Keys.TAB,"9491151062",Keys.ENTER).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.name("q")).sendKeys("Iphone 7 Plus",Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Apple iPhone 7 Plus (Black, 32 GB)']")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//button[text()='BUY NOW']")).click();
	
	}
	@Test
	public void orderIphone1() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions act = new Actions(driver);
		act.sendKeys("9491151062",Keys.TAB,"9491151062",Keys.ENTER).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.name("q")).sendKeys("Iphone 7 Plus",Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Apple iPhone 7 Plus (Black, 32 GB)']")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//button[text()='BUY NOW']")).click();
	
	}
	@Test
	public void orderIphone3() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions act = new Actions(driver);
		act.sendKeys("9491151062",Keys.TAB,"9491151062",Keys.ENTER).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.name("q")).sendKeys("Iphone 7 Plus",Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Apple iPhone 7 Plus (Black, 32 GB)']")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//button[text()='BUY NOW']")).click();
	
	}
	@Test
	public void orderIphone2() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions act = new Actions(driver);
		act.sendKeys("9491151062",Keys.TAB,"9491151062",Keys.ENTER).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.name("q")).sendKeys("Iphone 7 Plus",Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Apple iPhone 7 Plus (Black, 32 GB)']")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//button[text()='BUY NOW']")).click();
	
	}
	
}
