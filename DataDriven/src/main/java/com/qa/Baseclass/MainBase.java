package com.qa.Baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MainBase {
	public WebDriver driver;
	
	public void initialization() {
		//System.setProperty("Webdriver.chrome.driver", "C:\\Users\\madhu\\Downloads\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\madhu\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://classic.crmpro.com/login.cfm");
	}
	public void TearDown() {
		driver.close();
	}
}
