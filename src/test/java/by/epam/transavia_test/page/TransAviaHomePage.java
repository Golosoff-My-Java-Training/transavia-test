package by.epam.transavia_test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TransAviaHomePage {

	private WebDriver driver;
	By fromField = By.xpath(".//input[@id = 'routeSelection_DepartureStation-input']");
	By fromEdinburg = By.xpath(".//li[text() = 'Edinburgh, United Kingdom']");
	By toField = By.xpath(".//input[@id = 'routeSelection_ArrivalStation-input']");
	By toParisOrly = By.xpath(".//li[text() = 'Paris (Orly South), France']");
	By departCalendar = By.xpath(".//span[@class = 'datepicker-trigger icon-font icon-calendar']");
	//By departCalendar = By.xpath(".//*[@id='desktop']/section/div[2]/div[2]/div/div/div[1]/div/div[1]/span");
	//By firstActiveDepartData = By.xpath("(.//td[@data-selectable-day = ''])[1]");
	//By firstActiveDepartData = By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[2]/a");
	By firstActiveDepartData = By.xpath(".//td[@class = 'ui-datepicker-current-day']/a");
	//By firstActiveDepartData = By.linkText("23");
	By returnOnCheckBox = By.id("dateSelection_IsReturnFlight");
	By whoWillBeTravelingField = By.id("booking-passengers-input");
	By searchButton = By.xpath(".//button[@type = 'submit']");
	
	public TransAviaHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void chooseFrom() {

		mySleep(5000);
		driver.findElement(fromField).click();
		driver.findElement(fromEdinburg).click();

	}

	
	public void chooseToCountry() {
		driver.findElement(toField).click();
		driver.findElement(toParisOrly).click();
	}

	

	public void chooseDepartDate() {
		mySleep(5000);
		
		driver.findElement(departCalendar).click();
		mySleep(5000);
		Actions myAction = new Actions(driver);
		myAction.click(driver.findElement(firstActiveDepartData)).build().perform();
	}
	
	private void mySleep(int millisForWait) {
		try {
			
			Thread.sleep(millisForWait);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void uncheckReturnOn() {
		driver.findElement(returnOnCheckBox).click();
		mySleep(2000);
		
	}

	public void chooseOneAdult() {
		System.out.println(driver.findElement(whoWillBeTravelingField).getText());
		
	}

	public TransAviaBookAFlightPage pressSearchButton() {
		// driver.findElement(searchButton).click();
		
		Actions myAction = new Actions(driver);
		myAction.click(driver.findElement(searchButton)).build().perform();
		
		return new TransAviaBookAFlightPage(driver);
	}


}
