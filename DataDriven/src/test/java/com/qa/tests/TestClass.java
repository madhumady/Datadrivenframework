package com.qa.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.Baseclass.MainBase;

//import com.gargoylesoftware.htmlunit.javascript.host.file.File;

public class TestClass extends MainBase{

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	
	XSSFRow row;
	WebElement element;
	
	public String path="C:\\Users\\madhu\\eclipse-workspace\\DataDriven\\src\\main\\java\\com\\qa\\main\\TestData.xlsx";
	
	@Test
		public void loginTest() throws IOException, InterruptedException {
	 
		File src=new File(path);
		FileInputStream input=new FileInputStream(src);
		FileOutputStream output= null;
		workbook= new XSSFWorkbook(input);
		
		sheet=workbook.getSheetAt(0);
		try {
			
			cell=sheet.getRow(0).createCell(2);
			
			cell.setCellValue("Status");
			
			
		for(int i=1;i<=sheet.getLastRowNum();i++)
		{
			
			cell=sheet.getRow(i).getCell(0);
			String username=cell.toString();
			initialization();	
			element=driver.findElement(By.xpath("//input[@type='text' and @name='username']"));
			element.sendKeys(username);
			//element.sendKeys(Keys.ENTER);
			
			//Thread.sleep(3000);
			cell=sheet.getRow(i).getCell(1);
			String password=cell.toString();
			element=driver.findElement(By.xpath("//input[@type='password' and @name='password']"));
			element.sendKeys(password);
			element=driver.findElement(By.xpath("//input[@type='submit' and @value='Login']"));
			element.click();
			Thread.sleep(4000);
			String title=driver.getTitle();
			System.out.println(title);
			String actual="CRMPRO";
			row=sheet.getRow(i);
			cell=row.createCell(2);
			if(title.equals(actual))
			{
				System.out.println("correct executing");
			cell.setCellValue("Pass");
			
			}
			else {
				cell.setCellValue("Fail");
			}
			TearDown();
//			output=new FileOutputStream(new File(path));
//			workbook.write(output);
//			output.close();
//			input.close();
		}
		
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	finally{	
			
				output=new FileOutputStream(new File(path));
				workbook.write(output);
				output.close();
				input.close();
			}
			
	}
		
}
		
	   
			
		

	
		
		
	
	
