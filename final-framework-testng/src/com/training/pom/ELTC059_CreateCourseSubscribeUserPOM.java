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

public class ELTC059_CreateCourseSubscribeUserPOM {
	
	private WebDriver driver;
	String CourseName;
	String ClassName; 
	String userName;
	Actions action;
	boolean found = false;
	
	public ELTC059_CreateCourseSubscribeUserPOM(WebDriver driver)
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
	private WebElement clickAddToCreateNewClass;
	
	@FindBy (xpath = "//div[@class='alert alert-success']")
	private WebElement confirmNewClassCreated;
	
	@FindBy (id= "usergroups")
	private WebElement listOfClasses;
	
	@FindBy (id="usergroups_name")
	private WebElement sortNameHeader;
	
	@FindBy (id="next_usergroups_pager")
	private WebElement NextPageClass;
	
	@FindBy (xpath = "//td[@aria-describedby='usergroups_name']")
	private List<WebElement> findClassInList;
	
	@FindBy (xpath = ".//following-sibling::td[@aria-describedby='usergroups_actions']/a[1]/img")
	private WebElement subscribeUsersButton;
		
	@FindBy (xpath = "//select[@id='elements_not_in']/option[4]")
	private WebElement selectUsers;
	
	@FindBy (xpath = "//div[@class ='col-md-2']//button[1]")
	private WebElement clickArrow;
	
	@FindBy (xpath = "//button[@class='btn btn-primary']")
	private WebElement clickOnSubscribeButton;
	
	@FindBy (xpath = ".//following-sibling::td[@aria-describedby='usergroups_users']/a")
	private WebElement usersAddedToClass;
	
	@FindBy (xpath = "//td[@aria-describedby='usergroups_name']")
	private List<WebElement> findClassListForCourse;
	
	@FindBy (xpath = ".//following-sibling::td[@aria-describedby='usergroups_actions']/a[2]/img")
	private WebElement subscribeCourseButton;
	
	@FindBy (xpath = "//select[@id='elements_not_in']/option")
	private List<WebElement> selectCourse;
	
	@FindBy (xpath = "//td[2]//button[1]")
	private WebElement clickArrowForCourse;
	
	@FindBy (xpath = "//select[@id='elements_in']/option")
	private WebElement selectedCourses;
	
	@FindBy (xpath = "//button[@class='btn btn-primary']")
	private WebElement clickOnSubscribeCourseButton;
	
	@FindBy (xpath = ".//following-sibling::td[@aria-describedby='usergroups_courses']")
	private WebElement coursesAddedToClass;
	
	@FindBy (xpath = "//button[@name='add_course']")
	private WebElement AddCourseButton;
	
	@FindBy (xpath = "//button[@name='next']")
	private WebElement NextButton;
	
	@FindBy (id="main_content")
	private WebElement AdminTabViewOpened;
	
	@FindBy (xpath = "//div[@class='alert alert-success']")
	private WebElement CourseCreatedSuccessfullyAlert;
	
	@FindBy (id ="gview_usergroups")
	private WebElement confirmClassLinkClicked;
	
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
		
	    public void clickClassLink() {
			this.classLink.click();
			
		}
		
	    public void clickAddClassButton() {
			this.addClassButton.click();
			
		}
	    
	   public void clickClassName() {
			this.className.click();
			
		}
	   
		public String sendClassName(String classNameText) {
			this.className.clear();
			this.className.sendKeys(classNameText);
			ClassName = className.getAttribute("value");
			System.out.println(ClassName);
			return ClassName;
			
		}
		
		
		public void sendClassDesc(String classDescText) {
			this.classDesc.sendKeys(classDescText);
			
		}
		
			
		public void selectGroupPermissions(String valueofPermissions) {
			groupPermissions.click();
			driver.findElement(By.xpath("//div[@class='inner open']//ul/li/a/span[contains(text(), '" + valueofPermissions + "')]")).click();
			
		}
		
		 public void clickAddToCreateNewClass() {
				this.clickAddToCreateNewClass.click();
				
			}
		 
		 
		 
		 public void clickOnSubscribeUsersIcon(String className) throws InterruptedException
			{
				Thread.sleep(3000);
				boolean ans = false;
				this.sortNameHeader.click();
				Thread.sleep(2000);
                for (int i = 0 ; i < findClassInList.size() ; i++)
					{
					  //System.out.println(findClassInList.get(i).getAttribute("title"));
					   if(findClassInList.get(i).getAttribute("title").contentEquals(className))
					   {
						  //System.out.println("get src " + subscribeUsersButton.getAttribute("src"));
						   subscribeUsersButton.click();	
						   ans= true;
		     			   break;
					   }
					 }
					   // this.NextPageClass.click();
					//    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", this.addClassButton);
			 }
					
		
		public void selectUsersFromList() throws InterruptedException {
			action = new Actions(driver);
			
			this.selectUsers.click();
			userName = this.selectUsers.getAttribute("value");
			this.clickArrow.click();
			Thread.sleep(2000);
			this.clickOnSubscribeButton.click();
					
		}
			
			
		public void clickSubscribeCourseButton(String className) throws InterruptedException
		{
			Thread.sleep(3000);
			
			boolean ans = false;
    		   for (int i = 0 ; i < findClassInList.size() ; i++)
			   {
				   System.out.println(findClassListForCourse.get(i).getAttribute("title"));
				   
					if(findClassListForCourse.get(i).getAttribute("title").contentEquals(className))
					{
						//System.out.println(subscribeCourseButton.getAttribute("src"));
						subscribeCourseButton.click();					
						break;
						
					}
				 }
				         
		}
		
		public void clickNameSortHeader() throws InterruptedException 
		{
			
			Thread.sleep(2000);
			this.sortNameHeader.click();
		}
		
		public void selectCoursesFromList() throws InterruptedException {
			action = new Actions(driver);
			for (int i=0; i < selectCourse.size();i++)
			{
				if (selectCourse.get(i).getText().contains(CourseName)) {
					
					selectCourse.get(i).click();
				    break;
			}}
			Thread.sleep(2000);
			this.clickArrowForCourse.click();
			this.clickOnSubscribeCourseButton.click();
			
		}
		
		public boolean confirmUsersSubscribedToClass(String className) throws InterruptedException
		{
			Thread.sleep(3000);
			boolean ans = false;

			for (int i = 0 ; i < findClassInList.size() ; i++)
			{
				if(findClassInList.get(i).getAttribute("title").contentEquals(className))
				{
					System.out.println(usersAddedToClass.getText());
					if(usersAddedToClass.getText().contentEquals("0"))
					{
						ans= false;
					}
					else
						ans = true;
					
				}
			}
			return ans;
					
		}
		
		public boolean confirmCoursesSubscribedToClass(String className) throws InterruptedException
		{
			Thread.sleep(3000);
			boolean ans = false;

			for (int i = 0 ; i < findClassListForCourse.size() ; i++)
			{
				if(findClassListForCourse.get(i).getAttribute("title").contentEquals(className))
				{
					System.out.println(coursesAddedToClass.getText());
					if(coursesAddedToClass.getText().contentEquals("0"))
					{
						ans= false;
					}
					else
						ans = true;
					
				}
			}
			return ans;
					
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
	    
	    public boolean confirmClassLinkClicked() {
			if (this.confirmClassLinkClicked.isDisplayed())
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
	    
	    
	    
}
