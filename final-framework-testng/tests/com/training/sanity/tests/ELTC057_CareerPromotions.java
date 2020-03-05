package com.training.sanity.tests;

import java.io.IOException;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.training.pom.ELTC057_CareerPromotionsPOM;

public class ELTC057_CareerPromotions extends InitializeTest{
	 
	ELTC057_CareerPromotionsPOM careerPromotionsPOM;
	
	@Test
	  public void clickOnAdminTab() throws InterruptedException 
	  {
		careerPromotionsPOM = new ELTC057_CareerPromotionsPOM(driver);
		 dateNow = new Date();
		 DateTime = df.format(dateNow);
		 DateTimeCode = df2.format(dateNow);  
		  logger = report.createTest("ELTC057 - Click on Admin tab");
		  
		  // Click on Admin Tab
		  careerPromotionsPOM.clickOnAdminTabButton();
		  Assert.assertTrue(careerPromotionsPOM.confirmAdminTabClicked());
		
	  }
	
	@Test (dependsOnMethods = {"clickOnAdminTab"})
	  public void clickOnCareersPromotionsLink() throws InterruptedException
	  {
		  logger = report.createTest("ELTC057 - Click on Careers and Promotions Link");
		  // Click on Career Promotions link
		 Thread.sleep(2000);
		  careerPromotionsPOM.clickOnCareersPromotionsLink();
		  Assert.assertTrue(careerPromotionsPOM.confirmIfCareerPromotionsLinkClicked());
				 
	  }  
 
	@Test (dependsOnMethods = {"clickOnCareersPromotionsLink"})
	  public void createCareer() throws InterruptedException
	  {
		  logger = report.createTest("ELTC057 - Click on Career icon and create a new career");
		  // Create new career
		 
		  careerPromotionsPOM.clickOnCareerIcon();
		  careerPromotionsPOM.clickOnAddCareerButton();
		  // Enter Name with unique suffix
		  careerPromotionsPOM.clickCareerNameInputBox("1_QA_"+DateTime);
		  careerPromotionsPOM.clickOnSubmitNewCareer();
		  Thread.sleep(2000);
		  // Sort the list to look for the newly created career
		 // careerPromotionsPOM.clickOnSortCareerNames();
		  Thread.sleep(2000);
		  Assert.assertTrue(careerPromotionsPOM.confirmIfCareerCreated());
				 
	  }  
	
	@Test (dependsOnMethods = {"createCareer"})
	  public void createPromotion() throws InterruptedException
	  {
		  logger = report.createTest("ELTC057 - Click on Promotion icon and create a new promotion");
		  // Click to create a new promotion
		  careerPromotionsPOM.clickOnCareersPromotionsLinkDetails();
		  careerPromotionsPOM.clickOnPromotionsIcon();
		  careerPromotionsPOM.clickOnAddPromotionsButton();
		  // enter name
		  careerPromotionsPOM.clickOnPromotionsNameInputBox("QA for Tester_"+DateTime);
		  careerPromotionsPOM.clickOnSubmitNewPromotions();
		  Thread.sleep(2000);
		  
		  // Sort the list
		  careerPromotionsPOM.clickOnSortPromotionsName();
		  Thread.sleep(2000);
		  Assert.assertTrue(careerPromotionsPOM.confirmIfPromotionCreated());
				 
	  }  
	
	@Test (dependsOnMethods = {"createPromotion"})
	  public void createTrainingSession() throws InterruptedException
	  {
		  logger = report.createTest("ELTC057 - Create a training session, assign coach");
		  // Create a training session
		  careerPromotionsPOM.clickOnAddTrainingSessionIcon();
		  
		  // Enter details in various fields
		  // Coach is a dropdown, method in POM accordingly
		  careerPromotionsPOM.clickOnTrainingSessionNameInputBox("Selenium Training Session "+DateTime);
		  careerPromotionsPOM.selectCoach();
		  
		  careerPromotionsPOM.clickOnClickNextStepButton();
		  // Select course and user to subscribe, inclusive methods created in POM
		  careerPromotionsPOM.selectCourse();
		  
		  careerPromotionsPOM.selectUser("sunil");
		  		  
		  Thread.sleep(2000);
		  Assert.assertTrue(careerPromotionsPOM.confirmCourseAddedSuccessfully() && careerPromotionsPOM.confirmUserAddedSuccessfully());
				 
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
