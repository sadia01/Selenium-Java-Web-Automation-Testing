import java.net.MalformedURLException;
import java.net.URI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GoogleTest {

	
	
	@Test
	public void HomePageCheck() throws MalformedURLException
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("firefox");
		//caps.setPlatform(Platform.);
//		caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//		caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		
		
		WebDriver driver = new RemoteWebDriver(URI.create("http://192.168.0.105:4444").toURL(), caps);
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Sadia Binte Nizam");
		driver.close();
		
	
		
	}
}
