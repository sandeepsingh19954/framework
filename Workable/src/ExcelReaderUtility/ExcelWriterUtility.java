package ExcelReaderUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriterUtility {

	public String WriteExcel(int row1, int col2,String Value) throws Exception{

		File src = new File("D:\\eclipse\\chromedriver_win32\\Testing.xlsx");

		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheetAt(0);

		sheet.getRow(row1).createCell(col2).setCellValue(Value);

		FileOutputStream fos = new FileOutputStream(src);

		wb.write(fos);

		wb.close();
		return Value;

	}

}
