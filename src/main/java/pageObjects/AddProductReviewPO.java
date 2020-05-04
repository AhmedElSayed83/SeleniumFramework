package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductReviewPO extends PageObjBase{

	public AddProductReviewPO(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "AddProductReview_Title")
	WebElement reviewTitleTxtBox;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewTxtArea;
	
	@FindBy(id = "addproductrating_5")
	public WebElement ratingRdoBtn; // common name for all RadioBtns 
	
	@FindBy(name = "add-review")
	WebElement submitReviewBtn;
	
	@FindBy(css = "div.result")
	public WebElement notification;
	
	public void addProductReview(String title, String reviewMsg) {
		setText2ElementTxt(reviewTitleTxtBox, title);
		setText2ElementTxt(reviewTxtArea, reviewMsg);
		clickButton(ratingRdoBtn);
		clickButton(submitReviewBtn);
	}

}
