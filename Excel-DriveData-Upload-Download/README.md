# Upload Download Using Excel External File

## Description

This project demonstrates an automated test for file upload and download operations using Selenium WebDriver and Excel file manipulation using Apache POI. The test involves:
1. Downloading an Excel file from a given URL.
2. Updating a specific cell in the Excel file.
3. Uploading the modified Excel file back to the server.
4. Verifying the success message and updated data on the web page.

## Prerequisites

Before you begin, ensure you have the following software and tools installed:

- **Java JDK 11 or higher**: Make sure Java is installed. You can verify the installation by running `java -version` in your terminal.
- **Apache Maven**: Used for project dependency management. Check the installation by running `mvn -v`.
- **Selenium WebDriver**: Required for browser automation. Make sure you have the WebDriver executable for Chrome (or the browser of your choice).
- **Apache POI & POI OOXML**: A Java library for manipulating Excel files. It should be included in your `pom.xml` file if you're using Maven.


## Configuration

Update the following parts of the code if needed:

- **File Paths**: Ensure that the path to `download.xlsx` is correct and that the file is accessible.
- **WebDriver Configuration**: Modify the WebDriver setup if you are using a different browser or version.
- **Excel File Details**: Adjust the column names and values according to your specific Excel file structure.

## Code Explanation

The main class, `UploadDownload`, performs the following steps:

1. **Setup WebDriver**

    ```java
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
    ```

    Initializes the WebDriver, sets an implicit wait time, and opens the target URL.

2. **Download File**

    ```java
    driver.findElement(By.cssSelector("#downloadButton")).click();
    ```

    Clicks the download button to start downloading the file.

3. **Update Excel File**

    - **Get Column Number**

      ```java
      int col = getColumnNumber(fileName, "price");
      ```

      Finds the column number of "price" in the Excel file.

    - **Get Row Number**

      ```java
      int row = getRowNumber(fileName, "Apple");
      ```

      Finds the row number where "Apple" is located.

    - **Update Cell**

      ```java
      Assert.assertTrue(updateCell(fileName, row, col, updatedValue));
      ```

      Updates the cell value in the Excel file and asserts that the update was successful.

4. **Upload File**

    ```java
    WebElement upload = driver.findElement(By.cssSelector("input[type='file']"));
    upload.sendKeys(System.getProperty("user.dir") + "//src//test//java//excelData//download.xlsx");
    ```

    Uploads the modified Excel file.

5. **Verify Success Message**

    ```java
    By toastLocator = By.cssSelector(".Toastify__toast-body div:nth-child(2");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
    String toastText = driver.findElement(toastLocator).getText();
    Assert.assertEquals("Updated Excel Data Successfully.", toastText);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));
    ```

    Waits for the success message to appear and verifies its content and wait for it to disappear.

6. **Verify Updated Data**

    ```java
    String priceColumn = driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
    String actualPrice = driver.findElement(By.xpath("//div[text()='" + fruitName
        + "']/parent::div/parent::div/div[@id='cell-" + priceColumn + "-undefined']")).getText();
    Assert.assertEquals(updatedValue, actualPrice);
    ```

    Checks that the updated value is correctly displayed in the web table.

7. **`updateCell` Method**
- ArrayList<String> a = new ArrayList<String>();: Creates an unused ArrayList. This line can be removed as it doesn't contribute to the method.
- FileInputStream fis = new FileInputStream(fileName);: Opens the Excel file specified by fileName.
- XSSFWorkbook workbook = new XSSFWorkbook(fis);: Creates a workbook object to access the Excel file.
- XSSFSheet sheet = workbook.getSheet("Sheet1");: Retrieves the sheet named "Sheet1".
- Row rowField = sheet.getRow(row - 1);: Retrieves the row based on the specified row number (adjusted for zero-based indexing).
- Cell cellField = rowField.getCell(col - 1);: Retrieves the cell based on the specified column number (adjusted for zero-based indexing).
- cellField.setCellValue(updatedValue);: Updates the cell with the new value.
- FileOutputStream fos = new FileOutputStream(fileName);: Prepares to write the changes back to the file.
- workbook.write(fos);: Writes the updated workbook to the file.
- workbook.close(); and fis.close();: Closes the workbook and file input stream to release resources.

**`getRowNumber` Method**
- ArrayList<String> a = new ArrayList<String>();: Creates an unused ArrayList. This line can be removed as it doesn't contribute to the method.
- FileInputStream fis = new FileInputStream(fileName);: Opens the Excel file specified by fileName.
- XSSFWorkbook workbook = new XSSFWorkbook(fis);: Creates a workbook object to access the Excel file.
- XSSFSheet sheet = workbook.getSheet("Sheet1");: Retrieves the sheet named "Sheet1".
- Iterator<Row> rows = sheet.iterator();: Iterates through the rows of the sheet.
- int k = 1; int rowIndex = -1;: Initializes row index counter k and the result variable rowIndex.
- while (rows.hasNext()) { ... }: Iterates over each row and its cells to find a cell that matches the specified text.
- rowIndex = k;: Sets the row index if the cell matches the specified text.

**`getColumnNumber Method`**
- ArrayList<String> a = new ArrayList<String>();: Creates an unused ArrayList. This line can be removed as it doesn't contribute to the method.
- FileInputStream fis = new FileInputStream(fileName);: Opens the Excel file specified by fileName.
- XSSFWorkbook workbook = new XSSFWorkbook(fis);: Creates a workbook object to access the Excel file.
- XSSFSheet sheet = workbook.getSheet("Sheet1");: Retrieves the sheet named "Sheet1".
- Iterator<Row> rows = sheet.iterator();: Iterates through the rows of the sheet.
- Row firstrow = rows.next();: Gets the first row (which contains the column headers).
- Iterator<Cell> ce = firstrow.cellIterator();: Iterates through the cells of the first row.
- int k = 1; int column = 0;: Initializes column index counter k and the result variable column.
- while (ce.hasNext()) { ... }: Iterates over each cell in the first row to find a cell that matches the specified column name.
- column = k;: Sets the column index if the cell matches the specified column name.



# Drive Data from Excel using TestNG Data Provider

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




# Code Functionality Explanation

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
