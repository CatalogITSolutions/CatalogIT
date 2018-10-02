package pageObjects;

import org.openqa.selenium.WebDriver;

public class UserAccount {

WebDriver driver;
	
	public UserAccount(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	
	}
	
	
	public void userAnalysis() {
		System.out.println("Start PO : userAnalysis");
		System.out.println(" UserAccount Page object");
		System.out.println("End PO : userAnalysis");
	}
}
