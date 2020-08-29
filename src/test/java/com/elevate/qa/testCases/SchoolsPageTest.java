package com.elevate.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.elevate.qa.Base.TestBase;
import com.elevate.qa.pages.AddNewSchoolPage;
import com.elevate.qa.pages.LMSDashboard;
import com.elevate.qa.pages.LoginPage;
import com.elevate.qa.pages.SchoolDetailsPage;
import com.elevate.qa.pages.SchoolsPage;

public class SchoolsPageTest extends TestBase{
	
	LoginPage loginPage;
	LMSDashboard lMSDashboard;
	SchoolsPage schoolsPage;
	SchoolDetailsPage schoolDetailsPage;
	
	public SchoolsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		lMSDashboard = new LMSDashboard();
		lMSDashboard = loginPage.adminLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifySchoolPageLandingTest() {
		schoolsPage = lMSDashboard.clickOnSchoolLink();
		String SchoolPageTitle = driver.getTitle();
		Assert.assertEquals(SchoolPageTitle, "Elevate Learning - Schools");
		Assert.assertTrue(schoolsPage.schoolsLabel());
	}
	
	@Test(priority=2)
	public void verifyNewSchoolCreationTest() throws InterruptedException {
		schoolsPage = lMSDashboard.clickOnSchoolLink();
		schoolsPage.createNewSchool();
		String SchoolDetailTitle = driver.getTitle();
		Assert.assertEquals(SchoolDetailTitle, "School Details");
		System.out.println("School Name for this Test is : " + AddNewSchoolPage.SCHOOLNAME);
		
		String resultSchoolName = schoolsPage.searchSchoolByName(AddNewSchoolPage.SCHOOLNAME);
		String DeletedSchoolName = schoolsPage.deleteSchool(resultSchoolName);
		System.out.println(DeletedSchoolName);
	}
	
	@Test(priority=3)
	public void verifySearchBySchoolNameTest() throws InterruptedException {
		schoolsPage = lMSDashboard.clickOnSchoolLink();
		schoolsPage.createNewSchool();
		String resultSchoolName = schoolsPage.searchSchoolByName(AddNewSchoolPage.SCHOOLNAME);
		Assert.assertEquals(resultSchoolName, AddNewSchoolPage.SCHOOLNAME);
		
		String DeletedSchool = schoolsPage.deleteSchool(resultSchoolName);
		System.out.println(DeletedSchool);
	}
	
	@Test(priority=4)
	public void verifyDeleteSchoolTest() throws InterruptedException {
		schoolsPage = lMSDashboard.clickOnSchoolLink();
		schoolsPage.createNewSchool();
		
		String resultSchoolName = schoolsPage.searchSchoolByName(AddNewSchoolPage.SCHOOLNAME);
		System.out.println("School to be deleted is : " + resultSchoolName);
		
		String DeletedSchool = schoolsPage.deleteSchool(resultSchoolName);
		Assert.assertEquals(DeletedSchool, "School Deleted");
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
