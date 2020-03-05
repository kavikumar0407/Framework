package com.training.regression.tests;

import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.UserDataProviders;
import com.training.pom.ELTC076_SignUpUserAsTeacherPOM;
import com.training.pom.ELTC077_InvalidUserDetailsTestPOM;
import com.training.sanity.tests.InitializeTest;

public class ELTC077_InvalidUserDetailsTest extends InitializeTest{
	
	private ELTC077_InvalidUserDetailsTestPOM invalidUserDetailsTestPOM ;
	
	@Test(dataProvider = "excel-inputs", dataProviderClass = UserDataProviders.class)
	public void enterInvalidUserDetails(String firstname,String lastname ,String email,String profile,String username ,String password,String confirmPassword,String language) throws IOException {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
		invalidUserDetailsTestPOM = new ELTC077_InvalidUserDetailsTestPOM(driver);
		
		logger = report.createTest("Enter invalid user details and confirm if error is displayed");
		
		// Since we are appending this test to the sanity tests, just getting the base url so that the tests can proceed.
		//((JavascriptExecutor)driver).executeScript("window.open("+baseUrl+";)");
		driver.get(baseUrl);
		
		// Click the sign up user link.
		
		invalidUserDetailsTestPOM.clickSignUpUserLink();
		
		// Enter details from the data provider
		// Username, email and passwords comparison are entered with invalid values.
		// Assert will locate the error and confirm if they are displayed.
		
		invalidUserDetailsTestPOM.enterFirstName(firstname);
		invalidUserDetailsTestPOM.enterLastName(lastname);
		invalidUserDetailsTestPOM.enterEmail(email);
		invalidUserDetailsTestPOM.selectProfile(profile);
		invalidUserDetailsTestPOM.enterUsername(username);
		invalidUserDetailsTestPOM.enterPassword(password);
		invalidUserDetailsTestPOM.enterConfirmPassword(confirmPassword);
		invalidUserDetailsTestPOM.selectLanguage(language);
		
		// Register user 
		invalidUserDetailsTestPOM.clickRegisterButton();
		
		logger.info("Username, email and passwords comparison are entered incorrectly. Recorded in the errors in screenshot.");
		logger.addScreenCaptureFromPath(screenShot.captureScreenShot("/Reports"+DateTimeFix+"/Screenshots/"+"InvalidUserDetailsXlsError"+DateTimeFix));
		
		// Error should be displayed as because username/login can only contain letters, numbers and _. We have entered other special characters
		// Error should also be displayed for passwords, since both passwords do not match.
		
		AssertJUnit.assertTrue(invalidUserDetailsTestPOM.confirmIfErrorMessageDisplayed());
	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		
		//Adds info about the status of the test case in ExtentReports html.
	  if(result.getStatus()==1)
			logger.pass("The status of " + result.getName() +" is PASS");
			else
				Assert.fail("The status of " + result.getName() +"  FAIL");
	  
		// Takes screenshot and saves it with the name of the @Test method
	  logger.addScreenCaptureFromPath(screenShot.captureScreenShot("/Reports"+DateTimeFix+"/Screenshots/"+result.getName()+DateTimeFix));
		
		report.flush();
		
}
	
}
