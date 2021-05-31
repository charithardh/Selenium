package com.selenium.prac;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest {

	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties p;
	public static Properties mainProp;
	public static Properties childProp;
	public static Properties orElemen;
	public static ExtentReports report;
	public static ExtentTest test;
	
	public static void init() throws Exception
	{
		fis = new FileInputStream(projectPath +"//user.properties");
		p = new Properties();
		p.load(fis);
		
		fis = new FileInputStream(projectPath + "//Environment.properties");
		mainProp=new Properties();
		mainProp.load(fis);
		String e = mainProp.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(projectPath + "//" +e+ ".properties");
		childProp=new Properties();
		childProp.load(fis);
		//String value = childProp.getProperty("infor");
		//System.out.println(value);
		
		fis=new FileInputStream(projectPath + "//or.properties");
		orElemen=new Properties();
		orElemen.load(fis);
		
		fis=new FileInputStream(projectPath + "//log4jConfig.properties");
		PropertyConfigurator.configure(fis);
		
		report=ExtentManager.getInstance();

	}
	
	public static void launch(String browser)
	{
		if(p.getProperty(browser).equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\May 20201 Drivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", projectPath+"//drivers//chromedriver.exe");
			ChromeOptions chromeoption=new ChromeOptions();
			chromeoption.addArguments("user-data-dir=C:\\Users\\kchar\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2");
			chromeoption.addArguments("--disable-notifications");
			driver = new ChromeDriver(chromeoption);
		}
		else if(p.getProperty(browser).equals("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", "C:/Users/DELL/Desktop/May 20201 Drivers/geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", projectPath+"//drivers//geckodriver.exe");
			
			ProfilesIni p =new ProfilesIni();
			FirefoxProfile profile = p.getProfile("AutomationBrowserProfile");
			profile.setPreference("dom.webnotifications.enabled", false);
			
			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(profile);
			driver = new FirefoxDriver(option);
		}
	}
	
	public static void navigateUrl(String url)
	{
		driver.get(childProp.getProperty(url));
		//driver.navigate().to(p.getProperty(url));
	}
	
	public static void windowRefresh() 
	{
		driver.navigate().refresh();
	}

	public static void windowForward() 
	{
		driver.navigate().forward();
	}

	public static void windowBack() 
	{
		driver.navigate().back();
	}

	public static void deleteCookies() 
	{
		driver.manage().deleteAllCookies();
	}

	public static String windowCurrentUrl() 
	{
		return driver.getCurrentUrl();
	}

	public static String windowTitle() 
	{
		return driver.getTitle();
	}

	public static void windowMaximize() 
	{
		driver.manage().window().maximize();
	}
	
	public static void waitForElement(int timeInMilliSeconds) throws Exception 
	{
		Thread.sleep(timeInMilliSeconds);
	}
	
	public static void windowClose() 
	{
		//driver.quit();
		driver.close();
	}
	
	public static void click(String locator) {
		webLocator(locator).click();
		
	}

	public static void typeText(String locator, String text) {
		webLocator(locator).sendKeys(text);
		
	}

	public static void selectOption(String locator, String option) {
		webLocator(locator).sendKeys(option);
		
	}
	
	public static WebElement webLocator(String locator) {
		WebElement element=null;
		if (locator.endsWith("_id")) {
			element=driver.findElement(By.id(orElemen.getProperty(locator)));
		}else
		if (locator.endsWith("_name")) {
			element=driver.findElement(By.name(orElemen.getProperty(locator)));
		}else
		if (locator.endsWith("_classname")) {
				element=driver.findElement(By.className(orElemen.getProperty(locator)));
		}else
		if (locator.endsWith("_xpath")) {
				element=driver.findElement(By.xpath(orElemen.getProperty(locator)));
		}else
		if (locator.endsWith("_css")) {
				element=driver.findElement(By.cssSelector(orElemen.getProperty(locator)));
		}else
		if (locator.endsWith("_linktext")) {
				element=driver.findElement(By.linkText(orElemen.getProperty(locator)));
		}else
		if (locator.endsWith("_partiallinktext")) {
				element=driver.findElement(By.partialLinkText(orElemen.getProperty(locator)));
		}
		return element;
	}

	
}
