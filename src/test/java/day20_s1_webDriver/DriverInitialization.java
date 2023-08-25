package day20_s1_webDriver;

import java.util.Scanner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverInitialization {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter browser name: ");

		String browser = sc.nextLine();
		if (browser.equalsIgnoreCase("chrome")) {
			Web_driver.driver = new ChromeDriver();
			Web_driver.driver.get(Web_driver.url);
		} else if (browser.equalsIgnoreCase("edge")) {
			Web_driver.driver = new EdgeDriver();
			Web_driver.driver.get(Web_driver.url);
		} else {
			System.out.println("entered improper browser");
		}

//		WebDriver driver = new Driver();
//		driver.get("https://www.google.com/");
		sc.close();

	}

}
