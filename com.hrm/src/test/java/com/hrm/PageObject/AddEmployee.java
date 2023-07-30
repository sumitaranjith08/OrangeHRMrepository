package com.hrm.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployee {

	
	WebDriver ldriver;
	public AddEmployee(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[text()='Add Employee']")
	WebElement AddEmployee;
	@FindBy(xpath="//input[@name='firstName']")
	WebElement firstName;
	@FindBy(xpath="//input[@name='lastName']")
	WebElement lastName;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")
	WebElement EmpId;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Save;
	
	public void toAddEmployee()
	{
		AddEmployee.click();
	}
	
	
	
	public void tofirstName(String firstname)
	{
		firstName.sendKeys(firstname);
	}
	
	
	public void tolastName(String lastname)
	{
		lastName.sendKeys(lastname);
	}
	
	
	
	public void toEmpId(String idnum)
	{
		EmpId.clear();
		EmpId.sendKeys(idnum);
	}

	public void toSave()
	{
		Save.click();
	}
	
}
