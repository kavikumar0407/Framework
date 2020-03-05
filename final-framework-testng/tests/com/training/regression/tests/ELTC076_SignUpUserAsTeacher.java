package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.dataproviders.UserDataProviders;
import com.training.pom.ELTC076_SignUpUserAsTeacherPOM;
import com.training.sanity.tests.InitializeTest;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC076_SignUpUserAsTeacher extends InitializeTest {
 
	private ELTC076_SignUpUserAsTeacherPOM signUpUserAsTeacherPOM ;
	
		
	@Test(dataProvider = "db-inputs", dataProviderClass = UserDataProviders.class, priority = 1)
	public void signUpNewUserTest(String firstname,String lastname ,String email,String profile,String username ,String password,String confirmPassword,String language) throws IOException, InterruptedException {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
		signUpUserAsTeacherPOM = new ELTC076_SignUpUserAsTeacherPOM(driver);
		System.out.println("signup");
		logger = report.createTest("Sign up user from database data provider");
		Thread.sleep(3000);			
		// Click the sign up user link.
		driver.get(baseUrl);
		Thread.sleep(3000);	
		
		signUpUserAsTeacherPOM.clickSignUpUserLink();
		
		// Enter details from the data provider
		signUpUserAsTeacherPOM.enterFirstName(firstname);
		signUpUserAsTeacherPOM.enterLastName(lastname);
		signUpUserAsTeacherPOM.enterEmail(email);
		signUpUserAsTeacherPOM.selectProfile(profile);
		signUpUserAsTeacherPOM.enterUsername(username);
		signUpUserAsTeacherPOM.enterPassword(password);
		signUpUserAsTeacherPOM.enterConfirmPassword(confirmPassword);
		signUpUserAsTeacherPOM.selectLanguage(language);
		
		logger.info("All the fields are entered. Recorded in Screenshot");
		logger.addScreenCaptureFromPath(screenShot.captureScreenShot("/Reports"+DateTimeFix+"/Screenshots/"+"EnterUserDetailsDB"+DateTimeFix));
		
		
		// Register user 
		signUpUserAsTeacherPOM.clickRegisterButton();
		Thread.sleep(1000);
		Assert.assertTrue(signUpUserAsTeacherPOM.confirmIfUserRegisteredSuccessfully());
		signUpUserAsTeacherPOM.clickLogout();
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
