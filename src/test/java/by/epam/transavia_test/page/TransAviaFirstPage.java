package by.epam.transavia_test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TransAviaFirstPage {

	private WebDriver driver;
	By unitedKingdom = By.xpath(".//ul[@class = 'language-switch_list']/li[3]");

	public TransAviaFirstPage(WebDriver driver) {
		this.driver = driver;
	}

	public TransAviaHomePage chooseSelectYourCountry(String selectYourCountry) {
		driver.findElement(unitedKingdom).click();
		return new TransAviaHomePage(driver);
	}

}
