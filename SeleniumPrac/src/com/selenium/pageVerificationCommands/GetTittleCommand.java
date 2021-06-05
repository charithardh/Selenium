package com.selenium.pageVerificationCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.selenium.prac.BaseTest;

public class GetTittleCommand extends BaseTest{

	public static void main(String[] args) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kchar\\git\\Selenium\\SeleniumPrac\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		String pageTilte=driver.getTitle();
	    System.out.println(pageTilte);
	    driver.quit();

	}

}
