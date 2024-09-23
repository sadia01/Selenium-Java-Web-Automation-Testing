package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.PageDriver;
import utilities.CommonMethods;

public class P002_SignUpNavigationPage extends CommonMethods {
	
	public P002_SignUpNavigationPage() {
		
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}

	@FindAll({
		
		@FindBy(css = "div[class='header-upper header d-none d-lg-flex align-items-center justify-content-between'] li:nth-child(2) a:nth-child(1) svg")
	})
    WebElement loginPageButton;
	
	@FindAll({
		
	    @FindBy(xpath = "//a[contains(text(),'Create Now')]")
	})
    WebElement signUpPageButton;
	
    public void navigateToLoginPage() {
        waitUntilElementVisible(loginPageButton);
        loginPageButton.click();
        timeOut();
    }
    

    public void navigateToSignUpPage() {
        waitUntilElementVisible(signUpPageButton);
        signUpPageButton.click();
        timeOut(5000);
    }



}
