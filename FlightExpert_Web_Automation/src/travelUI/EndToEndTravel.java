package travelUI;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EndToEndTravel {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		actions = new Actions(driver);
	}

	@BeforeMethod
	public void navigateToBaseURL() {
		String baseURL = "https://flightexpert.com/?lorigin=Dhaka&ldestination=Saidpur&itinerary=DAC-SPD&ref=flightlpage&https://www.flightexpert.com/=&Iorigin=&Idestination=&itinerary=DAC-SPD&ref=flightlpage&gad_source=1&gclid=CjwKCAjwko21BhAPEiwAwfaQCOY249vJ_7wcz_KImfsM5S1mu2QU9EJVfL83E75Iro-iN6JSI53QiBoC0R4QAvD_BwE";
		driver.get(baseURL);
	}

	@Test
	public void testFlightSearch() throws InterruptedException {
		selectAirport("div[class='mb-3 mb-xl-0'] div:nth-child(1)", "DHA", "Hazrat Shahjalal International Airport");
		selectAirport(".w-100.ps-xl-3", "CHI", "Shah Amanat International");

		selectDate("2024", "October", "23");
		verifyReturnDateDisabled();

		adjustPassengerCount(3);
		selectBookingClass("#business");
		clickDoneButton();
		submitSearch();
	}

	private void selectAirport(String selector, String inputText, String airportName) {
		WebElement source = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
		source.click();

		WebElement sourceInput = driver
				.findElement(By.cssSelector("input[placeholder='Type for the airport name or airport code']"));
		sourceInput.sendKeys(inputText);

		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='search-options']//p[contains(text(),'" + airportName + "')]")));
		option.click();
	}

	private void selectDate(String year, String month, String day) {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".border.calendar-modal"))).click();

		selectFromDropdown(By.xpath("//span[contains(@class,'rdrYearPicker')]//select"), year);
		selectFromDropdown(By.xpath("//span[contains(@class,'rdrMonthPicker')]//select"), month);

		List<WebElement> dates = driver.findElements(By.cssSelector(".rdrDays .rdrDayNumber"));
		for (WebElement date : dates) {
			if (date.getText().equals(day)) {
				actions.moveToElement(date).click().perform();
				break;
			}
		}
	}

	private void selectFromDropdown(By locator, String value) {
		WebElement dropdown = driver.findElement(locator);
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
	}

	private void verifyReturnDateDisabled() {
		driver.findElement(By.id("oneway")).click();
		WebElement returnDateMessage = driver
				.findElement(By.xpath("//small[contains(@class,'mt-0 text-muted fs-12')]"));
		boolean isDisabled = returnDateMessage.getAttribute("style").contains("0.5");

		Assert.assertTrue(isDisabled, "Return date is enabled, but it should be disabled.");
		System.out.println(isDisabled ? "It's disabled" : "It's enabled");
	}

	private void adjustPassengerCount(int numberOfAdults) {
		WebElement searchInputButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[contains(@class,'search-input-button mb-2')])[1]")));
		actions.moveToElement(searchInputButton).click().perform();

		WebElement inputElement = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[contains(@value,'+')])[1]")));
		for (int i = 1; i < numberOfAdults; i++) {
			actions.moveToElement(inputElement).click().perform();
		}
	}

	private void selectBookingClass(String classSelector) {
		WebElement classRadioButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector(classSelector)));
		actions.moveToElement(classRadioButton).click().perform();
	}

	private void clickDoneButton() {
		WebElement doneButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='done-btn']")));
		actions.moveToElement(doneButton).click().perform();
	}

	private void submitSearch() {
		WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#submit_btn")));
		submitButton.click();
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
