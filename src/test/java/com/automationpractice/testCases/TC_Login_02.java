package com.automationpractice.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationpractice.pageObject.LoginToMyStorePage;
import com.automationpractice.utilities.XLUtils;

public class TC_Login_02 extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pass) throws Exception
	{
		LoginToMyStorePage Login= new LoginToMyStorePage(driver);
		Login.clickSignIn();
		logger.info("Sign in button clicked on homepage");
		Login.setUsername(user);
		Login.setPassword(pass);
		Login.clickSubmit();
		logger.info("submit button clicked");
		if(driver.getPageSource().contains("Authentication failed"))
		{
			logger.info("Authentication Failed, Please enter valid credentials");
			System.out.println("Authentication Failed, Please enter valid credentials");
			captureScreen(driver,"loginDDT");
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
			captureScreen(driver,"loginDDTPass");
			Login.SignOut();
			logger.info("Sign out button clicked");	
		}
		Thread.sleep(5000);
	}
	
	@DataProvider(name="LoginData")
	String [][]getdata() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/automationpractice/testData/LoginTestdata.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][] = new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0; j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
		
	}
}
