package com.automation.bizcover.tests.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.bizcover.framework.DriverFactory;
import com.automation.bizcover.modal.User;
import com.automation.bizcover.pages.AccountPage;
import com.automation.bizcover.pages.CreateAccountPage;
import com.automation.bizcover.pages.CreateAccountPersonalInformationPage;
import com.automation.bizcover.pages.LandingPage;
import com.automation.bizcover.tests.BaseTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Steps {

	static Logger log = Logger.getLogger(Steps.class.getName());
	public static WebDriver driver;
	LandingPage landingPage;
	CreateAccountPage createAccountPage;
	CreateAccountPersonalInformationPage createAccountPersonalInformationPage;
	AccountPage accountPage;

	User user;

	public Steps() {
		user = User.getUserData();
		
	}

	@Given("^user navigates to createAccount, page provides the personal information and submits$")
	public void user_navigates_to_createAccount_page_provides_the_personal_information_and_submits() throws Throwable {
		user = User.getUserData();
		log.info("User Registration process has been initiated");
		landingPage = new LandingPage(driver);
		createAccountPage = landingPage.navigateToCreateAccountPage(CreateAccountPage.class);
		createAccountPersonalInformationPage = createAccountPage.signUp(user,
				CreateAccountPersonalInformationPage.class);
		accountPage = createAccountPersonalInformationPage.signUpPersonalInfo(user, AccountPage.class);
	}

	@Then("^user registration should be successfully processed$")
	public void user_registration_should_be_successfully_processed() throws Throwable {
		log.info("User Registration complete. Now, verifying the registraion.");
		Assert.assertTrue(accountPage.isAccountPage());
		log.info("Registration completed successfully.");
	}

}
