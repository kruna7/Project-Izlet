package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtils {

	private static HSSFSheet excelWSheet;
	private static HSSFWorkbook excelWBook;
	private static HSSFCell cell;
	private static HSSFRow row;
	private static DataFormatter formatter;

	//metoda koja postavlja excel fajl koji cemo koristiti
	public static void setExcelFile(String path, String sheetName) throws Exception {
		try {
			FileInputStream ExcelFile = new FileInputStream(path);
			excelWBook = new HSSFWorkbook(ExcelFile);
			excelWSheet = excelWBook.getSheet(sheetName);
			formatter = new DataFormatter();
		} catch (Exception e) {
			throw (e);
		}

	}

	//metoda koja uzima podatke iz celija excel tabele
	public static String getCellData(int rowNum, int colNum) throws Exception {
		try {
			cell = excelWSheet.getRow(rowNum).getCell(colNum);
			String data = formatter.formatCellValue(cell);
			;
			return data;
		} catch (Exception e) {
			return "";
		}

	}

	//metoda koja vraca workcsheet
	public static HSSFSheet getWorkSheet() {
		return excelWSheet;
	}

	//metoda koja upisuje podatke u tabelu
	public static void setCellData(String result, int rowNum, int colNum) throws Exception {
		try {
			row = excelWSheet.getRow(rowNum);
			cell = row.getCell(colNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);
			if (cell == null) {
				cell = row.createCell(colNum);
				cell.setCellValue(result);
			} else {
				cell.setCellValue(result);
			}
			FileOutputStream fileOut = new FileOutputStream(Constant.PATH + Constant.FILE);
			excelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);

		}

	}

}