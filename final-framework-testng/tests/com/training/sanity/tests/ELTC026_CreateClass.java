package com.training.sanity.tests;

import org.testng.annotations.Test;
import com.training.pom.ELTC026_CreateClassPOM;

import java.io.IOException;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;


public class ELTC026_CreateClass extends InitializeTest{
	
	private ELTC026_CreateClassPOM createClassPOM ;
	
	
  @Test
  public void clickAdminTab() {
	  dateNow = new Date();
		 DateTime = df.format(dateNow);
		 DateTimeCode = df2.format(dateNow);
	  createClassPOM = new ELTC026_CreateClassPOM(driver);
		
	//Create new test case in extent reports	
		logger = report.createTest("ELTC026 - Click on Admin Tab");
   // Click on Admin tab	  
	  createClassPOM.clickAdminTab();
	  Assert.assertTrue(createClassPOM.confirmAdminTabOpened());
  }
  
  @Test(dependsOnMethods = {"clickAdminTab"})
  public void clickOnClassLink()
  {
	//Create new test case in extent reports	
			logger = report.createTest("ELTC026 - Click on Class Link");
	  // Click on class link to navigate to display the list of classes
	  logger = report.createTest("Click on Class link and navigate to list of classes view");
	  createClassPOM.clickClassLink();
	  Assert.assertTrue(createClassPOM.confirmClassLinkClicked());
	  
  }
  
  @Test(dependsOnMethods = {"clickOnClassLink"})
  public void clickOnAddButton()
  {
	//Create new test case in extent reports	
			logger = report.createTest("ELTC026 - Click on Add Button");
	  
	  // Click on image to open the new class creation form
	  createClassPOM.clickAddClassButton();
	  Assert.assertTrue(createClassPOM.confirmAddClassClicked());
  }
  
  
  @Test(dependsOnMethods = {"clickOnAddButton"})
  public void enterClassDetails() throws InterruptedException
   {
	//Create new test case in extent reports	
	logger = report.createTest("ELTC026 - Enter the class details");
	 Thread.sleep(3000);
	  // Create new class by entering details. Used DateTime string which holds the current Date and time for clarity purposes.
	  createClassPOM.sendClassName("1demo_Kavita_" + DateTime);
	  logger.info("Class name is entered");
	  ClassName = createClassPOM.storeClassName();
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
	  logger.addScreenCaptureFromPath(screenShot.captureScreenShot("/Reports"+DateTimeFix+"/Screenshots/"+result.getName()+DateTimeFix));
		
		report.flush();
		
	}
  
  
	  
}