	package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaBrand {

	public static void main(String[] args) {
		
		//Download the Chrome driver
		WebDriverManager.chromedriver().setup();
		
		//Launch the browser
		ChromeDriver driver = new ChromeDriver();
		
		//1) Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
			
		//2) Mouseover on Brands and Search L'Oreal Paris
		WebElement findElement = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions act = new Actions(driver);
		act.moveToElement(findElement).perform();
				
		//3) Click L'Oreal Paris
		driver.findElement(By.xpath("//img[contains(@src,'lorealparis')]")).click();
		
		//4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		String title = driver.getTitle();
		if (title.contains("paris")) {
		System.out.println("Title contains paris");
		}
		//5) Click sort By and select customer top rated
		driver.findElement(By.xpath("//span[contains(text(),'Sort By')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'top rated')]")).click();
		
		
		//6) Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//span[contains(text(),'Category')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Hair')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Hair Care')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Shampoo')]")).click();
		
		//7) Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[contains(text(),'Concern')]")).click();	
	
		driver.findElement(By.xpath("//span[contains(text(),'Color Protection')]")).click();
		
		
		//8)check whether the Filter is applied with Shampoo
		String text = driver.findElement(By.xpath("//span[contains(text(),'Shampoo')]")).getText();
		if(text.contains("Shampoo"))
		{
		System.out.println("It contains shampoo");
		}
		else {
			System.out.println("It does not contains shampoo");
		}
		
		//9) Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div[contains(text(),'Colour Protect Shampoo')]")).click();
		
		//10) GO to the new window and select size as 175ml
		Set<String> winSet = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(winSet);
		
		//11) Print the MRP of the product
		String text2 = driver.findElement(By.xpath("//span[contains(text(),'MRP')]")).getText();
		
		System.out.println(text2);
		
		//12) Click on ADD to BAG
		driver.findElement(By.xpath("//div[contains(text(),'ADD TO BAG')]")).click();
		
		//13) Go to Shopping Bag
		driver.findElement(By.xpath("//div[contains(text(),'Account')]/following::span")).click();
		
		//14) Print the Grand Total amount
		String gt1 = driver.findElement(By.xpath("//div[@class='first-col')]")).getText();
		String replaceAll = gt1.replaceAll("\\D", "");
		int grantTotal = Integer.parseInt(replaceAll);
		System.out.println("Grant Total"+grantTotal );
		
		//15) Click Proceed
		driver.findElement(By.xpath("//div[contains(text(),'PROCEED')]")).click();
		
		//16) Click on Continue as Guest
		driver.findElement(By.xpath("//button[contains(text(),'GUEST')]")).click();
		
		//17) Check if this grand total is the same in step 14
		String gt2 = driver.findElement(By.xpath("//div[contains(text(),'Grand Total')]/following::div[1]")).getText();
		String replaceAll2 = gt1.replaceAll("\\D", "");
		int grantTotal2 = Integer.parseInt(replaceAll);
		System.out.println("Grant Total"+grantTotal2 );
		
		if(grantTotal == grantTotal2) {
			System.out.println("Both are same");
		}
		else {
			System.out.println("Both are not same");
		}
			
		
		//18) Close all windows

	}

}
