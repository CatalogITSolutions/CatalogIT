package pageObjects.Admin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.HoldOn;
import generalUtilities.ReadProperties;
import generalUtilities.ReadXL;
import generalUtilities.Readxlsx;
import testSuites.TestSuites;

public class Dashboard {

	WebDriver driver;
	ApplicationUtilities appUts;
	Readxlsx readxlsx;

	String xpathAdd;
	HoldOn wait;
	JavascriptExecutor js;         

	public Dashboard(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readxlsx = new Readxlsx("testData/XLData.xlsx");
		wait = new HoldOn();
		js = (JavascriptExecutor) driver;
	}

	public void selectState() {
		System.out.println("Start PO : selectState");
		System.out.println(" selectState Page Method");
		appUts.returnAnElement("xpath", "//a[@href='load-stateform']//img[@id='rcorners2']").click();
		wait.staticWait(2);
		appUts.returnAnElement("id", "statename").sendKeys();
		
		System.out.println("End PO : selectState");
	}

}
