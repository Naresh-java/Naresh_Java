package extentreports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportExample {
	@Test
	public void googleSearch() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\NARESH\\git\\repository2\\Maven_Framework\\src\\Resports\\extendReport.html");
		ExtentReports report = new ExtentReports();
		report.attachReporter(htmlReporter);	
		ExtentTest test1 = report.createTest("Google Search Test One","This is a Test To Validate Google Functionality");
		test1.log(Status.INFO, "Starting Test Case");
		driver.get("http:\\www.google.com");
		test1.pass("Launch Google page");
		driver.findElement(By.name("q")).sendKeys("naresh");
		test1.pass("Enter Value into SearchBox");
		driver.findElement(By.name("btnK")).click();
		test1.pass("Click Google Search Button");
		driver.close();
		test1.log(Status.INFO, "Browser Closed ");
		driver.quit();
		report.flush();
		
		
		
	}

}
