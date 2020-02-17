package com.training.sanity.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.training.pom.AddCourseToClassPOM;

public class AddCourseToClass extends InitializeTest{
 
	private AddCourseToClassPOM addCourseToClassPOM;
	
	
	@Test
	public void clickonSubscribeCourseButton() throws InterruptedException {
		
		addCourseToClassPOM = new AddCourseToClassPOM (driver);
		logger = report.createTest("Click on subscribe course to class button");
				   
			   //Pass the stored class name to this method
			   // It will look for all the td elements with this title
			   // for loop created in POM to select the correct record and go to it's following-sibling and click the subscribe button
			 // subscribeCourseToClassPOM.clickNameSortHeader();
			  
		 addCourseToClassPOM.clickSubscribeCourseButton(storedClassName);
			  
		 Assert.assertTrue(addCourseToClassPOM.confirmSubscribeCourseButtonClicked());
			  
		  }
		  
	  @Test (dependsOnMethods = {"clickonSubscribeCourseButton"})
	  public void selectCourses()
	  {
			  logger = report.createTest("Select 2 courses records to be added ");
			  // This method will select 2 courses. Actions keydown CNTRL has been used for this
			  addCourseToClassPOM.selectCoursesFromList();
			  
			  //This will click the arrow pointing to right to move the selected courses in the next window.
			  addCourseToClassPOM.clickArrow();
			  
			  // confirm if both courses are selected and moved
			  Assert.assertTrue(addCourseToClassPOM.confirmIfCoursesInGroupAreAdded());
		  }
		  
		  @Test (dependsOnMethods = {"selectCourses"})
		  public void subscribeCoursesToClass() throws InterruptedException {
			  logger = report.createTest("Click on subscribe button to subscribe courses");
			  
			  // Selected courses need to be subscribed by clicking on the button
			  addCourseToClassPOM.clickOnSubscribeButton();
			  
			//Sort the titles 
			  addCourseToClassPOM.clickNameSortHeader();
			  
			  // Assert will check if the count of courses against the class name have been increased
			  Assert.assertTrue(addCourseToClassPOM.confirmCoursesSubscribedToClass(storedClassName));
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

	

