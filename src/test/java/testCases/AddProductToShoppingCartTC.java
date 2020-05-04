package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductDetailsPO;
import pageObjects.SearchProductPO;
import pageObjects.ShoppingCartPO;

public class AddProductToShoppingCartTC extends TestCaseBase{
	
	SearchProductPO searchProductObj;
	ProductDetailsPO productDetailsObj;
	ShoppingCartPO shoppingCartObj;
	
	String productName = "Apple MacBook Pro 13-inch";
	// 1- Search for product number 1 
	// 2- Add product to cart 
	
	@Test(priority = 1)
    public void UserCanAddProductToCart() throws InterruptedException {
		searchProductObj= new SearchProductPO(driver);
    	productDetailsObj= new ProductDetailsPO(driver);
    	shoppingCartObj= new ShoppingCartPO(driver);
    	
    	searchProductObj.productSearchUsingAutoSuggest("macB");
    	Assert.assertTrue(productDetailsObj.productNameBreadCrumb.getText().contains(productName));
    	productDetailsObj.addToCart();
    	driver.navigate().to("https://demo.nopcommerce.com/cart");
    	Thread.sleep(4000);
    	Assert.assertTrue(shoppingCartObj.productNameTitle.isDisplayed());
    	Assert.assertTrue(shoppingCartObj.productNameTitle.getText().contains(productName));
    	
    	shoppingCartObj.updateProductQuantityInCart("10");
	}
	
	@Test(dependsOnMethods = "UserCanAddProductToCart")
    public void UserCanRemoveProductFromCart() throws InterruptedException {
		shoppingCartObj= new ShoppingCartPO(driver);
		shoppingCartObj.removeProductFromCart();
		Thread.sleep(2000);
		Assert.assertTrue(shoppingCartObj.emptyMsg.getText().contains("Your Shopping Cart is empty!"));
	}

}
