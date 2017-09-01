package by.epam.transavia_test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransAviaHomePage extends TransAviaPage{

	private WebDriver driver;
	By fromField = By.xpath(".//input[@id = 'routeSelection_DepartureStation-input']");
	By fromInput = By.xpath(".//input[@id = 'routeSelection_DepartureStation-input']");
	By fromEdinburg = By.xpath(".//li[text() = 'Edinburgh, United Kingdom']");
	By toField = By.xpath(".//input[@id = 'routeSelection_ArrivalStation-input']");
	By toParisOrly = By.xpath(".//li[text() = 'Paris (Orly South), France']");
	By departCalendar = By.xpath(".//span[@class = 'datepicker-trigger icon-font icon-calendar']");
	//By firstActiveDepartData = By.xpath("(.//td[@data-selectable-day = ''])[1]");
	//By firstActiveDepartData = By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[2]/a");
	By currentDayData = By.xpath(".//td[@class = 'ui-datepicker-current-day']/a");
	By returnOnCheckBox = By.id("dateSelection_IsReturnFlight");
	By whoWillBeTravelingField = By.id("booking-passengers-input");
	By searchButton = By.xpath("(.//button[@class='button button-primary'])[2]");
	By feedbackBar = By.xpath(".//div[@class='usabilla_live_button_container']");
	By whoWillBeTraveling = By.id("booking-passengers-input");
	By whoWillBeTravelingAdultsPlus = By.xpath(".//div[@class = 'selectfield adults']/div/div/div/div/button[@class = 'button button-secondary increase']");
	By whoWillBeTravelingChildenPlus = By.xpath(".//div[@class = 'selectfield children']/div/div/div/div/button[@class = 'button button-secondary increase']");
	By whoWillBeTravelingSaveButton = By.xpath(".//button[text() = 'Save']");
	By manageYourBooking = By.xpath("(.//li[@class = 'primary-navigation_item'])[3]");
	By viewYourBooking = By.xpath(".//span[@class = 'stamp icon-font icon-account']");
    
	
	public TransAviaHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void chooseFrom() {

		driver.findElement(fromField).click();
		driver.findElement(fromEdinburg).click();

	}
	
	public void chooseFrom(String selectLondon) {
		mySleep(5000);
		WebDriverWait myWait = new WebDriverWait(driver, 60);
		myWait.until(ExpectedConditions.elementToBeClickable(searchButton));
		driver.findElement(fromField).click();
		driver.findElement(fromField).sendKeys(selectLondon);
		driver.findElement(fromField).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(fromField).sendKeys(Keys.ENTER);
		
		
	}

	
	public void chooseToCountry() {
		WebDriverWait myWait = new WebDriverWait(driver, 60);
		myWait.until(ExpectedConditions.elementToBeClickable(feedbackBar));
		driver.findElement(toField).click();
		mySleep(2000);
		driver.findElement(toParisOrly).click();
	}

	public void chooseToCountry(String selectParis) {
		
		WebDriverWait myWait = new WebDriverWait(driver, 60);
		myWait.until(ExpectedConditions.elementToBeClickable(feedbackBar));
		driver.findElement(toField).click();
		
		driver.findElement(toField).sendKeys(selectParis);
		driver.findElement(toField).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(toField).sendKeys(Keys.ENTER);
		
	}

	public void chooseDepartDate() {
//		mySleep(5000);
		
		driver.findElement(departCalendar).click();
//		mySleep(5000);
		Actions myAction = new Actions(driver);
		myAction.click(driver.findElement(currentDayData)).build().perform();
	}
	


	public void uncheckReturnOn() {
		driver.findElement(returnOnCheckBox).click();
		mySleep(2000);
		
	}

	public void chooseOneAdult() {
		System.out.println(driver.findElement(whoWillBeTravelingField).getText());
		
	}

	public TransAviaBookAFlightPage pressSearchButton() {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(searchButton));
		Actions myAction = new Actions(driver);
		myAction.click(driver.findElement(searchButton)).build().perform();
		return new TransAviaBookAFlightPage(driver);
	}

	public void chooseWhoWillBeTraveling(byte adultsNumber, byte childrenNumber) {
		driver.findElement(whoWillBeTraveling).click();
		driver.findElement(whoWillBeTravelingAdultsPlus).click();
		driver.findElement(whoWillBeTravelingChildenPlus).click();
		driver.findElement(whoWillBeTravelingSaveButton).click();
		//mySleep(5000);
	}

	public TransAviaLoginPage goesToMyBooking() {
		WebDriverWait myWait = new WebDriverWait(driver, 60);
		myWait.until(ExpectedConditions.elementToBeClickable(manageYourBooking));
		driver.findElement(manageYourBooking).click();
/*		WebDriverWait myWait1 = new WebDriverWait(driver, 60);
		myWait1.until(ExpectedConditions.elementToBeClickable(viewYourBooking));
		driver.findElement(viewYourBooking).click();*/
		return new TransAviaLoginPage(driver);
	}






}
