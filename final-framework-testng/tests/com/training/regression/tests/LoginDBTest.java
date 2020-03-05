package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginDBTest {
	
	public LoginPOM loginPOM;
	static public WebDriver driver;
	static public String baseUrl;
	public static Properties properties;
	static public ScreenShot screenShot;
	
	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		System.out.println(baseUrl);
		// open the browser 
		driver.get(baseUrl);
	}


	/*
	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String userName, String password) {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
		loginPOM = new LoginPOM(driver); 		
		//loginPOM.sendUserName(userName);
		
//		loginPOM.sendPassword(password);
	//	loginPOM.clickLoginBtn();
		
		screenShot.captureScreenShot(userName);

	}*/

}