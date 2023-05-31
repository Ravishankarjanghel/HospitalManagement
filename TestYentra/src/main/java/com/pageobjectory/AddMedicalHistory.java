package com.pageobjectory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddMedicalHistory {

	@FindBy(xpath = "//button[@data-toggle='modal']")
	private WebElement addMedicalHistoryButton;
	
	@FindBy(xpath = "//input[@name='bp']")
	private WebElement bloodPressureTextField;
	
	@FindBy(xpath = "//input[@name='bs']")
	private WebElement bloodSugarTextField;
	
	@FindBy(xpath = "//input[@name='weight']")
	private WebElement weightTextField;
	
	@FindBy(xpath = "//input[@name='temp']")
	private WebElement temperatureTextField;
	
	@FindBy(xpath = "//textarea[@name='pres']")
	private WebElement prescriptionTextField;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement submitButton;
	
	public AddMedicalHistory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddMedicalHistoryButton() {
		return addMedicalHistoryButton;
	}

	public WebElement getBloodPressureTextField() {
		return bloodPressureTextField;
	}

	public WebElement getBloodSugarTextField() {
		return bloodSugarTextField;
	}

	public WebElement getWeightTextField() {
		return weightTextField;
	}

	public WebElement getTemperatureTextField() {
		return temperatureTextField;
	}

	public WebElement getPrescriptionTextField() {
		return prescriptionTextField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
}
