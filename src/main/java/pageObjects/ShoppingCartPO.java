package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPO extends PageObjBase{

	public ShoppingCartPO(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "a.product-name")
	//or @FindBy(linkText = "Apple MacBook Pro 13-inch")
	//@FindBy(css = "td.product")
	public WebElement productNameTitle;
	
	//@FindBy(id = "itemquantity19011")
	//@FindBy(css = "td.quantity")
	@FindBy(css = "input.qty-input")
	WebElement quantityTxtBox;
	
	@FindBy(name = "updatecart")
	WebElement updateCartBtn;
	
	//@FindBy(id = "removefromcart19011")
	@FindBy(css = "td.remove-from-cart")
	WebElement removeCheckBox;
	
	@FindBy(css = "div.no-data")
	public WebElement emptyMsg;
	
	@FindBy(id = "checkout")
	WebElement checkoutBtn;
	
	@FindBy(id = "termsofservice")
	WebElement termsofserviceCheckBox;
	
	@FindBy(css = "input.button-1.checkout-as-guest-button")
	private WebElement guestBtn;
	
	public void updateProductQuantityInCart(String quantity) {
		//Clear TextBox first
		clearText(quantityTxtBox);
		setText2ElementTxt(quantityTxtBox, quantity);
		clickButton(updateCartBtn);
	}
	
	public void removeProductFromCart() {
		clickButton(removeCheckBox);
		clickButton(updateCartBtn);
	}
	public void openCheckoutPage() {
		clickButton(termsofserviceCheckBox);
		clickButton(checkoutBtn);
	}

	public void openCheckoutPageAsGuest() {
		clickButton(termsofserviceCheckBox);
		clickButton(checkoutBtn);
		clickButton(guestBtn);
		
	}
	

}
