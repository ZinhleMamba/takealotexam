package cmbandapplynow;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import accounts.cmb.applynow.PaySpaceCMB;

public class PaySpaceTest {
	PaySpaceCMB ps = new PaySpaceCMB();
	
	@Test
	public void GIVEN_PaySpaceForm_WHEN_ValidCustomerDataIsUsed_THEN_SuccessPageIsDisplayed() {
		//GIVEN
		ps.goToPaySpacePage();
		ps.enterUserName("sa35808186");
		ps.enterUserPassword("wem@123");
		ps.clickSignInButton();
		ps.clickRefreshButton();
		//WHEN
		ps.closeCookies();
		ps.clickCallMeBackButton();
		ps.enterfirstName("Zinhle 1234");
		ps.enterlastName("Testing automation");
		ps.enterPhoneNumber("0987654328");
		ps.clickSubmitButton();
		
		//THEN
				String actualMessage = ps.assertPaySpaceHeading();
				String expectedMessage = "Your enquiry has been submitted successfully.";
				Reporter.log("actual ------>"+ actualMessage);
				Reporter.log("expected ------>"+ expectedMessage);
				Assert.assertEquals(actualMessage, expectedMessage);
	}

}
