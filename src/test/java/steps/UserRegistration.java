package steps;


import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePO;
import pageObjects.UserRegistrationPO;
import testCases.TestCaseBase;

public class UserRegistration extends TestCaseBase{
	HomePO homeObj;
	UserRegistrationPO userRegistrationObj;
	
	
	@Given("^user is on the home page$")
	public void user_is_on_the_home_page()  {
		homeObj=new HomePO(driver);
		homeObj.openRegistrationPage();
	    
	}

	@When("^user click on the Register link$")
	public void user_click_on_the_Register_link()  {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

	/*
	 * @When("^user enter the user data$") public void user_enter_the_user_data() {
	 * userRegistrationObj = new UserRegistrationPO(driver);
	 * userRegistrationObj.userRegistration("Samir91","Taiea","samir91@taiea.com",
	 * "12345678"); }
	 */
	@When("^user enter \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void user_enter(String firstname, String lastname, String email, String password) {
		userRegistrationObj = new UserRegistrationPO(driver);
		 userRegistrationObj.userRegistration(firstname,lastname,email,password); 
	}
	

	@Then("^the registration page displayed successfuly message$")
	public void the_registration_page_displayed_successfuly_message()  {
		Assert.assertTrue(userRegistrationObj.SuccessMsg.getText().contains("Your registration completed"));
		userRegistrationObj.userLogout();
	}
	

}
