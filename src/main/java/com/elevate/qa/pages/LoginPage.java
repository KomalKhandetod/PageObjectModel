package com.elevate.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.elevate.qa.Base.TestBase;

public class LoginPage extends TestBase{
	
	Logger log = Logger.getLogger(LoginPage.class);
	
	//Define Page Factory or Object Repository (OR)
	
	@FindBy(name="Username")
	WebElement Username;
	
	@FindBy(name="Password")
	WebElement Password;
	
	@FindBy(name="action")
	WebElement Login;
	
	@FindBy(xpath="//img[@class='responsive-img']")
	WebElement ElevateLogo;
	
	//Create constructor of LoginPage to access Page Factory Elements
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Define all actions on Login Page
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateElevateLogo() {
		return ElevateLogo.isDisplayed();
	}
	
	public LMSDashboard adminLogin(String username, String password) {
		Username.sendKeys(username);
		Password.sendKeys(password);
		Login.click();
		
		return new LMSDashboard();
		
		
	}
}
