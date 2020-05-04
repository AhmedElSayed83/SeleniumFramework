package pageObjects;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePO extends PageObjBase {

	public HomePO(WebDriver driver) {
		super(driver);	
		jse= (JavascriptExecutor) driver;
		action2= new Actions(driver); //to deal with Hover
	}
	
	@FindBy(linkText = "Register")
	WebElement registerLink;
	
	@FindBy(linkText = "Log in")
	WebElement loginLink;
	
	@FindBy(linkText = "Contact us")
	WebElement contactusLink;
	
	@FindBy(id = "customerCurrency")
	WebElement currencyDropList;
		
	//@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
	@FindBy(linkText = "Computers ")
	WebElement computerMenu;
	
	//@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a/text()") //"Notebooks "
	@FindBy(linkText= "Notebooks ")
	WebElement notebookMenu;// 
	
	public void openRegistrationPage() {
		clickButton(registerLink);	//registerLink.click();
	}
	
	public void openLoginPage() {
		clickButton(loginLink);	
	}
	
	public void openContactUsPage() {
		scrollToBottom();
		clickButton(contactusLink);
	}
	
	public void changeCurrency() {
		selectOptions = new Select(currencyDropList);
		selectOptions.selectByVisibleText("Euro");
	}
	
	public void selectNotebooksMenu() {
		//to deal with Hover
		action2
		.moveToElement(computerMenu)
		.moveToElement(notebookMenu)
		.click()
		.build()
		.perform();
	}

}
