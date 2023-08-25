package day29_s10_Handling_Iframes_Windows;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_Windows {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//enter user name
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("Admin");
		
		
	
		//clicking orange inc (Opening another tab)
		driver.findElement(By.xpath("//a[contains(.,'OrangeHRM, Inc')]")).click();
		
		//capturing the window handlings
		Set <String> windowHandles = driver.getWindowHandles();
		
		String title = "OrangeHRM";
		for (String windowHandle : windowHandles) {
			driver.switchTo().window(windowHandle);
			if (!driver.getTitle().equals(title)) {
				break;
			}
		}
		
		Thread.sleep(2000);
		// clicking on book a demo
		driver.findElement(By.xpath("//a[contains(@href,'book-a')]")).click();
		
		for (String windowHandle : windowHandles) {
			driver.switchTo().window(windowHandle);
			if (driver.getTitle().equals(title)) {
				break;
			}
		}
		// enter password
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		//click on login
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
	}

}
