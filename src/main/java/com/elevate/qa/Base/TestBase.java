package com.elevate.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.elevate.qa.util.TestUtil;
import com.elevate.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	//Create Constructor of TestBase Class to read properties from config.properties
	public TestBase(){
		//Establish connection between TestBase Class and config.properties
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\komal\\eclipse-workspace\\ElevateK12\\src\\main\\java\\com\\elevate\\qa\\config\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
				
	}
	
	public static void initialization() {
		
		String browser = prop.getProperty("browser");
		
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver = new ChromeDriver();			
		}else if(browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else {
			System.out.println("No browser specified");
		}
		
		
		//WebEvent Listner Logic
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));	
	}

}
