package com.freecrm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.freecrm.base.testBase;

public class testUtils extends testBase {
	
	public testUtils() throws IOException {
		super();
	}

	public static void takeScreenshot(String name) throws IOException { // setting up the screenshot file
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("D:\\Courses\\Udemy - Selenium Course\\AutomationFramework\\Snapshots\\"+name+".png"));
		
	}
	
	public static Object[][] getDataFromExcel(String sheetName) throws Exception { // setting up the excel test data file
		
		File file = new File("D:\\Courses\\Udemy - Selenium Course\\AutomationFramework\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		
		int rows = sheet.getPhysicalNumberOfRows();
		int columns = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] data = new Object[rows][columns];
		
		for(int i=0 ; i<rows ; i++) {
			for (int k = 0 ; k<columns ; k++) {
				data[i][k] = sheet.getRow(i).getCell(k).toString();
			}
		}
		
		workbook.close();
		return data;
		
	}

}
