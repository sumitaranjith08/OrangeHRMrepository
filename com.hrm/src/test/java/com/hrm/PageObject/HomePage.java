package com.hrm.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{

	
	
	WebDriver ldriver;
	public HomePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	
	
	
	@FindBy(xpath="//a[contains(@class, 'oxd-main-menu-item')]//child::span[text()='PIM']")
	WebElement PIM;
	
	
	public void toClickPIM()
	{
		PIM.click();
	}
	
}
