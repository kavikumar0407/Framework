package com.training.pom;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ELTC057_CareerPromotionsPOM {
	
	private WebDriver driver ;
	String userName;
	String CareerName;
	String PromotionName;
	String SessionName;
	String CourseName;
	Actions action;
	
	public ELTC057_CareerPromotionsPOM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//a[contains(text(),'Administration')]")
	private WebElement AdminTabButton;
	
	@FindBy (xpath = "//div[@class='alert alert-info']//span[contains(text(),'×')]")
	private WebElement CloseAlert;
	
	@FindBy (id="main_content")
	private WebElement AdminTabViewOpened;
	
	@FindBy (xpath = "//div[@id='tabs-4']//a[contains(text(),'Careers and promotions')]")
	private WebElement CareersPromotionsLink;
	
	@FindBy (xpath = "//a[contains(text(),'Careers and promotions')]")
	private WebElement CareersPromotionsLinkDetails;
	
	
	@FindBy (xpath = "//a[2]//img[@title='Careers']")
    private WebElement CareerIcon;
	
	@FindBy (xpath = "//div[@class='actions']//a[2]//img[@title='Add']")
	private WebElement AddCareerButton;
	
	@FindBy (id="career_name")
    private WebElement CareerNameInputBox;
	
	@FindBy (id="career_submit")
	private WebElement SubmitNewCareer;
	
	@FindBy (xpath = "//div[@id='jqgh_careers_name']")
    private WebElement SortCareerNames;	
	
	@FindBy (xpath="//table[@id='careers']//td[@aria-describedby='careers_name']")
	private List<WebElement> CareerNameListed;
	
	@FindBy (xpath = "//a[contains(text(),'Careers and promotions')]")
	private WebElement CareerPromotionsInDetails;
	
	@FindBy (xpath = "//a[3]//img[@title = 'Promotions']")
	private WebElement PromotionsIcon;
	
	@FindBy (xpath = "//div[@class='actions']//a[2]//img[@title= 'Add']")
	private WebElement AddPromotionsButton;
	
	@FindBy (xpath = "//input[@id='name']")
	private WebElement PromotionsNameInputBox;
	
	@FindBy (xpath = "//button[@id='promotion_submit']")
	private WebElement SubmitNewPromotions;
	
	@FindBy (xpath = "//div[@id='jqgh_promotions_name']")
	private WebElement SortPromotionsName;
	
	@FindBy (xpath="//table[@id='promotions']//tr/td[1]")
	private List<WebElement> PromotionNameListed;
	
	@FindBy (xpath = "//div[@class='actions']//a[3]//img[@title = 'Add a training session']")
	private WebElement AddTrainingSessionIcon;
	
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
	
	@FindBy (xpath = "//select[@id='origin']//option[1]")
	private WebElement SelectcourseName;
	
	@FindBy (xpath = "//button[@name='add_course']")
	private WebElement AddCourseButton;
	
	@FindBy (xpath = "//button[@name='next']")
	private WebElement NextButton;
	
	@FindBy (id="user_to_add")
	private WebElement UserToAddTextArea;
	
	@FindBy (xpath = "//div[@id='ajax_list_users_single']/a")
	private WebElement SelectUserFromList;
	
	@FindBy (xpath= "//select[@id='destination_users']/option")
	private WebElement ElementAddedDestinationWindow;
	
	@FindBy (xpath = "//button[@name='next']")
	private WebElement ClickNextButton;
	
	@FindBy (xpath = "//table[@id='session-list-course']//td[@class='title']/a")
	private WebElement CourseNameInSessionDetailsPage;
	
	@FindBy (xpath = "//table[@id='session-user-list']//tr/td/a")
	private WebElement UserNameInSessionDetailsPage;
	
	public void clickOnAdminTabButton() throws InterruptedException
	{
		
		Thread.sleep(1000);
		this.AdminTabButton.click();
		Thread.sleep(2000);
		this.CloseAlert.click();
		
	}
	
	public void clickOnCareersPromotionsLink() throws InterruptedException
	{
		action = new Actions(driver);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CareersPromotionsLink);
		action.moveToElement(CareersPromotionsLink).click().build().perform();
		
	}
	

	public void clickOnCareersPromotionsLinkDetails()
	{
		this.CareersPromotionsLinkDetails.click();
		
	}
	
	public void clickOnCareerIcon()
	{
		this.CareerIcon.click();
		
	}
	
	public void clickOnAddCareerButton()
	{
		this.AddCareerButton.click();
		
	}
	
	public void clickCareerNameInputBox(String careerName)
	{
		this.CareerNameInputBox.sendKeys(careerName);
		CareerName = careerName.trim();
		System.out.println(CareerName);
		
	}
	
	public void clickOnSubmitNewCareer()
	{
		this.SubmitNewCareer.click();
		
	}
	
	public void clickOnSortCareerNames()
	{
		this.SortCareerNames.click();
		
	}
	
	
	public void clickOnPromotionsIcon()
	{
		this.PromotionsIcon.click();
		
	}
	
	public void clickOnAddPromotionsButton()
	{
		this.AddPromotionsButton.click();
		
	}
	
	public void clickOnPromotionsNameInputBox(String promotionName)
	{
		this.PromotionsNameInputBox.sendKeys(promotionName);
		PromotionName = promotionName.trim();
	}
	
	public void clickOnSubmitNewPromotions()
	{
		this.SubmitNewPromotions.click();
		
	}
	
	public void clickOnSortPromotionsName()
	{
		this.SortPromotionsName.click();
		
	}
	
	public void clickOnAddTrainingSessionIcon()
	{
		this.AddTrainingSessionIcon.click();
		
	}
	
	public void clickOnTrainingSessionNameInputBox(String sessionName)
	{
		this.TrainingSessionNameInputBox.sendKeys(sessionName);
		SessionName = sessionName.trim();		
	}
	
	public void selectCoach()
	{
		this.CoachNameBox.click();
		this.EnterCoachNameKeyword.sendKeys("test");
		this.SelectCoachName.click();
		
	}
	
	public void clickOnClickNextStepButton()
	{
		this.ClickNextStepButton.click();
		
	}
	
	public void selectCourse()
	{
		this.SelectcourseName.click();
		CourseName = SelectcourseName.getText().trim();
		this.AddCourseButton.click();
		this.ClickNextButton.click();
		
	}
	
	public void selectUser(String UserName) throws InterruptedException
	{
		this.UserToAddTextArea.sendKeys(UserName);
		userName = String.valueOf(UserName);
		Thread.sleep(2000);
		if(this.SelectUserFromList.getText().contains(userName))
		{
			this.SelectUserFromList.click();
		}
		this.ClickNextButton.click();
	}
	
	public boolean confirmAdminTabClicked() {
    	if (this.AdminTabViewOpened.isDisplayed())
    		return true;
    	else
    		return false;
    }
	
	public boolean confirmIfCareerPromotionsLinkClicked()
	{
		if(CareerIcon.isDisplayed())
			return true;
		else
			return false;
					
	}
	
	public boolean confirmIfCareerCreated()
	{
		boolean ans = false;
		
		for (int i = 0; i < CareerNameListed.size() ; i++) {
				if(CareerNameListed.get(i).getText().contains(CareerName))
		{	ans = true;
		     break;}
		}
		return ans;}
	
	public boolean confirmIfPromotionCreated()
	{
		boolean ans = false;
		for (int i = 0; i < PromotionNameListed.size() ; i++) {
		if(PromotionNameListed.get(i).getText().contains(PromotionName))
		{	
			ans = true;
			return true;
		}
	    }
		return ans;
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
