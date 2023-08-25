package day36_ApachePOI_2_DataDrivenTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FixedDepositeCalculator {
public static void main(String[] args) throws Exception {
	
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
	driver.manage().window().maximize();
	
//	String filePath = "C:\\Users\\surth\\eclipse-workspace\\SeleniumProject\\ExcelTestData\\caldata.xlsx";
//	String filePath = System.getProperty("user.dir")+"/ExcelTestData/caldata.xlsx";
	String filePath = "./ExcelTestData/caldata.xlsx";
	
	int noOfRows = ExcelUtils.getRowCount(filePath, "Sheet1");
	System.out.println("No.of Rows: "+noOfRows);
	
	driver.findElement(By.xpath("//button[@class='No thanks']")).click();
	
	for (int i = 1; i <= noOfRows; i++) {
		String principle = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
		String rateOfInt = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
		String perNo = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
		String perType = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
		String freq = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
		String exp_MatVal = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);
		
		
		//sending Principle amount
		driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principle);
		
		//sending Rate of interest
		driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateOfInt);
		
		//sending Time period
		driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(perNo);
		
		//selecting time period type
		Select selTenure = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
		selTenure.selectByVisibleText(perType);
		
		//selecting type of interest
		Select selFreq = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
		selFreq.selectByVisibleText(freq);
		
		
		//clicking on calculate button
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement calculate = driver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']"));
		js.executeScript("arguments[0].click();", calculate);
		
		//Validation and Updating excel sheet
		String act_value = driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();
		
		if (Double.parseDouble(act_value)== Double.parseDouble(exp_MatVal)) {
			System.out.println("Test Passed");
			ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Passed");
			ExcelUtils.fillGreenColor(filePath,"Sheet1", i, 7);
		}else {
			System.out.println("Test Failed");
			ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Failed");
			ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7);
		}
		
//		if (act_value.equals(exp_MatVal)) {
//			System.out.println("Test Passed");
//			ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Passed");
//			ExcelUtils.fillGreenColor(filePath,"Sheet1", i, 7);
//		}else {
//			System.out.println("Test Failed");
//			ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Failed");
//			ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7);
//		}
		
		//Clicking on CLEAR button
		WebElement clear = driver.findElement(By.xpath("//img[@class='PL5']"));
		js.executeScript("arguments[0].click();", clear);
		
	}
	
	
	
}
}
