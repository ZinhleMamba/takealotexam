package cmbandapplynow;

import org.testng.Assert;
import org.testng.annotations.Test;

import accounts.cmb.applynow.ContractSaveCMB;

public class ContractSaveCMBTest {
	ContractSaveCMB cs = new ContractSaveCMB();
	
	@Test
	public void GIVEN_CotractSaveForm_WHEN_ValidCustomerDataIsUsed_THEN_SuccessPageIsDisplayed() {
		//GIVEN
		cs.goToContractSavePage();
		cs.enterUserName("sa35808186");
		cs.enterUserPassword("wem@123");
		cs.clickSignInButton();
		cs.clickRefreshButton();
		//cs.zoomPage();
		
		//cs.clickCallMeBackButton();
		cs.closeCookies();
		cs.scrollUp();
		//cs.pageResize();
		cs.clickRefreshButton();
		cs.clickCallMeBackButton();
		//cs.goToAlertText();
		//WHEN
		cs.enterFirstName("Zola");
		cs.enterLastName("Seven");
		cs.enterPhoneNumber("0879098711");
		cs.enterAlternativePhoneNumber("0987656799");
		cs.enterEmailAddress("ziphelele@seven.com");
		cs.enterIDNumber("9412306602093");
		//cs.scrollDown();
		cs.popiaConsent();
		cs.clickSubmitButton();
		
		//THEN
		String actualMessage = cs.assertContractSaveSuccessHeading();
		String expectedMessage = "Your request was submitted.";
		Assert.assertEquals(actualMessage, expectedMessage);
		
	}

}
