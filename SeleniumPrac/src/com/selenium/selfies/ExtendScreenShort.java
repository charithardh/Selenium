package com.selenium.selfies;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtendScreenShort {
	private static WebDriver driver;
	private static ExtentReports report;
	private static ExtentTest test;
	private static String projectDir;

	public static void main(String[] args) throws Exception{
		
	  projectDir=System.getProperty("user.dir");
	  report=new ExtentReports(projectDir+"//HTMLReports//report.html");
	  report.loadConfig(new File(projectDir+"//extentreportconfig.xml"));
	  test=report.startTest("ExtendScreenShort");
	  
	  System.setProperty("webdriver.chrome.driver", projectDir+"//drivers//chromedriver.exe");
	  driver=new ChromeDriver();
	  test.log(LogStatus.PASS, "Browser got launched...!");
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.com");
	  test.log(LogStatus.PASS, "Browser got navigated to the url: "+driver.getCurrentUrl());
	  String expectedURL="Customer service";
	  
	  if(!verifyLinksEqual(expectedURL)) {
		  System.out.println("Not Equal");
		  reportFailed("Both the texts are different");
	  }else {
		  reportSuccess("Both the texts are same");
		  System.out.println("Equal");
	  }
	  
	  report.endTest(test);
	  report.flush();

	}

	private static void reportFailed(String FailedText) throws Exception{
		test.log(LogStatus.FAIL, FailedText);
		Date dt=new Date();
		System.out.println(dt);
		String dataFormat = dt.toString().replace(":", "_").replace(" ", "_")+".png";
		File screensht = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screensht, new File(projectDir+"//failurescreenshots//"+dataFormat));
		test.log(LogStatus.INFO, "Screenshot-->"+test.addScreenCapture(projectDir+"//failurescreenshots//"+dataFormat));
		
	}

	private static void reportSuccess(String successText) {
		test.log(LogStatus.PASS, successText);
		
	}

	private static boolean verifyLinksEqual(String expectedURL) {
		String actualLink=driver.findElement(By.linkText("Customer Service")).getAttribute("innerHTML");
		System.out.println("Entered");
		if(actualLink.equals(expectedURL)) 
			return true;
		else
			return false;
	}

}
