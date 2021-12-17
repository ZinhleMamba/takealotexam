package accounts.cmb.applynow;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import FrameworkClasses.BasePage;

public class ContractSaveCMB extends BasePage {
	public void goToContractSavePage() {
		driver.get("http://uwempas1v.standardbank.co.za:8080/southafrica/personal/products-and-services/insure-what-matters/your-future/trusts ");
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
	public void scrollUp() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("window.scrollBy(0,-100)");
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Call Me Back')]"));
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
	}
public void pageResize() {
	for(int i=0; i<3;i++) {
		driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));
//		WebElement html = driver.findElement(By.tagName("html"));
//		html.sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));
	}
	}
	
	public void clickCallMeBackButton() {
		clickElement(By.xpath("//a[contains(text(),'Call Me Back')]"));
	}
	
	//create  method or a pop up n close it
	
	
			public void goToAlertText() {
				Alert alert = driver.switchTo().alert();	
				
			}
			
			public void closeAlertText() {
			Alert alert = driver.switchTo().alert();	
				alert.accept();
					
			}
			
			public void closeCookies() {
				clickElement(By.xpath("//i[@data-component='icon'][@data-icon='icon-close']"));
			}
			
			public void zoomPage() {
				
				for(int i=0; i<3; i++){
					driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));
				}
			}
	
	public void enterFirstName(String firstName) {
		EnterText(By.xpath("//input[@name='first-name']"),firstName);		
	}
	public void enterLastName(String lastName) {
		EnterText(By.xpath("//input[@name='last-name']"),lastName);		
	}
	public void enterPhoneNumber(String phoneNumber) {
		EnterText(By.xpath("//input[@name='phone-number']"),phoneNumber);		
	}
	public void enterAlternativePhoneNumber(String altphoneNumber) {
		EnterText(By.xpath("//input[@name='phone-number-2']"),altphoneNumber);		
	}
	public void enterEmailAddress(String emailAddress) {
		EnterText(By.xpath("//input[@name='emailAddress']"),emailAddress);		
	}
	public void enterIDNumber(String idNumber) {
		EnterText(By.xpath("//input[@name='identification']"),idNumber);	
		
	}
	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-100)");
		//WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Call Me Back')]"));
		//jse.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	public void popiaConsent() {
		clickElement(By.xpath("//label[./div[@class = 'form__control-indicator']]"));
	}
	public void termsAndConditionsLink() {
		clickElement(By.linkText("Privacy Policy"));
	}
	public void clickSubmitButton() {
		clickElement(By.xpath("//a[contains(text(),'Submit')]"));
	}
	public String assertContractSaveSuccessHeading() {
		return getElementText(By.xpath("//h4[contains(text(),' Your request was submitted. ')]"));
	}

}
