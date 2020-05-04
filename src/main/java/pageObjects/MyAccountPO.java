package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPO extends PageObjBase{

	public MyAccountPO(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Change password")
	WebElement changePassLink;
	
	@FindBy(id="OldPassword")
	WebElement oldPassTxtBox;
	
	@FindBy(id="NewPassword")
	WebElement newPassTxtBox;
	
	@FindBy(id="ConfirmNewPassword")
	WebElement confirmNewPassTxtBox;
	
	@FindBy(css="input.button-1.change-password-button")
	WebElement changePassBtn;
	
	@FindBy(css="div.result")
	public WebElement PassChangedMsg;
	
	public void openChangePasswordPage() {
		clickButton(changePassLink);
	}
	
	public void changePassword(String oldPass, String newPass) {
		setText2ElementTxt(oldPassTxtBox, oldPass);
		setText2ElementTxt(newPassTxtBox, newPass);
		setText2ElementTxt(confirmNewPassTxtBox, newPass);
		clickButton(changePassBtn);
	}
	
	
}
