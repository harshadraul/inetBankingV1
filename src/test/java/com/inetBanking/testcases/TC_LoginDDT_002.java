package com.inetBanking.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;


public class TC_LoginDDT_002 extends BaseClass 
{
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user,String password) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.logOut();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
		
	}
	
	public boolean isAlertPresent()//User defined method created to check if method is present or not
	{
		try
		{
			driver.switchTo().alert();
			return(true);
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	
	
	
	@DataProvider(name="LoginData")
	String [][] getdata() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testdata/LoginData.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][] = new String[rownum][colcount];
		
		for(int i =1;i<= rownum;i++ )
		{
			for(int j=0;j<colcount;j++)
			{
				loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			
			}
		}
		
		return loginData;
	}
}
