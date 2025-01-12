package com.freecrm.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.freecrm.base.testBase;
import com.freecrm.util.testUtils;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class contactsPageTest extends testBase {

	public contactsPageTest() throws IOException {
		super();
	}
	
	@Test(priority = 8, groups = {"E2E", "Sanity"}, dataProvider = "testData")
	public void newContactTest(String fName, String lName, String companyName, String departmentName) { // testing adding a new contact
		
		WebElement contacts = driver.findElement(By.xpath("//a[text()='Contacts']"));
		Actions action = new Actions(driver);
		action.moveToElement(contacts).build().perform();
		
		WebElement newContact = driver.findElement(By.xpath("//a[text()='New Contact']"));
		newContact.click();
		
		WebElement firstNameTextBox = driver.findElement(By.name("first_name"));
		WebElement lastNameTextBox = driver.findElement(By.name("surname"));
		WebElement companyTextBox = driver.findElement(By.name("client_lookup"));
		WebElement departmentTextBox = driver.findElement(By.name("department"));
		WebElement saveButton = driver.findElement(By.xpath("//input[@value='Save']"));
		
		firstNameTextBox.sendKeys(fName);
		lastNameTextBox.sendKeys(lName);
		companyTextBox.sendKeys(companyName);
		departmentTextBox.sendKeys(departmentName);
		saveButton.click();
		
		WebElement modifiedLabel = driver.findElement(By.xpath("//strong[text()='Last modified']"));
		boolean actualResult = modifiedLabel.isDisplayed();
		Assert.assertTrue(actualResult, "New contact is not added.");
		
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
	
	@DataProvider
	public Object[][] testData() throws Throwable { // getting the test data from the excel file
		Object[][] data = testUtils.getDataFromExcel("contactsData");
		return data;
	}

}
