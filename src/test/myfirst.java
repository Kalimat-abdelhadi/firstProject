package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myfirst {

	
	WebDriver driver = new EdgeDriver(); 
	
	String THEWEBSITE = "https://www.saucedemo.com/";
	String UserName="standard_user";
	String Password="secret_sauce";

	@BeforeTest
	public void mySetup() {
		
		driver.manage().window().maximize();
		
		driver.get(THEWEBSITE);
		
	}
	
	
	@Test(priority = 1)
	public void login() throws InterruptedException {
		WebElement UserNameInput= driver.findElement(By.id("user-name"));
		WebElement PasswordInput=driver.findElement(By.id("password"));
		WebElement loginButton=driver.findElement(By.id("login-button"));
		
		
		UserNameInput.sendKeys(UserName);
		PasswordInput.sendKeys(Password);
		Thread.sleep(2000);
		loginButton.click();
	}
	
	@Test(priority = 2)
	public void addItemToThecart() throws InterruptedException {
		WebElement SauceLab= driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		SauceLab.click();
		Thread.sleep(1000);
	}
	
	@Test(priority = 3)
	public void removeItemFromTheCart() {
		WebElement RemoveSauceLab=driver.findElement(By.id("remove-sauce-labs-backpack"));
		RemoveSauceLab.click();
	}
	@Test(priority=4)
	public void logOut() throws InterruptedException {
		WebElement	burgerMenue=driver.findElement(By.id("react-burger-menu-btn"));
		WebElement	LogOut=driver.findElement(By.id("logout_sidebar_link"));
		WebElement MainLogo=driver.findElement(By.className("login_logo"));
		
		burgerMenue.click();
		Thread.sleep(1000);
		LogOut.click();
		System.out.print(MainLogo.getText());
		
	}
	
	@AfterTest
	public void myAfterTest() {
		
//		driver.quit();
	}

}
