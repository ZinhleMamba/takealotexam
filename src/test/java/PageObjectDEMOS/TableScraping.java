package PageObjectDEMOS;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import FrameworkClasses.BasePage;

public class TableScraping extends BasePage {
	public void goToTablesDemo() {
		driver.get("http://demo.guru99.com/test/table.html");
	}
	

	
	public void tablesDemo() {
		goToTablesDemo();
		//To locate table
		WebElement mytable = getElement(By.xpath("//tbody"));
		//To locate rows of table
		List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
		//To calculate number of rows in a table
		int rows_count = rows_table.size();
		//loop will execute till last row in a table
		for(int row=0;row<rows_count;row++) {
			//To Locate columns(cells) of that specific row
			List<WebElement> columns_row = rows_table.get(row).findElements(By.tagName("td"));
			//To calculate number of columns(cells) in that specific row
			int columns_count = columns_row.size();
			System.out.println("Number of cells in  row"+row+"are"+columns_count);
			//Loop will execute till the last cell of that specific row
			for(int column=0;column<columns_count;column++) {
				//to retrieve text from that specific cell
				String celltext = columns_row.get(column).getText();
				System.out.println("Cell Value of row number"+row+"and column number"+column+"is"+celltext);
				
				
			}
			
		}
	}

}

