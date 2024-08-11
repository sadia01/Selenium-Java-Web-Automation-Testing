# Excel Data-Driven Test Automation

## Overview

This Java class, `E03_dataDrivenExcel`, is designed for data-driven testing. It reads test data from an Excel file and retrieves data for a specified test case which is in `E04_testSample`. The data is extracted from a specific sheet and row, and is returned as an ArrayList<String>.

## Features

- Reads data from an Excel file (`ExcelDataTest.xlsx`).
- Identifies the column for test cases.
- Retrieves data for a specific test case.
- Supports both string and numeric cell types.

# Usage

# Prerequisites
- Create Maven project
- Apache POI & POI-OOXML dependencies in pom.xml for handling Excel files.

### Code Explanation

1. **File Reading**
   - Reads the Excel file from the specified path.

2. **Sheet Selection**
   - Iterates through sheets to find the sheet named `"testdata"`.

3. **Column Identification**
   - Identifies the column index where `"TestCases"` is located.

4. **Row Retrieval**
   - Scans rows to find the row matching the specified test case name.

5. **Data Extraction**
   - Extracts data from the identified row and adds it to an ArrayList<String>.




# Code Funnctionality Explanation

- Defines a public class named dataDriven
- Defines a public method getData that returns an ArrayList<String>. It takes a single parameter testcaseName of type String
- Creates a new ArrayList of String to store the data retrieved from the Excel file
- Creates a FileInputStream to read the Excel file 
- Creates an XSSFWorkbook object from the FileInputStream. This represents the entire Excel workbook
- Retrieves the number of sheets in the workbook
- Starts a loop to iterate through each sheet in the workbook
- Checks if the sheet name is "testdata" 
-  Gets the sheet at index i
- Creates an iterator for the rows in the sheet and retrieves the first row.
- Creates an iterator for the cells in the first row, initializes k and coloumn, and starts a loop to iterate through the cells.
- Checks if the cell value is `"TestCases"`. If it is, stores the column index in coloumn. Increments k to move to the next cell.
- Begins a new loop to iterate through the remaining rows in the sheet.
- Retrieves the next row and checks if the cell in the identified column matches testcaseName which is stored in `E04_testSample` class by creating a object of `E03_dataDrivenExcel` in that class.
- Creates an iterator for the cells in the identified row and starts a loop to iterate through these cells.
- Retrieves the cell value based on its type (string or numeric) and adds it to the ArrayList. After processing, returns the ArrayList containing the data.




# Excel Data Provider for TestNG

## Overview

The `T01_dataProviderExcel` Java class is designed for data-driven testing using TestNG. It reads test data from an Excel file (`dataProvider.xlsx`) and provides this data to the test methods through the TestNG `@DataProvider` annotation. This enables executing the same test method with different sets of data.

## Features

- **Data-Driven Testing:** Provides test data from an Excel file to TestNG test methods.
- **Excel File Integration:** Reads data from an Excel file named `dataProvider.xlsx`.
- **Dynamic Data Handling:** Automatically adapts to different numbers of rows and columns in the Excel file.
- **TestNG Integration:** Utilizes TestNG’s `@DataProvider` to supply data to test methods.

## Prerequisites

- **Java Development Kit (JDK):** Ensure that JDK is installed on your system.
- **TestNG:** Ensure that TestNG is set up in your project.

## Dependencies
- Create Maven project
- Apache POI, POI-OOXML & TestNG dependencies in pom.xml for handling Excel files.

### Code Explanation
The T01_dataProviderExcel class uses Apache POI to read data from an Excel file and TestNG's @DataProvider to supply this data to test methods. Here’s a detailed explanation of the code:

1. **Class Definition**
    - **public class T01_dataProviderExcel:** Defines the class for data-driven testing.
  
2. **Test Method**
    - **@Test(dataProvider="driveTest"):** Marks the testCaseData method as a TestNG test method that will use data provided by the getData method.
    - **public void testCaseData(String greeting, String communication, String id):** The test method that takes data provided by getData and prints it.
  
3. **Data Provider Method**
   - **@DataProvider(name="driveTest"):** Defines the getData method as a TestNG data provider named "driveTest".
   - **public Object[][] getData() throws IOException:** The method that reads data from the Excel file and returns it as a 2D Object array.

5. **File Reading and Data Extraction**
   - **File Input Stream:** FileInputStream fis=new FileInputStream(...) creates an input stream to read the Excel file from the specified path.
   - **Workbook Creation:** XSSFWorkbook workbook=new XSSFWorkbook(fis) creates a workbook instance representing the entire Excel file.
   - **Sheet Selection:** XSSFSheet sheet = workbook.getSheetAt(0) selects the first sheet from the workbook.
   - **Row and Column Count:** int rowCount = sheet.getPhysicalNumberOfRows() and int colCount = row.getLastCellNum() determine the number of rows and columns in the sheet.
   - **Data Extraction:** Loops through each row and column, reads cell values, and stores them in a 2D Object array (Object data[][]).
  
5. **Data Formatting**
   - Uses DataFormatter to format cell values, ensuring compatibility with various cell types (e.g., string, numeric).
  
7. **Returning Data**
   - Returns the 2D Object array containing the test data, which is used by TestNG to run the test method with different data sets.
