package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPO extends PageObjBase {

	public EmailFriendPO(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FriendEmail")
	WebElement friendEmailTxtBox;
	
	@FindBy(id = "PersonalMessage")
	WebElement personalMsgTxtArea;
	
	@FindBy(name = "send-email")
	WebElement sendEmailBtn;
	
	@FindBy(css = "div.result")
	public WebElement MsgSent;
	
	public void sendEmailToFriend(String friendEmail, String personalMsg) {
		setText2ElementTxt(friendEmailTxtBox, friendEmail);
		setText2ElementTxt(personalMsgTxtArea, personalMsg);
		clickButton(sendEmailBtn);
	}

}
