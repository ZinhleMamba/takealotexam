package pageObjectstakealot;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;

import FrameworkClasses.BasePage;
import groovyjarjarantlr4.v4.parse.ANTLRParser.element_return;

public class Takealot extends BasePage{
	
	public void goToTakealotPage() {
		driver.get("https://www.takealot.com/");
	}
	
	public void covidInfoClose() {
		clickElement(By.xpath("//div[@class='covid-banner-module_close-icon_h--s8']"));
	}
	
	public void cookieNotificationGotIt() {
		try {
			if(driver.findElement(By.xpath("//button[contains(text(),'Got it')]")).isDisplayed()) {
				clickElement(By.xpath("//button[contains(text(),'Got it')]"));
			}else {
				System.out.println("Cookie Element not found");
			}
				
		}catch (NoSuchElementException e) {
			
		}
		
	}
	public void dailyDeals() {
		clickElement(By.linkText("Daily Deals"));
	}
	public void globalSearch(String search) {
		EnterText(By.xpath("//input[@name='search'][@class='search-field ']"),search);
	}
	public void globalSearchExcel(String ProductItemsearch) {
		EnterText(By.xpath("//input[@name='search'][@class='search-field ']"),ProductItemsearch);
	}
	
	public void searchButton() {
		clickElement(By.xpath("//button[@class='button search-btn search-icon']"));
		
	}
	public void checkProductSearch() {
		clickElement(By.xpath("//label[@class='checkbox grid-x align-middle  on']"));
	}
	public void checkProductFromSearch() {
		clickElement(By.xpath("//label[@class='checkbox grid-x align-middle ']"));
	}
	public void searchToo(String SearchProduct) {
		EnterText(By.xpath("//input[@id='_undefined'][@type='text']"),SearchProduct);
	}
	public void searchButtonToo() {
		clickElement(By.xpath("//div[lass='filter-search-icon filter-search-module_search-icon_qgJqk']"));
	}
	public String productNotFound() {
		return getElementText(By.xpath("//p[@class='filter-search-module_no-results_3zVd7']"));
	}
	public void productNotFoundTCs() {
			clickElement(By.xpath("//label[@class='checkbox grid-x align-middle ']"));
			if(driver.findElement(By.xpath("//p[@class='filter-search-module_no-results_3zVd7']")).isDisplayed()) {
				throw new SkipException("Test Case skipped");
				
				//return getElementText(By.xpath("//p[@class='filter-search-module_no-results_3zVd7']"));
			}else {
				clickElement(By.xpath("//label[@class='checkbox grid-x align-middle ']"));
			}
			
	}
	public void clearSearchToo() {
		clickElement(By.xpath("//div[@class='filter-clear-icon filter-search-module_clear-icon_3Plm_']"));
	}
	public String getItemsCount() {
		//driver.findElement(By.xpath("//*[@id=\"shopfront-app\"]/div[3]/div/div/div[1]/div[2]/div[2]/div"));
		//System.out.println("get number of items");
		return getElementText(By.xpath("//div[@class='search-count toolbar-module_search-count_P0ViI search-count-module_search-count_1oyVQ']"));
		
	}
	
	public void findFirstItem() {
		clickElement(By.xpath("//div[@class='product-card product-card-module_product-card_fdqa8']"));
	}
	public void secondAddToCart() {
		clickElement(By.xpath("//button[@class='button  expanded add-to-cart-button add-to-cart-button-module_add-to-cart-button_1a9gT']"));
	}
	public void itemSize() {
		clickElement(By.xpath("//div[@class='swiper-slide']"));
	}
	
	public void switchToAnotherWindow() {
		String parentWindowHandler = driver.getWindowHandle(); 
		// Store your parent window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles();
		// get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); 
		System.out.println("another window");
		// switch to popup window
		// perform operations on popup

		//driver.switchTo().window(parentWindowHandler); 
     }
	

	public void shopAllOptionsORaddToCart() {
		boolean shopAllOpts = driver.findElement(By.linkText("Shop All Options")).isDisplayed();
		//boolean addTocart = driver.findElement(By.xpath("//button[@class='button  expanded add-to-cart-button add-to-cart-button-module_add-to-cart-button_1a9gT ghost")).isDisplayed();
		if(shopAllOpts == true) {
			clickElement(By.linkText("Shop All Options"));
		}
		else {
			clickElement(By.xpath("//button[@class='button  expanded add-to-cart-button add-to-cart-button-module_add-to-cart-button_1a9gT ghost']"));
		}
		
	}
	public void addToCart2() {
		clickElement(By.linkText("Add to Cart"));
	}
	public String addedToCart() {
	
		return getElementText(By.xpath("//span[contains(text(),'Added to cart')]"));
	}
	public void goToCart() {
		clickElement(By.xpath("//button[@class='button checkout-now dark']"));
	}
	public void selectItemQuantity() {
		Select se = new Select(driver.findElement(By.xpath("//select[@id='cart-item_undefined']")));
		se.selectByIndex(2);
		System.out.println("item quantity selected");
	}
	
	public void selectItemQuantityExcel(int itemQuantity) {
		clickElement(By.xpath("//select[@id='cart-item_undefined']"));
		Select se = new Select(driver.findElement(By.xpath("//select[@id='cart-item_undefined']")));
		se.selectByIndex(itemQuantity);
	}
	public void shopAllOptions() {
		clickElement(By.linkText("Shop All Options"));
	}
	public void procceedToCheckout() {
		clickElement(By.linkText("Proceed to Checkout"));
	}
	
	public String itemAmount() {
		//driver.findElement(By.xpath(""));
		//System.out.println("amount of each item");
		return getElementText(By.xpath("//span[@class='currency plus currency-module_currency_29IIm']"));
		
	}
	public String totalAmountForSelectedItems() {
		//driver.findElement(By.xpath("//span[@class='currency plus currency-module_currency_29IIm']"));
		//System.out.println("amount of all items");
		//return getElementText(By.xpath("//*[contains(text(),'Cart Summary')]/..//span[contains(@class,'currency plus currency-module_currency_29IIm')]"));
		return getElementText(By.xpath("//p[@class='cart-summary-module_cart-summary-items-cost_2gFl4']"));
	}
	public void closeChildBrowserTab() {
		Set<String> handles = driver.getWindowHandles();
		//selenium will check how many windows are currently open, this will store the ID for both parent and child window
		Iterator<String> it = handles.iterator();
		//using the it object you can access the ID
		String parentWindowID = it.next();
		String childWindowID = it.next();
		driver.switchTo().window(childWindowID);
		driver.close();
		driver.switchTo().window(parentWindowID);
		System.out.println("back to parent window");
	}
	public String freeDeliveryMessage() {
		return getElementText(By.xpath("//p[contains(text(),'Spend')]"));
	}
	
	public void cleanup() {
		driver.close();
	}

}
