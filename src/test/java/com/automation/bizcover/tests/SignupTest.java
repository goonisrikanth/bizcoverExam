package com.automation.bizcover.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.bizcover.modal.User;
import com.automation.bizcover.pages.AccountPage;
import com.automation.bizcover.pages.CreateAccountPage;
import com.automation.bizcover.pages.CreateAccountPersonalInformationPage;
import com.automation.bizcover.pages.LandingPage;

public class SignupTest extends BaseTest {
	static Logger log = Logger.getLogger(SignupTest.class.getName());

	
	User user;

	@BeforeMethod
	public void setup() {
		user = User.getUserData();
	}

	@Test
	public void signUpTestWithValidData() throws Exception {

		LandingPage landingPage = new LandingPage(driver);
		CreateAccountPage createAccountPage = landingPage.navigateToCreateAccountPage(CreateAccountPage.class);
		CreateAccountPersonalInformationPage createAccountPersonalInformationPage =createAccountPage.signUp(user, CreateAccountPersonalInformationPage.class);
		AccountPage accountPage = createAccountPersonalInformationPage.signUpPersonalInfo(user, AccountPage.class);
		Assert.assertTrue(accountPage.isAccountPage());
	}



}
