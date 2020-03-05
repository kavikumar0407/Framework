package com.training.sanity.tests;

import java.io.IOException;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import com.training.pom.ELTC060_CreateUserSubscribeUserToClassPOM;

public class ELTC060_CreateUserSubscribeUserToClass extends InitializeTest{
	
	ELTC060_CreateUserSubscribeUserToClassPOM createUserSubscribeUserToClassPOM;
	

	 @Test
	  public void clickOnAdminTab() throws InterruptedException 
	  {
		 dateNow = new Date();
		 DateTime = df.format(dateNow);
		 DateTimeCode = df2.format(dateNow);
		 createUserSubscribeUserToClassPOM = new ELTC060_CreateUserSubscribeUserToClassPOM(driver);
        
		  logger = report.createTest("ELTC060 - Click on Admin tab");
		  
		  // Click on Admin Tab
		  createUserSubscribeUserToClassPOM.clickOnAdminTabButton();
		  Assert.assertTrue(createUserSubscribeUserToClassPOM.confirmAdminTabClicked());
		  	  
	  }
	 
	 @Test (dependsOnMethods = {"clickOnAdminTab"})
	 public void clickOnCreateNewUserLink()
	 {
		 logger = report.createTest("ELTC060 - Click on Add New User Link");
		 
		 createUserSubscribeUserToClassPOM.clickAddAUserLink();
		 
		 Assert.assertTrue(createUserSubscribeUserToClassPOM.confirmAddUSerLinkClicked());
		 	 
	 }
	 
	 
	 @Test (dependsOnMethods = {"clickOnCreateNewUserLink"})
	 public void enterUserDetails()
	 {
		 logger = report.createTest("ELTC060 - Enter Details for new User");
		 createUserSubscribeUserToClassPOM.enterFirstName("manzoor_" +DateTime);
		 createUserSubscribeUserToClassPOM.enterLastName("mehadi");
		 createUserSubscribeUserToClassPOM.enterEmail("manzoor@gmail.com");
		 createUserSubscribeUserToClassPOM.enterPhone("983635242");
		 
		 createUserSubscribeUserToClassPOM.enterLogin("manzoor"+DateTimeCode);
		 createUserSubscribeUserToClassPOM.enterPassword("manzoor");
		 
		 createUserSubscribeUserToClassPOM.addUserSubmitButton();
		 
		 Assert.assertTrue(createUserSubscribeUserToClassPOM.confirmIfUserCreatedSuccessfully());
	 }
	 
	 @Test(dependsOnMethods = {"enterUserDetails"})
	  public void clickOnClassLink() throws InterruptedException
	  {
		//Create new test case in extent reports	
				logger = report.createTest("ELTC060 - Click on Class Link");
		  // Click on class link to navigate to display the list of classes
		  logger = report.createTest("Click on Class link and navigate to list of classes view");
		  createUserSubscribeUserToClassPOM.clickOnAdminTabButton();
		  	
		  createUserSubscribeUserToClassPOM.clickClassLink();
		  Assert.assertTrue(createUserSubscribeUserToClassPOM.confirmClassLinkClicked());
		  
	  }
	  
	  
	  @Test(dependsOnMethods = {"clickOnClassLink"})
	  public void createNewClass() throws InterruptedException
	   {
		//Create new test case in extent reports	
		logger = report.createTest("ELTC060 - Enter the class details");
		
		createUserSubscribeUserToClassPOM.clickAddClassButton();
		
		 Thread.sleep(3000);
		  // Create new class by entering details. Used DateTime string which holds the current Date and time for clarity purposes.
		 ClassName = createUserSubscribeUserToClassPOM.sendClassName("1demo_Kavita_" + DateTime);
		  logger.info("Class name is entered");
		  createUserSubscribeUserToClassPOM.sendClassDesc("demo");
		  logger.info("Description is entered");
		  createUserSubscribeUserToClassPOM.selectGroupPermissions("Open");
		  logger.info("Goup Permission dropdown is selected");
		  createUserSubscribeUserToClassPOM.clickAddToCreateNewClass();
		  logger.info("Add class button is clicked");
		  
		 
		  Assert.assertTrue(createUserSubscribeUserToClassPOM.confirmNewClassCreated().contains("Item added"));
		  
		  
	  }
	  
	  @Test(dependsOnMethods = {"createNewClass"})
		public void subscribeUserToClass() throws InterruptedException {
			
			logger = report.createTest("ELTC060 - Click on subscribe course to class button");
			
			Thread.sleep(2000);
			createUserSubscribeUserToClassPOM.clickOnSubscribeUsersIcon(ClassName);
			createUserSubscribeUserToClassPOM.selectUsersFromList();
			// Assert will check if the count of users against the class name have been increased
			createUserSubscribeUserToClassPOM.clickNameSortHeader();
			  Assert.assertTrue(createUserSubscribeUserToClassPOM.confirmUsersSubscribedToClass(ClassName));
		  }
			  
	  
	  
	  @Test(dependsOnMethods = {"subscribeUserToClass"})
		public void subscribeCourseToClass() throws InterruptedException {
			
			logger = report.createTest("Click on subscribe course to class button");
			   //Pass the stored class name to this method
				   // It will look for all the td elements with this title
				   // for loop created in POM to select the correct record and go to it's following-sibling and click the subscribe button
				 // subscribeCourseToClassPOM.clickNameSortHeader();
				  
			createUserSubscribeUserToClassPOM.clickSubscribeCourseButton(ClassName);
		   
			createUserSubscribeUserToClassPOM.selectCoursesFromList(CourseName);
			  
					//Sort the titles 
			createUserSubscribeUserToClassPOM.clickNameSortHeader();
					  
					  // Assert will check if the count of courses against the class name have been increased
			Assert.assertTrue(createUserSubscribeUserToClassPOM.confirmCoursesSubscribedToClass(ClassName));
			  
			 
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
