package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundRadioButtonPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/radio.html");
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Are you enjoying the classes?
		driver.findElement(By.id("yes")).click();

		// Find default selected radio button
		if (driver.findElement(By.xpath("(//input[@value=\"0\"])[2]")).isSelected())
			System.out.println("Default selected radio button is : Unchecked");
		else
			System.out.println("Default selected radio button is : Checked");

		// Select your age group (Only if choice wasn't selected)
		if (driver.findElement(By.xpath("(//input[@value=\"1\"])[3]")).isSelected())
			System.out.println("Age group is selected by default");
		else {
			System.out.println("Age group is not selected by default");
			driver.findElement(By.xpath("(//input[@value=\"1\"])[3]")).click();
		}

	}

}
