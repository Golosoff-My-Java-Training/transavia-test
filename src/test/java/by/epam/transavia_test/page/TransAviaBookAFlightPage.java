package by.epam.transavia_test.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransAviaBookAFlightPage extends TransAviaPage{

	private WebDriver driver;
	By flightAvailBeads = By.xpath(".//span[@class = 'price-prefix']");
	By firstAvailFlightTile = By.xpath("(.//span[@class = 'price']/span[@class = 'price-prefix'])[1]");
	By selectButton = By.xpath(".//span[text() = 'Select']");

	public TransAviaBookAFlightPage(WebDriver driver) {
		this.driver = driver;
	}

	public void checkForFlightAvailable() {
		mySleep(15000);
		Assert.assertTrue(driver.findElements(flightAvailBeads).size()>0);
		
		
		
	}

	public void selectFirstAvailableFlight() {
		mySleep(10000);
	//	driver.findElement(firstAvailFlightTile).click();
		Actions myAction = new Actions(driver);
		myAction.click(driver.findElement(firstAvailFlightTile)).build().perform();
		Wait myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.elementToBeClickable(selectButton));
		driver.findElement(selectButton).click();
		mySleep(15000);
	}

}
