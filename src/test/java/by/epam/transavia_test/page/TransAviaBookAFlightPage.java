package by.epam.transavia_test.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransAviaBookAFlightPage extends TransAviaPage{

	private WebDriver driver;
	By flightAvailBeads = By.xpath(".//span[@class = 'price-prefix']");

	public TransAviaBookAFlightPage(WebDriver driver) {
		this.driver = driver;
	}

	public void checkForFlightAvailable() {
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(driver.findElements(flightAvailBeads).size()>0);
		
		
		
	}

}
