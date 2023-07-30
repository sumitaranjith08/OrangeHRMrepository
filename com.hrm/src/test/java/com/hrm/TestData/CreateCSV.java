package com.hrm.TestData;

import java.io.FileWriter;

public class CreateCSV {
public static void main (String [] args)
{
StringBuilder stringBuilder=new StringBuilder();
stringBuilder.append("FirstName").append(",").append("LastName").append(",").append("EmpID").append("\n");
stringBuilder.append("Arun").append(",").append("A").append(",").append("1001").append("\n");
stringBuilder.append("Bala").append(",").append("B").append(",").append("1002").append("\n");
stringBuilder.append("Chinna").append(",").append("C").append(",").append("1003").append("\n");
stringBuilder.append("Dev").append(",").append("D").append(",").append("1004").append("\n");



try(FileWriter writer=new FileWriter("D:\\temp\\empdata.csv")){
	writer.write(stringBuilder.toString());
	System.out.println("CSV File Created...");
}catch(Exception e)
{
	}
}
}
