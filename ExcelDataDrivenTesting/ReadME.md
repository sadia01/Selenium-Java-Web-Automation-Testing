# Excel Data-Driven Test Automation

## Overview

This Java class, `dataDriven`, is designed for data-driven testing. It reads test data from an Excel file and retrieves data for a specified test case. The data is extracted from a specific sheet and row, and is returned as an `ArrayList<String>`.

## Features

- Reads data from an Excel file (`ExcelDataTest.xlsx`).
- Identifies the column for test cases.
- Retrieves data for a specific test case.
- Supports both string and numeric cell types.

## Usage

# Prerequisites
- Create Maven project
- Apache POI & POI-OOXML dependencies in pom.xml for handling Excel files.

### Code Explanation

1. **File Reading**
   - Reads the Excel file from the specified path.

2. **Sheet Selection**
   - Iterates through sheets to find the sheet named "testdata".

3. **Column Identification**
   - Identifies the column index where "TestCases" is located.

4. **Row Retrieval**
   - Scans rows to find the row matching the specified test case name.

5. **Data Extraction**
   - Extracts data from the identified row and adds it to an `ArrayList<String>`.




# Code Functionality Explanation

- Defines a public class named dataDriven
-  Defines a public method getData that returns an ArrayList<String>. It takes a single parameter testcaseName of type String
- Creates a new ArrayList of String to store the data retrieved from the Excel file
- Creates a FileInputStream to read the Excel file 
- Creates an XSSFWorkbook object from the FileInputStream. This represents the entire Excel workbook
- Retrieves the number of sheets in the workbook
-  Starts a loop to iterate through each sheet in the workbook
- Checks if the sheet name is "testdata"
- Sets the sheet at index i
- Creates an iterator for the rows in the sheet and retrieves the first row.
- Creates an iterator for the cells in the first row, initializes k and coloumn, and starts a loop to iterate through the cells.
- Checks if the cell value is "TestCases". If it is, stores the column index in coloumn. Increments k to move to the next cell.
- Begins a new loop to iterate through the remaining rows in the sheet.
- Retrieves the next row and checks if the cell in the identified column matches testcaseName
- Creates an iterator for the cells in the identified row and starts a loop to iterate through these cells.
- Retrieves the cell value based on its type (string or numeric) and adds it to the ArrayList. After processing, returns the ArrayList containing the data.
