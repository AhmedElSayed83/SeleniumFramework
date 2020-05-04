package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.UserRegistrationPO;

public class UserRegistrationWithDDTAndDataProvider extends TestCaseBase {

	HomePO homeObject;
	UserRegistrationPO registerObject;
	LoginPO loginObject;

	@DataProvider(name = "testData")
	public static Object[][] userData(){
		return new Object[][] {
			{"A7mad","Sayed","a7mad30@test.com","123456"},
			{"Yassin","GadAllah","yasso30@test.com","12345678"}
		};
	}

	@Test(priority = 1, alwaysRun = true, dataProvider = "testData")
	public void userCanRegisterSuccessfully(String fname, String lname, String email, String password ) {
		homeObject = new HomePO(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPO(driver);
		registerObject.userRegistration(fname, lname, email, password);
		Assert.assertTrue(registerObject.SuccessMsg.getText().contains("Your registration completed"));
		System.out.println(registerObject.SuccessMsg.getText());
		registerObject.userLogout();
		homeObject.openLoginPage();
		loginObject=new LoginPO(driver);
		loginObject.UserLogin(email, password);
		Assert.assertTrue(registerObject.logoutLink.isDisplayed());
		registerObject.userLogout();
	}	
}
