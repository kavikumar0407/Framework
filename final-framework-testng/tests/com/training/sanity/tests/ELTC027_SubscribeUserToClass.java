package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.pom.ELTC027_SubscribeUserToClassPOM;

import java.io.IOException;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;


public class ELTC027_SubscribeUserToClass extends InitializeTest{
	
	private ELTC027_SubscribeUserToClassPOM subscribeUserToClassPOM ;
	
		
  @Test
  public void clickonSubscribeUserButton() throws InterruptedException {
	 
	  subscribeUserToClassPOM = new ELTC027_SubscribeUserToClassPOM (driver);
	  dateNow = new Date();
		 DateTime = df.format(dateNow);
		 DateTimeCode = df2.format(dateNow);
	  logger = report.createTest("ELTC027 - Click on subscribe user to class button");
	 
	// Click Name header for sorting
	   subscribeUserToClassPOM.clickNameSortHeader();
	   
	   //Pass the stored class name to this method
	   // It will look for all the td elements with this title
	   // for loop created in POM to select the correct record and go to it's following-sibling and click the subscribe button
	   System.out.println("what" + ClassName);
	  subscribeUserToClassPOM.findClassInList(ClassName);
	  
	  Assert.assertTrue(subscribeUserToClassPOM.confirmSubscribeUsersButtonClicked());
	  
  }
  
  @Test (dependsOnMethods = {"clickonSubscribeUserButton"})
  public void selectUsers()
  {
	  logger = report.createTest("ELTC027 - Select 2 user records to be added ");
	  // This method will select 2 users. Actions keydown CNTRL has been used for this
	  subscribeUserToClassPOM.selectUsersFromList();
	  
	  //This will click the arrow pointing to right to move the selected users in the next window.
	  subscribeUserToClassPOM.clickArrow();
	  
	  // confirm if both users are selected and moved
	  Assert.assertTrue(subscribeUserToClassPOM.confirmIfUsersInGroupAreAdded());
  }
  
  @Test (dependsOnMethods = {"selectUsers"})
  public void subscribeUsersToClass() throws InterruptedException {
	  logger = report.createTest("ELTC027 - Click on subscribe button to subscribe users");
	  
	  // Selected users need to be subscribed by clicking on the button
	  subscribeUserToClassPOM.clickOnSubscribeButton();
	  
	//Sort the titles 
	  subscribeUserToClassPOM.clickNameSortHeader();
	  
	  // Assert will check if the count of users against the class name have been increased
	  Assert.assertTrue(subscribeUserToClassPOM.confirmUsersSubscribedToClass(ClassName));
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
