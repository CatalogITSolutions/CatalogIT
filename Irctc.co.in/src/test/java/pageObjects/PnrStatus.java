package pageObjects;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.ReadProperties;
import generalUtilities.ReadXL;
import testSuites.TestSuites;

public class PnrStatus {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadXL readxl;
	ReadProperties readprop;

	public PnrStatus(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readxl = new ReadXL(TestSuites.xlfilepath);
		readprop = new ReadProperties("testData/TestData.properties");
		
	}

	public void checkPnrStatus() {
		System.out.println("Start PO : checkPnrStatus");
		System.out.println("Check PNR Status ");

		appUts.returnAnElement("xpath", "//label[@class='search_btn']").click();
		Set<String> windows = driver.getWindowHandles();
		ArrayList<String> myWindows = new ArrayList<String>(windows);
		for (int i = 0; i < myWindows.size(); i++) {
			System.out.println(myWindows.get(i));
		}
		System.out.println("Browser 1:" + driver.getTitle());
		driver.switchTo().window(myWindows.get(1));
	//	appUts.returnAnElement("id", "inputPnrNo").sendKeys("4446572690");
		appUts.returnAnElement("id", "inputPnrNo").sendKeys(readprop.readValue("PNR"));
    	// driver.findElement(By.id("inputPnrNo")).sendKeys(readxl.getCellData("PNR", 1, 0));
		appUts.returnAnElement("id", "modal1").click();
		// driver.findElement(By.xpath("//label[@class='search_btn']")).click();
		try {
			//driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			Thread.sleep(10000);
			appUts.returnAnElement("id", "submitPnrNo").click();
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println("End PO : checkPnrStatus");
		
	}

}
