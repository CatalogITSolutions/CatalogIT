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

	public TestSuites() {
		// TODO Auto-generated constructor stub
		propfilepath = "testData/Data.properties";
		xmlfilepath = "testData/Dataxml.xml";
		xlfilepath = "testData/Dataxl.xls";
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

		flag = tc.goToApplication();
		if (flag) {
			child1.log(LogStatus.PASS, "Step name: User Login", "Result: Login Successfully");
		} else {
			child1.log(LogStatus.FAIL, "Failed to login", child1.addScreenCapture(tc.TakeErrorScreenShot("login")));
		}

		parent.log(LogStatus.INFO, "Execution Done");
		extentFamily.flush();
		extentFamily.endTest(parent);

		System.out.println(" End ts: regressionSuite");
	}

	public void smokeSuite() {
		// TODO Auto-generated method stub
		System.out.println(" Start ts: smokeSuite");

		System.out.println(" End ts: smokeSuite");
	}

}
