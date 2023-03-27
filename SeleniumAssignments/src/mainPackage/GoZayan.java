package mainPackage;

import static org.testng.Assert.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoZayan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://www.gozayaan.com/");

		WebElement signInButton = driver.findElement(By.cssSelector(".auth-action button"));
		WebElement searchButton = driver.findElement(By.cssSelector(".search-btn"));

		boolean signInButtonExists = signInButton.isDisplayed();
		boolean searchButtonExists = searchButton.isDisplayed();

		assertTrue(signInButtonExists, "Sign In button doesn't exist");
		assertTrue(searchButtonExists, "Search button doesn't exist");

		WebElement oneWayRadioButton = driver.findElement(By.xpath("//span[text()='Round Way']"));
		oneWayRadioButton.click();

		WebElement retunDate = driver.findElement(By.xpath("//span[text()='Return Date']"));
		String returnDateText = retunDate.getText();

		assertEquals(returnDateText, "RETURN DATE");

		WebElement fromOption = driver.findElement(By.xpath("//span[text()='From']"));
		fromOption.click();

		WebElement fromSearchTextBox= driver.findElement(By.cssSelector(".from input"));
		fromSearchTextBox.sendKeys("CXB");

		WebElement departureAirport = driver.findElement(By.cssSelector(".from .airport"));
		departureAirport.click();

		WebElement toSearchTextBox= driver.findElement(By.cssSelector(".to input"));
		toSearchTextBox.sendKeys("DAC");

		WebElement returnAirport = driver.findElement(By.cssSelector(".to .airport"));
		returnAirport.click();

		WebElement departureMonthText = driver.findElement(By.xpath("//div[@class='calendar right']/div[@class='header']"));
		String textOfDepartureMonth = departureMonthText.getText();

		assertEquals(textOfDepartureMonth, "November, 2022");

		WebElement departureDate = driver.findElement(By.xpath("//div[@class='calendar right']/div[@class='month']/span[7]"));
		departureDate.click();

		WebElement goToNext = driver.findElement(By.xpath("//div[@class='calendar right']//span[@class='navigate-month next']"));

		for (int i = 0; i < 3; i++) {
			goToNext.click();
		}

		WebElement returnMonthText = driver.findElement(By.xpath("//div[@class='calendar right']/div[@class='header']"));
		String textOfReturnMonth = returnMonthText.getText();

		assertEquals(textOfReturnMonth, "February, 2023");

		WebElement returnDate = driver.findElement(By.xpath("//div[@class='calendar right']/div[@class='month']/span[9]"));
		returnDate.click();

		WebElement travelerOption = driver.findElement(By.cssSelector(".traveler"));
		travelerOption.click();

		WebElement incrementForAdults = driver.findElement(By.xpath("//div[@class='adults']//button[2]"));
		incrementForAdults.click();

		WebElement businessRadioButton = driver.findElement(By.xpath("//span[text()='Business']"));
		businessRadioButton.click();

		WebElement doneButton = driver.findElement(By.xpath("//button[text()='Done']"));
		doneButton.click();

		searchButton.click();

		WebElement cheapestOption = driver.findElement(By.xpath("//span[text()='Cheapest']"));
		WebElement fastestOption = driver.findElement(By.xpath("//span[text()='Fastest']"));

		boolean isCheapestOptionExists = cheapestOption.isDisplayed();
		boolean isFastestOptionExists = fastestOption.isDisplayed();

		assertTrue(isCheapestOptionExists, "Cheapest Option doesn't exist");
		assertTrue(isFastestOptionExists, "Fastest Option doesn't exist");

		fastestOption.click();

		WebElement selectButton = driver.findElement(By.cssSelector(".flight-airlines-wrapper button"));
		selectButton.click();

		WebElement reviewYourBookingText = driver.findElement(By.xpath("//*[text()='Review Your Booking']"));
		String textOfReviewYourBooking = reviewYourBookingText.getText();
		System.out.println(textOfReviewYourBooking);

		// When we use testng, first argument is the ACTUAL and second argument is the EXPECTED
		// When we use JUnit, first argument is the EXPECTED and second argument is the ACTUAL
		assertEquals(textOfReviewYourBooking, "Review Your Booking", "Review Your Booking text doesn't exist");

		WebElement selectTitleOption = driver.findElement(By.xpath("//div[@class='collapse show']//span[text()='MR.']"));
		selectTitleOption.click();

		WebElement firstName1TextBox = driver.findElement(By.xpath("//input[@id='first-name-0']"));
		firstName1TextBox.sendKeys("Mohammad");

		WebElement lastName1TextBox = driver.findElement(By.xpath("//input[@id='last-name-0']"));
		lastName1TextBox.sendKeys("Karim");

		WebElement email1TextBox = driver.findElement(By.xpath("//input[@id='email-0']"));
		email1TextBox.sendKeys("karim@gmail.com");

		WebElement phone1TextBox = driver.findElement(By.xpath("//input[@id='phone-number-0']"));
		phone1TextBox.sendKeys("1728803979");

		WebElement travelerListCheckBox = driver.findElement(By.xpath("//div[@class='collapse show']//label[contains(text(),'my traveler')]"));
		travelerListCheckBox.click();

		WebDriverWait explicit = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement passenger1Text = explicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\'toggle-icon flat-icon\' and @xpath=\'1\']\r\n"
				+ "")));

		Actions action = new Actions(driver);
		action.click(passenger1Text);

		//WebElement passenger1Text = driver.findElement(By.xpath("//div[1]/span/div[1]/div/span/div/div[2]"));
		//passenger1Text.click();

		//		WebElement passenger2Text = driver.findElement(By.xpath("//div[@class='flight-booking-container']//div[1]/span/div[1]/div//div[@class='passenger-header']"));
		//		passenger2Text.click();

		selectTitleOption.click();

		WebElement firstName2TextBox = driver.findElement(By.cssSelector("#first-name-1"));
		firstName2TextBox.sendKeys("Mohammad");

		WebElement lastName2TextBox = driver.findElement(By.cssSelector("#last-name-1"));
		lastName2TextBox.sendKeys("Riyad");

		WebElement email2TextBox = driver.findElement(By.cssSelector("#email-1"));
		email2TextBox.sendKeys("riyad@gmail.com");

		WebElement phone2TextBox = driver.findElement(By.cssSelector("#phone-number-1"));
		phone2TextBox.sendKeys("01684550302");

		travelerListCheckBox.click();

		WebElement continueButton = driver.findElement(By.xpath("//*[text()='Continue']"));
		continueButton.click();


	}

}
