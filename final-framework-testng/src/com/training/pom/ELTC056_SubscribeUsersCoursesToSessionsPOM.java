package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ELTC056_SubscribeUsersCoursesToSessionsPOM {
 
	private WebDriver driver ;
	WebElement sessionRecordinList;
	String SubscribeUserToSessionIcon = "./following-sibling::td[@aria-describedby = 'sessions_actions']/a[2]/img";
	String SubscribeCourseToSessionIcon = "./following-sibling::td[@aria-describedby = 'sessions_actions']/a[3]/img";
	String userName;
	String SessionName;
	String CourseValue;
	String CourseName;
	private JavascriptExecutor executor = (JavascriptExecutor)driver;
	
	public ELTC056_SubscribeUsersCoursesToSessionsPOM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//a[contains(text(),'Administration')]")
	private WebElement AdminTabButton;
	
	@FindBy (xpath = "//div[@id='tabs-4']//a[contains(text(),'Sessions categories list')]")
	private WebElement SessionsCategoriesListLink;
	
	@FindBy (xpath = "//div[@class='actions']//a[2]//img[@alt = 'Training sessions list']")
	private WebElement TrainingSessionsListIcon;
	
	@FindBy (id="search_simple_keyword")
	private WebElement SearchInputBox;
	
	@FindBy (id= "search_simple_submit")
	private WebElement SearchSubmitButton;
	
	@FindBy (xpath = "//div[@id='searchhdfbox_sessions']//span[@class='ui-icon ui-icon-closethick']")
	private WebElement CloseButtonOnSearchWidget;
	
	@FindBy (xpath = "//td[@aria-describedby='sessions_name']")
	private WebElement SessionRecord;
	
	@FindBy (id="user_to_add")
	private WebElement UserToAddTextArea;
	
	@FindBy (xpath = "//div[@id='ajax_list_users_single']/a")
	private WebElement SelectUserFromList;
	
	@FindBy (xpath= "//select[@id='destination_users']/option")
	private WebElement ElementAddedDestinationWindow;
	
	@FindBy (xpath = "//button[@name='next']")
	private WebElement ClickNextButton;
	
	@FindBy (xpath = "//a[contains(text(),'Session list')]")
	private WebElement SessionsListLink;
	
	@FindBy (xpath = "//div[@id='session-table']")
	private WebElement ListOfSessions;
	
	@FindBy (xpath = "//option[1]")
	private WebElement CourseToBeAdded;
	
	@FindBy (xpath = "//button[@name='add_course']")
	private WebElement AddCourseButton;
	
	@FindBy (xpath = "//table[@id='session-list-course']//td[@class='title']/a")
	private WebElement CourseNameInSessionDetailsPage;
	
	@FindBy (xpath = "//table[@id='session-user-list']//tr/td/a")
	private WebElement UserNameInSessionDetailsPage;
	
	@FindBy (id="main_content")
	private WebElement AdminTabViewOpened;
	
	@FindBy (xpath = "//table[@class='data_table']")
	private WebElement DataTableVisible;
	
	@FindBy (xpath = "//div[@class='alert alert-info']//span[contains(text(),'×')]")
	private WebElement CloseAlert;
	
	
	public void clickOnCloseAlert()
	{
		this.CloseAlert.click();
	}
	public void clickOnAdminTabButton() {
		this.AdminTabButton.click();
	}
	
	public void clickOnSessionsCategoriesListLink() {
		//executor.executeScript("arguments[0].scrollIntoView(true);", SessionsCategoriesListLink);
		this.SessionsCategoriesListLink.click();
		
	}
	
	public void clickOnTrainingSessionsListIcon()
	{
		this.TrainingSessionsListIcon.click();
	}
	
	public void sendTextToSearchInputBox(String SessionName)
	{
		SearchInputBox.sendKeys(SessionName);
		this.SessionName = SessionName;
	}
	
	public void clickOnSearchSubmitButton()
	{
		this.SearchSubmitButton.click();
	}
	
	public void clickOnCloseButtonOnSearchWidget()
	{
		this.CloseButtonOnSearchWidget.click();
	}
	
	public void clickOnSubscribeUserToSessionIcon()
	{
		if (this.SessionRecord.getText().contentEquals(SessionName))
		{
			SessionRecord.findElement(By.xpath(SubscribeUserToSessionIcon)).click();
		}
	}
	
	public void enterUserInSearchTextArea(String UserName)
	{
		this.UserToAddTextArea.sendKeys(UserName);
		userName = String.valueOf(UserName);
	}
	
	public void selectUserFromList()
	{
		if(this.SelectUserFromList.getText().contains(userName))
		{
			this.SelectUserFromList.click();
		}
	}
	
	public void clickOnNextButton()
	{
		this.ClickNextButton.click();
	}
	
	public void clickOnSessionsListLink()
	{
		this.SessionsListLink.click();
	}

	
	public void clickOnSubscribeCourseToSessionIcon()
	{
		if (this.SessionRecord.getText().contentEquals(SessionName))
		{
			
			SessionRecord.findElement(By.xpath(SubscribeCourseToSessionIcon)).click();
		}
	}
	
    public void selectCoursesToBeAdded()
    {
    	this.CourseToBeAdded.click();
    	CourseValue = CourseToBeAdded.getAttribute("value");
    	CourseName = CourseToBeAdded.getText().trim();
    	System.out.println(CourseName);
    }
    
    public void clickOnAddCourseButton()
    {
    	this.AddCourseButton.click();
    }
    
    public boolean confirmAdminTabClicked() {
    	if (this.AdminTabViewOpened.isDisplayed())
    		return true;
    	else
    		return false;
    }
    
    public boolean confirmCoursesToBeAddedAreHighlighted()
    {
    	if(this.CourseToBeAdded.isSelected())
    	    return true;
    	else
    		return false;
    	
     }
    
    public boolean confirmSessionsListDisplayed()
	{
		if (this.ListOfSessions.isDisplayed())
			return true;
		else 
			return false;
	}
    
    public boolean confirmSessionsRecordDisplayed()
   	{
   		if (this.SessionRecord.getText().contentEquals(SessionName))
   			return true;
   		else 
   			return false;
   	}
    


    public boolean confirmIfUserAddedInDestinationWindow()
	{
		if(this.ElementAddedDestinationWindow.getText().contains(userName))
			return true;
		else
			return false;
	}
    
    public boolean confirmIfAddCourseButtonclicked()
    {
    	if (this.ElementAddedDestinationWindow.getAttribute("value").contentEquals(CourseValue))
    		return true;
    	else
    		return false;
     }
    
    public boolean confirmCoursesAddedSuccessfully()
    {
    	System.out.println(CourseNameInSessionDetailsPage.getText());
    	if (CourseNameInSessionDetailsPage.getText().contains(CourseName))
    		return true;
    	else
    		return false;
    }
    
    public boolean confirmUserAddedSuccessfully()
    {
    	System.out.println(userName);
    	if (UserNameInSessionDetailsPage.getText().contains(userName))
    		return true;
    	else
    		return false;
    }
    
    public boolean confirmDataTableVisible()
    {
    	if (this.DataTableVisible.isDisplayed())
    		return true;
    	else
    		return false;
    }
}
