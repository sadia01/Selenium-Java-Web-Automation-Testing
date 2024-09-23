package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentFactoryReport {

	
	public static ExtentReports getReportObject()
	{
		String path =System.getProperty("user.dir")+"//reports//report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Ladily Web Automation Results");
		reporter.config().setDocumentTitle("Automation Test Results");
		
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sadia Binte Nizam");
		return extent;
		
		
		
	}
}