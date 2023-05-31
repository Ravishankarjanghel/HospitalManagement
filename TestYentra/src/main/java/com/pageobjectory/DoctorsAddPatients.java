package com.pageobjectory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorsAddPatients {
	@FindBy(xpath = "//span[text()=' Patients ']")
	private WebElement patientDropDown;

	public WebElement getPatientDropDown() {
		return patientDropDown;
	}

	@FindBy(xpath = "//span[text()=' Add Patient']")
	private WebElement addPatientsListOpption;

	@FindBy(xpath = "//input[@name='patname']")
	private WebElement patientNameTextBox;

	@FindBy(xpath = "//input[@name='patcontact']")
	private WebElement patientContactNumTxBox;

	@FindBy(xpath = "//input[@id='patemail']")
	private WebElement patientEmailIdTxBox;

	@FindBy(xpath = "//label[normalize-space(text())='Female']")
	private WebElement femaleRadioButton;

	@FindBy(xpath = "//label[normalize-space(text())='Male']")
	private WebElement maleRadioButton;

	@FindBy(xpath = "//textarea[@name='pataddress']")
	private WebElement patientAddressTxBox;

	@FindBy(xpath = "//input[@name='patage']")
	private WebElement patientAgeTxBox;

	@FindBy(xpath = "//textarea[@name='medhis']")
	private WebElement patientMedicalHistorybtx;

	@FindBy(xpath = "//button[@id='submit']")
	private WebElement addButton;

	public DoctorsAddPatients(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddPatientsListOpption() {
		return addPatientsListOpption;
	}

	public WebElement getPatientNameTextBox() {
		return patientNameTextBox;
	}

	public WebElement getPatientContactNumTxBox() {
		return patientContactNumTxBox;
	}

	public WebElement getPatientEmailIdTxBox() {
		return patientEmailIdTxBox;
	}

	public WebElement getFemaleRadioButton() {
		return femaleRadioButton;
	}

	public WebElement getMaleRadioButton() {
		return maleRadioButton;
	}

	public WebElement getPatientAddressTxBox() {
		return patientAddressTxBox;
	}

	public WebElement getPatientAgeTxBox() {
		return patientAgeTxBox;
	}

	public WebElement getPatientMedicalHistorybtx() {
		return patientMedicalHistorybtx;
	}

	public WebElement getAddButton() {
		return addButton;
	}

}