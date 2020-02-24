package extentreports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LaunchBrowsers {
	ExtentHtmlReporter extentHtmlReporter;
	ExtentReports extentReports;

	@BeforeClass
	public void beforeClass() {
		extentHtmlReporter = new ExtentHtmlReporter(
				"C:\\Users\\NARESH\\git\\repository2\\Maven_Framework\\src\\Resports\\extendReport.html");
	}

	@BeforeMethod
	public void beforeMethod() {
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
	}

	@Test
	public void LaunchGoogle() {
		ExtentTest test = extentReports.createTest("Launch Google");
		test.log(Status.PASS, "Browser Launch Start");
		WebDriver driver = new ChromeDriver();
		test.log(Status.PASS, "Browser Launched Successfully");
		test.log(Status.PASS, "Google Launch Start");
		driver.get("https://www.google.com");
		test.log(Status.PASS, "Google Launched Successfully");
		if (driver.getTitle().equalsIgnoreCase("Google")) {
			test.log(Status.PASS, "Google Test Pass");
		} else {
			test.log(Status.FAIL, "Google Test Fail");
		}

	}

	@Test
	public void LaunchOutLook() {
		ExtentTest test1 = extentReports.createTest("Launch Outlook");
		test1.log(Status.PASS, "Browser Launch Start");
		WebDriver driver = new ChromeDriver();
		test1.log(Status.PASS, "Browser Launched Successfully");
		test1.log(Status.PASS, "OutLook Launch Start");
		driver.get("https://outlook.live.com/owa/");
		test1.log(Status.PASS, "OutLook Launched Successfully");
		if (driver.getTitle().equalsIgnoreCase("Google")) {
			test1.log(Status.PASS, "OutLook Test Pass");
		} else {
			test1.log(Status.FAIL, "OutLook Test Fail");
		}

	}

	@AfterMethod
	public void afterMethod() {
		extentReports.flush();
	}

}
