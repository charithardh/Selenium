package excelDataDriven;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

public class DataManagmentWithHashTable {
  @Test(dataProvider = "getData")
  public void f(Hashtable<String, String> dt) {
  }

  @DataProvider
  public Object[][] getData() throws Exception {
	  ExcelAPI e=new ExcelAPI("E:\\DummyExcels\\suitea.xlsx");
		String sheetName="Data";
		String testCaseName="TestB";
		
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
		
		Object[][] data=new Object[row][1];
		Hashtable<String, String> table=null;
		int dataRow=0;
		for(int rnum = dataStartRowNumber; rnum < dataStartRowNumber+row; rnum++) {
			table=new Hashtable<String, String>();
			for(int cnum=0; cnum < col;cnum++) {
				
			    //System.out.print(e.getCellData(sheetName, rnum, cnum)+ " ");
				//data[dataRow][cnum]=e.getCellData(sheetName, rnum, cnum);
				String key = e.getCellData(sheetName, columnStartRowNumber, cnum);
				String value=e.getCellData(sheetName, rnum, cnum);
				table.put(key, value);
			}
			System.out.println();
			data[dataRow][0]=table;
			dataRow++;
		}
		return data;

  }
}
