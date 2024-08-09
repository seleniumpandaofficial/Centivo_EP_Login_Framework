package com.qa.centivo_ep_Hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.centivo_ep_DriverFactory.DriverFactory;
import com.tutorialsninja.qa.Utilities.ConfigReader;
import com.tutorialsninja.qa.Utilities.Util;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks {
    public WebDriver driver;
    public Properties prop;
    

    @Before
    public void setup() throws Exception{
    	prop = ConfigReader.initializePropertiesFile();
        DriverFactory.initializeBrowser(prop.getProperty("browser"));
        driver = DriverFactory.getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.IMPLICIT_WAIT_TIME));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Util.PAGE_LOAD_TIME));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Util.SCRIPT_TIME));
        driver.get(prop.getProperty("url")); 
    }

    @After
    public void tearDown(Scenario scenario){
    	String scenarioName = scenario.getName().replaceAll(" ", "_");
    	if(scenario.isFailed()) {
    		byte[] srcScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    		scenario.attach(srcScreenShot,"image/png", scenarioName);
    	}
        driver.quit();
    }


}
