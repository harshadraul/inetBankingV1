package com.inetBanking.testcases;

import java.io.IOException;


import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddNewCustomer_003 extends BaseClass{

	@Test
	public void AddNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		logger.info("Username provided");
		lp.setUserName(userName);
		logger.info("Password provided");
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
				
		addcust.clickAddNewCustomer();
		
		Thread.sleep(10000);
		
		logger.info("Providing new customer details...");
		addcust.custName("Harshad");
		addcust.custGender("m");
		addcust.custDOB("07", "11", "1995");
		addcust.custAddress("India");
		addcust.custCity("Mumbai");
		addcust.custState("Maha");
		addcust.custPin(998822);
		addcust.custPhone("1234567890");
		
		String email = randomString()+"@gmail.com";
		
		addcust.custEmail(email);
		addcust.custPassword("123456");
		addcust.clickSubmit();
		
		Thread.sleep(10000);
		
		boolean res =driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (res == true)
		{
			Assert.assertTrue(true);
			logger.info("test case is passed");
		}
		else
		{
			captureScreen(driver, "addnewCustomer");
			Assert.assertTrue(false);
			logger.info("Testcase is failed");
		}
		
	}
	
	
}
