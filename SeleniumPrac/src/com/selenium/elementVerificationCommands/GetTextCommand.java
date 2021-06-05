package com.selenium.elementVerificationCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextCommand {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kchar\\git\\Selenium\\SeleniumPrac\\drivers\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.cleartrip.com/");
		boolean validation=driver.findElement(By.xpath("//button[text()='Search flights']")).isDisplayed();
		System.out.println("IS Displayed:"+validation);
		boolean validation2=driver.findElement(By.xpath("//button[text()='Search flights']")).isEnabled();
		System.out.println("IS Enabled:"+validation2);
		
		//Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
		
		//Handling the cookies footer message by clicking on close button
		driver.findElement(By.xpath("//div[@class='closeit']")).click();
		
		Thread.sleep(3000);
		
		//Clicking on search button without giving origin and destination
		driver.findElement(By.xpath("//button[text()='Search flights']")).click();
		
		//Search and validating the warrning message
		String warrMessage=driver.findElement(By.xpath("//div[@class='col-24']/div/span")).getText();
		System.out.println(warrMessage);
		
		String acctualWarrMess="Select Departure";
		
		if (warrMessage.contains(acctualWarrMess)) {
			System.out.println("Correct Message is displayed");
		} else {
			System.out.println("Wrong Message is displayed");
		}
		
		Thread.sleep(3000);
		
		driver.quit();

	}

}
