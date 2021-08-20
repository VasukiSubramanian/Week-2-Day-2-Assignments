package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafTapsEditLeadPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/main");
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// 2. Enter UserName "demosalesmanager"
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		// 3. Enter Password "crmsfa" Using Id Locator
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// 4. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		// 5. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		// 6. Click Leads Link
		driver.findElement(By.linkText("Leads")).click();
		// 7. Click Find Leads
		driver.findElement(By.linkText("Find Leads")).click();
		// 8. Enter first name
		driver.findElement(By.name("firstName")).sendKeys("c");
		// 9. Click Find leads button
		driver.findElement(By.xpath("(//button[@class=\"x-btn-text\"])[7]")).click();

		Thread.sleep(2000);

		// 10. Click on first resulting lead
		driver.findElement(By.xpath("(//div[@class=\"x-grid3-cell-inner x-grid3-col-partyId\"])/a")).click();
		// 11. Verify title of the page
		String title2 = driver.getTitle();
		if (title2.contains("View Lead"))
			System.out.println("Title verified OK");
		else
			System.out.println("Title verified not OK");
		// 12. Click Edit
		driver.findElement(By.linkText("Edit")).click();
		// 13. Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Old Company");
		// 14. Click Update
		driver.findElement(By.className("smallSubmit")).click();
		// 15. Confirm the changed name appears
		if (driver.findElement(By.id("viewLead_companyName_sp")).getText().contains("Old Company"))
			System.out.println("The changed name appears");
		else
			System.out.println("The changed name doesn't appear");
		// 16. Close the browser (Do not log out)
		driver.close();

	}

}
