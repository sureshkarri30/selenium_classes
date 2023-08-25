
package day31_s12_Handling_DatePickers;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Date_Picker_Example_Dynamic {

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
		String year = "2024";
		
		int monthValue = 0;
		switch (month) {
		case "January": monthValue =1;
			break;
		case "February": monthValue =2;
			break;
		case "March": monthValue =3;
		break;
		case "April": monthValue =4;
		break;
		case "May": monthValue =5;
		break;
		case "June": monthValue =6;
		break;
		case "July": monthValue =7;
		break;
		case "August": monthValue =8;
		break;
		case "September": monthValue =9;
		break;
		case "October": monthValue =10;
		break;
		case "November": monthValue =11;
		break;
		case "December": monthValue =12;
		break;
		default:System.out.println("Month name mismatched");
		}	
			
		Date date = new Date();  
	    SimpleDateFormat yformatter = new SimpleDateFormat("yyyy");  
	    String strYear= yformatter.format(date);  
	    System.out.println("Year value: "+strYear);
	    SimpleDateFormat mformatter = new SimpleDateFormat("M");  
	    String strMonth= mformatter.format(date);  
	    System.out.println("Month value: "+strMonth);
        
        
        
		
		while(true) {
			WebElement monthPicker = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[1]"));
			WebElement yearPicker = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[2]"));
			
			if((monthPicker.getText()).equals(month)&& (yearPicker.getText()).equals(year)) {
				break;
			}
			          
			
			WebElement select= 
			(Integer.parseInt(year)>Integer.parseInt(strYear)&&monthValue>Integer.parseInt(strMonth))||
			(Integer.parseInt(year)==Integer.parseInt(strYear)&&monthValue>Integer.parseInt(strMonth))||
			(Integer.parseInt(year)>Integer.parseInt(strYear)&&monthValue<Integer.parseInt(strMonth))
			
			
			? driver.findElement(By.xpath("//a/span[contains(.,'Next')]")): driver.findElement(By.xpath("//a/span[contains(.,'Prev')]"));
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
