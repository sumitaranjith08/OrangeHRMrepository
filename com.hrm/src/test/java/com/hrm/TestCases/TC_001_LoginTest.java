package com.hrm.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrm.PageObject.LoginPage;
import com.opencsv.exceptions.CsvValidationException;

public class TC_001_LoginTest extends BaseClass{
@Test
public void loginTest() throws InterruptedException, CsvValidationException, IOException
{driver.get(baseUrl);
	LoginPage lp=new LoginPage(driver);
	lp.getUsername(username);
	lp.getPassword(password);
	lp.toLogin();
		
	if(driver.getTitle().equalsIgnoreCase("OrangeHRM"))
	{
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
	}
	
	

}

}

