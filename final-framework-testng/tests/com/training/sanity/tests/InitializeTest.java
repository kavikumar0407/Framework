package com.training.sanity.tests;

import java.text.DateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;

public class InitializeTest {
  
	static public WebDriver driver;
	static public String baseUrl;
	static public LoginPOM loginPOM;
	public static Properties properties;
	public static ExtentReports report;
	public static ExtentTest logger;
	public static ExtentHtmlReporter htmlReporter;
	
	public static DateFormat df;
	public static Date dateNow ;
	static public ScreenShot screenShot;
	static public String DateTime;
	static public String storedClassName;
	
	
	
}
