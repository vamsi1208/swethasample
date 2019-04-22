// Reading the data from excel sheet


package com.Reltio.CommonClasses.copy;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader 
{
	static XSSFSheet Sheet;

	static XSSFWorkbook WBook;

	static XSSFCell Cell;

	static XSSFRow Row;

	
	
	/**
	 * 
	 * This method will be exposed in test case to read the data from the excel sheet
	 * 
	 * @param Path
	 * 
	 * @param SheetName
	 * 
	 * @param RowNum
	 * 
	 * @param ColNum
	 * 
	 * @return
	 * 
	 */
	@SuppressWarnings("static-access")
	public static String getCellData(String Path, String SheetName, int RowNum, int ColNum) throws Exception
	{

		try 
		{
			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			WBook = new XSSFWorkbook(ExcelFile);

			Sheet = WBook.getSheet(SheetName);

			Cell = Sheet.getRow(RowNum).getCell(ColNum);

			// String CellData = Cell.getStringCellValue();

			if (Cell.getCellType() == Cell.CELL_TYPE_STRING)
			{
				return Cell.getStringCellValue();
			}
			else if (Cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			{
				String[] splitValue=Cell.getRawValue().split(".0");
                return splitValue[0];
			//	return String.valueOf(Cell.getNumericCellValue());
			}
			else if (Cell.getCellType() == Cell.CELL_TYPE_BOOLEAN)
			{
				return String.valueOf(Cell.getBooleanCellValue());
			} 
			else if (Cell.getCellType() == Cell.CELL_TYPE_BLANK)
			{
				return "";
			}
		}
		catch (Exception e) 
		{

			return e.getMessage();

		}

		return null;

	}
}
