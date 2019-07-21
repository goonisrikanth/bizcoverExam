package com.automation.bizcover.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage{
	static Logger log = Logger.getLogger(LandingPage.class.getName());
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}


	By signInLink = By.xpath("//div[@class='header_user_info']/a");
	
	
	public <T> T  navigateToCreateAccountPage( Class<T> target) throws Exception
	{
		log.info("Navigating to CreateAccount page.");
		clickElement(signInLink);
		return PageFactory.initElements(driver, target);
	}
	
	
}
