package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.HoldOn;
import generalUtilities.ReadProperties;
import generalUtilities.ReadXL;
import generalUtilities.Readxlsx;
import testSuites.TestSuites;

public class Register {

	WebDriver driver;
	ApplicationUtilities appUts;
	Readxlsx readxlsx;
	static String reg = "Register";
	String xpathAdd;
	HoldOn wait;
	JavascriptExecutor js;

	public Register(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readxlsx = new Readxlsx("testData/XLData.xlsx");
		wait = new HoldOn();
		js = (JavascriptExecutor) driver;
	}

	public void userSignup() {
		System.out.println("Start PO : userSignup");
		System.out.println(" Registration Page object");
	
		
		System.out.println("End PO : userSignup");
	}

	
}
