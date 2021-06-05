package com.selenium.pageVerificationCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetPageSourceCommand {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kchar\\git\\Selenium\\SeleniumPrac\\drivers\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		
		String pageSource=driver.getPageSource();
		//System.out.println(pageSource);
		
		//getting title from the source
		
		if (pageSource.contains("amazon"))
			System.out.println("Title maches");
		else
			System.out.println("Title didn't match");
		
		String pageurl=driver.getCurrentUrl();
		if (pageSource.equalsIgnoreCase(pageurl)) {
			System.out.println("URL matches");
		} else {
            System.out.println("URL didn't matches");
		}
		
		driver.quit();
		

	}

}
