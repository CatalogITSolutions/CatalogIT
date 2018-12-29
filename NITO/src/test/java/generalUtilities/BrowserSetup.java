package generalUtilities;

import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserSetup {

	WebDriver driver;
	ReadProperties readprop;
	URL getUrl;
	
	public BrowserSetup() {
		// TODO Auto-generated constructor stub
		readprop = new ReadProperties("testData/Data.properties");
	}

	public WebDriver driverType() {
		if (readprop.readValue("executionType").equalsIgnoreCase("LOCAL")) {
			driver = getLocalDriver();
		} else if (readprop.readValue("executionType").equalsIgnoreCase("REMOTE")) {
			driver = getRemoteDriver();
		} else {
			driver = getLocalDriver();
		}
		return driver;

	}

	public WebDriver getLocalDriver() {
		String path = System.getProperty("user.dir");
		if (readprop.readValue("browser").equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver",
					path + "\\browser\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (readprop.readValue("browser").equalsIgnoreCase("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver", path + "\\browser\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (readprop.readValue("browser").equalsIgnoreCase("INTERNETEXPLORER")) {
			System.setProperty("webdriver.ie.driver", path + "\\browser\\IEDriverServer\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (readprop.readValue("browser").equalsIgnoreCase("OPERA")) {

			driver = new OperaDriver();
		} else {
			System.setProperty("webdriver.chrome.driver",
					path + "\\browser\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		return driver;
	}

	public WebDriver getRemoteDriver() {
		// TODO Auto-generated method stub
		try {
			getUrl = new URL(readprop.readValue("SaucelabsURL"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("name", readprop.readValue("ApplicationName"));
		capabilities.setCapability(CapabilityType.BROWSER_NAME, readprop.readValue("browser"));
		capabilities.setCapability(CapabilityType.VERSION, readprop.readValue("BrowserVersion"));
		capabilities.setCapability(CapabilityType.PLATFORM, readprop.readValue("OS"));
		capabilities.setCapability("screen-resolution", readprop.readValue("ScreenResolution"));
		capabilities.setCapability("username", readprop.readValue("SaucelabsUserName"));
		capabilities.setCapability("accessKey", readprop.readValue("SaucelabsAccessKey"));
		driver = new RemoteWebDriver(getUrl, capabilities);
		return driver;
	}

}
