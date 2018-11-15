package pageObjects.Student;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.ReadProperties;

public class StartTest {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadProperties readprop;

	public StartTest(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readprop = new ReadProperties("testData/Data.properties");

	}

	public void viewStartTest() {
		System.out.println(" Start PO : viewStartTest");
		System.out.println("viewStartTest");
		appUts.returnAnElement("xpath", "//a[contains(text(),'START TEST')]").click();
		System.out.println(" End PO : viewStartTest");
	}

}
