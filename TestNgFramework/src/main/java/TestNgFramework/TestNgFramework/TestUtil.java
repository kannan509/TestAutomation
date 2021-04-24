package testNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.sun.media.sound.InvalidFormatException;

public class TestUtil {
	
	static Workbook book;
	static Sheet sheet;
	
	public static String TestData_Sheet="C:\\Users\\Poorni\\eclipse-workspace\\testNG\\src\\test\\resources\\TestData.xlsx";
	
	public static Object[][] getTestData(String SheetName) 
    {
		FileInputStream file =null;
		try {
			file= new FileInputStream(TestData_Sheet);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	
		try {
			book =WorkbookFactory.create(file);
		}catch(InvalidFormatException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(SheetName);
		
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getFirstRowNum(); i++) {
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				System.out.println("Data is :::: "+data[i][k]);
			}
		}
		
		return data;
        
    }
	
	
}
