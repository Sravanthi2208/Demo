package test;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Property_File {
	WebDriver driver;
	Properties con;
	@BeforeTest
	public void setUp()throws Throwable
	{
		con = new Properties();
		con.load(new FileInputStream("OR.Properties"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(con.getProperty("Url"));

	}
	@Test
	public void verifyLogin()  
	{
		driver.findElement(By.xpath(con.getProperty("ObjReset"))).click();
		driver.findElement(By.xpath(con.getProperty("Objuser"))).sendKeys(con.getProperty("admin"));
		driver.findElement(By.xpath(con.getProperty("Objpass"))).sendKeys(con.getProperty("master"));
		driver.findElement(By.xpath(con.getProperty("ObjLoginbtn"))).click();
		String Expected_Title = "Users « Stock Accounting";
		String Actual_title = driver.getTitle();
		if(Expected_Title.equalsIgnoreCase(Actual_title)) 
		{
			Reporter.log("Login Success::"+Expected_Title+"   "+Actual_title,true);
		}else 
		{
			Reporter.log("Login Fail::"+Expected_Title+"   "+Actual_title,true);
		}
	}
	@AfterTest
	public void tearDown() 
	{
		driver.quit();
	}
	



}
