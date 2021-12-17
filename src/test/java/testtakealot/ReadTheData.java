package testtakealot;
import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FrameworkClasses.ReadExcel;
import pageObjectstakealot.Takealot;

public class ReadTheData {
	
		Takealot ta = new Takealot();
		ReadExcel rExcel = new ReadExcel();
		@BeforeTest
		
		public void GIVEN_TakealotLandingPage_WHEN_CookiesAndCovidClosed_THENDisappeared() {
			//GIVEN
			ta.goToTakealotPage();
			//WHEN
			ta.covidInfoClose();
			ta.cookieNotificationGotIt();
			
		}
		
		@Test(dataProvider = "getDataFromExcel")
		
		public void ReadTakealotProducts(String ProductItemsearch, String itemQuantity) throws InterruptedException {
			//GIVEN
			ta.goToTakealotPage();
		
			//ta.cookieNotificationGotIt();
			ta.globalSearchExcel(ProductItemsearch);
			
			ta.searchButton();
			//ta.searchToo(ProductItemsearch);
			//ta.checkProductFromSearch();
			//WHEN
			
			ta.findFirstItem();
			//ta.shopAllOptions();
			
			ta.addToCart2();
			ta.switchToAnotherWindow();
			//THEN
			ta.itemAmount();
			double myItemamount = Double.parseDouble(ta.itemAmount());
			System.out.println(myItemamount);
			Thread.sleep(2000);
			ta.secondAddToCart();
			ta.addedToCart();
			ta.goToCart();
			
			int itemQ = Integer.parseInt(itemQuantity);
			System.out.println(itemQ);
			ta.selectItemQuantityExcel(itemQ);
			
			Thread.sleep(2000);
			ta.totalAmountForSelectedItems();
			System.out.println(ta.totalAmountForSelectedItems());
			
			String myTotalAmnt = ta.totalAmountForSelectedItems().substring(2);
			
			String actualmyTotalAmnt = "total amount for all items is: "+ myTotalAmnt;
			String expectedmyTotalAmnt = "total amount for all items is: " + myItemamount*itemQ;
			Reporter.log("actual ------>"+ actualmyTotalAmnt);
			Reporter.log("expected ------>"+ expectedmyTotalAmnt);
			Assert.assertEquals(actualmyTotalAmnt, expectedmyTotalAmnt);
			System.out.println("total amount value is : "+ ta.totalAmountForSelectedItems());
			ta.closeChildBrowserTab();
			
			System.out.println("The get Data Results from Excel");
			System.out.println(ProductItemsearch +" "+itemQuantity);
			ta.closeChildBrowserTab();
			//ta.cleanup();
		}
		
		@Test(dataProvider = "getDataFromExcel")
		public  void ReadDataFromExcel(String ProductItemsearch, String itemQuantity) {
			System.out.println("product name is "+ProductItemsearch);
			System.out.println("the quantity is" + itemQuantity);
			
		}
		
		@DataProvider
		
		public Object [][] getDataFromExcel() throws IOException{
			String excelDirectory = rExcel.getDataConfigProperties("excelDataDir");
			Object[][] arrayObj = rExcel.getExcelData(excelDirectory+"ExcelData.xlsx","Sheet1");
			
			return arrayObj;
		}

	

}
