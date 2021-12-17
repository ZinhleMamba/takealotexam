package VAFapplication;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageobjects.VAF.VAFApplication;

public class VAFNormalUserTest {
	VAFApplication vaf = new VAFApplication();
	@Test
	
	public void GIVEN_NormalUserFormIsDisplayed_WHEN_NextButtonIsClickedTHEN_LegalRequirementsPageDisplayed() {
		//GIVEN
		vaf.goToVAFNormallUsersPage();
		vaf.enterUserName("sa35808186");
		vaf.enterUserPassword("wem@123");
		vaf.clickSignInButton();
		vaf.clickRefreshButton();
		vaf.closeCookies();
		
		//WHEN
		vaf.clickNextBeforeBeginning();
		//THEN
		String actualMsg = vaf.assertLegalRequirementsSuccessHeading();
		String expectedMsg = "LEGAL REQUIREMENTS";
		
		Reporter.log("actual ------>"+ actualMsg);
		Reporter.log("expected ------>"+ expectedMsg);
		Assert.assertEquals(actualMsg, expectedMsg);
		
		
	}
	
	@Test
	
	public void GIVEN_LegalRequirementsPageIsDisplayed_WHEN_UserEntersValidData_AND_NextButtonIsClickedTHEN_VehicleDetailsPageDisplayed() {
		//GIVEN
		vaf.debtReviewYes();
		vaf.underAdministrationNo();
		vaf.underSequestrationNo();
	}

}
