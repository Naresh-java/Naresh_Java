package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.freecrm.qa.base.TestBase;

public class LoginPage extends TestBase {
	// Page Factory - Respositry
	@FindBy(name = "username")
//	@CacheLookup
	public WebElement username;
//	@CacheLookup
	@FindBy(name = "password")
	public WebElement password;
	@FindBy(xpath = "//input[@value='Login']")
	public WebElement login;
	@FindBy(xpath = "//input[@type='submit']")
	public WebElement signUp;
	@FindBy(xpath = "//img[contains(@src,'logo.png')]")
	public WebElement cmrLogo;

	// initilizing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validatePageTitle() {
		return driver.getTitle();
	}

	public boolean validateCrmImg() {
		return cmrLogo.isDisplayed();
	}
	public HomePage login(String username,String password) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.username.clear();
		this.username.sendKeys(username);
		this.password.clear();
		this.password.sendKeys(password);
		login.click();
		return new HomePage();
	}

}
