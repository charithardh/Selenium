package com.selenium.prac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunch {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://Users//ckonda//OneDrive - Infor//Desktop//Learning//Jar files//Selenium Jar files//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.infor.com");
		driver.close();
		driver.quit();

	}

}
