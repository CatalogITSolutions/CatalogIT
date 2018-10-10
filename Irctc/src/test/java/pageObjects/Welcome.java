package pageObjects;


import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

import generalUtilities.ReadProperties;
import generalUtilities.ReadXL;
import generalUtilities.Readjson;
import generalUtilities.Readxml;

public class Welcome {

	WebDriver driver;
	ReadProperties readprop;
	ReadXL readxl;
	Readxml readxml;
	Readjson readjson;

	public Welcome(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		readprop = new ReadProperties("testData/TestData.properties");
		readxl = new ReadXL("testData/DataXL.xls");
		readxml = new Readxml("testData/Data.xml");
		readjson = new Readjson("testData/Data.json");
	}
	
//	@BeforeAll
	//public void maximizeWindow() {
//		driver.manage().window().maximize();
//	}

	
	public void launchApplication() {
		System.out.println("Welcome to IRCTC");
		System.out.println(" Start PO : launchApplication");
		driver.manage().window().maximize();
		
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Java\\Workspace\\JarFiles\\chromedriver\\chromedriver.exe");
		// driver = new ChromeDriver();
		// driver.get("https://www.irctc.co.in/nget/");
	//	driver.get(readprop.readValue("URL"));
		//	driver.get(readxl.getCellData("URL", 0, 0));
	//	driver.get(readxml.getMenuData("URL", "/Train/Link[@id='1']/url"));
		//driver.get(readjson.getData("URL","url"));
		driver.get(readjson.getData("url"));
		
		System.out.println("End PO : launchApplication");
	}
	
	
	public void closeApplication() {
		System.out.println(" Start PO : closeApplication");
		System.out.println("Bye Bye from IRCTC");
		System.out.println(" End PO : closeApplication");
		
	}

	/*
	 * @AfterMethod public void afterMethod() { driver.quit();
	 * 
	 * }
	 */
}
