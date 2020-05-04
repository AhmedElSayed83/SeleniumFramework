package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckoutPO;
import pageObjects.HomePO;
import pageObjects.OrderDetailsPO;
import pageObjects.ProductDetailsPO;
import pageObjects.SearchProductPO;
import pageObjects.ShoppingCartPO;
import pageObjects.UserRegistrationPO;

public class RegisteredUserCheckoutProductTC extends TestCaseBase {
	String productName="Apple MacBook Pro 13-inch";
	ShoppingCartPO shoppingCartObj;
	HomePO homeObj;
	UserRegistrationPO registerObj;
	SearchProductPO searchProdObj;
	ProductDetailsPO productDetailsObj;
	CheckoutPO checkoutObj;
	OrderDetailsPO OederObj;
	/*
	 * 1- Register User
	 * 2- Search for product
	 * 3- Add to Cart
	 * 4- Checkout
	 * 5- Logout   */
	
	@Test(priority = 1,alwaysRun=true) //1- User Registration 
	public void UserCanRegisterSuccssfully() {
		homeObj= new HomePO(driver);
		homeObj.openRegistrationPage();
		registerObj= new UserRegistrationPO(driver);
		registerObj.userRegistration("Ahmed", "GadAllah", "gadi06@test.com", "123456");
		Assert.assertTrue(registerObj.SuccessMsg.getText().contains("Your registration completed"));
	}
	
	@Test(priority=2) // 2- Search for product
	public void UserCanSearchWithAutoSuggest() {
		try {
			searchProdObj= new SearchProductPO(driver);
			searchProdObj.productSearchUsingAutoSuggest("macB");
			productDetailsObj= new ProductDetailsPO(driver);
			Assert.assertEquals(productDetailsObj.productNameBreadCrumb.getText() , productName);
			
		} catch (Exception e) {
			System.out.println("Error Occured: " + e.getMessage());
		}
	}
	
	@Test(priority = 3) // 3- Add to Cart
    public void UserCanAddProductToCart() throws InterruptedException {
		productDetailsObj= new ProductDetailsPO(driver);
		productDetailsObj.addToCart();
    	driver.navigate().to("https://demo.nopcommerce.com/cart");
    	Thread.sleep(4000);
    	shoppingCartObj= new ShoppingCartPO(driver);
    	Assert.assertTrue(shoppingCartObj.productNameTitle.isDisplayed());
    	Assert.assertTrue(shoppingCartObj.productNameTitle.getText().contains(productName));
	}
	
	@Test(priority=4) // 4- Checkout
	public void UserCanCheckoutProduct() throws InterruptedException {
		shoppingCartObj= new ShoppingCartPO(driver);
		shoppingCartObj.openCheckoutPage();
		checkoutObj= new CheckoutPO(driver);
		checkoutObj.RegisteredUserCheckoutProduct
		("Egypt", "gadi06@test.com", "123456", "32445566677", "Cairo", productName);
		Thread.sleep(2000);
		Assert.assertTrue(checkoutObj.prodcutName.isDisplayed());
		Assert.assertTrue(checkoutObj.prodcutName.getText().contains(productName));
		
		checkoutObj.confirmOrder();
		Assert.assertTrue(checkoutObj.ThankYoulbl.isDisplayed());
		checkoutObj.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		OederObj= new OrderDetailsPO(driver);
		OederObj.PrintOrderDetails();
		OederObj.DownloadPDFInvoice();
		
	}
	
	@Test(priority = 5) // 5- Logout
	public void RegisteredUserCanLogout() {
		registerObj.userLogout();
	}

}
