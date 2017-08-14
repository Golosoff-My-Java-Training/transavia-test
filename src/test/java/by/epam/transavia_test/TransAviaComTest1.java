package by.epam.transavia_test;

import org.testng.annotations.Test;

import by.epam.transavia_test.page.TransAviaFirstPage;
import by.epam.transavia_test.page.TransAviaHomePage;

public class TransAviaComTest1 extends TestBase{
	TransAviaFirstPage transAviaFirstPage = null;
	TransAviaHomePage transAviaHomePage = null;
	
	protected String selectYourCountry = "United Kingdom";
	
	@Test
	public void wereDoYouWantToGoTest(){
		transAviaFirstPage = new TransAviaFirstPage(driver);
		transAviaHomePage = transAviaFirstPage.chooseSelectYourCountry(selectYourCountry);
		transAviaHomePage.chooseFrom();
		transAviaHomePage.chooseToCountry();
	}
}
