package driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import driverStrategy.DriverStrategy;

public class ChromeEdge implements DriverStrategy{

	public WebDriver setStrategy() {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/msedgedriver.exe");
		EdgeDriver driver = new EdgeDriver();
		return driver;
		
	}
}
