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

public class SubmitExam {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadProperties readprop;
	Snippet snip;
	JavascriptExecutor js;

	public SubmitExam(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readprop = new ReadProperties("testData/Data.properties");
		snip = new Snippet(driver);
		js = (JavascriptExecutor) driver;
	}

	public void submitExam() {
		System.out.println(" Start PO : submitExam");
		js.executeScript("window.scrollBy(0,600)");
		appUts.returnAnElement("xpath", "//a[@href='//a[@href='load-viewexamnamesforsubmitexam']").click();
		snip.TakeErrorScreenShot("submitExam");
		System.out.println(" End PO : submitExam");
	}

}
