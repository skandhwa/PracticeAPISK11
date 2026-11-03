package Utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FetchDataFromExcel {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	FetchDataFromExcel(String excelPath,String sheetName) throws IOException
	{
		workbook =new XSSFWorkbook(excelPath);
		sheet=workbook.getSheet(sheetName);
	}
	
	
	public static String getDataExcel(int x,int y)
	{
		DataFormatter obj=new DataFormatter();
		Object value=	obj.formatCellValue(sheet.getRow(x).getCell(y));
		return value.toString();
	}
	
	
	public int getRowCount() {
	    return sheet.getPhysicalNumberOfRows();
	}

	public int getColumnCount() {
	    return sheet.getRow(0).getLastCellNum();
	}
	
	
	
	

}
