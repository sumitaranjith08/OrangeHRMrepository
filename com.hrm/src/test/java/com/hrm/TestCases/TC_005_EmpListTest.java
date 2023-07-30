package com.hrm.TestCases;

import java.io.FileReader;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrm.PageObject.EmployeeListPage;
import com.opencsv.CSVReader;

public class TC_005_EmpListTest extends BaseClass {
@Test

public void employeeListTest() {
	EmployeeListPage EL=new EmployeeListPage(driver);
	EL.toClickEmployeelist();
	
	CSVReader reader=null;

	try {
		reader=new CSVReader(new FileReader("D:\\temp\\empdata.csv"));
		String[] nextLine=reader.readNext();
		while((nextLine=reader.readNext())!=null) {
			 
			{
					
					int i=0;
						String Firstname=nextLine[i];
						
						//AddEmployee AddEmp=new AddEmployee(driver);
						
						EL.toSearchEmpname(Firstname);
						System.out.println("Records found: Info found Message for"+" "+Firstname);
						EL.toSubmit();
						Thread.sleep(2000);
						if(EL.toMatchname().equalsIgnoreCase(Firstname))
						{
							Assert.assertTrue(true);
							System.out.println("Info found Message for"+" "+Firstname);
						}
						else
						{
							Assert.assertTrue(false);
							System.out.println("Info not found Message");
						}
						
				}Thread.sleep(2000);
				EL.toReset();
				Thread.sleep(2000);
		}
				
			
			 }
	catch(Exception e)
	{
		e.printStackTrace();
		}
	
	EL.toLogout();
	
}



}
