package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPO extends PageObjBase {

	public WishlistPO(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "wishlist")
	WebElement wishlistNotificationLink;
	
	@FindBy(className = "page-title") // or css 
	public WebElement wishlistHeader; 
	
	@FindBy(className = "product-name")// or (css = "td.product")
	public WebElement productCell; 
	
	@FindBy(name = "removefromcart")
	WebElement removefromcartCheck;
	
	@FindBy(name = "updatecart")
	WebElement updatecartBtn;
	
	@FindBy(className = "no-data") //  or css
	public WebElement emptyCartMsg; 
	
	
	public void openWishlistNotificationLink() {	
		clickButton(wishlistNotificationLink);
	}
	
	public void removeProductFromWishlist() {	
		clickButton(removefromcartCheck);
		clickButton(updatecartBtn);
	}
	
	
	

}
