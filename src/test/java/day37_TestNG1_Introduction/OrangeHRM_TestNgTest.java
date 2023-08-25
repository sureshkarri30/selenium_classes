package day37_TestNG1_Introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrangeHRM_TestNgTest {

	// 1) Launch browser
	WebDriver driver = new ChromeDriver();

	@Test(priority = 1)
	public void login() {
		// 3) Provide username - Admin
//		driver.findElement(By.name("username")).sendKeys("Admin");
		WebElement userName = driver.findElement(By.name("username"));
		userName.sendKeys("Admin");

		// 4) Provide password - admin123
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");

		// 5) Click on Login button
		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();

	}

	@Test(priority = 2)
	public void logout() {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(25));
		Actions act = new Actions(driver);
		WebElement dropDown = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
		act.moveToElement(dropDown).click(dropDown).perform();
		WebElement logout = driver.findElement(By.xpath("//a[contains(.,'Logout')]"));
		mywait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']"))));
		mywait.until(ExpectedConditions.elementToBeClickable(logout));
		logout.click();
//		mywait.until(ExpectedConditions.visibilityOf(logout));
//		act.moveToElement(logout).click().perform();
	}

	@BeforeClass
	public void beforeClass() {

		// 2) open url https://opensource-demo.orangehrmlive.com/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
