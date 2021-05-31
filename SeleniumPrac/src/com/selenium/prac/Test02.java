package com.selenium.prac;

import com.relevantcodes.extentreports.LogStatus;

public class Test02 extends BaseTest{
	


	public static void main(String[] args) throws Exception 
	{
        
		init();
		test=report.startTest("TC_002");
		test.log(LogStatus.INFO, "Loading the properties file.....!");
		launch("chromebrowser");
		test.log(LogStatus.PASS, "Launching the browser:"+p.getProperty("chromebrowser"));
		deleteCookies();
		test.log(LogStatus.INFO, "Deleting the browser cookies");
		navigateUrl("amazon");
		test.log(LogStatus.PASS, "Navigating to the URL:"+childProp.getProperty("amazon"));
		windowMaximize();
		test.log(LogStatus.INFO, "Browser got maximized");
		selectOption("amazonSearchDropdown_id", "Books");
		test.log(LogStatus.FAIL, "Selecting the Dropdown using locator:"+orElemen.getProperty("amazonSearchDropdown_id"));
		typeText("mainSearchTextField_name", "Harry Potter");
		test.log(LogStatus.PASS, "Entering the text using locator:"+orElemen.getProperty("mainSearchTextField_name"));
		click("mainSearchButton_xpath");
		test.log(LogStatus.PASS, "Clicking on search button using locator:"+orElemen.getProperty("mainSearchButton_xpath"));
		windowClose();
		test.log(LogStatus.INFO, "Closing the browser");
		report.endTest(test);
		report.flush();

	}

}
