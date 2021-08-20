package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundImagePage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Click on the image to go home page
		driver.findElement(By.xpath("//label[@for=\"home\"]/following-sibling::img")).click();
		driver.navigate().back();

		// Am I broken Image
		String width = driver.findElement(By.xpath("//label[@for=\"position\"]/following-sibling::img"))
				.getAttribute("naturalWidth");
		if (width.equals("0"))
			System.out.println("I am broken");
		else
			System.out.println("I am not broken");

		// Click me using Keyboard or Mouse
		driver.findElement(By.xpath("//section[@class=\"innerblock\"]/div[3]//img")).click();

	}

}
