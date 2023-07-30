package com.hrm.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver ldriver;
public LoginPage(WebDriver rdriver)
{
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}

@FindBy(name="username")
WebElement username;

@FindBy(name="password")
WebElement password;

@FindBy(xpath="//button[@type='submit']")

WebElement Submit;



public void  getUsername(String user) 
{
	username.sendKeys(user);	
}

public void  getPassword(String pwd) 
{
	password.sendKeys(pwd);	
}

public void toLogin()
{
	Submit.click();
}


}
