package com.freecrm.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.freecrm.base.testBase;
import com.freecrm.util.testUtils;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class homePageTest extends testBase {
	
	public homePageTest() throws IOException {
		super();
	}
	
	
	@Test(priority = 5, groups = {"E2E"})
	public void openContactsTest() { // testing if opening the Contacts page works
		
		WebElement contacts = driver.findElement(By.xpath("//a[text()='Contacts']"));
		contacts.click();
		
		WebElement statusLabel = driver.findElement(By.xpath("//td[text()='Status']"));
		boolean actualResult = statusLabel.isDisplayed();
		Assert.assertTrue(actualResult, "This is not the Contacts page.");
		
	}
	
	@Test(priority = 6, groups = {"E2E"})
	public void openDealsTest() { // testing if opening the Deals page works
		
		WebElement deals = driver.findElement(By.xpath("//a[text()='Deals']"));
		deals.click();
		
		WebElement keywordLabel = driver.findElement(By.xpath("//td[text()='Keyword']"));
		boolean actualResult = keywordLabel.isDisplayed();
		Assert.assertTrue(actualResult, "This is not the Deals page.");
		
	}
	
	@Test(priority = 7, groups = {"E2E"})
	public void openTasksTest() { // testing if opening the Tasks page works
		
		WebElement tasks = driver.findElement(By.xpath("//a[text()='Tasks']"));
		tasks.click();
		
		WebElement keywordLabel = driver.findElement(By.xpath("//td[text()='Keyword']"));
		boolean actualResult = keywordLabel.isDisplayed();
		Assert.assertTrue(actualResult, "This is not the Tasks page.");
		
	}
	
	
	
	@Parameters({"browser"})
	@BeforeMethod(groups = {"E2E" , "Regression", "Sanity"})
	public void setUp(String browser, Method method) throws ATUTestRecorderException { // setting up the ChromeDriver and logging in before executing the test cases
		
		initialization(browser);
		// recording a video
		recorder = new ATUTestRecorder("D:\\Courses\\Udemy - Selenium Course\\AutomationFramework\\Videos", method.getName(), false);
		recorder.start();
		
		WebElement userNameTextBox = driver.findElement(By.name("username"));
		WebElement passwordTextBox = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
		userNameTextBox.sendKeys(prop.getProperty("userName"));
		passwordTextBox.sendKeys(prop.getProperty("password"));
		loginButton.click();
		
		driver.switchTo().frame("mainpanel");
		
	}
	
	@AfterMethod(groups = {"E2E" , "Regression", "Sanity"})
	public void shutDown(Method method) throws ATUTestRecorderException, IOException { // closing each opened browser page after executing the test cases
		recorder.stop();
		// taking a screenshot
		testUtils.takeScreenshot(method.getName());
		driver.quit();
	}

}
