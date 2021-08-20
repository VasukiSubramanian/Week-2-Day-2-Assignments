package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundDropDownPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// select last but before one option
		WebElement drop = driver.findElement(By.id("dropdown1"));
		Select select = new Select(drop);
		int size = select.getOptions().size();
		select.selectByIndex(size - 2);

		// Select Training program using index
		WebElement drop1 = driver.findElement(By.id("dropdown1"));
		Select select1 = new Select(drop1);
		select1.selectByIndex(1);

		// Select training program using Text
		WebElement drop2 = driver.findElement(By.name("dropdown2"));
		Select select2 = new Select(drop2);
		select2.selectByVisibleText("Selenium");

		// Select training program using Value
		WebElement drop3 = driver.findElement(By.id("dropdown3"));
		Select select3 = new Select(drop3);
		select3.selectByValue("1");

		// Get the number of dropdown options
		WebElement drop4 = driver.findElement(By.className("dropdown"));
		Select select4 = new Select(drop4);
		System.out.println("Number of dropdown options : " + select4.getOptions().size());

		// Use SendKeys to select
		driver.findElement(By.xpath("//section[@class=\"innerblock\"]/div[5]/select")).sendKeys("Selenium");

		// Select multiple programs
		WebElement drop6 = driver.findElement(By.xpath("//section[@class=\"innerblock\"]/div[6]/select"));
		Select select6 = new Select(drop6);
		select6.selectByIndex(1);
		select6.selectByIndex(2);

	}

}
