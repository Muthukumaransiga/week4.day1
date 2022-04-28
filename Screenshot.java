package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {

	public static void main(String[] args) throws IOException{
		// Launch URL http://leafground.com/pages/frame.html
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		System.out.println("Application Launched");
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File file =new File(".//snaps//screnshot.png");
		FileUtils.copyFile(src, file);
		int size = driver.findElements(By.xpath("//iframe")).size();
		System.out.println("Size of frame is "+size);

	}

}
