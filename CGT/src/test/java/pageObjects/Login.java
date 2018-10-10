package pageObjects;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.ReadProperties;

public class Login {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadProperties readprop;

	public Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readprop = new ReadProperties("testData/TestData.properties");

	}

	@BeforeMethod
	public void beforeLoginToApplication() {
		// driver.findElement(By.id("loginText")).click();
		// driver.manage().window().maximize();
	}

	public void loginToApplication() {
		System.out.println(" Start PO : loginToApplication");
		System.out.println("loginToApplication");

		
		System.out.println(" End PO : loginToApplication");
	}

	public void logoutFromApplication() {
		System.out.println(" Start PO : logoutFromApplication");
		
		appUts.returnAnElement("id","welcome").click();
		appUts.returnAnElement("xpath","//a[text()='Logout']").click();

		System.out.println(" End PO : logoutFromApplication");

	}

	public void loginToApplicationDataDriven(String uName,String pWord) {
		// TODO Auto-generated method stub
		System.out.println("username = "+uName);
		System.out.println("password = "+pWord);
	
		appUts.returnAnElement("id","txtUsername").sendKeys(uName);
		appUts.returnAnElement("id","txtPassword").sendKeys(pWord);
		appUts.returnAnElement("id","btnLogin").click();
	}

}
