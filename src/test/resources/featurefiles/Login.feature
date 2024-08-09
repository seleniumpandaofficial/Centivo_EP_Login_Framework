@CentivoEPLogin
Feature: Login functionality of Centivo Employer Portal

@ValidCredentials
Scenario: Login with valid credentials
Given user navigates to Centivo employer portal LoginPage
And user enters valid email "jahangir.ali@centivo.com"
And user enters valid password "Technova2024@"
Then Next button gets activated
When user clicks on the Next button
Then system is redirected to EnterVerificationCodePage
    
@AccountNotCreatedYet
Scenario: Verify login with an Account not created yet
Given user navigates to Centivo employer portal LoginPage
And user enters invalid email "jahangir.ali1@centivo.com"
And user enters invalid password "Technova2025@"
Then Next button gets activated
When user clicks on the Next button
Then Application should display an error message "Sorry, we don’t recognize this email address."

@AccountNotRegisteredYet
Scenario: Verify login to employer portal with account which is not registered yet
Given user navigates to Centivo employer portal LoginPage
And user enters unregistered email "jahangir.ali1@centivo.com"
And user enters unregistered password "Technova2025@"
Then Next button gets activated
When user clicks on the Next button
Then Application should display an error message "It looks like you haven't set up your account just yet. To get started, click the link in your registration email."

@InvalidEmail
Scenario: Verify login to employer portal with invalid email
Given user navigates to Centivo employer portal LoginPage
And user enters invalid email "jahangir.ali1@centivo.com"
And user enters valid password "Technova2024@"
Then Next button gets activated
When user clicks on the Next button
Then Application should display an error message "Sorry, we don’t recognize this email address."

@LockedAccountWithDateTimeStamp
Scenario: Verify login to employer portal with locked account due to too many attempts
Given user navigates to Centivo employer portal LoginPage
And user enters invalid email "jahangir.ali1@centivo.com" and invalid password "Technova2025@" repeatedly
Then Application should display an error message with DateTimeStamp "Account locked due to too many attempts. Account will unlock: 11/7/2024, 1:01:35 PM."

@RetrievingLockedAccountWithClientSuccessExecutive
Scenario: Verify login to employer portal with locked account due to too many attempts
Given user navigates to Centivo employer portal LoginPage
When User have account locked for 20 minutes due to password fail and fails MFA code max retries
Then Application should display an error message "Your account has been locked because of consecutive failed log in attempts. To reset your account, contact your Client Success Executive."

@MFAfail
Scenario: Verify Error message for the account locked for 20 minutes due to MFA fail and fails password max retries
Given user navigates to Centivo employer portal LoginPage

@IndefinitelyLockedAccount
Scenario: Verify login to employer portal with indefinitely locked account
Given user navigates to Centivo employer portal LoginPage
When account which is previously locked indefintely
Then Application should display an error message "Your account has been locked because of consecutive failed log in attempts. To reset your account, contact your Client Success Executive."

@IncorrectPassword
Scenario: Verify login to employer portal with invalid password
Given user navigates to Centivo employer portal LoginPage
And user enters valid email "jahangir.ali@centivo.com"
And user enters invalid password "Technova2025@"
Then Next button gets activated
When user clicks on the Next button
Then Application should display an incorrect password error message "You have entered an incorrect password."

@CorrectPasswordSecondAttempt
Scenario: Verify login to employer portal with valid password attempt in the 2nd iteration
Given user navigates to Centivo employer portal LoginPage
And user enters valid email "jahangir.ali@centivo.com"
And user enters valid password "Technova2024@" in the second attempt
Then Next button gets activated

@InvalidPasswordSecondAttempt
Scenario: Verify login to employer portal with invalid password attempt in the 2nd iteration
Given user navigates to Centivo employer portal LoginPage
And user enters valid email "jahangir.ali@centivo.com" but user enters invalid password "Technova2025@" in the second attempt
Then Next button gets activated
When user clicks on the Next button
And Application should display a lockout warning error message "You have entered an incorrect password. You have one attempt remaining before being temporarily locked out."

@NextButtonEnablementThirdAttemptCorrectPassword
Scenario: Verify Next button enablement with valid password attempt in the 3rd iteration
Given user navigates to Centivo employer portal LoginPage
And user enters valid email "jahangir.ali@centivo.com" and user enters invalid password "Technova2025@" in the first attempt 
And user enters valid email "jahangir.ali@centivo.com" and user enters invalid password "Technova2025@" in the second attempt 
And user enters valid email "jahangir.ali@centivo.com" and user enters valid password "Technova2024@" in the third attempt
Then Next button gets activated

@UnlockAccountpost20minutes
Scenario: Verify unlocking account after 20 minutes of lockout
Given user navigates to Centivo employer portal LoginPage



