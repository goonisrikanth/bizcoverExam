package com.automation.bizcover.tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.automation.bizcover.framework.DriverFactory;

public class BaseTest {
  static Logger log = Logger.getLogger(BaseTest.class.getName());
  protected WebDriver driver;
  private String browser;
  private String appUrl;

  @AfterTest
  public void tearDown() {
    log.info("Closing browser sessions if any");
    if (driver != null)
      driver.quit();
  }

  @Parameters({"browserType", "appURL"})
  @BeforeClass
  public void initializeParams(String browserType, String appURL) {
    this.browser = browserType;
    this.appUrl = appURL;

  }

  @BeforeMethod
  public void init(Method method) {
	  
	log.info("*** Started Executing - "+method.getName()+" ***");
	log.info("In BaseTest, initializing WebDriver based on browser type");
    try {
      driver = DriverFactory.getWebDriver(this.browser, this.appUrl);
    } catch (Exception e) {
      log.error("Failed to initialize browser" + e.getStackTrace());
      throw e;
    }

  }

  @AfterMethod
  public void takeScreenShotOnFailure(ITestResult testResult, Method method) throws IOException {
    
	  log.info("*** Finished Executing - "+method.getName()+" ***");
	  
	  if (testResult.getStatus() == ITestResult.FAILURE) {
      File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(scrFile, new File("./Screenshots/" + testResult.getName() + "-"
          + Arrays.toString(testResult.getParameters()) + ".png"));
    }
    log.info("Closing browser session");
    driver.quit();
  }
  
  
}
