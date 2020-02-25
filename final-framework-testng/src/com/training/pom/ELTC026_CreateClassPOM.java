package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELTC026_CreateClassPOM {
	
	private WebDriver driver; 
	
		
	public ELTC026_CreateClassPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	// AdminTab
	@FindBy(xpath = "//a[contains(text(),'Administration')]")
	private WebElement adminTab; 
	
	@FindBy(xpath = "//div[@class='panel panel-default block-admin-users']//ul[@class='list-items-admin']//a[contains(text(),'Classes')]")
	private WebElement classLink; 
	
	@FindBy(xpath = "//div[@class='actions']//img[@title = 'Add classes']")
	private WebElement addClassButton;
	
	@FindBy(id= "usergroup_name")
	private WebElement className; 
	
	@FindBy (id="usergroup_description")
	private WebElement classDesc;
	
	@FindBy (xpath="//div[@class='filter-option']")
	private WebElement groupPermissions;
	
	@FindBy(xpath="//div[@class='inner open']//ul/li/a/")
	private WebElement selectOption;
	
	@FindBy (id = "usergroup_submit")
	private WebElement submitClass;
	
	@FindBy (id="settings")
	private WebElement confirmAdminTabOpened;
	
	@FindBy (id ="gview_usergroups")
	private WebElement confirmClassLinkClicked;
	
	@FindBy (id = "usergroup")
	private WebElement confirmAddClassClicked;
	
	@FindBy (id = "usergroup_submit")
	private WebElement clickAddToCreateNewClass;
	
	@FindBy (xpath = "//div[@class='alert alert-success']")
	private WebElement confirmNewClassCreated;
	
	@FindBy (id= "usergroups")
	private WebElement listOfClasses;
	
	public void clickAdminTab() {
		this.adminTab.click();
		
	}
	
	public void clickClassLink() {
		this.classLink.click();
		
	}
	
	public void clickAddClassButton() {
		this.addClassButton.click();
		
	}
	
	public void clickClassName() {
		this.className.click();
		
	}
	public void sendClassName(String classNameText) {
		this.className.clear();
		this.className.sendKeys(classNameText);
	}
	
	
	public void sendClassDesc(String classDescText) {
		this.classDesc.sendKeys(classDescText);
		
	}
	
	public String storeClassName()
	{
	   String storedClassName = className.getAttribute("value");
	   return storedClassName;
	}
	
	public void selectGroupPermissions(String valueofPermissions) {
		groupPermissions.click();
		driver.findElement(By.xpath("//div[@class='inner open']//ul/li/a/span[contains(text(), '" + valueofPermissions + "')]")).click();
		
	}
	
	public void clickSubmitClass() {
		this.submitClass.click();
		
	}
	
	public void clickAddToCreateNewClass() {
		this.clickAddToCreateNewClass.click();
		
	}
	
	public boolean confirmAdminTabOpened() {
		if (this.confirmAdminTabOpened.isDisplayed())
		{
			return true;
		}
		else
			return false;
	}
	
	public boolean confirmClassLinkClicked() {
		if (this.confirmClassLinkClicked.isDisplayed())
		{
			return true;
		}
		else
			return false;
	}
	
	public boolean confirmAddClassClicked() {
		if (this.confirmAddClassClicked.isDisplayed())
		{
			return true;
		}
		else
			return false;
	}
	
	public String confirmNewClassCreated() {
		
		System.out.println(confirmNewClassCreated.getText());
		//System.out.println(confirmNewClassCreated.getAttribute("value"));
		return confirmNewClassCreated.getText();
			
	}

	public boolean confirmListOfClassesDisplayed()
	{
		if (this.listOfClasses.isDisplayed())
		{
			return true;
		}
		else
			return false;
	}
	
	
}
