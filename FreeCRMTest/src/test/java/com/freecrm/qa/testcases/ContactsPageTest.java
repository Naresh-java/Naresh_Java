package com.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.utili.TestUtili;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtili testUtili;
	ContactsPage contactsPage;
	String sheetName = "contacts";
	public ContactsPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		intialization();
		testUtili = new TestUtili();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtili.switchToFrame("mainpanel");
		contactsPage = homePage.clickContactsLink();
	}
	@Test(priority = 1)
	public void verifyContactsPageLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts lable Not Visible");
	}
	@Test(priority = 2,enabled = false)
	public void selectContactsTest() {
		testUtili.switchToFrame("processFrame");
		contactsPage.selectContactsByName("Sudha Nadha");
	}
	@DataProvider
	public Object[][] getCRMTestData() {
	Object[][] data =	TestUtili.getTestData(sheetName);
	return data;
		
	}
	@Test(priority = 3,dataProvider = "getCRMTestData" ,enabled = false)
	public void validateNewContact(String title,String firstName,String surName, String company) {
		homePage.clickOnNewContactsLink();
		contactsPage.createNewContact(title, firstName, surName, company);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
