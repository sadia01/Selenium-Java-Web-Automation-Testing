package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.PageDriver;
import utilities.CommonMethods;

public class P006_CheckoutProductPage extends CommonMethods {

	public P006_CheckoutProductPage() {

		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}

	@FindBy(css = "#checkout")
	WebElement checkoutButton;

	@FindBy(id = "FirstName")
	WebElement firstNameField;

	@FindBy(name = "LastName")
	WebElement lastNameField;

	@FindBy(css = "#Email")
	WebElement emailField;

	@FindBy(css = "#StateProvinceId")
	WebElement districtDropdown;

	@FindBy(css = "#Address1")
	WebElement addressField;

	@FindBy(css = "#PhoneNumber")
	WebElement phoneNumberField;

	@FindBy(css = "label[for='paymentmethod_1']")
	WebElement paymentMethod;

	@FindBy(xpath = "//button[contains(text(),' PAY & CONFIRM ')]")
	WebElement confirmPaymentButton;
	
    public void checkoutProduct(String checkoutFirstName, String checkoutLastName, String checkoutEmail, String checkoutDistrict, String checkoutAddress, String checkoutPhoneNumber) throws InterruptedException {

        hoverClickElement(checkoutButton);
        timeOut(3000);
        scrollTheWindow(0, 200);
        sendText(firstNameField, checkoutFirstName);
        sendText(lastNameField, checkoutLastName);
        sendText(emailField, checkoutEmail);
        selectItemByVisibleText(districtDropdown, checkoutDistrict);
        sendText(addressField, checkoutAddress);
        sendText(phoneNumberField, checkoutPhoneNumber);
        hoverClickElement(paymentMethod);
        hoverClickElement(confirmPaymentButton);

        timeOut(5000);
    }

}
