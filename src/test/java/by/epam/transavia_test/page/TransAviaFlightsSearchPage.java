package by.epam.transavia_test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.PageFactory;



public class TransAviaFlightsSearchPage extends TransAviaPage{

	@FindBy(id = "openJawRouteSelection_DepartureStationOutbound-input")
	@CacheLookup
	private WebElement inputOutboundFrom;
	
	@FindBy(id = "openJawRouteSelection_ArrivalStationOutbound-input")
	@CacheLookup
	private WebElement inputOutboundTo;
	
	@FindBy(id = "dateSelection_OutboundDate-datepicker")
	@CacheLookup
	private WebElement inputOutboundDate;

	@FindBy(id = "openJawRouteSelection_DepartureStationInbound-input")
	@CacheLookup
	private WebElement inputInboundFrom;

	@FindBy(id = "openJawRouteSelection_ArrivalStationInbound-input")
	@CacheLookup
	private WebElement inputInboundTo;

	@FindBy(id = "dateSelection_InboundDate-datepicker")
	@CacheLookup
	private WebElement inputInboundDate;

	@FindBy(xpath = ".//div[@class='usabilla_live_button_container']")
	private WebElement feedbackBar;

	@FindBy(xpath = "(.//button[@class='button button-primary'])[2]")
	private WebElement searchButton;

	@FindBy(xpath = "(.//span[text() = 'Select'])[1]")
	private WebElement outboundFlightSelectButton;

	@FindBy(xpath = ".//section[@class = 'flight inbound']//span[text() = 'Select']")
	private WebElement inboundFlightSelectButton;

	@FindBy(xpath = "(.//div[@class = 'panel flight-result active selected']/button/div[@class = 'actions']/div/span[text() = 'Selected'])[1]")
	private WebElement selectedOutboundMessage;

	@FindBy(xpath = ".//section[@class = 'flight inbound']//div[@class = 'panel flight-result active selected']/button/div[@class = 'actions']/div/span[text() = 'Selected']")
	private WebElement selectedInboundMessage;

	@FindBy(xpath = ".//div[@class = 'grand-total__price-container']/div/div/div[@class = 'back']")
	private WebElement totalAmount;

	@FindBy(xpath = ".//h2[text() = ' Inbound flight']")
	private WebElement inboundFlightsH2;





	public TransAviaFlightsSearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	public void setOutboundFrom(String selectBologna) {
		mySleep(15000);
		inputOutboundFrom.sendKeys(selectBologna);
		inputOutboundFrom.clear();
		inputOutboundFrom.sendKeys(selectBologna); // strange but it works
		inputOutboundFrom.sendKeys(Keys.ARROW_DOWN);
		inputOutboundFrom.sendKeys(Keys.ENTER);
	}


	public void setOutboundTo(String selectEindhoven) {
		inputOutboundTo.sendKeys(selectEindhoven);
		inputOutboundTo.sendKeys(Keys.ARROW_DOWN);
		inputOutboundTo.sendKeys(Keys.ENTER);
		
	}


	public void setOutboundDate(String outboundDate) {
		inputOutboundDate.clear();
		inputOutboundDate.sendKeys(outboundDate);
		inputOutboundDate.sendKeys(Keys.ARROW_DOWN);
		inputOutboundDate.sendKeys(Keys.ENTER);
	}


	public void setInboundFrom(String selectAmsterdam) {
		inputInboundFrom.sendKeys(selectAmsterdam);
		inputInboundFrom.sendKeys(Keys.ARROW_DOWN);
		inputInboundFrom.sendKeys(Keys.ENTER);
	}


	public void setInboundTo(String selectCasablanca) {
		inputInboundTo.sendKeys(selectCasablanca);
		inputInboundTo.sendKeys(Keys.ARROW_DOWN);
		inputInboundTo.sendKeys(Keys.ENTER);
		
	}


	public void setInboundDate(String inboundDate) {
		inputInboundDate.clear();
		inputInboundDate.sendKeys(inboundDate);
		inputInboundDate.sendKeys(Keys.ARROW_DOWN);
		inputInboundDate.sendKeys(Keys.ENTER);
		
	}


	public void pressSearchButon() {
		searchButton.click();
		mySleep(15000);
	}


	public void pressSelectOutboundFlight() {
		outboundFlightSelectButton.click();
		WebDriverWait myWait = new WebDriverWait(driver, 60);
		myWait.until(ExpectedConditions.visibilityOf(selectedOutboundMessage));
	}


	public void pressSelectInboundFlight() {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", inboundFlightsH2);
		
		inboundFlightSelectButton.click();
		WebDriverWait myWait = new WebDriverWait(driver, 60);
		myWait.until(ExpectedConditions.visibilityOf(selectedInboundMessage));
	}


	public void getTotalAmount() {
		mySleep(15000);
		String totalAmountString = totalAmount.getText();
		System.out.println("Total amount is: " + totalAmountString);
		Assert.assertTrue(totalAmountString.length() > 1);
	}
	

}
