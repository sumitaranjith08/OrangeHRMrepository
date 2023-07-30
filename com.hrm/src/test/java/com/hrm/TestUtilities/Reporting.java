package com.hrm.TestUtilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.util.Timer.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting implements ITestListener
{
	
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext testContext)
	{
		
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report-"+timestamp+".html";
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		try {
			spark.loadXMLConfig(System.getProperty("user.dir")+"/test-output/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extent=new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Host name", "Local Host");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Tester Sumi");
		
		
		
		spark.config().setDocumentTitle("Simple Automation Report");
		spark.config().setReportName("Test Report");
		spark.config().setTheme(Theme.DARK);	
		  
	}
	public void onTestSuccess(ITestResult iTestResult) {
	test=extent.createTest(iTestResult.getName());
	System.out.println(iTestResult.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(iTestResult.getName().toUpperCase()+" PASS",ExtentColor.GREEN));
	    

	}

	public void onTestFailure(ITestResult iTestResult) {
		test=extent.createTest(iTestResult.getName());
		System.out.println(iTestResult.getName());
		test.log(Status.FAIL,iTestResult.getThrowable().getMessage());
		test.log(Status.FAIL,MarkupHelper.createLabel(iTestResult.getName().toUpperCase()+" FAIL",ExtentColor.RED));
	    //test.log(Status.FAIL,iTestResult.getThrowable().getMessage());
	   //BaseTest.test.log(Status.FAIL,MarkupHelper.createLabel(iTestResult.getName().toUpperCase()+" FAIL",ExtentColor.RED));
String screenshotpath=System.getProperty("user.dir")+"\\Screenshots\\"+iTestResult.getName()+".png";
File f=new File(screenshotpath);
if(f.exists())
	    try {
	    	test.fail("Screenshot is below:" +test.addScreenCaptureFromPath(screenshotpath));
	      
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	public void onTestSkipped(ITestResult iTestResult) {
		test=extent.createTest(iTestResult.getName());
		System.out.println(iTestResult.getName());
//		test.log(Status.SKIP, MarkupHelper.createLabel(iTestResult.getName().toUpperCase()+" SKIPPED",ExtentColor.PURPLE));
		test.log(Status.SKIP, "TEST SKIPPED");
	}

		

	public void onFinish(ITestContext iTestContext) {
	extent.flush();
	}
		
	
    
}


	
	
	
	
	
	
	
