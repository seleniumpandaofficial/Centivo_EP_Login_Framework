package com.qa.Centivo_ep.Utilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public WebElement webelement;
	
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnElement(WebElement element, long durationInSeconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		webelement = wait.until(ExpectedConditions.elementToBeClickable(element));
		webelement.click();
	}

}
