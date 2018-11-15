package pageObjects.Student;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.ReadProperties;

public class Result {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadProperties readprop;

	public Result(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readprop = new ReadProperties("testData/Data.properties");

	}

	public void viewResult() {
		System.out.println(" Start PO : viewResult");
		System.out.println("viewResult");

		System.out.println(" End PO : viewResult");
	}

}
