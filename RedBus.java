package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// 1. Go to https://www.redbus.in/ in chrome
		driver.get("https://www.redbus.in/");
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// 2. Type Chennai in From textBox and ENTER
		WebElement source = driver.findElement(By.id("src"));
		source.sendKeys("Chennai");
		Thread.sleep(1000);
		source.sendKeys(Keys.ENTER);
		
		// 3. Type Bengaluru in Destination textBox and ENTER
		WebElement destination = driver.findElement(By.id("dest"));
		destination.sendKeys("Bengaluru");
		Thread.sleep(1000);
		destination.sendKeys(Keys.ENTER);
		
		// 4. Choose any date 
		driver.findElement(By.id("onward_cal")).click();
		driver.findElement(By.xpath("//td[@class=\"next\"]/button")).click();
		driver.findElement(By.xpath("(//td[@class=\"we day\"])[7]")).click();
		
		// 5. Search Buses
		driver.findElement(By.id("search_btn")).click();
		//driver.findElement(By.xpath("//button[@class='fl button' and @id='search_btn']")).click();
		// driver.findElement(By.xpath("//button[text()='Search Buses']")).click();
		
		// Thread.sleep(1000);

		// 6. Close the popup using the X button at the right corner
		 driver.findElement(By.xpath("(//i[@class=\"icon icon-close c-fs\"])")).click();
		// driver.findElement(By.xpath("//div[@class='close']")).click();
		
		// Thread.sleep(1000);
		
		// 7. Print the number of search results
		String searchResults = driver.findElement(By.xpath("//span[@class=\"f-bold busFound\"]")).getText();
		System.out.println("No. Of buses found total : " + searchResults);
		// 8. Choose only Sleeper Bus
		driver.findElement(By.xpath("//label[@for=\"bt_SLEEPER\"]")).click();
		// 9. Print the number of search results
		String searchResults1 = driver.findElement(By.xpath("//span[@class=\"f-bold busFound\"]")).getText();
		System.out.println("No. of sleeper buses found : " + searchResults1);
		// 10. Deselect the sleeper Bus and select the AC bus alone
		driver.findElement(By.xpath("//label[@for=\"bt_SLEEPER\"]")).click();
		driver.findElement(By.xpath("//label[@for=\"bt_AC\"]")).click();
		// 11. Print the number of search results
		String searchResults2 = driver.findElement(By.xpath("//span[@class=\"f-bold busFound\"]")).getText();
		System.out.println("No. of A/C buses found : " + searchResults2);
		// 12. Choose also Non AC buses
		driver.findElement(By.xpath("//label[@for=\"bt_NONAC\"]")).click();
		// 13. Print the number of search results
		String searchResults3 = driver.findElement(By.xpath("//span[@class=\"f-bold busFound\"]")).getText();
		System.out.println("No. of A/C and Non A/C buses found : " + searchResults3); 


	}

}
