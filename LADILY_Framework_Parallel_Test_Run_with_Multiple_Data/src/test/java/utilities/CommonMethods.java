package utilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.Faker;

import drivers.BaseDriver;
import drivers.PageDriver;



public class CommonMethods extends BaseDriver{
	
	/************************
	 * Get Current Page URL * 
	 ************************
	 */

	public String currentPageUrl() {
		return PageDriver.getCurrentDriver().getCurrentUrl();
	}


	/**************************
	 * Get Current Page Title * 
	 **************************
	 */

	public String getTitle() {
		return PageDriver.getCurrentDriver().getTitle();
	}

	/************************************************************
	 * Write in a input field 									*
	 * @param element This is the target element where to write *
	 * @param value   what to write 							*
	 ************************************************************
	 */

	public void sendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	


	/****************************************************************************
	 * Perform Hover on an element 												*
	 * @param element This is the target element where to perform hover action 	*
	 ****************************************************************************
	 */
    public void hoverClickElement(WebElement element) {
        Actions actions = new Actions(PageDriver.getCurrentDriver());
        actions.moveToElement(element).click().perform();
    }
        
    public void hoverElement(WebElement element) {
            Actions actions = new Actions(PageDriver.getCurrentDriver());
            actions.moveToElement(element).perform();
    }

	public void hover(WebElement element) {
		Actions action = new Actions(PageDriver.getCurrentDriver());
		action.clickAndHold(element).build().perform();
	}

	/********************************************************************
	 * Handle shadow Dome Related Task 									*
	 * @param host    is the root element shadow dome 					*
	 * @param element is the targeted element within the shadow dome 	*
	 ********************************************************************
	 */

	public void shadowDomePopup(WebElement host, By element) {
		// Finding the ShadowRoot in a WebElement
		SearchContext context = host.getShadowRoot();
		// finding the targeted element
		context.findElement(element).click();
	}

	/************************************************
	 * Handle Select Tag Related Element Task 		*
	 * @param element locator of Select tag 		*
	 * @param value   attribute value of option tag *
	 ************************************************
	 */

	public void selectItemByValue(WebElement element, String value) {
		Select selectItems = new Select(element);
		selectItems.selectByValue(value);
	}
	
	public void selectItemByVisibleText(WebElement element, String value) {
		Select selectItems = new Select(element);
		selectItems.selectByVisibleText(value);
	}
	
	public void selectItemByIndex(WebElement element, int index) {
		Select selectItems = new Select(element);
		selectItems.selectByIndex(index);
	}

	/********************************************
	 * Get selected Item's Text 				*
	 ********************************************
	 */

	public String selectedItemText(WebElement element) {
		Select selectItems = new Select(element);
		return selectItems.getFirstSelectedOption().getText();
	}

	/************************************************************
	 * Get Items select status True if selected or false 		*
	 * **********************************************************
	 */

	public boolean itemSelectedStatus(List<WebElement> elements, String value) {
		for (WebElement element : elements) {
			if (element.getAttribute("value").equals(value)) {
				return element.isSelected();
			}
		}
		return false;
	}

	/*************************************
	 * Handle List elements Related Task *
	 *************************************
	 */

	// Perform any action on the nth number of elements from an elements list
	public void clickOnNthNumberButton(List<WebElement> elements, int position) {
		elements.get(position - 1).click();
	}

	// Perform click action on an element where visible Text matches from an element
	// list
	public void listitem(List<WebElement> elements, String visibleText) {
		for (WebElement element : elements) {
			if (element.getText().equals(visibleText)) {
				element.click();
				break;
			}
		}
	}

	/**********************************
	 * Handle JavaScript Related Task *
	 **********************************
	 */

	// click on a hidden element by using JavascriptExecutor
	public void clickOnAButtonJs(String script) {
		JavascriptExecutor js = (JavascriptExecutor) PageDriver.getCurrentDriver();
		js.executeScript(script + ".click();");
	}

	// Set any DOM element Border color using JavascriptExecutor
	public void highlighter(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) PageDriver.getCurrentDriver();
		js.executeScript("arguments[0].setAttribute('style','border:2px solid red;background: beige');", element);
	}

	/************************************************
	 * Scroll to an element 						*
	 * @param element This is the target element 	*
	 ************************************************
	 */

	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) PageDriver.getCurrentDriver();
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'nearest'});", element);
	}
	
	/************************************************
	 * Scroll The Window Vertically Or Horizontally  				*
	 * @param element This is the target element 	*
	 ************************************************
	 */

	public void scrollTheWindow(int horizontal, int vertical) {
	    JavascriptExecutor js = (JavascriptExecutor) PageDriver.getCurrentDriver();
	    js.executeScript("window.scrollBy(arguments[0], arguments[1]);", horizontal, vertical);
	}
	
	/************************************************
	 * Scroll UP and DOWN							*
	 ************************************************
	 */
	
	//scroll up a page
	public void scrollPageUp() {
		Actions action = new Actions(PageDriver.getCurrentDriver());
		//action.sendKeys(Keys.PAGE_UP).build().perform();
		action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		timeOut();
	}
	
	//scroll down a page
	public void scrollPageDown() {
		Actions action = new Actions(PageDriver.getCurrentDriver());
		action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		//action.sendKeys(Keys.PAGE_DOWN).build().perform();
		timeOut();
	}

	/************************************************************************
	 * Scroll Within an element 											*
	 * @param cssLocator is the target element's cssLocator/query selector 	*
	 * @param offsetX    is the scroll position relative to x axis 			*
	 * @param offsetY    is the scroll position relative to Y axis 			*
	 ************************************************************************
	 */

	public void scrollInsideElement(String cssLocator, int offsetX, int offsetY) {
		JavascriptExecutor js = (JavascriptExecutor) PageDriver.getCurrentDriver();
		js.executeScript("document.querySelector('" + cssLocator + "').scrollBy(" + offsetX + "," + offsetY + ");");
	}

	/****************************
	 * Handle Wait Related Task * 
	 ****************************
	 */

	WebDriverWait wait;

	// wait for default set seconds
	public void timeOut() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// wait for customize given seconds
	public void timeOut(int durationMS) {
		try {
			Thread.sleep(durationMS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Wait for an alert present and return with an alert
	public Alert waitForAlert() {
		wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(30));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		return alert;
	}

	// Wait for an element to be present
	public void waitForElement(By element) {
		wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}

	public void waitUntilElementVisible(WebElement element) {
		wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/***********************************************
	 * Wait to completely load the current web page*
	 * *********************************************
	 */

	public void waitForPageLoad() {
		wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(30));
		wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState;").equals("complete"));
	}

	/*****************************
	 * Handle Alert Related Task * 
	 *****************************
	 */

	// Accept alert whenever it present
	public void alertAccept() {
		Alert alert = waitForAlert();
		alert.accept();
	}

	// Accept alert with giving text whenever it present
	public void allertAccept(String value) {
		Alert alert = waitForAlert();
		alert.sendKeys(value);
		alert.accept();
	}

	// Decline alert whenever it present
	public void alertDismiss() {
		Alert alert = waitForAlert();
		alert.dismiss();
	}

	/****************************
	 * Faker Related Task 		* 
	 ****************************
	 */

	private static Faker faker = new Faker(Locale.of("en", "US"));
	
	public static String firstName;
	public static String firstNameGenerate() {
	    // Generate first name and remove any non-alphabetic characters
	    firstName = faker.name().firstName().replaceAll("[^a-zA-Z]", "");
	    return firstName;
	}

	public static String lastName;

	public static String lastNameGenerate() {
	    // Generate last name and remove any non-alphabetic characters
	    lastName = faker.name().lastName().replaceAll("[^a-zA-Z]", "");
	    return lastName;
	}
    
	public static String email;
	public static String emailGenerate() {
		email =faker.bothify("????##@mail.com");
		return email;
	}

	public static String phoneNumber;

	public String phoneNumberGenerate() {
		
		phoneNumber = faker.numerify("###-###-####");
		return phoneNumber;
	}
	
	public static String bdPhoneNumber;

	public String bdPhoneNumberGenerate() {

        String[] prefixes = {"015", "019", "013", "018", "016"};
        String prefix = prefixes[faker.random().nextInt(prefixes.length)];
        bdPhoneNumber = prefix + faker.numerify("########"); 
        return bdPhoneNumber;
    }

	
	public static String address;

	public static String addressGenerate() {
	    address = faker.address().streetAddress() + ", " + faker.address().city() + ", " + faker.address().state();
	    return address;
	}
	

    private static Random random = new Random();
	
    private static String[] cities = {"Dhaka", "Chittagong", "Khulna", "Rajshahi", "Sylhet", "Barisal", "Rangpur", "Mymensingh"};
    private static String[] districts = {"Dhaka", "Chittagong", "Khulna", "Rajshahi", "Sylhet", "Barisal", "Rangpur", "Mymensingh"};
    private static String[] postalCodes = {"1212", "4000", "9100", "6000", "3116", "8200", "5400", "2200"};

    public static String bdAddressGenerate() {
        String streetAddress = faker.address().streetAddressNumber() + " " + faker.address().streetName();
        String city = cities[random.nextInt(cities.length)];
        String postalCode = postalCodes[random.nextInt(postalCodes.length)];
        String district = districts[random.nextInt(districts.length)];
        return streetAddress + ", " + district + " District, " + city + ", " + postalCode;
    }

	
	
	
	/************************************************************************************
	 * Perform Double Click on an element 												*
	 * 																					*
	 * @param element This is the target element where to perform double click action 	*
	 ************************************************************************************
	 */

	public void doubleClick(WebElement element) {
		Actions action = new Actions(PageDriver.getCurrentDriver());
		action.doubleClick(element).build().perform();
	}
	
	/****************************
	 * Window Handling			*
	 ****************************
	 */
	
	public List<String> windowHandling() {
		//Get all window handles and hold them in a list.
        Set<String> windowHandles = PageDriver.getCurrentDriver().getWindowHandles(); //driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandles);
        
        // Write to total window handle number to the console.
        @SuppressWarnings("unused")
		int size = windowHandlesList.size();
		return windowHandlesList;
	}
	
	public void pageRefresh() {
		PageDriver.getCurrentDriver().navigate().refresh();
		timeOut();
	}
	
	public void newTabOpen() {
		PageDriver.getCurrentDriver().switchTo().newWindow(WindowType.TAB);
		System.out.println("Open a new Tab");
	}
	
	public static void closeTabs() throws InterruptedException {
	    String originalHandle = PageDriver.getCurrentDriver().getWindowHandle();

	    for(String handle : PageDriver.getCurrentDriver().getWindowHandles()) {
	        if (!handle.equals(originalHandle)) {
	        	PageDriver.getCurrentDriver().switchTo().window(handle);
	        	Thread.sleep(1000);
	        	PageDriver.getCurrentDriver().close();
	        }
	    }

	    PageDriver.getCurrentDriver().switchTo().window(originalHandle);
	}


}
