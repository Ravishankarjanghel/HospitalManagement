package com.pageobjectory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorsHomePage {

	@FindBy(xpath="//span[text()=' Dashboard ']")
	private WebElement dashboardbtx;
	
	
	@FindBy(xpath = "//span[text()=' Appointment History ']")
	private WebElement appointmentHistorybtx;
	
	
	@FindBy(xpath = "//span[text()=' Patients ']")
	private WebElement patientsbtx;
	
	
	@FindBy(xpath = "//span[text()=' Add Patient']")
	private WebElement addPatientsListOpption;
	
	
	@FindBy(xpath = "//span[text()=' Manage Patient ']")
	private WebElement managePatientsListOpption;
	
	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	private WebElement DoctorsDropDown;
	
	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	private WebElement logoutTextButton;
	
	
	public WebElement getDoctorsDropDown() {
		return DoctorsDropDown;
	}

	public WebElement getLogoutTextButton() {
		return logoutTextButton;
	}

	public WebElement getAddPatientsListOpption() {
		return addPatientsListOpption;
	}

	public WebElement getManagePatientsListOpption() {
		return managePatientsListOpption;
	}

	@FindBy(xpath = "//span[text()=' Search ']")
	private WebElement search;
	
	
	@FindBy(xpath = "//span[@class='username']")
	private WebElement Doctordropdown;
	 
	public DoctorsHomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getDashboardbtx() {
		return dashboardbtx;
	}

	public WebElement getAppointmentHistorybtx() {
		return appointmentHistorybtx;
	}

	public WebElement getPatientsbtx() {
		return patientsbtx;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getDoctordropdown() {
		return Doctordropdown;
	}
	
}
