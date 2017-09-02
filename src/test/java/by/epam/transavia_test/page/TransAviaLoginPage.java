package by.epam.transavia_test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransAviaLoginPage extends TransAviaPage{
	
	private WebDriver driver;
	public TransAviaLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	By inputBookingNumber = By.id("retrieveBookingByLastname_RecordLocator");
	By inputLastName = By.id("retrieveBookingByLastname_LastName");
	By inputFlightDate = By.id("retrieveBookingByLastname_FlightDate-datepicker");
	By buttonViewBooking = By.xpath(".//button[text() = 'View booking']");
	By inputEMail = By.id("loginID");
	By feedbackBar = By.xpath(".//div[@class='usabilla_live_button_container']");
	
	public TransAviaBookingOverviewPage login(String bookingNumber, String lastName, String flightDate) {
		/*WebDriverWait myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.visibilityOfElementLocated(feedbackBar));*/
		
		mySleep(25000);
		WebDriverWait myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.elementToBeClickable(buttonViewBooking));
	//	driver.findElement(inputBookingNumber).click();
		driver.findElement(inputBookingNumber).sendKeys(bookingNumber);
		//driver.findElement(inputLastName).click();
		driver.findElement(inputLastName).sendKeys(lastName);
		//driver.findElement(inputFlightDate).click();
		driver.findElement(inputFlightDate).sendKeys(flightDate);
		driver.findElement(inputLastName).click();
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(buttonViewBooking));
		mySleep(5000);
		//driver.findElement(buttonViewBooking).click();
		Actions myAction = new Actions(driver);
		myAction.click(driver.findElement(buttonViewBooking)).build().perform();
		Actions myAction1 = new Actions(driver);
		myAction1.click(driver.findElement(buttonViewBooking)).build().perform();
		return new TransAviaBookingOverviewPage(driver);
	}

}
