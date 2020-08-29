package com.elevate.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.elevate.qa.Base.TestBase;
import com.elevate.qa.util.TestUtil;

public class AddNewSchoolPage extends TestBase{
	
	public static String SCHOOLNAME;
	
	@FindBy(xpath="//div[contains(text(),'Add new school')]")
	WebElement AddNewSchoollabel;
	
	@FindBy(name="Code")
	WebElement Abbreviation;
	
	@FindBy(name="Name")
	WebElement Name;
	
	@FindBy(name="DistrictName")
	WebElement SchoolDistrict;
	
	@FindBy(name="Phone")
	WebElement Phone;
	
	@FindBy(name="Line1")
	WebElement AddressLine1;
	
	@FindBy(name="Line2")
	WebElement AddressLine2;
	
	@FindBy(name="countrySelect")
	WebElement CountryDropDown;
	
	@FindBy(name="ddState")
	WebElement StateDropDown;
	
	@FindBy(name="City")
	WebElement City;
	
	@FindBy(name="Zip")
	WebElement ZipCode;
	
	@FindBy(name="TimeZones")
	WebElement TimeZonesDropDown;
	
	@FindBy(name="selectProjectManager")
	WebElement ProjectManagerDropDown;
	
	@FindBy(id="save")
	WebElement CreateButton;
	
	@FindBy(id="cancel")
	WebElement CancelButton;
	
	@FindBy(xpath="//span[@htmlfor='Code']")
	WebElement CodeError;
	
	@FindBy(xpath="//span[@htmlfor='Name']")
	WebElement NameError;
	
	@FindBy(xpath="//span[@htmlfor='ddState']")
	WebElement StateError;
	
	
	public AddNewSchoolPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyAddNewSchoolPage() {
		boolean flag = AddNewSchoollabel.isDisplayed();
		return flag;
	}
	
	public SchoolDetailsPage fillSchoolCreationForm() {
		
		int i = TestUtil.randomNumberGenerator();
		
		Abbreviation.sendKeys("AC" + i);
		SCHOOLNAME = "Automation School " + i;
		Name.sendKeys(SCHOOLNAME);
		
		SchoolDistrict.sendKeys("Automation District " + i);
		Phone.sendKeys("9876543210");
		
		AddressLine1.sendKeys("Automation Address Line "+ i);
		AddressLine2.sendKeys("Automation Address Line "+ i);
		
		TestUtil.selectDropdown(CountryDropDown, "United States");
		TestUtil.selectDropdown(StateDropDown, "Alaska");
		
		City.sendKeys("Automation City "+ i);
		ZipCode.sendKeys("901010");
		
		TestUtil.selectDropdown(TimeZonesDropDown, "(UTC-05:00) Eastern Time (US & Canada)");
		TestUtil.selectDropdown(ProjectManagerDropDown, " Jack Reacher");		
		
		CreateButton.click();
		
		return new SchoolDetailsPage();
	}
	
	public SchoolsPage clickCancelButton() {
		CancelButton.click();
		return new SchoolsPage();
	}
	
	public boolean emptyFormCreateClick() {
		boolean flag; 
		CreateButton.click();
		
		boolean code = CodeError.isDisplayed();
		boolean name = NameError.isDisplayed();
		boolean state = StateError.isDisplayed();
		if(code==true&&name==true&&state==true) {
			System.out.println("All Error messages are displayed correctly");
			flag = true;
		}else {
			System.out.println("Error Messages are not displayed for Code OR Name OR State");
			flag = false;
		}
		return flag;
	}

}
