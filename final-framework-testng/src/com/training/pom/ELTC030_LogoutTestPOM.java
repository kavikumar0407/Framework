package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ELTC030_LogoutTestPOM {

private WebDriver driver;
	
	
	public ELTC030_LogoutTestPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	private WebElement RecordDropdown;
	
	@FindBy (xpath = "//a[@id='logout_button']")
	private WebElement LogoutButton;
	
	@FindBy (xpath = "//ul[@class='dropdown-menu']")
	private WebElement menuBar;
	
	@FindBy (xpath = "//div[@id='login-block']")
	private WebElement loginBlock;
	
	
	public void clickRecordDropdown()
	{
		//((JavascriptExecutor)driver).executeScript("arguments[1].scrollIntoView();", RecordDropdown);
		this.RecordDropdown.click();
	}
	
    public void clickLogoutButton()
    {
    	this.LogoutButton.click();
    }
    
    public boolean confirmMenuOptionsVisible()
    {
    	if (menuBar.isDisplayed())
    		return true;
    	else
    		return false;
    }
    
    public boolean confirmLogoutSuccessful()
    {
    	if (this.loginBlock.isDisplayed())
    		return true;
    	else
    		return false;
    }
}
