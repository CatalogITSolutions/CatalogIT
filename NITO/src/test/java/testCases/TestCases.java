package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import generalUtilities.Snippet;
import pageObjects.Admin.Dashboard;
import pageObjects.Admin.Login;
import pageObjects.Admin.Welcome;
import pageObjects.Student.BookmarkQuestions;
import pageObjects.Student.Profile;
import pageObjects.Student.Rank;
import pageObjects.Student.Result;
import pageObjects.Student.SPA;
import pageObjects.Student.StLogin;
import pageObjects.Student.StartTest;
import generalUtilities.BrowserSetup;
import generalUtilities.ReadProperties;
import generalUtilities.Readxlsx;

public class TestCases {

	WebDriver driver;
	BrowserSetup brsetup;
	ReadProperties readprop;
	Readxlsx readxlsx;
	Welcome welc;
	Login login;
	Snippet snip;
	Dashboard dash;

	/* --- Student Variable ------- */
	StLogin stlogin;
	StartTest stTest;
	BookmarkQuestions stBookmark;
	SPA stSPA;
	Profile stProfile;
	Rank stRank;
	Result stResult;

	public TestCases() {
		// TODO Auto-generated constructor stub
		readprop = new ReadProperties("testData/Data.properties");
		readxlsx = new Readxlsx("testData/Dataxlsx.xlsx");
		brsetup = new BrowserSetup();
		driver = brsetup.driverType();
		welc = new Welcome(driver);
		login = new Login(driver);
		snip = new Snippet(driver);
		dash = new Dashboard(driver);
		/* --- Student Page objects ------- */
		stlogin = new StLogin(driver);
		stTest = new StartTest(driver);
		stBookmark = new BookmarkQuestions(driver);
		stSPA = new SPA(driver);
		stProfile = new Profile(driver);
		stRank = new Rank(driver);
		stResult = new Result(driver);
	}

	public boolean goToApplication() {
		welc.launchApplication();
		login.loginToApplication();
		login.switchWindow();
		// login.logoutFromApplication();
		// dash.selectState();
		return true;
	}

	// /// //// ///// ========== Student TestCases ==========================

	public boolean studentLoginAndLogout() {
		welc.launchApplication();
		stlogin.loginToStudent();
		stlogin.switchWindow();
		stlogin.logoutFromStudent();
		// dash.selectState();
		return true;
	}

	public boolean studentStartTest() {
		welc.launchApplication();
		stlogin.loginToStudent();
		stlogin.switchWindow();
		stTest.viewStartTest();
		stlogin.logoutFromStudent();
		return true;
	}

	public boolean studentBookmarkQuestions() {
		welc.launchApplication();
		stlogin.loginToStudent();
		stlogin.switchWindow();
		stBookmark.viewBookmarkQuestions();
		stlogin.logoutFromStudent();
		endDriver();
		return true;
	}

	public boolean studentSPA() {
		welc.launchApplication();
		stlogin.loginToStudent();
		stlogin.switchWindow();
		stSPA.viewSPA();
		stlogin.logoutFromStudent();
		endDriver();
		return true;
	}

	public boolean studentProfile() {
		welc.launchApplication();
		stlogin.loginToStudent();
		stlogin.switchWindow();
		stProfile.editProfile();
		stlogin.logoutFromStudent();
		endDriver();
		return true;
	}

	public boolean studentPassword() {
		welc.launchApplication();
		stlogin.loginToStudent();
		stlogin.switchWindow();
		stProfile.changePassword();
		stlogin.logoutFromStudent();
		endDriver();
		return true;
	}

	public String TakeErrorScreenShot(String string) {
		// TODO Auto-generated method stub
		return snip.TakeErrorScreenShot(string);
	}

	public void endDriver() {
		// TODO Auto-generated method stub
		driver.quit();
	}

	String sheetName = "StudentDataDriven";

	public void studentDataDrivenTestCase() {
		// TODO Auto-generated method stub

		for (int i = 0; i < readxlsx.getRowCount(sheetName); i++) {

			welc.launchApplication();
			System.out.println("loop count" + i);
			System.out.println(readxlsx.getRowCount(sheetName));
			System.out.println((readxlsx.getCellData(sheetName, i, 0) + readxlsx.getCellData(sheetName, i, 1)));
			// System.out.println(readxl.getCellData(xlfile, 0,
			// i)+readxl.getCellData(xlfile, 1, i));
			stlogin.loginToStudentDataDriven(readxlsx.getCellData(sheetName, i, 0),
					readxlsx.getCellData(sheetName, i, 1));
			stlogin.switchWindow();
			stlogin.logoutFromStudentDataDriven();
			welc.closeApplication();

		}
	}

}
