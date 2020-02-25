package com.training.sanity.tests;

import java.io.IOException;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.training.pom.ELTC058_CreateCourseSessionPOM;


public class ELTC058_CreateCourseSession extends InitializeTest{
	
	ELTC058_CreateCourseSessionPOM createCourseSessionPOM;
	String CourseName;
	String SessionName;
	
	 @Test
	  public void clickOnAdminTab() throws InterruptedException 
	  {
		 createCourseSessionPOM = new ELTC058_CreateCourseSessionPOM(driver);
		 dateNow = new Date();
		 DateTime = df.format(dateNow);
		 DateTimeCode = df2.format(dateNow);
		  logger = report.createTest("ELTC058 - Click on Admin tab");
		  
		  // Click on Admin Tab
		  createCourseSessionPOM.clickOnAdminTabButton();
		  Assert.assertTrue(createCourseSessionPOM.confirmAdminTabClicked());
		  	  
	  }
	 
	 @Test (dependsOnMethods = {"clickOnAdminTab"})
	 public void clickOnCreateNewCourseLink()
	 {
		 logger = report.createTest("ELTC058 - Click on Create New Course Link");
		 // Create new course
		 createCourseSessionPOM.clickOnCreateNewCourse();
		 Assert.assertTrue(createCourseSessionPOM.confirmIfCreateNewCourseLinkClicked());
		 	 
	 }
	 
	 @Test (dependsOnMethods = {"clickOnCreateNewCourseLink"})
	 public void enterDetailsToCreateNewCourse() throws InterruptedException
	 {
		 logger = report.createTest("ELTC058 - Enter details to create a new course");
		 // Enter details to create course
		 CourseName = createCourseSessionPOM.enterCourseName("Testing_Kavita_"+DateTime);
		 System.out.println(CourseName);
		 createCourseSessionPOM.enterCode("tesSelenium"+DateTimeCode);
		 
		 // some of the fields are dropdown, inclusive methods written in POM
		 createCourseSessionPOM.selectTeacher("manzoor");
		 createCourseSessionPOM.selectCategory("Project");
		 createCourseSessionPOM.selectLanguage("English");
		 
		 createCourseSessionPOM.submitCourseCreation();
		 Thread.sleep(3000);
		 
		 Assert.assertTrue(createCourseSessionPOM.confirmIfNewCourseCreated());
				 
	 }
	 
	 @Test (dependsOnMethods = {"enterDetailsToCreateNewCourse"})
	 public void clickOnAddTrainingSession() throws InterruptedException
	 {
		 logger = report.createTest("ELTC058 - Go to Admin Tab and add a new training session");
		 // Add a new training session
		 
		 createCourseSessionPOM.createNewSession("Selenium Training Session_"+DateTime);
		 
		 // Fields of a course
		 createCourseSessionPOM.selectCoach();
		 createCourseSessionPOM.clickOnClickNextStepButton();
		 createCourseSessionPOM.selectCourse(CourseName);
		 
		 createCourseSessionPOM.selectUser("sunil");
	
	  Thread.sleep(2000);
	  Assert.assertTrue(createCourseSessionPOM.confirmCourseAddedSuccessfully() && createCourseSessionPOM.confirmUserAddedSuccessfully());
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
