package generalUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadXL {

	FileInputStream readfile;
	Workbook readbook;
	Sheet readsheet;
	String xlFilepath;

	public ReadXL(String xlFilepath) {
		// TODO Auto-generated constructor stub
		this.xlFilepath = xlFilepath;
	}

	public Sheet getMySheet(String sheetName) {
		try {
			readfile = new FileInputStream(xlFilepath);
			readbook = Workbook.getWorkbook(readfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(sheetName);
		readsheet = readbook.getSheet(sheetName);
		return readsheet;

	}

	public int getRowCount(String sheetName) {
		readsheet = getMySheet(sheetName);
		System.out.println(readsheet);
		return readsheet.getRows();

	}

	public int getColumnCount(String sheetName) {
		readsheet = getMySheet(sheetName);
		return readsheet.getColumns();

	}

	public String getCellData(String sheetName, int col, int row) {
		readsheet = getMySheet(sheetName);
		//System.out.println(sheetName);
		return readsheet.getCell(col, row).getContents();
	}

}
