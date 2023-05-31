package com.hmsPractice;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;

import com.genericutility.FileUtility;
import com.genericutility.Practice.ExcelUtility;
import com.google.common.collect.Multiset.Entry;
import com.pageobjectory.DoctorsAddPatients;
import com.pageobjectory.DoctorsLoginPage;
import com.pageobjectory.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddPatientShortly {
public static void main(String[]arg) throws Throwable
{
	WebDriver driver = WebDriverManager.chromedriver().create();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	FileUtility fu=new FileUtility();
	 String URL = fu.getPropertyKeyValue("url");
	 driver.get(URL);
	 HomePage hm=new HomePage(driver);
	 hm.getDoctorsbtn().click();
	 
	 DoctorsLoginPage dl=new DoctorsLoginPage(driver);
	 dl.getUsernametxbox().sendKeys("suhas@outlook.com");
	 dl.getPwdbox().sendKeys("Suhas@123");
	 dl.getLogintxbox().click();
	 
	 DoctorsAddPatients dap=new DoctorsAddPatients(driver);
	 dap.getPatientDropDown().click();
	 dap.getAddPatientsListOpption().click();
	 
	// ExcelUtility eu=new ExcelUtility();
//	 int rowNum = eu.getRowCount("AddPatient")+1;
//	 int cellNum = eu.getCellCount("AddPatient");
//	 HashMap<String,String> map=new HashMap<String, String>();
//	 for(int i=0;i<rowNum;i++) {
//		 map.put(eu.getDataFromExcel("AddPatient", i, 0),eu.getDataFromExcel("AddPatient", i, 0));
//	 }
	 ExcelUtility eu=new ExcelUtility();
	 getData(driver, eu.getMultipleData("AddPatient"));
	 Thread.sleep(20000);
}
public static void getData(WebDriver driver,HashMap<String ,String> field) {
	
for(java.util.Map.Entry<String, String> element:field.entrySet()) {
	driver.findElement(By.name(element.getKey())).sendKeys(element.getValue());
}
}

}
