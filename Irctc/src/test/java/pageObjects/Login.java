package pageObjects;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.ReadProperties;
import generalUtilities.Readjson;

public class Login {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadProperties readprop;
	Readjson readjson;

	public Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readprop = new ReadProperties("testData/TestData.properties");
		readjson = new Readjson("testData/Data.json");
	}

	@BeforeMethod
	public void beforeLoginToApplication() {
		// driver.findElement(By.id("loginText")).click();
		// driver.manage().window().maximize();
	}

	public void loginToApplication() {
		System.out.println(" Start PO : loginToApplication");
		System.out.println("loginToApplication");

		// driver.findElement(By.id("loginText")).click();

		appUts.returnAnElement("id", "loginText").click();
		appUts.returnAnElement("id", "userId").sendKeys(readjson.getData("username"));
		appUts.returnAnElement("id", "pwd").sendKeys(readjson.getData( "password"));
//		appUts.returnAnElement("id", "userId").sendKeys(readprop.readValue("RailUserName"));
	//	appUts.returnAnElement("id", "pwd").sendKeys(readprop.readValue("RailPassword"));
		try {
			// driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			Thread.sleep(15000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		appUts.returnAnElement("xpath", "//button[contains(text(),'SIGN IN')]").click();
		try {
			// driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(" End PO : loginToApplication");
	}

	public void logoutFromApplication() {
		System.out.println(" Start PO : logoutFromApplication");
		System.out.println("logoutFromApplication");

		appUts.returnAnElement("xpath", "//a[@class='a ng-star-inserted']//span[contains(text(),'Logout')]").click();
		System.out.println(" End PO : logoutFromApplication");

	}

	public void loginToApplicationDataDriven(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println(" Start PO : loginToApplication");
		System.out.println("loginToApplication");

		appUts.returnAnElement("id", "loginText").click();
		appUts.returnAnElement("id", "userId").sendKeys(username);
		appUts.returnAnElement("id", "pwd").sendKeys(password);
    
		try {
			// driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			Thread.sleep(15000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		appUts.returnAnElement("xpath", "//button[contains(text(),'SIGN IN')]").click();
		try {
			// driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(" End PO : loginToApplication");
	}

}
