package testSuites; // Current Package

// -:--:--:--:- Importing Predefined Java class -:--:--:--:-

import java.text.SimpleDateFormat;
import java.util.Date;

// -:--:--:--:- Importing Extent Report class -:--:--:--:-

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

//-:--:--:--:- Importing Unit Testing class -:--:--:--:-

import org.testng.annotations.Test;
//import org.junit.Test;

import generalUtilities.ExReportUtility;

// -:--:--:--:- Importing local project file class -:--:--:--:-

import generalUtilities.ReadProperties;
import testCases.TestCases;

public class UnitSuites {

	TestCases tc;
	ExtentReports extentFamily;
	ExtentTest parent;
	ExtentTest childx;
	boolean flag;
	public static String xlfilepath;
	public static String propfilepath;
	public static String xmlfilepath;
	public static String xlsxfilepath;
	public static String jsonfilepath;
	ReadProperties readprop;

	public UnitSuites() {
		// TODO Auto-generated constructor stub
		propfilepath = "testData/TestData.properties";
		readprop = new ReadProperties(propfilepath);

		/*
		 * xmlfilepath ="testData/Data.xml"; xlfilepath = "testData/DataXL.xls";
		 * jsonfilepath="testData/Data.json";
		 */
		/*
		 * xlsxfilepath = readprop.readValue(xlsxfilepath); xlfilepath =
		 * readprop.readValue(xlfilepath); xmlfilepath =
		 * readprop.readValue(xmlfilepath); jsonfilepath =
		 * readprop.readValue(jsonfilepath);
		 */

		tc = new TestCases();
		// new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) +
		// "reports.html");
		extentFamily = new ExtentReports("TestReports/report.html");
		parent = extentFamily.startTest("Unit Suite", "Build Validation Test");

	}

	
	public void readfiles() {
		propfilepath = "testData/TestData.properties";
		readprop = new ReadProperties(propfilepath);
		xmlfilepath = "testData/Data.xml";
		xlfilepath = "testData/DataXL.xls";
		jsonfilepath = "testData/Data.json";
		xlsxfilepath = readprop.readValue(xlsxfilepath);
		xlfilepath = readprop.readValue(xlfilepath);
		xmlfilepath = readprop.readValue(xmlfilepath);
		jsonfilepath = readprop.readValue(jsonfilepath);
	}

	public ExtentTest defaultChild(String name, String des) {
		childx = extentFamily.startTest(name, des);
		return childx;
	}

	@Test
	public void unitPnr() {

		ExtentTest childx = defaultChild("PNR", "pnr description");
		parent.appendChild(childx);

		System.out.println(" Start ts: unitPnr");

		flag = tc.pnrStatus();
		if (flag) {
			childx.log(LogStatus.PASS, "PNR status Successfully",
					childx.addScreenCapture(tc.TakeErrorScreenShot("pnrsuccess")));
		} else {
			childx.log(LogStatus.FAIL, "Failed to PNR", childx.addScreenCapture(tc.TakeErrorScreenShot("pnrfail")));
		}
		parent.log(LogStatus.INFO, "Execution Done");
		extentFamily.flush();
		extentFamily.endTest(parent);

		System.out.println(" End ts: unitPnr");
	}

	@Test
	public void unitLogin() {
		System.out.println(" Start ts: unitLogin");

		ExtentTest childx = defaultChild("Login", "Login description");
		parent.appendChild(childx);

		flag = tc.loginToIrctc();
		if (flag) {
			childx.log(LogStatus.PASS, "Login status Successfully",
					childx.addScreenCapture(tc.TakeErrorScreenShot("Loginsuccess")));
		} else {
			childx.log(LogStatus.FAIL, "Failed to login", childx.addScreenCapture(tc.TakeErrorScreenShot("Loginfail")));
		}
		parent.log(LogStatus.INFO, "Execution Done");
		extentFamily.flush();
		extentFamily.endTest(parent);

		System.out.println(" End ts: unitLogin");
	}

	public void unitRegister() {
		System.out.println(" Start ts: unitRegister");

		ExtentTest childx = defaultChild("Register", "Register description");
		parent.appendChild(childx);

		flag = tc.registerToIrctc();
		if (flag) {
			childx.log(LogStatus.PASS, "Register status Successfully",
					childx.addScreenCapture(tc.TakeErrorScreenShot("Registersuccess")));
		} else {
			childx.log(LogStatus.FAIL, "Failed to login",
					childx.addScreenCapture(tc.TakeErrorScreenShot("Registerfail")));
		}
		parent.log(LogStatus.INFO, "Execution Done");
		extentFamily.flush();
		extentFamily.endTest(parent);

		System.out.println(" End ts: unitRegister");
	}

	@Test
	public void unitSearchTrain() {
		System.out.println(" Start ts: unitSearchTrain");

		ExtentTest childx = defaultChild("SearchTrain", "SearchTrain description");
		parent.appendChild(childx);

		flag = tc.searchTrain();
		if (flag) {
			childx.log(LogStatus.PASS, "SearchTrain status Successfully",
					childx.addScreenCapture(tc.TakeErrorScreenShot("searchsuccess")));
		} else {
			childx.log(LogStatus.FAIL, "Failed to login",
					childx.addScreenCapture(tc.TakeErrorScreenShot("searchfail")));
		}
		parent.log(LogStatus.INFO, "Execution Done");
		extentFamily.flush();
		extentFamily.endTest(parent);

		System.out.println(" End ts: unitSearchTrain");
	}

}
