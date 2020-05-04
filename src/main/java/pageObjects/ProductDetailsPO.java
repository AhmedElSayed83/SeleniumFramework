package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPO extends PageObjBase{

	public ProductDetailsPO(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="strong.current-item")
	public WebElement productNameBreadCrumb;
	
	//Hello my friend. this is a very good product. have a look.
	@FindBy(css = "input.button-2.email-a-friend-button")
	WebElement emailFreindBtn;
	
	@FindBy(css ="span.price-value-4")
	public WebElement priceLabel;
	
	@FindBy(linkText = "Add your review")
	WebElement addReviewLink;
	
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement addToWishlistBtn;
	
	@FindBy(css = "input.button-2.add-to-compare-list-button")
	WebElement addToCompareListBtn;
	
	@FindBy(id = "add-to-cart-button-4")
	WebElement addToCartBtn;
	
	public void openEmailFriendPage() {
		clickButton(emailFreindBtn);
	}
	public void openAddReviewPage() {
		clickButton(addReviewLink);
	}
	
	public void addProductToWishlist() {
		clickButton(addToWishlistBtn);
	}

	public void addToCompareList() {
		clickButton(addToCompareListBtn);
	}
	public void addToCart() {
		clickButton(addToCartBtn);
	}
}
