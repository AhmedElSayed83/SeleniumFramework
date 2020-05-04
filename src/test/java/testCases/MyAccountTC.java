package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.MyAccountPO;
import pageObjects.UserRegistrationPO;

public class MyAccountTC extends TestCaseBase {
	HomePO homeObject;
	MyAccountPO myAccountObj;
	UserRegistrationPO registerObject;
	LoginPO loginObject;
	String fName="Ahmed";
	String lName="Sayed";
	String email="gadi08@test.com";
	String oldPassword="1234567";
	String newPassword="yassin";
	
	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() {
		homeObject = new HomePO(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPO(driver);
		registerObject.userRegistration(fName,lName ,email ,oldPassword);
		Assert.assertTrue(registerObject.SuccessMsg.getText().contains("Your registration completed"));
		System.out.println(registerObject.SuccessMsg.getText());
	}
	@Test(dependsOnMethods = "userCanRegisterSuccessfully")
	public void RegisteredUserCanchangePassword() {
		//userRegObj= new UserRegistrationPO(driver);
		registerObject.openMyAccountPage();
		myAccountObj= new MyAccountPO(driver);
		myAccountObj.openChangePasswordPage();
		myAccountObj.changePassword(oldPassword,newPassword);
		Assert.assertTrue(myAccountObj.PassChangedMsg.getText().contains("Password was changed"));		
	}
	
	@Test(dependsOnMethods = "RegisteredUserCanchangePassword")
	public void RegisteredUserCanLogout() {
		registerObject.userLogout();
	}
	
	@Test(dependsOnMethods = "RegisteredUserCanLogout")
	public void RegisteredUserCanLogin() {
		homeObject.openLoginPage();
		loginObject=new LoginPO(driver);
		loginObject.UserLogin(email, newPassword);
		System.out.println(registerObject.logoutLink.getText());
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
	
	@Test(dependsOnMethods = "RegisteredUserCanLogin")
	public void RegisteredUserCanLogout2() {
		registerObject.userLogout();
	}

}
