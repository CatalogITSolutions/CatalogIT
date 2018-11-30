package generalUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readxlsx {

	FileInputStream readfile;
	String xlsxPath;
	XSSFWorkbook readbook = null;
	XSSFSheet readsheet;
	XSSFRow row;
	private static XSSFCell Cell;

	public Readxlsx(String xlsxPath) {
		// TODO Auto-generated constructor stub
		this.xlsxPath = xlsxPath;
	}

	public XSSFSheet getMySheet(String sheetName) {
		try {
			readfile = new FileInputStream(xlsxPath);
			// Getting the workbook instance for xlsx file
			readbook = new XSSFWorkbook(readfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		readsheet = readbook.getSheet(sheetName);

		// System.out.println(sheetName);

		return readsheet;

	}

	public String getCellData(String sheetName, int row, int col) {
		readsheet = getMySheet(sheetName);
		Cell = readsheet.getRow(row).getCell(col);
		String CellData = Cell.getStringCellValue();
		return CellData;
	}

	public String getRawData(String sheetName, int row, int col) {
		readsheet = getMySheet(sheetName);
		Cell = readsheet.getRow(row).getCell(col);
		String CellData1 = Cell.getRawValue();
		return CellData1;
	}

	public String getIntData(String sheetName, int row, int col) {
		readsheet = getMySheet(sheetName);
		Cell = readsheet.getRow(row).getCell(col);
		int intData = (int) Cell.getNumericCellValue();
		String data = String.valueOf(intData);
		return data;
	}

	public int getRowCount(String sheetName) {
		readsheet = getMySheet(sheetName);
		int row = readsheet.getLastRowNum();
		row = row + 1;
		return row;
	}
}
