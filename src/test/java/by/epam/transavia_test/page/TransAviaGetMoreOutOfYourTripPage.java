package by.epam.transavia_test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransAviaGetMoreOutOfYourTripPage extends TransAviaPage{

	private WebDriver driver;
	By plusColumn = By.xpath(".//th[@data-column-number = '2']");
	By plusColumnSelectedButton = By.xpath("(.//div[@class = 'panel_section-button-container']/button[@value = 'B'])[1]");
	By totalAmountEuro = By.xpath(".//div[@class = 'grand-total__price-container']/div/div/div[@class = 'back']");
	By totalAmountCent = By.xpath(".//div[@class = 'grand-total__price-container']/div/div/div[@class = 'back']/span");
	
	public TransAviaGetMoreOutOfYourTripPage(WebDriver driver) {
		this.driver = driver;
	}

	public void plusColumnClick() {
		WebDriverWait myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.elementToBeClickable(plusColumn));
		Actions myAction = new Actions(driver);
		myAction.click(driver.findElement(plusColumn)).build().perform();
/*		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(plusColumnSelectedButton));
		WebDriverWait myWait1 = new WebDriverWait(driver, 20);
		myWait1.until(ExpectedConditions.elementToBeClickable(plusColumnSelectedButton));
		Actions myAction1 = new Actions(driver);
		myAction1.click(driver.findElement(plusColumnSelectedButton)).build().perform();
		mySleep(15000);*/
	}

	public void totalCheck() {
		System.out.println("Total amount " + driver.findElement(totalAmountEuro).getText());
		System.out.println("Total amount " + driver.findElement(totalAmountCent).getText());
		
	}

}
