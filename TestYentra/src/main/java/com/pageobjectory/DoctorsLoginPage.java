package com.pageobjectory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorsLoginPage {

	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernametxbox;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement pwdbox;

	@FindBy(xpath = "//button[@name='submit']")
	private WebElement logintxbox;

	public DoctorsLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernametxbox() {
		return usernametxbox;
	}

	public WebElement getPwdbox() {
		return pwdbox;
	}

	public WebElement getLogintxbox() {
		return logintxbox;
	}
}
