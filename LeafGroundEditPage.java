package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundEditPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Enter your email address
		driver.findElement(By.id("email")).sendKeys("vasu94it@gmail.com");

		// Append a text and press keyboard tab
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys("vasu", Keys.TAB);

		// Get Default text entered
		String text2 = driver.findElement(By.xpath("//input[@value='TestLeaf']")).getAttribute("value");
		System.out.println(text2);

		// Clear the text
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();

		// Confirm that edit field is disabled
		boolean isenabled = driver.findElement(By.xpath("//input[@disabled='true']")).isEnabled();
		System.out.println(isenabled);

	}

}
