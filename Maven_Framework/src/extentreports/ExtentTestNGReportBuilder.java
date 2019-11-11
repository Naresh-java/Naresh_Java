package extentreports;

import org.junit.BeforeClass;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.protobuf.Method;

public class ExtentTestNGReportBuilder {
	private static ExtentReports extent;
	private static ThreadLocal parentTest = new ThreadLocal();
	private static ThreadLocal test = new ThreadLocal();
	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.createInstance("extent.html");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		extent.attachReporter(htmlReporter);
	}
	@BeforeClass
	public synchronized void beforeClass() {
		ExtentTest parent = extent.createTest(getClass().getName());
		parentTest.set(parent);
	}
	@BeforeMethod
	public synchronized void beforeMethod() {
        ExtentTest child = ((ExtentTest) parentTest.get()).createNode(getClass().getMethods()[0].getName());
		test.set(child);
	}
	@AfterMethod
	public synchronized void afterMethod() {
		ITestResult result = Reporter.getCurrentTestResult();
		if (result.getStatus()==ITestResult.FAILURE) {
			((ExtentTest) test.get()).fail(result.getThrowable());			
		}else if(result.getStatus()==ITestResult.SKIP) {
			((ExtentTest) test.get()).skip(result.getThrowable());	
		}else {
			 ((ExtentTest) test.get()).pass("Test passed");
		}
		extent.flush();
	}

}
