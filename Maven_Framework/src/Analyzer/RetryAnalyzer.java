package Analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer  implements IRetryAnalyzer{
	int counter =0;
	int retryLimit = 3;
	public boolean retry(ITestResult results) {
		if (counter<retryLimit) {
			counter++;
			System.out.println("This is Retry for"+results.getName()+" Count "+counter);
			return true;
		}
		return false;
	}
}
