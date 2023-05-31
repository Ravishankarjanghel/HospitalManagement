package com.pageobjectory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookAppointment {

	@FindBy(xpath = "//select[@name='Doctorspecialization']")
	private WebElement DoctorSpecialization;
	
	@FindBy(xpath = "//select[@id='doctor']")
	private WebElement selectDoctorTextField;
	
	@FindBy(xpath = "//select[@id='fees']")
	private WebElement feesTextField;
	
	@FindBy(xpath = "//input[@name='appdate']")
	private WebElement dateTextField;
	
	@FindBy(xpath = "//input[@id='timepicker1']")
	private WebElement timeTextField;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement submitButton;
	
	public BookAppointment(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getDoctorSpecialization() {
		return DoctorSpecialization;
	}

	public WebElement getSelectDoctorTextField() {
		return selectDoctorTextField;
	}

	public WebElement getFeesTextField() {
		return feesTextField;
	}

	public WebElement getDateTextField() {
		return dateTextField;
	}

	public WebElement getTimeTextField() {
		return timeTextField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
}
