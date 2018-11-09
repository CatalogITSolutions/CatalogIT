package testCases;


import org.openqa.selenium.WebDriver;


import org.testng.annotations.AfterSuite;

import generalUtilities.Snippet;
import generalUtilities.BrowserSetup;
import generalUtilities.ReadProperties;
import pageObjects.Dashboard;
import pageObjects.Login;
//import pageObjects.Register;
import pageObjects.Welcome;

public class TestCases {

	WebDriver driver;
	BrowserSetup brsetup;
	ReadProperties readprop;
	Welcome welc;
	Login login;
//	Register reg;
	Snippet snip;
	Dashboard dash;

	public TestCases() {
		// TODO Auto-generated constructor stub
		readprop = new ReadProperties("testData/Data.properties");
		brsetup = new BrowserSetup();
		driver = brsetup.driverType();
		welc = new Welcome(driver);
		login = new Login(driver);
	//	reg = new Register(driver);
		snip = new Snippet(driver);
		dash = new Dashboard(driver);

	}
	
	public boolean goToApplication() {
		welc.launchApplication();
		login.loginToApplication();
		login.switchWindow();
	//	login.logoutFromApplication();
	//	dash.selectState();
		return true;
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

}
