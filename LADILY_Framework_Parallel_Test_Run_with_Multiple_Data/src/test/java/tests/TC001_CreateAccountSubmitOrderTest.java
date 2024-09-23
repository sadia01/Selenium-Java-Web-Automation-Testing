package tests;

import org.testng.Assert;


import org.testng.annotations.Test;
import data.DataSet;
import drivers.BaseDriver;
import pages.P002_SignUpNavigationPage;
import pages.P003_CreateAccountPage;
import pages.P004_CreateAccountSuccessPage;
import pages.P005_AddProductToCartPage;
import pages.P006_CheckoutProductPage;
import pages.P008_OrderConfirmationPage;

public class TC001_CreateAccountSubmitOrderTest extends BaseDriver {
	
	@Test(priority = 0, dataProvider = "combinedAccountCheckoutData", dataProviderClass = DataSet.class)
	public void CreateAccount(String firstName, String lastName, String createAccountEmail, String phoneNumber, String createAccountpassword, String confirmPassword,
			                  String checkoutFirstName, String checkoutLastName, String checkoutEmail, String checkoutDistrict, String checkoutAddress, String checkoutPhoneNumber) throws InterruptedException 
	{

		P002_SignUpNavigationPage navigationPage = new P002_SignUpNavigationPage();
		navigationPage.navigateToLoginPage();
		navigationPage.navigateToSignUpPage();
		
		P003_CreateAccountPage createAccountPage = new P003_CreateAccountPage();
		createAccountPage.fillCreateAccountForm(firstName, lastName, createAccountEmail, phoneNumber, createAccountpassword, confirmPassword);
		
		P004_CreateAccountSuccessPage successPage = new P004_CreateAccountSuccessPage();
		successPage.clickContinueShopping();
		
		P005_AddProductToCartPage addProductToCartPage = new P005_AddProductToCartPage();
		addProductToCartPage.addProductToCart();
		
		P006_CheckoutProductPage checkoutProductPage = new P006_CheckoutProductPage();
		checkoutProductPage.checkoutProduct(checkoutFirstName, checkoutLastName, checkoutEmail, checkoutDistrict, checkoutAddress, checkoutPhoneNumber);
		
		P008_OrderConfirmationPage orderConfirmationPage = new P008_OrderConfirmationPage();

		String confirmationMessage = orderConfirmationPage.getConfirmationMessage();
		Assert.assertEquals(confirmationMessage, "Your order has been successfully processed!");

		orderConfirmationPage.clickOrderDetailsPageLink();
		orderConfirmationPage.clickOrderList();
		orderConfirmationPage.logout();
		
}
		

}

