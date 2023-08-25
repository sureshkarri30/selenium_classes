package day24_s5_Xpaths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XpathExample1 {

	public static void main(String[] args) throws Exception {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://demo.opencart.com/");
//		driver.manage().window().maximize();
		Thread.sleep(3000);
		
	}

}
