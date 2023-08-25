package day29_s10_Handling_Iframes_Windows;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrameExample1 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		
		//frame1
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);//by web element
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("FRAME1");
		//Switch to default frame
		driver.switchTo().defaultContent();
		//frame2
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);//by web element
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("FRAME2");
		//Switch to default frame
		driver.switchTo().defaultContent();
		//frame3
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);//by web element
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("FRAME3");
		
		//Switching to inner frame
		WebElement innerFrame3 = driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(innerFrame3);//by web element
		driver.findElement(By.xpath("//span[@dir='auto' and contains(.,'I am a human')]")).click();
		
		//Switch to default frame
		driver.switchTo().defaultContent();
		//frame3
		WebElement frame4 = driver.findElement(By.xpath("//frame[@src='frame_4.html']"));
		driver.switchTo().frame(frame4);//by web element
		driver.findElement(By.xpath("//input[@name='mytext4']")).sendKeys("FRAME4");
		
		
		
		
		
		
	}

}
