package testCases;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

//import org.testng.annotations.Test;

import generalUtilities.Snippet;
import generalUtilities.BrowserSetup;

import generalUtilities.ReadProperties;
import generalUtilities.ReadXL;
import generalUtilities.Readxlsx;
import pageObjects.Login;

import pageObjects.Register;

import pageObjects.Welcome;

public class TestCases {

	WebDriver driver;
	BrowserSetup brsetup;
	ReadProperties readprop;
	Welcome welc;
	Login login;
	Register reg;
	Snippet snip;
	ReadXL readxl;
	Readxlsx readxlsx;
	String env;
	String xlfile = "DataDriven";
	String sheetName = "DataDriven";

	public TestCases() {
		// TODO Auto-generated constructor stub
		readprop = new ReadProperties("testData/TestData.properties");
		readxl = new ReadXL("testData/DataXL.xls");
		readxlsx = new Readxlsx("testData/XLData.xlsx");
		brsetup = new BrowserSetup();
		driver = brsetup.driverType();
		welc = new Welcome(driver);
		login = new Login(driver);
		reg = new Register(driver);
		snip = new Snippet(driver);

		env = readprop.readValue("DataDriven");

	}

	public boolean registerToApplication() {

		System.out.println(" Start tc: register");
		welc.launchApplication();
		reg.userSignup();
		login.loginToApplication();
		login.logoutFromApplication();
		welc.closeApplication();
		System.out.println(" end tc: register");
		return true;
	}

	public boolean userLogin() {
		System.out.println(" Start tc: userLogin");
		welc.launchApplication();
		login.loginToApplication();
		login.logoutFromApplication();
		welc.closeApplication();
		System.out.println(" end tc: userLogin");
		return true;
	}

	public String TakeErrorScreenShot(String string) {
		// TODO Auto-generated method stub
		return snip.TakeErrorScreenShot(string);
	}

	public void dataDrivenTest() {
		// TODO Auto-generated method stub

		for (int i = 0; i < readxlsx.getRowCount(sheetName); i++) {

			welc.launchApplication();
			System.out.println("loop count" + i);
			System.out.println(readxlsx.getRowCount(sheetName));
			System.out.println((readxlsx.getCellData(sheetName, i, 0)+readxlsx.getCellData(sheetName, i, 1)));
			// System.out.println(readxl.getCellData(xlfile, 0,
			// i)+readxl.getCellData(xlfile, 1, i));
			login.loginToApplicationDataDriven(readxlsx.getCellData(sheetName, i, 0), readxlsx.getCellData(sheetName, i, 1));
			login.logoutFromApplication();
			welc.closeApplication();

		}

	}

	/*
	 * @Test public void working() { System.out.println("Junit is working"); }
	 */

}
