package com.pageobjectory;

import javax.xml.ws.WebEndpoint;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorsManagePatients {

	@FindBy(xpath = "//span[text()=' Patients ']")
	private WebElement patientDropDow;
	
	@FindBy(xpath = "//span[text()=' Manage Patient ']")
	private WebElement managePatientTxtField;
	
	@FindBy(xpath = "//table[@id='sample-table-1']//td[text()='1234567890']/..//a[contains(@href,'view')]")
	private WebElement viewPointIcon;
	
	public WebElement getViewPointIcon() {
		return viewPointIcon;
	}

	public DoctorsManagePatients(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getPatientDropDow() {
		return patientDropDow;
	}

	public WebElement getManagePatientTxtField() {
		return managePatientTxtField;
	}
}
