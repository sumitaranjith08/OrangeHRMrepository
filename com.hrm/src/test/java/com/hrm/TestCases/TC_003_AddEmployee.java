package com.hrm.TestCases;

import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import com.hrm.PageObject.AddEmployee;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class TC_003_AddEmployee extends BaseClass{
	
	@Test
	public void Employee() throws CsvValidationException, IOException
	{
		AddEmployee AddEmp=new AddEmployee(driver);
		AddEmp.toAddEmployee();
		CSVReader reader=null;

		try {
			reader=new CSVReader(new FileReader("D:\\temp\\empdata.csv"));
			String[] nextLine=reader.readNext();
			while((nextLine=reader.readNext())!=null) {
				 
								{
						
						int i=0;
							String Firstname=nextLine[i];
							String Lastname=nextLine[i+1];
							String Empid=nextLine[i+2];
							//AddEmployee AddEmp=new AddEmployee(driver);
							AddEmp.tofirstName(Firstname);
							System.out.println(Firstname);
							AddEmp.tolastName(Lastname);
							System.out.println(Lastname);
							AddEmp.toEmpId(Empid);
							System.out.println(Empid);
							AddEmp.toSave();
							
							AddEmp.toAddEmployee();
							
						}
							
							
						
						
					}
					

					
				
				 }
		catch(Exception e)
		{
			e.printStackTrace();
			}
		finally
		{
		reader.close();	
		}
			
	}
}
