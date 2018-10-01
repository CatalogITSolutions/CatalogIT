package testSuites;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

//import org.testng.annotations.Test;

import generalUtilities.ReadProperties;
import testCases.TestCases;





public class TestSuites2 {
	ReadProperties readprop;
	TestCases tc;
	ExtentReports extentFamily;
	ExtentTest parent;

	
	public TestSuites2() {
		// TODO Auto-generated constructor stub
		readprop = new ReadProperties("testData/TestData.properties");
		tc = new TestCases();
		extentFamily = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
		parent = extentFamily.startTest("Smoke Suite");
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
		tc.userLogin();
		tc.searchAndBookTrain();
		tc.pnrStatusCheck();
		System.out.println(" End ts: regressionSuite");
	}

	public void smokeSuite() {
		// TODO Auto-generated method stub
		System.out.println(" Start ts: smokeSuite");
		tc.registerToIrctc();
		tc.userLogin();
		tc.accountActions();
		tc.searchTrain();
		tc.searchAndBookTrain();
		tc.pnrStatusCheck();
		System.out.println(" End ts: smokeSuite");
	}

	/*@Test
	public void testNG() {
		System.out.println("Test NG working");
	}*/

	
	
}
