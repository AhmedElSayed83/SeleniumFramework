package steps;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.CheckoutPO;
import pageObjects.OrderDetailsPO;
import pageObjects.ProductDetailsPO;
import pageObjects.SearchProductPO;
import pageObjects.ShoppingCartPO;
import testCases.TestCaseBase;

public class E2ETests extends TestCaseBase {
	
	SearchProductPO searchProdObj;
	ProductDetailsPO productDetailsObj;
	ShoppingCartPO shoppingCartObj;
	CheckoutPO checkoutObj;
	OrderDetailsPO orderDetailsObj;
	
	@Given("^user is on home page$")
	public void user_is_on_home_page()  {
		Assert.assertTrue(driver.getCurrentUrl().contains("demo.nopcommerce.com"));
	}

	@When("^user searches for \"([^\"]*)\"$")
	public void user_searches_for(String productName) throws InterruptedException  {
		searchProdObj= new SearchProductPO(driver);
		searchProdObj.productSearchUsingAutoSuggest(productName);
		productDetailsObj= new ProductDetailsPO(driver);
		Assert.assertTrue(productDetailsObj.productNameBreadCrumb.getText().contains(productName));
		
	}

	
	@When("^choose to buy two items$")
	public void choose_to_buy_two_items() throws InterruptedException {
		productDetailsObj= new ProductDetailsPO(driver);
		productDetailsObj.addToCart();
		driver.navigate().to("https://demo.nopcommerce.com/cart");
    	Thread.sleep(6000);
    	shoppingCartObj= new ShoppingCartPO(driver);
    	Assert.assertTrue(shoppingCartObj.productNameTitle.isDisplayed());
    	Assert.assertTrue(shoppingCartObj.productNameTitle.getText().contains("Apple MacBook Pro 13-inch"));
	}

	@When("^moves to check outcart and enter personel details on checkout page and place the order$")
	public void moves_to_check_outcart_and_enter_personel_details_on_checkout_page_and_place_the_order() throws InterruptedException  {
		checkoutObj= new CheckoutPO(driver);
		shoppingCartObj.openCheckoutPageAsGuest();
		checkoutObj.CheckoutProduct("amro", "diaab", "amrooo@test.com", "Egypt", "Cairo", "October",
				"11211", "38890282", "Apple MacBook Pro 13-inch");
		Assert.assertTrue(checkoutObj.prodcutName.isDisplayed());
		//Assert.assertTrue(checkoutObj.prodcutName.getText().contains("Apple MacBook Pro 13-inch"));
		checkoutObj.confirmOrder();
		//Assert.assertTrue(checkoutObj.ThankYoulbl.isDisplayed());
	}

	@Then("^he can view the order and download the invoice$")
	public void he_can_view_the_order_and_download_the_invoice() throws InterruptedException  {
		orderDetailsObj = new OrderDetailsPO(driver);
		checkoutObj.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderDetailsObj.DownloadPDFInvoice();
		Thread.sleep(3000);
		orderDetailsObj.PrintOrderDetails();
	}

}
