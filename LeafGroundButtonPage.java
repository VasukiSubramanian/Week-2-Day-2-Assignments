package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundButtonPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Click button to travel home page
		driver.findElement(By.id("home")).click();
		driver.navigate().back();
		
		// Get Position of the button
		Point location = driver.findElement(By.id("position")).getLocation();
		System.out.println("Positions (x,y) are : " + location);
		
		// what color am I?
		String color = driver.findElement(By.id("color")).getAttribute("style");
		System.out.println(color);
		
		// Find the height and width
		Dimension size = driver.findElement(By.id("size")).getSize();
		System.out.println("Height and width : " + size);

	}

}
