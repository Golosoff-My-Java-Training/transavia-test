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
	By nextButton = By.xpath(".//button(@name = 'next_button'");
	By selectedMessage = By.xpath(".//div[@class = 'panel flight-result active selected']/button/div[@class = 'actions']/div/span[text() = 'Selected']");

	public TransAviaBookAFlightPage(WebDriver driver) {
		this.driver = driver;
//		mySleep(15000);
	}

	public void checkForFlightAvailable() {
		
		Assert.assertTrue(driver.findElements(flightAvailBeads).size()>0);
		
		
		
	}

	public void selectFirstAvailableFlight() {
	//	mySleep(15000);
	//	driver.findElement(firstAvailFlightTile).click();
		Actions myAction = new Actions(driver);
		myAction.click(driver.findElement(firstAvailFlightTile)).build().perform();
		Wait myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.elementToBeClickable(selectButton));
//		driver.findElement(selectButton).click();
		Actions myAction1 = new Actions(driver);
		myAction1.click(driver.findElement(selectButton)).build().perform();
		WebDriverWait myWait1 = new WebDriverWait(driver, 60);
		myWait1.until(ExpectedConditions.visibilityOfElementLocated(selectedMessage));
		
	}

	public void pressNextButton() {
//		driver.findElement(nextButton).click();
//		mySleep(3000);
		WebDriverWait myWait = new WebDriverWait(driver, 60);
		myWait.until(ExpectedConditions.elementToBeClickable(firstAvailFlightTile));
		Actions myAction = new Actions(driver);
		myAction.click(driver.findElement(firstAvailFlightTile)).build().perform();
		mySleep(15000);
	}

}
