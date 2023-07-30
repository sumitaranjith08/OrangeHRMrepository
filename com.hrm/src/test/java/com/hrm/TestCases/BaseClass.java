package com.hrm.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.core.config.Loggers;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.hrm.TestUtilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	public String baseUrl=readconfig.getUrl();
	public String username=readconfig.getUserName();
	public String password=readconfig.getPassword();
	

	public static WebDriver driver;
	public static Loggers logger;
	
@BeforeTest

public void setUp() throws InterruptedException
{
System.setProperty("webdriver.chrome.driver", "C:\\DriveJar\\chromedriver_win32\\chromedriver.exe");	

//ChromeOptions options=new ChromeOptions();
//options.addArguments("disable-notifications");
driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS) ;
}
public void captureScreen(WebDriver driver, String tname) throws IOException{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
	FileUtils.copyFile(src, target);
	System.out.println("Screenshot taken");
	
}









@AfterTest
public void tearDown()
{
driver.close();
}


}
