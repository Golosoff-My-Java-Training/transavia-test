package by.epam.transavia_test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransAviaHomePage extends TransAviaPage{

	@FindBy(xpath = ".//input[@id = 'routeSelection_DepartureStation-input']")
	@CacheLookup
	private WebElement fromField;
	
	@FindBy(id = ".//input[@id = 'routeSelection_DepartureStation-input']")
	@CacheLookup
	private WebElement fromInput;
	
	@FindBy(xpath = ".//li[text() = 'Edinburgh, United Kingdom']")
	private WebElement fromEdinburg;
	
	@FindBy(xpath = ".//input[@id = 'routeSelection_ArrivalStation-input']")
	@CacheLookup
	private WebElement toField;
	
	@FindBy(xpath = ".//li[text() = 'Paris (Orly South), France']")
	private WebElement toParisOrly;
	
	@FindBy(xpath = ".//span[@class = 'datepicker-trigger icon-font icon-calendar']")
	private WebElement departCalendar;
	
	@FindBy(xpath = ".//td[@class = 'ui-datepicker-current-day']/a")
	private WebElement currentDayData;
	
	@FindBy(id = "dateSelection_IsReturnFlight")
	private WebElement returnOnCheckBox;
	
	@FindBy(id = "booking-passengers-input")
	private WebElement whoWillBeTravelingField;
	
	@FindBy(xpath = "(.//button[@class='button button-primary'])[2]")
	private WebElement searchButton;
		
	@FindBy(xpath = ".//div[@class='usabilla_live_button_container']")
	private WebElement feedbackBar;
		
	@FindBy(id = "booking-passengers-input")
	private WebElement whoWillBeTraveling;
	
	@FindBy(xpath = ".//div[@class = 'selectfield adults']/div/div/div/div/button[@class = 'button button-secondary increase']")
	private WebElement whoWillBeTravelingAdultsPlus;
	
	@FindBy(xpath = ".//div[@class = 'selectfield children']/div/div/div/div/button[@class = 'button button-secondary increase']")
	private WebElement whoWillBeTravelingChildenPlus;
	
	@FindBy(xpath = ".//button[text() = 'Save']")
	private WebElement whoWillBeTravelingSaveButton;
	
	@FindBy(xpath = "(.//li[@class = 'primary-navigation_item'])[3]")
	private WebElement manageYourBooking;
	
	@FindBy(xpath = ".//span[@class = 'stamp icon-font icon-account']")
	private WebElement viewYourBooking;
	
	@FindBy(linkText = "Add multiple destinations")
	private WebElement inboundFlightFromDifferentAirport;
		
	public TransAviaHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void chooseFrom() {

		fromField.click();
		fromEdinburg.click();

	}
	
	public void chooseFrom(String selectLondon) {
		mySleep(5000);
		WebDriverWait myWait = new WebDriverWait(driver, 60);
		myWait.until(ExpectedConditions.elementToBeClickable(searchButton));
		fromField.click();
		fromField.sendKeys(selectLondon);
		fromField.sendKeys(Keys.ARROW_DOWN);
		fromField.sendKeys(Keys.ENTER);
		
		
	}

	
	public void chooseToCountry() {
		WebDriverWait myWait = new WebDriverWait(driver, 60);
		myWait.until(ExpectedConditions.elementToBeClickable(feedbackBar));
		toField.click();
		mySleep(2000);
		toParisOrly.click();
	}

	public void chooseToCountry(String selectParis) {
		
		WebDriverWait myWait = new WebDriverWait(driver, 60);
		myWait.until(ExpectedConditions.elementToBeClickable(feedbackBar));
		toField.click();
		toField.sendKeys(selectParis);
		toField.sendKeys(Keys.ARROW_DOWN);
		toField.sendKeys(Keys.ENTER);
		
	}

	public void chooseDepartDate() {
		departCalendar.click();
		Actions myAction = new Actions(driver);
		myAction.click(currentDayData).build().perform();
	}
	


	public void uncheckReturnOn() {
		returnOnCheckBox.click();
		mySleep(2000);
		
	}

	public void chooseOneAdult() {
		System.out.println(whoWillBeTravelingField.getText());
		
	}

	public TransAviaBookAFlightPage pressSearchButton() {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", searchButton);
		Actions myAction = new Actions(driver);
		myAction.click(searchButton).build().perform();
		return new TransAviaBookAFlightPage(driver);
	}

	public void chooseWhoWillBeTraveling(byte adultsNumber, byte childrenNumber) {
		whoWillBeTraveling.click();
		whoWillBeTravelingAdultsPlus.click();
		whoWillBeTravelingChildenPlus.click();
		whoWillBeTravelingSaveButton.click();
	}

	public TransAviaLoginPage goesToMyBooking() {
		WebDriverWait myWait = new WebDriverWait(driver, 60);
		myWait.until(ExpectedConditions.elementToBeClickable(manageYourBooking));
		manageYourBooking.click();
		return new TransAviaLoginPage(driver);
	}

	public TransAviaFlightsSearchPage goesToDifferentDepartAirport() {
		WebDriverWait myWait1 = new WebDriverWait(driver, 60);
		myWait1.until(ExpectedConditions.elementToBeClickable(inboundFlightFromDifferentAirport));
		inboundFlightFromDifferentAirport.click();
		return new TransAviaFlightsSearchPage(driver);
	}

}
