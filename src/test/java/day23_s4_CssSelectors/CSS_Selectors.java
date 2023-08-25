package day23_s4_CssSelectors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSS_Selectors {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		// 1) tagname # id
		
		List<WebElement> products = driver.findElements(By.xpath("//ul[@class='top-menu mobile']/li"));
		for (WebElement webElement : products) {
			System.out.println(webElement.getText());
//			System.out.println(webElement.getAttribute("href"));
		}
		driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("macBook");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		System.out.println(driver.findElement(By.cssSelector("button[type='submit']")).getText());
		Thread.sleep(3000);

//		//2) tagname . class 
		driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("apple");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(3000);
//		
//		//3) tagname  [Attribute='attribute value']
		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("computer");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(3000);
//		
////		String s = "aadi\"\"pursh";
////		System.out.println(s);

//		//4) tagname.class[Attribute='attribute value']
		driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("iphone");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(3000);

		driver.findElement(By.cssSelector("img[alt='nopCommerce demo store']")).click();

//		ArrayList<Integer> list2= new ArrayList<Integer>() ;
		List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='top-menu mobile']/li/a"));
		System.out.println(elements.size());
		for (WebElement webElement : elements) {
			System.out.println(webElement.getText());
			System.out.println(webElement.getAttribute("href"));
		}
	}

}
