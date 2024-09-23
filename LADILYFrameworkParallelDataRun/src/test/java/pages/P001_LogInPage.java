package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.PageDriver;
import utilities.CommonMethods;

public class P001_LogInPage  extends CommonMethods  {
	
	public P001_LogInPage(){
		
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}
	

		
	@FindBy(css = "div[class='header-upper header d-none d-lg-flex align-items-center justify-content-between'] li:nth-child(2) a:nth-child(1) svg")
    WebElement loginPageButton;
	
	@FindBy(id= "Username")
	WebElement loginEmailInput;
	
	@FindBy(name= "Password")
	WebElement loginPasswordInput;
	
	@FindBy(xpath= "//button[contains(text(),'Log in')]")
	WebElement loginButton;
	
	
	
    public void navigateToLoginPage() {
    	
        waitUntilElementVisible(loginPageButton);
        loginPageButton.click();
        timeOut();
    }
    
    public void fillLoginDetails(String loginEmail, String loginPassword) {
        
        sendText(loginEmailInput, loginEmail );
        sendText(loginPasswordInput, loginPassword);
        hoverClickElement(loginButton);
        timeOut();
    }

}
