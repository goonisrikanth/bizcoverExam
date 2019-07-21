package com.automation.bizcover.tests.runners;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.bizcover.framework.DriverFactory;
import com.automation.bizcover.tests.stepDefinitions.Steps;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Feature",
		glue= {"com.automation.bizcover.tests.stepDefinitions"}
		)

public class TestRunner extends AbstractTestNGCucumberTests{
	
	@BeforeMethod
	public void init()
	{
		Steps.driver = DriverFactory.getWebDriver("Chrome", "http://automationpractice.com/index.php");
	}
	
	@AfterMethod
	    public void tearDown() {
	        Steps.driver.quit();
	    }
}