package pageObjects;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.HoldOn;
import generalUtilities.ReadProperties;
import generalUtilities.ReadXL;
import generalUtilities.Readxlsx;
import generalUtilities.Readxml;
import testSuites.TestSuites;

public class Welcome {

	WebDriver driver;
	ReadProperties readprop;
	ReadXL readxl;
	Readxml readxml;
	Readxlsx readxlsx;
	ApplicationUtilities appUts;
	HoldOn wait;
	String propfilepath;

	public Welcome(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		propfilepath = TestSuites.propfilepath;
		readprop = new ReadProperties(propfilepath);
		readxl = new ReadXL("testData/DataXL.xls");
		readxml = new Readxml("testData/Data.xml");
		appUts = new ApplicationUtilities(driver);
		readxlsx = new Readxlsx(readprop.readValue("xlfilepath"));
		wait = new HoldOn();
	}

//	@BeforeAll
	// public void maximizeWindow() {
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
		// driver.get(readprop.readValue("URL"));
		// driver.get(readxl.getCellData("URL", 0, 0));
		// driver.get(readxml.getMenuData("URL", "/Train/Link[@id='1']/url"));
		driver.get(readprop.readValue("URL"));
		appUts.returnAnElement("xpath", "//a[text()='Online Exam']").click();
		appUts.returnAnElement("xpath", "//span[text()='-- Choose One --']").click();
		wait.staticWait(2);
		// appUts.returnAnElement("xpath", "//li[text()='Electus 2']").click();
		// appUts.selectAnElementFromDropDown("xpath", "//li[text()='Electus 2']","Electus 2");
	//	selectClient();
	appUts.returnAnElement("xpath", "//li[text()='Electus 2']").click();
		 appUts.returnAnElement("xpath", "//input[@type='submit']").click();
		 appUts.returnAnElement("xpath", "//a[text()='Online Exam']").click();
		System.out.println("End PO : launchApplication");
	}

	/*public void selectClient() {
		System.out.println("selectClient method");
		String client = readxlsx.getCellData("client", 0, 0);
		wait.staticWait(5);
		String xpathAdd = "//li[text()='";
		xpathAdd = xpathAdd.concat(client);
		xpathAdd = xpathAdd.concat("']");
		wait.staticWait(5);
		xpathAdd = '"' + xpathAdd + '"';
		System.out.println(xpathAdd);

		wait.staticWait(5);
		appUts.returnAnElement("xpath", xpathAdd).click();

	}*/

	public void closeApplication() {
		System.out.println(" Start PO : closeApplication");
		System.out.println("");
		System.out.println(" End PO : closeApplication");

	}

	/*
	 * @AfterMethod public void afterMethod() { driver.quit();
	 * 
	 * }
	 */
}
