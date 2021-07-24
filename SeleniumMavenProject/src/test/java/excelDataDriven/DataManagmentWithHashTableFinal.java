package excelDataDriven;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

public class DataManagmentWithHashTableFinal {
  @Test(dataProvider = "getData")
  public void f(Hashtable<String, String> dt) {
	  System.out.println(dt.get("UserName"));
	  
  }

  @DataProvider
  public Object[][] getData() throws Exception {
	  ExcelAPI e=new ExcelAPI("E:\\DummyExcels\\suitea.xlsx");
		String sheetName="Data";
		String testCaseName="TestB";
		
		return DataUtils.getTestData(e, sheetName, testCaseName);
  }
}
