package pageObjects;


import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

import generalUtilities.ReadProperties;
import generalUtilities.ReadXL;

public class Welcome {

	WebDriver driver;
	ReadProperties readprop;
	ReadXL readxl;

	public Welcome(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		readprop = new ReadProperties("testData/TestData.properties");
		readxl = new ReadXL("testData/DataXL.xls");
	}
	
//	@BeforeAll
	//public void maximizeWindow() {
//		driver.manage().window().maximize();
//	}

	
	public void launchApplication() {
		//System.out.println("Welcome to IRCTC");
		System.out.println("Start Welcome : launchApplication");
		driver.manage().window().maximize();
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Java\\Workspace\\JarFiles\\chromedriver\\chromedriver.exe");
		// driver = new ChromeDriver();
		// driver.get("https://www.irctc.co.in/nget/");
		driver.get(readprop.readValue("URL"));
	//	driver.get(readxl.getCellData("URL", 0, 0));
		System.out.println("End Welcome : launchApplication");
	}
	
	
	public void closeApplication() {
		System.out.println(" Start PO : closeApplication");
	
		System.out.println(" End PO : closeApplication");
		
	}

	/*
	 * @AfterMethod public void afterMethod() { driver.quit();
	 * 
	 * }
	 */
}
