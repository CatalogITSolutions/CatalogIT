package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import applicationUtilities.ApplicationUtilities;

public class ActionKeys {
	WebDriver driver;
	ApplicationUtilities appUts;
	Actions builder;
	public ActionKeys(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
	}
	
	
	public void actionClass() {
		System.out.println("Start PO : actionClass");
		System.out.println(" Action Page object");
		System.out.println("End PO : actionClass");
		 builder = new Actions(driver);
	}
	
	public void action_logoutFromApplication() {
		System.out.println(" Start PO : logoutFromApplication");
		System.out.println("logoutFromApplication");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement element = appUts.returnAnElement("xpath", "//a[contains(text(),'MY ACCOUNT')]");
		builder.moveToElement(element).perform();
		//builder.moveToElement(appUts.returnAnElement("xpath", "//a[contains(text(),'MY ACCOUNT')]")).sendKeys(Keys.ARROW_DOWN).build().perform();
		appUts.returnAnElement("xpath", "//ul[@class='loginDropBox box-shadow']//span[@class='list_text'][contains(text(),'Logout')]").click();
		
		
		System.out.println(" End PO : logoutFromApplication");
	}

}
