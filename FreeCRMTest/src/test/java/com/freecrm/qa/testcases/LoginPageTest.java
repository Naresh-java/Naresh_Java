package com.freecrm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	Logger logger = Logger.getRootLogger();
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		logger.info("-----------------BeforeMethod Start------------------------");
		logger.info("-----------------------setUp------------------------------");	
		intialization();
		logger.info("--------------intialization Method Called---------------");
		loginPage = new LoginPage();
		logger.info("-----------------------setUp End------------------------");
	}
	@Test(priority =1)
	public void loginPageTitleTest() {
		logger.info("-----------------------loginPageTitleTest Start--------------------");
		String title = loginPage.validatePageTitle();
		logger.info("--------------------"+title+" validate Start----------------------");
		Assert.assertEquals(title, 
				"CRMPRO - CRM software for customer relationship management, sales, and support.");
		logger.info("-----------------------loginPageTitleTest End--------------------");
	}
	@Test(priority = 2)
	public void crmLogoTest() {
		logger.info("-----------------------crmLogoTest Start--------------------");
		Assert.assertTrue(loginPage.validateCrmImg(), "Login Logo Not Matched");
		logger.info("-----------------------crmLogoTest End-----------------------");
	}
	@Test(priority = 3 )
	public void loginTest() {
		logger.info("-----------------------loginTest Start-----------------------");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		logger.info("-----------------------loginTest End-------------------------");
	}
	@AfterMethod
	public void tearDown() {
		logger.info("-----------------------tearDown Start--------------------");
		driver.quit();
		logger.info("-----------------------tearDown End--------------------");
		logger.info("-----------------------Browser Quit--------------------");
		
	}
	

}
