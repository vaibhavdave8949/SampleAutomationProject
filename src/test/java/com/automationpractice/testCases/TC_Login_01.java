package com.automationpractice.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.pageObject.LoginToMyStorePage;

public class TC_Login_01 extends BaseClass{
	
	@Test
	public void signIn() throws IOException
	{
		//driver.get(URL);
		logger.info("URL opened");
		LoginToMyStorePage Login= new LoginToMyStorePage(driver);
		Login.clickSignIn();
		logger.info("Sign in button clicked on homepage");
		Login.setUsername(username);
		Login.setPassword(password);
		Login.clickSubmit();
		logger.info("submit button clicked");
		
		
		String title=driver.getTitle();
		System.out.println("Title ----"+title);
		
		if(driver.getTitle().contains("My Store"))
		{
			Assert.assertTrue(true);	
		}
		else
		{
			captureScreen(driver,"Signin");
			Assert.assertTrue(false);
		}
		
//		if(driver.getPageSource().contains("Authentication failed"))
//		{
//			System.out.println("Authentication Failed, Please enter valid credentials");
//			captureScreen(driver,"InvalidLogin");
//			Assert.assertTrue(false);
//		}
//		else {
//			Assert.assertTrue(true);
//		}
	}

}
