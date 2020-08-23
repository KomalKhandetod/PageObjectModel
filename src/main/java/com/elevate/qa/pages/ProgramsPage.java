package com.elevate.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.elevate.qa.Base.TestBase;
import com.elevate.qa.util.TestUtil;
import com.elevate.qa.util.Xls_Reader;

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
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\komal\\eclipse-workspace\\POMFunctional\\src\\main\\java\\com\\elevate\\qa\\testData\\ProgramList.xlsx");
		
		if(!(reader.isSheetExist("Program")==true)) {
			reader.addSheet("Program");
			reader.addColumn("Program", "Program Name");
			reader.addColumn("Program", "Tech Check Link");
		}else {
			reader.removeColumn("Program", 0);
			reader.removeColumn("Program", 1);
			reader.addColumn("Program", "Program Name");
			reader.addColumn("Program", "Tech Check Link");
		}
		
		int index = 0;
		try {
			for(int i=2; i<=ProgramsList.size(); i++) {
				
				String ListItem = ProgramsList.get(index).getText();
				System.out.println(ListItem);
				reader.setCellData("Program", "Program Name", i, ListItem);
				index++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int j = ProgramsList.size();
		
		NextPage.click();
		testUtil.expicitWaitVisibilityOfElement(driver, PreviousArrow, 30);
		
		int ProgSize = j + ProgramsList.size() ;
		
		int index1 = 0;
		try {
			for(int k=j+1; k<=ProgSize; k++) {
				
				String ListItem = ProgramsList.get(index1).getText();
				System.out.println(ListItem);
				reader.setCellData("Program", "Program Name", k, ListItem);
				index1++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
