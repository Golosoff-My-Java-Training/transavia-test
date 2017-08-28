package by.epam.transavia_test.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.epam.transavia_test.TestBase;

public class TransAviaBookAFlightPage extends TransAviaPage{

	private WebDriver driver;
	By flightAvailBeads = By.xpath(".//span[@class = 'price-prefix']");
	By firstAvailOutboundFlightTile = By.xpath("(.//span[@class = 'price']/span[@class = 'price-prefix'])[1]");
	By selectOutboundButton = By.xpath("(.//span[text() = 'Select'])[1]");
	By selectedOutboundMessage = By.xpath(".//div[@class = 'panel flight-result active selected']/button/div[@class = 'actions']/div/span[text() = 'Selected']");
	By firstAvailInboundFlightTile = By.xpath("(.//section[@class = 'flight inbound']//span[@class = 'price']/span[@class = 'price-prefix'])[1]");
	By selectInboundButton = By.xpath("(.//section[@class = 'flight inbound']//span[text() = 'Select'])[1]");
	By selectedInboundMessage = By.xpath(".//section[@class = 'flight inbound']//div[@class = 'panel flight-result active selected']/button/div[@class = 'actions']/div/span[text() = 'Selected']");
	By nextButton = By.xpath("(.//button[@name = 'next_button'])[1]");

	public TransAviaBookAFlightPage(WebDriver driver) {
		this.driver = driver;
//		mySleep(15000);
	}

	public void checkForFlightAvailable() {
		
		Assert.assertTrue(driver.findElements(flightAvailBeads).size()>0);
		
		
		
	}

	public void selectFirstOutboundAvailableFlight() {
		Actions myAction = new Actions(driver);
		myAction.click(driver.findElement(firstAvailOutboundFlightTile)).build().perform();
		Wait myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.elementToBeClickable(selectOutboundButton));
		mySleep(5000);
		System.out.println("жмем на (.//span[text() = 'Select'])[1]");
		driver.findElement(selectOutboundButton).click();
		System.out.println("нажали на (.//span[text() = 'Select'])[1]");
		System.out.println("ждем сообщения о появлении selectedMessage");
		WebDriverWait myWait1 = new WebDriverWait(driver, 20);
		myWait1.until(ExpectedConditions.visibilityOfElementLocated(selectedOutboundMessage));
	}
	
	public void selectFirstInboundAvailableFlight() {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(firstAvailInboundFlightTile));
		Actions myAction = new Actions(driver);
		myAction.click(driver.findElement(firstAvailInboundFlightTile)).build().perform();
		Wait myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.elementToBeClickable(selectInboundButton));
		mySleep(2000);
		System.out.println("жмем на (.//span[text() = 'Select'])[1]");
		driver.findElement(selectInboundButton).click();
		System.out.println("нажали на (.//span[text() = 'Select'])[1]");
		System.out.println("ждем сообщения о появлении selectedMessage");
		WebDriverWait myWait1 = new WebDriverWait(driver, 20);
		myWait1.until(ExpectedConditions.visibilityOfElementLocated(selectedInboundMessage));
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