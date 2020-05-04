package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductDetailsPO;
import pageObjects.SearchProductPO;

public class SearchProductUsingAutoSuggestTC extends TestCaseBase {
	
	String productName="Apple MacBook Pro 13-inch";
	SearchProductPO searchProdObj;
	ProductDetailsPO productDetailsObj;
	
	@Test
	public void userCanSearchWithAutoSuggest(){
		try {
			searchProdObj= new SearchProductPO(driver);
			searchProdObj.productSearchUsingAutoSuggest("macB");
			productDetailsObj= new ProductDetailsPO(driver);
			Assert.assertEquals(productDetailsObj.productNameBreadCrumb.getText() , productName);
			
		} catch (Exception e) {
			System.out.println("Error Occured: " + e.getMessage());
		}
		
	}

}
