package com.pageobjectory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLoginPage {
@FindBy(xpath = "//input[@name='username']")
private WebElement usenametxbox;

@FindBy(xpath = "//input[@name='password']")
private WebElement pwdtxbox;

@FindBy(xpath = "//button[@name='submit']")
private WebElement loginbtn;

public PatientLoginPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}

public WebElement getUsenametxbox() {
	return usenametxbox;
}

public WebElement getPwdtxbox() {
	return pwdtxbox;
}

public WebElement getLoginbtn() {
	return loginbtn;
}
}
