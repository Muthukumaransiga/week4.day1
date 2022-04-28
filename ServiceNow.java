package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		System.out.println("Driver Setup is done");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev121343.service-now.com");
		System.out.println("Application Launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.xpath("//button[text() = 'Log in']")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("filter")).sendKeys("incident");
		//Thread.sleep(3000);
		//String mainWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//span[text() = 'Incident']//parent::a//following-sibling::ul//div[text() = 'All']")).click();
		System.out.println("Clicked on : Incident- All");
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//button[text() = 'New']")).click();
		System.out.println("Clicked on : New");
		
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		System.out.println("Clicked on : Caller");
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowList.get(1));
		driver.findElement(By.xpath("//table[@id = 'sys_user_table']//tbody/tr/td[@style= '']/a")).click();
		System.out.println("Filtered with Caller");
		driver.switchTo().window(windowList.get(0));
		System.out.println(driver.getTitle());
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@aria-label = 'Short description']")).sendKeys("Isuue in Incident");
		System.out.println("Entered Discription");
		
		String incident = driver.findElement(By.id("incident.number")).getAttribute("value");
		driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
		System.out.println("Submited Incident");
//		driver.switchTo().window(mainWindow);
//		System.out.println(driver.getTitle());
		//driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@class = 'form-control'][@placeholder = 'Search']")).sendKeys(incident, Keys.ENTER);
		System.out.println("Searched with Incident: "+incident);

		String incidentAfterSearch = driver.findElement(By.xpath("//table[@id = 'incident_table']//tbody//td[contains(@class, 'list_decoration_cell')][contains(@class, 'col-small')][contains(@class, 'col-center')][not(contains(@class, 'col-control'))]//following-sibling::td/a[contains(text(), 'INC')]")).getText();
		if(incident.equals(incidentAfterSearch))
		{
			System.out.println("Incident Created Successfully");
		}
	}

}
