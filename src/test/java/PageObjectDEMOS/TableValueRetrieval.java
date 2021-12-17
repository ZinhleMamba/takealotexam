package PageObjectDEMOS;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import FrameworkClasses.BasePage;

public class TableValueRetrieval extends BasePage {
	public void goToTableDemo2() {
		driver.get("http://demo.guru99.com/test/web-table-element.php");
	}
	//http://demo.guru99.com/test/web-table-element.php
		
	    //print the number of rows and columns
	
	   // print the value of row 4 column 4 --- 1 value 
	
	public void tableDemo() {
		goToTableDemo2();
		//locate table
		WebElement mytable1 = getElement(By.xpath("//tbody"));
		List<WebElement> rows_table = mytable1.findElements(By.tagName("tr"));
		int rows_count = rows_table.size();
		
		System.out.println("the number of rows: "+rows_count);
		List<WebElement> cols_table = rows_table.get(1).findElements(By.tagName("td"));
		int cols_count = cols_table.size();
		System.out.println("the number of columns: " +cols_count);
				
		WebElement myvalue = getElement(By.xpath("//tbody/tr[4]/td[4]"));
		String value1 = myvalue.getText();
		System.out.println("The 4th row 4th column has: "+value1);
	}
	

}
