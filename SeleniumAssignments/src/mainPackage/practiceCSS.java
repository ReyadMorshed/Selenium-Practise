package mainPackage;

import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
public class practiceCSS {

	public static void main (String [] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Resources\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		//WebDriverWait wait = new WebDriverWait(WebDriverRefrence,TimeOut);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.com/");
		
		
		
		WebElement searchbox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		searchbox.sendKeys("mobile phone"); 
		
		WebElement search = driver.findElement(By.cssSelector("#nav-search-submit-button"));
		search.click();
		
		/*WebElement seeMore = driver.findElement(By.cssSelector("a[aria-label=\"See more, Featured Brands\"] .a-expander-prompt"));
		seeMore.click();*/
		
		
		WebElement brand =  driver.findElement(By.xpath("//span[@class='a-size-base a-color-base'][text() = 'SAMSUNG']"));
		brand.click();
		
		/*WebElement price = driver.findElement(By.xpath("//span[text()='$50 to $100']"));
		price.click();*/
		
		WebElement minValue = driver.findElement(By.cssSelector("#low-price"));
		minValue.sendKeys("60");
		
		WebElement maxValue = driver.findElement(By.cssSelector("input[id='high-price']"));
		maxValue.sendKeys("90");
		
		WebElement valueSearch = driver.findElement(By.cssSelector("[class='a-button-input']"));
		valueSearch.click();
		

	
		
		
		
		//driver.close();
	}

}
