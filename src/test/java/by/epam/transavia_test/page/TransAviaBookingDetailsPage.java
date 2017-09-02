package by.epam.transavia_test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TransAviaBookingDetailsPage {

	private WebDriver driver;
	By totalSum = By.xpath("(.//div[@class = 'front'])[1]");
	By paymentAmount = By.xpath("(.//div[@class = 'amount'])[8]");

	public TransAviaBookingDetailsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void compareTotalSumAndPaymentAmount() {
		String totalSumString = driver.findElement(totalSum).getText();
		String paymentAmountString = driver.findElement(paymentAmount).getText();
		System.out.println("Total sum is: " + totalSumString);
		System.out.println("Payment amount is: " + paymentAmountString);
		Assert.assertTrue(totalSumString.equals(paymentAmountString));
	}

}
