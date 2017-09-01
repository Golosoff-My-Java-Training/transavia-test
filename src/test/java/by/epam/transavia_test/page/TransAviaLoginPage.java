package by.epam.transavia_test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransAviaLoginPage extends TransAviaPage{
	
	private WebDriver driver;
	public TransAviaLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	By inputBookingNumber = By.id("retrieveBookingByLastname_RecordLocator");
	By inputLastName = By.id("retrieveBookingByLastname_LastName");
	By inputFlightDate = By.id("retrieveBookingByLastname_FlightDate-datepicker");
	By buttonViewBooking = By.xpath(".//button[text() = 'View booking']");
	
	public TransAviaBookingOverviewPage login(String bookingNumber, String lastName, String flightDate) {
		driver.findElement(inputBookingNumber).sendKeys(bookingNumber);
		driver.findElement(inputLastName).sendKeys(lastName);
		driver.findElement(inputFlightDate).sendKeys(flightDate);
		driver.findElement(buttonViewBooking).click();
		mySleep(15000);
		return new TransAviaBookingOverviewPage(driver);
	}

}
