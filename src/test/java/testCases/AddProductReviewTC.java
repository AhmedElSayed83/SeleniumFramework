package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddProductReviewPO;
import pageObjects.HomePO;
import pageObjects.ProductDetailsPO;
import pageObjects.SearchProductPO;
import pageObjects.UserRegistrationPO;

public class AddProductReviewTC extends TestCaseBase{
	
	HomePO homeObject;
	UserRegistrationPO registerObject;
	String productName="Apple MacBook Pro 13-inch";
	SearchProductPO searchProdObj;
	ProductDetailsPO productDetailsObj;
	AddProductReviewPO addProductReviewObj;
	
	// 1-User Registration
	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() {
		homeObject = new HomePO(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPO(driver);
		registerObject.userRegistration("Ramadan3", "Kareem", "gadi1030@test.com", "123456");
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
	
	// 3-Add Review for the product.
	@Test(priority = 3)
	public void RegisteredUserCanAddProductReview() {
		productDetailsObj.openAddReviewPage();
		addProductReviewObj = new AddProductReviewPO(driver);
		addProductReviewObj.addProductReview("test", "Very Good Product");
		Assert.assertTrue(addProductReviewObj.notification.getText().contains("Product review is successfully added."));
		//System.out.println(addProductReviewObj.ratingRdoBtn.getAttribute("id"));
	}
	
	
	// 4-User logout
	@Test(priority = 4)
	public void RegisteredUserCanLogout() {
		registerObject.userLogout();
	}

}
