package by.epam.transavia_test.page;

import org.openqa.selenium.WebDriver;

public class TransAviaBookAFlightPage {

	private WebDriver driver;

	public TransAviaBookAFlightPage(WebDriver driver) {
		this.driver = driver;
	}

	public void checkForFlightAvailable() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
