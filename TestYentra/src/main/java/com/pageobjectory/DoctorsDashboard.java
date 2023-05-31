package com.pageobjectory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorsDashboard {

	@FindBy(xpath = "//a[contains(text(),'Update Profile')]")
	private WebElement updateProfileLink;
	
	@FindBy(xpath = "//a[contains(text(),'View Appointment History')]")
	private WebElement viewAppointmentHistory;
	
	public DoctorsDashboard(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getUpdateProfileLink() {
		return updateProfileLink;
	}

	public WebElement getViewAppointmentHistory() {
		return viewAppointmentHistory;
	}
	
}
