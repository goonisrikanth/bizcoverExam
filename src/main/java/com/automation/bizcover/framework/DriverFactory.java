package com.automation.bizcover.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
  static WebDriver driver;

  public static WebDriver getWebDriver(String type, String appUrl) {
    switch (type) {
      case "Chrome":
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
        break;
      default:
        System.setProperty("webdriver.gecko.driver", "lib/geckodriver.exe");
        driver = new FirefoxDriver();
        break;
    }
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);
    driver.navigate().to(appUrl);
    return driver;
  }
}
