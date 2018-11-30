package pageObjects.Admin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import applicationUtilities.ApplicationUtilities;
import generalUtilities.ReadProperties;
import generalUtilities.Snippet;

public class UpdateKey {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadProperties readprop;
	Snippet snip;

	public UpdateKey(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readprop = new ReadProperties("testData/Data.properties");
		snip = new Snippet(driver);
	}

	public void keyUpload() {
		System.out.println(" Start PO : keyUpload");
		appUts.returnAnElement("xpath", "//a[@href='load-updateKey']").click();
		appUts.returnAnElement("xpath", "//span[contains(text(),'--Please Select--')]").click();
		appUts.returnAnElement("xpath", "//li[contains(text(),'WEEKEND-2')]").click();
		appUts.returnAnElement("xpath", "//button[@class='button btn-primary']").click();
		snip.TakeErrorScreenShot("keyUpload");
		appUts.returnAnElement("xpath", "//a[contains(text(),'Next')]").click();
		snip.TakeErrorScreenShot("keyNext");
		appUts.returnAnElement("xpath", "//a[contains(text(),'Previous')]").click();
		snip.TakeErrorScreenShot("keyPervious");
		System.out.println(" End PO : keyUpload");
	}

}
