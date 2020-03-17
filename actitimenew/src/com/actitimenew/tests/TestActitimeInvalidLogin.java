package com.actitimenew.tests;

import org.testng.annotations.Test;

import com.actitimenew.generic.ActitimeBaseClass;
import com.actitimenew.generic.FWUtils;
import com.actitimenew.page.ActitimeLoginPage;

public class TestActitimeInvalidLogin extends ActitimeBaseClass  {
	@Test
	public void invalidInputs() throws InterruptedException
	{
		ActitimeLoginPage lp=new ActitimeLoginPage(driver);
		lp.varifyLogo();
		for(int i=1; i<FWUtils.getLastRowNumber(DATA_PATH,"invalid"); i++)
		{
			String un = FWUtils.getXLdata(DATA_PATH, "invalid", i, 0);
			String pw = FWUtils.getXLdata(DATA_PATH, "invalid", 1, 1);
			lp.getCredentials(un, pw);
			lp.clickLogin();
			Thread.sleep(4000);
		}
		//Assert.fail();
	}

}
