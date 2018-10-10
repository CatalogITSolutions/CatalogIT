package generalUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readxlsx {

	FileInputStream readfile;
	String xlsxPath;
	XSSFWorkbook readbook;
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
			System.out.println(e.getMessage());
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

	public int getRowCount(String sheetName) {
		readsheet = getMySheet(sheetName);
		int row = readsheet.getLastRowNum();
		row = row + 1;
		return row;
	}
}
