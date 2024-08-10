# Introduction
This project automates the end-to-end travel UI flow using Selenium WebDriver. The code navigates through the flight booking process, selecting source and destination airports, departure date, and number of passengers.

# Code Explanation
The code consists of the following steps:
# Select Source Airport:
1. Click on the source airport dropdown
2. Enter "CHI" in the search input field
3. Wait for the search options to appear
4. Select "Shah Amanat International" airport
# Select Destination Airport:
1. Click on the destination airport dropdown
2. Enter "DHA" in the search input field
3. Wait for the search options to appear
4. Select "Hazrat Shahjalal International Airport" using Java Stream
# Select Departure Date:
1. Wait for the calendar modal to appear
2. Select the year "2025" from the dropdown
3. Select the month "April" from the dropdown
4. Click on the date "15"
# Get Return Date Disabled:
1. Click on the one-way radio button
2. Verify that the return date input field is disabled
3. Get Number of Passengers:
4. Click on the search input button
5. Increment the passenger count to 3
6. Click on the done button
# Radio-button Selection:
Click on the third radio button to choose student fare
# Search for Flights:
Click on the search button
