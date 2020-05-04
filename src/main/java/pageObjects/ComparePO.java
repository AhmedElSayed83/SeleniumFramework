package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePO extends PageObjBase{

	public ComparePO(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText="Apple MacBook Pro 13-inch")
    public WebElement firstProductName; 
    
    @FindBy(linkText="Asus N551JK-XO076H Laptop")
    public WebElement secodProductName ; 
	
	@FindBy(css = "table.compare-products-table")
	WebElement compareTable;
	
	@FindBy(tagName = "tr")
	List<WebElement> allRows;

	@FindBy(tagName = "td")
	List<WebElement> allCol;
	
	@FindBy(css = "div.no-data")
	public WebElement noDataLbl;
	
	@FindBy(css = "a.clear-list")
	WebElement clearListLink;
	
	public void clearCompareList() {
		clickButton(clearListLink);
	}
	public void compareProducts() {
		//get no. of all rows 
		System.out.println(allRows.size());
		// get data from each row and col.
		for (WebElement row : allRows) {
			System.out.println(row.getText() +"\t");
			for (WebElement col : allCol) {
				System.out.println(col.getText() + "\t");
			}
		}
	}
	
}
