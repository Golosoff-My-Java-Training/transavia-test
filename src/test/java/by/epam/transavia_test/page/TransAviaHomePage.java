package by.epam.transavia_test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TransAviaHomePage {

	private WebDriver driver;
	By fromField = By.xpath(".//input[@id = 'routeSelection_DepartureStation-input']");
	By fromEdinburg = By.xpath(".//li[text() = 'Edinburgh, United Kingdom']");
	By toField = By.xpath(".//input[@id = 'routeSelection_ArrivalStation-input']");
	By toParisOrly = By.xpath(".//li[text() = 'Paris (Orly South), France']");
	By departCalendar = By.xpath(".//span[class = 'datepicker-trigger icon-font icon-calendar'][1]");
	By firstActiveDepartData = By.xpath(".//td[data-selectable-day = ''][1]");

	public TransAviaHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void chooseFrom() {
		/*
		 * Select selectFrom = new
		 * Select(driver.findElements(fromField).get(0));
		 * selectFrom.selectByVisibleText("Edinburgh, United Kingdom");
		 */
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
		driver.findElement(firstActiveDepartData).click();
		mySleep(2000);
	
	}
	
	private void mySleep(int millisForWait) {
		try {
			
			Thread.sleep(millisForWait);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
