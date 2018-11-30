package pageObjects.Admin;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.ReadProperties;
import generalUtilities.Snippet;

public class SetExamPattern {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadProperties readprop;
	Snippet snip;

	public SetExamPattern(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readprop = new ReadProperties("testData/Data.properties");
		snip = new Snippet(driver);
	}

	public void examPattern() {
		System.out.println(" Start PO : examPattern");
		appUts.returnAnElement("xpath", "//a[@href='load-setstartexampattern']").click();
		appUts.returnAnElement("id", "exampatternval_2").click();
		appUts.returnAnElement("xpath", "//button[@id='popup']").click();
		appUts.returnAnElement("xpath", "//button[@value='finishtest']").click();
		snip.TakeErrorScreenShot("examPattern");
		System.out.println(" End PO : examPattern");
	}

}
