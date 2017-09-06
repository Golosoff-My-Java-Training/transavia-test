package by.epam.transavia_test.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import by.epam.transavia_test.TestBase;

public class TransAviaBookAFlightPage extends TransAviaPage {

	@FindBy(xpath = ".//span[@class = 'price-prefix']")
	private List<WebElement> flightAvailBeads;

	@FindBy(xpath = "(.//span[@class = 'price']/span[@class = 'price-prefix'])[1]")
	private WebElement firstAvailOutboundFlightTile;

	@FindBy(xpath = "(.//span[text() = 'Select'])[1]")
	private WebElement selectOutboundButton;

	@FindBy(xpath = ".//div[@class = 'panel flight-result active selected']/button/div[@class = 'actions']/div/span[text() = 'Selected']")
	private WebElement selectedOutboundMessage;

	@FindBy(xpath = "(.//section[@class = 'flight inbound']//span[@class = 'price']/span[@class = 'price-prefix'])[1]")
	private WebElement firstAvailInboundFlightTile;

	@FindBy(xpath = "(.//section[@class = 'flight inbound']//span[text() = 'Select'])[1]")
	private WebElement selectInboundButton;

	@FindBy(xpath = ".//section[@class = 'flight inbound']//div[@class = 'panel flight-result active selected']/button/div[@class = 'actions']/div/span[text() = 'Selected']")
	private WebElement selectedInboundMessage;

	@FindBy(xpath = "(.//button[@name = 'next_button'])[1]")
	private WebElement nextButton;

	@FindBy(xpath = ".//div[@class='notification-message notification-inline notification-error']/p")
	private WebElement notificationErrorMessage;

	private String noFlightFromDubaiToAgadirMessage = "Unfortunately we do not fly from Dubai, United Arab Emirates to Agadir, Morocco. However, we do fly from Dubai, United Arab Emirates to other destinations. Please change your destination and try again.";

	public TransAviaBookAFlightPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void checkForFlightAvailable() {

		Assert.assertTrue(flightAvailBeads.size() > 0);

	}

	public void selectFirstOutboundAvailableFlight() {
		mySleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", firstAvailOutboundFlightTile);
		Actions myAction = new Actions(driver);
		myAction.click(firstAvailOutboundFlightTile).build().perform();
		Wait myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.elementToBeClickable(selectOutboundButton));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", selectOutboundButton);
		Actions myAction1 = new Actions(driver);
		myAction1.click(selectOutboundButton).build().perform();
		WebDriverWait myWait1 = new WebDriverWait(driver, 20);
		myWait1.until(ExpectedConditions.visibilityOf(selectedOutboundMessage));
	}

	public void selectFirstInboundAvailableFlight() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
				firstAvailInboundFlightTile);
		Actions myAction = new Actions(driver);
		myAction.click(firstAvailInboundFlightTile).build().perform();
		Wait myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.elementToBeClickable(selectInboundButton));
		mySleep(2000);
		selectInboundButton.click();
		WebDriverWait myWait1 = new WebDriverWait(driver, 20);
		myWait1.until(ExpectedConditions.visibilityOf(selectedInboundMessage));
	}

	public TransAviaGetMoreOutOfYourTripPage pressNextButton() {
		mySleep(3000);
		WebDriverWait myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.elementToBeClickable(nextButton));
		Actions myAction = new Actions(driver);
		myAction.click(nextButton).build().perform();
		return new TransAviaGetMoreOutOfYourTripPage(driver);
	}

	public void checkForNoFlightMessage() {

		Assert.assertTrue(
				noFlightFromDubaiToAgadirMessage.equals(notificationErrorMessage.getText()));

	}

}
