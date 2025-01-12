package com.freecrm.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import com.freecrm.util.WebListener;
import atu.testrecorder.ATUTestRecorder;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriver e_driver;
	public static WebDriverListener webListener;
	public static ATUTestRecorder recorder;
	
	public testBase() throws IOException { // setting up the config.properties file
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Courses\\Udemy - Selenium Course\\AutomationFramework\\src\\com\\freecrm\\config\\config.properties");
		prop.load(fis);
		
	}
	
	@SuppressWarnings("deprecation")
	public void initialization(String browser) { // setting up the ChromeDriver before executing the test cases
		
		// setting up the browser type
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			e_driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			e_driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
		    WebDriverManager.edgedriver().setup();
		    e_driver = new EdgeDriver();
		}
		else {
		    throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
		
		webListener = new WebListener();
		driver = new EventFiringDecorator<>(webListener).decorate(e_driver);
		
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
}
