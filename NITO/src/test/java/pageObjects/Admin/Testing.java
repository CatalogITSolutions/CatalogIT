package pageObjects.Admin;

import org.junit.Test;

import generalUtilities.Readxlsx;

public class Testing {

	Readxlsx readxlsx;

	public Testing() {
		// TODO Auto-generated constructor stub
		readxlsx = new Readxlsx("testData/Dataxlsx.xlsx");
	}

	@Test
	public void testing() {

		System.out.println(readxlsx.getIntData("Test", 0, 0));
		System.out.println(readxlsx.getCellData("Test", 1, 0));
		System.out.println(readxlsx.getRawData("Test", 2, 0));
		System.out.println(readxlsx.getRowCount("Test"));
	}
}
