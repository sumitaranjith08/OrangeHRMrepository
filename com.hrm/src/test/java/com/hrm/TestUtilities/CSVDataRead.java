package com.hrm.TestUtilities;

import java.io.FileReader;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.hrm.PageObject.AddEmployee;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CSVDataRead {
String csvFile="D:\\temp\\empdata.csv";
WebDriver driver;
private CSVReader csvReader;
String[] cell;
@Test

public void verify_search() throws IOException, CsvValidationException
{
	AddEmployee AddEmp=new AddEmployee(driver);
AddEmp.toAddEmployee();
	
	
		csvReader=new CSVReader(new FileReader(csvFile));
		while((cell=csvReader.readNext())!=null) {
		for(int i=0; i<3; i++) {
			//for(int j=1; j<cell.length; j++) {
			String Firstname=cell[i];
			driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(Firstname);
			System.out.println(Firstname);
			String Lastname=cell[i+1];
			driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(Lastname);
			System.out.println(Lastname);
			String Empid=cell[i+2];
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")).sendKeys(Empid);
			System.out.println(Empid);
	
		//}
		}
	}
	
	
	
	
	AddEmp.toSave();
	
}
}

