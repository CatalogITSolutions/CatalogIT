package generalUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Snippet {

	WebDriver driver;
	String screenshotfilepath;

	public Snippet(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public String TakeErrorScreenShot(String fname) {
		String path = System.getProperty("user.dir");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		screenshotfilepath = path + "\\ScreenShots\\" + fname + ".png";
		try {
			FileUtils.copyFile(scrFile, new File(screenshotfilepath));
			// FileUtils.copyFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// e.getMessage();
		}
		scrFile = null;
		System.out.println(screenshotfilepath);
		return screenshotfilepath;
	}
}
