package mainPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Trivago {
	
	@Test
	public void trivago() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://www.trivago.com/");
		
		WebElement searchBox = driver.findElement(By.cssSelector("#input-auto-complete"));
		searchBox.sendKeys("Kol");
		
		WebElement city = driver.findElement(By.xpath("//div[@id='suggestion-list']//li[1]"));
		city.click();
		
		WebElement nextWeek = driver.findElement(By.xpath("//input[@value=\"nextWeekend\"]"));
		nextWeek.click();
		
		WebElement checkout = driver.findElement(By.xpath("//span[@data-testid='checkout-calendar-label']"));
		checkout.click();
		
		
		WebElement month = driver.findElement(By.xpath("//button[@class=\"cursor-auto font-bold\"]"));
		System.out.println(month.getText()); //April 2023
		
		String currentMonth = month.getText();
		String checkoutMonth = "December 2022";
		
		WebElement nextButton = driver.findElement(By.xpath("//button[@data-testid='calendar-button-next']//span"));
		
		while(!(currentMonth.equalsIgnoreCase(checkoutMonth))) {
			
		
		nextButton.click();
		currentMonth = month.getText();
		System.out.println(currentMonth);
		
			
		}
		
		WebElement checkoutDate = driver.findElement(By.xpath("//time[@datetime='2023-01-05']"));
		checkoutDate.click(); 
		
		//WebElement room = driver.findElement(By.xpath("//span[contains(text(),' Guests')]"));
		//room.click();
		
		WebElement adultIncrement = driver.findElement(By.xpath("//button[@data-testid='adults-amount-plus-button']"));
		adultIncrement.click();
		
		WebElement applyButton = driver.findElement(By.xpath("//span[text()='Apply']"));
		applyButton.click();
		
		Thread.sleep(40000);
		
		WebElement hotel = driver.findElement(By.xpath("//label[@data-title='Hotel']"));
		hotel.click();
		
		WebElement price = driver.findElement(By.xpath("//div[@data-testid='slider-handle-min' and @style='left: calc(0% - 1.2rem);' ]"));
		
		Actions action = new Actions(driver);
		
		action.dragAndDropBy(price, 60, 0).build().perform();
		
		price.click();
		
		

	}

}
