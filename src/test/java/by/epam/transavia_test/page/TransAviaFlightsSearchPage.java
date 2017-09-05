package by.epam.transavia_test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class TransAviaFlightsSearchPage extends TransAviaPage{

	private WebDriver driver;
	By inputOutboundFrom = By.id("openJawRouteSelection_DepartureStationOutbound-input");
	By inputOutboundTo = By.id("openJawRouteSelection_ArrivalStationOutbound-input");
	By inputOutboundDate = By.id("dateSelection_OutboundDate-datepicker");
	By inputInboundFrom = By.id("openJawRouteSelection_DepartureStationInbound-input");
	By inputInboundTo = By.id("openJawRouteSelection_ArrivalStationInbound-input");
	By inputInboundDate = By.id("dateSelection_InboundDate-datepicker");
	By feedbackBar = By.xpath(".//div[@class='usabilla_live_button_container']");
	By searchButton = By.xpath("(.//button[@class='button button-primary'])[2]");
	By outboundFlightSelectButton = By.xpath("(.//span[text() = 'Select'])[1]");
	By inboundFlightSelectButton = By.xpath(".//section[@class = 'flight inbound']//span[text() = 'Select']");
	By selectedOutboundMessage = By.xpath("(.//div[@class = 'panel flight-result active selected']/button/div[@class = 'actions']/div/span[text() = 'Selected'])[1]");
	By selectedInboundMessage = By.xpath(".//section[@class = 'flight inbound']//div[@class = 'panel flight-result active selected']/button/div[@class = 'actions']/div/span[text() = 'Selected']");
	By totalAmount = By.xpath(".//div[@class = 'grand-total__price-container']/div/div/div[@class = 'back']");
	By inboundFlightsH2 = By.xpath(".//h2[text() = ' Inbound flight']");
	

	public TransAviaFlightsSearchPage(WebDriver driver) {
		this.driver = driver;
	}


	public void setOutboundFrom(String selectBologna) {
		/*WebDriverWait myWait = new WebDriverWait(driver, 60);
		myWait.until(ExpectedConditions.elementToBeClickable(searchButton));*/
		mySleep(15000);
		driver.findElement(inputOutboundFrom).sendKeys(selectBologna);
		driver.findElement(inputOutboundFrom).clear();
		driver.findElement(inputOutboundFrom).sendKeys(selectBologna); // strange but it works
		driver.findElement(inputOutboundFrom).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(inputOutboundFrom).sendKeys(Keys.ENTER);
	}


	public void setOutboundTo(String selectEindhoven) {
		driver.findElement(inputOutboundTo).sendKeys(selectEindhoven);
		driver.findElement(inputOutboundTo).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(inputOutboundTo).sendKeys(Keys.ENTER);
		
	}


	public void setOutboundDate(String outboundDate) {
		driver.findElement(inputOutboundDate).clear();
		driver.findElement(inputOutboundDate).sendKeys(outboundDate);
		driver.findElement(inputOutboundDate).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(inputOutboundDate).sendKeys(Keys.ENTER);
	}


	public void setInboundFrom(String selectAmsterdam) {
		driver.findElement(inputInboundFrom).sendKeys(selectAmsterdam);
		driver.findElement(inputInboundFrom).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(inputInboundFrom).sendKeys(Keys.ENTER);
	}


	public void setInboundTo(String selectCasablanca) {
		driver.findElement(inputInboundTo).sendKeys(selectCasablanca);
		driver.findElement(inputInboundTo).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(inputInboundTo).sendKeys(Keys.ENTER);
		
	}


	public void setInboundDate(String inboundDate) {
		driver.findElement(inputInboundDate).clear();
		driver.findElement(inputInboundDate).sendKeys(inboundDate);
		driver.findElement(inputInboundDate).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(inputInboundDate).sendKeys(Keys.ENTER);
		
	}


	public void pressSearchButon() {
		driver.findElement(searchButton).click();
		mySleep(15000);
	}


	public void pressSelectOutboundFlight() {
		driver.findElement(outboundFlightSelectButton).click();
		WebDriverWait myWait = new WebDriverWait(driver, 60);
		myWait.until(ExpectedConditions.visibilityOfElementLocated(selectedOutboundMessage));
	}


	public void pressSelectInboundFlight() {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(inboundFlightsH2));
		
		driver.findElement(inboundFlightSelectButton).click();
		WebDriverWait myWait = new WebDriverWait(driver, 60);
		myWait.until(ExpectedConditions.visibilityOfElementLocated(selectedInboundMessage));
	}


	public void getTotalAmount() {
		mySleep(15000);
		String totalAmountString = driver.findElement(totalAmount).getText();
		System.out.println("Total amount is: " + totalAmountString);
		Assert.assertTrue(totalAmountString.length() > 1);
	}
	

}
