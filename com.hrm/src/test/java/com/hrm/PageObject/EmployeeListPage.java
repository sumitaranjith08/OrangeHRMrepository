package com.hrm.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeListPage {
	WebDriver ldriver;
	public EmployeeListPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[text()='Employee List']")
	WebElement EmployeeList;
	
	@FindBy(xpath="(//input[@placeholder='Type for hints...'])[1]")
			WebElement EmpName;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")
			WebElement Empid;
	
		
	@FindBy(xpath="//button[@type='submit']")
			WebElement submit;
	
	@FindBy(xpath="//button[@type='reset']")
	WebElement reset;
	               
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[3]/div")
			WebElement resultname;
			
		
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div")
	WebElement fid;
	
	@FindBy(xpath="//a[@href='/web/index.php/dashboard/index']")
	WebElement dashboard;
			
public void toClickEmployeelist()
{
	EmployeeList.click();
}

public void toSearchEmpname(String name)
{
	
	EmpName.sendKeys(name);
	
}

public void toSearchEmpid(String id)
{
	Empid.sendKeys(id);
}
public void toSubmit()
{
	submit.click();
	
}

public void toReset()
{
	reset.click();
	
}

public String toMatchname()
{
	
String result=resultname.getText();
return result;
	
	}
public void toMatchid()
{
	fid.getText();
	}
public void toLogout()
{
	dashboard.getText();
	}

}