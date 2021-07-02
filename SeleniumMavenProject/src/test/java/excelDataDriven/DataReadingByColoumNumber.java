package excelDataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReadingByColoumNumber {

	public static void main(String[] args) throws IOException {
	   
		FileInputStream file=new FileInputStream("E://DummyExcels//UserDetailsSheet.xlsx");
        XSSFWorkbook wb=new XSSFWorkbook(file);
        XSSFSheet sheet=wb.getSheet("UserDetails");
        XSSFRow row = sheet.getRow(2);
        XSSFCell cell = row.getCell(1);
        String txt = cell.getStringCellValue();
        System.out.println(txt);
        
        wb.close();
        file.close();
	}

}
