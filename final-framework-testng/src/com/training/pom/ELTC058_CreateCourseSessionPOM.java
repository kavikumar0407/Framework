package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ELTC058_CreateCourseSessionPOM {
  
	private WebDriver driver;
	String CourseName;
	String SessionName; 
	String userName;
	Actions action;
	
	public ELTC058_CreateCourseSessionPOM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath = "//a[contains(text(),'Administration')]")
	private WebElement AdminTabButton;
	
	@FindBy(xpath = "//ul[@class='nav navbar-nav']//li[7]/a")
	private WebElement AdminTabReopen;
	
	@FindBy (xpath = "//div[@class='alert alert-info']//span[contains(text(),'×')]")
	private WebElement CloseAlert;
	
	@FindBy (xpath = "//div[@id='tabs-2']//a[contains(text(),'Create a course')]")
	private WebElement CreateNewCourseLink;
	
	@FindBy (xpath = "//input[@id='update_course_title']")
	private WebElement UpdateCourseTitle;
	
	@FindBy (xpath = "//input[@id='visual_code']")
	private WebElement UpdateCode;
	
	@FindBy (xpath = "//li[2]//input[@type='search']")
	private WebElement ClickTeacherBox;
	
	@FindBy (xpath = "//ul[@id='select2-course_teachers-results']")
	private WebElement ListOfTeachers;
	
	@FindBy (xpath = "//button[@data-id='update_course_category_code']//div[@class='filter-option']")
	private WebElement CategoryBox;
	
	@FindBy (xpath = "//div[@class='dropdown bootstrap-select form-control open']//input[@class='form-control']")
	private WebElement CategoryKeyword;
	
	@FindBy (xpath = "//a[@class='active']")
	private WebElement SelectDropdownOption;
	
	@FindBy(xpath = "//div[@class='filter-option']//div[contains(text(),'English')]")
	private WebElement ClickLanguageBox;
	
	@FindBy (xpath = "//li[@class = 'selected active']//span[contains(text(),'English')]")
	private WebElement LanguageOption;
	
	
	@FindBy (xpath = "//button[@id='update_course_submit']")
	private WebElement CreateCourseSubmitButton;
	
	@FindBy (xpath = "//input[@id='course-search-keyword']")
	private WebElement SearchCourseName;
	
	@FindBy (xpath = "//button[@id='search_simple_submit']")
	private WebElement SearchCourseButton;
	
	@FindBy (xpath = "//div[@class='alert alert-success']")
	private WebElement CourseCreatedSuccessfullyAlert;
	
	@FindBy (xpath = "//a[contains(text(),'Add a training session')]")
	private WebElement AddTrainingSessionLink;
	
	@FindBy (xpath = "//input[@id='add_session_name']")
	private WebElement TrainingSessionNameInputBox;
	
	@FindBy (xpath = "//span[@id='select2-coach_username-container']")
	private WebElement CoachNameBox;
	
	@FindBy (xpath = "//input[@class='select2-search__field']")
	private WebElement EnterCoachNameKeyword;
	
	@FindBy (xpath = "//ul[@id='select2-coach_username-results']//li[contains(text(),'teach test1')]")
	private WebElement SelectCoachName;
	
	@FindBy (xpath = "//button[@id='add_session_submit']")
	private WebElement ClickNextStepButton;
	
	@FindBy (xpath = "//select[@id='origin']//option")
	private List<WebElement> SelectcourseName;
	
	@FindBy (xpath = "//button[@name='add_course']")
	private WebElement AddCourseButton;
	
	@FindBy (xpath = "//button[@name='next']")
	private WebElement NextButton;
	
	@FindBy (id="user_to_add")
	private WebElement UserToAddTextArea;
	
	@FindBy (xpath = "//div[@id='ajax_list_users_single']/a")
	private WebElement SelectUserFromList;	
	
	@FindBy (id="main_content")
	private WebElement AdminTabViewOpened;
	
	@FindBy (xpath = "//table[@id='session-list-course']//td[@class='title']/a")
	private WebElement CourseNameInSessionDetailsPage;
	
	@FindBy (xpath = "//table[@id='session-user-list']//tr/td/a")
	private WebElement UserNameInSessionDetailsPage;

    public void clickOnAdminTabButton() throws InterruptedException
    {
	  this.AdminTabButton.click();
	  Thread.sleep(2000);
	  this.CloseAlert.click();
	
    }
    
    public void clickOnCreateNewCourse()
    {
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CreateNewCourseLink);
		
    	this.CreateNewCourseLink.click();
    	
    }
    
    public String enterCourseName(String courseName) 
    {
    
    	this.UpdateCourseTitle.sendKeys(courseName);
    	this.CourseName = UpdateCourseTitle.getAttribute("value");
    	System.out.println(UpdateCourseTitle.getAttribute("value"));
    	return CourseName;
    }
    
    public void enterCode(String courseCode) 
    {
    
    	this.UpdateCode.sendKeys(courseCode);
    	
    }
    
    public void selectTeacher(String teacherName) 
    {
         this.ClickTeacherBox.click();
    	 this.ClickTeacherBox.sendKeys(teacherName);
    		teacherName = "("+teacherName+")";
    		ListOfTeachers.findElement(By.xpath("//li[contains(text(),'"+teacherName+"')]")).click();
    		 	
    }
    
    public void selectCategory(String categoryName) throws InterruptedException 
    {
    	action = new Actions(driver);
    	action.moveToElement(CategoryBox).click().sendKeys(Keys.ARROW_DOWN).sendKeys(categoryName).build().perform();
    	Thread.sleep(2000);
    	
    	//this.CategoryKeyword.sendKeys(categoryName);
    	this.SelectDropdownOption.click();    	
    }
    
    public void selectLanguage(String languageName) throws InterruptedException 
    {
    	action = new Actions(driver);
    	action.moveToElement(ClickLanguageBox).click().sendKeys(Keys.ARROW_DOWN).sendKeys(languageName).build().perform();
    	Thread.sleep(2000);
    	this.LanguageOption.click();
    }
    
    public void submitCourseCreation() throws InterruptedException  
    {
     	this.CreateCourseSubmitButton.click();
     	
    }
	
    public void createNewSession(String sessionName) throws InterruptedException
    {
    	action = new Actions(driver);
    	System.out.println("inside create new session");
    	action.moveToElement(AdminTabReopen).click().build().perform();
    	//this.AdminTabReopen.click();
    	Thread.sleep(2000);
    	this.CloseAlert.click();
    	Thread.sleep(2000);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AddTrainingSessionLink);
		
    	this.AddTrainingSessionLink.click();
    	this.TrainingSessionNameInputBox.sendKeys(sessionName);
    	SessionName = TrainingSessionNameInputBox.getText();
    	System.out.println(SessionName);
      	
    }
   
    public void selectCoach() throws InterruptedException
	{
		this.CoachNameBox.click();
		this.EnterCoachNameKeyword.sendKeys("test");
		Thread.sleep(2000);
		this.SelectCoachName.click();
		
	}
	
	public void clickOnClickNextStepButton()
	{
		this.ClickNextStepButton.click();
		
	}
	
	public void selectCourse(String courseName) throws InterruptedException
	{
		for (int i=0; i < SelectcourseName.size();i++)
		{
			if (SelectcourseName.get(i).getText().contains(courseName)) {
				
				SelectcourseName.get(i).click();
			    break;
		}}
		Thread.sleep(2000);
		this.AddCourseButton.click();
		this.NextButton.click();
		
	}
	
	public void selectUser(String UserName) throws InterruptedException
	{
		this.UserToAddTextArea.sendKeys(UserName);
		userName = UserName.trim();
		Thread.sleep(2000);
		if(this.SelectUserFromList.getText().contains(UserName))
		{
			this.SelectUserFromList.click();
		}
		this.NextButton.click();
	}
	
	public boolean confirmAdminTabClicked() {
    	if (this.AdminTabViewOpened.isDisplayed())
    		return true;
    	else
    		return false;
    }

    public boolean confirmIfCreateNewCourseLinkClicked()
    {
    	if(this.UpdateCourseTitle.isDisplayed())
    		return true;
    	else
    		return false;
    }
 
    public boolean confirmIfNewCourseCreated()
    {
    	System.out.println(CourseCreatedSuccessfullyAlert.getText());
    	if(this.CourseCreatedSuccessfullyAlert.getText().contains(CourseName))
    		return true;
    	else
    		return false;
    }
    
    public boolean confirmCourseAddedSuccessfully()
    {
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
    
}