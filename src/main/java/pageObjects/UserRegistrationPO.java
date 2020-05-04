package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPO extends PageObjBase {

	public UserRegistrationPO(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="gender-male")
	WebElement genderRdoBtn;
	
	@FindBy(id="FirstName")
	WebElement fnameTxtBox;
	
	@FindBy(id="LastName")
	WebElement lnameTxtBox;
	
	@FindBy(id="Email")
	WebElement emailTxtBox;
	
	@FindBy(id="Password")
	WebElement passwordTxtBox;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmPasswordTxtBox;
	
	@FindBy(id="register-button")
	WebElement registerBtn;
	
	@FindBy(css="div.result")
	public WebElement SuccessMsg; 
	
	@FindBy(linkText="Log out")
	public WebElement logoutLink;
	
	@FindBy(linkText = "My account")
	public WebElement myAccountLink;
	
	public void userRegistration(String fname, String lname , String email, String password) {
		clickButton(genderRdoBtn);	 //genderRdoBtn.click();
		setText2ElementTxt(fnameTxtBox, fname);	//fnameTxtBox.sendKeys(fname);
		setText2ElementTxt(lnameTxtBox, lname);	//lnameTxtBox.sendKeys(lname);
		setText2ElementTxt(emailTxtBox, email);	//emailTxtBox.sendKeys(email);
		setText2ElementTxt(passwordTxtBox, password);	//passwordTxtBox.sendKeys(password);
		setText2ElementTxt(confirmPasswordTxtBox, password);	//confirmPasswordTxtBox.sendKeys(password);
		submitButton(registerBtn);		//registerBtn.submit();
	}
	
	public void userLogout() {
		clickButton(logoutLink);
	}
	
	public void openMyAccountPage() {
		clickButton(myAccountLink);
	}

}
