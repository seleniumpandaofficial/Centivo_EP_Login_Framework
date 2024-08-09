package com.qa.centivo_ep.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    
        features = {"src/test/resources/featurefiles" },
        glue     = {"com.qa.centivo_ep.StepDefinitions", "com.qa.centivo_ep_Hooks"},
        tags     = "@ValidCredentials or @AccountNotCreatedYet or @InvalidEmail or @IncorrectPassword or @CorrectPasswordSecondAttempt or @InvalidPasswordSecondAttempt or @NextButtonEnablementThirdAttemptCorrectPassword",
        plugin   = {"pretty", "html:target/CucumberReports/CucumberReport.html", "json:target/cucumber1.json"},
        publish  = true

   )

public class Runner_TestNG extends AbstractTestNGCucumberTests {

}
