package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import drivers.PageDriver;

public class Listeners implements ITestListener {
    
    private ExtentTest test;
    private ExtentReports extent = ExtentFactoryReport.getReportObject();
    private ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    
    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());
        
        WebDriver driver = PageDriver.getCurrentDriver();
        
        // Attach Screenshot to the Report
       String filePath = null;
        
        try {
            filePath = getScreenshot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    }

    // Implement getScreenshot within Listeners
    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationPath = System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
        File file = new File(destinationPath);
        FileUtils.copyFile(source, file);
        return destinationPath;
    }
    
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

}
