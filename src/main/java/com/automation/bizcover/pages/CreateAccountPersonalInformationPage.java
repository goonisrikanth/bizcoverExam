package com.automation.bizcover.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.bizcover.modal.User;

public class CreateAccountPersonalInformationPage extends BasePage{

	static Logger log = Logger.getLogger(CreateAccountPersonalInformationPage.class.getName());
	public CreateAccountPersonalInformationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	
	By mrRadioButton = By.id("id_gender1");
	By mrsRadioButton = By.id("id_gender2");
	
	By customerFirstName = By.id("customer_firstname");
	By customerLastName = By.id("customer_lastname");
	By password = By.id("passwd");
	By customerCompany = By.id("company");
	
	By customerAddress = By.id("address1");
	By customerAddress2 = By.id("address2");
	By customerCity = By.id("city");
	By state = By.id("id_state");
	By customerPostcode = By.id("postcode");
	By customerMobile = By.id("phone_mobile");
	By customerPassword = By.id("passwd");
	
	By submit = By.id("submitAccount");
	
	
	public <T> T signUpPersonalInfo(User user, Class<T> target) throws Exception {

		String[] address1 = user.getAddress().split("\n");
		String[] address2 = address1[1].split(" ");
		String city = "";
		for(int i=0;i<address2.length-1;i++)
			city = city + " "+ address2[i];
		
		log.info("Entering all the personal details for registration process.");
		clickElement(mrRadioButton);
		setText(customerFirstName, user.getFirstName());
		setText(customerLastName, user.getLastName());
		setText(customerPassword, user.getPassword());
		setText(customerCompany, user.getCompanyName());
		setText(customerAddress, address1[0]);
		setText(customerCity, city);
		selectValueByIndex(state, 1);
		setText(customerPostcode, address2[address2.length-1]);
		setText(customerMobile, user.getMobile());
		
		log.info("Registering with all the necessary details.");
		clickElement(submit);

		return PageFactory.initElements(driver, target);

	}
	

}
