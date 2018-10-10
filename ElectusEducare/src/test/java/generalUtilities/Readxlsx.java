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
	XSSFCell cell;

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

	public String getCellData(String sheetName, int col, int row) {
		readsheet = getMySheet(sheetName);

		return readsheet.getRow(row).getCell(col).getStringCellValue();
	}
}
