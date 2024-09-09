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

public class EndtoEndTravelUI {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions actions = new Actions(driver);
		
		String baseURL = "https://flightexpert.com/?lorigin=Dhaka&ldestination=Saidpur&itinerary=DAC-SPD&ref=flightlpage&https://www.flightexpert.com/=&Iorigin=&Idestination=&itinerary=DAC-SPD&ref=flightlpage&gad_source=1&gclid=CjwKCAjwko21BhAPEiwAwfaQCOY249vJ_7wcz_KImfsM5S1mu2QU9EJVfL83E75Iro-iN6JSI53QiBoC0R4QAvD_BwE";

		driver.get(baseURL);				

		// Select Source
		 WebElement source = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='mb-3 mb-xl-0'] div:nth-child(1)")));
	     source.click();
	     
	     WebElement sourceInput = driver.findElement(By.cssSelector("input[placeholder='Type for the airport name or airport code']"));
	     sourceInput.sendKeys("DHA");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='search-options']")));

		List<WebElement> options = driver.findElements(By.cssSelector("div[class='search-options'] div:nth-child(2) p:nth-child(2)"));

		for (WebElement option : options) {
			if (option.getText().contains("Hazrat Shahjalal International Airport")) {
				option.click();
				break;
			}
		}

		// Select Destination using Java Stream

        WebElement destination = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".w-100.ps-xl-3")));
        destination.click();
        WebElement destinationInput = driver.findElement(By.cssSelector("input[placeholder='Type for the airport name or airport code']"));
        destinationInput.sendKeys("CHI");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='search-options']")));
		
		List<WebElement> options1 = driver
				.findElements(By.cssSelector("div[class='search-options'] div:nth-child(2) p:nth-child(2)"));

		for (WebElement option : options1) {
			if (option.getText().contains("Shah Amanat International")) {
				option.click();
				break;
			}
		}

		// Select Date Year Month

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".border.calendar-modal")));

		WebElement yearDropdown = driver.findElement(By.xpath("//span[contains(@class,'rdrYearPicker')]//select"));
		Select yearSelect = new Select(yearDropdown);
		yearSelect.selectByVisibleText("2024");

		WebElement monthDropdown = driver.findElement(By.xpath("//span[contains(@class,'rdrMonthPicker')]//select"));
		Select monthSelect = new Select(monthDropdown);
		monthSelect.selectByVisibleText("October");

		List<WebElement> dates = driver.findElements(By.cssSelector(".rdrDays .rdrDayNumber"));
		int count = dates.size();

		for (int i = 0; i < count; i++) {
			String text = dates.get(i).getText();
			if (text.equalsIgnoreCase("23")) {
				Thread.sleep(2000);
				actions.moveToElement(dates.get(i)).click().perform();
				break;
			}
		}

		// Get return date disable

        driver.findElement(By.id("oneway")).click();
        WebElement returnDateMessage = driver.findElement(By.xpath("//small[contains(@class,'mt-0 text-muted fs-12')]"));
        if (returnDateMessage.getAttribute("style").contains("0.5")) {
            System.out.println("It's disabled");
            Assert.assertTrue(true);
        } else {
            System.out.println("It's enabled");
            Assert.assertTrue(false);
        }


		// Get number of passengers

		WebElement searchInputButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'search-input-button mb-2')])[1]")));
		actions.moveToElement(searchInputButton).click().perform();

		WebElement inputElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[contains(@value,'+')])[1]")));

		for (int i = 1; i < 3; i++) {
			actions.moveToElement(inputElement).click().perform();
		}
		
		// Radio-button Selection

        WebElement firstclassRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#business")));
		actions.moveToElement(firstclassRadioButton).click().perform();

		// Done Button
		
		WebElement doneButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='done-btn']")));
		actions.moveToElement(doneButton).click().perform();
		

        // Search for the flight
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#submit_btn")));
        submitButton.click();

	}
}
