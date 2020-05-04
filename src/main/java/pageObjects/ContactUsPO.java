package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPO extends PageObjBase{

	public ContactUsPO(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="FullName")
	WebElement fNameTxtBox;
	
	@FindBy(id="Email")
	WebElement emailTxtBox;
	
	@FindBy(id="Enquiry")
	WebElement queryTxtArea;
	
	@FindBy(name = "send-email")
	WebElement submitBtn;
	
	@FindBy( css= "div.result")
	public WebElement SuccessMsg;
	
	public void contactUs(String fname, String email, String enquiry) {
		
		setText2ElementTxt(fNameTxtBox, fname);
		setText2ElementTxt(emailTxtBox, email);
		setText2ElementTxt(queryTxtArea, enquiry);
		submitButton(submitBtn);
	}

}
