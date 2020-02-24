package Analyzer;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestAnalyzer {
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void testMethod1() {
		assertTrue(true);
	}
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void testMethod2() {
		assertTrue(false);
	}
}
