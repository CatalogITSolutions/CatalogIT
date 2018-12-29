package generalUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

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
	
	public String getMIxedData(String sheetName, int row, int col) {
		readsheet = getMySheet(sheetName);
		Cell = readsheet.getRow(row).getCell(col);
		String CellData1 = Cell.getCellFormula();
		return CellData1;
	}
	
	
	
	/*public String getRawValue(String sheetName, int row, int col) {
	readsheet = getMySheet(sheetName);
	Cell = readsheet.getRow(row).getCell(col);
	String Data = getCellValueAsString(Cell);
	return Data;
}*/

/*private String getCellValueAsString(XSSFCell cell2) {
	// TODO Auto-generated method stub

	String strCellValue = null;
	if (cell2 != null) {
		switch (cell2.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			strCellValue = cell2.toString();
			break;
		case Cell.CELL_TYPE_NUMERIC:
			if (DateUtil.isCellDateFormatted(cell2)) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				strCellValue = dateFormat.format(cell2.getDateCellValue());
			} else {
				Double value = cell2.getNumericCellValue();
				Long longValue = value.longValue();
				strCellValue = new String(longValue.toString());
			}
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			strCellValue = new String(new Boolean(cell2.getBooleanCellValue()).toString());
			break;
		case Cell.CELL_TYPE_BLANK:
			strCellValue = "";
			break;
		}
	}
	return strCellValue;

}*/

/*
 * private static void printCellValue(XSSFCell cell) { switch
 * (cell.getCellTypeEnum()) { case BOOLEAN:
 * 
 * System.out.print(cell.getBooleanCellValue()); break; case STRING:
 * System.out.print(cell.getRichStringCellValue().getString()); break; case
 * NUMERIC: if (DateUtil.isCellDateFormatted(cell)) {
 * System.out.print(cell.getDateCellValue()); } else {
 * System.out.print(cell.getNumericCellValue()); } break; case FORMULA:
 * System.out.print(cell.getCellFormula()); break; case BLANK:
 * System.out.print(""); break; default: System.out.print(""); }
 * 
 * System.out.print("\t");
 * 
 * }
 */

	
}
