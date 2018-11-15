package pageObjects.Student;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.ReadProperties;
import generalUtilities.Readxml;
import generalUtilities.Snippet;
import testSuites.TestSuites;

public class Profile {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadProperties readprop;
	Readxml readxml;
	Snippet snip;

	public Profile(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readprop = new ReadProperties("testData/Data.properties");
		readxml = new Readxml(TestSuites.xmlfilepath);
		snip = new Snippet(driver);
	}

	public void editProfile() {
		System.out.println(" Start PO : editProfile");
		appUts.returnAnElement("xpath", "//a[contains(text(),'PROFILE')]").click();
		appUts.returnAnElement("xpath", "//a[text()='EDIT']").click();
		appUts.returnAnElement("name", "firstname").clear();
		appUts.returnAnElement("name", "firstname")
				.sendKeys(readxml.getMenuData("ChangeFirstName", "/Student/editprofile[@id='1']/FirstName"));
		appUts.returnAnElement("name", "lastname").clear();
		appUts.returnAnElement("name", "lastname")
				.sendKeys(readxml.getMenuData("ChangeLastName", "/Student/editprofile[@id='1']/LastName"));
		appUts.returnAnElement("xpath", "//input[@value='Update']").click();
		System.out.println(" End PO : editProfile");
	}

	public void changePassword() {
		System.out.println(" Start PO : changePassword");
		appUts.returnAnElement("xpath", "//a[contains(text(),'PROFILE')]").click();
		appUts.returnAnElement("xpath", "//a[contains(text(),'Change Password')]").click();
		appUts.returnAnElement("id", "password")
				.sendKeys(readxml.getMenuData("ChangePassword", "/Student/changepassword[@id='1']/Cpassword"));
		appUts.returnAnElement("id", "changePassword")
				.sendKeys(readxml.getMenuData("NewPassword", "/Student/changepassword[@id='1']/Npassword"));
		appUts.returnAnElement("id", "reenterpassword")
				.sendKeys(readxml.getMenuData("RepeatPassword", "/Student/changepassword[@id='1']/Rpassword"));
		appUts.returnAnElement("xpath", "//button[@id='popup']").click();
		snip.TakeErrorScreenShot("cpassword");
		System.out.println(" End PO : changePassword");
	}

}
