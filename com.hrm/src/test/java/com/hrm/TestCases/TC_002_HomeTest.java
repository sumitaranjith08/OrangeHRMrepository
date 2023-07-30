package com.hrm.TestCases;

import org.testng.annotations.Test;

import com.hrm.PageObject.HomePage;

public class TC_002_HomeTest extends BaseClass {
	
	@Test
public void homeTest() throws InterruptedException {
		HomePage Hp=new HomePage(driver);
		Hp.toClickPIM();
	}
}
