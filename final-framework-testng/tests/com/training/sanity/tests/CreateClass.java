package com.training.sanity.tests;

import org.testng.annotations.Test;
import com.training.pom.CreateClassPOM;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;


public class CreateClass extends InitializeTest{
	
	private CreateClassPOM createClassPOM ;
	
	
  @Test
  public void clickAdminTab() {
	  
	  createClassPOM = new CreateClassPOM(driver);
		
	//Create new test case in extent reports	
		logger = report.createTest("Click on Admin Tab");
   // Click on Admin tab	  
	  createClassPOM.clickAdminTab();
	  Assert.assertTrue(createClassPOM.confirmAdminTabOpened());
  }
  
  @Test(dependsOnMethods = {"clickAdminTab"})
  public void clickOnClassLink()
  {
	//Create new test case in extent reports	
			logger = report.createTest("Click on Class Link");
	  // Click on class link to navigate to display the list of classes
	  logger = report.createTest("Click on Class link and navigate to list of classes view");
	  createClassPOM.clickClassLink();
	  Assert.assertTrue(createClassPOM.confirmClassLinkClicked());
	  
  }
  
  @Test(dependsOnMethods = {"clickOnClassLink"})
  public void clickOnAddButton()
  {
	//Create new test case in extent reports	
			logger = report.createTest("Click on Add Button");
	  
	  // Click on image to open the new class creation form
	  createClassPOM.clickAddClassButton();
	  Assert.assertTrue(createClassPOM.confirmAddClassClicked());
  }
  
  
  @Test(dependsOnMethods = {"clickOnAddButton"})
  public void enterClassDetails() throws InterruptedException
   {
	//Create new test case in extent reports	
	logger = report.createTest("Enter the class details");
	 Thread.sleep(3000);
	  // Create new class by entering details. Used DateTime string which holds the current Date and time for clarity purposes.
	  createClassPOM.sendClassName("demo_Kavita_" + DateTime);
	  logger.info("Class name is entered");
	  storedClassName = createClassPOM.storeClassName();
	  createClassPOM.sendClassDesc("demo");
	  logger.info("Description is entered");
	  createClassPOM.selectGroupPermissions("Open");
	  logger.info("Goup Permission dropdown is selected");
	  createClassPOM.clickAddToCreateNewClass();
	  logger.info("Add class button is clicked");
	  Assert.assertTrue(createClassPOM.confirmNewClassCreated().contains("Item added"));
	  
	  
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