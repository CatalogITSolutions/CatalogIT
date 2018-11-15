package pageObjects.Student;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.ReadProperties;

public class SPA {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadProperties readprop;

	public SPA(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readprop = new ReadProperties("testData/Data.properties");

	}

	public void viewSPA() {
		System.out.println(" Start PO : viewSPA");
		System.out.println("viewSPA");
		appUts.returnAnElement("xpath", "//a[contains(text(),'SPA')]").click();
		appUts.returnAnElement("xpath", "//a[text()='MAINS']").click();
		appUts.returnAnElement("xpath", "//button[@id='plain']").click();
		appUts.returnAnElement("xpath", "//button[@id='inverted']").click();
		appUts.returnAnElement("id", "polar").click();
		System.out.println(" End PO : viewSPA");
	}

}
