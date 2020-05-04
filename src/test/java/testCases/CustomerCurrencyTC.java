package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePO;
import pageObjects.ProductDetailsPO;
import pageObjects.SearchProductPO;

public class CustomerCurrencyTC extends TestCaseBase {
	HomePO homeObj;
	ProductDetailsPO productDetailsObj;
	SearchProductPO searchProdObj;
	String productName="Apple MacBook Pro 13-inch";
	
	@Test(priority = 1)
	public void userCanChangeCurrency() {
		homeObj = new HomePO(driver);
		homeObj.changeCurrency();		
	}
	
	@Test(priority = 2)
	public void userCanSearchWithAutoSuggest(){
		try {
			searchProdObj= new SearchProductPO(driver);
			searchProdObj.productSearchUsingAutoSuggest("macB");
			productDetailsObj= new ProductDetailsPO(driver);
			Assert.assertEquals(productDetailsObj.productNameBreadCrumb.getText() , productName);
			Assert.assertTrue(productDetailsObj.priceLabel.getText().contains("Ђ"));
			System.out.println(productDetailsObj.priceLabel.getText());
			
		} catch (Exception e) {
			System.out.println("Error Occured: " + e.getMessage());
		}
	}

}
