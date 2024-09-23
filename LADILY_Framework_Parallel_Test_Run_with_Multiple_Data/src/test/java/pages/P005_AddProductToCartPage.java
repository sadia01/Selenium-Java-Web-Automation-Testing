package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.PageDriver;
import utilities.CommonMethods;

public class P005_AddProductToCartPage extends CommonMethods {
	
	public P005_AddProductToCartPage() {
		
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}
	
    @FindBy(xpath = "(//button[@type='button'][normalize-space()='Add to cart'])[1]")
    WebElement addToCartPageButton;
    
    @FindBy(xpath = "//label[normalize-space()='60 ml']")
    WebElement productSize;
    
    @FindBy(css = "#add-to-cart-button-2")
    WebElement addToCartButton;
    
    @FindBy(xpath = "(//button[@class='button-flat text-white continue-shopping-button'])[1]")
    WebElement goToCartButton;
    

    
    
    public void addProductToCart() throws InterruptedException {
    	
    	scrollTheWindow(0,900);
    	timeOut(2000);
    	scrollToElement(addToCartPageButton);
    	hoverClickElement(addToCartPageButton); 
        timeOut(3000); 
        
        waitUntilElementVisible(productSize);
        scrollToElement(productSize);
        hoverClickElement(productSize); 
        timeOut(2000); 

        scrollToElement(addToCartButton);
        hoverClickElement(addToCartButton); 
        timeOut();
        
        hoverClickElement(goToCartButton); 
        timeOut(5000);
        
        

    }
    

}
