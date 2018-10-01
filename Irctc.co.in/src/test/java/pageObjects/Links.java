package pageObjects;

import org.openqa.selenium.WebDriver;

public class Links {
	
WebDriver driver;
	
	public Links(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void clickOnLinks() {
		System.out.println("Start PO : clickOnLinks");
		System.out.println(" Links Page object");
		System.out.println("End PO : clickOnLinks");
	}

}
