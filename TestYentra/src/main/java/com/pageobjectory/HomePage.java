package com.pageobjectory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath = "//a[text()='Hospital Management system']")
	private WebElement hmsTitleLink;

	@FindBy(xpath = "//li[@class='active']//a[text()='Home']")
	private WebElement homebtx;

	@FindBy(xpath = "//div[@class='top-nav']//a[text()='contact']")
	private WebElement contactbtx;

	@FindBy(xpath = "//h3[text()='Patients']/following-sibling::div//a")
	private WebElement patientsbtn;

	@FindBy(xpath = "//h3[text()='Doctors Login']/..//a")
	private WebElement doctorsbtn;

	@FindBy(xpath = "//h3[text()='Admin Login']/..//a")
	private WebElement adminbtn;

	@FindBy(xpath = "//div[@class='footer-left']//a[text()='Home']")
	private WebElement downhomebtn;

	@FindBy(xpath = "//div[@class='footer-left']//a[text()='contact']")
	private WebElement downcontactbtn;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getHmsTitleLink() {
		return hmsTitleLink;
	}

	public WebElement getHomebtx() {
		return homebtx;
	}

	public WebElement getContactbtx() {
		return contactbtx;
	}

	public WebElement getPatientsbtn() {
		return patientsbtn;
	}

	public WebElement getDoctorsbtn() {
		return doctorsbtn;
	}

	public WebElement getAdminbtn() {
		return adminbtn;
	}

	public WebElement getDownhomebtn() {
		return downhomebtn;
	}

	public WebElement getDowncontactbtn() {
		return downcontactbtn;
	}

	public Object getAdminGotoPageButton() {
		// TODO Auto-generated method stub
		return null;
	}

}
