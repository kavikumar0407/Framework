package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests extends InitializeTest{

		
	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		screenShot = new ScreenShot(driver);
		
		// Get current date and time to be used for Extent Reports folder creation
		df = new SimpleDateFormat("dd-MM-yy_HH-mm");  
		dateNow = new Date();
		DateTime = df.format(dateNow);
		
		
		//Set up Extent Reports
		htmlReporter = new ExtentHtmlReporter("C:/Users/KAVITAKUMAR/Desktop/Elearning/Reports"+DateTime+"/SeleniumTest_" + DateTime + ".html");
	
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		
		// open the browser 
		driver.get(baseUrl);
	}

	
	@Test()
	public void validLoginTest(){
		
		logger = report.createTest("Log into ELearning website");
		
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		
	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		
		//Adds info about the status of the test case in ExtentReports html.
		if(result.getStatus()==1)
			logger.pass("The status of " + result.getName() +" is PASS");
			else
				logger.fail("The status of " + result.getName() +"  FAIL");
	  
		// Takes screenshot and saves it with the name of the @Test method
		
		logger.addScreenCaptureFromPath(screenShot.captureScreenShot("Reports"+DateTime+"/Screenshots/"+result.getName()+DateTime));
		
		report.flush();
		
	}
}
