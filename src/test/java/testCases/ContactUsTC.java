package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ContactUsPO;
import pageObjects.HomePO;

public class ContactUsTC extends TestCaseBase{
	
	HomePO homeObj;
	ContactUsPO contactusObj;
	String fullName="Heba Samir";
	String Email="heba13@test.com";
	String Enquiry="Hi admin. This is for test purposes.";
	
	
	@Test
	public void userCanContactUs() {
		homeObj= new HomePO(driver);
		homeObj.openContactUsPage();
		contactusObj = new ContactUsPO(driver);
		contactusObj.contactUs(fullName, Email, Enquiry);
		Assert.assertTrue(contactusObj.SuccessMsg.getText().
				contains("Your enquiry has been successfully sent to the store owner."));
		
	}

}
