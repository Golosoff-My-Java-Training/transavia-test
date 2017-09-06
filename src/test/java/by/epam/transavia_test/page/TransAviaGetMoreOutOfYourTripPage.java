package by.epam.transavia_test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransAviaGetMoreOutOfYourTripPage extends TransAviaPage{

	@FindBy(xpath = ".//th[@data-column-number = '2']")
	private WebElement plusColumn;
	
	@FindBy(xpath = "(.//div[@class = 'panel_section-button-container']/button[@value = 'B'])[1]")
	private WebElement plusColumnSelectedButton;
	
	@FindBy(xpath = ".//div[@class = 'grand-total__price-container']/div/div/div[@class = 'back']")
	private WebElement totalAmountEuro;
	
	
	@FindBy(xpath = ".//div[@class = 'grand-total__price-container']/div/div/div[@class = 'back']/span")
	private WebElement totalAmountCent;
	
	@FindBy(xpath = ".//div[@class='usabilla_live_button_container']")
	private WebElement feedbackBar;
	
	public TransAviaGetMoreOutOfYourTripPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void plusColumnClick() {
		WebDriverWait myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.elementToBeClickable(plusColumn));
		WebDriverWait myWait1 = new WebDriverWait(driver, 20);
		myWait1.until(ExpectedConditions.elementToBeClickable(feedbackBar));
		Actions myAction = new Actions(driver);
		myAction.click(plusColumn).build().perform();
	}

	public void totalCheck() {
		mySleep(5000);
		System.out.println("Total amount " + totalAmountEuro.getText());
	}

}
