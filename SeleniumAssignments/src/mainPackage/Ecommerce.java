package mainPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Ecommerce {
	
	public static void main (String [] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Resources\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		//Task01
		
		driver.get("https://www.amazon.com/"); //Navigate to amazon
		driver.findElement(By.id("nav-logo-sprites")); //Logo by id
		driver.findElement(By.name("field-keywords")); //Search box by name
		driver.findElement(By.className("nav-input")); //Search box by class name
		driver.findElement(By.tagName("input"));
		
		//Task02
		
		driver.get("https://www.daraz.com.bd/"); //Navigate to Daraz
		driver.findElement(By.linkText("Sell on Daraz")); //Locate Sell on Daraz hyperlink by LinkTest locator
		driver.findElement(By.partialLinkText("SAVE ")); //Locate SAVE MORE ON APP hyperlink by Partial LinkTest locator
		driver.findElement(By.className("cart-icon")); //Locate shopping cart by Class Name locator
		driver.findElement(By.id("q")); //Locator search box by id  locator
		driver.findElement(By.name("q"));//Locator search box by  name locator 
		
		driver.close();
	}

}
