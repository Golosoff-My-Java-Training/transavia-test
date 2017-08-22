package by.epam.transavia_test.page;

public class TransAviaPage {

	protected void mySleep(int millisForWait) {
		try {
			
			Thread.sleep(millisForWait);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
