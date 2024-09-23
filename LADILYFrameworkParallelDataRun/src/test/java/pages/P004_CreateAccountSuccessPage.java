package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.PageDriver;
import utilities.CommonMethods;

public class P004_CreateAccountSuccessPage extends CommonMethods{
	
	public P004_CreateAccountSuccessPage() {
		
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}
	
    
	@FindBy(xpath = "//button[@class='button-flat text-white continue-shopping-button'][normalize-space()='Continue Shopping']")
    WebElement continueShoppingButton;

    public void clickContinueShopping() {
    	hoverClickElement(continueShoppingButton); 
    	timeOut(2000);
    }

}
