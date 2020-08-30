package com.elevate.qa.testCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.elevate.qa.Base.TestBase;
import com.elevate.qa.pages.LMSDashboard;
import com.elevate.qa.pages.LoginPage;
import com.elevate.qa.pages.ProgramsPage;
import com.elevate.qa.pages.TechCheckReportsPage;


public class LMSDashboardTest extends TestBase {
	
	LoginPage LoginPage;
	LMSDashboard LMSDashboard;
	TechCheckReportsPage TechCheckReportsPage;
	ProgramsPage ProgramsPage;
	Logger log = Logger.getLogger(LMSDashboardTest.class);
	
	public LMSDashboardTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		LoginPage = new LoginPage();
		LMSDashboard = LoginPage.adminLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyLMSDashboardTitleTest() {
		
		String LMSDashboardTitle = LMSDashboard.verifyLMSDashboardTitle();
		Assert.assertEquals(LMSDashboardTitle, "DailySessions");
	}
	
	@Test(priority=2)
	public void verifyHomeClickTest() {
		LMSDashboard.clickOnHomeLink();
		String HomePageTitle = driver.getTitle();
		Assert.assertEquals(HomePageTitle, "DailySessions");
	}
	
	@Test(priority=3)
	public void verifyGenesisClickTest() {
		LMSDashboard.clickOnGenesisLink();
		String GenesisPageTitle = driver.getTitle();
		Assert.assertEquals(GenesisPageTitle, "Elevate K12");
	}
	
	@Test(priority=4)
	public void verifyTechCheckUtilityClickTest() {
		
		LMSDashboard.clickOnTechCheckLink();
		String TechCheckTitle = driver.getTitle();
		Assert.assertEquals(TechCheckTitle, "FalconWeb", "Tech Check Click Failed");
	}
	
	@Test(priority=5)
	public void verifyProgramClickTest() {
		
		LMSDashboard.clickOnProgramLink();
		String ProgramTitle = driver.getTitle();
		Assert.assertEquals(ProgramTitle, "Elevate Learning - Learning programs", "Program Page Click Failed");
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();		
	}

}
