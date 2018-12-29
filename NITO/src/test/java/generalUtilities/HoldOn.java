package generalUtilities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public class HoldOn {

	public void staticWait(int timeInSec) {
		try {
			Thread.sleep(timeInSec * 1000); // thread will take in milli seconds
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void implicitlyWait(WebDriver driver, int timeInSec) {
		driver.manage().timeouts().implicitlyWait(timeInSec, TimeUnit.SECONDS); // thread will take in seconds
	}

}
