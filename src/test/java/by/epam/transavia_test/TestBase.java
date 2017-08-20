package by.epam.transavia_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class TestBase {
	
	public static final String TRANSAVIA_COM_URL = "https://www.transavia.com";
	
	protected WebDriver driver;
	@BeforeTest
	public void setup(){
		
//		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "C://driver//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(TRANSAVIA_COM_URL);
				
	}

	@AfterTest
	public void close(){
		driver.close();
	}
	
	
	
}
