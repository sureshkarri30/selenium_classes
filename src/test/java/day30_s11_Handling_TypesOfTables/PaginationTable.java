
package day30_s11_Handling_TypesOfTables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationTable {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));
		driver.get("https://demo.opencart.com/admin/index.php");

		// Login
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.clear();
		username.sendKeys("demo");
		
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.clear();
		password.sendKeys("demo");
		
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
	
		WebElement modelContant = driver.findElement(By.xpath("//div[@class='modal-content']"));
		WebElement modelContantClose = driver.findElement(By.xpath("//button[@class='btn-close']"));
	
		
		if (modelContant.isDisplayed()) {
			modelContantClose.click();
		}
		
		//customers drop down
		WebElement customersDropdwn = driver.findElement(By.xpath("//li[@id='menu-customer']"));
		customersDropdwn.click();
		
		WebElement customerOption = driver.findElement(By.xpath("//li[@id='menu-customer']//li/a[contains(@href,'customer&user')]"));
		customerOption.click();
		
		WebElement noOfPages = driver.findElement(By.xpath("//div[@class='table-responsive']/following-sibling::div//div[contains(.,'Showing')]"));
		String pagesCount = noOfPages.getText();
		System.out.println(pagesCount);
		
		String count = pagesCount.substring(pagesCount.indexOf("(")+1, pagesCount.indexOf("P")-1);
		System.out.println(count);
		
		
		int pageNo = Integer.parseInt(count);
		int rows = driver.findElements(By.xpath("//table//tbody/tr")).size();
//		Actions action = new Actions(driver);
		for (int p = 1; p <= 5; p++) {
			
			if(pageNo>1)
			{
				WebElement active_Page=driver.findElement(By.xpath("//ul[@class='pagination']//li//*[text()="+p+"]"));	
				System.out.println(" Active Page : "+active_Page.getText());
//				action.moveToElement(active_Page,0,0);
//				active_Page.click();
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", active_Page);
				
				
				Thread.sleep(3000);
			}
			
			//table handling
			for (int r = 1; r <= rows; r++) {
				for (int c = 2; c <= 4; c++) {
					WebElement data = driver.findElement(By.xpath("//table//tbody/tr["+r+"]/td["+c+"]"));
					System.out.print(data.getText()+"\t");
				}
				System.out.println();
			}
//			WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']/li/a[contains(.,'"+p+"')]"));
//			wait.until(ExpectedConditions.elementToBeClickable(page));
//			page.click();
			
			
			
			
		}
		
		
		
		
		
		
	}

}
