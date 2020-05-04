package pageObjects;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageObjBase {
	
	protected WebDriver driver;
	public static JavascriptExecutor jse;
	public Select selectOptions;
	public Actions action2;
	
	public PageObjBase(WebDriver driver) {
		PageFactory.initElements(driver, this); 
	}
	
	protected static void clickButton(WebElement button) {
		button.click();
	}
	protected static void submitButton(WebElement button) {
		button.submit();
	}
	
	protected static void setText2ElementTxt(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	protected static void scrollToBottom() {
		jse.executeScript("scrollBy(0,2500)");
	}
	
	protected void clearText(WebElement element) {
		element.clear();
	}

}
