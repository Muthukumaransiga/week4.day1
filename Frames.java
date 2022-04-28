package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		
		//*  Launch URL "https://chercher.tech/practice/frames-example-selenium-webdriver"
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		System.out.println("Application Launched");
		driver.manage().window().maximize();
		
		// Go to the frame1
		driver.switchTo().frame("frame1");
		
		// Add the hello every one content using the xpath
		driver.findElement(By.xpath("//b[@id= 'topic']//following-sibling::input")).sendKeys("Hello Everyone");
		
		//Go to the frame3
		driver.switchTo().frame("frame3");
		
		//click the check box
		driver.findElement(By.id("a")).click();
		
		// Switch to the default place
		driver.switchTo().defaultContent();
		
		// Go to the frame2
		driver.switchTo().frame("frame2");
		
		// Select the animal dropdown value in Avatar
		WebElement animals =driver.findElement(By.id("animals"));
		Select select = new Select(animals);
		select.selectByVisibleText("Avatar");

	}

}
