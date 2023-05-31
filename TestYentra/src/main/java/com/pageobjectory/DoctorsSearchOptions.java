package com.pageobjectory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorsSearchOptions {
	
@FindBy(xpath = " //span[text()=' Search ']")
private WebElement searchOptionbtx;

@FindBy(xpath = " //input[@id='searchdata']")
private WebElement nameMobileNumTextBox;

@FindBy(xpath = " //button[@id='submit']")
private WebElement searchButton;

public DoctorsSearchOptions(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getSearchOptionbtx() {
	return searchOptionbtx;
}

public WebElement getNameMobileNumTextBox() {
	return nameMobileNumTextBox;
}

public WebElement getSearchButton() {
	return searchButton;
}

}
