package com.selenium.elementVerificationCommands;



import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementLocation {

	public static void main(String[] args) {
     System.setProperty("webdriver.chrome.driver", "C:\\Users\\kchar\\git\\Selenium\\SeleniumPrac\\drivers\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Harry Potter");
		WebElement searchButton=driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		
		Point obj_location=searchButton.getLocation();
		int x_obj=obj_location.getX();
		int y_obj=obj_location.getY();
		System.out.println("Old Style X:"+x_obj+" Y:"+y_obj);
		
		int x=searchButton.getLocation().x;
		int y=searchButton.getLocation().y;
		System.out.println("New Style X:"+x+" Y:"+y);
		
		System.out.println("CSS style value: "+searchButton.getCssValue("position"));
		
		
		driver.quit();
		
		
		

	}

}
