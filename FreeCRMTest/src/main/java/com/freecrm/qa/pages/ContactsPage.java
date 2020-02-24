package com.freecrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.freecrm.qa.base.TestBase;

public class ContactsPage  extends TestBase{
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	public WebElement contactsLable;
	@FindBy(id="first_name")
	public WebElement firstName;
	@FindBy(id = "surname")
	public WebElement surName;
	@FindBy(name ="client_lookup")
	public WebElement company;
	@FindBy(xpath ="//input[@value='Load From Company']// following::input[@value = 'Save']")
	public WebElement saveButton;
	
	public ContactsPage() {
		PageFactory.initElements(driver,this);
	}
	public boolean verifyContactsLabel() {
		return contactsLable.isDisplayed();
	}
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']")).click();
	}
	public void createNewContact(String title,String fName,String sName,String company) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText("Mr.");
		firstName.sendKeys(fName);
		surName.sendKeys(sName);
		this.company.sendKeys(company);
		saveButton.click();
	}
}
