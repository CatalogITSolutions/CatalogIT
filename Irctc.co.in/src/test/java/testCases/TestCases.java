package testCases;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.Test;

import generalUtilities.Snippet;
import generalUtilities.BrowserSetup;
import generalUtilities.ExReportUtility;
import generalUtilities.ReadProperties;
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
		//exRpUty = new ExReportUtility(parentname, parentdesc)
		
	}

	public void registerToIrctc() {

		System.out.println(" Start tc: registerToIrctc");
		railWelc.launchApplication();
		railReg.userSignup();
		railLogin.loginToApplication();
		railLogin.logoutFromApplication();
		railWelc.closeApplication();
		System.out.println(" end tc: registerToIrctc");
	}

	@Test
	public boolean userLogin() {
		System.out.println(" Start tc: userLogin");
		railWelc.launchApplication();
		railLogin.loginToApplication();
		railLogin.logoutFromApplication();
		railWelc.closeApplication();
		System.out.println(" end tc: userLogin");
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

	public void searchTrain() {
		System.out.println(" Start tc: searchTrain");
		railWelc.launchApplication();
		railLogin.loginToApplication();
		railSearch.findTrain();
		railLogin.logoutFromApplication();
		railWelc.closeApplication();

		System.out.println(" end tc: searchTrain");
	}

	public boolean searchAndBookTrain() {
		System.out.println(" Start tc: searchAndBookTrain");
		railWelc.launchApplication();
		railLogin.loginToApplication();
		railSearch.findAndBookTrain();
		railLogin.logoutFromApplication();
		railWelc.closeApplication();
		System.out.println(" end testcase: searchAndBookTrain");
		return true;
	}

	public boolean pnrStatusCheck() {
		System.out.println(" Start testcase: pnrStatusCheck");
		railWelc.launchApplication();
		railPnr.checkPnrStatus();
		railWelc.closeApplication();
		System.out.println(" end tc: pnrStatusCheck");
		return true;
	}

	public String TakeErrorScreenShot(String string) {
		// TODO Auto-generated method stub
		return snip.TakeErrorScreenShot(string);
	}

	public boolean forUnit() {
		// TODO Auto-generated method stub
		railWelc.launchApplication();
	//	railPnr.checkPnrStatus();
		railLogin.loginToApplication();
		railLogin.logoutFromApplication();
		return true;
	}
	
	public boolean forUnit2() {
		// TODO Auto-generated method stub
		railWelc.launchApplication();
	railPnr.checkPnrStatus();
		
		return true;
	}
	
	
	public boolean forRegister() {
		// TODO Auto-generated method stub
		railWelc.launchApplication();
		railReg.userSignup();
		return true;
	}
	
	
	/*
	 * @Test public void working() { System.out.println("Junit is working"); }
	 */

}
