package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;

public class HomePage  extends TestBase{
	@FindBy(xpath = "//td[contains(text(),'Sudha Nanda')]")
	public WebElement userNameLabel;
	@FindBy(xpath = "//a[text()='Contacts']")
	public WebElement contacts;
	@FindBy(xpath = "//a[text()='Deals']")
	public WebElement deals;
	@FindBy(xpath = "//a[text()='Tasks']")
	public WebElement tasks;
	@FindBy(xpath = "//a[text()='New Contact']")
	public WebElement newContact;
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	public ContactsPage clickContactsLink() {
		contacts.click();
		return new ContactsPage();
	}
	public DealsPage clickDealsLink() {
		deals.click();
		return new DealsPage(); 
	}
	public TasksPage clickTasksLink() {
		tasks.click();
		return new TasksPage();
	}
	public boolean isUserNameDisplayed() {
		
		return userNameLabel.isDisplayed();
	}
	public void clickOnNewContactsLink() {
		Actions act = new Actions(driver);
		act.moveToElement(contacts).build().perform();
		newContact.click();
	}
	 
}
