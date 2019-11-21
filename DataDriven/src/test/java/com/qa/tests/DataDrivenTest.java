package com.qa.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.datadriven.Base.TestBase;
import com.qa.datadriven.utility.UtilityClass;

public class DataDrivenTest extends TestBase {

	
	@BeforeMethod
	public void initializingBrowser() {
		setup();
		
	}
	@DataProvider
	public Iterator<Object[]> getData() throws IOException {
		UtilityClass utility=new UtilityClass();
		ArrayList<Object[]> testData=utility.gettestData();
		return testData.iterator();
	}
	
	@Test(dataProvider="getData")
	public void FormFilling(String fname, String lname) {
		System.out.println(fname+":"+lname);
		EnterElementData(fname, lname); 
	}
	@Test
	@Parameters({"firstname", "lastname"})
	public void parameterscheckin(String firstname, String lastname) {
		EnterElementData(firstname, lastname); 
	}
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}
	
}
