package by.epam.transavia_test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransAviaLoginPage extends TransAviaPage{
	
	@FindBy(id = "retrieveBookingByLastname_RecordLocator")
	private WebElement inputBookingNumber;
	
	@FindBy(id = "retrieveBookingByLastname_LastName")
	private WebElement inputLastName;
	
	@FindBy(id = "retrieveBookingByLastname_FlightDate-datepicker")
	private WebElement inputFlightDate;
	
	@FindBy(xpath = ".//button[text() = 'View booking']")
	private WebElement buttonViewBooking;

	
	@FindBy(id = "loginID")
	private WebElement inputEMail;
	
	@FindBy(xpath = ".//div[@class='usabilla_live_button_container']")
	private WebElement feedbackBar;
	
	public TransAviaLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	

	public TransAviaBookingOverviewPage login(String bookingNumber, String lastName, String flightDate) {
		mySleep(25000);
		WebDriverWait myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.elementToBeClickable(buttonViewBooking));
		inputBookingNumber.sendKeys(bookingNumber);
		inputLastName.sendKeys(lastName);
		inputFlightDate.sendKeys(flightDate);
		inputLastName.click();
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", buttonViewBooking);
		mySleep(5000);
		Actions myAction = new Actions(driver);
		myAction.click(buttonViewBooking).build().perform();
		Actions myAction1 = new Actions(driver);
		myAction1.click(buttonViewBooking).build().perform();
		return new TransAviaBookingOverviewPage(driver);
	}

}
