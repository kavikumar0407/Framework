package com.training.sanity.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.training.pom.RemoveClassesPOM;

public class RemoveClasses extends InitializeTest{
	
	private RemoveClassesPOM removeClassesPOM;
	
	
  @Test
  public void clickOnDeleteButton() throws InterruptedException {
	  System.out.println("Inside delete");
	  removeClassesPOM = new RemoveClassesPOM(driver);
	  // Locate the class in the link and click on delete
	  logger = report.createTest("Delete the created class");
	 // removeClassesPOM.clickNameSortHeaderInDeleteView();
	  
	  removeClassesPOM.clickOnDeleteButton(storedClassName);
	  
	  //This method will accept the alert that is thrown by the application
	  removeClassesPOM.acceptAlert();
	  Thread.sleep(2000);
	  removeClassesPOM.clickNameSortHeaderInDeleteView();
	  Assert.assertTrue(removeClassesPOM.confirmIfClassDeleted(storedClassName));
  }
  
  @AfterMethod
	public void teardown(ITestResult result) throws IOException {
		
		//Adds info about the status of the test case in ExtentReports html.
	  if(result.getStatus()==1)
			logger.pass("The status of " + result.getName() +" is PASS");
	      
			else
				logger.fail("The status of " + result.getName() +"  FAIL");
	  
		// Takes screenshot and saves it with the name of the @Test method
	  logger.addScreenCaptureFromPath(screenShot.captureScreenShot("/Reports"+DateTime+"/Screenshots/"+result.getName()+DateTime));
		
		report.flush();
		
	}
  
}
