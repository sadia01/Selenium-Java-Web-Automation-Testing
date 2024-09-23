package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.PageDriver;
import utilities.CommonMethods;

public class P003_CreateAccountPage extends CommonMethods {

	public P003_CreateAccountPage() {

		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}

	@FindAll({

			@FindBy(id = "FirstName") })
	WebElement firstNameInput;

	@FindAll({

			@FindBy(name = "LastName") })
	WebElement lastNameInput;

	@FindAll({

			@FindBy(css = "#Email") })
	WebElement emailInput;

	@FindAll({

			@FindBy(css = "#Phone") })
	WebElement phoneInput;

	@FindAll({

			@FindBy(xpath = "//input[@name='Password']") })
	WebElement passwordInput;

	@FindAll({

			@FindBy(css = "svg[id='registration-icon-toggle']") })
	WebElement passwordEyeIcon;

	@FindAll({

			@FindBy(css = "input[name='ConfirmPassword']") })
	WebElement confirmPasswordInput;

	@FindAll({

			@FindBy(css = "svg[id='registration-confirm-icon-toggle']") })
	WebElement confirmPasswordEyeIcon;

	@FindAll({

			@FindBy(xpath = "//button[@name='register-button']") })
	WebElement registerButton;
	


	public void fillCreateAccountForm(String firstName, String lastName, String createAccountEmail, String phoneNumber, String createAccountpassword, String confirmPassword) throws InterruptedException {

		sendText(firstNameInput, firstName);
		sendText(lastNameInput, lastName);
		sendText(emailInput, createAccountEmail);
		scrollTheWindow(0, 500);
		timeOut();

		sendText(phoneInput, phoneNumber);
		sendText(passwordInput, createAccountpassword);
		passwordEyeIcon.click();
		timeOut(2000);
		sendText(confirmPasswordInput, confirmPassword);
		confirmPasswordEyeIcon.click();
		timeOut(2000);
		hoverClickElement(registerButton);
		timeOut();

	}
	

}
