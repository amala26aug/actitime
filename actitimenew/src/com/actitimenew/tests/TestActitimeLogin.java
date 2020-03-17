package com.actitimenew.tests;

//import org.testng.Assert;
import org.testng.annotations.Test;

import com.actitimenew.generic.ActitimeBaseClass;
import com.actitimenew.generic.FWUtils;
import com.actitimenew.page.ActitimeLoginPage;

public class TestActitimeLogin extends ActitimeBaseClass {
	
	@Test
	public void inputs()
	{
		ActitimeLoginPage lp=new ActitimeLoginPage(driver);
		lp.varifyLogo();
		String un = FWUtils.getXLdata(DATA_PATH, "valid", 1, 0);
		String pw = FWUtils.getXLdata(DATA_PATH, "valid", 1, 1);
		lp.getCredentials(un, pw);
		lp.clickLogin();
		//Assert.fail();
	}
	

}
