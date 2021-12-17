package accounts.cmb.applynow;

import org.openqa.selenium.By;

import FrameworkClasses.BasePage;

public class PaySpaceCMB extends BasePage {
	
	public void goToPaySpacePage() {
		driver.get("http://uwempws1v.standardbank.co.za/southafrica/personal/products-and-services/insure-what-matters/yourself/life%E2%80%93cover ");
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
	
	public void clickCallMeBackButton() {
		clickElement(By.xpath("//a[contains(text(),'Call me back')]"));
	}
	
	public void closeCookies() {
		clickElement(By.xpath("//i[@data-component='icon'][@data-icon='icon-close']"));
	}
	public void enterfirstName(String fName) {
		EnterText(By.xpath("//input[@type='text'][@name='first-name']"),fName);		
	}
	
	public void enterlastName(String lName) {
		EnterText(By.xpath("//input[@type='text'][@name='last-name']"),lName);		
	}
	
	public void enterPhoneNumber(String phoneNumber) {
		EnterText(By.xpath("//input[@type='number'][@name='contact-number']"),phoneNumber);		
	}
	
	public void clickSubmitButton() {
		clickElement(By.xpath("//a[@class='button button--medium apply-now__button js-payspace-payroll-and-hr__button']"));
	}
	
	public String assertPaySpaceHeading() {
		return getElementText(By.xpath("//p[contains(text(),'Your enquiry has been submitted successfully.')]"));
	}
	
	
}
