package testCases;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;

import generalUtilities.Snippet;
import generalUtilities.BrowserSetup;
import generalUtilities.ExReportUtility;
import generalUtilities.ReadProperties;
import generalUtilities.Readxlsx;
import pageObjects.ActionKeys;
import pageObjects.Links;
import pageObjects.Login;
import pageObjects.PnrStatus;
import pageObjects.Register;
import pageObjects.SearchTrain;
import pageObjects.UserAccount;
import pageObjects.Welcome;

public class TestCases {

	WebDriver driver;
	BrowserSetup brsetup;
	ReadProperties readprop;
	Welcome railWelc;
	Login railLogin;
	PnrStatus railPnr;
	Register railReg;
	UserAccount railUser;
	Links railLinks;
	ActionKeys railActions;
	SearchTrain railSearch;
	Snippet snip;
	ExReportUtility exRpUty;
	Readxlsx readxlsx;
	public static String xlsxfilepath;
	public static String environment;

	public TestCases() {
		// TODO Auto-generated constructor stub
		readprop = new ReadProperties("testData/TestData.properties");
		brsetup = new BrowserSetup();
		driver = brsetup.driverType();
		railWelc = new Welcome(driver);
		railLogin = new Login(driver);
		railPnr = new PnrStatus(driver);
		railReg = new Register(driver);
		railUser = new UserAccount(driver);
		railLinks = new Links(driver);
		railActions = new ActionKeys(driver);
		railSearch = new SearchTrain(driver);
		snip = new Snippet(driver);
		readxlsx = new Readxlsx(readprop.readValue("xlsxfilepath"));
		environment = readprop.readValue("environment");
		// exRpUty = new ExReportUtility(parentname, parentdesc)

	}

	public boolean registerToIrctc() {

		System.out.println(" Start tc: registerToIrctc");
		railWelc.launchApplication();
		railReg.userSignup();
		railLogin.loginToApplication();
		railLogin.logoutFromApplication();
		railWelc.closeApplication();
		System.out.println(" end tc: registerToIrctc");
		return true;
	}

	public boolean loginToIrctc() {
		System.out.println(" Start tc: loginToIrctc");
		railWelc.launchApplication();
		railLogin.loginToApplication();
		railLogin.logoutFromApplication();
		railWelc.closeApplication();
		System.out.println(" end tc: loginToIrctc");
		return true;
	}

	public boolean pnrStatus() {
		// TODO Auto-generated method stub
		railWelc.launchApplication();
		railPnr.checkPnrStatus();
		railWelc.closeApplication();
		return true;
	}

	public boolean searchTrain() {
		System.out.println(" Start tc: searchTrain");
		railWelc.launchApplication();
		railLogin.loginToApplication();
		railSearch.findTrain();
		railLogin.logoutFromApplication();
		railWelc.closeApplication();
		System.out.println(" end tc: searchTrain");
		return true;
	}

	public boolean searchAndBookTrain() {
		System.out.println(" Start tc: searchAndBookTrain");
		railWelc.launchApplication();
		// railLogin.loginToApplication();
		// railSearch.findTrain();
		// railSearch.bookTrain();
		// railLogin.logoutFromApplication();
		railWelc.closeApplication();
		System.out.println(" end testcase: searchAndBookTrain");
		return true;
	}

	public void accountActions() {
		System.out.println(" Start tc: accountActions");
		railWelc.launchApplication();
		railLogin.loginToApplication();
		railUser.userAnalysis();
		railActions.action_logoutFromApplication();
		railWelc.closeApplication();
		System.out.println(" end tc: accountActions");
	}

	public String TakeErrorScreenShot(String string) {
		// TODO Auto-generated method stub
		return snip.TakeErrorScreenShot(string);
	}

	@AfterSuite
	public void endDriver() {
		// TODO Auto-generated method stub
		driver.close();
	}

	public void dataDrivenTest() {
		// TODO Auto-generated method stub
		for (int i = 0; i < readxlsx.getRowCount(environment); i++) {

			railWelc.launchApplication();
			System.out.println("loop count" + i);
			System.out.println((readxlsx.getCellData(environment, i, 0)+readxlsx.getCellData(environment, i, 1)));
			railLogin.loginToApplicationDataDriven(readxlsx.getCellData(environment,  i, 0), readxlsx.getCellData(environment, i, 1));
			railLogin.logoutFromApplication();
			railWelc.closeApplication();
		}
	}

}
