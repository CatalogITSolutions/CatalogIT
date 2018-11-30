package pageObjects.Admin;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.ReadProperties;
import generalUtilities.Snippet;

public class ResultsCalculation {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadProperties readprop;
	Snippet snip;

	public ResultsCalculation(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readprop = new ReadProperties("testData/Data.properties");
		snip = new Snippet(driver);
	}

	public void calculation() {
		System.out.println(" Start PO : calculation");

		appUts.returnAnElement("xpath", "//a[@href='load-resultsCalculation']//img[@id='rcorners2']").click();
		appUts.returnAnElement("id", "// span[contains(text(),'--Please Select--')]").click();
		appUts.returnAnElement("id", "// span[contains(text(),'--Please Select--')]").click();
		appUts.returnAnElement("id", "//button[@class='button btn-primary']").click();
		snip.TakeErrorScreenShot("resultCalculation");
		System.out.println(" End PO : calculation");
	}

}
