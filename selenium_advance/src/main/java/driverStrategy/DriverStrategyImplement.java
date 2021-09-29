package driverStrategy;
import driver.Chrome;
import driver.ChromeEdge;
import utilities.Constants;

public class DriverStrategyImplement {

	public static DriverStrategy chooseStrategy(String strategy) {
		switch(strategy) {
		case Constants.CHROME:
			return new Chrome();
		case Constants.CHROME_EDGE:
			return new ChromeEdge();
		default:
			return null;
			
		}
	}
}
