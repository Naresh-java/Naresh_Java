package extentreports;

import java.io.File;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentTest {
	@Test
	public void testMethod() {
		ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(
				new File("C:\\Users\\NARESH\\git\\repository2\\Maven_Framework\\src\\Resports\\extentTest.html"));
		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
		com.aventstack.extentreports.ExtentTest test = extentReports.createTest("SampleTest1");
		test.log(Status.PASS, "Step 1 Pass");
		test.log(Status.PASS, "Step 2 Pass");
		test.log(Status.FAIL, "Step 3 Fail");
		test.log(Status.SKIP, "Step 4 Skip");
		extentReports.flush();

	}
}
