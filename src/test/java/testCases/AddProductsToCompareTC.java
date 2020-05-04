package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ComparePO;
import pageObjects.HomePO;
import pageObjects.ProductDetailsPO;
import pageObjects.SearchProductPO;

public class AddProductsToCompareTC extends TestCaseBase{
	
	String firstProductName = "Apple MacBook Pro 13-inch";
    String secondProductName = "Asus N551JK-XO076H Laptop"; 

    HomePO homeObj;
    ProductDetailsPO productDetailsObj;
    SearchProductPO searchProductObj;
    ComparePO compareObj;
	// 1- Search for product number 1
	// 2- Search for product number 2 
	// 3- Add to compare 
	// 4- Clear list
    @Test(priority = 1)
    public void UserCanCompareProducts() throws InterruptedException {
    	searchProductObj= new SearchProductPO(driver);
    	productDetailsObj= new ProductDetailsPO(driver);
    	compareObj= new ComparePO(driver);
    	
    	searchProductObj.productSearchUsingAutoSuggest("macB");
    	Assert.assertTrue(productDetailsObj.productNameBreadCrumb.getText().contains(firstProductName));
    	productDetailsObj.addToCompareList();
    	
    	searchProductObj.productSearchUsingAutoSuggest("Asus");
    	Assert.assertTrue(productDetailsObj.productNameBreadCrumb.getText().contains(secondProductName));
    	productDetailsObj.addToCompareList();
    	
    	Thread.sleep(2000);
    	
    	driver.navigate().to("http://demo.nopcommerce.com/compareproducts");
    	Assert.assertTrue(compareObj.firstProductName.getText().equals("Apple MacBook Pro 13-inch"));
		Assert.assertTrue(compareObj.secodProductName.getText().equals("Asus N551JK-XO076H Laptop"));
		compareObj.compareProducts();	
    }
    
    @Test(priority=2)
	public void UserCanClearCompareList() {
		compareObj.clearCompareList();
		Assert.assertTrue(compareObj.noDataLbl.getText().contains("You have no items to compare."));
	}

}
