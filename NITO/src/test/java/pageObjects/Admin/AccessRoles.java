package pageObjects.Admin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.ReadProperties;
import generalUtilities.Readxlsx;
import generalUtilities.Snippet;
import testSuites.TestSuites;

public class AccessRoles {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadProperties readprop;
	JavascriptExecutor js;
	Snippet snip;
	Readxlsx readxlsx;

	public AccessRoles(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readprop = new ReadProperties(TestSuites.propfilepath);
		js = (JavascriptExecutor) driver;
		snip = new Snippet(driver);
		readxlsx = new Readxlsx(TestSuites.xlsxfilepath);
	}

	public void assignRoles() {
		// TODO Auto-generated method stub
		System.out.println(" Start PO : assignRoles");

		appUts.returnAnElement("xpath", "//a[@href='load-Adminform']").click();

		System.out.println(" End PO : assignRoles");

	}

}
