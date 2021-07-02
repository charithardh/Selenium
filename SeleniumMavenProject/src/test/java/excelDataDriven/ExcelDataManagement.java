package excelDataDriven;

import java.io.IOException;

public class ExcelDataManagement {

	public static void main(String[] args) throws Throwable {
		
		ExcelAPI e=new ExcelAPI("E:\\DummyExcels\\suitea.xlsx");
		String sheetName="Data";
		String testCaseName="LoginTest";
		
		System.out.println("TestName is: "+testCaseName);
		
		int startRowNumber=0;
		while (!(e.getCellData(sheetName, startRowNumber, 0)).equals(testCaseName)) {
			     
			startRowNumber++;
			
		}
		
		System.out.println("Test row Start from: "+startRowNumber);
		int columnStartRowNumber=startRowNumber+1;
		int dataStartRowNumber=startRowNumber+2;
		
		int row=0;
		while (!e.getCellData(sheetName, dataStartRowNumber+row, 0).equals("")) {
			
			  row++;
		}
		
		System.out.println("Total row are :"+row);
		
		int col=0;
		while(!e.getCellData(sheetName, columnStartRowNumber, col).equals("")) {
			
			col++;
			
		}
		
		System.out.println("Total col are: "+col);
		
		for(int rnum = dataStartRowNumber; rnum < dataStartRowNumber+row; rnum++) {
			
			for(int cnum=0; cnum < col;cnum++) {
				
			    System.out.print(e.getCellData(sheetName, rnum, cnum)+ " ");
			}
			System.out.println();
		}

	}

}
