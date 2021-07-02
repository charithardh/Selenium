package excelDataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataWrittingByColoumName {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file=new FileInputStream("E://DummyExcels//UserDetailsSheet.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("UserDetails");
		XSSFRow row = sheet.getRow(0);
	    XSSFCell cell=null;
	    
	    int cellIndex=-1;
	    
	    for(int i=0; i < row.getLastCellNum(); i++) {
	    	
	    	if(row.getCell(i).getStringCellValue().trim().equals("Result"))
	    		cellIndex=i;
	    }
	    
	    row=sheet.getRow(2);
	    cell=row.getCell(cellIndex);
	    cell.setCellValue("Failed");
	    
	    FileOutputStream fo=new FileOutputStream("E://DummyExcels//UserDetailsSheet.xlsx");
	    wb.write(fo);
	    wb.close();
	    file.close();
	    fo.close();
	    System.out.println("File has been written & File has been closed");

	}

}
