package com.hrm.TestUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig()
	{
		File src=new File("./Configuration/config.properties");
		try {
		FileInputStream fis= new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception message: "+e.getMessage());
		}
		
	}
	
	public String getUrl()
	{
		String url=pro.getProperty("baseUrl");
		return url;
		
	}
	
	public String getUserName()
	{
		String user=pro.getProperty("username");
		return user;
		
		}
	
	
	public String getPassword()
	{
		String pwd=pro.getProperty("password");
		return pwd;
	}
	
	
	public String getChrome()
	{
		String chrome=pro.getProperty("cromepath");
		return chrome;
	}
	
	public String getie()
	{
		String ie=pro.getProperty("iepath");
		return ie;
	}
	
	public String getFirefox()
	{
		String firefox=pro.getProperty("firefoxpath");
		return firefox;
	}
	public String getfirstname()
	{
		String firstname=pro.getProperty("firstname");
		return firstname;
	}
	public String getlastname()
	{
		String lastname=pro.getProperty("lastname");
		return lastname;
	}
	
	public String getempid()
	{
		String empid=pro.getProperty("empid");
		return empid;
	}
}
