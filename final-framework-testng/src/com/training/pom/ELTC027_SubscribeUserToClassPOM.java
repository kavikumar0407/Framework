package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ELTC027_SubscribeUserToClassPOM {
  
		private WebDriver driver; 
		private Actions action;
		private String user1,user2;
		
		public ELTC027_SubscribeUserToClassPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy (id="usergroups_name")
		private WebElement sortNameHeader;
		
		@FindBy (xpath = "//td[@aria-describedby='usergroups_name']")
		private List<WebElement> findClassInList;
		
		@FindBy (xpath = ".//following-sibling::td[@aria-describedby='usergroups_actions']/a[1]/img")
		private WebElement subscribeUsersButton;
		
		@FindBy (id= "usergroups")
		private WebElement listOfClasses;
		
		@FindBy (xpath = "//form[@name='formulaire']")
		private WebElement confirmSubscribeUsersButtonClicked;
		
		@FindBy (xpath = "//select[@id='elements_not_in']/option[4]")
		private WebElement selectUsers;
		
		@FindBy (xpath = "//select[@id='elements_not_in']/option[6]")
		private WebElement selectUsers2;
		
		@FindBy (xpath = "//div[@class ='col-md-2']//button[1]")
		private WebElement clickArrow;
		
		@FindBy (xpath = "//select[@id='elements_in']/option")
		private WebElement selectedUsers;
		
		@FindBy (xpath = "//button[@class='btn btn-primary']")
		private WebElement clickOnSubscribeButton;
		
		@FindBy (xpath = ".//following-sibling::td[@aria-describedby='usergroups_users']/a")
		private WebElement usersAddedToClass;
		
		public void clickNameSortHeader() throws InterruptedException 
		{
			
			Thread.sleep(3000);
			this.sortNameHeader.click();
		}
		
		public void findClassInList(String className) throws InterruptedException
		{
			Thread.sleep(3000);
			for (int i = 0 ; i < findClassInList.size() ; i++)
			{
				if(findClassInList.get(i).getAttribute("title").contentEquals(className))
				{
					//System.out.println("get src " + subscribeUsersButton.getAttribute("src"));
					subscribeUsersButton.click();					
					//driver.findElement(By.xpath(".//following-sibling::td[@aria-describedby='usergroups_actions']/a/img")).click();
					break;
					
				}
			}
			
		}
		
		public boolean confirmSubscribeUsersButtonClicked() {
			if (confirmSubscribeUsersButtonClicked.isDisplayed())
					return true;
			else
				return false;
			
			
		}
		
		public void selectUsersFromList() {
			action = new Actions(driver);
			
			this.selectUsers.click();
			user1 = this.selectUsers.getAttribute("value");
			
			action.keyDown(Keys.CONTROL);
			this.selectUsers2.click();
			user2 = this.selectUsers2.getAttribute("value");
			
			action.keyUp(Keys.CONTROL);
			
		}
		
		public void clickArrow()
		{
			this.clickArrow.click();
		}
		
		public boolean confirmIfUsersInGroupAreAdded() {
			
			if(driver.findElement(By.xpath("//select[@id='elements_in']//option[@value ='"+user1+"']")).isDisplayed() && (driver.findElement(By.xpath("//select[@id='elements_in']//option[@value='"+user2+"']")).isDisplayed()))
			    
				return true;
			else
				return false;
			
		 }
		
		public void clickOnSubscribeButton() throws InterruptedException
		{
			//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickOnSubscribeButton);
			//Thread.sleep(2000);
			//action.moveToElement(this.clickOnSubscribeButton).click().build().perform();
			this.clickOnSubscribeButton.click();
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
		
        
}
