package excelDataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelAPI {
	
	public FileInputStream fis=null;
	public FileOutputStream fos=null;
	public XSSFWorkbook wb=null;
	public XSSFSheet sheet=null;
	public XSSFRow row=null;
	public XSSFCell cell=null;
	String xlFilePath;
	
	public ExcelAPI(String xlFilePath) throws IOException {
		System.out.println("Excel has initilized......");
		this.xlFilePath=xlFilePath;
		fis=new FileInputStream(xlFilePath);
		wb=new XSSFWorkbook(fis);
	}
	
	public int getRowCount(String sheetName) {
		sheet=wb.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum()+1;
		return rowCount;
		
	}
	
	public int getColumnCount(String sheetName) {
		sheet=wb.getSheet(sheetName);
		row=sheet.getRow(0);
		int columnCount=row.getLastCellNum();
		return columnCount;
		
	}
	
	//Reading the cell data from Excel by using column number
	public String getCellData(String sheetName, int rowNumber, int columNumber) {
		try {
			sheet=wb.getSheet(sheetName);
			row=sheet.getRow(rowNumber);
			cell=row.getCell(columNumber);
			
			if(cell.getCellTypeEnum()==CellType.STRING) 
				return cell.getStringCellValue();
			else if(cell.getCellTypeEnum()==CellType.NUMERIC || cell.getCellTypeEnum()==CellType.FORMULA) {
				String cellValue=String.valueOf(cell.getNumericCellValue());
				if(HSSFDateUtil.isCellDateFormatted(cell)) {
					DateFormat df=new SimpleDateFormat("dd/mm/yy");
					Date date = cell.getDateCellValue();
					cellValue=df.format(date);
				}
				return cellValue;
				
			}else if(cell.getCellTypeEnum()==CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
			
		} catch (Exception e) {
			e.printStackTrace();
			return "No matching value";
		}
		
	}
	
	//Reading the cell data from Excel by using Column Name
	public String getCellData(String sheetName, int rowNumber, String columName) {
		try {
			int cellIndex=-1;
			sheet=wb.getSheet(sheetName);
			row=sheet.getRow(0);
			
			for(int i=0; i < row.getLastCellNum(); i++) {
				if(cell.getStringCellValue().trim().equals(columName)) {
					cellIndex=i;
				}
			}
			row=sheet.getRow(rowNumber);
			cell=row.getCell(cellIndex);
			
			if(cell.getCellTypeEnum()==CellType.STRING)
				return cell.getStringCellValue();
			else if(cell.getCellTypeEnum()==CellType.NUMERIC || cell.getCellTypeEnum()==CellType.FORMULA) {
				String CellValue = String.valueOf(cell.getNumericCellValue());
				if(HSSFDateUtil.isCellDateFormatted(cell)) {
					DateFormat df=new SimpleDateFormat("dd/mm/yy");
					Date date = cell.getDateCellValue();
					CellValue=df.format(date);
				}
				return CellValue;
			}else if(cell.getCellTypeEnum()==CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {
			e.printStackTrace();
			return "No matching value";
		}
	}
	
	//Writting cell data to Excel using Colum Number
	public boolean setCellData(String sheetName, int rowNumber, int ColumnNumber, String value) {
		try {
			sheet=wb.getSheet(sheetName);
			row=sheet.getRow(rowNumber);
			cell=row.getCell(ColumnNumber);
			cell.setCellValue(value);
			
			fos=new FileOutputStream(xlFilePath);
			wb.write(fos);
			fos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	//Writting cell data to Excel using Colum Name
	public boolean setCellData(String sheetName, int rowNumber, String ColumName, String value) {
		try {
			int indexValue=-1;
			sheet=wb.getSheet(sheetName);
			row=sheet.getRow(0);
			
			for(int i=0; i < row.getLastCellNum(); i++) {
				if(cell.getStringCellValue().trim().equals(ColumName)) {
					indexValue=i;
				}
			}
			
			row=sheet.getRow(rowNumber);
			cell=row.getCell(indexValue);
			cell.setCellValue(value);
			
			fos=new FileOutputStream(xlFilePath);
			wb.write(fos);
			fos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
