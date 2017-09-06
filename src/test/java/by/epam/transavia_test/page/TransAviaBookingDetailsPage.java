package by.epam.transavia_test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TransAviaBookingDetailsPage extends TransAviaPage{

	@FindBy(xpath = "(.//div[@class = 'front'])[1]")
	private WebElement totalSum;
	
	@FindBy(xpath = "(.//div[@class = 'amount'])[8]")
	private WebElement paymentAmount;

	public TransAviaBookingDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void compareTotalSumAndPaymentAmount() {
		String totalSumString = totalSum.getText();
		String paymentAmountString = paymentAmount.getText();
		System.out.println("Total sum is: " + totalSumString);
		System.out.println("Payment amount is: " + paymentAmountString);
		Assert.assertTrue(totalSumString.equals(paymentAmountString));
	}

}
