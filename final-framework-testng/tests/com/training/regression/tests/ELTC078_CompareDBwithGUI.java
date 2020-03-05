package com.training.regression.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.UserDataProviders;
import com.training.pom.ELTC076_SignUpUserAsTeacherPOM;
import com.training.pom.ELTC078_CompareDBwithGUIPOM;
import com.training.sanity.tests.InitializeTest;

public class ELTC078_CompareDBwithGUI extends InitializeTest{
	
	private ELTC078_CompareDBwithGUIPOM compareDBwithGUIPOM ;
	
	
	@Test(dataProvider = "db-inputs-compare", dataProviderClass = UserDataProviders.class)
	public void compareGUIDataWithDBData(String firstname,String lastname ,String email,String profile,String username ,String password,String confirmPassword,String language) throws InterruptedException, IOException {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
		compareDBwithGUIPOM = new ELTC078_CompareDBwithGUIPOM(driver);
		
		// Since we are appending this test to the sanity tests, just getting the base url so that the tests can proceed.
				driver.get(baseUrl);
				
		logger = report.createTest("Compare data entered in GUI with DB data");
		// Click the sign up user link.
		
		compareDBwithGUIPOM.clickSignUpUserLink();
		boolean verifyStatus = false;
		// Enter details from the data provider
		// Added a logger to print the values entered through GUI and that saved in DB
		// Do a soft verify since we will have a final assert.
		
		compareDBwithGUIPOM.enterFirstName(firstname);
		logger.info("Data entered for First Name in GUI is - " +compareDBwithGUIPOM.getFirstName() + " and from DB is - " + firstname );
		if(!compareDBwithGUIPOM.getFirstName().contentEquals(firstname))
		{
			verifyStatus = true;
		}
		
		
		compareDBwithGUIPOM.enterLastName(lastname);
		logger.info("Data entered for Last Name in GUI is - " +compareDBwithGUIPOM.getLastName() + " and from DB is - " + lastname );
		if(!compareDBwithGUIPOM.getLastName().contentEquals(lastname))
		{
			verifyStatus = true;
		}
		
		compareDBwithGUIPOM.enterEmail(email);
		logger.info("Data entered for Last Name in GUI is - " +compareDBwithGUIPOM.getEmail() + " and from DB is - " + email );
		if(!compareDBwithGUIPOM.getEmail().contentEquals(email))
		{
			verifyStatus = true;
		}
		
		compareDBwithGUIPOM.selectProfile(profile);
		logger.info("Data entered for Last Name in GUI is - " +compareDBwithGUIPOM.getProfile() + " and from DB is - " + profile );
		if(!compareDBwithGUIPOM.getProfile().contentEquals(profile))
		{
			verifyStatus = true;
		}
		
		compareDBwithGUIPOM.enterUsername(username);
		logger.info("Data entered for Last Name in GUI is - " +compareDBwithGUIPOM.getUserName() + " and from DB is - " + username );
		if(!compareDBwithGUIPOM.getUserName().contentEquals(username))
		{
			verifyStatus = true;
		}
	
		compareDBwithGUIPOM.enterPassword(password);
		logger.info("Data entered for Last Name in GUI is - " +compareDBwithGUIPOM.getPassword() + " and from DB is - " + password );
		if(!compareDBwithGUIPOM.getPassword().contentEquals(password))
		{
			verifyStatus = true;
		}
		
		compareDBwithGUIPOM.enterConfirmPassword(confirmPassword);
		logger.info("Data entered for Last Name in GUI is - " +compareDBwithGUIPOM.getConfirmPassword() + " and from DB is - " + confirmPassword );
		if(!compareDBwithGUIPOM.getConfirmPassword().contentEquals(confirmPassword))
		{
			verifyStatus = true;
		}
	
		compareDBwithGUIPOM.selectLanguage(language);
		logger.info("Data entered for Last Name in GUI is - " +compareDBwithGUIPOM.getLanguage() + " and from DB is - " + language );
		
		if(!compareDBwithGUIPOM.getLanguage().contentEquals(language))
		{
			verifyStatus = true;
		}
		
		logger.addScreenCaptureFromPath(screenShot.captureScreenShot("/Reports"+DateTimeFix+"/Screenshots/"+"CompareUserDetails"+DateTimeFix));
		
		
		Assert.assertTrue(verifyStatus == false);
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
