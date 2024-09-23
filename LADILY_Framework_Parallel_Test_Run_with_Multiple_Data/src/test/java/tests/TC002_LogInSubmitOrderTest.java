package tests;

import org.testng.Assert;

import org.testng.annotations.Test;
import data.DataSet;
import drivers.BaseDriver;
import pages.P001_LogInPage;
import pages.P005_AddProductToCartPage;
import pages.P007_CheckoutProductLoginPage;
import pages.P008_OrderConfirmationPage;

public class TC002_LogInSubmitOrderTest extends BaseDriver {

	@Test(priority = 0, dataProvider = "combinedLoginCheckoutData", dataProviderClass = DataSet.class)
	public void loginSubmitOrder(String loginEmail, String loginPassword, String checkoutLoginPhoneNumber, String checkoutLoginEmail) throws InterruptedException {

		P001_LogInPage loginPage = new P001_LogInPage();
		loginPage.navigateToLoginPage();
		loginPage.fillLoginDetails(loginEmail, loginPassword );
		
		P005_AddProductToCartPage addProductToCartPage = new P005_AddProductToCartPage();
		addProductToCartPage.addProductToCart();
		
		P007_CheckoutProductLoginPage checkoutProductLoginPage = new P007_CheckoutProductLoginPage();
		checkoutProductLoginPage.checkoutProductLogin(checkoutLoginPhoneNumber, checkoutLoginEmail);
		
		P008_OrderConfirmationPage orderConfirmationPage = new P008_OrderConfirmationPage();

		String confirmationMessage = orderConfirmationPage.getConfirmationMessage();
		Assert.assertEquals(confirmationMessage, "Your order has been successfully processed!");

		orderConfirmationPage.clickOrderDetailsPageLink();
		orderConfirmationPage.clickOrderList();
		orderConfirmationPage.logout();
		
	}
	

}
