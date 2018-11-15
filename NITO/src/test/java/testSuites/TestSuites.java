package testSuites; // Current Package

// -:--:--:--:- Importing Predefined Java class -:--:--:--:-

import java.text.SimpleDateFormat;
import java.util.Date;

// -:--:--:--:- Importing Extent Report class -:--:--:--:-

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.AfterMethod;

//-:--:--:--:- Importing Unit Testing class -:--:--:--:-

import org.testng.annotations.Test;
//import org.junit.Test;

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
	public static String xlsxfilepath;

	public TestSuites() {
		// TODO Auto-generated constructor stub
		propfilepath = "testData/Data.properties";
		xmlfilepath = "testData/Dataxml.xml";
		xlfilepath = "testData/Dataxl.xls";
		xlsxfilepath = "testData/Dataxlsx.xlsx";
		readprop = new ReadProperties(propfilepath);
		tc = new TestCases();

		// new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) +
		// "reports.html");
		extentFamily = new ExtentReports("TestReports/report.html");
		parent = extentFamily.startTest("Regression Suite", "Build Validation Test");
		// child1 = extentFamily.startTest("Admin Login", "Admin login in electus 2");
		// child2 = extentFamily.startTest("studentLoginAndLogout",
		// "studentLoginAndLogout");
		// child3 = extentFamily.startTest("", "");

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

		System.out.println(" Start ts: regressionSuite");

		System.out.println(" End ts: regressionSuite");
	}

	public void smokeSuite() {
		// TODO Auto-generated method stub
		System.out.println(" Start ts: smokeSuite");
		parent.appendChild(childx);
		flag = tc.goToApplication();
		if (flag) {
			child1.log(LogStatus.PASS, "Step name: Admin Login", "Result: Login Successfully");
		} else {
			child1.log(LogStatus.FAIL, "Failed to login", child1.addScreenCapture(tc.TakeErrorScreenShot("login")));
		}

		parent.log(LogStatus.INFO, "Execution Done");
		extentFamily.flush();
		extentFamily.endTest(parent);
		System.out.println(" End ts: smokeSuite");
	}

	@Test
	public void unitSuite() {
		// TODO Auto-generated method stub
		System.out.println(" Start ts: unitSuite");
		childx = defaultChild("studentLoginAndLogout ", "studentLoginAndLogout page");
		parent.appendChild(childx);
		flag = tc.studentLoginAndLogout();
		if (flag) {
			childx.log(LogStatus.PASS, "Step name: studentLoginAndLogout", "Result: Login Successfully");
		} else {
			childx.log(LogStatus.FAIL, "Failed to login", childx.addScreenCapture(tc.TakeErrorScreenShot("login")));
		}

		parent.log(LogStatus.INFO, "Execution Done");
		extentFamily.flush();
		extentFamily.endTest(parent);
		System.out.println(" End ts: unitSuite");
	}

	@Test
	public void unitSuite2() {
		// TODO Auto-generated method stub
		System.out.println(" Start ts: unitSuite2");
		childx = defaultChild("Start Test", "Student Start Test page");
		parent.appendChild(childx);
		flag = tc.studentStartTest();
		if (flag) {
			childx.log(LogStatus.PASS, "Step name: Student Start Test",
					childx.addScreenCapture(tc.TakeErrorScreenShot("sttest")));
		} else {
			childx.log(LogStatus.FAIL, "Failed to login", childx.addScreenCapture(tc.TakeErrorScreenShot("sttest")));
		}
		String name = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println("Method Name:" + name);
		parent.log(LogStatus.INFO, "Execution Done");
		extentFamily.flush();
		extentFamily.endTest(parent);
		System.out.println(" End ts: unitSuite2");
	}

	@Test
	public void unitSuite3() {
		// TODO Auto-generated method stub
		System.out.println(" Start ts: unitSuite3");
		childx = defaultChild("BookMark Questions", "Student BookMark Questions page");
		parent.appendChild(childx);
		flag = tc.studentBookmarkQuestions();
		if (flag) {
			childx.log(LogStatus.PASS, "Step name: BookMark Questions", "BookMark Questions completed");
		} else {
			childx.log(LogStatus.FAIL, "Failed to login", childx.addScreenCapture(tc.TakeErrorScreenShot("stbook")));
		}

		parent.log(LogStatus.INFO, "Execution Done");
		extentFamily.flush();
		extentFamily.endTest(parent);
		System.out.println(" End ts: unitSuite3");
	}

	@Test
	public void unitSuite4() {
		// TODO Auto-generated method stub
		System.out.println(" Start ts: unitSuite4");
		childx = defaultChild("SPA ", "Student SPA page");
		parent.appendChild(childx);
		flag = tc.studentSPA();
		if (flag) {
			childx.log(LogStatus.PASS, "Step name: SPA", "SPA completed");
		} else {
			childx.log(LogStatus.FAIL, "Failed to SPA", childx.addScreenCapture(tc.TakeErrorScreenShot("SPA")));
		}

		parent.log(LogStatus.INFO, "Execution Done");
		extentFamily.flush();
		extentFamily.endTest(parent);
		System.out.println(" End ts: unitSuite4");
	}

	@Test
	public void unitSuite5() {
		// TODO Auto-generated method stub
		System.out.println(" Start ts: unitSuite5");
		childx = defaultChild(" Profile ", "Student Profile page");
		parent.appendChild(childx);
		flag = tc.studentProfile();
		if (flag) {
			childx.log(LogStatus.PASS, "Step name: Student Profile", "Student Profile completed");
		} else {
			childx.log(LogStatus.FAIL, "Failed to Stduent Profile",
					childx.addScreenCapture(tc.TakeErrorScreenShot("profile")));
		}

		parent.log(LogStatus.INFO, "Execution Done");
		extentFamily.flush();
		extentFamily.endTest(parent);
		System.out.println(" End ts: unitSuite5");
	}

	@Test
	public void unitSuite6() {
		// TODO Auto-generated method stub
		System.out.println(" Start ts: unitSuite6");
		childx = defaultChild(" Change Password ", "Student Change Password page");
		parent.appendChild(childx);
		flag = tc.studentPassword();
		if (flag) {
			childx.log(LogStatus.PASS, "Step name: Student Change Password", "Student Change Password completed");
		} else {
			childx.log(LogStatus.FAIL, "Failed to Stduent Profile",
					childx.addScreenCapture(tc.TakeErrorScreenShot("password")));
		}

		parent.log(LogStatus.INFO, "Execution Done");
		extentFamily.flush();
		extentFamily.endTest(parent);
		System.out.println(" End ts: unitSuite6");
	}
	
	/*   *************  Student Data Driven Testsuite ***************   */
	
	@Test
	public void studentDataDrivenTestSuite() {
		tc.studentDataDrivenTestCase();
	}

}
