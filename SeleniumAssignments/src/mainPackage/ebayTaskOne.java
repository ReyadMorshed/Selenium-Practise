package mainPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/*Test for ebay

1. Login to ebay
2. Click on categories
3. Select cell phone
4. Write samsung phone on searchbar
5. Hover on Myebay
6. Click on summary
7. Click on Continue with google button*/

public class ebayTaskOne {
	
	public static void main (String [] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Resources\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		
		//Navigate to ebay
		driver.get("https://www.ebay.com/");
		
		//Select Cell phone category
		WebElement category = driver.findElement(By.cssSelector("#gh-cat"));
		Select selectPhone = new Select(category);
		selectPhone.selectByVisibleText("Cell Phones & Accessories");
		
		//Search for Samsung Mobile
		WebElement Searchbox = driver.findElement(By.cssSelector(".gh-tb"));
		Searchbox.sendKeys("Samsung phone");
		WebElement Search = driver.findElement(By.cssSelector("#gh-btn"));
		Search.click();
		
		//Hover on Myebay
		Actions action = new Actions(driver);
		WebElement myEbay = driver.findElement(By.cssSelector("a[title='My eBay']"));
		action.moveToElement(myEbay).build().perform();
		
		//Click on summary and google login
		WebElement summary = driver.findElement(By.cssSelector(".gh-submenu a[href$='summary']"));
		summary.click();
		WebElement googleLogin = driver.findElement(By.cssSelector("#signin_ggl_btn"));
		googleLogin.click();
		
		
		
		
		
		
		
		
		
	}

}
