package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.HoldOn;
import generalUtilities.ReadProperties;
import generalUtilities.ReadXL;
import generalUtilities.Readxlsx;
import testSuites.TestSuites;

public class Register {

	WebDriver driver;
	ApplicationUtilities appUts;
	Readxlsx readxlsx;
	static String reg = "Register";
	String xpathAdd;
	HoldOn wait;
	JavascriptExecutor js;

	public Register(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readxlsx = new Readxlsx("testData/XLData.xlsx");
		wait = new HoldOn();
		js = (JavascriptExecutor) driver;
	}

	public void userSignup() {
		System.out.println("Start PO : userSignup");
		System.out.println(" Registration Page object");
		appUts.returnAnElement("xpath", "//a[@class='ng-star-inserted'][contains(text(),'REGISTER')]").click();
		appUts.returnAnElement("id", "userName").sendKeys(readxlsx.getCellData(reg, 1, 0));
		appUts.returnAnElement("id", "usrPwd").sendKeys(readxlsx.getCellData(reg, 1, 1));
		appUts.returnAnElement("id", "cnfUsrPwd").sendKeys(readxlsx.getCellData(reg, 1, 2));
		appUts.returnAnElement("xpath",
				"//label[@class='ng-tns-c13-8 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ng-star-inserted']")
				.click();
		// span[contains(text(),'What make was your first car or bike?')]
		/*
		 * xpathAdd ="//span[contains(text(),'"; xpathAdd =
		 * xpathAdd.concat(readxlsx.getCellData(reg, 0, 4)); xpathAdd =
		 * xpathAdd.concat("')]");
		 */
		appUts.returnAnElement("xpath", getConcatxpath("//span[contains(text(),'", 0, 4)).click();
		appUts.returnAnElement("xpath", "//input[@placeholder='Security Answer']")
				.sendKeys(readxlsx.getCellData(reg, 1, 4));
		appUts.returnAnElement("xpath",
				"//label[@class='ng-tns-c13-9 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ng-star-inserted']")
				.click();
		/*
		 * xpathAdd ="//span[contains(text(),'"; xpathAdd =
		 * xpathAdd.concat(readxlsx.getCellData(reg, 1, 5)); xpathAdd =
		 * xpathAdd.concat("')]");
		 */
		appUts.returnAnElement("xpath", getConcatxpath("//span[contains(text(),'", 1, 5)).click();
		js.executeScript("window.scrollBy(0,600)");
		appUts.returnAnElement("id", "firstName").sendKeys(readxlsx.getCellData(reg, 1, 6));
		appUts.returnAnElement("id", "middleName").sendKeys(readxlsx.getCellData(reg, 1, 7));
		appUts.returnAnElement("id", "lastname").sendKeys(readxlsx.getCellData(reg, 1, 8));
		appUts.selectAnElementFromCollection("id", "M", "value", "M");

		appUts.returnAnElement("xpath", "//span[@class='ng-tns-c14-10 ui-calendar']//input[@type='text']").click();

		appUts.selectAnElementFromDropDown("xpath",
				"//select[@class='ui-datepicker-month ng-tns-c14-10 ng-star-inserted']", 6);
		/*
		 * try { Thread.sleep(2000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		wait.staticWait(2);
		appUts.selectAnElementFromDropDown("xpath",
				"//select[@class='ui-datepicker-year ng-tns-c14-10 ng-star-inserted']", "1963");
		appUts.returnAnElement("xpath",
				"//label[@class='ng-tns-c13-11 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ng-star-inserted']")
				.click();
		appUts.returnAnElement("xpath", getConcatxpath("//span[contains(text(),'", 1, 9)).click();
		appUts.selectAnElementFromCollection("xpath", "//label[@class='col-md-3 col-sm-4 col-xs-6']//input[@value='M']",
				"value", "M");
		appUts.returnAnElement("id", "email").sendKeys(readxlsx.getCellData(reg, 1, 11));
		appUts.returnAnElement("id", "mobile").sendKeys("7382878709");
		//appUts.selectAnElementFromDropDown("xpath", "//select[@class='form-control ng-touched ng-dirty ng-valid']",readxlsx.getCellData(reg, 1, 13));
		js.executeScript("window.scrollBy(0,600)");
		appUts.returnAnElement("id", "resAddress1").sendKeys(readxlsx.getCellData(reg, 1, 15));
		appUts.returnAnElement("id", "resAddress2").sendKeys(readxlsx.getCellData(reg, 1, 16));
		appUts.returnAnElement("id", "resAddress3").sendKeys(readxlsx.getCellData(reg, 1, 17));
		appUts.returnAnElement("id", "resPinCode").sendKeys(readxlsx.getCellData(reg, 1, 18));
		appUts.returnAnElement("id", "	resState").click();
		appUts.selectAnElementFromDropDown("xpath", "//select[@class='form-control ng-pristine ng-invalid ng-touched']",
				readxlsx.getCellData(reg, 1, 19));
		appUts.selectAnElementFromDropDown("xpath", "//select[@class='form-control ng-pristine ng-invalid ng-touched']",
				readxlsx.getCellData(reg, 1, 20));
		appUts.returnAnElement("id", "resPhone").sendKeys(readxlsx.getCellData(reg, 1, 12));
		appUts.selectAnElementFromCollection("xpath", "//div[@class='col-md-1 col-sm-1 col-xs-12 inlineBlock']//input[@value='Y']",
				"value", "Y");
		wait.staticWait(15);
		appUts.returnAnElement("xpath", "//input[@class='ng-touched ng-dirty ng-valid']").click();
		appUts.returnAnElement("xpath", "//b[text()='REGISTER']").click();
		System.out.println("End PO : userSignup");
	}

	public String getConcatxpath(String tag, int col, int row) {
		xpathAdd = tag;
		xpathAdd = xpathAdd.concat(readxlsx.getCellData(reg, col, row));
		xpathAdd = xpathAdd.concat("')]");
		return xpathAdd;
	}

}
