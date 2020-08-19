package com.elevate.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.elevate.qa.Base.TestBase;
import com.elevate.qa.util.TestUtil;

public class LMSDashboard extends TestBase {
	
	TestUtil TestUtil = new TestUtil();

	@FindBy(xpath="//a[contains(text(),'Home')]")
	WebElement HomeMenu;
	
	@FindBy(xpath="//a[contains(text(),'Projects')]")
	WebElement ProjectsMenu;
	
	@FindBy(xpath="//div[@id='menu']/ul/li[1]/ul/li/a")
	List <WebElement> HomeMenuList;
	
	@FindBy(xpath="//div[@id='menu']/ul/li[4]//ul/li/a")
	List <WebElement> ProjectMenuList;
	
	
	//Initializing Page Objects
	public LMSDashboard() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyLMSDashboardTitle() {
		return driver.getTitle();
	}
	
	public TechCheckReportsPage clickOnTechCheckLink() {
		
		TestUtil.expicitWaitVisibilityOfElement(driver, HomeMenu, 30);
		TestUtil.hoverOnItem(HomeMenu);
		
		int HomeMenuSize = HomeMenuList.size();
		TestUtil.expicitWaitVisibilityOfAllElements(driver, HomeMenuList, 30);
		
		try {
			for(int i=0;i<=HomeMenuSize;i++) {
				String HomeMenuItem = HomeMenuList.get(i).getText();
				if(HomeMenuItem.equalsIgnoreCase("Falcon")) {
					HomeMenuList.get(i).click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new TechCheckReportsPage();
	}
	
	public ProgramsPage clickOnProgramLink() {
		
		TestUtil.expicitWaitVisibilityOfElement(driver, ProjectsMenu, 30);
		TestUtil.hoverOnItem(ProjectsMenu);
		
		int ProjectMenuSize = ProjectMenuList.size();
		TestUtil.expicitWaitVisibilityOfAllElements(driver, ProjectMenuList, 30);
		
			for(int i=0;i<=ProjectMenuSize;i++) {
				String ProjectMenuItem = ProjectMenuList.get(i).getText();
				if(ProjectMenuItem.equalsIgnoreCase("Programs")) {
					ProjectMenuList.get(i).click();
					break;
				}
			}
		return new ProgramsPage();
	}
}
