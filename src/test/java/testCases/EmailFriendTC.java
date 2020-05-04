package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmailFriendPO;
import pageObjects.HomePO;
//import pageObjects.LoginPO;
import pageObjects.ProductDetailsPO;
import pageObjects.SearchProductPO;
import pageObjects.UserRegistrationPO;

public class EmailFriendTC extends TestCaseBase {
	   
	HomePO homeObject;
	UserRegistrationPO registerObject;
	//LoginPO loginObject;
	String productName="Apple MacBook Pro 13-inch";
	SearchProductPO searchProdObj;
	ProductDetailsPO productDetailsObj;
	EmailFriendPO emailFriendObj;
	
	
	// 1-User Registration.
	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() {
		homeObject = new HomePO(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPO(driver);
		registerObject.userRegistration("Ooo", "Pps", "gadi000@test.com", "123456");
		Assert.assertTrue(registerObject.SuccessMsg.getText().contains("Your registration completed"));
		System.out.println(registerObject.SuccessMsg.getText());
	}
	
	// 2-Search for product using Auto-suggest.
	@Test(priority = 2)
	public void userCanSearchWithAutoSuggest(){
		try {
			searchProdObj= new SearchProductPO(driver);
			searchProdObj.productSearchUsingAutoSuggest("macB");
			productDetailsObj= new ProductDetailsPO(driver);
			Assert.assertEquals(productDetailsObj.productNameBreadCrumb.getText() , productName);
			
		} catch (Exception e) {
			System.out.println("Error Occured: " + e.getMessage());
		}
		
	}
	
	// 3-Email to friend.
	@Test(priority = 3)
	public void RegisteredUserCanSendEmailToFriend() {
		productDetailsObj.openEmailFriendPage();
		emailFriendObj = new EmailFriendPO(driver);
		emailFriendObj.sendEmailToFriend("yassin2@yassin.com", "This is a very good product. take a look.");
		Assert.assertTrue(emailFriendObj.MsgSent.getText().contains("Your message has been sent."));		
	}
	

	// 4-User logout
	@Test(priority = 4)
	public void RegisteredUserCanLogout() {
		registerObject.userLogout();
	}
	
	
	
}
