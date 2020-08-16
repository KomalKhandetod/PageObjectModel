package com.elevate.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.elevate.qa.Base.TestBase;
import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TechCheckReportsPage extends TestBase {
	
	NgWebDriver ngWebDriver;
	JavascriptExecutor jsDriver;
	
	ByAngularButtonText SwitchPortal = ByAngular.buttonText("Switch Portal");
	
	public TechCheckReportsPage() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		jsDriver = (JavascriptExecutor)driver;
		ngWebDriver = new NgWebDriver(jsDriver);
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://falconuat.portalelevate.com/tech-check/list");
		ngWebDriver.waitForAngularRequestsToFinish();
	}
	
	//Normal_method
	public void techCheckLogin() {
		driver.findElement(By.name("Username")).sendKeys("Administrator");
		driver.findElement(By.name("Password")).sendKeys("Q!A@z3w4");
		driver.findElement(By.name("action")).click();
		ngWebDriver.waitForAngularRequestsToFinish();
		System.out.println(driver.getTitle());
	}
	//angular_method
	public void clickOnSwitchPotal() {
		ngWebDriver.waitForAngularRequestsToFinish();
		driver.findElement(SwitchPortal).click();
		ngWebDriver.waitForAngularRequestsToFinish();
		System.out.println(driver.getTitle());
	}
}
