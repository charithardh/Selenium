package SampleMavenProject.SeleniumMavenProject;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.LogStatus;

public class Test03 extends BaseTest{
	


	public static void main(String[] args) throws Exception 
	{
        
		init();
		test=report.startTest("TC_003");
		test.log(LogStatus.INFO, "Loading the properties file.....!");
		launch("chromebrowser");
		test.log(LogStatus.PASS, "Launching the browser:"+p.getProperty("chromebrowser"));
		deleteCookies();
		test.log(LogStatus.INFO, "Deleting the browser cookies");
		navigateUrl("amazon");
		test.log(LogStatus.PASS, "Navigating to the URL:"+childProp.getProperty("amazon"));
		windowMaximize();
		test.log(LogStatus.INFO, "Browser got maximized");
		String expectedText="Customer service";
		
		if(verifyLinkEqualsTo(expectedText)) 
			VerificationPassed("Link text are not equal");
		else
			VerificationFailed("Link text are not equal");
		
		windowClose();
		test.log(LogStatus.INFO, "Closing the browser");
		report.endTest(test);
		report.flush();

	}

}
