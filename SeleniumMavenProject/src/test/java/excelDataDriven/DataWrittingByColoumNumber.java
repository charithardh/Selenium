package excelDataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataWrittingByColoumNumber {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file=new FileInputStream("E://DummyExcels//UserDetailsSheet.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFFont font = wb.createFont();
		XSSFCellStyle style = wb.createCellStyle();
		
		//Calibri & Algerian
		font.setFontName("Calibri");
		font.setFontHeight(12);
		font.setBold(true);
		
		style.setFont(font);
		
		XSSFSheet sheet = wb.getSheet("UserDetails");
		XSSFRow row = sheet.getRow(1);
		XSSFCell cell = row.getCell(3);
		cell.setCellStyle(style);
		cell.setCellValue("Pass");
		
		FileOutputStream fo=new FileOutputStream("E://DummyExcels//UserDetailsSheet.xlsx");
		wb.write(fo);
		wb.close();
		file.close();
		fo.close();
		System.out.println("Data have written and file has been closed....!");

	}

}
