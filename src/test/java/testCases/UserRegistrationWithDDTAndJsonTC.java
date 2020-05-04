package testCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.UserRegistrationPO;

public class UserRegistrationWithDDTAndJsonTC extends TestCaseBase {
	
	HomePO homeObject;
	UserRegistrationPO registerObject;
	LoginPO loginObject;
	JsonDataReader jsonReaderObj;
	
	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() throws FileNotFoundException, IOException, ParseException {
		jsonReaderObj = new JsonDataReader();
		jsonReaderObj.JsonReader();
		
		homeObject = new HomePO(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPO(driver);
		registerObject.userRegistration(jsonReaderObj.firstname,jsonReaderObj.lastname,
				jsonReaderObj.email, jsonReaderObj.password);
		Assert.assertTrue(registerObject.SuccessMsg.getText().contains("Your registration completed"));
		System.out.println(registerObject.SuccessMsg.getText());
		//logout
		registerObject.userLogout();
		//login
		homeObject.openLoginPage();
		loginObject=new LoginPO(driver);
		loginObject.UserLogin(jsonReaderObj.email, jsonReaderObj.password);
		Assert.assertTrue(registerObject.logoutLink.isDisplayed());
		//logout
		registerObject.userLogout();
	}

}
