package pageObjects.Student;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.CacheLookup;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.HoldOn;
import generalUtilities.ReadProperties;
import generalUtilities.Readxlsx;

public class StLoginPageFactory {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadProperties readprop;
	Readxlsx readxlsx;
	HoldOn wait;

	public StLoginPageFactory(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readprop = new ReadProperties("testData/Data.properties");
		readxlsx = new Readxlsx("testData/Dataxlsx.xlsx");
		wait = new HoldOn();
		PageFactory.initElements(driver, this);
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

	@FindBy(id = "username")
	@CacheLookup
	WebElement userName;

	// @FindBy(id = "password")

	@FindBy(how = How.ID, using = "password")
	@CacheLookup
	WebElement passWord;

	/*
	 * @FindBy(how = How.XPATH, using = "//button[text()='Sign In']")
	 * 
	 * @CacheLookup WebElement signBtn1;
	 */

	@FindBy(xpath = "//button[text()='Sign In']")
	@CacheLookup
	WebElement signBtn;

	public void loginToStudentUsingPageFactory() {
		System.out.println(" Start PO : loginToStudentUsingPageFactory");
		System.out.println("loginToStudent");
		userName.sendKeys(readxlsx.getCellData("Student", 0, 1));
		passWord.sendKeys(readxlsx.getCellData("Student", 1, 1));
		signBtn.click();

		System.out.println(" End PO : loginToStudentUsingPageFactory");
	}

	public void loginToStudentUsingUserNameMethod() {
		System.out.println(" Start PO : loginToStudentUsingUserNameMethod");

		userName.sendKeys(readxlsx.getCellData("Student", 0, 1));

		System.out.println(" End PO : loginToStudentUsingUserNameMethod");
	}

	public void loginToStudentUsingPassWordMethod() {
		System.out.println(" Start PO : loginToStudentUsingUserNameMethod");

		passWord.sendKeys(readxlsx.getCellData("Student", 1, 1));

		System.out.println(" End PO : loginToStudentUsingUserNameMethod");
	}

	public void loginToStudentUsingSignInButtonMethod() {
		System.out.println(" Start PO : loginToStudentUsingUserNameMethod");

		signBtn.click();

		System.out.println(" End PO : loginToStudentUsingUserNameMethod");
	}

}
