package com.elevate.qa.util;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.elevate.qa.Base.TestBase;

public class TestUtil extends TestBase {

	public static final long PAGE_LOAD_TIMEOUT = 40;
	public static final long IMPLICIT_WAIT = 30;
	public static final long EXPLICIT_WAIT = 30;
	
	public void hoverOnItem(WebElement MenuLocation) {
		Actions act = new Actions(driver);
		act.moveToElement(MenuLocation).build().perform();
	}
	
	public void expicitWaitVisibilityOfElement(WebDriver driver, WebElement Element, int Seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Seconds);
		wait.until(ExpectedConditions.visibilityOf(Element));
	}
	
	public void expicitWaitVisibilityOfAllElements(WebDriver driver,List <WebElement> ElementList, int Seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Seconds);
		wait.until(ExpectedConditions.visibilityOfAllElements(ElementList));
	}
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		 
	}
	
	public void printTextFromTable(List <WebElement> List) {
		
		try {
			for(int i=0;i<List.size();i++) {
				String ListItem = List.get(i).getText();
				System.out.println(ListItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
