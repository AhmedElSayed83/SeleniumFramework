package testCases;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.UserRegistrationPO;

public class UserRegistrationWithDDTAndCSVfileTC extends TestCaseBase {
	
	HomePO homeObject;
	UserRegistrationPO registerObject;
	LoginPO loginObject;
	
	CSVReader reader ;
	
	
	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() throws IOException, CsvValidationException {
		//get path for CSV file
		String csv_path=System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.csv";
		reader = new CSVReader(new FileReader(csv_path));
		
		String[] csvCell ; 
		// while loop will be executed till the last value in CSV file. 
		while((csvCell=reader.readNext()) != null) {
			String firstName = csvCell[0];
			String lastName = csvCell[1];
			String email = csvCell[2]; 
			String password = csvCell[3]; 
			
			homeObject = new HomePO(driver);
			homeObject.openRegistrationPage();
			registerObject = new UserRegistrationPO(driver);
			registerObject.userRegistration(firstName, lastName,email, password);
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
	
	
	
	
}
