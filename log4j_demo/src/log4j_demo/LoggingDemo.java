package log4j_demo;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoggingDemo {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("src/Log4j_demo/Log4j.xml");
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe"); 
		   WebDriver driver=new ChromeDriver();
		 //  Logger log = Logger.getLogger("devpinoyLogger");
			 Logger log = Logger.getLogger(LoggingDemo.class);

		  driver.get("http://www.google.com");
		  log.debug("opening webiste");
		  driver.manage().window().maximize();
		  log.debug("maximizing webiste");
		  log.info("maximizing webiste1");

	}

}
