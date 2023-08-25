package day30_s11_Handling_TypesOfTables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticPageExample {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

		// 1)Find no of rows in a table
		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		int noOfRows = rows.size();
		System.out.println("No of rows: " + noOfRows);

		// 2)Find no of cols in a table
		int noOfCols = driver.findElements(By.xpath("//table[@name='BookTable']//tr[1]/th")).size();
		System.out.println("No of cols: " + noOfCols);

		// 3) Read specific data
		String data = driver.findElement(By.xpath("//table[@name='BookTable']//tr[2]//td[3]")).getText();
		System.out.println(data);

		// 4) READ ALL DATA FROM A TABLE
		List<WebElement> tableHeaders = driver.findElements(By.xpath("//table[@name='BookTable']//th"));
		for (WebElement header : tableHeaders) {
			System.out.print(header.getText() + "\t");
		}
		System.out.println();
		for (int i = 2; i <= noOfRows; i++) {
			for (int j = 1; j <= noOfCols; j++) {
				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]//td[" + j + "]"))
						.getText();
				System.out.print(value + "\t");
			}
			System.out.println();
		}

		// 5)Print books names whose author is mukesh
		System.out.println("Books wrote by Mukhesh:");
		for (int i = 2; i <= noOfRows; i++) {
			String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]/td[2]"))
					.getText();
			if(author.equals("Mukesh")) {
			System.out.println(driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]/td[1]")).getText());
			}
		}

		
		//6)sum of all book prices
		int totalPrice = 0;
		for (int r = 2; r <= noOfRows; r++) {
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[4]")).getText();
			int cost = Integer.parseInt(price);
			totalPrice = totalPrice+cost;
//			totalPrice += cost;
		}
		System.out.println("Total price of books: "+totalPrice);
		
		
	}

}
