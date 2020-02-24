package com.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.utili.TestUtili;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtili testutili;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}
	//Test cases independet each other
	//before each test case -- launch the browser and login
	//after each test case -- close the browser
	//then Test will be exqutied
	@BeforeMethod
	public void setUp() {
		intialization();
		testutili = new TestUtili();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home Page Title Not Matcheds");
	}

	@Test(priority = 2)
	public void verifyCurrentUserName() {
		testutili.switchToFrame("mainpanel");
		Assert.assertTrue(homePage.isUserNameDisplayed(), "User Name Label Not Displayed");
	}
	@Test(priority = 3)
	public void clickOnContactsLinkTest() {
		testutili.switchToFrame("mainpanel");
		contactsPage =homePage.clickContactsLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
