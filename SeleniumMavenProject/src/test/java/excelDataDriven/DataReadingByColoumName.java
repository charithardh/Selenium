package excelDataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReadingByColoumName {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file=new FileInputStream("E://DummyExcels//UserDetailsSheet.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("UserDetails");
		XSSFRow row = sheet.getRow(0);
		XSSFCell cell=null;
		
		int cellIndex=-1;
		
		for(int i=0; i < row.getLastCellNum();i++) {
			
			if(row.getCell(i).getStringCellValue().trim().equals("Password")) {
				cellIndex=i;
			}
			
		}
		
		row=sheet.getRow(1);
		String txt=row.getCell(cellIndex).getStringCellValue();
		System.out.println(txt);
		wb.close();
		file.close();

	}

}
