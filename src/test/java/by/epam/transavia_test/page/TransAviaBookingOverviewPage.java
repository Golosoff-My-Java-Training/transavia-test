package by.epam.transavia_test.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransAviaBookingOverviewPage extends TransAviaPage{


	@FindBy(xpath = "(.//p[@class = 'flight-info_value']/em/time)[2]")
	private WebElement arrivalTime;
	
	@FindBy(xpath = "(.//a[@class = 'icon-left-side icon-animation-next'])[1]")
	private WebElement toBookingDetails;
	
	public TransAviaBookingOverviewPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void checkArrivalTime() {
		mySleep(15000);
		System.out.println("Arrival time is: " + arrivalTime.getText());
		Assert.assertTrue(arrivalTime.getText() != null);
		
	}

	public TransAviaBookingDetailsPage goesToBookingDetails() {
		toBookingDetails.click();
		return new TransAviaBookingDetailsPage(driver);
	}

}
