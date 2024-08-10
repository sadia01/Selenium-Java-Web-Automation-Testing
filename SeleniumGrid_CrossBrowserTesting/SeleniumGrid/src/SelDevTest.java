import java.net.MalformedURLException;
import java.net.URI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SelDevTest {

	
	
	@Test
	public void HomePageCheck() throws MalformedURLException
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		
		//caps.setPlatform("");
		//caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		
		
		WebDriver driver = new RemoteWebDriver(URI.create("http://192.168.0.105:4444").toURL(), caps);
		driver.get("https://www.selenium.dev/");
		System.out.println(driver.getTitle());
		driver.close();
		
	
		
	}
}
