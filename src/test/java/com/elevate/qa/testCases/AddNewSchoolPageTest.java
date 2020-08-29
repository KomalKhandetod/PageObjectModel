package com.elevate.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.elevate.qa.Base.TestBase;
import com.elevate.qa.pages.AddNewSchoolPage;
import com.elevate.qa.pages.LMSDashboard;
import com.elevate.qa.pages.LoginPage;
import com.elevate.qa.pages.SchoolsPage;

public class AddNewSchoolPageTest extends TestBase{
	
	LoginPage loginPage;
	LMSDashboard lMSDashboard;
	SchoolsPage schoolsPage;
	AddNewSchoolPage addNewSchoolPage;
	
	public AddNewSchoolPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		lMSDashboard = new LMSDashboard();
		schoolsPage = new SchoolsPage();
		addNewSchoolPage = new AddNewSchoolPage();
		lMSDashboard = loginPage.adminLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test (priority=1)
	public void verifyAddNewSchoolPageLandingTest() {
		lMSDashboard.clickOnSchoolLink();
		schoolsPage.createNewSchoolClick();
		String AddNewSchoolPageTitle =  driver.getTitle();
		Assert.assertEquals(AddNewSchoolPageTitle, "CreateSchool");
		boolean flag = addNewSchoolPage.verifyAddNewSchoolPage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void verifyCancelButtonTest() {
		lMSDashboard.clickOnSchoolLink();
		schoolsPage.createNewSchoolClick();
		addNewSchoolPage.clickCancelButton();
		String PageTitle = driver.getTitle();
		Assert.assertEquals(PageTitle, "Elevate Learning - Schools");
	}
	
	@Test(priority=3)
	public void verifyEmptyFormSubmitTest() {
		lMSDashboard.clickOnSchoolLink();
		schoolsPage.createNewSchoolClick();
		boolean flag = addNewSchoolPage.emptyFormCreateClick();
		Assert.assertTrue(flag);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();		
	}

}
