package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseDriver {
	

	@BeforeMethod
	public static void setDriver() {
		
		String browser = System.getProperty("browser", "chrome");
        WebDriver driver;
		
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new EdgeDriver();
        }
		
        PageDriver.getInstance().setDriver(driver);
        WebDriver currentDriver = PageDriver.getCurrentDriver();
        currentDriver.get("https://bssoln-001-site3.atempurl.com/");
        currentDriver.manage().window().maximize();

	}


	@AfterMethod
	public static void tearDown() {
		if (PageDriver.getCurrentDriver() != null) {
            PageDriver.getCurrentDriver().quit();
        }
          
	}

}
