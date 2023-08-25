
package day31_s12_Handling_DatePickers;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Date_Picker_Example {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/datepicker/");

		
		WebElement iframe = driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(iframe);
		
		WebElement dateInput = driver.findElement(By.xpath("//input[@id='datepicker']"));
		dateInput.click();
//Approach 1
//		dateInput.sendKeys("12/23/2026");//future date
//		dateInput.sendKeys("12/23/2015");//past date
		
		
//Approach 2
		String month = "May";
		String day = "6";
		String year = "2020";
		
		
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy");  
	    String strDate= formatter.format(date);  
        System.out.println(strDate);
		
        
        
        
		
		while(true) {
			WebElement monthPicker = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[1]"));
			WebElement yearPicker = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[2]"));
			
			if((monthPicker.getText()).equals(month)&& (yearPicker.getText()).equals(year)) {
				break;
			}
			
			WebElement select= Integer.parseInt(year)>Integer.parseInt(strDate) ? driver.findElement(By.xpath("//a/span[contains(.,'Next')]")): driver.findElement(By.xpath("//a/span[contains(.,'Prev')]"));
//			WebElement prev = driver.findElement(By.xpath("//a/span[contains(.,'Prev')]"));
//			prev.click();
//			WebElement next = driver.findElement(By.xpath("//a/span[contains(.,'Next')]"));
//			next.click();
			select.click();
		}
		
		List <WebElement> selectDate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//td"));
		
		for (WebElement daySelect : selectDate) {
			if((daySelect.getText()).equals(day)) {
				daySelect.click();
				break;
			}
		}
		
		
		
	}

}
