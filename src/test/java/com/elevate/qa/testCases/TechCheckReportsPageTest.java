package com.elevate.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.elevate.qa.pages.TechCheckReportsPage;

public class TechCheckReportsPageTest {
	
	public TechCheckReportsPageTest() {
		super();
	}
	
	TechCheckReportsPage TechCheckReportsPage;	
	
	
	@BeforeMethod
	public void setup() {
		TechCheckReportsPage = new TechCheckReportsPage();		
	}
	
	@Test(priority=1)
	public void VerifySwitchPortalClickTest() {
		TechCheckReportsPage.techCheckLogin();
		TechCheckReportsPage.clickOnSwitchPotal();	
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();		
	}

}
