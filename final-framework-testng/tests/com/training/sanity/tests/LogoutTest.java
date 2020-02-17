package com.training.sanity.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.training.pom.LogoutTestPOM;

public class LogoutTest extends InitializeTest {
	
	private LogoutTestPOM logoutTestPOM;
	
  @Test
  public void clickOnRecordDropdown() throws InterruptedException {
	  
	  logoutTestPOM = new LogoutTestPOM(driver);
	  
	  //Click on the dropdown button
	 //Verify that the menu options are shown
	  
	  logger = report.createTest("Click on record dropdown to get Logout option");
	  Thread.sleep(3000);
	  System.out.println("goign to click drodown");
	  logoutTestPOM.clickRecordDropdown();
	  Assert.assertTrue(logoutTestPOM.confirmMenuOptionsVisible());
  }
  
  @Test (dependsOnMethods = {"clickOnRecordDropdown"})
  public void clickLogoutButoon()
  {
	logger = report.createTest("Click on Logout button");
	 // choose Logout option
	  //Will be directed back to Login page.
	
	logoutTestPOM.clickLogoutButton();
	
	Assert.assertTrue(logoutTestPOM.confirmLogoutSuccessful());
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
