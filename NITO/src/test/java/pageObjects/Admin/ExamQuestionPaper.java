package pageObjects.Admin;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.ReadProperties;
import generalUtilities.Snippet;

public class ExamQuestionPaper {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadProperties readprop;
	Snippet snip;
	public ExamQuestionPaper(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readprop = new ReadProperties("testData/Data.properties");
		snip = new Snippet(driver);
	}

	public void examQuestions() {
		System.out.println(" Start PO : examQuestions");
		appUts.returnAnElement("xpath", "//a[@href='load-viewexamnamesforqpaper']").click();
		appUts.returnAnElement("xpath", "//span[contains(text(),'--Please Select--')]").click();
		appUts.returnAnElement("xpath", "//li[contains(text(),'FINAL TEST')]").click();
		appUts.returnAnElement("xpath", "//button[@class='button btn-primary']").click();
		snip.TakeErrorScreenShot("examQuestions");
		System.out.println(" End PO : examQuestions");
	}

}
