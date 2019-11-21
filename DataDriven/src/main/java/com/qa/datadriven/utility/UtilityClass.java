package com.qa.datadriven.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class UtilityClass {

	public  XSSFWorkbook workbook;
	public  XSSFSheet sheet;
	public  XSSFCell cell;
	
	public String path="C:\\Users\\madhu\\eclipse-workspace\\DataDriven\\src\\main\\java\\com\\qa\\datadriven\\utility\\myTestData.xlsx";
	
	
	@Test
	public  ArrayList<Object[]> gettestData() throws IOException {
		
		//File file=new File(path);
		FileInputStream fis=new FileInputStream(new File(path));
		workbook= new XSSFWorkbook(fis);
		sheet=workbook.getSheetAt(0);

		ArrayList<Object[]> myData=new ArrayList<Object[]>();
		for(int i=1;i<=sheet.getLastRowNum();i++) {
			cell=sheet.getRow(i).getCell(0);
			String firstname=cell.toString();
			cell=sheet.getRow(i).getCell(1);
			String lastname=cell.toString();
			Object[] obj= {firstname,lastname};
			myData.add(obj);
	
		}
		
		return myData;
		
	}
	
}
