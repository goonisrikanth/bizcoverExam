package com.automation.bizcover.pages;

import org.openqa.selenium.WebDriver;

import com.automation.bizcover.framework.SeleniumWrapper;

public class BasePage extends SeleniumWrapper {

  WebDriver driver;

  public BasePage(WebDriver driver) {
    super(driver);
  }
}
