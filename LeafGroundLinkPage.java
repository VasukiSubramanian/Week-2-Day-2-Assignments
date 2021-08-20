package week2.day2.assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundLinkPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Go To Home Page
		driver.findElement(By.linkText("Go to Home Page")).click();
		driver.navigate().back();

		// Find where am supposed to go without clicking me?
		String link = driver.findElement(By.linkText("Find where am supposed to go without clicking me?"))
				.getAttribute("href");
		System.out.println("Link supposed to go without clicking : " + link);

		// Verify am I broken
		driver.findElement(By.linkText("Verify am I broken?")).click();
		String title2 = driver.getTitle();
		System.out.println("Status of the link : " + title2);
		driver.navigate().back();

		// Interact with same link name
		String link1 = driver.findElement(By.linkText("Go to Home Page")).getAttribute("href");
		String link2 = driver.findElement(By.xpath("//label[@for=\"position\"]/preceding-sibling::a"))
				.getAttribute("href");
		if (link1.equals(link2)) {
			System.out.println("Both the links are same");
			driver.findElement(By.linkText("Go to Home Page")).click();
			driver.navigate().back();
		} else
			System.out.println("Both the links are different");

		// How many links are available in this page
		List<WebElement> tag = driver.findElements(By.tagName("a"));
		System.out.println("Number of links in the page : " + tag.size());

	}

}
