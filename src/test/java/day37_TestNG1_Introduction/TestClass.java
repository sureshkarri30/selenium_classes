package day37_TestNG1_Introduction;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClass {

	
	@BeforeClass
	public void openBrowser() {
		System.out.println("I am from Open Browser");
	}
	
	@Test(priority = 2)
	public void login() {
		System.out.println("I am from Login");
	}
	
	@Test(priority = 3)
	public void logout() {
		System.out.println("I am from Logout");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("I am from closeBrowser");
	}
}
