## Project Overview

This project is an automated test suite designed using **TestNG** and **Selenium WebDriver**. The test suite automates user flows for an e-commerce platform, focusing on creating accounts, logging in, adding products to the cart, and submitting orders. It implements various classes for data handling, page object model, browser driver setup, and test execution.

### Project Structure

The project is structured into the following packages and classes:

- `data` – Contains test data providers.
- `drivers` – Contains browser driver setup and management.
- `pages` – Contains Page Object Model (POM) classes representing various web pages.
- `tests` – Contains test classes to perform specific test scenarios.
- `utilities` – Contains utility classes like event listeners and common methods.

## Classes Overview

### 1. `data.DataSet`

The `DataSet` class provides data for test methods using the `@DataProvider` annotation. Two data sets are provided here:

- **`combinedAccountCheckoutData`**: Provides data for account creation and product checkout in one set. It includes:
  - User details for account creation (name, email, phone, password).
  - Address and contact details for product checkout.

- **`combinedLoginCheckoutData`**: Provides login details and checkout data for users who are logging in to purchase a product. It includes:
  - Login credentials (email, password).
  - Contact and email details for checkout.

### 2. `drivers.BaseDriver`

The `BaseDriver` class is responsible for setting up and tearing down the WebDriver before and after each test method:

- **`@BeforeMethod`**: Initializes the WebDriver based on the browser specified (Chrome, Firefox, or Edge). The default browser is Chrome. It maximizes the window and navigates to the website.
- **`@AfterMethod`**: Ensures that the WebDriver quits after the test method is completed, to avoid memory leaks and unnecessary resource consumption.

### 3. `drivers.PageDriver`

The `PageDriver` class follows the Singleton pattern to manage a single WebDriver instance per thread. This ensures that each test thread gets its own WebDriver, preventing interference between test executions:

- **`getInstance`**: Ensures that only one instance of `PageDriver` is created.
- **`setDriver`**: Sets the WebDriver for the current thread.
- **`getCurrentDriver`**: Retrieves the WebDriver instance for the current thread.

### 4. `tests.TC001_CreateAccountSubmitOrderTest`

This test class automates the scenario where a user creates an account, adds a product to the cart, and submits an order:

- **Test Flow**:
  1. Navigate to the sign-up page.
  2. Fill out and submit the account creation form.
  3. Add a product to the cart.
  4. Fill out the checkout form.
  5. Assert the successful order submission message.

The test uses data from the `combinedAccountCheckoutData` provider and verifies that the user can successfully create an account and place an order.

### 5. `tests.TC002_LogInSubmitOrderTest`

This test class automates the scenario where a user logs in, adds a product to the cart, and submits an order:

- **Test Flow**:
  1. Log in with valid credentials.
  2. Add a product to the cart.
  3. Fill out the checkout form.
  4. Assert the successful order submission message.

The test uses data from the `combinedLoginCheckoutData` provider and verifies that the user can log in and place an order successfully.

### 6. `utilities.Listeners`

This class implements the **`ITestListener`** interface and serves as a listener to monitor test execution and report failures and successes. It also generates screenshots on test failures. This class is responsible for generating the Extent Report object that will record test results and display them in a visually appealing manner. It integrates screenshots of failed tests for better analysis:

- **`onTestStart`**: Logs the start of the test.
- **`onTestSuccess`**: Logs the success of the test.
- **`onTestFailure`**: Captures a screenshot and logs the failure.
- **`getScreenshot`**: A helper method to capture and save screenshots during test execution.

### 7. `utilities.CommonMethods`

- **Purpose**: Contains common methods used across different page classes, such as waiting for elements, sending text, clicking elements, etc.
- **Methods**:
  - `waitUntilElementVisible()`: Waits until an element is visible.
  - `sendText()`: Sends text to an input field.
  - `hoverClickElement()`: Hovers over an element and then clicks it.
  - `hoverElement()`: Hovers over an element.
  - `scrollToElement()`: Scrolls the window to make an element visible.
  - `scrollTheWindow()`: Scrolls the window horizontally and vertically.
  - `timeOut()`: Waits for a specified amount of time.


## Page Objects

Each class in the `pages` package represents a web page, using the Page Object Model (POM) design pattern. The key page objects are:

### 1. `P001_LogInPage`

This page object interacts with the login form:

- **`navigateToLoginPage`**: Navigates to the login page.
- **`fillLoginDetails`**: Fills out and submits the login form with user details (email,password).

### 2. `P002_SignUpNavigationPage`

This page object is responsible for navigating to the sign-up page from the home or login page:

- **`navigateToLoginPage`**: Navigates to the login page.
- **`navigateToSignUpPage`**: Navigates to the sign-up page from the login page.

### 3. `P003_CreateAccountPage`

This page object interacts with the account creation form:

- **`fillCreateAccountForm`**: Fills out and submits the form with user details (first name, last name, email, phone number, password, confirm password).

### 4. `P004_CreateAccountSuccessPage`

This page object represents the success page after account creation:

- **`clickContinueShopping`**: Clicks the button to continue shopping after a successful account creation.

### 5. `P005_AddProductToCartPage`

This page object handles adding a product to the cart:

- **`addProductToCart`**: Adds a predefined product to the shopping cart.

### 6. `P006_CheckoutProductPage`

This page object is responsible for filling out the checkout form:

- **`checkoutProduct`**: Fills in details like name, email, district, address, and phone number to complete the checkout process for newly created account user.

### 7. `P007_CheckoutProductLoginPage`

This page object manages the checkout flow for logged-in users:

- **`checkoutProductLogin`**: Completes the checkout form after login with the user's details like updating phone number or email.

### 8. `P008_OrderConfirmationPage`

This page object represents the order confirmation page:

- **`getConfirmationMessage`**: Retrieves the message confirming successful order placement.
- **`clickOrderDetailsPageLink`**: Navigates to the order details page.
- **`clickOrderList`**: Navigates to the user's order history.
- **`logout`**: Logs the user out of the system.

## Parallel Test Execution

The `testng.xml` suite file enables parallel test execution using the `parallel="tests"` attribute. This means that the tests will run in parallel to optimize test execution time. Two test classes are specified:

1. **Create Account Submit Order Test**
2. **Log In Submit Order Test**

