package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends PageObjBase {

	public LoginPO(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "Email")
	WebElement emailTxtBox;
	
	@FindBy(id = "Password")
	WebElement PasswordTxtBox;
	
	@FindBy(css = "input.button-1.login-button")
	WebElement LoginBtn;
	
	public void UserLogin(String email, String password) {
		setText2ElementTxt(emailTxtBox, email);
		setText2ElementTxt(PasswordTxtBox, password);
		submitButton(LoginBtn);
	}
	
	

}
