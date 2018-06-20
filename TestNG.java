package com.qait.testing.Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG {
	WebDriver driver;

	@BeforeTest
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\akanksha.yadav\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void Step01_LaunchHris() {
	
		driver.get("https://s-hris.qainfotech.com/login.php");
	}

	@Test
	public void Step_02_AttemptToLoginWithIncorrectPasswordWillShowInvalidLogin() {
		driver.findElement(By.cssSelector("input[id=txtUserName]")).sendKeys("akanksha.yadav");
		driver.findElement(By.id("txtPassword")).sendKeys("Incorrect_Password");
		driver.findElement(By.cssSelector("#login > form > div.loginTxtBtn.extraText > div > input")).submit();

		// Expected error Message

		Assert.assertTrue(
				driver.findElement(By.cssSelector("#login > form > div.loginTxt.txtHideDiv.alert.alert-error > div"))
						.getText().contains("INVALID LOGIN"));

	}
@Test
	
	public void Step_03_AttemptToLoginWithBlankPasswordWillHighlightRedBox()
	{
		driver.findElement(By.cssSelector("input[id=txtUserName]")).sendKeys("akanksha.yadav");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.cssSelector("#login > form > div.loginTxtBtn.extraText > div > input")).submit();
		
		//Expected Error
		
		Assert.assertTrue(
				driver.findElement(By.cssSelector("#login > form > div.loginTxt.txtHideDiv.alert.alert-error > div"))
						.getText().contains("INVALID LOGIN"));
	}
	
	@AfterTest

	public void Step_04_ClearForm()
	{
		driver.findElement(By.cssSelector("input[id=txtUserName]")).clear();
		driver.findElement(By.id("txtPassword")).clear();	
		
	}
	
	
		
	}
	
	
	
	


