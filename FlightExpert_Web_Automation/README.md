# Travel UI Automation Project

## Introduction
This project automates the end-to-end travel UI flow using Selenium WebDriver. It simulates the flight booking process by navigating through various UI components, including selecting source and destination airports, choosing departure dates, and managing the number of passengers.

## Code Explanation

### 1. Select Source Airport
- **Click on the Source Airport Dropdown:** Opens the dropdown for source airport selection.
- **Enter "CHI" in the Search Input Field:** Types "CHI" to filter the search options.
- **Wait for the Search Options to Appear:** Ensures search options are visible.
- **Select "Shah Amanat International" Airport:** Chooses the airport from the search results.

### 2. Select Destination Airport
- **Click on the Destination Airport Dropdown:** Opens the dropdown for destination airport selection.
- **Enter "DHA" in the Search Input Field:** Types "DHA" to filter the search options.
- **Wait for the Search Options to Appear:** Ensures search options are visible.
- **Select "Hazrat Shahjalal International Airport" Using Java Stream:** Chooses the destination airport efficiently using Java Stream API.

### 3. Select Departure Date
- **Wait for the Calendar Modal to Appear:** Ensures the calendar modal is visible for date selection.
- **Select the Year "2025" from the Dropdown:** Chooses the year from the dropdown menu.
- **Select the Month "April" from the Dropdown:** Chooses the month from the dropdown menu.
- **Click on the Date "15":** Selects the 15th day of the month.

### 4. Get Return Date Disabled
- **Click on the One-Way Radio Button:** Switches to a one-way flight option.
- **Verify that the Return Date Input Field is Disabled:** Ensures that the return date field is disabled when a one-way trip is selected.

### 5. Get Number of Passengers
- **Click on the Search Input Button:** Opens the passenger selection input.
- **Increment the Passenger Count to 3:** Sets the number of passengers to 3.
- **Click on the Done Button:** Finalizes the passenger count selection.

### 6. Radio-Button Selection
- **Click on the Third Radio Button:** Chooses the student fare option.

### 7. Search for Flights
- **Click on the Search Button:** Initiates the search for available flights based on the selected parameters.

