package com.freecrm.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.freecrm.base.testBase;
import com.freecrm.util.testUtils;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class loginPageTest extends testBase {
	
	public loginPageTest() throws IOException {
		super();
	}
	
	
	@Test(priority = 1, groups = {"E2E"})
	public void titleTest() { // testing if the page's title is correct
		
		String expectedResult = "Free CRM software for customer relationship management, sales, and support.";
		String actualResult = driver.getTitle();
		Assert.assertEquals(actualResult, expectedResult, "The title is incorrect.");
		
	}
	
	@Test(priority = 2, groups = {"E2E"})
	public void urlTest() { // testing if the page's URL is correct
		
		String expectedResult = "https://classic.freecrm.com/index.html";
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(actualResult, expectedResult, "The URL is incorrect.");
		
	}
	
	@Test(priority = 3, groups = {"E2E", "Sanity"})
	public void logoTest() { // testing if the page's LOGO is displayed
				
		WebElement logo = driver.findElement(By.xpath("//img[@src='https://classic.freecrm.com/img/logo@2x.png']"));
		
		boolean actualResult = logo.isDisplayed();
		Assert.assertTrue(actualResult, "The logo is not displayed.");
		
	}
	
	@Test(priority = 4, groups = {"E2E" , "Regression"})
	public void loginTest() { // testing if the Login function works
		
		WebElement userNameTextBox = driver.findElement(By.name("username"));
		WebElement passwordTextBox = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
		userNameTextBox.sendKeys(prop.getProperty("userName"));
		passwordTextBox.sendKeys(prop.getProperty("password"));
		loginButton.click();
		
		String expectedResult = "CRMPRO";
		String actualResult = driver.getTitle();
		Assert.assertEquals(actualResult, expectedResult, "Username or password is incorrect.");
		
	}
	
	
	@Parameters({"browser"})
	@BeforeMethod(groups = {"E2E" , "Regression", "Sanity"})
	public void setUp(String browser, Method method) throws ATUTestRecorderException { // setting up the ChromeDriver before executing the test cases
		initialization(browser);
		// recording a video
		recorder = new ATUTestRecorder("D:\\Courses\\Udemy - Selenium Course\\AutomationFramework\\Videos", method.getName(), false);
		recorder.start();
	}
	
	@AfterMethod(groups = {"E2E" , "Regression", "Sanity"})
	public void shutDown(Method method) throws ATUTestRecorderException, IOException { // closing each opened browser page after executing the test cases
		recorder.stop();
		// taking a screenshot
		testUtils.takeScreenshot(method.getName());
		driver.quit();
	}

}
