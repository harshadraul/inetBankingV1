package com.inetBanking.testcases;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
		
	public String baseURL =  readconfig.getbaseURL(); //"https://demo.guru99.com/V4/";
	public String userName = readconfig.getuserName(); //"mngr385072";
	public String password = readconfig.getPassword(); //"mYnEnYv";
	public static WebDriver driver;
	public static Logger logger;
	public String chropath = readconfig.getChromepath() ;
	
	
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		
		
		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("Chrome")) {
			//System.getProperty("user.dir")+"//Drivers//chromedriver.exe")
			System.setProperty("webdriver.chrome.driver", chropath);
			driver = new ChromeDriver();	
		}
		else if (br.equals("IE"))
		{
			//System.getProperty("user.dir")+"//Drivers//chromedriver.exe")
			System.setProperty("webdriver.ie.driver", readconfig.getIEpath());
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
	}
	
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen (WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screen Shot Taken");
	}
	
	public static String randomString()
	{
		String var = RandomStringUtils.randomAlphabetic(5);
		return var;
	}
}
