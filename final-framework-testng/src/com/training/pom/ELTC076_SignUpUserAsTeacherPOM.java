package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.training.regression.tests.LoginDBTest;

public class ELTC076_SignUpUserAsTeacherPOM extends LoginDBTest {
 
	private WebDriver driver;
	
	public ELTC076_SignUpUserAsTeacherPOM(WebDriver driver)
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
	 
	@FindBy (xpath = "//a[@class='dropdown-toggle']")
	private WebElement UserRegisteredSuccessfullyMessage;
	
	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	private WebElement RecordDropdown;
	
	@FindBy (xpath = "//a[@id='logout_button']")
	private WebElement LogoutButton;
	
	@FindBy (xpath = "//ul[@class='dropdown-menu']")
	private WebElement menuBar;
	
	
	public void clickSignUpUserLink()
	{
		this.SignUpLink.click();
	}
	
	public void enterFirstName(String firstname)
	{
		this.FirstNameInputBox.sendKeys(firstname);
		
	}
	
	public void enterLastName(String lastname)
	{
		this.LastNameInputBox.sendKeys(lastname);
	}
	
	public void enterEmail(String email)
	{
		this.EmailInputBox.sendKeys(email);
	}
	
	public void selectProfile (String profile)
	{
		if (profile.equalsIgnoreCase("Teacher"))
			{
			  this.ProfileTeacherRadioButton.click();
			}
	}
	
	public void enterUsername(String username)
	{
		this.UsernameInputBox.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		this.PasswordInputBox.sendKeys(password);
	}
	
	public void enterConfirmPassword(String passwordConfirm)
	{
		this.ConfirmPasswordInputBox.sendKeys(passwordConfirm);
	}
	
	public void selectLanguage(String language)
	{
	     this.LaguageDropDownBox.click();
	     this.SelectLanguageOption.findElement(By.xpath("//span[contains(text(),'"+language+"')]")).click();
	}
	
	public void clickRegisterButton()
	{
		this.RegistrationSubmitButton.click();
	}
	
	public boolean confirmIfUserRegisteredSuccessfully()
	{
		if (this.UserRegisteredSuccessfullyMessage.isDisplayed())
		   return true;
		else
			return false;
	}
	
	
	public void clickLogout()
	{
		RecordDropdown.click();
		LogoutButton.click();
		
	}
}
