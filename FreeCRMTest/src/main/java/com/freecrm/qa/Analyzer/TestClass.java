package com.freecrm.qa.Analyzer;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void m1() {
		Assert.assertEquals(true, false);
	}
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void m2() {
		Assert.assertEquals(true, false);
	}
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void m3() {
		Assert.assertEquals(true,true);
	}

}
