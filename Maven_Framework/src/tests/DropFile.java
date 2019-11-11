package tests;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class DropFile {
	@Test
	public void DropFileToGmail() throws InterruptedException, IOException, FindFailed {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://mail.google.com/");
		driver.findElement(By.id("identifierId"))
		.sendKeys("mamellapallinaresh",Keys.ENTER);
		driver.findElement(By.name("password"))
		.sendKeys("Naresh@9491151062",Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Compose']")).click();
		Actions act = new Actions(driver);
		Thread.sleep(3000);
		act.sendKeys("sravankdk@gmail.com",Keys.TAB).build().perform();
		Thread.sleep(3000);
		act.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(3000);
		act.sendKeys("Tasks").build().perform();
		Desktop.getDesktop().open(new File("C:\\Users\\NARESH\\Desktop"));
		Thread.sleep(3000);
		Screen screen = new Screen();
		Pattern resume = new Pattern("D:\\Sikuli_Images\\flower.PNG");
		Thread.sleep(3000);
		Pattern emailbody = new Pattern("D:\\Sikuli_Images\\GmailBody.PNG");
		screen.dragDrop(resume, emailbody);
		Thread.sleep(3000);
		act.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(3000);
		//act.sendKeys(Keys.ENTER).build().perform();
		
	}

}
