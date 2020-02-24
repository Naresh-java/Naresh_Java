package TestNGListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Case is Started "+result.getName());
	} 

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case is Success "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case is Failure "+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case is Skiped "+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test Case is onTestFailedButWithinSuccessPercentage "+result.getName());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

		System.out.println("Test Case is onTestFailedWithTimeout "+result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Case is onStart "+context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Case is onFinish "+context.getName());
	}

}
