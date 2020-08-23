package com.elevate.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.elevate.qa.Base.TestBase;
import com.elevate.qa.util.TestUtil;

public class ProgramsPage extends TestBase {
	
	TestUtil testUtil = new TestUtil();
	
	
	@FindBy(xpath="//h4[@class='hBorderOrange']")
	WebElement ProgramLabel;
	
	@FindBy(xpath="//*[@id='mytable']/tbody/tr/td[3]/a")
	List <WebElement> ProgramsList;
	
	@FindBy(xpath="//a[@class='NextOneArrow']")
	WebElement NextPage;
	
	@FindBy(xpath="//a[@class='PrevtOneArrow']")
	WebElement PreviousArrow;
	
	
	public ProgramsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String programsPageTitle() {
		return driver.getTitle();
	}
	
	public String ProgramPageLabel() {
		return ProgramLabel.getText();
	}
	
	public void printProgramList() {
	
		testUtil.printTextFromTable(ProgramsList);
		NextPage.click();
		testUtil.expicitWaitVisibilityOfElement(driver, PreviousArrow, 30);
		testUtil.printTextFromTable(ProgramsList);	
	}
	public void readProgramListExcel() {
		
		int index = 0;
		String SheetName = "Program"; 
		String ColumnName1 = "Program Name";
		String ColumnName2 = "Tech Check Link";
		
		testUtil.expicitWaitVisibilityOfElement(driver, NextPage, 30);
		testUtil.copyTableDataToExcel(index, ProgramsList, SheetName, ColumnName1, ColumnName2);
		
		int j = ProgramsList.size();
		j = j+1;
		index = 0;
		
		NextPage.click();
		testUtil.expicitWaitVisibilityOfElement(driver, PreviousArrow, 30);
		
		int NewProgSize = j + ProgramsList.size() ;
		testUtil.copyTableDataToExcel2(j, NewProgSize, index, ProgramsList, SheetName, ColumnName1, ColumnName2);
		
	}
	
}
