package com.automation.bizcover.modal;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.company.Company;
import io.codearte.jfairy.producer.person.Person;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class User {
  
  String firstName;
  String lastName;
  String name;
  String companyName;
  String email;
  String password;
  String address;
  String postalcode;
  String mobile;
  
  
  public enum UserFields
  {
	 FULL_NAME, COMPANY_NAME, EMAIL, PASSWORD; 
  }

  public static User getUserData() {
    Fairy fairy = Fairy.create();
    Person person = fairy.person();
    Company comp = fairy.company();
    User user = new User();

    user.companyName = comp.getName();
    user.firstName = person.getFirstName();
    user.lastName = person.getLastName();
    user.name = user.firstName+" "+user.lastName;
    user.email = person.getEmail();
    user.password = person.getPassword();
    user.address = person.getAddress().toString();
    user.mobile = person.getTelephoneNumber();
   
    
    return user;
  }
  
  public static void main(String[] args) {
	
	  
	  System.out.println(User.getUserData().getEmail());
	  System.out.println(User.getUserData().getName());
	  System.out.println(User.getUserData().getAddress());
	  System.out.println(User.getUserData().getMobile());
}
}
