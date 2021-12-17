package testtakealot;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;


import pageObjectstakealot.Takealot;

public class TakealotTest extends Takealot{
	Takealot ta = new Takealot();
	ReadTheData rd = new ReadTheData();
//	@BeforeTest
//	
//	public void GIVEN_TakealotLandingPage_WHEN_CookiesAndCovidClosed_THENDailyDealsIsClickable() {
//		//GIVEN
//		ta.goToTakealotPage();
//		//WHEN
//		ta.covidInfoClose();
//		ta.cookieNotificationGotIt();
//		//THEN
//		//ta.dailyDeals();
//	}
	
		
	@Test
	public void GIVEN_NewWindowIsOpened_WHEN_ItemHasBeenSearched_THEN_VerifyAvailabilityOfItem() throws InterruptedException {
		//GIVEN
		ta.goToTakealotPage();
		ta.cookieNotificationGotIt();
		String[] myProducts = {"nokia", "Berlinger Haus","apple"};
		ta.globalSearch("samsung");
		ta.searchButton();
		for(int i=0;i<myProducts.length;i++) {
		ta.searchToo(myProducts[i]);
		
		//ta.productNotFound();
		//ta.productNotFoundTCs();
		
		if(ta.productNotFound().contains("No results found ")) {
			//ta.clearSearchToo();
			throw new SkipException("Test Case skipped");
			
		}else
		{
			System.out.println("Product Data found counting to :"+ta.getItemsCount());
			ta.clearSearchToo();
			}
			
				
		}
		ta.cleanup();
	}
		@Test		
		
		public void GIVEN_ProductItemIsSearched_WHEN_ItemIsAvailable_THEN_VerifyAmountOfItem() {
			//GIVEN
			ta.goToTakealotPage();
			//ta.cookieNotificationGotIt();
			ta.globalSearch("Stationary");
			ta.searchButton();
			ta.searchToo("Stationary");
			ta.checkProductFromSearch();
			//ta.searchButtonToo();
			
			ta.checkProductSearch();
			ta.getItemsCount();
			System.out.println(ta.getItemsCount());
			String myvalue = ta.getItemsCount().substring(0,1);
			System.out.println(myvalue);
			int value = Integer.parseInt(myvalue);
			if(value>=1) {
				System.out.println("Products are 1 or more dispalyed");
			}else {
				throw new SkipException("Test Case skipped");
			}
			
			
			
			//WHEN
			ta.findFirstItem();
			//THEN
			ta.shopAllOptions();
			//ta.shopAllOptionsORaddToCart();
			ta.switchToAnotherWindow();
			ta.itemAmount();
			
			String  expectedItemAmount= "item price is: R 168";
			String actualItemAmount = "item price is: "+ta.itemAmount();
			Reporter.log("actual ------>"+ actualItemAmount);
			Reporter.log("expected ------>"+ expectedItemAmount);
			
			Assert.assertEquals(expectedItemAmount, actualItemAmount);
			ta.cleanup();
			
		}
		
	
	@Test
	public void GIVEN_ProductItemIsSearched_WHEN_NumberOfItemsIsSelected_THEN_VerifyAmountOfTotalItems() throws InterruptedException {
		//GIVEN
				ta.goToTakealotPage();
				//ta.cookieNotificationGotIt();
				ta.globalSearch("bosch");
				ta.searchButton();
				ta.searchToo("bosch");
				ta.checkProductFromSearch();
				//ta.searchButtonToo();
				
				ta.checkProductSearch();
				ta.getItemsCount();
				System.out.println(ta.getItemsCount());
				String myvalue = ta.getItemsCount().substring(0,1);
				System.out.println(myvalue);
				int value = Integer.parseInt(myvalue);
				if(value>=1) {
					System.out.println("Products are 1 or more dispalyed");
				}else {
					throw new SkipException("Test Case skipped");
				}
				
				
				
		//WHEN
				ta.findFirstItem();
				//THEN
				ta.shopAllOptions();
				//ta.shopAllOptionsORaddToCart();
				ta.switchToAnotherWindow();
				ta.itemAmount();
		//THEN
				String myItemcut = ta.itemAmount().substring(2);
				myItemcut = myItemcut.replaceAll(",",".");
				double myItemamount = Double.parseDouble(myItemcut);
				System.out.println(myItemamount);
				ta.addToCart2();
				ta.addedToCart();
				System.out.println(ta.addedToCart());
				ta.goToCart();
				ta.selectItemQuantity();
				Thread.sleep(2000);
				String TotalforItems = ta.totalAmountForSelectedItems();
				TotalforItems = TotalforItems.replaceAll(",", ".");
				String TotItemscut = TotalforItems.substring(2);
				
				String actualMessageTotalItems = "total amount for all items is: "+ TotItemscut;
				String expectedMessageTotalItems = "total amount for all items is: " + myItemamount*2;
				Reporter.log("actual ------>"+ actualMessageTotalItems);
				Reporter.log("expected ------>"+ expectedMessageTotalItems);
				Assert.assertEquals(actualMessageTotalItems, expectedMessageTotalItems);
				System.out.println("total amount value is : "+ ta.totalAmountForSelectedItems());
				ta.cleanup();
				
		
	}
	@Test
	public void GIVEN_ProductItemIsSearched_WHEN_TotalAmountOfItemsIsBelow450_THEN_VerifyFreeShippingMessageIsDisplayed() throws InterruptedException {
		//GIVEN
				ta.goToTakealotPage();
				//ta.cookieNotificationGotIt();
				ta.globalSearch("glasses");
				ta.searchButton();
				ta.searchToo("glasses");
				ta.checkProductFromSearch();
				//ta.searchButtonToo();
				
				ta.checkProductSearch();
					
				
		//WHEN
				ta.findFirstItem();
				//THEN
				ta.shopAllOptions();
				//ta.shopAllOptionsORaddToCart();
				ta.switchToAnotherWindow();
				ta.itemAmount();
		//THEN
				
				ta.addToCart2();
				ta.addedToCart();
				System.out.println(ta.addedToCart());
				ta.goToCart();
				ta.selectItemQuantity();
				
			
				Thread.sleep(2000);
				System.out.println(ta.totalAmountForSelectedItems());
				
				String myTotalAmnt = ta.totalAmountForSelectedItems().substring(2);
				myTotalAmnt = myTotalAmnt.replaceAll(",",".");
				double myTotalamount = Double.parseDouble(myTotalAmnt);
				System.out.println(myTotalamount);
				if(myTotalamount < 450.0) {
				String DeliveryMesage = ta.freeDeliveryMessage();
				String myDeliveryMsg = "Spend R450 or more to get FREE DELIVERY. T&Cs apply";
				System.out.println(DeliveryMesage);
				
				String actualDeliveryMesage = "total delivery message: "+ DeliveryMesage;
				String expectedDeliveryMesage = "total delivery message: "+ myDeliveryMsg;
				Reporter.log("actual ------>"+ actualDeliveryMesage);
				Reporter.log("expected ------>"+ expectedDeliveryMesage);
				Assert.assertEquals(actualDeliveryMesage, expectedDeliveryMesage);
				}else {
					System.out.println("Total amount is greater than 450");
				}
				
				ta.cleanup();
				
		
	}
	

}
