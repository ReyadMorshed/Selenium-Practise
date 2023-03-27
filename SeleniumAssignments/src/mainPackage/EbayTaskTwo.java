package mainPackage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.commons.io.FileUtils;

public class EbayTaskTwo {
	
	public static void takeSnapshot (WebDriver driver, String path) throws IOException {
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileUtils.copyFile(source, destination);
		
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Resources\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		//Navigate to ebay
		driver.get("https://www.ebay.com/");

		WebElement searchbox = driver.findElement(By.cssSelector("#gh-ac"));
		boolean searchboxVisible = searchbox.isDisplayed();

		Assert.assertTrue(searchboxVisible);
		System.out.println("Is searchbox displayed? " + searchboxVisible);
		searchbox.sendKeys("mobile phones"); 



		WebElement categories = driver.findElement(By.xpath("//select[@id='gh-cat']"));
		boolean categoriesVisible = searchbox.isDisplayed();
		System.out.println("Is category displayed? " + categoriesVisible);

		assertTrue(categoriesVisible);



		List <WebElement> subcategory = driver.findElements(By.cssSelector("#gh-cat option"));

		int totalSubcategory = subcategory.size();

		System.out.println("Total number of subcategory is " + totalSubcategory);


		Select selectCategory = new Select(categories);
		selectCategory.selectByVisibleText("Cell Phones & Accessories");

		//Verifying Category

		WebElement verifyCategory = selectCategory.getFirstSelectedOption();
		assertEquals(verifyCategory.getText(), "Cell Phones & Accessories");
		System.out.println("selected category is " + verifyCategory.getText());

		WebElement search = driver.findElement(By.cssSelector("#gh-btn"));

		boolean searchvisible = search.isDisplayed();
		assertTrue(searchvisible);

		System.out.println("Is search icon visible? " + searchvisible);

		search.click();

		WebElement result = driver.findElement(By.xpath("//div[@class=\'s-answer-region s-answer-region-center-top\']//span[@class=\'BOLD\'] [1]"));

		boolean resultVisible = result.isDisplayed();
		assertTrue(resultVisible);

		System.out.println("Is result visible? " + resultVisible);

		System.out.println("Search result is " + result.getText());

		WebElement shipping = driver.findElement(By.xpath("//button[@class=\'x-flyout__button\']"));


		boolean shippingVisible = shipping.isDisplayed();
		assertTrue(shippingVisible);

		System.out.println("Is shipping visible? " + shippingVisible);

		shipping.click();

		WebElement shippingCountry = driver.findElement(By.xpath("//select[@id='s0-52-12-5-4[0]-42-0-7-13-select']"));

		Select selectCountry = new Select(shippingCountry);
		selectCountry.selectByVisibleText("United States - USA");

		//verifying selected option
		WebElement verifyCountry = selectCountry.getFirstSelectedOption();
		String countryName = verifyCountry.getText();
		assertEquals(countryName, "United States - USA");
		System.out.println("Selected Country is " + countryName);

		List <WebElement> countryList = driver.findElements(By.xpath("//select[@id='s0-52-12-5-4[0]-42-0-7-13-select']//option"));

		int totalCountry = countryList.size();

		System.out.println("Total Country is " + totalCountry);

		WebElement zipcode = driver.findElement(By.xpath("//span[@class=\'textbox\']//input"));

		boolean zipcodeVisible = zipcode.isDisplayed();
		assertTrue(zipcodeVisible);

		System.out.println("Is zipcode visible? " + zipcodeVisible);

		zipcode.sendKeys("10009");

		WebElement goButton = driver.findElement(By.xpath("//input[@value=\'Go\']"));

		boolean goButtonVisible = goButton.isDisplayed();
		assertTrue(goButtonVisible);

		System.out.println("Is shipping visible? " + goButtonVisible);

		goButton.click();
		
		
		//List<WebElement> products = driver.findElements(By.xpath("//li[@class='s-item s-item__pl-on-bottom s-item--watch-at-corner']"));
		int count = 1;
		List<WebElement> products = driver.findElements(By.xpath("//ul[@class=\"srp-results srp-list clearfix\"]//div[@class=\"s-item__wrapper clearfix\"]"));

		System.out.println("Total Product = " + products.size());
		for(WebElement product : products) {
			
			Thread.sleep(3000);
			
			
			//WebElement title = product.findElement(By.xpath(".//div[@class='s-item__title']/span"));
			////div[@class='s-item__title']/span/span
			try {
				WebElement title = product.findElement(By.xpath(".//a[@class='s-item__link']//span[@aria-level='3'] or .//div[@class='s-item__title']/span/span"));
				String titleText = title.getText();
				System.out.println("Laptop ["+ count+"]" + titleText);
			} catch (Exception e) {
				
				System.out.println("title not found");
				//D:\Automation\Screenshot
				takeSnapshot(driver, "D:\\Automation\\Screenshot\\title" + count + ".png" );
			}
			
			count++;
			
		}

	}

}
