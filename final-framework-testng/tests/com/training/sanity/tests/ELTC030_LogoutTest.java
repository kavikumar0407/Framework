package com.training.sanity.tests;

import java.io.IOException;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.training.pom.ELTC030_LogoutTestPOM;

public class ELTC030_LogoutTest extends InitializeTest {
	
	private ELTC030_LogoutTestPOM logoutTestPOM;
	
  @Test
  public void clickOnRecordDropdown() throws InterruptedException {
	  dateNow = new Date();
		 DateTime = df.format(dateNow);
		 DateTimeCode = df2.format(dateNow);
	  logoutTestPOM = new ELTC030_LogoutTestPOM(driver);
	  
	  //Click on the dropdown button
	 //Verify that the menu options are shown
	  
	  logger = report.createTest("ELTC030 - Click on record dropdown to get Logout option");
	  Thread.sleep(3000);
	  System.out.println("goign to click drodown");
	  logoutTestPOM.clickRecordDropdown();
	  Thread.sleep(3000);
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
	  logger.addScreenCaptureFromPath(screenShot.captureScreenShot("/Reports"+DateTimeFix+"/Screenshots/"+result.getName()+DateTimeFix));
			
		report.flush();
		
	}

  
}
