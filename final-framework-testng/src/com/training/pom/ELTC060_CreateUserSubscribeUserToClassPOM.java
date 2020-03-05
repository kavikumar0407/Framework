package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ELTC060_CreateUserSubscribeUserToClassPOM {
  
	private WebDriver driver;
    String CourseName;
	String ClassName; 
	String userName,login;
	Actions action;
	boolean found = false;
	
	public ELTC060_CreateUserSubscribeUserToClassPOM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//a[contains(text(),'Administration')]")
	private WebElement AdminTabButton;
	
	@FindBy (xpath = "//div[@class='alert alert-info']//span[contains(text(),'×')]")
	private WebElement CloseAlert;
	
	@FindBy (xpath = "//a[contains(text(),'Add a user')]")
	private WebElement AddUserLink;
	
	@FindBy(id="firstname")
	private WebElement FirstName;
	
	@FindBy(id="lastname")
	private WebElement LastName;
	
	@FindBy(id="email")
	private WebElement Email;
	
	@FindBy(id="phone")
	private WebElement Phone;
	
	@FindBy(id="username")
	private WebElement UserName;
	
	@FindBy (xpath = "//div[@id='password-group']//div[@class='col-sm-8']//div[2]")
	private WebElement PasswordRadioButton;
	
	@FindBy(id="password")
	private WebElement Password;

	@FindBy (xpath = "//div[@class='dropdown bootstrap-select form-control open']//div[@class='filter-option']")
	private WebElement ProfileOptions;
	
	@FindBy (xpath = "//section[@id='cm-content']//li[6]//a[1]")
	private WebElement InviteeOption;
	
	@FindBy (xpath = "//button[@name='submit']")
	private WebElement SubmitUser;
	
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
		
	@FindBy (xpath = "//select[@id='elements_not_in']/option")
	private List<WebElement> selectUsers;
	
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
	
	@FindBy (id ="gview_usergroups")
	private WebElement confirmClassLinkClicked;
	
	@FindBy (id="main_content")
	private WebElement AdminTabViewOpened;
	
	@FindBy (xpath = "//div[@class='alert alert-success']")
	private WebElement CourseCreatedSuccessfullyAlert;
	
	@FindBy(xpath = "//div[@class='alert alert-info']")
	private WebElement UserCreatedSuccessfully;
	
	
	 public void clickOnAdminTabButton() throws InterruptedException
	    {
		  this.AdminTabButton.click();
		  Thread.sleep(2000);
		  this.CloseAlert.click();
		
	    }
	 
	 public void clickAddAUserLink()
	 {
		 this.AddUserLink.click();
	 }
	 
	 public void enterFirstName(String firstName)
	 {
		 this.FirstName.sendKeys(firstName);
		 userName = firstName.trim();
	 }
	 
	 public void enterLastName(String lastName) {
		 this.LastName.sendKeys(lastName);
		 userName = userName.concat(" "+lastName);
	 }
	 
	 public void enterEmail(String email) {
		 this.Email.sendKeys(email);
		 }
	 
	 public void enterPhone(String phone) {
          this.Phone.sendKeys(phone);
	
	 }
	 
	 public void chooseProfile() throws InterruptedException {
		this.ProfileOptions.click();
		Thread.sleep(2000);
		this.InviteeOption.click();
	 }
	 
	 public void enterLogin(String loginName) {
		 
		 this.UserName.sendKeys(loginName);
		 login = this.UserName.getAttribute("value");
		   
	 }
	 
	 public void enterPassword(String password) {
		 this.PasswordRadioButton.click();
		 this.Password.sendKeys(password);
	 }
	 
	 public void addUserSubmitButton()
	 {
		 this.SubmitUser.click();
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
				Thread.sleep(5000);
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
					
		
		public void selectUsersFromList() {
			action = new Actions(driver);
			for (int i=0; i < selectUsers.size();i++)
			{
				if (selectUsers.get(i).getText().contains(login)) {
					
					selectUsers.get(i).click();
				    break;
			}}
			
			this.clickArrow.click();
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
		
		public void selectCoursesFromList(String CourseName) throws InterruptedException {
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
		    
		    public boolean confirmAdminTabClicked() {
		    	if (this.AdminTabViewOpened.isDisplayed())
		    		return true;
		    	else
		    		return false;
		    }    
	
		    public boolean confirmAddUSerLinkClicked() {
		    	if (this.FirstName.isDisplayed())
		    		return true;
		    	else
		    		return false;
		    } 
	
	       public boolean confirmIfUserCreatedSuccessfully()
	       {
	    	   if(UserCreatedSuccessfully.getText().contains(userName))
	    		   return true;
	    	   else
	    		   return false;
	       }
	
	
	
}
