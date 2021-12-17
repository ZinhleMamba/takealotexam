package FrameworkClasses;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	

    
    // Declare the WebDriver
	
	public static WebDriver driver;
    
    //constructor of the base class
	
	public BasePage() {
		if(driver == null) {
			// Get parameter values
			
			String browser = getDataConfigProperties("browser");
			String systemUnderTest = getDataConfigProperties("systemUnderTest");
			String pdriverDir = getDataConfigProperties("driverdir");
			
			//check if parameter passed is chrome 
			
			if(browser.equalsIgnoreCase("chrome")) {
				//set path to chromedriver .exe
				
				System.setProperty("webdriver.chrome.driver", pdriverDir+"chromedriver.exe");
				
				//create instance of chrome
				driver= new ChromeDriver();
				driver.get(systemUnderTest);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			}
			//check parameter passed as fireFox
			else if(browser.equalsIgnoreCase("fireFox")) {
				//set path to gecko .exe
				
				System.setProperty("webdriver.gecko.driver", pdriverDir+"geckodriver.exe");
				
				//create instance of firefox
				driver= new FirefoxDriver();
				driver.get(systemUnderTest);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			}
			//check parameter passed as edge
			else if(browser.equalsIgnoreCase("Edge")) {
				//set path to geko .exe
				
				System.setProperty("webdriver.edge.driver", pdriverDir+"MicrosoftWebdriver.exe");
				
				//create instance of edge
				driver= new EdgeDriver();
				driver.get(systemUnderTest);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			}
			
			
		}
	}
    
    //Create a method to read the config
	
	public String getDataConfigProperties(String propertyName) {
		// properties setup
		
		Properties p = new Properties();
		InputStream is = null;
		
		try {
			is = new FileInputStream("config.properties");
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}
		try {
			p.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p.getProperty(propertyName);		
	}
    
    //create a method to Wait for Element
    
	public void waitForElement(int elementWait, By pLocator) {
		WebDriverWait wait = new WebDriverWait(driver,elementWait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pLocator));
		
	}
	
    //create a method to wait for the URL
	
	public void waitForUrl(int elementWait, String pLocator) {
		WebDriverWait wait = new WebDriverWait(driver,elementWait);
		wait.until(ExpectedConditions.urlContains(pLocator));
	}
	
    
    //create a method to Wait for Click
	
	public void waitForClick(int elementWait, By pLocator) {
		WebDriverWait wait = new WebDriverWait(driver,elementWait);
		wait.until(ExpectedConditions.elementToBeClickable(pLocator));
		
	}
    
    //create a method to get Element Text
	public String getElementText(By pLocator) {
		waitForElement(12,pLocator);
		String h1 = getElement(pLocator).getText();
		return h1;
		
	}
    
    //create a method to click Element
	
	public void clickElement(By pLocator) {
		waitForClick(10,pLocator);
		getElement(pLocator).click();
		
	}
    
    //create a method to get Element
	
	public WebElement getElement(By pLocator) {
		waitForClick(10,pLocator);
		return driver.findElement(pLocator);
		
	}

    
    //clean up (close the browser)
	
	public void cleanup() {
		driver.close();
	}
    
    //create a method to EnterText
	public void EnterText(By pLocator, String pText) {
		waitForClick(10,pLocator);
		driver.findElement(pLocator).sendKeys(pText);
		
	}
	
    
    //create a method to select the drop down
	public void selectDropDown(By pLocator, String pValue) {
		//create the instance of the drop down object
		Select sDropDown = new Select(getElement(pLocator));
		//populate the dropdown
		sDropDown.selectByVisibleText(pValue);
		
	}

}

