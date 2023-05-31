package com.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.pageobjectory.DoctorsLoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {

	 public FileUtility flib=new FileUtility();
	public ExcelUtility Eelib=new ExcelUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
public WebDriver driver;

//connect to DataBase
@BeforeSuite(groups= {"smoke","regression"})
public void config_BS() {
	System.out.println("----database connected----");
}

@BeforeClass(groups= {"smoke","regression"})
public void config_BC() throws Throwable{
	String Browser = flib.getPropertyKeyValue("browser");
	if(Browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(); 
	}
	else {
		WebDriverManager.firefoxdriver().setup();
		driver=new ChromeDriver();
	}
	wlib.maximizeWindow(driver);
}
//Login to Application
@BeforeMethod(groups= {"smoke","regression"})
public void config_BM() throws Throwable {
	String url = flib.getPropertyKeyValue("url");
	String username = flib.getPropertyKeyValue("username");
	String password = flib.getPropertyKeyValue("pwd");
	
	driver.get(url);
	wlib.waitForPageLoad(driver);
	
	DoctorsLoginPage dlp=new DoctorsLoginPage(driver);
	dlp.getUsernametxbox().sendKeys(username);
	dlp.getPwdbox().sendKeys(password);
	System.out.println("----login successful----");
}
//Logout from Application
@AfterMethod(groups= {"smoke","regression"})
public void congig_AM() {
	System.out.println("---logout operation perform---");
}
//close the Browser
@AfterClass(groups= {"smoke","regression"})
public void config_AC(){
	driver.quit();
}
//Disconnect database
@AfterSuite(groups= {"smoke","regression"})
public void config_AS() {
	System.out.println("----database disconnected----");
}
	}


