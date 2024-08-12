package com.qa.centivo_ep.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    
        features = {"src/test/resources/featurefiles" },
        glue     = {"com.qa.centivo_ep.StepDefinitions", "com.qa.centivo_ep_Hooks"},
        tags     = "@ValidCredentials or @LockedAccountWithDateTimeStamp",
        plugin   = {"pretty", "html:target/CucumberReports/CucumberReport.html", 
        		    "json:target/cucumber1.json", 
        		    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        publish  = true

   )

public class Runner_TestNG extends AbstractTestNGCucumberTests {
	
	/* 
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
	
	*/

}
