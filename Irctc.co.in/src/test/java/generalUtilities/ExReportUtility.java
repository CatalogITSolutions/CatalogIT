package generalUtilities;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExReportUtility {
	ExtentReports extentFamily;
	ExtentTest parent;
	ExtentTest childx;
	ReadProperties readprop;
	String ExReportPath;
	Snippet snip;

	public ExReportUtility(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 readprop = new ReadProperties("testData/TestData.properties");
	
		snip = new Snippet(driver);

	}
	
	public ExtentTest defaultParent(String parentname, String parentdesc) {
		extentFamily = new ExtentReports(readprop.readValue(ExReportPath));
		parent = extentFamily.startTest(parentname, parentdesc);
		return parent;
	}

	public ExtentTest defaultChild(String name, String des) {
		childx = extentFamily.startTest(name, des);
		return childx;
	}

	public void generateReport(boolean flag) {
		ExtentTest childx = defaultChild("PNR", "pnr description");
		parent.appendChild(childx);

		System.out.println(" Start : Generate Report");

		if (flag) {
			childx.log(LogStatus.PASS, "PNR status Successfully",
					childx.addScreenCapture(snip.TakeErrorScreenShot("pnrsuccess")));
		} else {
			childx.log(LogStatus.FAIL, "Failed to login", childx.addScreenCapture(snip.TakeErrorScreenShot("pnrfail")));
		}
		parent.log(LogStatus.INFO, "Execution Done");
		extentFamily.flush();
		extentFamily.endTest(parent);

		System.out.println(" End ts: unitTest");
	}

}
