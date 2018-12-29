package pageObjects.Student;

import org.openqa.selenium.WebDriver;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.ReadProperties;

public class Rank {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadProperties readprop;

	public Rank(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readprop = new ReadProperties("testData/Data.properties");

	}

	public void viewRank() {
		System.out.println(" Start PO : viewRank");
		System.out.println("viewRank");
		appUts.returnAnElement("xpath", "//a[contains(text(),'RANKS')]").click();
		appUts.returnAnElement("xpath", "//button[@value='QUATERLY']").click();
		
		System.out.println(" End PO : viewRank");
	}

}
