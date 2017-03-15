package guru99.ecommerce.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Settings {

	public WebDriver driver;
	String baseurl = "http://live.guru99.com";
	String driverpath = "F:\\Driver\\Chrome\\";
	
	@BeforeTest
	public void Siteup () {
		System.setProperty("webdriver.chrome.driver",driverpath+ "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseurl);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void teardown () {
		driver.quit();
	}
	
	
	
}
