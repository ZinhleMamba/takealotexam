package pageobjects.VAF;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import FrameworkClasses.BasePage;

public class VAFApplication extends BasePage{
	public void goToVAFInternalUsersPage() {
		driver.get("http://dsbgchop183.standardbank.co.za:8080/southafrica/personal/products-and-services/insure-what-matters/standard-insurance-limited?isStdBankInternalUser=true ");
	}
	public void goToVAFNormallUsersPage() {
		driver.get("http://dsbgchop183.standardbank.co.za:8080/southafrica/personal/products-and-services/insure-what-matters/standard-insurance-limited  ");
	}
	public void enterUserName(String userName) {
		EnterText(By.xpath("//input[@id='vui-cps-ui-toolbar-user-name-inputEl']"),userName);		
	}
	public void enterUserPassword(String userPwd) {
		EnterText(By.xpath("//input[@id='vui-cps-ui-toolbar-user-password-inputEl']"),userPwd);		
	}
	public void clickSignInButton() {
		clickElement(By.xpath("//span[@id='vui-cps-ui-toolbar-signin-button-btnIconEl']"));
	}
	
	public void clickRefreshButton() {
		clickElement(By.xpath("//span[@id='vui-cps-ui-preview-toolbar-clearCache-btnIconEl']"));
	}
	public void closeCookies() {
		clickElement(By.xpath("//i[@data-component='icon'][@data-icon='icon-close']"));
	}
	public void pageResize() {
		
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));
	}
	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
	}
	public void closeAlertText() {
		Alert alert = driver.switchTo().alert();	
			alert.accept();
				
		}
	//InternalUsers only
	public void clickNextBeforeBeginningInternalUser() {
		clickElement(By.xpath("//button[contains(text(),'Next')]"));
	}
	public String assertLegalRequirementsSuccessHeading() {
		return getElementText(By.xpath("//h3[contains(text(),'Legal Requirements')]"));
	}
	
	public void selectScheme() {
		Select s = new Select(driver.findElement(By.xpath("//select[@name='scheme']")));
		s.selectByIndex(1);
		//clickElement(By.xpath("//select[@name='scheme']"));		
	}
	public void clickTakeoverApplicationYes() {
		clickElement(By.xpath("//input[@name='takeoverApplication'][@value='Yes']"));
	}
	public void clickTakeoverApplicationNo() {
		clickElement(By.xpath("//input[@name='takeoverApplication'][@value='No']"));
	}
	public void selectMarketSubsegment() {
	//	clickElement(By.xpath("//select[@name='marketSubsegment']"));
		Select m = new Select(driver.findElement(By.xpath("//select[@name='marketSubsegment']")));
		m.selectByIndex(3);
	}
	public void selectBusinessUnitVafBranch() {
		//clickElement(By.xpath("//select[@name='vafBranch']"));
		Select v = new Select(driver.findElement(By.xpath("//select[@name='vafBranch']")));
		v.selectByIndex(2);
	}
	public void selectSbsaBranch() {
		clickElement(By.xpath("//select[@name='sbsaBranch']"));	
		Select b = new Select(driver.findElement(By.xpath("//select[@name='sbsaBranch']")));
		b.selectByIndex(3);
	}
	public void enterSbsaBDOEmployeeNumber(String sbsaBDOEmployeeNumber) {
		EnterText(By.xpath("//input[@name='sbsaBDONumber'][@type='text']"),sbsaBDOEmployeeNumber);		
	}
	public void clickNextAtInternalUserDetailsEnd() {
		clickElement(By.xpath("//button[contains(text(),'Next')]"));
	}

	
	//Normal Users start here
	public void clickNextBeforeBeginning() {
		clickElement(By.xpath("//button[contains(text(),'Next')]"));
	}
	
	public void debtReviewYes() {
		clickElement(By.xpath("//input[@ type='radio-button'][@value='Yes'][@name='currentlyUnderDebtReview']"));
	}
	public void debtReviewNo() {
		clickElement(By.xpath("//input[@name='currentlyUnderDebtReview'][@value='No']"));
	}
	public void underAdministrationYes() {
		clickElement(By.xpath("//input[@name='currentlyUnderAdministrationOrder'][@value='Yes']"));
	}
	public void underAdministrationNo() {
		clickElement(By.xpath("//input[@name='currentlyUnderAdministrationOrder'][@value='No']"));
	}
	public void underSequestrationYes() {
		clickElement(By.xpath("//input[@name='currentlyUnderSequstrationOrder'][@value='Yes']"));
	}
	public void underSequestrationNo() {
		clickElement(By.xpath("//input[@name='currentlyUnderSequstrationOrder'][@value='No']"));
	}
	public void positionOfAuthorityYes() {
		clickElement(By.xpath("//input[@name='isPublicOfficialOrInPositionOfAuthority'][@value='Yes']"));
	}
	public void positionOfAuthorityNo() {
		clickElement(By.xpath("//input[@name='isPublicOfficialOrInPositionOfAuthority'][@value='No']"));
	}
	public void isRelatedOrAssociatedWithPublicOfficialYes() {
		clickElement(By.xpath("//input[@name='isRelatedOrAssociatedWithPublicOfficial'][@value='Yes']"));
	}
	public void isRelatedOrAssociatedWithPublicOfficialNo() {
		clickElement(By.xpath("//input[@name='isRelatedOrAssociatedWithPublicOfficial'][@value='No']"));
	}
	public void selectNatureofRelationship() {
		clickElement(By.xpath("//select[@name='natureOfRelationshipFic']"));		
	}
	public void enterpublicOfficialNameSurname(String publicOfficialNameSurname) {
		EnterText(By.xpath("//input[@name='publicOfficialNameSurname']"),publicOfficialNameSurname);		
	}
	public void indentityAndFraudPrevChecksAndInfoSharingConsent() {
		clickElement(By.xpath("//div[name='indentityAndFraudPreventionChecksAndInformationSharingConsent'][@class='form__control-indicator']"));
	}
	public void understandAndAgreeToTermsAndConditions() {
		clickElement(By.xpath("//div[name='understandAndAgreeToTermsAndConditions'][@class='form__control-indicator']"));
	}
	public void termsAndCondtitionsLink() {
		clickElement(By.linkText("terms and conditions"));
	}
	public void clickNextLegalRequirements() {
		clickElement(By.xpath("//button[contains(text(),'Next')]"));
	}
	
	//Vehicles page
	
	public void isReplacingAnExistingVehicleYes() {
		clickElement(By.xpath("//input[@name='replacingAnExistingVehicle'][@value='Yes']"));
	}
	public void enterExistingVehicleCurrentMonthlyInstalment(String existingVehicleCurrentMonthlyInstalment) {
		EnterText(By.xpath("//input[@name='existingVehicleCurrentMonthlyInstalment']"),existingVehicleCurrentMonthlyInstalment);		
	}
	public void isReplacingAnExistingVehicleNo() {
		clickElement(By.xpath("//input[@name='replacingAnExistingVehicle'][@value='No']"));
	}
	
	public void isPurchasingNewOrUsedVehicleYes() {
		clickElement(By.xpath("//input[@name='purchasingNewOrUsedVehicle'][@value='Yes']"));
	}
	public void isPurchasingNewOrUsedVehicleNo() {
		clickElement(By.xpath("//input[@name='purchasingNewOrUsedVehicle'][@value='No']"));
	}
	public void selectYearOfRegistration() {
		clickElement(By.xpath("//select[@name='yearOfRegistration']"));		
	}
	public void selectVehicleMake() {
		clickElement(By.xpath("//select[@name='vehicleMake']"));		
	}
	public void selectVehicleModel() {
		clickElement(By.xpath("//select[@name='vehicleModel']"));		
	}
	public void enterVehiclePurchasePrice(String vehiclePurchasePrice) {
		EnterText(By.xpath("//input[@name='purchasePrice']"),vehiclePurchasePrice);		
	}
	public void hasVehicleExtrasNo() {
		clickElement(By.xpath("//input[@name='hasVehicleExtras'][@value='No']"));
	}
	public void hasVehicleExtrasYes() {
		clickElement(By.xpath("//input[@name='hasVehicleExtras'][@value='Yes']"));
	}
	public void enterVehicleExtrasTotal(String vehicleExtrasTotal) {
		EnterText(By.xpath("//input[@name='vehicleExtrasTotal']"),vehicleExtrasTotal);		
	}
	public void enterLicenceExtrasTotal(String licenceExtrasTotal) {
		EnterText(By.xpath("//input[@name='licenceExtrasTotal']"),licenceExtrasTotal);		
	}
	public void enterOtherExtrasTotal(String otherExtrasTotal) {
		EnterText(By.xpath("//input[@name='otherExtrasTotal']"),otherExtrasTotal);		
	}
	public void enterVehicleDeposit(String vehicleDeposit) {
		EnterText(By.xpath("//input[@name='deposit']"),vehicleDeposit);		
	}
	public void enterBalloonPercentage(String balloonPercentage) {
		EnterText(By.xpath("//input[@name='balloonPercentage']"),balloonPercentage);		
	}
	public void enterResidualValue(String residualValue) {
		EnterText(By.xpath("//input[@disabled name='residualValue']"),residualValue);		
	}
	public void hasRateTypeLinked() {
		clickElement(By.xpath("//input[@name='rateType'][@value='LINKED']"));
	}
	public void hasRateTypeFixed() {
		clickElement(By.xpath("//input[@name='rateType'][@value='FIXED']"));
	}
	public void selectRepaymentTerm() {
		clickElement(By.xpath("//select[@name='repaymentTerm']"));		
	}
	public void buyPrivateSeller() {
		clickElement(By.xpath("//input[@name='vehiclePurchaseLocation'][@value='No']"));
	}
	public void buyDealership() {
		clickElement(By.xpath("//input[@name='vehiclePurchaseLocation'][@value='Yes']"));
	}
	public void selectDealershipProvince() {
		clickElement(By.xpath("//select[@name='dealershipProvince']"));		
	}
	public void selectDealershipProvinceSubRegion() {
		clickElement(By.xpath("//select[@name='dealershipProvinceSubRegion']"));		
	}
	public void selectDealershipName() {
		clickElement(By.xpath("//select[@name='dealershipName']"));		
	}
	public void clickBackAtvehicleDetails() {
		clickElement(By.xpath("//button[contains(text(),'Back')]"));
	}
	public void clickNextAtvehicleDetails() {
		clickElement(By.xpath("//button[contains(text(),'Next')]"));
	}
	//Personal Details Page
	
	public void clickcustomerTypePrivate() {
		clickElement(By.xpath("//input[@name='customerType'][@value='Private Individual']"));
	}
	public void clickcustomerTypeSoleProprietor() {
		clickElement(By.xpath("//input[@name='customerType'][@value='Self Employed(Professional)']"));
	}
	public void enterSaIdentityNumber(String saIdentityNumber) {
		EnterText(By.xpath("//input[@name='saIdentityNumber']"),saIdentityNumber);		
	}
	
	public void selectNameTitle() {
		clickElement(By.xpath("//select[@name='nameTitle']"));		
	}
	public void enterFirstName(String firstName) {
		EnterText(By.xpath("//input[@name='firstName']"),firstName);		
	}
	public void enterLastName(String lastName) {
		EnterText(By.xpath("//input[@name='lastName']"),lastName);		
	}
	public void selectEthnicity() {
		clickElement(By.xpath("//select[@name='ethnicity']"));		
	}
	public void selectCountryOfBirth() {
		clickElement(By.xpath("//select[@name='countryOfBirth']"));		
	}
	public void selectCountryOfCitizenship() {
		clickElement(By.xpath("//select[@name='countryOfCitizenship']"));		
	}
	public void selectMaritalStatus() {
		clickElement(By.xpath("//select[@name='maritalStatus']"));		
	}
	public void selectMaritalType() {
		clickElement(By.xpath("//select[@name='maritalType']"));		
	}
	
	public void clickBackAtPersonalDetails() {
		clickElement(By.xpath("//button[contains(text(),'Back')]"));
	}
	public void clickNextAtPersonalDetails() {
		clickElement(By.xpath("//button[contains(text(),'Next')]"));
	}
	
	//Contact Details
	
	public void enterCellNumber(String cellNumber) {
		EnterText(By.xpath("//input[@name='cellNumber']"),cellNumber);		
	}
	public void enterOfficeNumber(String officeNumber) {
		EnterText(By.xpath("//input[@name='officeNumber']"),officeNumber);		
	}
	public void enterEmailAddress(String emailAddress) {
		EnterText(By.xpath("//input[@name='emailAddress']"),emailAddress);		
	}
	public void selectResidentailStatus() {
		clickElement(By.xpath("//select[@name='residentailStatus']"));		
	}
	public void enterStreetNumber(String streetNumber) {
		EnterText(By.xpath("//input[@name='streetNumber']"),streetNumber);		
	}
	public void enterStreetName(String streetName) {
		EnterText(By.xpath("//input[@name='Street name']"),streetName);		
	}
	public void enterSuburbName(String suburb) {
		EnterText(By.xpath("//input[@name='suburb']"),suburb);		
	}
	public void enterCityName(String city) {
		EnterText(By.xpath("//input[@name='city']"),city);		
	}
	public void enterPostalCode(String postalCode) {
		EnterText(By.xpath("//input[@name='postalCode']"),postalCode);		
	}
	public void clickBackAtContactDetails() {
		clickElement(By.xpath("//button[contains(text(),'Back')]"));
	}
	public void clickNextAtContactDetails() {
		clickElement(By.xpath("//button[contains(text(),'Next')]"));
	}
	
	//Employment Details
	public void selectEmploymentStatus() {
		clickElement(By.xpath("//select[@name='employmentStatus']"));		
	}
	public void isStandardBankEmployeeYes() {
		clickElement(By.xpath("//input[@name='isStandardBankEmployee'][@value='Yes']"));
	}
	public void enterSbEmployeeNumber(String sbEmployeeNumber) {
		EnterText(By.xpath("//input[@name='sbEmployeeNumber']"),sbEmployeeNumber);		
	}
	
	public void isStandardBankEmployeeNo() {
		clickElement(By.xpath("//input[@name='isStandardBankEmployee'][@value='No']"));
	}
	public void enterPlaceOfEmployment(String placeOfEmployment) {
		EnterText(By.xpath("//input[@name='placeOfEmployment']"),placeOfEmployment);		
	}
	
	public void selectOccupation() {
		clickElement(By.xpath("//select[@name='occupation']"));		
	}
	public void selectEmployerISICCode_Level1() {
		clickElement(By.xpath("//select[@name='employerISICCode_Level1']"));		
	}
	public void selectEmployerISICCode_Level2() {
		clickElement(By.xpath("//select[@name='employerISICCode_Level2']"));		
	}
	public void selectEmployerISICCode_Level3() {
		clickElement(By.xpath("//select[@name='employerISICCode_Level3']"));		
	}
	public void selectEmployerISICCode_Level4() {
		clickElement(By.xpath("//select[@name='employerISICCode_Level4']"));		
	}
	public void selectEmployerISICCode_Level5() {
		clickElement(By.xpath("//select[@name='employerISICCode_Level5']"));		
	}
	public void selectStartDateOfCurrentEmploymentDay() {
		clickElement(By.xpath("//select[@name='startDateOfCurrentEmploymentDay']"));		
	}
	public void selectStartDateOfCurrentEmploymentMonth() {
		clickElement(By.xpath("//select[@name='startDateOfCurrentEmploymentMonth']"));		
	}
	public void selectStartDateOfCurrentEmploymentYear() {
		clickElement(By.xpath("//select[@name='startDateOfCurrentEmploymentYear']"));		
	}
	
	public void clickBackAtEmploymentDetails() {
		clickElement(By.xpath("//button[contains(text(),'Back')]"));
	}
	public void clickNextAtEmploymenttDetails() {
		clickElement(By.xpath("//button[contains(text(),'Next')]"));
	}
	
	//Income and Banking Details
	
	public void enterMonthlyIncomeBeforeTax(String monthlyIncomeBeforeTax) {
		EnterText(By.xpath("//input[@name='monthlyIncomeBeforeTax']"),monthlyIncomeBeforeTax);		
	}
	public void enterMonthlyIncomeAfterTax(String monthlyIncomeAfterTax) {
		EnterText(By.xpath("//input[@name='monthlyIncomeAfterTax']"),monthlyIncomeAfterTax);		
	}
	public void enterCarAllowance(String carAllowance) {
		EnterText(By.xpath("//input[@name='carAllowance']"),carAllowance);		
	}
	public void enterMonthlyExpenses(String monthlyExpenses) {
		EnterText(By.xpath("//input[@name='monthlyExpenses']"),monthlyExpenses);		
	}
	public void hasAdditionalIncomeNo() {
		clickElement(By.xpath("//input[@name='hasAdditionalIncome'][@value='No']"));
	}
	public void hasAdditionalIncomeYes() {
		clickElement(By.xpath("//input[@name='hasAdditionalIncome'][@value='Yes']"));
	}
	public void enterAdditionalIncomeAmount(String additionalIncomeAmount) {
		EnterText(By.xpath("//input[@name='additionalIncomeAmount']"),additionalIncomeAmount);		
	}
	public void enterSourceOfAdditionalIncome(String sourceOfAdditionalIncome) {
		EnterText(By.xpath("//input[@name='sourceOfAdditionalIncome']"),sourceOfAdditionalIncome);		
	}
	public void selectCurrentBank() {
		clickElement(By.xpath("//select[@name='currentBank']"));		
	}
	public void enterOtherSpecifiedCurrentBank(String specifiedCurrentBank) {
		EnterText(By.xpath("//input[@name='specifiedCurrentBank']"),specifiedCurrentBank);		
	}
	public void enterOtherSpecifiedCurrentBankBranchCode(String specifiedCurrentBankBranchCode) {
		EnterText(By.xpath("//input[@name='specifiedCurrentBankBranchCode']"),specifiedCurrentBankBranchCode);		
	}
	public void enterBankAccountNumber(String bankAccountNumber) {
		EnterText(By.xpath("//input[@name='bankAccountNumber']"),bankAccountNumber);		
	}
	public void clickBankAccountTypeCheque() {
		clickElement(By.xpath("//input[@name='bankAccountType'][@value='Cheque']"));
	}
	public void clickBankAccountTypeSavings() {
		clickElement(By.xpath("//input[@name='bankAccountType'][@value='Savings']"));
	}
	public void selectCustomerSalaryDay() {
		clickElement(By.xpath("//select[@name='customerSalaryDay']"));		
	}
	public void clickPermissionToRequestBankStatementsYes() {
		clickElement(By.xpath("//input[@name='permissionToRequestBankStatements'][@value='Yes']"));
	}
	public void clickPermissionToRequestBankStatementsNo() {
		clickElement(By.xpath("//input[@name='permissionToRequestBankStatements'][@value='No']"));
	}
	public void clickReCaptchaCheckBox() {
		clickElement(By.xpath("//div[@class='recaptcha-checkbox-border'][@role='presentation']"));
	}

	public void clickBackAtIncomeNBankingDetails() {
		clickElement(By.xpath("//button[contains(text(),'Back')]"));
	}
	public void clickNextAtIncomeNBankingDetails() {
		clickElement(By.xpath("//button[contains(text(),'Next')]"));
	}

}
