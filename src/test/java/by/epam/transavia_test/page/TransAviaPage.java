package by.epam.transavia_test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TransAviaPage {
	
	protected WebDriver driver;
	

	public TransAviaPage(WebDriver driver) {
		super();
		this.driver = driver;
	}


	protected void mySleep(int millisForWait) {
		try {
			
			Thread.sleep(millisForWait);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
