package com.qa.centivo_ep_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	@FindBy(css = "div._ChildrenWrapper_pojm6_44.undefined > h1")
	private WebElement WelcomeLogo;
	
	@FindBy(css = "input#email")
	private WebElement emailTextBoxField;
	
	@FindBy(css = "input#password")
	private WebElement passwordTextBoxField;
	
	@FindBy(css = "section._NextSection_1mh1d_33 > button")
	private WebElement nextButton;
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String retrieveWelcomeLogotext() {
		String message = WelcomeLogo.getText();
		return message;
	}
	
	
	public void enterValidEmail(String emailText) {
		emailTextBoxField.sendKeys(emailText);	
	}
	
	public void enterValidPassword(String passwordText) {
		passwordTextBoxField.sendKeys(passwordText);	
	}
	
	public boolean validateEnablementOfNextButton() {
		boolean enablementStatus = nextButton.isEnabled();
		return enablementStatus;
	}
	
	public EnterVerificationCodePage clickOnNextButton() {
		nextButton.click();
		return new EnterVerificationCodePage(driver);
	}
}
