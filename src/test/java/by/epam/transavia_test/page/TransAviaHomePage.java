package by.epam.transavia_test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TransAviaHomePage extends TransAviaPage{

	private WebDriver driver;
	By fromField = By.xpath(".//input[@id = 'routeSelection_DepartureStation-input']");
	By fromEdinburg = By.xpath(".//li[text() = 'Edinburgh, United Kingdom']");
	By toField = By.xpath(".//input[@id = 'routeSelection_ArrivalStation-input']");
	By toParisOrly = By.xpath(".//li[text() = 'Paris (Orly South), France']");
	By departCalendar = By.xpath(".//span[@class = 'datepicker-trigger icon-font icon-calendar']");
	//By firstActiveDepartData = By.xpath("(.//td[@data-selectable-day = ''])[1]");
	//By firstActiveDepartData = By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[2]/a");
	By currentDayData = By.xpath(".//td[@class = 'ui-datepicker-current-day']/a");
	By returnOnCheckBox = By.id("dateSelection_IsReturnFlight");
	By whoWillBeTravelingField = By.id("booking-passengers-input");
	By searchButton = By.xpath("(.//button[@class='button button-primary'])[2]");
	
	public TransAviaHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void chooseFrom() {

		driver.findElement(fromField).click();
		driver.findElement(fromEdinburg).click();

	}

	
	public void chooseToCountry() {
		driver.findElement(toField).click();
		mySleep(2000);
		driver.findElement(toParisOrly).click();
	}

	

	public void chooseDepartDate() {
//		mySleep(5000);
		
		driver.findElement(departCalendar).click();
//		mySleep(5000);
		Actions myAction = new Actions(driver);
		myAction.click(driver.findElement(currentDayData)).build().perform();
	}
	


	public void uncheckReturnOn() {
		driver.findElement(returnOnCheckBox).click();
		mySleep(2000);
		
	}

	public void chooseOneAdult() {
		System.out.println(driver.findElement(whoWillBeTravelingField).getText());
		
	}

	public TransAviaBookAFlightPage pressSearchButton() {
		Actions myAction = new Actions(driver);
		myAction.click(driver.findElement(searchButton)).build().perform();
		return new TransAviaBookAFlightPage(driver);
	}


}
