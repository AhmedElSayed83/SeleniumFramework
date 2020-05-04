package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.UserRegistrationPO;

public class UserRegistrationWithDDTAndExcelTC extends TestCaseBase {
	
	HomePO homeObject;
	UserRegistrationPO registerObject;
	LoginPO loginObject;
	
	@DataProvider(name = "ExcelData")
	public static Object[][] userData() throws IOException{
		// get data from Excel Reader class
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
		
	}
	
	@Test(priority = 1, alwaysRun = true, dataProvider = "ExcelData")
	public void userCanRegisterSuccessfully(String fname, String lname, String email, String password) {
		homeObject = new HomePO(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPO(driver);
		registerObject.userRegistration(fname, lname, email, password);
		Assert.assertTrue(registerObject.SuccessMsg.getText().contains("Your registration completed"));
		System.out.println(registerObject.SuccessMsg.getText());
		registerObject.userLogout();
		//login
		homeObject.openLoginPage();
		loginObject=new LoginPO(driver);
		loginObject.UserLogin(email, password);
		//Assert.assertTrue(registerObject.logoutLink.getText().equal("Log out"));
		Assert.assertTrue(registerObject.logoutLink.isDisplayed());
		//logout
		registerObject.userLogout();
	}
	
}
