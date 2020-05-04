package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.UserRegistrationPO;

public class UserRegistrationTC extends TestCaseBase {
	
	HomePO homeObject;
	UserRegistrationPO registerObject;
	LoginPO loginObject;
	
	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() {
		homeObject = new HomePO(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPO(driver);
		registerObject.userRegistration("A7medz", "Saidz", "gady700@test.com", "123456");
		Assert.assertTrue(registerObject.SuccessMsg.getText().contains("Your registration completed"));
		System.out.println(registerObject.SuccessMsg.getText());
	}
	
	@Test(dependsOnMethods = "userCanRegisterSuccessfully")
	public void RegisteredUserCanLogout() {
		registerObject.userLogout();
	}
	
	@Test(dependsOnMethods = "RegisteredUserCanLogout")
	public void RegisteredUserCanLogin() {
		homeObject.openLoginPage();
		loginObject=new LoginPO(driver);
		loginObject.UserLogin("gady700@test.com", "123456");
		//Assert.assertTrue(registerObject.logoutLink.getText().equal("Log out"));
		Assert.assertTrue(registerObject.logoutLink.isDisplayed());
	}
	
	@Test(dependsOnMethods = "RegisteredUserCanLogin")
	public void RegisteredUserCanLogout2() {
		registerObject.userLogout();
	}
	
	
}
