package mainPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PracticeImportant {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Navigate
		driver.get("https://trytestingthis.netlify.app/");
		
		driver.findElement(By.cssSelector("#fname")).sendKeys("Md Reyad");
		driver.findElement(By.cssSelector("#lname")).sendKeys("Morshed");
		
		driver.findElement(By.cssSelector("#male")).click();
		
		WebElement option = driver.findElement(By.xpath("//select[@id='option']"));
		Select selectOption = new Select (option);
		selectOption.selectByVisibleText("Option 2");
		
		driver.findElement(By.xpath("//input[@type='checkbox' and @value='Option 1']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox' and @value='Option 3']")).click();
		
		driver.findElement(By.xpath("//input[@list='datalists']")).sendKeys("Mint");
		
		driver.findElement(By.cssSelector("#favcolor")).click();
		
		WebElement date = driver.findElement(By.cssSelector("#day"));
		date.click();
		
		//scroll up
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		
		//Upload image
		
		WebElement image = driver.findElement(By.cssSelector("#myfile"));
		image.sendKeys("C:\\Users\\ASUS\\OneDrive\\Pictures\\reyad.jpg");
		//Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("#quantity")).sendKeys("9");
		
		//slider
		 Actions action = new Actions(driver);
		 WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
		 
		 Rectangle res = slider.getRect();
		 System.out.println(res.getX());
		 System.out.println(res.getY());
		 action.dragAndDropBy(slider, 23, 0).perform();


	}

}
