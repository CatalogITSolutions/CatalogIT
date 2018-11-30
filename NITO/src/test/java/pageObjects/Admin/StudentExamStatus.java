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

public class StudentExamStatus {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadProperties readprop;
	JavascriptExecutor js;
	Snippet snip;

	public StudentExamStatus(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readprop = new ReadProperties("testData/Data.properties");
		js = (JavascriptExecutor) driver;
		snip = new Snippet(driver);
	}

	public void examStatus() {
		System.out.println(" Start PO : examStatus");
		js.executeScript("window.scrollBy(0,200)");
		appUts.returnAnElement("xpath", "//a[@href='load-viewexamnamesforstdexamstatus']").click();
		appUts.returnAnElement("xpath", "//span[contains(text(),'--Please Select--')]").click();
		appUts.returnAnElement("xpath", "//li[contains(text(),'FINAL TEST')]").click();
		appUts.returnAnElement("xpath", "//button[@class='button btn-primary']").click();

		snip.TakeErrorScreenShot("examStatus");

		System.out.println(" End PO : examStatus");

	}

}
