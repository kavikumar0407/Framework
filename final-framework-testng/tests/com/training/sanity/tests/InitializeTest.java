package com.training.sanity.tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.base.Verify;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class InitializeTest {
  
	static public WebDriver driver;
	static public String baseUrl;
	static public LoginPOM loginPOM;
	public static Properties properties;
	public static ExtentReports report;
	public static ExtentTest logger;
	public static ExtentHtmlReporter htmlReporter;
	
	public static DateFormat df,df2;
	public static Date dateNow ;
	static public ScreenShot screenShot;
	static public String DateTime,DateTimeCode, DateTimeFix;
	//static public String storedClassName;
	public static String storedSessionName = "Kavita TestCase ELTC_056 Session";
	public static String CourseName,ClassName;
	
	/*
	public void InitializeTest()
	{
		
		screenShot = new ScreenShot(driver);
		
		// Get current date and time to be used for Extent Reports folder creation
		df = new SimpleDateFormat("dd-MM-yy_HH-mm");
		df2 = new SimpleDateFormat("ddMMyyHHmm");
		dateNow = new Date();
		DateTime = df.format(dateNow);
		DateTimeCode = df2.format(dateNow);
		DateTimeFix = df.format(dateNow);
		
		//Set up Extent Reports
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/Reports"+DateTime+"/SeleniumTest_" + DateTimeFix + ".html");
	
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		
	}*/
}
