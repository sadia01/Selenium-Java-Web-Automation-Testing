# Selenium Grid Setup

## Overview

Selenium Grid allows you to run tests in parallel across multiple machines and browsers, helping you achieve faster test execution and improved efficiency. This document provides instructions for setting up a Selenium Grid with a Hub and Nodes.

## Selenium Grid Architecture

1. **Client Request**
   - The client sends a request to the **Router**.

2. **Router**
   - Forwards the request to the **Distributor**.

3. **Distributor**
   - **New Session:** Creates a **Session ID** if a new session is needed.
   - **Session Queue:** Holds requests in the queue if multiple sessions are present until they can be processed.
   - **First-Time Execution:** Creates a **Session Map** and sends it to the Router. The Router directs the request to a suitable **Node**.
   - **Existing Session Map:** Sends the request directly to the appropriate **Node**.

4. **Event Bus**
   - Facilitates communication between different components of Selenium Grid through event channels.

## Setting Up Selenium Grid

### On the Hub Machine

1. **Download Selenium Server**
   - Obtain the Selenium server JAR file from the [official Selenium website](https://www.selenium.dev/downloads/).

2. **Place Files**
   - Ensure the Selenium server JAR file and browser drivers (e.g., ChromeDriver, GeckoDriver for Firefox, EdgeDriver) are in the same folder.

3. **Open Command Prompt**
   - Navigate to the folder containing the Selenium server JAR and drivers.

4. **Start Hub**
   - Run the following command:
     ```sh
     java -jar selenium-server-4.23.0.jar hub
     ```

### On the Node Machine

1. **Download Selenium Server**
   - As with the Hub, download the Selenium server JAR file and place it in a folder.

2. **Place Drivers**
   - Ensure the browser drivers are also placed in the same folder as the Selenium server JAR.

3. **Open Command Prompt**
   - Navigate to the folder containing the Selenium server JAR and drivers.

4. **Start Node**
   - Run the following command to start the Node and connect it to the Hub:
     ```sh
     java -jar selenium-server-4.23.0.jar node --detect-drivers true --publish-events tcp://<HUB_IP>:4442 --subscribe-events tcp://<HUB_IP>:4443
     ```
   - Replace `<HUB_IP>` with the IP address of the Hub machine.

## Obtain Hub Details

- **IP Address:** Find the IP address of the Hub machine (e.g., `192.168.0.105`).
- **XPUB Port:** `4442`
- **XSUB Port:** `4443`

## Example Command for Node

- If your Hub machine's IP address is `192.168.0.105`, use the following command:
  ```sh
  java -jar selenium-server-4.23.0.jar node --detect-drivers true --publish-events tcp://192.168.0.105:4442 --subscribe-events tcp://192.168.0.105:4443

## Conclusion
By following these steps, you will have a fully functional Selenium Grid setup. The Hub will manage and distribute test requests to Nodes across different machines, enabling parallel test execution across various browsers and platforms. This setup enhances testing efficiency and reduces cycle times.

For more information, visit the [official Selenium Grid website](https://www.selenium.dev/documentation/grid/getting_started/).
