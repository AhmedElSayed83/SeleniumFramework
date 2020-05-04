package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.UserRegistrationPO;

public class UserRegistrationWithDDTAndJavaFakerTC extends TestCaseBase {
	
	HomePO homeObject;
	UserRegistrationPO registerObject;
	LoginPO loginObject;
	Faker fakeData = new Faker();
	String fName= fakeData.name().firstName();
	String lName= fakeData.name().lastName();
	String email= fakeData.internet().emailAddress();
	String password= fakeData.number().digits(8).toString();
	
	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() {
		homeObject = new HomePO(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPO(driver);
		registerObject.userRegistration(fName,lName,email,password);
		Assert.assertTrue(registerObject.SuccessMsg.getText().contains("Your registration completed"));
		System.out.println(registerObject.SuccessMsg.getText());
		System.out.println("User Data: " + fName + " " + lName + " " + email+ " " + password);
	}
	
	@Test(dependsOnMethods = "userCanRegisterSuccessfully")
	public void RegisteredUserCanLogout() {
		registerObject.userLogout();
	}
	
	@Test(dependsOnMethods = "RegisteredUserCanLogout")
	public void RegisteredUserCanLogin() {
		homeObject.openLoginPage();
		loginObject=new LoginPO(driver);
		loginObject.UserLogin(email , password);
		//Assert.assertTrue(registerObject.logoutLink.getText().equal("Log out"));
		Assert.assertTrue(registerObject.logoutLink.isDisplayed());
	}
	
	@Test(dependsOnMethods = "RegisteredUserCanLogin")
	public void RegisteredUserCanLogout2() {
		registerObject.userLogout();
	}
	
	
}
