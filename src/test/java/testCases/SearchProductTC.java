package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductDetailsPO;
import pageObjects.SearchProductPO;

public class SearchProductTC extends TestCaseBase {

	String productName="Apple MacBook Pro 13-inch";
	SearchProductPO searchProdObj;
	ProductDetailsPO productDetailsObj;

	@Test
	public void userCanSearchForProducts() {
		searchProdObj = new SearchProductPO(driver);
		searchProdObj.productSearch(productName);
		searchProdObj.openProductDetailsPage();
		productDetailsObj = new ProductDetailsPO(driver);
		//Assert.assertTrue(productDetailsObj.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
		Assert.assertEquals(productDetailsObj.productNameBreadCrumb.getText() , productName);
	}

}
