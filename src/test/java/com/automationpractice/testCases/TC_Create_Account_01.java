package com.automationpractice.testCases;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automationpractice.pageObject.CreateAccountPage;
import com.automationpractice.utilities.XLUtils;

public class TC_Create_Account_01 extends BaseClass{
	
	@Test(enabled=false)
	public void emailExistValidation()
	{
		
	}
	
	@Test
	public void CreateNewUserAccount() throws InterruptedException, IOException
	{
		
		CreateAccountPage CA = new CreateAccountPage(driver);
		CA.clickSignIn();
		logger.info("Sign in button clicked");
		String path=System.getProperty("user.dir")+"/src/test/java/com/automationpractice/testData/CreateUserAccountData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		String userdata[][] = new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0; j<colcount;j++)
			{
				userdata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		String emailid = userdata[0][0];
		String gender = userdata[0][1];
		String FirstName = userdata[0][2];
		String LastName = userdata[0][3];
		String Password = userdata[0][4];
		String ComapnyName = userdata[0][5];
		String Address1 = userdata[0][6];
		String Address2 = userdata[0][7];
		String City = userdata[0][8];
		String zipcode = userdata[0][10];
		String Country = userdata[0][11];
		String AditionalInfo = userdata[0][12];
		String HomePhoneNO = userdata[0][13];
		String MobilePhoneNo = userdata[0][14];
		String AddressAlias = userdata[0][15];	
		
		CA.enterEmail(emailid);
		logger.info("Email Entered");
		CA.clickCreateAccountButton();
		logger.info("Created Account button clicked");
		
		if(gender.equalsIgnoreCase("Male"))
		{
		CA.clickonMrGender();
		}
		else
		{
			CA.clickonMrsGender();
		}
		logger.info("Gender option clicked");
		
		CA.enterFirstName(FirstName);
		logger.info("First Name entered");
		CA.enterLastName(LastName);
		logger.info("LastName entered");
		// Scrolling down Code
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(5000);
		// Email text field validation to check already enetered email is correct
		Assert.assertTrue(CA.getEmailtext().equalsIgnoreCase(emailid));
		logger.info("Email field validation done");
		captureScreen(driver,"TillEmailValidaton");	
		CA.enterPass(Password);
		logger.info("Password entered");
		// Select day for birthday from dropdown values
		CA.enterBirthDay(20);
		logger.info("Day selected");
		// Select month for birthday from dropdown values
		CA.enterBirthMonth(3);
		logger.info("Month selected");
		CA.enterBirthYear("2012");
		logger.info("Year selected");
		
		js.executeScript("window.scrollBy(0,400)");
		// Selecting signup for newletter checkbox
		CA.SelectSignUpNewsLetter();
		// Selecting checkbox for receiving special offer updates
		CA.SelectSpecialOfferUpdatesCheckbox();
		// Taking screenshot till checkboxes
		captureScreen(driver,"TillCheckboxes");
		js.executeScript("window.scrollBy(0,200)");
		logger.info("Scrolling done");
		Assert.assertTrue(CA.FirstNameTextValue().contains(FirstName));
		Assert.assertTrue(CA.LastNameTextValue().contains(LastName));
		logger.info("Firstname Lastname validation done.....");
		logger.info("Entering Company Details");
		CA.enterCompanyName(ComapnyName);
		CA.enterAddress1(Address1);
		CA.enterAddress2(Address2);
		CA.enterCity(City);
		CA.enterState(5);		
		captureScreen(driver,"TillStateEntered");
		Thread.sleep(5000);
		CA.enterZipcode(zipcode);
		CA.selectCountryVerify(Country);
		logger.info("Country selected");
		captureScreen(driver,"TillCountrySelection");
		CA.AddAdditionalInfo(AditionalInfo);
		CA.EnterHomePhoneNo(HomePhoneNO);
		CA.EnterMobilePhoneNo(MobilePhoneNo);
		CA.enterAddressAlias(AddressAlias);
		Thread.sleep(5000);
		logger.info("Address Alias enetered");	
	}

}
