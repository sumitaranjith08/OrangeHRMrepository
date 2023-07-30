package com.hrm.TestCases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrm.PageObject.AddEmployee;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class TC_004_EmpDDT extends BaseClass  {
	
	@Test(dataProvider="EmpData")
	
	public void getCSVData(String Firstname, String Lastname, String Empid) throws InterruptedException  {
		AddEmployee AddEmp=new AddEmployee(driver);
		AddEmp.toAddEmployee();
		AddEmp.tofirstName(Firstname);
		Thread.sleep(2000);
		AddEmp.tolastName(Lastname);
		Thread.sleep(2000);
		AddEmp.toEmpId(Empid);
		Thread.sleep(2000);
		
		AddEmp.toSave();
		
		AddEmp.toAddEmployee();	
	}
/*	public String[] getCSVData(String fileName, String sheetName){
		
	
			CSVReader reader=null;
			String[] data = null;
		try {
			reader=new CSVReader(new FileReader("D:\\temp\\empdata.csv"));
			String[] nextLine=reader.readNext();
			while((nextLine=reader.readNext())!=null) {
				
				{			
					int i=0;
						String Firstname=nextLine[i];
						String Lastname=nextLine[i+1];
						String Empid=nextLine[i+2];
						data=new String[i];
			}
			}
		}
	
	catch(IOException e)
	{
		e.printStackTrace();
	
	
	}return data;
		
	}*/
	public String[][] getCSVData(String fileName, String sheetName){
    String csvFile = "D:\\temp\\empdata.csv";
    
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";
    ArrayList<String> content = new ArrayList<String>();

    String[][] returnObj = null;
	try {

        //this loop is pseudo code
        br = new BufferedReader(new FileReader(csvFile));
        int datalength = 0;
        int listsize =0;;
        
        while ((line = br.readLine()) != null) {
            // use comma as separator

            content.add(line);
        }
        System.out.println(content);
        
        listsize = content.size();
        datalength = content.get(0).split(cvsSplitBy).length;
        returnObj = new String[listsize][datalength];
        
        for (int i = 0; i<listsize; i++) {
            
            String[] data = content.get(i).split(cvsSplitBy);
            for (int j=0; j< datalength ; j++) {
                returnObj[i][j] = data[j];
                
            }
            
        }
        

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    System.out.println("Done");
    return returnObj;

}

@DataProvider(name="EmpData")
public Object[][] getData() throws IOException{
	//We are creating an object from the excel sheet data by calling a method that reads data from the excel stored locally in our system
	Object[][] arrObj = getCSVData("D:\\temp\\empdata.csv");
	return arrObj;


}

}