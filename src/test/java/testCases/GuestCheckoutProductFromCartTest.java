package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckoutPO;
import pageObjects.OrderDetailsPO;
import pageObjects.ProductDetailsPO;
import pageObjects.SearchProductPO;
import pageObjects.ShoppingCartPO;

public class GuestCheckoutProductFromCartTest extends TestCaseBase{
	
	String productName="Apple MacBook Pro 13-inch";
	/*
	 * 1- Search for product
	 * 2- Add to Cart
	 * 3- Checkout as a guest
	 * 5- View Order details   */
	SearchProductPO searchProdObj;
	ProductDetailsPO productDetailsObj;
	ShoppingCartPO shoppingCartObj;
	CheckoutPO checkoutObj;
	OrderDetailsPO orderDetailsObj;
	
	@Test(priority=1) // 1- Search for product
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
	
	@Test(priority = 2) // 2- Add to Cart
    public void UserCanAddProductToCart() throws InterruptedException {
		productDetailsObj= new ProductDetailsPO(driver);
		productDetailsObj.addToCart();
    	driver.navigate().to("https://demo.nopcommerce.com/cart");
    	Thread.sleep(5000);
    	shoppingCartObj= new ShoppingCartPO(driver);
    	Assert.assertTrue(shoppingCartObj.productNameTitle.isDisplayed());
    	Assert.assertTrue(shoppingCartObj.productNameTitle.getText().contains(productName));
	}
	
	@Test(priority=3)
	public void UserCanCheckoutProduct() throws InterruptedException {
		checkoutObj = new CheckoutPO(driver);
		shoppingCartObj.openCheckoutPageAsGuest();
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/onepagecheckout"));
		checkoutObj.CheckoutProduct("Ahmedoof", "Sayedoof", "gadooof112@test.com", "Egypt", "Cairo", "October",
				"11211", "38890282", productName);
		Thread.sleep(3000);
		Assert.assertTrue(checkoutObj.prodcutName.isDisplayed());
		Assert.assertTrue(checkoutObj.prodcutName.getText().contains(productName));
		checkoutObj.confirmOrder();
		Assert.assertTrue(checkoutObj.ThankYoulbl.isDisplayed());
	}
	
	@Test(priority=4)
	public void UserCanViewOrderDetails() throws InterruptedException {
		orderDetailsObj = new OrderDetailsPO(driver);
		checkoutObj.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderDetailsObj.DownloadPDFInvoice();
		Thread.sleep(3000);
		orderDetailsObj.PrintOrderDetails();
	}

}
