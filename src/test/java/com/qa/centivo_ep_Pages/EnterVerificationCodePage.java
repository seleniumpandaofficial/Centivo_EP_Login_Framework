package com.qa.centivo_ep_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterVerificationCodePage {
	public WebDriver driver;
	
	@FindBy(xpath = "//h3[text() = 'Enter verification code']")
	private WebElement EnterVerificationCodeLogo;
	
	
	
	public EnterVerificationCodePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String retrieveEnterVerificationCodeLogo() {
		String message = EnterVerificationCodeLogo.getText();
		return message;
	}
	
	

}
