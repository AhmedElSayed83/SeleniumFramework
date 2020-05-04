package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.UserRegistrationPO;

public class UserRegistrationWithDDTAndPropertiesFileTC extends TestCaseBase {
	
	HomePO homeObject;
	UserRegistrationPO registerObject;
	LoginPO loginObject;
	String fName=LoadProperties.userdata.getProperty("firstname");
	String lName=LoadProperties.userdata.getProperty("lastname");
	String email=LoadProperties.userdata.getProperty("email");
	String password=LoadProperties.userdata.getProperty("password");
	
	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() {
		homeObject = new HomePO(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPO(driver);
		registerObject.userRegistration(fName, lName, email , password);
		Assert.assertTrue(registerObject.SuccessMsg.getText().contains("Your registration completed"));
		System.out.println(registerObject.SuccessMsg.getText());
	}
	
	@Test(dependsOnMethods = "userCanRegisterSuccessfully")
	public void RegisteredUserCanLogout() {
		registerObject.userLogout();
	}
	
	@Test(dependsOnMethods = "RegisteredUserCanLogout")
	public void RegisteredUserCanLogin() throws InterruptedException {
		homeObject.openLoginPage();
		loginObject=new LoginPO(driver);
		loginObject.UserLogin(email, password);
		//Assert.assertTrue(registerObject.logoutLink.getText().equal("Log out"));
		Thread.sleep(3000);
		Assert.assertTrue(registerObject.logoutLink.isDisplayed());
	}
	
	@Test(dependsOnMethods = "RegisteredUserCanLogin")
	public void RegisteredUserCanLogout2() {
		registerObject.userLogout();
	}
	
	
}
