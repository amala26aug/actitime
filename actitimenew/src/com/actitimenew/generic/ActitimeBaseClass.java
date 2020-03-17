package com.actitimenew.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class ActitimeBaseClass implements IAutoConstants {

	public static WebDriver driver;
	public static int pass,fail;
	@BeforeSuite
	public void projectInfo()
	{
		Reporter.log("This project majorly focus on the employee time sheet",true);
	}
	
	@BeforeTest
	public void setPro()
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}
	
	@BeforeMethod
	public void launchApp()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
	}
	
	@AfterMethod
	public void tearDown(ITestResult it)
	{
		if(it.getStatus()==2)
		{
			String name = it.getName();
			FWUtils.getSnapshot(driver, PHOTO_PATH+name+".png");
			fail++;
		}else if(it.getStatus()==1)
		{
			pass++;
		}
		
		driver.quit();
	}

	@AfterSuite
	public void reportGeneration()
	{
		FWUtils.setXLData(REPORT_PATH, "Sheet1", 1, 0, pass);
		FWUtils.setXLData(REPORT_PATH, "Sheet1", 1, 1, fail);
	}
	
	
	
}
