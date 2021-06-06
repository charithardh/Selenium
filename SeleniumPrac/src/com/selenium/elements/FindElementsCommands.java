package com.selenium.elements;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsCommands {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kchar\\git\\Selenium\\SeleniumPrac\\drivers\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='nav-xshop']/a"));
		
		/*
		 * for(int i = 0; i<list.size();i++) {
		 * System.out.println(list.get(i).getText()); }
		 */
		
		for (WebElement l : list) {
			System.out.println(l.getText());
		}
		
		driver.quit();

	}

}
