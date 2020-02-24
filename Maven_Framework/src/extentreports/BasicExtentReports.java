package extentreports;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BasicExtentReports {
	@Test
	public void loginTest() {
		System.out.println("Login");
		ExtentHtmlReporter extentHtmlReporter = new 
				ExtentHtmlReporter("C:\\Users\\NARESH\\git\\repository2\\Maven_Framework\\src\\Resports\\logintest.html");
		ExtentReports extentReports = new ExtentReports();
		 	extentReports.attachReporter(extentHtmlReporter);
		 	ExtentTest extentTest = extentReports.createTest("Login Test");
		 	extentTest.log(Status.INFO, "Login to Amazon");
		 	extentTest.log(Status.PASS, "Pass Login to Amazon");
		 	extentReports.flush();
		 	
	}
}
