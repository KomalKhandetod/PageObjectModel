package com.elevate.qa.testCases;

import org.apache.log4j.Logger;
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
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	//To call TestBase Class Constructor use Super Keyword.
	//This will be used to read all properties from config.properties file
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		log.info("****************************** Starting test case execution  *****************************************");
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
		log.info("****************************** Browser is closed *****************************************");
		driver.quit();		
	}

}
