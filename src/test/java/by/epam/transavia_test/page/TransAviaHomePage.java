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

	public TransAviaHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void chooseFrom() {
		/*
		 * Select selectFrom = new
		 * Select(driver.findElements(fromField).get(0));
		 * selectFrom.selectByVisibleText("Edinburgh, United Kingdom");
		 */
		driver.findElement(fromField).click();
		driver.findElement(fromEdinburg).click();

		myWait();
	}

	public void chooseToCountry() {
		driver.findElement(toField).click();
		driver.findElement(toParisOrly).click();
		myWait();
	}

	public void myWait() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
