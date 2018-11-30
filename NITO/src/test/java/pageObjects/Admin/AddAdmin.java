package pageObjects.Admin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.ReadProperties;
import generalUtilities.Readxlsx;
import generalUtilities.Snippet;
import testSuites.TestSuites;

public class AddAdmin {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadProperties readprop;
	JavascriptExecutor js;
	Snippet snip;
	Readxlsx readxlsx;

	public AddAdmin(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readprop = new ReadProperties(TestSuites.propfilepath);
		js = (JavascriptExecutor) driver;
		snip = new Snippet(driver);
		readxlsx = new Readxlsx(TestSuites.xlsxfilepath);
	}

	public void addadminBySuperAdmin() {
		// TODO Auto-generated method stub
		System.out.println(" Start PO : addadminBySuperAdmin");

		appUts.returnAnElement("xpath", "//a[@href='load-Adminform']").click();
		appUts.returnAnElement("id", "firstname").sendKeys(readxlsx.getCellData("Admin", 0, 0));
		appUts.returnAnElement("id", "lastname").sendKeys(readxlsx.getCellData("Admin", 1, 0));
		appUts.returnAnElement("id", "username").sendKeys(readxlsx.getCellData("Admin", 2, 0));
		appUts.returnAnElement("id", "password").sendKeys(readxlsx.getIntData("Admin", 3, 0));
		appUts.returnAnElement("id", "emailid").sendKeys(readxlsx.getCellData("Admin", 4, 0));
		appUts.returnAnElement("id", "mobile").sendKeys(readxlsx.getRawData("Admin", 5, 0));
		js.executeScript("window.scrollBy(0,200)");
		appUts.returnAnElement("xpath", "//button[@class='btn-primary']").click();
		snip.TakeErrorScreenShot("addadmin");

		System.out.println(" End PO : addadminBySuperAdmin");

	}

}
