package generalUtilities;

import java.util.concurrent.TimeUnit;

public class HoldOn {
	
	public void staticWait(int timeInSec) {
		try {
			Thread.sleep(timeInSec * 1000);  // thread will take in milli seconds 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

}
