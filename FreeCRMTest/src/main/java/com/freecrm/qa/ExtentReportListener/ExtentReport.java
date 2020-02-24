package com.freecrm.qa.ExtentReportListener;

import static org.testng.Assert.assertEquals;

import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	ExtentHtmlReporter extentHtmlReporter;
	ExtentReports extentReport;
	ExtentTest extentTest;
	@BeforeMethod
	public void setup() {
		extentHtmlReporter = new ExtentHtmlReporter("D:\\JavaPractice\\FreeCRMTest\\src\\Reports\\testReports.html");
		extentReport = new ExtentReports();
		extentReport.attachReporter(extentHtmlReporter);
		extentHtmlReporter.config().setChartVisibilityOnOpen(true);
		extentHtmlReporter.config().setDocumentTitle("Test Report");
		extentHtmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		extentHtmlReporter.config().setTheme(Theme.STANDARD);
		extentHtmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");	
	}
	@Test
	public void testMethod1() {
		System.out.println("Test Method");
		extentTest = extentReport.createTest("Test Case 1", "PASSED test case");
		
	}
	@Test
	public void testMethod2() {
		System.out.println("Test Method");
		extentTest = extentReport.createTest("Test Case 2", "PASSED test case");
	}
	@Test
	public void testMethod3() {
		System.out.println("Test Method");
		extentTest = extentReport.createTest("Test Case 3", "PASSED test case");
	}
	@Test
	public void testMethod4() {
		System.out.println("Test Method");
		extentTest = extentReport.createTest("Test Case 4", "Failed test case");
		assertEquals(true, false);
	}
	@Test
	public void testMethod5() {
		System.out.println("Test Method");
		extentTest = extentReport.createTest("Test Case 4", "PASSED test case");
	}
	@Test
	public void testMethod6() {
		System.out.println("Test Method");
		extentTest = extentReport.createTest("Test Case 14", "PASSED test case");
	}
	@Test
	public void testMethod8() {
		System.out.println("Test Method");
		extentTest = extentReport.createTest("Test Case 8", "PASSED test case");
	}
	
	 public void getResult(ITestResult result) {
	        if(result.getStatus() == ITestResult.FAILURE) {
	        	extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
	        	extentTest.fail(result.getThrowable());
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS) {
	        	extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
	        }
	        else {
	        	extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
	        	extentTest.skip(result.getThrowable());
	        }
	        extentReport.flush();
	    }
}
