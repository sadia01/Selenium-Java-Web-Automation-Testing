# Selenium Grid Architecture
1. Client Request: The client sends a request to the Router.
2. Router: The Router forwards the request to the Distributor.
3. Distributor:
   If a new session is needed, the Distributor creates a session ID.
   If there are multiple sessions, the Session Queue holds the requests until the Distributor can process them.
   If it’s the first time the test is being executed, the Distributor creates a Session Map and sends it to the Router. The Router then directs the request to a suitable Node.
   If the Session Map already exists, the Distributor sends the request directly to the appropriate Node.
5. Event Bus: Facilitates communication between different components of Selenium Grid through event channels.
# Setting Up Selenium Grid
# On the Hub Machine
1. Download Selenium Server: Obtain the Selenium server JAR file from the official Selenium website.
2. Place Files: Ensure the Selenium server JAR file and browser drivers (e.g., ChromeDriver, GeckoDriver for Firefox, EdgeDriver) are in the same folder.
3. Open Command Prompt: Navigate to the folder containing the Selenium server JAR and drivers.
4. Start Hub: Run the following command to start the Hub: java -jar selenium-server-4.23.0.jar hub

# On the Node Machine
1. Download Selenium Server: As with the Hub, download the Selenium server JAR file and place it in a folder.
2. Place Drivers: Ensure the browser drivers are also placed in the same folder as the Selenium server JAR.
3. Open Command Prompt: Navigate to the folder containing the Selenium server JAR and drivers.
4. Start Node: Run the following command to start the Node and connect it to the Hub: java -jar selenium-server-4.23.0.jar node --detect-drivers true --publish-events tcp://<HUB_IP>:4442 --subscribe-events tcp://<HUB_IP>:4443
5. Replace <HUB_IP> with the IP address of the Hub machine.
# Obtain Hub Details:
IP Address: Find the IP address of the Hub machine. For example, 192.168.0.105.
XPUB Port: 4442
XSUB Port: 4443
# Example Command for Node
If your Hub machine's IP address is 192.168.0.105, you would use: java -jar selenium-server-4.23.0.jar node --detect-drivers true --publish-events tcp://192.168.0.105:4442 --subscribe-events tcp://192.168.0.105:4443

By following these steps, you should have a functional Selenium Grid setup with a Hub managing and distributing test requests to Nodes across different machines.
This setup enables parallel test execution across various browsers and platforms, enhancing testing efficiency and reducing cycle times.
