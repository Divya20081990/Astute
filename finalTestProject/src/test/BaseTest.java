package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BaseTest {

	public static WebDriver driver=null;

	@BeforeSuite
	public void initialize() {
		
		System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.get("http://www.demo.guru99.com/V4/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	
	@AfterSuite
	public void close() {
		
		driver.quit();
	}

}
