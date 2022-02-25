package ExcelReaderUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader extends ExcelWriterUtility {
	
	XSSFWorkbook wb;
	XSSFSheet sheet1 ;
	
	
	public  String Excel(int row, int col) throws Exception{
		
		File src = new File("D:\\eclipse\\chromedriver_win32\\Testing.xlsx");
		
		FileInputStream fis = new FileInputStream(src);
		
		 wb = new XSSFWorkbook(fis);
		
		 sheet1 = wb.getSheetAt(0);
		
		sheet1.getRow(row).getCell(col).getStringCellValue();
		
		wb.close();
		
		return sheet1.getRow(row).getCell(col).getStringCellValue();
	}

}
