package by.epam.transavia_test.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransaviaHandLuggagePage extends TransAviaPage{

	@FindBy(xpath = ".//h2[text()='Video: hand luggage and Transavia']")
	private WebElement videoPageSection;
	
	public TransaviaHandLuggagePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void scrollToVideoSection() {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", videoPageSection);
		
	}

}
