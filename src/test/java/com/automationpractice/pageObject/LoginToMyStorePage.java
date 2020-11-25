package com.automationpractice.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginToMyStorePage {
	
	WebDriver ldriver;
	public LoginToMyStorePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	

	
	@FindBy(xpath="//a[@class='login']")
	@CacheLookup
	WebElement txtSignIn;
	
	@FindBy(id="email")
	@CacheLookup
	WebElement txtEnterEmail;
	
	@FindBy(id="passwd")
	@CacheLookup
	WebElement txtEnterPass;
	
	@FindBy(id="SubmitLogin")
	@CacheLookup
	WebElement SubmitLogin;
	
	@FindBy(xpath="//a[@class='logout']")
	@CacheLookup
	WebElement SignOut;
	public void clickSignIn()
	{
		txtSignIn.click();
	}
	
	public void setUsername(String uname)
	{
		txtEnterEmail.sendKeys(uname);
	}
	public void setPassword(String pwd)
	{
		txtEnterPass.sendKeys(pwd);
	}
	public void clickSubmit()
	{
		SubmitLogin.click();
	}
	public void SignOut()
	{
		SignOut.click();
	}
	
}
	


