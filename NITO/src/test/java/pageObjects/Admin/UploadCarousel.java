package pageObjects.Admin;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.ReadProperties;
import generalUtilities.Snippet;

public class UploadCarousel {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadProperties readprop;
	Snippet snip;

	public UploadCarousel(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readprop = new ReadProperties("testData/Data.properties");
		snip = new Snippet(driver);
	}

	public void carouselSlide() {
		System.out.println(" Start PO : carouselSlide");
		
		appUts.returnAnElement("xpath", "//a[@href='load-uploadClientCarousel']").click();
		String path = System.getProperty("user.dir");
		appUts.returnAnElement("id", "carousel").sendKeys(path + "\\Images\\slider.png");
		appUts.returnAnElement("cssSelector", ".btn-primary").click();
		snip.TakeErrorScreenShot("carouselSlide");

		System.out.println(" End PO : carouselSlide");
	}

}
