package VAFapplication;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageobjects.VAF.VAFApplication;

public class VAFInternalPageOnly {
	VAFApplication va = new VAFApplication();
	
	@Test
	public void GIVEN_InternalUserFormIsDisplayed_WHEN_UserEntersValidData_AND_NextButtonIsClickedTHEN_LegalRequirementsPageDisplayed() {
	//GIVEN
		va.goToVAFInternalUsersPage();
		va.enterUserName("sa35808186");
		va.enterUserPassword("wem@123");
		va.clickSignInButton();
		va.clickRefreshButton();
		//va.clickRefreshButton();
		va.closeCookies();
		//va.closeAlertText();
		va.clickNextBeforeBeginningInternalUser();
	//WHEN
		va.selectScheme();
		//va.clickTakeoverApplicationNo();
		va.scrollDown();
		va.selectMarketSubsegment();
		va.selectBusinessUnitVafBranch();
		va.selectSbsaBranch();
		va.enterSbsaBDOEmployeeNumber("739067");
		va.clickNextAtInternalUserDetailsEnd();
	//THEN
		String actualMsg = va.assertLegalRequirementsSuccessHeading();
		String expectedMsg = "LEGAL REQUIREMENTS";
		
		Reporter.log("actual ------>"+ actualMsg);
		Reporter.log("expected ------>"+ expectedMsg);
	
		Assert.assertEquals(actualMsg, expectedMsg);
		
	}
	
	@Test
	
	public void GIVEN_LegalRequirementsPageIsDisplayed_WHEN_UserEntersValidData_AND_NextButtonIsClickedTHEN_VehicleDetailsPageDisplayed() {
		va.debtReviewYes();
		va.underAdministrationNo();
		va.underSequestrationNo();
		va.positionOfAuthorityNo();
		va.isRelatedOrAssociatedWithPublicOfficialNo();
		va.indentityAndFraudPrevChecksAndInfoSharingConsent();
		va.understandAndAgreeToTermsAndConditions();
		va.clickNextLegalRequirements();
	}
	

}
