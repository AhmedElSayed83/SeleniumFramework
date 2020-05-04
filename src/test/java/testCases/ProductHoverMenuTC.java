package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePO;

public class ProductHoverMenuTC extends TestCaseBase {

	HomePO homeObj;
	
	@Test
	public void userCanSelectSubCategoryFromMainMenu() {
		homeObj= new HomePO(driver);
		homeObj.selectNotebooksMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}
}
