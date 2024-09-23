package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.PageDriver;
import utilities.CommonMethods;

public class P007_CheckoutProductLoginPage extends CommonMethods {
	
	public P007_CheckoutProductLoginPage() {

		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}
	

	@FindBy(css = "#checkout")
	WebElement checkoutButton;
	
	@FindBy(css = "#phonNumberEdit")
	WebElement updateNumberFieldClick;

	@FindBy(css = "#shippingPhoneNumber")
	WebElement editNumberField;

	
	@FindBy(css = "#emailEdit")
	WebElement updateEmailFieldClick;
	
	@FindBy(css = "#customerEmail")
	WebElement editEmailField;


	@FindBy(css = "label[for='paymentmethod_1']")
	WebElement paymentMethod;

	@FindBy(xpath = "//button[contains(text(),' PAY & CONFIRM ')]")
	WebElement confirmPaymentButton;
	
	 public void checkoutProductLogin(String checkoutLoginPhoneNumber, String checkoutLoginEmail) throws InterruptedException {

	        hoverClickElement(checkoutButton);
	        timeOut(3000);
	        
	        hoverClickElement(updateNumberFieldClick);
	        sendText(editNumberField, checkoutLoginPhoneNumber);
	        
	        hoverClickElement(updateEmailFieldClick);
	        sendText(editEmailField, checkoutLoginEmail);
	        
	        hoverClickElement(paymentMethod);
	        hoverClickElement(confirmPaymentButton);
	        timeOut(3000);
	    }
}
