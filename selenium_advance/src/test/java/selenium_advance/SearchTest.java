package selenium_advance;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import driverStrategy.DriverSingleton;
import page.DirectoryPage;
import page.LoginPage;
import utilities.Constants;
import utilities.FrameworkProperties;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SearchTest {

	static FrameworkProperties frameworkProperties;
	static WebDriver driver;
	static LoginPage loginPage;
	static DirectoryPage directoryPage;
	
	@BeforeClass
	public static void initializeObjects() {
		frameworkProperties=new FrameworkProperties();
		DriverSingleton.getInstance(frameworkProperties.getProperty(Constants.BROWSER));
		driver = DriverSingleton.getDriver();
		loginPage= new LoginPage();
		directoryPage=new DirectoryPage();
	}
	
	@Test
	public void testingLogin() {
		driver.get(Constants.URL);
		loginPage.setUsernameAndPasswor(frameworkProperties.getProperty(Constants.USERNAME), frameworkProperties.getProperty(Constants.PASSWORD));
		loginPage.buttonLogin();
	}
	@Test
	public void testingDirectory() {
		
	}
	
	
	@AfterClass
	public static void closeObject() {
		driver.close();
	}
	
}
