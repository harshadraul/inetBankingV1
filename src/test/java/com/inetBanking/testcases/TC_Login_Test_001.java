package com.inetBanking.testcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_Login_Test_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException
	{
			
			logger.info("url is opened");
			LoginPage lp = new LoginPage(driver);
			
			lp.setUserName(userName);
			logger.info("User Name is entered");
			lp.setPassword(password);
			logger.info("Password is entered");
			lp.clickSubmit();
			logger.info("Submit button is clicked"); 
			
			if(driver.getTitle().equals("Guru99 Bank Manager HomePa"))
			{
				Assert.assertTrue(true);
				logger.info("Login test passed");
			}
			else
			{
				captureScreen(driver, "loginTest");
				Assert.assertTrue(false);
				logger.info("Login test is failed");
			}
	}
	
}
