package day22_s3_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://github.com/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//1)Locator id
		WebElement userName = driver.findElement(By.id("login_field"));
		highlight(driver, userName);
		Thread.sleep(3000);
		
		
		//2)Locator name
		WebElement password = driver.findElement(By.name("password"));
		highlight(driver, password);
		Thread.sleep(3000);
		
		
		
		//3)Locator classname
		WebElement headerLogo = driver.findElement(By.className("header-logo"));
		highlight(driver, headerLogo);
		Thread.sleep(3000);
		
		//4)Locator Tagname
		WebElement heading = driver.findElement(By.tagName("h1"));
		highlight(driver, heading);
		Thread.sleep(3000);
		
		
		//5)Locator linktext
		WebElement forgetPassword = driver.findElement(By.linkText("Forgot password?"));
		highlight(driver, forgetPassword);
		Thread.sleep(3000);
		
		
		//6)Locator partial link text
		WebElement createAccount = driver.findElement(By.partialLinkText("Create"));
		highlight(driver, createAccount);
		Thread.sleep(3000);

		//7)Locator css selector
		WebElement signinButton = driver.findElement(By.cssSelector("input[name='commit']"));
		highlight(driver, signinButton);
		Thread.sleep(3000);
		
		
		//7)Locator xpath
		WebElement contactGit = driver.findElement(By.xpath("//a[contains(.,'Contact')]"));
		highlight(driver, contactGit);					
		Thread.sleep(3000);
	}

	
	
	public static void highlight(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
	}
}
