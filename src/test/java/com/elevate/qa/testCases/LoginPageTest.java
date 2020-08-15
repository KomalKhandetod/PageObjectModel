package com.elevate.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.elevate.qa.Base.TestBase;
import com.elevate.qa.pages.LoginPage;
import com.elevate.qa.pages.LMSDashboard;

public class LoginPageTest extends TestBase {
	
	LoginPage LoginPage;
	LMSDashboard LMSDashboard;
	
	//To call TestBase Class Constructor use Super Keyword.
	//This will be used to read all properties from config.properties file
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		LoginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = LoginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "");
	}
	
	@Test(priority=2)
	public void elevateLogoTest() {
		boolean flag = LoginPage.validateElevateLogo();
		Assert.assertEquals(flag, true);
	}
	
	@Test(priority=3)
	public void adminLoginTest() {
		LMSDashboard = LoginPage.adminLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();		
	}

}
