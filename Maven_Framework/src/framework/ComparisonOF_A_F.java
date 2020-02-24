package framework;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ComparisonOF_A_F {
	@Test
	public void priceComparition() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.sendKeys("9491151062", Keys.TAB).perform();
		actions.sendKeys("9491151062", Keys.ENTER).perform();
		Thread.sleep(3000);
		driver.findElement(By.name("q")).sendKeys("Apple iPhone 7", Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Apple iPhone 7 (Black, 32 GB)']")).click();
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
			if (driver.getTitle().equalsIgnoreCase("iPhone 7 (Black, 32 GB) Online at Best Price on Flipkart.com")) {
				break;
			}
		}
		WebElement price = driver.findElement(By.xpath("//div[@class='_1vC4OE _3qQ9m1']"));
		String aPrice = price.getText();
		aPrice = aPrice.replaceAll("[^0-9]", "");
		System.out.println(aPrice);
		WebElement tprice = driver.findElement(By.xpath("//div[@class='_3auQ3N _1POkHg']"));
		String tPrice = tprice.getText();
		tPrice = tPrice.replaceAll("[^0-9]", "");
		System.out.println(tPrice);
		int discount = Integer.parseInt(tPrice) - Integer.parseInt(aPrice);
		System.out.println("Discount Price : " + discount);
		driver.navigate().to("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Apple iPhone 7", Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='Apple iPhone 7 (32GB) - Black']")).click();
		Set<String> windowsA = driver.getWindowHandles();
		for (String window : windowsA) {
			driver.switchTo().window(window);
			if (driver.getTitle().equalsIgnoreCase(
					"iPhone 7 Price: Buy Apple iPhone 7 Black, 32GB Mobile Phone Online at Best Price in India – Amazon.in\r\n"
							+ "\r\n" + "\r\n" + " \r\n" + " \r\n" + "        "))
				break;
		}
		WebElement priceA = driver
				.findElement(By.xpath("//span[@class='a-size-medium a-color-price priceBlockBuyingPriceString']"));
		String PriceAm = price.getText();
		aPrice = PriceAm.replaceAll("[^0-9]", "");
		System.out.println(aPrice);
		WebElement toprice = driver.findElement(By.xpath("//span[@class='priceBlockStrikePriceString a-text-strike']"));
		String totPrice = tprice.getText();
		tPrice = totPrice.replaceAll("[^0-9]", "");
		System.out.println(totPrice);
		int discountA = Integer.parseInt(totPrice) - Integer.parseInt(PriceAm);
		System.out.println("Discount Price : " + discountA);

	}
}