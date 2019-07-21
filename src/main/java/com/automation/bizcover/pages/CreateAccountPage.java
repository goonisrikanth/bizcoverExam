package com.automation.bizcover.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.bizcover.modal.User;

public class CreateAccountPage extends BasePage{
	
	static Logger log = Logger.getLogger(CreateAccountPage.class.getName());
	public CreateAccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	
	By emailAddress = By.id("email_create");
	By createAccountButton = By.id("SubmitCreate");

	public void enterEmail(String email) throws Exception
	{
		log.info("Creating account with "+email+" email address.");
		setText(emailAddress, email);
	}
	
	
	public <T> T signUp(User user, Class<T> target) throws Exception {

		enterEmail(user.getEmail());
		log.info("Navigating to CreateAccount with personal details page.");
		clickElement(createAccountButton);

		return PageFactory.initElements(driver, target);

	}
	
	
}
