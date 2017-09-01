package by.epam.transavia_test;

/*1. Появляется окно выбора маршрута "Where do you want to go?"
2. Появляется выпадающий список с названиями доступных мест для перелета в поле  "FROM"
3. Появляется выпадающий список с названием доступных мест в поле  "TO"
4. Появляется поле с каллендарным списком дней недели, месяцами и годом
5. Перевести checkbox "Where do you want to go?" в состоянии unchecked
6. Появляктся дополнительное поле для выбора количества пассажиров в поле "Who will be travelling?"

1. Появиться окно "Where do you want to go?" с полями выбора
2. Появляется название выбранного места в поле "FROM"
3. Появляется название выбранного места в поле "TO"
4. Поялкляется дата выбранного времени в поле "Depart on" в формате dd-mm-yyyy
5. Сheckbox "Return on" в состоянии unchecked
5.1 Поле "Return on" пустое
6. Появляется количество выбранных пасажиров
7. Найденн хотя бы один рейс в период от 1 до 7 дней
*/


import org.testng.annotations.Test;

import by.epam.transavia_test.page.TransAviaBookAFlightPage;
import by.epam.transavia_test.page.TransAviaBookingOverviewPage;
import by.epam.transavia_test.page.TransAviaFirstPage;
import by.epam.transavia_test.page.TransAviaGetMoreOutOfYourTripPage;
import by.epam.transavia_test.page.TransAviaHomePage;
import by.epam.transavia_test.page.TransAviaLoginPage;
import by.epam.transavia_test.page.TransAviaPage;

public class TransAviaComTest extends TestBase{
	TransAviaFirstPage transAviaFirstPage = null;
	TransAviaHomePage transAviaHomePage = null;
	TransAviaBookAFlightPage transAviaBookAFlightPage = null;
	TransAviaGetMoreOutOfYourTripPage transAviaGetMoreOutOfYourTripPage = null;
	TransAviaLoginPage transAviaLoginPage = null;
	TransAviaBookingOverviewPage transAviaBookingOverviewPage = null;
	
	protected String selectYourCountry = "United Kingdom";
	protected String selectBarcelona = "Barcelona";
	protected String selectParis = "Paris";
	protected byte adultsNumber = 2;
	protected byte childrenNumber = 1;
	protected String bookingNumber = "MF8C9R";
	protected String lastName = "kukharau";
	protected String flightDate = "9 June 2016";
	
	
	@Test(enabled = false)
	public void wereDoYouWantToGoTest(){
		transAviaFirstPage = new TransAviaFirstPage(driver);
		transAviaHomePage = transAviaFirstPage.chooseSelectYourCountry(selectYourCountry);
		transAviaHomePage.chooseFrom();
		transAviaHomePage.chooseToCountry();
		transAviaHomePage.chooseDepartDate();
		transAviaHomePage.uncheckReturnOn();
		transAviaHomePage.chooseOneAdult();
		transAviaBookAFlightPage = transAviaHomePage.pressSearchButton();
		transAviaBookAFlightPage.checkForFlightAvailable();
		
		
	}
	
	@Test(enabled = false)
	public void checkForTotal(){
		transAviaFirstPage = new TransAviaFirstPage(driver);
		transAviaHomePage = transAviaFirstPage.chooseSelectYourCountry(selectYourCountry);
		transAviaHomePage.chooseFrom(selectBarcelona);
		transAviaHomePage.chooseToCountry(selectParis);
		transAviaHomePage.chooseWhoWillBeTraveling(adultsNumber, childrenNumber);
		transAviaBookAFlightPage = transAviaHomePage.pressSearchButton();
		transAviaBookAFlightPage.selectFirstOutboundAvailableFlight();
		transAviaBookAFlightPage.selectFirstInboundAvailableFlight();
		transAviaGetMoreOutOfYourTripPage = transAviaBookAFlightPage.pressNextButton();
		transAviaGetMoreOutOfYourTripPage.plusColumnClick();
		transAviaGetMoreOutOfYourTripPage.totalCheck();
		
		
		
	}
	
	@Test(enabled = true)
	public void checkForArrivalTime(){
		transAviaFirstPage = new TransAviaFirstPage(driver);
		transAviaHomePage = transAviaFirstPage.chooseSelectYourCountry(selectYourCountry);
		transAviaLoginPage = transAviaHomePage.goesToMyBooking();
		transAviaBookingOverviewPage = transAviaLoginPage.login(bookingNumber, lastName, flightDate);
		
	}
	
}
