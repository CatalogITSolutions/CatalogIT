package pageObjects;

import org.openqa.selenium.WebDriver;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.HoldOn;
import generalUtilities.ReadProperties;
import generalUtilities.Readxml;
import testSuites.TestSuites;

public class SearchTrain {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadProperties readprop;
	Readxml readxml;
	HoldOn wait;

	public SearchTrain(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readprop = new ReadProperties(TestSuites.propfilepath);
		readxml = new Readxml("testData/Data.xml");
		wait = new HoldOn();
	}

	public void findAndBookTrain() {
		System.out.println("Start PO : findAndBookTrain");
		System.out.println("SearchTrain Page Objects");
		System.out.println("End PO : findAndBookTrain");

	}

	public void findTrain() {
		// TODO Auto-generated method stub
		System.out.println("Start PO : findTrain");
		System.out.println("SearchTrain Page Object");

		appUts.returnAnElement("xpath", "//input[@placeholder='From*']")
				.sendKeys(readxml.getMenuData("From", "/Train/Search[@id='1']/From"));
		appUts.returnAnElement("xpath", "//input[@placeholder='To*']")
				.sendKeys(readxml.getMenuData("From", "/Train/Search[@id='1']/To"));
		appUts.returnAnElement("xpath", "//input[@placeholder='Journey Date(dd-mm-yyyy)*']")
				.sendKeys(readxml.getMenuData("From", "/Train/Search[@id='1']/Date"));
		appUts.returnAnElement("xpath", "//button[contains(text(),'Find trains')]").click();
		wait.staticWait(15);
		System.out.println("End PO : findTrain");

	}

	public void bookTrain() {
		// TODO Auto-generated method stub

	}

}
