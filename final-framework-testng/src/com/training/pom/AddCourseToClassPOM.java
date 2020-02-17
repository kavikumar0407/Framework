package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AddCourseToClassPOM {
  
	private WebDriver driver;
	private Actions action;
	String course1,course2;
	
	public AddCourseToClassPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//td[@aria-describedby='usergroups_name']")
	private List<WebElement> findClassListForCourse;
	
	@FindBy (xpath = ".//following-sibling::td[@aria-describedby='usergroups_actions']/a[2]/img")
	private WebElement subscribeCourseButton;
	
	@FindBy (xpath = "//form[@name='formulaire']")
	private WebElement confirmSubscribeCourseButtonClicked;
	
	@FindBy (id="usergroups_name")
	private WebElement sortNameHeader;
	
	@FindBy (xpath = "//select[@id='elements_not_in']/option[1]")
	private WebElement selectCourse1;
	
	@FindBy (xpath = "//select[@id='elements_not_in']/option[2]")
	private WebElement selectCourse2;
	
	@FindBy (xpath = "//td[2]//button[1]")
	private WebElement clickArrow;
	
	@FindBy (xpath = "//select[@id='elements_in']/option")
	private WebElement selectedCourses;
	
	@FindBy (xpath = "//button[@class='btn btn-primary']")
	private WebElement clickOnSubscribeButton;
	
	@FindBy (xpath = ".//following-sibling::td[@aria-describedby='usergroups_courses']")
	private WebElement coursesAddedToClass;
	
	public void clickSubscribeCourseButton(String className) throws InterruptedException
	{
		Thread.sleep(3000);
		System.out.println(findClassListForCourse);
		for (int i = 0 ; i < findClassListForCourse.size() ; i++)
		{
			System.out.println(findClassListForCourse.get(i).getAttribute("title"));
			if(findClassListForCourse.get(i).getAttribute("title").contentEquals(className))
			{
				System.out.println(subscribeCourseButton.getAttribute("src"));
				subscribeCourseButton.click();					
				break;
				
			}
		}
	}
	
	public boolean confirmSubscribeCourseButtonClicked() {
		if (confirmSubscribeCourseButtonClicked.isDisplayed())
				return true;
		else
			return false;
		
		
	}
	
	public void clickNameSortHeader() throws InterruptedException 
	{
		
		Thread.sleep(2000);
		this.sortNameHeader.click();
	}
	
	public void selectCoursesFromList() {
		action = new Actions(driver);
		
		this.selectCourse1.click();
		course1 = this.selectCourse1.getAttribute("value");
		
		action.keyDown(Keys.CONTROL);
		this.selectCourse2.click();
		course2 = this.selectCourse2.getAttribute("value");
		
		action.keyUp(Keys.CONTROL);
		
	}
	
	public void clickArrow()
	{
		this.clickArrow.click();
	}
	
	public boolean confirmIfCoursesInGroupAreAdded() {
		
		if(driver.findElement(By.xpath("//select[@id='elements_in']//option[@value ='"+course1+"']")).isDisplayed() && (driver.findElement(By.xpath("//select[@id='elements_in']//option[@value='"+course2+"']")).isDisplayed()))
		    
			return true;
		else
			return false;
		
	 }
	
	public void clickOnSubscribeButton() throws InterruptedException
	{
		this.clickOnSubscribeButton.click();
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
	
	
}
	
	

