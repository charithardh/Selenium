package com.selenium.elementVerificationCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTageNameGetAttribute {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kchar\\git\\Selenium\\SeleniumPrac\\drivers\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Harry Potter");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		String searchTagName=driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).getTagName();
		System.out.println(searchTagName);
		String getAttri=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).getAttribute("value");
		System.out.println("Value you have entered:"+getAttri);
		driver.quit();
		


	}

}
