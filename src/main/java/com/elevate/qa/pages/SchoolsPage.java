package com.elevate.qa.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.elevate.qa.Base.TestBase;
import com.elevate.qa.util.TestUtil;

public class SchoolsPage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'Schools')]")
	WebElement SchoolsLabel;
	
	@FindBy(xpath="//img[@alt='Add']")
	WebElement AddSchool;
	
	@FindBy(name="txtSearchByName")
	WebElement SchoolNameSearch;
	
	@FindBy(xpath="//button[@id='submitsearch']")
	WebElement SchoolSearch;
	
	@FindBy(xpath="//a[@title='View school details']")
	WebElement ResultSchoolName;
	
	@FindBy(xpath="//img[@title='Delete school']")
	WebElement DeleteSchoolIcon;
	
	@FindBy(xpath="//input[@name='btnOk']")
	WebElement ConfirmDelete;
	
	TestUtil testUtil = new TestUtil();
	AddNewSchoolPage addNewSchoolPage = new AddNewSchoolPage();
	LMSDashboard lMSDashboard = new LMSDashboard();
	
	public SchoolsPage() {
		PageFactory.initElements(driver, this);
	}
	

	public boolean schoolsLabel() {
		boolean flag = SchoolsLabel.isDisplayed();
		return flag;
	}
	
	public AddNewSchoolPage createNewSchool() {
		testUtil.expicitWaitVisibilityOfElement(driver, AddSchool, 30);
		AddSchool.click();		
		addNewSchoolPage.fillSchoolCreationForm();
		return new AddNewSchoolPage();
	}
	
	public String searchSchoolByName(String SchoolName) throws InterruptedException {
		lMSDashboard.clickOnSchoolLink();
		testUtil.expicitWaitVisibilityOfElement(driver, SchoolNameSearch, 30);
		SchoolNameSearch.sendKeys(SchoolName);
		SchoolSearch.click();
		//testUtil.expicitWaitVisibilityOfElement(driver, ResultSchoolName, 30);
		Thread.sleep(10000);
		String ResultSchool = ResultSchoolName.getText();
		return ResultSchool;
	}
	
	public String deleteSchool(String DeleteSchoolName) throws InterruptedException {
		
		//String FoundSchool = searchSchoolByName(DeleteSchoolName);
		String FoundSchool = ResultSchoolName.getText();
		
		if(FoundSchool.equalsIgnoreCase(DeleteSchoolName)) {
			DeleteSchoolIcon.click();
			testUtil.expicitWaitVisibilityOfElement(driver, ConfirmDelete, 30);
			ConfirmDelete.click();
			Thread.sleep(10000);	
		}
		
		String DeletedSchoolName = "School Deleted";
		try {
			DeletedSchoolName = searchSchoolByName(DeleteSchoolName);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return DeletedSchoolName;
		
		
		// //table[@id='mytable']//tr[2]/td[1]/a/img[@title='Delete school']
		/*
		 * if(DeleteSchoolName==AddNewSchoolPage.SCHOOLNAME) { DeleteSchoolIcon.click();
		 * } else { System.out.println("School not found"); }
		 */
	}

	
}
