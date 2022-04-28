package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	
	public static void main(String[] args) throws InterruptedException {
		
		//* 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  
		// * 2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		// * 3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		
		// * 4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		// * 5. Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		
		// * 6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		System.out.println("Clicked on Merge Contacts");
		
		// * 7. Click on Widget of From Contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();		
		 
		// * 8. Click on First Resulting Contact
		// Inorder to click we have to use window handling
			Set<String> windowHandles = driver.getWindowHandles();
			//Create an empty list to store window handles inorder to getwindowhangeles in order
			List<String> winList = new ArrayList<String>(windowHandles);
			// Now get into the first window
			driver.switchTo().window(winList.get(1));
			//To click on first resulting contact
			Thread.sleep(3000);
			//driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1])")).click();	
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		
		// * 9. Click on Widget of To Contact
			driver.switchTo().window(winList.get(0));
	
		 //* 10. Click on Second Resulting Contact
			driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();	
			
			Set<String> windowHandles2 = driver.getWindowHandles();
			//Create an empty list to store window handles inorder to getwindowhangeles in order
			List<String> winList2 = new ArrayList<String>(windowHandles2);
			
			driver.switchTo().window(winList2.get(1));
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
			
			driver.switchTo().window(winList.get(0));
	 
		 //* 11. Click on Merge button using Xpath Locator
			driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		// * 12. Accept the Alert
			driver.switchTo().alert().accept();
	
		// * 13. Verify the title of the page
		String title = driver.getTitle();
		if(title.contains("View Contact")) {
			System.out.println("Passed");
	}
		else {
			System.out.println("Failed");

		}
		}

}
