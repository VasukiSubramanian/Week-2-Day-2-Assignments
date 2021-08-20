package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundCheckBoxPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Select the languages that you know?
		driver.findElement(By.xpath("(//input)[1]")).click();
		driver.findElement(By.xpath("(//input)[3]")).click();

		// Confirm Selenium is checked
		if (driver.findElement(By.xpath("(//input)[6]")).isSelected())
			System.out.println("Selenium is checked already");
		else {
			driver.findElement(By.xpath("(//input)[6]")).click();
			System.out.println("Selenium is checked now");
		}

		// DeSelect only checked
		for (int i = 7; i <= 8; i++) {
			if (driver.findElement(By.xpath("(//input)[" + i + "]")).isSelected())
				driver.findElement(By.xpath("(//input)[" + i + "]")).click();
		}

		// Select all below checkboxes
		for (int i = 9; i <= 13; i++)
			driver.findElement(By.xpath("(//input)[" + i + "]")).click();

	}

}
