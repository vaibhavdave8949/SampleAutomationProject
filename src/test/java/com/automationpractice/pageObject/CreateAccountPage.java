package com.automationpractice.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class CreateAccountPage{
	
	WebDriver ldriver;
	public CreateAccountPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}	
		@FindBy(xpath="//a[@class='login']")
		@CacheLookup
		WebElement btnSignIn;
	
		@FindBy(id="SubmitCreate")
		@CacheLookup
		WebElement btnClickCreateAccount;
	
		@FindBy(css="input#email_create")
		@CacheLookup
		WebElement txtEmail;
		

		@FindBy(id="id_gender1")
		@CacheLookup
		WebElement radioGender1;
		
		@FindBy(id="id_gender2")
		@CacheLookup
		WebElement radioGender2;
		
		@FindBy(id="customer_firstname")
		@CacheLookup
		WebElement txtFirstname;
		
		@FindBy(id="customer_lastname")
		@CacheLookup
		WebElement txtLastname;
		
		@FindBy(id="email")
		@CacheLookup
		WebElement txtemailValue;
		
		@FindBy(id="passwd")
		@CacheLookup
		WebElement txtPassword;
		
		@FindBy(id="newsletter")
		@CacheLookup
		WebElement chkboxNewsletter;
		
		@FindBy(id="optin")
		@CacheLookup
		WebElement chkboxforSpecialOffers;
		
		@FindBy(id="firstname")
		@CacheLookup
		WebElement txtFirstNameValue;
		
		@FindBy(id="lastname")
		@CacheLookup
		WebElement txtLastNameValue;
		
		@FindBy(id="company")
		@CacheLookup
		WebElement txtCompanyName;
		
		@FindBy(id="address1")
		@CacheLookup
		WebElement txtAddress1;
		
		@FindBy(id="address2")
		@CacheLookup
		WebElement txtAddress2;
		
		@FindBy(id="city")
		@CacheLookup
		WebElement txtCity;
		
		@FindBy(id="id_state")
		@CacheLookup
		WebElement drpdownState;
		
		@FindBy(id="days")
		@CacheLookup
		WebElement drpdownBirthDay;
		
		@FindBy(id="months")
		@CacheLookup
		WebElement drpdownBirthMonth;
		
		@FindBy(id="years")
		@CacheLookup
		WebElement drpdownYear;
		
		@FindBy(id="postcode")
		@CacheLookup
		WebElement txtZipcode;
		
		@FindBy(id="id_country")
		@CacheLookup
		WebElement drpdownCountry;
		
		@FindBy(id="other")
		@CacheLookup
		WebElement txtAdditionalInfo;
		
		@FindBy(id="phone")
		@CacheLookup
		WebElement txtHomePhoneNo;
		
		@FindBy(id="phone_mobile")
		@CacheLookup
		WebElement txtMobilePhoneNo;
		
		@FindBy(id="alias")
		@CacheLookup
		WebElement txtAddressAlias;
		
		
		
		
		public void clickSignIn()
		{
			btnSignIn.click();
		}
		
		public void enterEmail(String email)
		{
			txtEmail.clear();
			txtEmail.sendKeys(email);
		}
		
		public void clickCreateAccountButton()
		{
			btnClickCreateAccount.click();
		}
		
		public void clickonMrGender()
		{
			if(radioGender1.isSelected())
			{
				System.out.println("Radio button is already selected");
			}
			else {
				radioGender1.click();
			}
		}
		public void clickonMrsGender()
		{
			radioGender2.click();
		}
		
		public void enterFirstName(String FirstName)
		{
			txtFirstname.clear();
			txtFirstname.sendKeys(FirstName);
		}
		
		public void enterLastName(String LastName)
		{
			txtLastname.clear();
			txtLastname.sendKeys(LastName);
		}
		
		public String getEmailtext()
		{
			String emailid = txtemailValue.getAttribute("value");
			return emailid;
		}
		
		public void enterPass(String password)
		{
			txtPassword.clear();
			txtPassword.sendKeys(password);
		}
		
		public void SelectSignUpNewsLetter()
		{
			if(chkboxNewsletter.isSelected())
			{
				System.out.println("Sign up for Newsletter checkbox is already selected");
			}
			else
			{
				chkboxNewsletter.click();
			}
		}
		
		public void SelectSpecialOfferUpdatesCheckbox()
		{
			if(chkboxforSpecialOffers.isSelected())
			{
				System.out.println("Sign up for Newsletter checkbox is already selected");
			}
			else
			{
				chkboxforSpecialOffers.click();
			}
		}
		
		public String FirstNameTextValue()
		{
			String firstname = txtFirstNameValue.getAttribute("value");
			System.out.println("First NAme --"+firstname);
			return firstname;
		}
		
		public String LastNameTextValue()
		{
			String lastname = txtLastNameValue.getAttribute("value");
			return lastname;
		}
		
		public void enterCompanyName(String company)
		{
			txtCompanyName.clear();
			txtCompanyName.sendKeys(company);
		}
		public void enterAddress1(String Address1)
		{
			txtAddress1.clear();
			txtAddress1.sendKeys(Address1);
		}
		
		public void enterAddress2(String Address2)
		{
			txtAddress2.clear();
			txtAddress2.sendKeys(Address2);
		}
		
		public void enterCity(String City)
		{
			txtCity.clear();
			txtCity.sendKeys(City);
		}
		
		public void enterState(int indexno)
		{
			Select StateDropDownValues = new Select(drpdownState);
			StateDropDownValues.selectByIndex(indexno);
		}
		
		public void enterBirthDay(int birthday)
		{
			Select daysdropdownvalues = new Select(drpdownBirthDay);
			daysdropdownvalues.selectByIndex(birthday);
		}
		
		public void enterBirthMonth(int birthmonth)
		{
			Select Monthdropdownvalues = new Select(drpdownBirthMonth);
			Monthdropdownvalues.selectByIndex(birthmonth);
		}
		
		public void enterBirthYear(String birthyear)
		{
			Select Yeardropdownvalues = new Select(drpdownYear);
			Yeardropdownvalues.selectByValue(birthyear);
		}
		
		public void enterZipcode(String zipcode)
		{
			txtZipcode.clear();
			txtZipcode.sendKeys(zipcode);
		}
		
		public void selectCountryVerify(String Country)
		{	
			Select Countrydropdownvalues = new Select(drpdownCountry);
			WebElement selectedoption = Countrydropdownvalues.getFirstSelectedOption();
			System.out.println("Selected option from country dropdown ---->"+selectedoption.getText());
			if(selectedoption.getText().contains(Country))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		public void AddAdditionalInfo(String Additionalinfo)
		{
			txtAdditionalInfo.clear();
			txtAdditionalInfo.sendKeys(Additionalinfo);
		}
		
		public void EnterHomePhoneNo(String homephoneno)
		{
			txtHomePhoneNo.clear();
			txtHomePhoneNo.sendKeys(homephoneno);
		}
		
		public void EnterMobilePhoneNo(String mobilephoneno)
		{
			txtMobilePhoneNo.clear();
			txtMobilePhoneNo.sendKeys(mobilephoneno);
		}
		
		public void enterAddressAlias(String Alias)
		{
			txtAddressAlias.clear();
			txtAddressAlias.sendKeys(Alias);
		}
		
}
