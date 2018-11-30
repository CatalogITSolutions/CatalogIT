package pageObjects.Admin;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.ReadProperties;
import generalUtilities.Snippet;

public class UploadLogo {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadProperties readprop;
	Snippet snip;

	public UploadLogo(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readprop = new ReadProperties("testData/Data.properties");
		snip = new Snippet(driver);
	}

	public void clientlogo() {
		System.out.println(" Start PO : clientlogo");
		appUts.returnAnElement("xpath", "//a[@href='load-uploadClientlogo']").click();
		String path = System.getProperty("user.dir");
		appUts.returnAnElement("id", "clientlogo").sendKeys(path + "\\Images\\logo2.png");
		appUts.returnAnElement("xpath", "//input[@value='UPLOAD']").click();
		snip.TakeErrorScreenShot("clientlogo");
		System.out.println(" End PO : clientlogo");
	}

}
