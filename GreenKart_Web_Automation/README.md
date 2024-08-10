## Introduction
This project automates the process of adding products to a cart on an e-commerce website using Selenium WebDriver. The automation script searches for specific products and adds them to the cart, simplifying the process of managing multiple product additions.

## Code Explanation

### 1. `ProductAddToCart.java`
- **Purpose:** Contains the main method to execute the automation flow.
- **Functionality:**
  1. **Launches the Browser:** Initializes the WebDriver and opens the browser.
  2. **Navigates to the Website:** Directs the browser to the e-commerce website.
  3. **Calls the `addItems` Method:** Invokes the method to handle the addition of specified products to the cart.

### 2. `addItems` Method
- **Purpose:** Adds products to the cart.
- **Parameters:**
  - **`WebDriver` object:** Manages the browser interactions.
  - **`Array of Product Names:`** Contains the names of the products to be added to the cart.
- **Functionality:**
  1. **Searches for Each Product:** Performs a search operation for each product name on the website.
  2. **Adds Products to the Cart:** Adds the found products to the cart.
  3. **Stops When All Products Are Added:** Terminates the process once all specified products are added.


