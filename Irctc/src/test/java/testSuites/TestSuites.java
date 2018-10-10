package testSuites; // Current Package

// -:--:--:--:- Importing Predefined Java class -:--:--:--:-

import java.text.SimpleDateFormat;
import java.util.Date;

// -:--:--:--:- Importing Extent Report class -:--:--:--:-

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//-:--:--:--:- Importing Unit Testing class -:--:--:--:-

import org.testng.annotations.Test;
//import org.junit.Test;

import generalUtilities.ExReportUtility;

// -:--:--:--:- Importing local project file class -:--:--:--:-

import generalUtilities.ReadProperties;
import testCases.TestCases;

public class TestSuites {
	ReadProperties readprop;
	TestCases tc;
	ExtentReports extentFamily;
	ExtentTest parent;
	ExtentTest child1;
	ExtentTest child2;
	ExtentTest child3;
	ExtentTest childx;
	boolean flag;
	public static String xlfilepath;
	public static String propfilepath;
	public static String xmlfilepath;
	ExReportUtility exRp;

	public TestSuites() {
		// TODO Auto-generated constructor stub
		propfilepath = "testData/TestData.properties";
		xmlfilepath ="testData/Data.xml";
		xlfilepath = "testData/DataXL.xls";
		readprop = new ReadProperties(propfilepath);
		tc = new TestCases();
		
		// new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) +
		// "reports.html");
		extentFamily = new ExtentReports("TestReports/report.html");
		parent = extentFamily.startTest("Regression Suite", "Build Validation Test");
		child1 = extentFamily.startTest("1.User Login", "Des:login with vaild data");
		child2 = extentFamily.startTest("2.Search Book Train", "Des:Search and book train");
		child3 = extentFamily.startTest("3.PNR Status", "Des:Check PNR Status");

	}

	public ExtentTest defaultChild(String name, String des) {
		childx = extentFamily.startTest(name, des);
		return childx;
	}

	@Test
	public void runUserChoice() {
		if (readprop.readValue("testingType").equalsIgnoreCase("SMOKE")) {
			smokeSuite();
		} else if (readprop.readValue("testingType").equalsIgnoreCase("REGRESSION")) {
			regressionSuite();
		} else {
			smokeSuite();
		}

	}

	public void regressionSuite() {
		// TODO Auto-generated method stub
		parent.appendChild(child1);
		parent.appendChild(child2);
		parent.appendChild(child3);

		System.out.println(" Start ts: regressionSuite");

		flag = tc.loginToIrctc();
		if (flag) {
			child1.log(LogStatus.PASS, "Step name: User Login", "Result: Login Successfully");
		} else {
			child1.log(LogStatus.FAIL, "Failed to login", child1.addScreenCapture(tc.TakeErrorScreenShot("login")));
		}

		flag = tc.searchAndBookTrain();
		if (flag) {
			child2.log(LogStatus.PASS, "Step name: Search and Book",
					"Result: Login, search and book train successfully");
		} else {
			child2.log(LogStatus.FAIL, "Failed to Book", child2.addScreenCapture(tc.TakeErrorScreenShot("Search")));
		}

		flag = tc.pnrStatus();
		if (flag) {
			child3.log(LogStatus.PASS, "Step name: PNR Status", "Result: Pnr status checked successfully");
		} else {
			child3.log(LogStatus.FAIL, "Failed to Pnr", child3.addScreenCapture(tc.TakeErrorScreenShot("Pnr")));
		}

		parent.log(LogStatus.INFO, "Execution Done");
		extentFamily.flush();
		extentFamily.endTest(parent);

		System.out.println(" End ts: regressionSuite");
	}

	public void smokeSuite() {
		// TODO Auto-generated method stub
		System.out.println(" Start ts: smokeSuite");
		tc.registerToIrctc();
		tc.loginToIrctc();
		tc.searchTrain();
		tc.searchAndBookTrain();
		tc.pnrStatus();
		tc.accountActions();
		System.out.println(" End ts: smokeSuite");
	}
	
	
	public void datadrivenSuite() {
		tc.dataDrivenTest();
	}

}
