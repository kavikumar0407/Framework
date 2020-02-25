package com.training.sanity.tests;

import java.io.IOException;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import com.training.pom.ELTC059_CreateCourseSubscribeUserPOM;

public class ELTC059_CreateCourseSubscribeUser extends InitializeTest {
  
	ELTC059_CreateCourseSubscribeUserPOM createCourseSubscribeUserPOM;
	
	
	 @Test
	  public void clickOnAdminTab() throws InterruptedException 
	  {
		 createCourseSubscribeUserPOM = new ELTC059_CreateCourseSubscribeUserPOM(driver);
		 dateNow = new Date();
		 DateTime = df.format(dateNow);
		 DateTimeCode = df2.format(dateNow);
		  logger = report.createTest("ELTC059 - Click on Admin tab");
		  
		  // Click on Admin Tab
		  createCourseSubscribeUserPOM.clickOnAdminTabButton();
		  Assert.assertTrue(createCourseSubscribeUserPOM.confirmAdminTabClicked());
		  	  
	  }
	 
	 @Test (dependsOnMethods = {"clickOnAdminTab"})
	 public void clickOnCreateNewCourseLink()
	 {
		 logger = report.createTest("ELTC059 - Click on Create New Course Link");
		 // click on create new course
		 createCourseSubscribeUserPOM.clickOnCreateNewCourse();
		 Assert.assertTrue(createCourseSubscribeUserPOM.confirmIfCreateNewCourseLinkClicked());
		 	 
	 }
	 
	 @Test (dependsOnMethods = {"clickOnCreateNewCourseLink"})
	 public void enterDetailsToCreateNewCourse() throws InterruptedException
	 {
		 logger = report.createTest("ELTC059 - Enter details to create a new course");
		 
		 CourseName = createCourseSubscribeUserPOM.enterCourseName("Testing_Kavita_"+DateTime);
		 System.out.println(CourseName);
		 createCourseSubscribeUserPOM.enterCode("tesSelenium"+DateTimeCode);
		 // enter fields while creating course
		 createCourseSubscribeUserPOM.selectTeacher("manzoor");
		 createCourseSubscribeUserPOM.selectCategory("Project");
		 createCourseSubscribeUserPOM.selectLanguage("English");
		 
		 createCourseSubscribeUserPOM.submitCourseCreation();
		 Thread.sleep(3000);
		 
		 Assert.assertTrue(createCourseSubscribeUserPOM.confirmIfNewCourseCreated());
				 
	 }
	 
	 @Test(dependsOnMethods = {"enterDetailsToCreateNewCourse"})
	  public void clickOnClassLink() throws InterruptedException
	  {
		//Create new test case in extent reports	
				logger = report.createTest("ELTC059 - Click on Class Link");
		  // Click on class link to navigate to display the list of classes
		  logger = report.createTest("Click on Class link and navigate to list of classes view");
		  createCourseSubscribeUserPOM.clickOnAdminTabButton();
		  	
		  createCourseSubscribeUserPOM.clickClassLink();
		  Assert.assertTrue(createCourseSubscribeUserPOM.confirmClassLinkClicked());
		  
	  }
	  
	  
	  @Test(dependsOnMethods = {"clickOnClassLink"})
	  public void createNewClass() throws InterruptedException
	   {
		//Create new test case in extent reports	
		logger = report.createTest("ELTC059 - Enter the class details");
		//create new class . Be careful to avoid duplicate names. Added current Datetime value to each class. Avoids confusion
		createCourseSubscribeUserPOM.clickAddClassButton();
		
		 Thread.sleep(3000);
		  // Create new class by entering details. Used DateTime string which holds the current Date and time for clarity purposes.
		 ClassName = createCourseSubscribeUserPOM.sendClassName("1demo_Kavita_" + DateTime);
		  logger.info("Class name is entered");
		  createCourseSubscribeUserPOM.sendClassDesc("demo");
		  logger.info("Description is entered");
		  createCourseSubscribeUserPOM.selectGroupPermissions("Open");
		  logger.info("Goup Permission dropdown is selected");
		  createCourseSubscribeUserPOM.clickAddToCreateNewClass();
		  logger.info("Add class button is clicked");
		  
		 
		  Assert.assertTrue(createCourseSubscribeUserPOM.confirmNewClassCreated().contains("Item added"));
		  
		  
	  }
	  
	  @Test(dependsOnMethods = {"createNewClass"})
		public void subscribeUserToClass() throws InterruptedException {
			
			logger = report.createTest("ELTC059 - Click on subscribe course to class button");
			// Navigate to newly created class and subscribe random user
			Thread.sleep(2000);
			createCourseSubscribeUserPOM.clickOnSubscribeUsersIcon(ClassName);
			createCourseSubscribeUserPOM.selectUsersFromList();
			// Assert will check if the count of users against the class name have been increased
			createCourseSubscribeUserPOM.clickNameSortHeader();
			  Assert.assertTrue(createCourseSubscribeUserPOM.confirmUsersSubscribedToClass(ClassName));
		  }
			  
	  
	  
	  @Test(dependsOnMethods = {"subscribeUserToClass"})
		public void subscribeCourseToClass() throws InterruptedException {
			
			logger = report.createTest("ELTC059 - Click on subscribe course to class button");
			   //Pass the stored class name to this method
				   // It will look for all the td elements with this title
				   // for loop created in POM to select the correct record and go to it's following-sibling and click the subscribe button
				 // subscribeCourseToClassPOM.clickNameSortHeader();
				  
			// Navigate to newly created class and subscribe course created in the previous steps
			createCourseSubscribeUserPOM.clickSubscribeCourseButton(ClassName);
				  
			createCourseSubscribeUserPOM.selectCoursesFromList();
			  
					//Sort the titles 
			createCourseSubscribeUserPOM.clickNameSortHeader();
					  
					  // Assert will check if the count of courses against the class name have been increased
			Assert.assertTrue(createCourseSubscribeUserPOM.confirmCoursesSubscribedToClass(ClassName));
			  
			 
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
