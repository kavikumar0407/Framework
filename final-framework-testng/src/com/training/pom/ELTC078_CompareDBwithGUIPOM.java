package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ELTC078_CompareDBwithGUIPOM {
private WebDriver driver;
	
	public ELTC078_CompareDBwithGUIPOM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Sign up!')]")
	private WebElement SignUpLink;
	
	@FindBy(xpath = "//input[@id='registration_firstname']")
	private WebElement FirstNameInputBox;
	
	@FindBy (xpath = "//input[@id='registration_lastname']")
	private WebElement LastNameInputBox;
	
	@FindBy (xpath = "//input[@id='registration_email']")
	private WebElement EmailInputBox;
	
	@FindBy (xpath = "//p[contains(text(),'Teach courses')]/preceding-sibling::input")
	private WebElement ProfileTeacherRadioButton;
	
	@FindBy (xpath = "//input[@id='username']")
	private WebElement UsernameInputBox;
	
	@FindBy (xpath = "//input[@id='pass1']")
	private WebElement PasswordInputBox;
	
	@FindBy (xpath = "//input[@id='pass2']")
	private WebElement ConfirmPasswordInputBox;
	
	@FindBy (xpath ="//div[@class='filter-option']")
	private WebElement LaguageDropDownBox;
	
	@FindBy (xpath = "//div[@class='inner open']//a[@role='option']")
	private WebElement SelectLanguageOption;
	
	@FindBy (xpath = "//button[@id='registration_submit']")
	private WebElement RegistrationSubmitButton;
	
	@FindBy (xpath = "//p[contains(text(),'An e-mail has been sent to remind you of your login and password')]")
	private WebElement UserRegisteredSuccessfullyMessage;
	
	public void clickSignUpUserLink()
	{
		this.SignUpLink.click();
	}
	
	public void enterFirstName(String firstname)
	{
		this.FirstNameInputBox.sendKeys(firstname);
		
	}
	
	public String getFirstName()
	{
		return this.FirstNameInputBox.getAttribute("value");
	}
	
	public void enterLastName(String lastname)
	{
		this.LastNameInputBox.sendKeys(lastname);
	}
	
	public String getLastName() throws InterruptedException
	{
		Thread.sleep(2000);
		return this.LastNameInputBox.getAttribute("value");
	}
	
	public void enterEmail(String email)
	{
		this.EmailInputBox.sendKeys(email);
	}
	
	public String getEmail() throws InterruptedException
	{
		Thread.sleep(2000);
		return this.EmailInputBox.getAttribute("value");
	}
	
	public void selectProfile (String profile)
	{
		
		if (profile.equalsIgnoreCase("Teacher"))
			{
			  this.ProfileTeacherRadioButton.click();
			}
	}
	
	public String getProfile() throws InterruptedException
	{
		Thread.sleep(2000);
		if (ProfileTeacherRadioButton.isSelected())
		      return "Teacher";
		else
			return "Student";
	}
	
	public void enterUsername(String username)
	{
		this.UsernameInputBox.sendKeys(username);
	}
	
	public String getUserName() throws InterruptedException
	{
		Thread.sleep(2000);
		return this.UsernameInputBox.getAttribute("value");
	}
	
	public void enterPassword(String password)
	{
		this.PasswordInputBox.sendKeys(password);
	}
	
	public String getPassword() throws InterruptedException
	{
		Thread.sleep(2000);
		return this.PasswordInputBox.getAttribute("value");
	}
	
	public void enterConfirmPassword(String passwordConfirm)
	{
		this.ConfirmPasswordInputBox.sendKeys(passwordConfirm);
	}
	
	public String getConfirmPassword() throws InterruptedException
	{
		Thread.sleep(2000);
		return this.ConfirmPasswordInputBox.getAttribute("value");
	}
	
	public void selectLanguage(String language)
	{
	     this.LaguageDropDownBox.click();
	     this.SelectLanguageOption.findElement(By.xpath("//span[contains(text(),'"+language+"')]")).click();
	}
	
	public String getLanguage() throws InterruptedException
	{
		Thread.sleep(2000);
		return this.LaguageDropDownBox.getText();
	}
	
	
	
}
