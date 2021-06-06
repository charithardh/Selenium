package com.selenium.selfies;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShorts {

	public static void main(String[] args) throws IOException {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\kchar\\git\\Selenium\\SeleniumPrac\\drivers\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='nav-xshop']/a"));
		
		for(int i = 0; i<list.size();i++) 
		{
		    Date d=new Date();
		    String dt=d.toString().replace(':', '_').replace(' ', '_');
		    
			String listName=list.get(i).getText();
			list.get(i).click();
			File scrnShort=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrnShort, new File("E:\\DummyScreenShorts\\"+listName+"_"+dt+".png"));
			
			driver.navigate().back();
			
			list = driver.findElements(By.xpath("//div[@id='nav-xshop']/a"));
		}

	}

}
