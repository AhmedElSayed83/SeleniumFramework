package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductDetailsPO;
import pageObjects.SearchProductPO;
import pageObjects.WishlistPO;

public class AddProductToWishlistTC extends TestCaseBase {
	
	String productName="Apple MacBook Pro 13-inch";
	SearchProductPO searchProdObj;
	ProductDetailsPO productDetailsObj;
	WishlistPO  WishlistObj;
	// 1- Search for product
	@Test(priority = 1)
	public void userCanSearchWithAutoSuggest(){
		try {
			searchProdObj= new SearchProductPO(driver);
			searchProdObj.productSearchUsingAutoSuggest("macB");
			productDetailsObj= new ProductDetailsPO(driver);
			Assert.assertEquals(productDetailsObj.productNameBreadCrumb.getText() , productName);
			productDetailsObj.addProductToWishlist();
			//WishlistObj= new WishlistPO(driver);
			//WishlistObj.openWishlistNotificationLink();
		} catch (Exception e) {
			System.out.println("Error Occured: " + e.getMessage());
		}
	}
	
	//2- Add product to wishlist
		@Test(priority = 2)
		public void userCanAddProductToWishlist() {
			productDetailsObj= new ProductDetailsPO(driver);
			productDetailsObj.addProductToWishlist();
			driver.navigate().to("https://demo.nopcommerce.com/wishlist");
			WishlistObj= new WishlistPO(driver);
			assertTrue(WishlistObj.wishlistHeader.isDisplayed());
			assertTrue(WishlistObj.productCell.getText().contains(productName));
			System.out.println(WishlistObj.wishlistHeader.getText());
			System.out.println(WishlistObj.productCell.getText());
			
		} 
	
	@Test(priority = 3)
	public void userCanRemoveProductFromCart() {
		WishlistObj= new WishlistPO(driver);
		WishlistObj.removeProductFromWishlist(); 
		System.out.println(WishlistObj.emptyCartMsg.getText());
		assertTrue(WishlistObj.emptyCartMsg.getText().contains("The wishlist is empty!"));
	}

}
