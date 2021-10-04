package automation.driverStrategy;
import automation.driver.Chrome;
import automation.driver.ChromeEdge;
import automation.utilities.Constants;

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
