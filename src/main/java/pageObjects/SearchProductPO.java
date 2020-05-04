package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProductPO extends PageObjBase {

	public SearchProductPO(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "small-searchterms")
	WebElement searchTxtBox;
	
	@FindBy(css = "input.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(id= "ui-id-1")
	List<WebElement> productList;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	WebElement productTitle;
	
	public void productSearch(String productName) {
		setText2ElementTxt(searchTxtBox, productName);
		clickButton(searchBtn);
	}
	public void openProductDetailsPage() {
		clickButton(productTitle);
	} 
	
	public void productSearchUsingAutoSuggest(String searchTxt) throws InterruptedException {
		setText2ElementTxt(searchTxtBox, searchTxt);
		Thread.sleep(1000);
		productList.get(0).click();
	}

}
