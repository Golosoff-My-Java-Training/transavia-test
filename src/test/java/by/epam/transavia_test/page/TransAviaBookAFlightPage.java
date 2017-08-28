package by.epam.transavia_test.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.epam.transavia_test.TestBase;

public class TransAviaBookAFlightPage extends TransAviaPage{

	private WebDriver driver;
	By flightAvailBeads = By.xpath(".//span[@class = 'price-prefix']");
	By firstAvailFlightTile = By.xpath("(.//span[@class = 'price']/span[@class = 'price-prefix'])[1]");
	By selectButton = By.xpath("(.//span[text() = 'Select'])[1]");
	By nextButton = By.xpath("(.//button[@name = 'next_button'])[1]");
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
		mySleep(5000);
		System.out.println("жмем на (.//span[text() = 'Select'])[1]");
		driver.findElement(selectButton).click();
		System.out.println("нажали на (.//span[text() = 'Select'])[1]");
/*		Actions myAction1 = new Actions(driver);
		myAction1.click(driver.findElement(selectButton)).build().perform();*/
		System.out.println("ждем сообщения о появлении selectedMessage");
		WebDriverWait myWait1 = new WebDriverWait(driver, 20);
		myWait1.until(ExpectedConditions.visibilityOfElementLocated(selectedMessage));
		
	}

	public void pressNextButton() {
//		driver.findElement(nextButton).click();
		mySleep(3000);
		System.out.println("waiting  clickable nextButton");
		WebDriverWait myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.elementToBeClickable(nextButton));
		System.out.println("clicking nextButton");
		Actions myAction = new Actions(driver);
		myAction.click(driver.findElement(nextButton)).build().perform();
		System.out.println("clicked nextButton");
		mySleep(15000);
	}

}
