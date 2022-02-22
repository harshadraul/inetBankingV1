package com.inetBanking.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	@CacheLookup WebElement linkAddNewCustomer;
	
//	WebElement linkAddNewCustomer = ldriver.findElement(By.xpath("//a[contains(text(),'New Customer')]"));
	
	@FindBy(name="name")
	@CacheLookup WebElement txtCustomerName;
	
	@FindBy(name="rad1")
	@CacheLookup WebElement rGender;
	
	@FindBy(name="dob")
	@CacheLookup WebElement txtdob;
	
	@FindBy(name="addr")
	@CacheLookup WebElement txtAddress;
	
	@FindBy(name="city")
	@CacheLookup WebElement txtCity;
		
	@FindBy(name="state")
	@CacheLookup WebElement txtState;
	
	@FindBy(name="pinno")
	@CacheLookup WebElement txtPin;
	
	@FindBy(name="telephoneno")
	@CacheLookup WebElement txtTelephonenumber;
	
	
	@FindBy(name="emailid")
	@CacheLookup WebElement txtEmail;
	
	@FindBy(name="sub")
	@CacheLookup WebElement btnSubmit;
	
	@FindBy(name="password")
	@CacheLookup WebElement txtPassword;
	
	
	public void clickAddNewCustomer() {
		linkAddNewCustomer.click();
	}
	
	public void custName(String name)
	{
		txtCustomerName.sendKeys(name);
	}
	public void custGender(String gender)
	{
		rGender.click();
	}
	public void custDOB(String mm,String dd,String yy)
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	public void custAddress(String address)
	{
		txtAddress.sendKeys(address);
	}
	public void custCity(String custCity)
	{
		txtCity.sendKeys(custCity);
	}
	public void custState(String custState)
	{
		txtState.sendKeys(custState);
	}
	public void custPin(int custPin)
	{
		txtPin.sendKeys(String.valueOf(custPin));
	}
	public void custPhone(String custPhone)
	{
		txtTelephonenumber.sendKeys(custPhone);
	}
	public void custEmail(String custEmail)
	{
		txtEmail.sendKeys(custEmail);
	}
	public void custPassword(String custPassword)
	{
		txtPassword.sendKeys(custPassword);
	}
	public void clickSubmit()
	{
		btnSubmit.click();
	}
}
