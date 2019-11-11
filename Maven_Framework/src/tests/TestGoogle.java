package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestGoogle {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("iusdhflsj");
		driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[1]/div[3]/center/input[1]")).click();
	}

}
