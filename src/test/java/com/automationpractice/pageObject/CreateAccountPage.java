package com.automationpractice.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateAccountPage{
	
	WebDriver ldriver;
	public CreateAccountPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}	
		@FindBy(css="input#email_create")
		@CacheLookup
		WebElement txtSignIn;
		
		public void clickSignIn()
		{
			txtSignIn.click();
		}
}
