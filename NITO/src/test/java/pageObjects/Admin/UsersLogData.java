package pageObjects.Admin;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.ReadProperties;
import generalUtilities.Snippet;

public class UsersLogData {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadProperties readprop;
	JavascriptExecutor js;
	Snippet snip;

	public UsersLogData(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readprop = new ReadProperties("testData/Data.properties");
		js = (JavascriptExecutor) driver;
		snip = new Snippet(driver);

	}

	public void userlogs() {
		System.out.println(" Start PO : userlogs");
		js.executeScript("window.scrollBy(0,200)");
		appUts.returnAnElement("xpath", "//a[@href='load-userslogdata']").click();
		js.executeScript("window.scrollBy(0,200)");
		snip.TakeErrorScreenShot("userlogs");
		js.executeScript("window.scrollBy(0,-200)");
		System.out.println(" End PO : userlogs");

	}

}
