package generalUtilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.TakesScreenshot;


import org.testng.ITestListener;



//-:--:--:--:- Importing Extent Report class -:--:--:--:-

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Listener implements ITestListener {
	
	WebDriver driver;
	ExtentReports extentFamily;
	ExtentTest parent;
	
	
	public Listener(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		driver = this.driver;
		//extentFamily = new ExtentReports(
		//		new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
		parent = extentFamily.startTest("Smoke Suite");
	}
	
	public void onStart(ITestContext context) {
		  System.out.println("on start");
		 // driver = new ChromeDriver(); // Set the drivers path in environment variables to avoid code(System.setProperty())
		  extentFamily = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
		 }
	
	public void onTestStart(ITestResult result) {
		  System.out.println("on test start");
		  parent = extentFamily.startTest(result.getMethod().getMethodName());
		  parent.log(LogStatus.INFO, result.getMethod().getMethodName() + "test is started");
		 }
		 public void onTestSuccess(ITestResult result) {
		  System.out.println("on test success");
		  parent.log(LogStatus.PASS, result.getMethod().getMethodName() + "test is passed");
		 }
		 public void onTestFailure(ITestResult result) {
		  System.out.println("on test failure");
		  parent.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed");
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File src = ts.getScreenshotAs(OutputType.FILE);
		  try {
		   FileUtils.copyFile(src, new File("C:\\Java\\Selenium\\Irctc.co.in\\ScreenShots" + result.getMethod().getMethodName() + ".png"));
		   String file = parent.addScreenCapture("C:\\Java\\Selenium\\Irctc.co.in\\ScreenShots" + result.getMethod().getMethodName() + ".png");
		   parent.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed", file);
		   parent.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed", result.getThrowable().getMessage());
		  } catch (IOException e) {
		   e.printStackTrace();
		  }catch (Exception e) {
			   e.printStackTrace();
			  }
		 }
		 public void onTestSkipped(ITestResult result) {
		  System.out.println("on test skipped");
		  parent.log(LogStatus.SKIP, result.getMethod().getMethodName() + "test is skipped");
		 }
		 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		  System.out.println("on test sucess within percentage");
		 }
		 
		 public void onFinish(ITestContext context) {
		  System.out.println("on finish");
		  driver.close();
		  extentFamily.endTest(parent);
		  extentFamily.flush();
		 }


}
