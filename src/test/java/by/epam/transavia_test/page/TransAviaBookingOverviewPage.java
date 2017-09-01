package by.epam.transavia_test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransAviaBookingOverviewPage extends TransAviaPage{
	private WebDriver driver;

	public TransAviaBookingOverviewPage(WebDriver driver) {
		this.driver = driver;
	}

	By arrivalTime = By.xpath("(.//p[@class = 'flight-info_value']/em/time)[2]");

	public void checkArrivalTime() {
		mySleep(15000);
		System.out.println("Arrival time is: " + driver.findElement(arrivalTime).getText());
		
	}

}
