package com.training.sanity.tests;

import java.io.IOException;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.training.pom.ELTC056_SubscribeUsersCoursesToSessionsPOM;

public class ELTC056_SubscribeUsersCoursesToSessions extends InitializeTest{
 
	ELTC056_SubscribeUsersCoursesToSessionsPOM subscribeUsersCoursesToSessionsPOM;
	
  @Test
  public void clickOnAdminTab() throws InterruptedException 
  {
	  subscribeUsersCoursesToSessionsPOM = new ELTC056_SubscribeUsersCoursesToSessionsPOM(driver);
	  dateNow = new Date();
		 DateTime = df.format(dateNow);
		 DateTimeCode = df2.format(dateNow);
	  logger = report.createTest("ELTC056 - Click on Admin tab");
	  
	  // Click on Admin Tab
	  subscribeUsersCoursesToSessionsPOM.clickOnAdminTabButton();
	  Assert.assertTrue(subscribeUsersCoursesToSessionsPOM.confirmAdminTabClicked());
	  
	  
  }
  
  @Test (dependsOnMethods = {"clickOnAdminTab"})
  public void clickOnSessionsCategoriesListLink() throws InterruptedException
  {
	  logger = report.createTest("ELTC056 - Click on Sessions Categories List Link");
	  // Click on Sessions Categories List
	  // Closing the Alert as sometimes the click is getting interesected
	  Thread.sleep(2000);
	  subscribeUsersCoursesToSessionsPOM.clickOnCloseAlert();
	  Thread.sleep(1000);
	   System.out.println("Ready to click");
	  subscribeUsersCoursesToSessionsPOM.clickOnSessionsCategoriesListLink();
	  Assert.assertTrue(subscribeUsersCoursesToSessionsPOM.confirmDataTableVisible());
			 
  }  
	 
  @Test (dependsOnMethods = {"clickOnSessionsCategoriesListLink"})
  public void clickOnTrainingSessionsListIcon() 
  {
	  logger = report.createTest("ELTC056 - Click On Training Sessions List Icon");
	  //Click on Training Session List Icon
	  subscribeUsersCoursesToSessionsPOM.clickOnTrainingSessionsListIcon();
	  Assert.assertTrue(subscribeUsersCoursesToSessionsPOM.confirmSessionsListDisplayed());
 }
	  
  @Test (dependsOnMethods = {"clickOnTrainingSessionsListIcon"})
  public void selectUserAndSubscribeUserToSession() throws InterruptedException 
  {
	  logger = report.createTest("ELTC056 - Select User And SubscribeUser To Session");
	  //Navigate to pre-created session. The steps to create a new session not listed under this testcase.
	  Thread.sleep(2000);
	  subscribeUsersCoursesToSessionsPOM.sendTextToSearchInputBox(storedSessionName);
	  subscribeUsersCoursesToSessionsPOM.clickOnSearchSubmitButton();
	  logger.log(Status.INFO, "Searched for session created before");
	  Thread.sleep(2000);
	  // Close Search Box widget as it might interfere with the click
	  subscribeUsersCoursesToSessionsPOM.clickOnCloseButtonOnSearchWidget();
	  logger.log(Status.INFO, "Closed the Search Widget");
	  
	// Click On subscribe user to session icon
		  subscribeUsersCoursesToSessionsPOM.clickOnSubscribeUserToSessionIcon();
		  
    // enter 'sunil' in search text input box
	 subscribeUsersCoursesToSessionsPOM.enterUserInSearchTextArea("kumar sunil");
	 // Select the option from the list displayed
	 Thread.sleep(2000);
	 subscribeUsersCoursesToSessionsPOM.selectUserFromList();  
	 subscribeUsersCoursesToSessionsPOM.clickOnNextButton();
	 
	 Assert.assertTrue(subscribeUsersCoursesToSessionsPOM.confirmUserAddedSuccessfully());
		  
	 
  }
  
  @Test (dependsOnMethods = {"selectUserAndSubscribeUserToSession"})
  public void selectAndAddCourseToSession() throws InterruptedException 
  {

	  logger = report.createTest("ELTC056 - Select User And Subscribe User To Session");
	  subscribeUsersCoursesToSessionsPOM.clickOnSessionsListLink();
	  
	  //Navigate to pre-created session
	  subscribeUsersCoursesToSessionsPOM.sendTextToSearchInputBox(storedSessionName);
	  subscribeUsersCoursesToSessionsPOM.clickOnSearchSubmitButton();
	  logger.log(Status.INFO, "Searched for session created before");
	  Thread.sleep(2000);
	  // Close Search Box
	  subscribeUsersCoursesToSessionsPOM.clickOnCloseButtonOnSearchWidget();
	  logger.log(Status.INFO, "Closed the Search Widget");
	  
	  // subscribe the selected course to the session.
	  subscribeUsersCoursesToSessionsPOM.clickOnSubscribeCourseToSessionIcon();
	  subscribeUsersCoursesToSessionsPOM.selectCoursesToBeAdded();
	  Thread.sleep(2000);
	  subscribeUsersCoursesToSessionsPOM.clickOnAddCourseButton();
	  subscribeUsersCoursesToSessionsPOM.clickOnNextButton();
	 
	  
	  Assert.assertTrue(subscribeUsersCoursesToSessionsPOM.confirmCoursesAddedSuccessfully());
	  
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
