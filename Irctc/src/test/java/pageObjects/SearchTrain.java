package pageObjects;

import org.openqa.selenium.WebDriver;

import applicationUtilities.ApplicationUtilities;

public class SearchTrain {
	
	WebDriver driver;
	ApplicationUtilities appUts;

	
	public SearchTrain(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		appUts = new ApplicationUtilities(driver);
		
	}
	
	
	
	public void findAndBookTrain() {
		System.out.println("Start PO : findAndBookTrain");
		System.out.println("SearchTrain Page Objects");
		System.out.println("End PO : findAndBookTrain");
		
	}



	public void findTrain() {
		// TODO Auto-generated method stub
		
	}



	public void bookTrain() {
		// TODO Auto-generated method stub
		
	}


}
