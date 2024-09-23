package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.PageDriver;
import utilities.CommonMethods;

public class P008_OrderConfirmationPage extends CommonMethods {

	public P008_OrderConfirmationPage() {

		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}

	@FindBy(css = "div[class='title'] strong")
	WebElement confirmMessage;

	@FindBy(xpath = "//a[contains(text(),'Click here for order details.')]")
	WebElement orderDetailsPageLink;

	@FindBy(css = "p[class='heading-font']")
	WebElement ordersList;

	@FindBy(xpath = "(//li[@id='topuserlink'])[1]")
	WebElement hoverlogOutOption;

	@FindBy(xpath = "(//p[contains(text(),'Log out')])[1]")
	WebElement accountLogout;
	
    public String getConfirmationMessage() {
    	
        return confirmMessage.getText();
    }

    public void clickOrderDetailsPageLink() {
    	
        orderDetailsPageLink.click();
        timeOut();
    }

    public void clickOrderList() {
    	
    	hoverClickElement(ordersList);
        timeOut();
    }

    public void logout() {
    	
        hoverElement(hoverlogOutOption);
        hoverClickElement(accountLogout);
        timeOut(2000);
    }

}
