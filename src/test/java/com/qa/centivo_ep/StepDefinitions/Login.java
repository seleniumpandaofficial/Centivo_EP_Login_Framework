package com.qa.centivo_ep.StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qa.Centivo_ep.Utilities.Util;
import com.qa.centivo_ep_DriverFactory.DriverFactory;
import com.qa.centivo_ep_Pages.EnterVerificationCodePage;
import com.qa.centivo_ep_Pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	public WebDriver driver;

	@Given("user navigates to Centivo employer portal LoginPage")
	public void user_navigates_to_centivo_employer_portal_loginPage() {
		driver = DriverFactory.getDriver();
		LoginPage loginpage = new LoginPage(driver);
		// String actualWelcomeMessage = driver.findElement(By.cssSelector("div._ChildrenWrapper_pojm6_44.undefined >h1")).getText();
		String actualWelcomeMessage = loginpage.retrieveWelcomeLogotext();
		String expectedWelcomeMessage = "Welcome to Centivo's employer portal";
		Assert.assertTrue(actualWelcomeMessage.contains(expectedWelcomeMessage));
	}

	@And("user enters valid email {string}")
	public void user_enters_valid_email(String emailText) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterValidEmail(emailText);
		//driver.findElement(By.cssSelector("input#email")).sendKeys(emailText);
	}

	@And("user enters valid password {string}")
	public void user_enters_valid_password(String passwordText) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterValidPassword(passwordText);
		//driver.findElement(By.cssSelector("input#password")).sendKeys(passwordText);
	}

	@Then("Next button gets activated")
	public void next_button_gets_activated() {
		LoginPage loginpage = new LoginPage(driver);
		Assert.assertTrue(loginpage.validateEnablementOfNextButton());
		//Assert.assertTrue(driver.findElement(By.cssSelector("section._NextSection_1mh1d_33 > button")).isEnabled());
	}

	@When("user clicks on the Next button")
	public void user_clicks_on_the_next_button() {
		
		driver.findElement(By.cssSelector("section._NextSection_1mh1d_33 > button")).click();
	}

	@Then("system is redirected to EnterVerificationCodePage")
	public void system_is_redirected_to_enterVerificationCodePage() {
		EnterVerificationCodePage enterverificationcodepage = new EnterVerificationCodePage(driver);
		String actualVerificationMessage = enterverificationcodepage.retrieveEnterVerificationCodeLogo();
		//String actualVerificationMessage = driver.findElement(By.xpath("//h3[text() = 'Enter verification code']")).getText();
		String expectedVerificationMessage = "Enter verification code";
		Assert.assertTrue(actualVerificationMessage.contains(expectedVerificationMessage));
	}

	@And("user enters invalid email {string}")
	public void user_enters_invalid_email(String invalidEmailText) {
		driver.findElement(By.cssSelector("input#email")).sendKeys(invalidEmailText);
	}

	@And("user enters invalid password {string}")
	public void user_enters_invalid_password(String invalidPasswordText) {
		driver.findElement(By.cssSelector("input#password")).sendKeys(invalidPasswordText);
	}

	@Then("Application should display an error message {string}")
	public void application_should_display_an_error_message(String accountNotCreatedWarningMessageText) {
		String actualWarningMessage = driver.findElement(By.cssSelector("div.sc-hzhJZQ.itFboL > div:nth-child(2)")).getText();
		String expectedWarningMessage = "Sorry, we don`t recognize this email address.";
		Assert.assertTrue(actualWarningMessage.equals(expectedWarningMessage));
	}

	@And("user enters unregistered email {string}")
	public void user_enters_unregistered_email(String unregisteredEmailText) {
		driver.findElement(By.cssSelector("input#email")).sendKeys(unregisteredEmailText);
	}

	@And("user enters unregistered password {string}")
	public void user_enters_unregistered_password(String unregisteredPasswordText) {
		driver.findElement(By.cssSelector("input#password")).sendKeys(unregisteredPasswordText);
	}

	@Then("Application should display an error message with DateTimeStamp {string}")
	public void application_should_display_an_error_message_with_datetimeStamp(String datetimeStampText) {

	}

	@And("user enters invalid email {string} and invalid password {string} repeatedly")
	public void user_enters_invalidEmail_and_invalidPassword_repeatedly(String invalidEmailTextRepeated,
			String invalidPasswordTextRepeated) throws InterruptedException {
		for (int i = 0; i < 9; i++) {
			driver.findElement(By.cssSelector("input#email")).sendKeys(invalidEmailTextRepeated);
			driver.findElement(By.cssSelector("input#password")).sendKeys(invalidPasswordTextRepeated);
			driver.findElement(By.cssSelector("section._NextSection_1mh1d_33 > button:nth-child(1)")).click();
			Thread.sleep(2000);
			if (i < 8) {
				driver.get("https://employee.centivo.dev/");
			}
			Thread.sleep(2000);
		}
		String expectedLockoutWarningMessage = "Account temporarily locked";
		String actualLockoutWarningMessage = driver.findElement(By.xpath("")).getText();
		System.out.println(actualLockoutWarningMessage);
		Assert.assertTrue(expectedLockoutWarningMessage.contains(actualLockoutWarningMessage));
	}
	
	@Then("Application should display an incorrect password error message {string}")
	public void application_should_display_an_incorrect_password_error_message(String incorrectPasswordWarningText) throws Exception {
		String actualIncorrectPasswordWarningMessage = driver.findElement(By.cssSelector("div.sc-hzhJZQ.itFboL > div:nth-child(2)")).getText();
		String expectedIncorrectPasswordWarningMessage = "You have entered an incorrect password.";
		Thread.sleep(2000);
		Assert.assertTrue(actualIncorrectPasswordWarningMessage.equals(expectedIncorrectPasswordWarningMessage));
		
	}
	
	@And("user enters valid password {string} in the second attempt")
	public void user_enters_valid_password_in_the_second_attempt(String validPasswordSecondAttemptText) {
		driver.findElement(By.cssSelector("input#password")).sendKeys(validPasswordSecondAttemptText);
	}
	
	@And("user enters valid email {string} but user enters invalid password {string} in the second attempt")
	public void user_enters_invalid_password_in_the_second_attempt(String emailText, String invalidPasswordSecondAttemptText) throws InterruptedException {
		for(int i=0 ; i<3 ; i++) {
			driver.findElement(By.cssSelector("input#email")).sendKeys(emailText);
		    driver.findElement(By.cssSelector("input#password")).sendKeys(invalidPasswordSecondAttemptText);
		if (i < 2) {
			driver.get("https://employee.centivo.dev/");
		  }
		}
	}
	
	@And("Application should display a lockout warning error message {string}")
	public void application_should_display_a_lockout_warning_error_message(String lockooutWarningText) {
	Assert.assertTrue(driver.findElement(By.xpath("//div[text() = 'You have entered an incorrect password. You have one attempt remaining before being temporarily locked out.']")).isDisplayed());
	}
	

	@And("user enters valid email {string} and user enters invalid password {string} in the first attempt")
	public void user_enters_valid_email_invalid_password1(String validEmailText, String invalidPasswordText) {
		driver.findElement(By.cssSelector("input#email")).sendKeys(validEmailText);
		driver.findElement(By.cssSelector("input#password")).sendKeys(invalidPasswordText);
	}
	
	@And("user enters valid email {string} and user enters invalid password {string} in the second attempt")
	public void user_enters_valid_email_invalid_password2(String validEmailText, String invalidPasswordText) {
		driver.findElement(By.cssSelector("input#email")).sendKeys(validEmailText);
		driver.findElement(By.cssSelector("input#password")).sendKeys(invalidPasswordText);
	}
	
	@And("user enters valid email {string} and user enters valid password {string} in the third attempt")
	public void user_enters_valid_email_valid_password3(String validEmailText, String validPasswordText) {
		driver.findElement(By.cssSelector("input#email")).sendKeys(validEmailText);
		driver.findElement(By.cssSelector("input#password")).sendKeys(validPasswordText);
	}
	
	
	
	
	
	
	
	@And("user enters valid email {string} for the first time")
	public void user_enters_valid_email_for_the_first_time(String firstAttemptEmailText) {
		driver.findElement(By.cssSelector("input#email")).sendKeys(firstAttemptEmailText);
	}
	
	@And("user enters invalid password {string} first time")
	public void user_enters_invalid_password_first_time(String firstAttemptInvalidPasswordText) {
		driver.findElement(By.cssSelector("input#password")).sendKeys(firstAttemptInvalidPasswordText);
		String actualIncorrectPasswordWarningMessage = driver.findElement(By.cssSelector("div.sc-hzhJZQ.itFboL > div:nth-child(2)")).getText();
		String expectedIncorrectPasswordWarningMessage = "You have entered an incorrect password.";
		Assert.assertTrue(actualIncorrectPasswordWarningMessage.equals(expectedIncorrectPasswordWarningMessage));
	}
	
	
	@And("user enters valid email {string} for the second time")
	public void user_enters_valid_email_for_the_second_time(String secondAttemptEmailText) {
		driver.findElement(By.cssSelector("input#email")).sendKeys(secondAttemptEmailText);	
	}
	
	@And("user enters invalid password {string} second time")
	public void user_enters_invalid_password_second_time(String secondAttemptInvalidPasswordText) {
		driver.findElement(By.cssSelector("input#password")).sendKeys(secondAttemptInvalidPasswordText);
		Assert.assertTrue(driver.findElement(By.xpath("//div[text() = 'You have entered an incorrect password. You have one attempt remaining before being temporarily locked out.']")).isDisplayed());
	}
	
	
	@And("user enters valid email {string} for the third time")
	public void user_enters_valid_email_for_the_third_time(String thirdAttemptEmailText) {
		driver.findElement(By.cssSelector("input#email")).sendKeys(thirdAttemptEmailText);		
	}
	
	@And("user enters invalid password {string} third time")
	public void user_enters_invalid_password_third_time(String thirdAttemptInvalidPasswordText) {
		driver.findElement(By.cssSelector("input#password")).sendKeys(thirdAttemptInvalidPasswordText);
		//String expectedeMessage = "Account locked due to too many log in attempts. Account will unlock: 8/12/2024, 6:02:47 PM";
		//String actualMessage = driver.findElement(By.xpath("//span[text() = 'Account locked due to too many log in attempts. Account will unlock: 8/12/2024, 6:02:47 PM']")).getText();
		
		String message = "Account locked due to too many log in attempts. Account will unlock:" + Util.dateTimeStamp();
		String xpath = "//span[text()='" + message + "']";
		WebElement warningMessage = driver.findElement(By.xpath(xpath));
		
		Assert.assertTrue(warningMessage.isDisplayed());
	  
	}

}
