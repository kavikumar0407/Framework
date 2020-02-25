package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;



public class ELTC029_RemoveClassesPOM {
 
	private WebDriver driver;
	
	
	public ELTC029_RemoveClassesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//td[@aria-describedby='usergroups_name']")
	private List<WebElement> listOfClassesForRemoval;
	
	@FindBy (xpath = ".//following-sibling::td[@aria-describedby='usergroups_actions']//img[@title = 'Delete']")
	private WebElement DeleteButton;
	
	@FindBy (id="usergroups_name")
	private WebElement sortNameHeaderRemoval;
	
	public void clickOnDeleteButton(String className)
	{
		for (int i = 0 ; i < listOfClassesForRemoval.size() ; i++)
		{
			System.out.println(listOfClassesForRemoval.get(i).getAttribute("title"));
			if(listOfClassesForRemoval.get(i).getAttribute("title").contentEquals(className))
			{
				System.out.println(DeleteButton.getAttribute("src"));
				DeleteButton.click();					
				break;
				
			}
		}
	}
	
	public void clickNameSortHeaderInDeleteView() throws InterruptedException 
	{
		
		Thread.sleep(1000);
		this.sortNameHeaderRemoval.click();
		Thread.sleep(2000);
	}
	
	public void acceptAlert() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}

    public boolean confirmIfClassDeleted(String className)
    {
    	boolean ans = false;
    	for (int i = 0 ; i < listOfClassesForRemoval.size() ; i++)
		{
			System.out.println(listOfClassesForRemoval.get(i).getAttribute("title"));
			if(listOfClassesForRemoval.get(i).getAttribute("title").contentEquals(className))
			{
				return false;
				
			}
			else
				return true;
		}
    	return ans;
    }
}
