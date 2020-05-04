package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPO extends PageObjBase{

	public CheckoutPO(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "billing-address-select")
	WebElement BillingAddList;
	
	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement fNameTxt;
	
	@FindBy(id = "BillingNewAddress_LastName")
	private WebElement lNameTxt;
	
	@FindBy(id = "BillingNewAddress_Email")
	private WebElement emailTxt;

	@FindBy(id = "BillingNewAddress_CountryId")
	private WebElement countryList;
	
	@FindBy(id = "BillingNewAddress_City")
	private WebElement cityTxt;

	@FindBy(id = "BillingNewAddress_Address1")
	private WebElement addressTxt;
	
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	private WebElement postCodeTxt;
	
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	private WebElement phoneTxt;
	
	@FindBy(css = "input.button-1.new-address-next-step-button")
	WebElement continueBtn; // 1.  //*[@id="billing-buttons-container"]/input
	
	@FindBy(id = "shippingoption_1")
	private WebElement shippingMethodRdo;
	
	@FindBy(css = "input.button-1.shipping-method-next-step-button")
	WebElement continueShippingBtn; // 2. //*[@id="shipping-method-buttons-container"]/input
	
	@FindBy(css = "input.button-1.payment-method-next-step-button")
	WebElement continuePaymentBtn; //3. //*[@id="payment-method-buttons-container"]/input
	
	@FindBy(css = "input.button-1.payment-info-next-step-button")
	WebElement continueInfoBtn; //4. //*[@id="payment-info-buttons-container"]/input
	
	@FindBy(css = "a.product-name")
	public WebElement prodcutName;

	@FindBy(css = "input.button-1.confirm-order-next-step-button")
	private WebElement confirmBtn;
	
	@FindBy(css = "h1")
	public WebElement ThankYoulbl;
	
	@FindBy(css = "div.title")
	private WebElement successMessage;
	
	@FindBy(linkText = "Click here for order details.")
	private WebElement orderDetailsLink;
	
	public void RegisteredUserCheckoutProduct(String countryName, String address, 
			String postcode, String phone, String city, String productName) throws InterruptedException {
		//selectOptions= new Select(BillingAddList);
		//selectOptions.selectByIndex(1);
		selectOptions= new Select(countryList);
		selectOptions.selectByVisibleText(countryName);
		setText2ElementTxt(cityTxt, city);
		setText2ElementTxt(addressTxt, address);
		setText2ElementTxt(postCodeTxt, postcode);
		setText2ElementTxt(phoneTxt, phone);
		clickButton(continueBtn);
		clickButton(shippingMethodRdo);
		clickButton(continueShippingBtn);
		Thread.sleep(1000);
		clickButton(continuePaymentBtn);
		Thread.sleep(1000);
		clickButton(continueInfoBtn);
	}
	
	public void confirmOrder() throws InterruptedException 
	{
		clickButton(confirmBtn);
		Thread.sleep(2000);
	}
	
	public void viewOrderDetails() {
		clickButton(orderDetailsLink);
	}

	public void CheckoutProduct(String firstName, String lastName,String email,
			String countryName, String city, String address, String postcode, 
			String phone,  String productName) throws InterruptedException {
		
		//selectOptions= new Select(BillingAddList);
		//selectOptions.selectByIndex(1);
		setText2ElementTxt(fNameTxt, firstName);
		setText2ElementTxt(lNameTxt, lastName);
		setText2ElementTxt(emailTxt, email);
		selectOptions = new Select(countryList);
		selectOptions.selectByVisibleText(countryName);
		setText2ElementTxt(cityTxt, city);
		setText2ElementTxt(addressTxt, address);
		setText2ElementTxt(postCodeTxt, postcode);
		setText2ElementTxt(phoneTxt, phone);
		clickButton(continueBtn);
		clickButton(shippingMethodRdo);
		clickButton(continueShippingBtn);
		Thread.sleep(2000);
		clickButton(continuePaymentBtn);
		Thread.sleep(2000);
		clickButton(continueInfoBtn);
	}

}
