package com.actitimenew.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.actitimenew.generic.ActitimeBaseClass;

public class ActitimeLoginPage extends ActitimeBaseClass {
	
	//declaration
	@FindBy(xpath="//div[@class='atLogoImg']")
	private WebElement actiTimeLoginLogo;
	
	@FindBy(name="username")
	private WebElement unTB;
	
	@FindBy(name="pwd")
	private WebElement pwTB;
	
	@FindBy(xpath="//div[text()='Login ']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//span[contains(text(),'invalid')]")
	private WebElement loginErrMsg;
	
	// initialization
	public ActitimeLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	// utilization
		
	public void getCredentials(String un, String pw )
	{
		unTB.sendKeys(un);
		pwTB.sendKeys(pw);
	}
	public void clickLogin()
	{
		loginBtn.click();
	}
	public void varifyLogo()
	{
		Assert.assertTrue(actiTimeLoginLogo.isDisplayed());
	}
	public void varifyErrorMsg()
	{
		WebDriverWait w=new WebDriverWait(driver,10);
		w.until(ExpectedConditions.invisibilityOf(loginErrMsg));
		Assert.assertTrue(loginErrMsg.isDisplayed());
	}
}
