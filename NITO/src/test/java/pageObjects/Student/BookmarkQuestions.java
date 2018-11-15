package pageObjects.Student;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.ReadProperties;

public class BookmarkQuestions {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadProperties readprop;

	public BookmarkQuestions(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readprop = new ReadProperties("testData/Data.properties");

	}
	
	 
	public void viewBookmarkQuestions() {
		System.out.println(" Start PO : bookMarkQuestions");
		System.out.println("bookMarkQuestions");
		appUts.returnAnElement("xpath", "//a[contains(text(),'BOOKMARK QUESTIONS')]").click();
		System.out.println(" End PO : bookMarkQuestions");
	}
	
	
	

}
