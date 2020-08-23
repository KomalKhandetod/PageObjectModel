package com.elevate.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.elevate.qa.Base.TestBase;
import com.elevate.qa.pages.LMSDashboard;
import com.elevate.qa.pages.LoginPage;
import com.elevate.qa.pages.ProgramsPage;

public class ProgramsPageTest extends TestBase{
	
	LoginPage loginPage;
	LMSDashboard lMSDashboard;
	ProgramsPage programsPage;
	
	public ProgramsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		lMSDashboard = new LMSDashboard();
		programsPage = new ProgramsPage();
		lMSDashboard = loginPage.adminLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyProgramPageTitleTest() {
		lMSDashboard.clickOnProgramLink();
		String ProgramPageTitle = driver.getTitle();
		Assert.assertEquals(ProgramPageTitle, "Elevate Learning - Learning programs");
	}
	
	@Test(priority=2)
	public void verifyProgramPageLabelTest() {
		lMSDashboard.clickOnProgramLink();
		String ProgramPageLabelText = programsPage.ProgramPageLabel();
		Assert.assertEquals(ProgramPageLabelText, "School Programs");
	}
	
	@Test(priority=3)
	public void verifyProgramsList() {
		lMSDashboard.clickOnProgramLink();
		programsPage.printProgramList();
		Assert.assertTrue(true);
	}
	
	@Test(priority=4)
	public void verifyEnterProgramListToExcelTest() {
		lMSDashboard.clickOnProgramLink();
		programsPage.readProgramListExcel();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();		
	}

}
