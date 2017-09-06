package by.epam.transavia_test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TransAviaFirstPage extends TransAviaPage{

	@FindBy(xpath = ".//ul[@class = 'language-switch_list']/li[3]")
	private WebElement unitedKingdom;

	public TransAviaFirstPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public TransAviaHomePage chooseSelectYourCountry(String selectYourCountry) {
		unitedKingdom.click();
		return new TransAviaHomePage(driver);
	}

}
