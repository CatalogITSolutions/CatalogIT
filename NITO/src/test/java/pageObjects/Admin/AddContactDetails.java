package pageObjects.Admin;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.ReadProperties;
import generalUtilities.Readxlsx;
import generalUtilities.Readxml;
import generalUtilities.Snippet;
import testSuites.TestSuites;

public class AddContactDetails {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadProperties readprop;
	JavascriptExecutor js;
	Snippet snip;
	Readxlsx readxlsx;

	public AddContactDetails(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readprop = new ReadProperties("testData/Data.properties");
		js = (JavascriptExecutor) driver;
		snip = new Snippet(driver);
		readxlsx = new Readxlsx("testData/Dataxlsx.xlsx");
	}

	public void addContact() {
		System.out.println(" Start PO : addContact");
		js.executeScript("window.scrollBy(0,200)");
		appUts.returnAnElement("xpath", "//a[@href='load-addContactdet']").click();
		appUts.returnAnElement("id", "contactinfo").clear();
		appUts.returnAnElement("id", "contactinfo").sendKeys(readxlsx.getIntData("Contact", 0, 0));
		/*
		 * appUts.returnAnElement("id", "emailid").clear(); appUts.returnAnElement("id",
		 * "emailid").sendKeys(readxlsx.getCellData("Contact", 0, 1));
		 */
		/*
		 * appUts.returnAnElement("id", "address").clear(); appUts.returnAnElement("id",
		 * "address").sendKeys(readxlsx.getCellData("Contact", 0, 2));
		 */
		appUts.returnAnElement("xpath", "//button[@class='btn-primary']").click();

		snip.TakeErrorScreenShot("addContact");

		System.out.println(" End PO : addContact");
	}

}
