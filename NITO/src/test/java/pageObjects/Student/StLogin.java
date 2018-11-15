package pageObjects.Student;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.HoldOn;
import generalUtilities.ReadProperties;
import generalUtilities.Readxlsx;

public class StLogin {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadProperties readprop;
	Readxlsx readxlsx;
	HoldOn wait;

	public StLogin(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readprop = new ReadProperties("testData/Data.properties");
		readxlsx = new Readxlsx("testData/Dataxlsx.xlsx");
		wait = new HoldOn();
	}

	@BeforeMethod
	public void beforeLoginToApplication() {
		// driver.findElement(By.id("loginText")).click();
		// driver.manage().window().maximize();
	}

	public void loginToStudent() {
		System.out.println(" Start PO : loginToStudent");
		System.out.println("loginToStudent");
		appUts.returnAnElement("id", "username").sendKeys(readxlsx.getCellData("Student", 0, 1));
		appUts.returnAnElement("id", "password").sendKeys(readxlsx.getCellData("Student", 1, 1));
		appUts.returnAnElement("xpath", "//button[text()='Sign In']").click();

		System.out.println(" End PO : loginToStudent");
	}

	public void switchWindow() {
		System.out.println(" Start PO : switchWindow");
		System.out.println("switchWindow");
		// String mulWindow = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		// driver.switchTo().window(mulWindow);
		System.out.println(" End PO : switchWindow");
	}

	public void logoutFromStudent() {
		// TODO Auto-generated method stub
		System.out.println(" Start PO : logoutFromStudent");
		System.out.println("logoutFromStudent");

		appUts.returnAnElement("xpath", "//a[@class='dropdown-toggle']").click();
		appUts.returnAnElement("xpath", "//ul[@class='dropdown-menu dropdown-user']//li//a[@href='logout']").click();
		// appUts.returnAnElement("xpath",
		// "//ul[@id='side-menu']//li//a[@href='logout']").click();
		// appUts.returnAnElement("xpath", "//a[contains(text(),'LOGOUT')]").click();
		System.out.println(" End PO : logoutFromStudent");
	}

	public void loginToStudentDataDriven(String uName, String pWord) {
		// TODO Auto-generated method stub
		System.out.println(" Start PO : loginToStudentDataDriven");
		System.out.println("loginToStudentDataDriven");
		appUts.returnAnElement("id", "username").sendKeys(uName);
		appUts.returnAnElement("id", "password").sendKeys(pWord);
		appUts.returnAnElement("xpath", "//button[text()='Sign In']").click();

		System.out.println(" End PO : loginToStudentDataDriven");

	}

	public void logoutFromStudentDataDriven() {
		// TODO Auto-generated method stub
		System.out.println(" Start PO : logoutFromStudentDataDriven");
		System.out.println("logoutFromStudentDataDriven");

		wait.staticWait(2);

		appUts.returnAnElement("xpath", "//a[contains(text(),'LOGOUT')]").click();
		System.out.println(" End PO : logoutFromStudent");
	}

}
