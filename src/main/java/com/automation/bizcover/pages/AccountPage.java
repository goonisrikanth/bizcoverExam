package com.automation.bizcover.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage{

	static Logger log = Logger.getLogger(AccountPage.class.getName());
	public AccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	By logout = By.xpath("//a[@class='logout']");
	
	
	public boolean isAccountPage() throws Exception
	{
		if(isElementDisplayed(logout))
		{
			log.info("User Registration seems to be successful... as we are able to see the Signout link");
			return true;
		}
		log.error("Signout link not available, seems like some error occured during registration process");
		return false;
	}
	
	public void signOut() throws Exception
	{
		clickElement(logout);
	}
	

}
